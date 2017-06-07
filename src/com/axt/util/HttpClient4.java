package com.axt.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClient4 {
	
	/***
	 * 
	 * 
	 * Ä£ÄâµÇÂ½
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	
	public static void doGet(CloseableHttpClient httpclient, BasicCookieStore cookieStore ) throws ClientProtocolException, IOException{
		  HttpGet httpget = new HttpGet("http://192.168.1.251:8080/");
		  //cookieStore.a
		  HttpResponse response = httpclient.execute(httpget);
		 // response.getStatusLine().
	      HttpEntity entity = response.getEntity();
	    /*  CookieStore cookieStore = ((AbstractHttpClient) httpclient).getCookieStore();
	        List<Cookie> cookies = ((AbstractHttpClient) httpclient)
	                .getCookieStore().getCookies();*/
	        for (Cookie cookie : cookieStore.getCookies()){
	            System.out.println("cookie begin***\n" + cookie + "\n cookie end");
	        }
	}
	
	
	/***
	 * 
	 * 
	 * Ä£ÄâµÇÂ½
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws URISyntaxException 
	 */
	
	public static void doPost(CloseableHttpClient httpclient, BasicCookieStore cookieStore ) throws ClientProtocolException, IOException, URISyntaxException{
		  HttpUriRequest login = RequestBuilder.post() .setUri(new URI("http://192.168.1.251:8080/login/dologin.do")) .addParameter("username", "admin") .addParameter("passwd", "bjaxt62216225").build();
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
		  }
		
		
		
	}
	
	/***
	 * 
	 * 
	 * Ä£ÄâµÇÂ½
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws URISyntaxException 
	 */
	
	public static void doThings(CloseableHttpClient httpclient, BasicCookieStore cookieStore ) throws ClientProtocolException, IOException, URISyntaxException{
		 HttpUriRequest login = RequestBuilder.post() .setUri(new URI("http://192.168.1.251:8080/admin/user/userFind.do")) .addParameter("pageNo", "1") .build();
		  CloseableHttpResponse response2 = httpclient.execute(login);
		  try {
		      HttpEntity entity = response2.getEntity();
		     // System.out.println("Login form get: " + response2.getStatusLine());
		      System.out.println(response2.getStatusLine());
		      String str =  EntityUtils.toString(entity);
		      
		      System.out.println("str:" + str);
		      EntityUtils.consume(entity);
		    //  System.out.println("Post logon cookies:");
		      
		     
		      List<Cookie> cookies = cookieStore.getCookies();
		      if (cookies.isEmpty()) {
		          //System.out.println("None");
		      } else {
		          for (int i = 0; i < cookies.size(); i++) {
		              System.out.println("- " + cookies.get(i).toString());
		          }
		      }
		  } finally {
		      response2.close();
		  }
		
		
	}
	
	
	/***
	 * 
	 * 
	 * Ä£ÄâµÇÂ½
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	
	public static void login1() throws ClientProtocolException, IOException{
		  BasicCookieStore cookieStore = new BasicCookieStore();
	      CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		  HttpGet httpget = new HttpGet("http://www.wjwylpj.com/");
		  HttpResponse response = httpclient.execute(httpget);
	      HttpEntity entity = response.getEntity();
	      for (Cookie cookie : cookieStore.getCookies()){
	            System.out.println("cookie begin***\n" + cookie + "\n cookie end");
	      }
	}

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static void main(String[] args) throws ClientProtocolException, IOException {
		BasicCookieStore cookieStore = new BasicCookieStore();
		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		
		doGet(httpclient,cookieStore);
		try {
			doPost(httpclient,cookieStore);
			doThings(httpclient,cookieStore);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(httpclient,cookieStore);
	
	}

}
