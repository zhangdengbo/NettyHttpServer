/**
 * Copyright (c) 2011 bjaxt. All Rights Reserved.
 */

package com.axt.util;

import java.security.*;

/**
 * 描述: 字符串的md5值
 * 版权:	 Copyright (c) 2011
 * 公司:	 中国民族证券
 * 作者:	 周海建
 * 版本:	 1.0
 * 创建日期: 2011-4-13
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
		
			/* 前4bit */
			byte upper = (byte)(((c&0xFF)) >> 4);
			if (upper < 10)
				upper = (byte)(upper + 0x30);
			else
				upper = (byte)(upper - 0x0A + 0x41);
			
			/* 后4bit */
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
