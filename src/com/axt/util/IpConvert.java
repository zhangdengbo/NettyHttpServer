package com.axt.util;

import java.net.InetAddress;

/**
 * Copyright (c) 2012, bjaxt
 * 
 * Java IP地址字符串与BigInteger的转换,
 * 支持IPv6
 * 
 */

public class IpConvert {

    private final static int INADDRSZ = 4;

    /**
     * 把IP地址转化为字节数组
     * @param ipAddr
     * @return byte[]
     */
    public static byte[] ipToBytesByInet(String ipAddr) {
        try {
            return InetAddress.getByName(ipAddr).getAddress();
        } catch (Exception e) {
            throw new IllegalArgumentException(ipAddr + " is invalid IP");
        }
    }

    /**
     * 把IP地址转化为int
     * @param ipAddr
     * @return int
     */
    public static byte[] ipToBytesByReg(String ipAddr) {
        byte[] ret = new byte[4];
        try {
            String[] ipArr = ipAddr.split("\\.");
            ret[0] = (byte) (Integer.parseInt(ipArr[0]) & 0xFF);
            ret[1] = (byte) (Integer.parseInt(ipArr[1]) & 0xFF);
            ret[2] = (byte) (Integer.parseInt(ipArr[2]) & 0xFF);
            ret[3] = (byte) (Integer.parseInt(ipArr[3]) & 0xFF);
            return ret;
        } catch (Exception e) {
            throw new IllegalArgumentException(ipAddr + " is invalid IP");
        }

    }

    /**
     * 字节数组转化为IP
     * @param bytes
     * @return int
     */
    public static String bytesToIp(byte[] bytes) {
        return new StringBuffer().append(bytes[0] & 0xFF).append('.').append(
                bytes[1] & 0xFF).append('.').append(bytes[2] & 0xFF)
                .append('.').append(bytes[3] & 0xFF).toString();
    }

    /**
     * 根据位运算把 byte[] -> int
     * @param bytes
     * @return int
     */
    public static long bytesToLong(byte[] bytes) {
    	long addr = bytes[3] & 0xFF;
        addr |= ((bytes[2] << 8) & 0xFF00);
        addr |= ((bytes[1] << 16) & 0xFF0000);
        addr |= ((bytes[0] << 24) & 0xFF000000);

        return addr;
    }

    /**
     * 把IP地址转化为int
     * @param ipAddr
     * @return int
     */
    public static long ipToLong(String ipAddr) {
        try {
            return bytesToLong(ipToBytesByInet(ipAddr));
        } catch (Exception e) {
            throw new IllegalArgumentException(ipAddr + " is invalid IP");
        }
    }
    
    /**
     * 把IP地址转化为long
     * @param ipAddr
     * @return long
     */
    public long ipToLong1(String ipAddr) {
    	long[] ip = new long[4];
		int position1 = ipAddr.indexOf(".");
		int position2 = ipAddr.indexOf(".",position1+1);
		int position3 = ipAddr.indexOf(".",position2+1);
		
		ip[0] = Long.parseLong(ipAddr.substring(0,position1));
		ip[1] = Long.parseLong(ipAddr.substring(position1+1,position2));
		ip[2] = Long.parseLong(ipAddr.substring(position2+1,position3));
		ip[3] = Long.parseLong(ipAddr.substring(position3+1));
		return (ip[0]<<24) + (ip[1]<<16) + (ip[2]<<8) + ip[3];
    }

    /**
     * ipInt -> byte[]
     * @param ipInt
     * @return byte[]
     */
    public static byte[] intToBytes(int ipInt) {
        byte[] ipAddr = new byte[INADDRSZ];
        ipAddr[0] = (byte) ((ipInt >>> 24) & 0xFF);
        ipAddr[1] = (byte) ((ipInt >>> 16) & 0xFF);
        ipAddr[2] = (byte) ((ipInt >>> 8) & 0xFF);
        ipAddr[3] = (byte) (ipInt & 0xFF);
        return ipAddr;
    }

    /**
     * 把int->ip地址
     * @param ipInt
     * @return String
     */
    public static String LongToIp(Long ipInt) {
        return new StringBuilder().append(((ipInt >> 24) & 0xff)).append('.')
                .append((ipInt >> 16) & 0xff).append('.').append(
                        (ipInt >> 8) & 0xff).append('.').append((ipInt & 0xff))
                .toString();
    }

