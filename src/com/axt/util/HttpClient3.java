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
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClient3 {
	
	public static void main(String[] ag) throws ParseException, IOException{
		
		  String username = "13716514827"; //
	  	  String md5pwd= Md5.getMd5("bjaxt62216225").toLowerCase(); //
	  	  String xxzh = "51660474";  //
	  	  String cnbh = "16063";  //
	  	  String loginUrl = "http://api.xuechebu.com/usercenter/userinfo/login?username="+username+"&passwordmd5="+md5pwd;
		
        DefaultHttpClient httpclient = new DefaultHttpClient();
   
 
        // 
      
 
        HttpGet loginurl = new HttpGet(loginUrl);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("user_id", "testuser007"));
   
 
        HttpResponse response = httpclient.execute(loginurl);
        HttpEntity entity = response.getEntity();
        // 
        String postResult = EntityUtils.toString(entity, "UTF-8");
        // 
        CookieStore cookieStore = ((AbstractHttpClient) httpclient).getCookieStore();
        List<Cookie> cookies = ((AbstractHttpClient) httpclient)
                .getCookieStore().getCookies();
        for (Cookie cookie : cookies)
            System.out.println("cookie begin***\n" + cookie + "\n cookie end");
        loginurl.releaseConnection();
 
        //
       /* String memberpage = "http://www.xuechebu.com/yueche.html";
        HttpGet httpget = new HttpGet(memberpage);*/
        HttpGet httpget = new HttpGet("http://longquanapi.xuechebu.com/KM2/ClYyAddByMutil?cnbh=16063&xxzh=51660474&isJcsdYyMode=1&params=16063.2017-06-08.3001.");
        response = httpclient.execute(httpget); //
        entity = response.getEntity();
        String html = EntityUtils.toString(entity, "UTF-8");
        httpget.releaseConnection();
 
        System.out.println(html);
        
        httpclient.close();
		
		
	}

}
