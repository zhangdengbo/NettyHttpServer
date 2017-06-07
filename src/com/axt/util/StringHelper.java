/**
 * Copyright (c) 2011 bjaxt. All Rights Reserved.
 */

package com.axt.util;

/**
 * 描述: 字符串处理
 * 版权:	 Copyright (c) 2011
 * 公司:	 中国民族证券
 * 作者:	 周海建
 * 版本:	 1.0
 * 创建日期: 2011-5-24
 */

public class StringHelper 
{
	/**
	 * 处理文件路径，将"\"全都处理成"/"
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