    /**
     * 把192.168.1.1/24 转化为long数组范围
     * @param ipAndMask
     * @return long[]
     */
    public static long[] getIPIntScope(String ipAndMask) {

        String[] ipArr = ipAndMask.split("/");
        if (ipArr.length != 2) {
            throw new IllegalArgumentException("invalid ipAndMask with: "
                    + ipAndMask);
        }
        int netMask = Integer.valueOf(ipArr[1].trim());
        if (netMask < 0 || netMask > 31) {
            throw new IllegalArgumentException("invalid ipAndMask with: "
                    + ipAndMask);
        }
        long ipInt = IpConvert.ipToLong(ipArr[0]);
        long netIP = ipInt & (0xFFFFFFFF << (32 - netMask));
        long hostScope = (0xFFFFFFFF >>> netMask);
        return new long[] { netIP, netIP + hostScope };

    }

    /**
     * 把192.168.1.1/24 转化为IP数组范围
     * @param ipAndMask
     * @return String[]
     */
    public static String[] getIPAddrScope(String ipAndMask) {
    	long[] ipIntArr = IpConvert.getIPIntScope(ipAndMask);
        return new String[] { IpConvert.LongToIp(ipIntArr[0]),
        		IpConvert.LongToIp(ipIntArr[0]) };
    }

    /**
     * 根据IP 子网掩码（192.168.1.1 255.255.255.0）转化为IP段
     * @param ipAddr ipAddr
     * @param mask mask
     * @return int[]
     */
    public static long[] getIPIntScope(String ipAddr, String mask) {

    	long ipInt;
    	long netMaskInt = 0, ipcount = 0;
        try {
            ipInt = IpConvert.ipToLong(ipAddr);
            if (null == mask || "".equals(mask)) {
                return new long[] { ipInt, ipInt };
            }
            netMaskInt = IpConvert.ipToLong(mask);
            ipcount = IpConvert.ipToLong("255.255.255.255") - netMaskInt;
            long netIP = ipInt & netMaskInt;
            long hostScope = netIP + ipcount;
            return new long[] { netIP, hostScope };
        } catch (Exception e) {
            throw new IllegalArgumentException("invalid ip scope express  ip:"
                    + ipAddr + "  mask:" + mask);
        }

    }

    /**
     * 根据IP 子网掩码（192.168.1.1 255.255.255.0）转化为IP段
     * @param ipAddr ipAddr
     * @param mask mask
     * @return String[]
     */
    public static String[] getIPStrScope(String ipAddr, String mask) {
    	long[] ipIntArr = IpConvert.getIPIntScope(ipAddr, mask);
        return new String[] { IpConvert.LongToIp(ipIntArr[0]),
        		IpConvert.LongToIp(ipIntArr[0]) };
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String ipAddr = "192.168.8.1";

        byte[] bytearr = IpConvert.ipToBytesByInet(ipAddr);

        StringBuffer byteStr = new StringBuffer();

        for (byte b : bytearr) {
            if (byteStr.length() == 0) {
                byteStr.append(b);
            } else {
                byteStr.append("," + b);
            }
        }
        System.out.println("IP: " + ipAddr + " ByInet --> byte[]: [ " + byteStr
                + " ]");

        bytearr = IpConvert.ipToBytesByReg(ipAddr);
        byteStr = new StringBuffer();

        for (byte b : bytearr) {
            if (byteStr.length() == 0) {
                byteStr.append(b);
            } else {
                byteStr.append("," + b);
            }
        }
        System.out.println("IP: " + ipAddr + " ByReg  --> byte[]: [ " + byteStr
                + " ]");

        System.out.println("byte[]: " + byteStr + " --> IP: "
                + IpConvert.bytesToIp(bytearr));

        long ipInt = IpConvert.ipToLong(ipAddr);

        System.out.println("IP: " + ipAddr + "  --> int: " + ipInt);

        System.out.println("int: " + ipInt + " --> IP: "
                + IpConvert.LongToIp(ipInt));

        String ipAndMask = "192.168.1.1/24";

        long[] ipscope = IpConvert.getIPIntScope(ipAndMask);
        System.out.println(ipAndMask + " --> int地址段：[ " + ipscope[0] + ","
                + ipscope[1] + " ]");

        System.out.println(ipAndMask + " --> IP 地址段：[ "
                + IpConvert.LongToIp(ipscope[0]) + ","
                + IpConvert.LongToIp(ipscope[1]) + " ]");

        String ipAddr1 = "192.168.1.1", ipMask1 = "255.255.255.0";

        long[] ipscope1 = IpConvert.getIPIntScope(ipAddr1, ipMask1);
        System.out.println(ipAddr1 + " , " + ipMask1 + "  --> int地址段 ：[ "
                + ipscope1[0] + "," + ipscope1[1] + " ]");

        System.out.println(ipAddr1 + " , " + ipMask1 + "  --> IP地址段 ：[ "
                + IpConvert.LongToIp(ipscope1[0]) + ","
                + IpConvert.LongToIp(ipscope1[1]) + " ]");

    }
}