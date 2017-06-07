package com.axt.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.impl.cookie.BasicClientCookie;

public class HttpUrlConn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		String url = "http://192.168.1.251:8080/";
		
		String cookie = null;
		
		
		doPost(doGet(url,cookie));
		
		System.out.println(cookie);
		
		doThing(doPost(doGet(url,cookie)));
	
	}
	
	
	public static  String  doGet(String url,String cookie){
		
		String cookieStr = "";
		URLConnection rulConnection = null;
		HttpURLConnection httpUrlConnection = null;
		try {
			URL uRL = new URL(url);
			rulConnection = uRL.openConnection();
			httpUrlConnection = (HttpURLConnection) rulConnection;
			httpUrlConnection.setDoOutput(true);   
			httpUrlConnection.setDoInput(true);   
			httpUrlConnection.setUseCaches(false);
		//	httpUrlConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
	    	httpUrlConnection.setRequestMethod("GET");  
			httpUrlConnection.connect(); 
			OutputStream out = httpUrlConnection.getOutputStream();
			
			InputStream in= httpUrlConnection.getInputStream();
			String responseCookies = httpUrlConnection.getHeaderField("Set-Cookie");
			
			cookie = responseCookies;
			System.out.println(responseCookies);
			Buffer buffer = new Buffer();
			byte[] array = new byte[1000];
			int pos = 0;
			while((pos=in.read(array))!= -1){
				buffer.append(array, pos);
			}
			return cookie;
		} catch (IOException e) {
			
		} finally{
			if(httpUrlConnection!= null){
				httpUrlConnection.disconnect();
			}
		}
		
		return null;
	}
	
	public static  String  doPost(String cookie){
		String cookieStr = "";
		URLConnection rulConnection = null;
		HttpURLConnection httpUrlConnection = null;
		try {
			URL uRL = new URL("http://192.168.1.251:8080/login/dologin.do");
			rulConnection = uRL.openConnection();
			httpUrlConnection = (HttpURLConnection) rulConnection;
			httpUrlConnection.setDoOutput(true);   
			httpUrlConnection.setDoInput(true);   
			httpUrlConnection.setUseCaches(false);
			httpUrlConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
	    	httpUrlConnection.setRequestMethod("POST");  
	    	httpUrlConnection.setRequestProperty("Cookie", cookie);
			httpUrlConnection.connect(); 
			OutputStream out = httpUrlConnection.getOutputStream();
			out.write("username=admin&passwd=bjaxt62216225".getBytes("UTF-8"));
			InputStream in= httpUrlConnection.getInputStream();
			String responseCookies = httpUrlConnection.getHeaderField("Set-Cookie");
			System.out.println(responseCookies);
			Buffer buffer = new Buffer();
			byte[] array = new byte[1000];
			int pos = 0;
			while((pos=in.read(array))!= -1){
				buffer.append(array, pos);
			}
			return responseCookies;
		} catch (IOException e) {
			
		} finally{
			if(httpUrlConnection!= null){
				httpUrlConnection.disconnect();
			}
		}
		return null;
	}
	
	public static  String  doThing(String cookie){
		String cookieStr = "";
		URLConnection rulConnection = null;
		HttpURLConnection httpUrlConnection = null;
		try {
			URL uRL = new URL("http://192.168.1.251:8080/admin/user/userFind.do");
			rulConnection = uRL.openConnection();
			httpUrlConnection = (HttpURLConnection) rulConnection;
			httpUrlConnection.setDoOutput(true);   
			httpUrlConnection.setDoInput(true);   
			httpUrlConnection.setUseCaches(false);
			httpUrlConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
	    	httpUrlConnection.setRequestMethod("POST");  
	    	httpUrlConnection.setRequestProperty("Cookie", cookie);
			httpUrlConnection.connect(); 
			OutputStream out = httpUrlConnection.getOutputStream();
			out.write("pageNo=1".getBytes("UTF-8"));
			InputStream in= httpUrlConnection.getInputStream();
			String responseCookies = httpUrlConnection.getHeaderField("Set-Cookie");
			System.out.println(responseCookies);
			Buffer buffer = new Buffer();
			byte[] array = new byte[1000];
			int pos = 0;
			while((pos=in.read(array))!= -1){
				buffer.append(array, pos);
			}
			
			System.out.println(new String(buffer.getData()));
			
		} catch (IOException e) {
			
		} finally{
			if(httpUrlConnection!= null){
				httpUrlConnection.disconnect();
			}
		}
		return null;
	}

}
