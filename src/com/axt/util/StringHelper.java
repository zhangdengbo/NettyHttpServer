/**
 * Copyright (c) 2011 bjaxt. All Rights Reserved.
 */

package com.axt.util;

/**
 * ����: �ַ�������
 * ��Ȩ:	 Copyright (c) 2011
 * ��˾:	 �й�����֤ȯ
 * ����:	 �ܺ���
 * �汾:	 1.0
 * ��������: 2011-5-24
 */

public class StringHelper 
{
	/**
	 * �����ļ�·������"\"ȫ�������"/"
	 */
	public static String trimFilePath(String path)
	{
		path = path.replace('\\', '/');
		while (path.contains("//"))
			path = path.replace("//", "/");
		if (path.endsWith("/"))
			path = path.substring(0, path.length()-1);
		
		return path;
	}
}
