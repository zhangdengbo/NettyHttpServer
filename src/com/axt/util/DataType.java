package com.axt.util;

import java.nio.charset.Charset;


public class DataType {
	
	public static final int DATA_T_NULL = 0;
	public static final int DATA_T_INT8 = 1;
	public static final int DATA_T_UINT8 = 2;
	public static final int DATA_T_INT16 = 3;
	public static final int DATA_T_UINT16 = 4;
	public static final int DATA_T_INT32 = 5;
	public static final int DATA_T_UINT32 = 6;
	public static final int DATA_T_INT64 = 7;
	public static final int DATA_T_UINT64 = 8;
	public static final int DATA_T_FLOAT = 9;
	public static final int DATA_T_DOUBLE = 10;
	public static final int DATA_T_STRING = 11;
	public static final int DATA_T_BINARY = 12;
	public static final int DATA_T_LONG_STRING = 13;
	public static final int DATA_T_LONG_BINARY = 14;
	public static final int DATA_T_DATE = 15;
	
	
	
	//int to byte
	public static byte[] intToBytes(int value)   
	{   
	    byte[] src = new byte[4];  
	    src[3] = (byte) ((value>>24) & 0xFF);  
	    src[2] = (byte) ((value>>16)& 0xFF);  
	    src[1] = (byte) ((value>>8)&0xFF);    
	    src[0] = (byte) (value & 0xFF);       
	    return src;  
	}  
	//byte to int
	public static int bytesToInt(byte[] src, int offset) {  
	    int value;    
	    value = (int) ( ((src[offset+3] & 0xFF)<<24)  
	            |((src[offset+2] & 0xFF)<<16)  
	            |((src[offset+1] & 0xFF)<<8)  
	            |(src[offset+0] & 0xFF));  
	    return value;  
	}
	//short to byte
	public static byte[] shortToBytes(short data) {  
	        byte[] bytes = new byte[2];  
	       // bytes[1] = (byte) ((data & 0xff00) >> 8);
	        //bytes[0] = (byte) (data & 0xff);  
	        
	        bytes[0] = (byte)(data &0xff);
	        bytes[1] = (byte)((data >>8) &0xff);
	        return bytes;  
	} 
	//byte to short
	public static short bytesToShort(byte[] b) {  
        short s;  
        s = (short) (((b[1] & 0xff)<<8) | (b[0] & 0xff));  
        return s;  
    } 
	//long to byte
	public static byte[] longToBytes(long data) {  
        byte[] bytes = new byte[8];  
        bytes[7] = (byte) ((data >> 56) & 0xff); 
        bytes[6] = (byte) ((data >> 48) & 0xff);  
        bytes[5] = (byte) ((data >> 40) & 0xff); 
        bytes[4] = (byte) ((data >> 32) & 0xff); 
        bytes[3] = (byte) ((data >> 24) & 0xff);  
        bytes[2] = (byte) ((data >> 16) & 0xff); 
        bytes[1] = (byte) ((data >> 8) & 0xff);  
        bytes[0] = (byte) (data & 0xff);  
        
        return bytes;  
    }  
	//byte to long
	 public static long bytesToLong(byte[] b) {  
	  
		 	long s = 0;  
	        long s0 = b[0] & 0xff; 
	        long s1 = b[1] & 0xff;  
	        long s2 = b[2] & 0xff;  
	        long s3 = b[3] & 0xff;  
	        long s4 = b[4] & 0xff; 
	        long s5 = b[5] & 0xff;  
	        long s6 = b[6] & 0xff;  
	        long s7 = b[7] & 0xff;  
	  
	        s1 <<= 8;  
	        s2 <<= 16;  
	        s3 <<= 24;  
	        s4 <<= 8 * 4;  
	        s5 <<= 8 * 5;  
	        s6 <<= 8 * 6;  
	        s7 <<= 8 * 7;  
	        s = s0 | s1 | s2 | s3 | s4 | s5 | s6 | s7;  
	        return s;  
	 }  
	 //double to byte
	  public static byte[] doubleToBytes(double data) {  
	        long intBits = Double.doubleToLongBits(data);  
	        return longToBytes(intBits);  
	  } 
	/*  public static byte[] double2Bytes(double d) {  
	        long value = Double.doubleToRawLongBits(d);  
	        byte[] byteRet = new byte[8];  
	        for (int i = 0; i < 8; i++) {  
	            byteRet[i] = (byte) ((value >> 8 * i) & 0xff);  
	        }  
	        return byteRet;  
	    }
	  public static double bytes2Double(byte[] arr) {  
	        long value = 0;  
	        for (int i = 0; i < 8; i++) {  
	            value |= ((long) (arr[i] & 0xff)) << (8 * i);  
	        }  
	        return Double.longBitsToDouble(value);  
	    }
	  */
	  
	  //byte to double
	  public static double bytesToDouble(byte[] bytes) {  
	        long l = bytesToLong(bytes);  
	       // System.out.println(l);  
	        return Double.longBitsToDouble(l);  
	  } 
	  
	  // string to byte
	  public static byte[] stringToBytes(String data) {  
		  Charset charset = Charset.forName("GBK");  
		  return data.getBytes(charset);  
	  } 
	  //byte to string
	  public static String bytesToString(byte[] bytes) {  
    	 return new String(bytes, Charset.forName("GBK")); 
	  } 
	  
	  
	  public static void main(String[] args) {
	       /* int a = 1256;
	        byte[] src = new byte[4]; 
	        src = DataType.intToBytes(a);
	        for(int i=0;i<4;i++){
	        	System.out.println(src[i]);
	        }
	        int b=0;
	        b = DataType.bytesToInt(src, 0);
	        System.out.println(b);*/
		 
		 
		 	short a = 1256;
	        byte[] src = new byte[2]; 
	        src = DataType.shortToBytes(a);
	        for(int i=0;i<2;i++){
	        	System.out.println(src[i]);
	        }
	        int b=0;
	        b = DataType.bytesToShort(src);
	        System.out.println(b);
		 
		 	/*long a = 1256234514;
	        byte[] src = new byte[8]; 
	        src = DataType.longToBytes(a);
	        for(int i=0;i<8;i++){
	        	System.out.println(src[i]);
	        }
	        long b=0;
	        b = DataType.bytesToLong(src);
	        System.out.println(b);*/
		 
		/* 
		 String a = "鐜嬮珮鏉�;
	        byte[] src = DataType.stringToBytes(a);
	        for(int i=0;i<src.length;i++){
	        	System.out.println(src[i]);
	        }
	        String b;
	        b = DataType.bytesToString(src);
	        System.out.println(b);
	        
	        */
		 
		 
		/* double a = 1.256231234;
	        byte[] src = DataType.doubleToBytes(a);
	        for(int i=0;i<src.length;i++){
	        	System.out.println(src[i]);
	        }
	        double b;
	        b = DataType.bytesToDouble(src);
	        System.out.println(b);*/
		 
	 }

	
	
}
