package com.axt.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {

	/**
	 * 获取当前时间
	 * 
	 * @return 返回时间类型yyyy-MM-dd HH:mm:ss
	 */
	public static Date getNowDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	/**
	 * 获取当前时间
	 * 
	 * @return 返回短格式 yyyy-MM-dd
	 */
	public static Date getNowDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	/**
	 * 获取当前时间
	 * 
	 * @return 返回字符串类型：yyyy-MM-dd HH:mm:ss
	 */
	public static String getStrDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(currentTime);
	}

	/**
	 * 获取当前时间
	 * 
	 * @return 返回字符串类型：yyyy-MM-dd
	 */
	public static String getStrDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(currentTime);
	}

	/**
	 * 获取时间 HH:mm:ss
	 * 
	 * @return
	 */
	public static String getTimeShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		return formatter.format(currentTime);
	}

	/**
	 * 提取一个月中的最后一天
	 * 
	 * @param day
	 * @return
	 */
	public static Date getLastDate(long day) {
		Date date = new Date();
		long date_3_hm = date.getTime() - 3600000 * 34 * day;
		Date date_3_hm_dateDate = new Date(date_3_hm);
		return date_3_hm_dateDate;
	}

	/**
	 * 把数字转换成日期：1334309647 2012-04-13 17:34:07
	 * 
	 * @param AValue
	 * @return
	 */
	public static String UnixToStr(String AValue) {
		Long timestamp = Long.parseLong(AValue) * 1000;
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(
				timestamp));
	}
	
	/**
	 * 把数字转换成时间：1334309647 17:34:07
	 * 
	 * @param AValue
	 * @return
	 */
	public static String UnixToShortStr(String AValue) {
		Long timestamp = Long.parseLong(AValue) * 1000;
		return new SimpleDateFormat("HH:mm:ss").format(new Date(
				timestamp));
	}
	
	/**
	 * 把数字转换成时间：1334309647 2012-04-13 17:34
	 * 
	 * @param AValue
	 * @return
	 */
	public static String UnixToShortStr1(String AValue) {
		Long timestamp = Long.parseLong(AValue) * 1000;
		return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(
				timestamp));
	}
    /**
     * 把时间转换成数字：2012-04-13 17:34:07 1334309647 
     * @param AValue
     * @return
     * @throws java.text.ParseException
     */
	public static long UnixTimestamp(String AValue)
			throws java.text.ParseException {
		long lRetVal = 0;
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(AValue);
		lRetVal = date.getTime() / 1000;
		return lRetVal;
	}
	
	/**
     * 把时间转换成数字：2012-04-13 17:34 1334309647 
     * @param AValue
     * @return
     * @throws java.text.ParseException
     */
	public static long UnixTimestamp1(String AValue)
			throws java.text.ParseException {
		long lRetVal = 0;
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(AValue);
		lRetVal = date.getTime() / 1000;
		return lRetVal;
	}
	
	/**
	 * 把字符串转换成一定格式的字符串：20120101----->>>2012年01月01日
	 * @param str
	 * @return
	 */
	public static String stringToDataString(String str){
		String year = str.substring(0, 4);
		String mount = str.substring(4,6);
		String day = str.substring(6, 8);
		return year + "年" + mount + "月" + day + "日";
	}
}
