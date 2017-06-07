package com.axt.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClient1 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException, IOException {
		// TODO Auto-generated method stub
		
		/* String username = "13716514827"; //用户名
	  	  String md5pwd= Md5.getMd5("bjaxt62216225").toLowerCase(); // 密码
	  	  String xxzh = "51660474";  //学习证号
	  	  String cnbh = "16063";  //教练号
	  	  StringBuffer tempcookie = new StringBuffer();
	      String loginUrl = "http://api.xuechebu.com/usercenter/userinfo/login?username="+username+"&passwordmd5="+md5pwd;
		 CloseableHttpClient httpclient = HttpClients.custom().build();
		 HttpGet httpget = new HttpGet(loginUrl);
	        List<NameValuePair> params = new ArrayList<NameValuePair>();
	        params.add(new BasicNameValuePair("user_id", "testuser007"));
	        params.add(new BasicNameValuePair("pwd", "asdfg123"));
	        httpget.setEntity(new UrlEncodedFormEntity(params));
	 
	        HttpResponse response = httpclient.execute(httpget);
	        HttpEntity entity = response.getEntity();
	        // 在这里可以用Jsoup之类的工具对返回结果进行分析，以判断登录是否成功
	        String postResult = EntityUtils.toString(entity, "UTF-8");
	        // 我们这里只是简单的打印出当前Cookie值以判断登录是否成功。
	        CookieStore cookieStore = ((AbstractHttpClient) httpclient).getCookieStore();
	        List<Cookie> cookies = ((AbstractHttpClient) httpclient)
	                .getCookieStore().getCookies();
	        for (Cookie cookie : cookies)
	            System.out.println("cookie begin***\n" + cookie + "\n cookie end");
	        httpget.releaseConnection();*/
	 
	

	}

}
