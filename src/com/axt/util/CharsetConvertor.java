package com.axt.util;

import java.io.UnsupportedEncodingException;

public class CharsetConvertor {

	/**
	* �ַ�������ת����ʵ�ַ���
	* @param str   ��ת��������ַ���
	* @param newCharset Ŀ�����
	* @return
	* @throws UnsupportedEncodingException
	*/
	public static String changeCharset(String str, String newCharset)
	    throws UnsupportedEncodingException {
	   if (str != null) {
	    //��Ĭ���ַ���������ַ�����
	    byte[] bs = str.getBytes();
	    //���µ��ַ����������ַ���
	    return new String(bs, newCharset);
	   }
	   return null;
	}
	/**
	* �ַ�������ת����ʵ�ַ���
	* @param str   ��ת��������ַ���
	* @param oldCharset ԭ����
	* @param newCharset Ŀ�����
	* @return
	* @throws UnsupportedEncodingException
	*/
	public static String changeCharset(String str, String oldCharset, String newCharset)
	    throws UnsupportedEncodingException {
	   if (str != null) {
	    //�þɵ��ַ���������ַ�����������ܻ�����쳣��
	    byte[] bs = str.getBytes(oldCharset);
	    //���µ��ַ����������ַ���
	    return new String(bs, newCharset);
	   }
	   return null;
	}
}
