package cn.itcast.common.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import sun.net.www.content.text.plain;

/*
 *专门处理异步返回的各种格式的工具类
 * xml
 * json
 * text
 */
public class ResponseUtils {
	public static void render(HttpServletResponse response,String contentType,String text){
		response.setContentType(contentType);
		try {
			response.getWriter().write(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//发送的是json
	public static void renderJson(HttpServletResponse response,String text) {
		render(response, "application/json;charset=UTF-8", text);
	}
	//发送的是xml
	public static void renderXml(HttpServletResponse response,String text) {
		render(response, "text/xml;charset=UTF-8", text);
	}
	//发送text
	public static void renderText(HttpServletResponse response,String text){
		render(response, "text/plain;charset=UTF-8", text);
	}
}
