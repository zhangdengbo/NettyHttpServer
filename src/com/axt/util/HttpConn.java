package com.axt.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

public class HttpConn {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		HttpURLConnection httpUrlConnection =  getUrlConnection("http://192.168.1.251:8080/"); 
		
		httpUrlConnection.setRequestMethod("GET");  
		httpUrlConnection.connect(); 
		OutputStream out = httpUrlConnection.getOutputStream();
		
		InputStream in= httpUrlConnection.getInputStream();
		String responseCookies = httpUrlConnection.getHeaderField("Set-Cookie");
		System.out.println("1:" + responseCookies);
		// TODO Auto-generated method stub
		
		
		///httpUrlConnection.set

	}
	
	public static HttpURLConnection getUrlConnection(String urlName){
		
		URLConnection rulConnection = null;
		HttpURLConnection httpUrlConnection = null;
		try {
			 URL realUrl = new URL(urlName);  
			 
			// URLConnection.set
			rulConnection = realUrl.openConnection();
			
		
			
			httpUrlConnection = (HttpURLConnection) rulConnection;
			httpUrlConnection.setDoOutput(true);   
			httpUrlConnection.setDoInput(true);   
			httpUrlConnection.setUseCaches(false);
			
			
	    
			return httpUrlConnection;
		} catch (IOException e) {
			return null;
		} 
		
	}
	
	

}
