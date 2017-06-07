package com.axt.util;

import io.netty.handler.codec.http.cookie.Cookie;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

public class HttpUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static MyResponse  getHttpMessage(String url,String method,List<Cookie> cookies,Map<String,Object> parmas,String str){
		
	String cookieStr = "";
		
		 for (Cookie cookie : cookies) {
   		// BasicClientCookie cookie1 = new BasicClientCookie(cookie.getName(),cookie.getValue());
   	      
   	      if("".equals(cookieStr)){
   	    	 cookieStr  = cookie.name()+ "=" + cookie.value();
   	      }else{
   	    	 cookieStr  = ";" + cookie.name()+ "=" + cookie.value();
   	      }
   	      //cookieStore.addCookie(cookie1);
   	      //System.out.println("cookieStr:" + cookieStr);
   	  }
		
		
		URLConnection rulConnection = null;
		HttpURLConnection httpUrlConnection = null;
		try {
			URL uRL = new URL(url);
			
			rulConnection = uRL.openConnection();
			httpUrlConnection = (HttpURLConnection) rulConnection;
			httpUrlConnection.setDoOutput(true);   
			httpUrlConnection.setDoInput(true);   
			httpUrlConnection.setUseCaches(false);
			httpUrlConnection.setRequestMethod(method.toUpperCase());
			
			if(method.toUpperCase().equals("POST")){
				httpUrlConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			}else{
				//httpUrlConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			}
			
			
			httpUrlConnection.setRequestMethod(method);  
			httpUrlConnection.setRequestProperty("Cookie", cookieStr);
			
		//	httpUrlConnection.setRequestProperty("Cookie", value)
			
			httpUrlConnection.connect(); 
			OutputStream out = httpUrlConnection.getOutputStream();
			out.write(str.getBytes("UTF-8"));
			//httpUrlConnection.set
			InputStream in= httpUrlConnection.getInputStream();
			
			String resCookes = httpUrlConnection.getHeaderField("Set-Cookie");
			
			System.out.println("resCookes:" + resCookes);
			
			//str = resCookes;
			
		
			
			Buffer buffer = new Buffer();
			
			
			byte[] array = new byte[1000];
			
			int pos = 0;
			
			while((pos=in.read(array))!= -1){
				
				buffer.append(array, pos);
				
			}
			
			MyResponse rep = new MyResponse();
			
			rep.array = buffer.getData();
			
			/*if(cookieStr != null && !"".equals(cookieStr)){
				rep.cookies = cookieStr;
			}else{
				rep.cookies = resCookes;
			}*/
			
			rep.cookies = resCookes;
			
			
			return rep;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} finally{
			
			if(httpUrlConnection!= null){
				
				httpUrlConnection.disconnect();
			}
			
		}
		
		
		return  null;
		
		
	}
	
	
	/*public static byte[]  getRealHttpContent(String url,String method,Set<Cookie> cookies,Map<String,Object> parmas) throws IOException, URISyntaxException{
		
		  BasicCookieStore cookieStore = new BasicCookieStore();
	      CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		 
	      if("get".equals(method.toLowerCase())){
	    	  HttpGet httpget = new HttpGet(url);
	    	  for (io.netty.handler.codec.http.Cookie cookie : cookies) {
	    		  BasicClientCookie cookie1 = new BasicClientCookie(cookie.getName(),cookie.getValue());
	    	      cookie1.setDomain(cookie.getDomain());
	    	      cookie1.setExpiryDate(new Date(cookie.getMaxAge()));
	    	      cookie1.setSecure(cookie.isSecure());
	    	      cookie1.setPath(cookie.getPath());
	    	      cookie1.setVersion(cookie.getVersion());
	    	      cookieStore.addCookie(cookie1);
	    	  }
	    	  CloseableHttpResponse response = httpclient.execute(httpget);
	    	  HttpEntity entity = response.getEntity();
              System.out.println("Login form get: " + response.getStatusLine());
              EntityUtils.consume(entity);
              System.out.println("Initial set of cookies:");
              List<Cookie> rcookies = cookieStore.getCookies();
              if (cookies.isEmpty()) {
                  System.out.println("None");
              } else {
                  for (int i = 0; i < rcookies.size(); i++) {
                      System.out.println(rcookies.get(i).getName() + ":" + rcookies.get(i).getValue());
                  }
              }
          	  InputStream in = entity.getContent();
          	  Buffer buffer = new Buffer();
			  byte[] array = new byte[1000];
			  int pos = 0;
			  while((pos=in.read(array))!= -1){
				buffer.append(array, pos);
			  }
			  return buffer.getData();
	      }else{
	    	  HttpUriRequest login = RequestBuilder.post().setUri(new URI(url))
           
              .addParameter("IDToken1", "username")
              .addParameter("IDToken2", "password")
             
              .build();
		      CloseableHttpResponse response2 = httpclient.execute(login);
		      try {
		          HttpEntity entity = response2.getEntity();
		
		          System.out.println("Login form get: " + response2.getStatusLine());
		          EntityUtils.consume(entity);
		
		          System.out.println("Post logon cookies:");
		          List<Cookie> rcookies = cookieStore.getCookies();
		          if (rcookies.isEmpty()) {
		              System.out.println("None");
		          } else {
		              for (int i = 0; i < cookies.size(); i++) {
		                  System.out.println("- " + rcookies.get(i).toString());
		              }
		          }
		      } finally {
		          response2.close();
		      }
	      }
		return  null;
		
		
	}*/
	
	

}
