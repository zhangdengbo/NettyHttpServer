/**
 * Copyright (c) 2011 bjaxt. All Rights Reserved.
 */

package com.axt.util;

import java.security.*;

/**
 * ����: �ַ�����md5ֵ
 * ��Ȩ:	 Copyright (c) 2011
 * ��˾:	 �й�����֤ȯ
 * ����:	 �ܺ���
 * �汾:	 1.0
 * ��������: 2011-4-13
 */

public class Md5 
{
	public static String getMd5(String input)
	{
		if (null == input)
			return "";
		
		try
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(input.getBytes());
			return bytes2hex(md.digest());			
		}
		catch (Exception e)
		{
			return "";
		}
	}
	
	private static String bytes2hex(byte[] src)
	{
		byte[] dst = new byte[src.length*2];

		for (int i = 0; i < src.length; i++) 
		{
			byte c = src[i];
		
			/* ǰ4bit */
			byte upper = (byte)(((c&0xFF)) >> 4);
			if (upper < 10)
				upper = (byte)(upper + 0x30);
			else
				upper = (byte)(upper - 0x0A + 0x41);
			
			/* ��4bit */
			byte lower = (byte)(c & 0x0F);
			if (lower < 10)
				lower = (byte)(lower + 0x30);
			else
				lower = (byte)(lower - 0x0A + 0x41);
			
			dst[i*2] = upper;
			dst[i*2+1] = lower;
		}
		
		return new String(dst);
	}
}
