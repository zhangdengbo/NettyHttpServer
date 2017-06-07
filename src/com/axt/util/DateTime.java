package com.axt.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {

	/**
	 * ��ȡ��ǰʱ��
	 * 
	 * @return ����ʱ������yyyy-MM-dd HH:mm:ss
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
	 * ��ȡ��ǰʱ��
	 * 
	 * @return ���ض̸�ʽ yyyy-MM-dd
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
	 * ��ȡ��ǰʱ��
	 * 
	 * @return �����ַ������ͣ�yyyy-MM-dd HH:mm:ss
	 */
	public static String getStrDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(currentTime);
	}

	/**
	 * ��ȡ��ǰʱ��
	 * 
	 * @return �����ַ������ͣ�yyyy-MM-dd
	 */
	public static String getStrDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(currentTime);
	}

	/**
	 * ��ȡʱ�� HH:mm:ss
	 * 
	 * @return
	 */
	public static String getTimeShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		return formatter.format(currentTime);
	}

	/**
	 * ��ȡһ�����е����һ��
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
	 * ������ת�������ڣ�1334309647 2012-04-13 17:34:07
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
	 * ������ת����ʱ�䣺1334309647 17:34:07
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
	 * ������ת����ʱ�䣺1334309647 2012-04-13 17:34
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
     * ��ʱ��ת�������֣�2012-04-13 17:34:07 1334309647 
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
     * ��ʱ��ת�������֣�2012-04-13 17:34 1334309647 
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
	 * ���ַ���ת����һ����ʽ���ַ�����20120101----->>>2012��01��01��
	 * @param str
	 * @return
	 */
	public static String stringToDataString(String str){
		String year = str.substring(0, 4);
		String mount = str.substring(4,6);
		String day = str.substring(6, 8);
		return year + "��" + mount + "��" + day + "��";
	}
}
