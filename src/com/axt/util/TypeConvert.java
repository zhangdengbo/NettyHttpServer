/**
 * Copyright (c) 2011 bjaxt. All Rights Reserved.
 */

package com.axt.util;

/**
 * 描述: 数据类型转换
 * 版权:	 Copyright (c) 2011
 * 公司:	 中国民族证券
 * 作者:	 周海建
 * 版本:	 1.0
 * 创建日期: 2011-4-13
 */

public class TypeConvert 
{
	/**
	 * 转为字符串值
	 */
	public static String toString(Object value)
	{
		return value == null ? "" : value.toString();
	}
	
	/**
	 * 转为字符串
	 */
	public static String toString(int value)
	{
		return toString(new Integer(value));
	}
	
	/**
	 * 转为字符串
	 */
	public static String toString(long value)
	{
		return toString(new Long(value));
	}
	
	/**
	 * 转为字符串
	 */
	public static String toString(float value)
	{
		return toString(new Float(value));
	}
	
	/**
	 * 转为字符串
	 */
	public static String toString(double value)
	{
		return toString(new Double(value));
	}
	
	/**
	 * 转为字符串
	 */
	public static String toString(boolean value)
	{
		return toString(new Boolean(value));
	}
	
	/**
	 * 转为整数值
	 */
	public static int toInteger(Object value)
	{
		int ret = 0;
		
		if (value == null)
			return 0;
		
		if (!(value instanceof Integer)) {
            try {
            	ret = Integer.parseInt(value.toString());
            }
            catch (Exception ex) {
            	ret = 0;
            }
        } else {
        	ret = ((Integer) value).intValue();
        }

        return ret;
	}
	
	/**
	 * 转为长整数
	 */
	public static long toLong(Object value)
	{
		long ret = 0;
		
		if (value == null)
			return 0;
		
		if (!(value instanceof Long)) {
            try {
            	ret = Long.parseLong(value.toString());
            }
            catch (Exception ex) {
            	ret = 0;
            }
        } else {
        	ret = ((Long) value).longValue();
        }

        return ret;
	}
	
	/**
	 * 转为浮点数
	 */
	public static float toFloat(Object value)
	{
		float ret = 0;
		
		if (value == null)
			return 0;
		
		if (!(value instanceof Float)) {
            try {
            	ret = Float.parseFloat(value.toString());
            }
            catch (Exception ex) {
            	ret = 0;
            }
        } else {
        	ret = ((Float) value).floatValue();
        }

        return ret;
	}
	
	/**
	 * 转为双精度值
	 */
	public static double toDouble(Object value)
	{
		double ret = 0;
		
		if (value == null)
			return 0;
		
		if (!(value instanceof Double)) {
            try {
            	ret = Double.parseDouble(value.toString());
            }
            catch (Exception ex) {
            	ret = 0;
            }
        } else {
        	ret = ((Double) value).doubleValue();
        }

        return ret;
	}
	
	/**
	 * 转为布尔值
	 */
	public static boolean toBoolean(Object value)
	{
		boolean ret = false;
		
		if (value == null)
			return false;
		
		if (!(value instanceof Boolean)) {
            try {
            	ret = Boolean.parseBoolean(value.toString());
            }
            catch (Exception ex) {
            	ret = false;
            }
        } else {
        	ret = ((Boolean) value).booleanValue();
        }

        return ret;
	}
}
