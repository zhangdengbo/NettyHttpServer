package com.axt.server;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.axt.util.HttpUtils;
import com.axt.util.MyResponse;

import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.HttpHeaders.Values;
import io.netty.handler.codec.http.cookie.ClientCookieDecoder;
import io.netty.handler.codec.http.cookie.Cookie;
import io.netty.handler.codec.http.cookie.CookieEncoder;
import io.netty.handler.codec.http.cookie.DefaultCookie;
import io.netty.handler.codec.http.cookie.ServerCookieDecoder;
import io.netty.handler.codec.http.CookieDecoder;
import io.netty.handler.codec.http.multipart.Attribute;
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.handler.codec.http.multipart.MemoryAttribute;
import io.netty.handler.codec.http.multipart.InterfaceHttpData.HttpDataType;
import io.netty.handler.codec.http.HttpRequest;

public class HttpServerInboundHandler extends ChannelInboundHandlerAdapter {

	private FullHttpRequest request;

	// private httpResponse res;

	@SuppressWarnings("deprecation")
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String format = null;
		String contentType = null;
		request = (FullHttpRequest) msg;
		String uri = request.getUri();
		
		if(uri.contains("google") || uri.contains("firefox")){
			return;
		}
		
/*		if(!uri.contains("192.168.1.251") ){
			
			return;
		}
		
		if(!uri.contains("192.168.1.251") ){
			
			return;
		}
		*/
		
if(!uri.contains("192.168.1.251") ){
			
			return;
		}
		
		/*if(!uri.contains("wjwylpj.com") ){
			
			return;
		}*/
		
		
		List<Cookie> cookies = new ArrayList<Cookie>();
		System.out.println("----------------------------------------> "	+ uri);
		if (uri.contains(".")) {
			format = uri.substring(uri.lastIndexOf(".") + 1);
		}
		StringBuffer header = new StringBuffer();
		for (Entry<String, String> entry : request.headers()) {
			header.append("HEADER: " + entry.getKey() + '='
					+ entry.getValue() + "\r\n");
		}
		// new getMethod
		StringBuffer cookieinfo = new StringBuffer();
		String value = request.headers().get("cookie");
		if (value == null) {
		
		} else {
		//	cookies = ServerCookieDecoder.STRICT.decode(value);
			
			String tempCookie[] = value.split(";");
			
			if(tempCookie != null && tempCookie.length > 0){
				
				for(int  i = 0 ;i < tempCookie.length;i++){
					
					 DefaultCookie cookie = new DefaultCookie((tempCookie[i].split("=")[0]).trim(),  ((tempCookie[i].split("=")[1]).replace(";", "")).trim());
					 
					 cookies.add(cookie);
				}
				
			}else{
				
				
			}
			
		}
		for (Cookie cookie : cookies) {
			cookieinfo.append("COOKIE: " + cookie.toString() + ",,,---" + cookie.path() + "&&&&&&&");
		}
		System.out.println("cookieinfo:" + cookieinfo.toString());
		//
		StringBuffer datainfo = new StringBuffer();
		
		Map<String,Object> parmas = new HashMap<String,Object>();
		
		String postparmas = "";
		
		if (request.getMethod().name().toLowerCase().equals("get")) {
			QueryStringDecoder decoderQuery = new QueryStringDecoder(
					request.getUri());
			Map<String, List<String>> uriAttributes = decoderQuery
					.parameters();
			for (Entry<String, List<String>> attr : uriAttributes
					.entrySet()) {
				for (String attrVal : attr.getValue()) {
					datainfo.append("data: " + attr.getKey() + '='
							+ attrVal + "\r\n");
					
					parmas.put(attr.getKey(), attrVal);
				}
			}
		} else {
			
			  ByteBuf buf = request.content();
			//  System.out.println(buf.toString(io.netty.util.CharsetUtil.UTF_8));
			  String strParmas = buf.toString(io.netty.util.CharsetUtil.UTF_8);
			  
			  postparmas = strParmas;
			  
			  String[] paramsArray = strParmas.split("&");
			  
			  if(paramsArray != null && paramsArray.length > 0){
				  
				  for(int i = 0 ;i < paramsArray.length ; i++){
					  
					  //String key  = paramsArray[i].split("=")[0];
					  
					  parmas.put(paramsArray[i].split("=")[0], paramsArray[i].split("=")[1]);
					  
				  }
				  
				  
				  
			  }
			  
			  
			  
			  
			  buf.release();
		}
		//System.out.println(datainfo.toString());

	
	/*	if (msg instanceof HttpContent) {
			HttpContent content = (HttpContent) msg;
			ByteBuf buf = content.content();
			System.out.println(buf.toString(io.netty.util.CharsetUtil.UTF_8));
			buf.release();

		}*/
		
		
		MyResponse rep = HttpUtils.getHttpMessage(uri,
				request.getMethod().name(), cookies, parmas,postparmas);
		FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK,
				Unpooled.wrappedBuffer(rep.array));

		if (format != null) {
			if ("js".equals(format.toLowerCase())) {
				contentType = "text/js";
			} else if ("css".equals(format.toLowerCase())
					|| format.toLowerCase().contains("css")) {
				contentType = "text/css";
			} else {
				contentType = "text/html";
			}
		} else {
			contentType = "text/html";
		}
		
		if(rep.cookies == null || "".equals(rep.cookies)){
			
		}else{
			
			response.headers().set("Set-Cookie", rep.cookies);
		}
		
		
		response.headers().set(CONTENT_TYPE, contentType);
		response.headers().set(CONTENT_LENGTH,
				response.content().readableBytes());
		if (HttpHeaders.isKeepAlive(request)) {
			response.headers().set(CONNECTION, Values.KEEP_ALIVE);
		}
		// CookieEncoder encoder = new CookieEncoder(true);
		ctx.write(response);
		ctx.flush();
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		// log.error(cause.getMessage());
		
		System.out.println("-----------------------------------------------------------end-------------------------------------");
		ctx.close();
	}

	/**
	 * 设置HTTP返回头信息
	 */
	private void setHeaders(FullHttpResponse response) {
		response.headers().set(HttpHeaders.Names.CONTENT_TYPE, "text/html");
		response.headers().set(HttpHeaders.Names.CONTENT_LANGUAGE,
				response.content().readableBytes());
		if (HttpHeaders.isKeepAlive(request)) {
			response.headers().set(HttpHeaders.Names.CONNECTION,
					Values.KEEP_ALIVE);
		}
	}

}
