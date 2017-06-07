package com.axt.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	
	
	  public static void main(String[] args) throws IOException, URISyntaxException{
		  BasicCookieStore cookieStore = new BasicCookieStore();
	      CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
	      String username = "13716514827"; //
	  	  String md5pwd= Md5.getMd5("bjaxt62216225").toLowerCase(); // 
	  	  String xxzh = "51660474";  //
	  	  String cnbh = "16063";  //
	  	  StringBuffer tempcookie = new StringBuffer();
	      String loginUrl = "http://api.xuechebu.com/usercenter/userinfo/login?username="+username+"&passwordmd5="+md5pwd;
	      try {
	    	  
	    	  { 
		    	  HttpGet httpget = new HttpGet(loginUrl);
		          CloseableHttpResponse response1 = httpclient.execute(httpget);
		          try {
		              HttpEntity entity = response1.getEntity();
		              System.out.println("Login form get: " + response1.getStatusLine());
		              EntityUtils.consume(entity);
		              System.out.println("Initial set of cookies:");
		              List<Cookie> cookies = cookieStore.getCookies();
		              
		              System.out.print(cookies.size());
		              
		              if (cookies.isEmpty()) {
		                  System.out.println("None");
		              } else {
		                  for (int i = 0; i < cookies.size(); i++) {
			                   System.out.println("- " + cookies.get(i).toString() + "\r\n");
			                   tempcookie.append(cookies.get(i).toString() + ";" );
		                     // System.out.println(cookies.get(i).getName() + ":" + cookies.get(i).getValue());
		                  }
		              }
		              
		          } finally {
		             // response1.close();
		          }
	          
	    	  }
	          
	    	  
	    	  //System.out.println(tempcookie.toString());
/*	          {
	        	  HttpGet httpget = new HttpGet("http://longquanapi.xuechebu.com/KM2/ClYyAddByMutil?cnbh=16063&xxzh=51660474&isJcsdYyMode=1&params=16063.2017-06-08.3001.");
	        	  //httpget.setHeader("cookie",tempcookie.toString());
		          CloseableHttpResponse response1 = httpclient.execute(httpget);
		          try {
		        	  
		        	  InputStream in = response1.getEntity().getContent();
		        	  
		        	  Buffer buffer = new Buffer();
		  			
		  			
		  			byte[] array = new byte[1000];
		  			
		  			int pos = 0;
		  			
		  			Buffer t = new Buffer();
		  			
		  			while((pos=in.read(array))!= -1){
		  				
		  				t.append(array, pos);
		  				
		  			}
		  			
		  			
		  			
		  		    System.out.print(new String(t.getData()));
		        	  //httpget.get
		        	  
		        	 // response1.
		              
		              
		              
		          } finally {
		              response1.close();
		          }
	        	  
	        	  
	        	  
	          }*/
	          
	          
	          
	          
	          
	          
	    	  
	    	

	         /* HttpUriRequest login = RequestBuilder.post()
	                  .setUri(new URI(loginUrl))
	                  .build();
	          CloseableHttpResponse response2 = httpclient.execute(login);
	          try {
	              HttpEntity entity = response2.getEntity();

	              System.out.println("Login form get: " + response2.getStatusLine());
	              EntityUtils.consume(entity);

	              System.out.println("Post logon cookies:");
	              List<Cookie> cookies = cookieStore.getCookies();
	              if (cookies.isEmpty()) {
	                  System.out.println("None");
	              } else {
	                  for (int i = 0; i < cookies.size(); i++) {
	                      System.out.println("- " + cookies.get(i).toString());
	                  }
	              }
	          } finally {
	              response2.close();
	          }*/
	      } finally {
	          httpclient.close();
	      }
		  
	  }
	
	
	  


}
