/**
 * Copyright (c) 2011 bjaxt. All Rights Reserved.
 */

package com.axt.util;

/**
 * ����: ��������ת��
 * ��Ȩ:	 Copyright (c) 2011
 * ��˾:	 �й�����֤ȯ
 * ����:	 �ܺ���
 * �汾:	 1.0
 * ��������: 2011-4-13
 */

public class TypeConvert 
{
	/**
	 * תΪ�ַ���ֵ
	 */
	public static String toString(Object value)
	{
		return value == null ? "" : value.toString();
	}
	
	/**
	 * תΪ�ַ���
	 */
	public static String toString(int value)
	{
		return toString(new Integer(value));
	}
	
	/**
	 * תΪ�ַ���
	 */
	public static String toString(long value)
	{
		return toString(new Long(value));
	}
	
	/**
	 * תΪ�ַ���
	 */
	public static String toString(float value)
	{
		return toString(new Float(value));
	}
	
	/**
	 * תΪ�ַ���
	 */
	public static String toString(double value)
	{
		return toString(new Double(value));
	}
	
	/**
	 * תΪ�ַ���
	 */
	public static String toString(boolean value)
	{
		return toString(new Boolean(value));
	}
	
	/**
	 * תΪ����ֵ
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
	 * תΪ������
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
	 * תΪ������
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
	 * תΪ˫����ֵ
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
	 * תΪ����ֵ
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
