package com.hzfh.market.controller.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

public class CrossDomainCommon extends CommonAction {
	private  HttpServletRequest request = ServletActionContext.getRequest();  
	private  HttpServletResponse response = ServletActionContext.getResponse();
	
	private String jsoncallback;
	public String getJsoncallback() {
		return jsoncallback;
	}

	public void setJsoncallback(String jsoncallback) {
		this.jsoncallback = jsoncallback;
	}
	
	
	public  String outJson(Object object) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject jsonObject = JSONObject.fromObject(object);
        System.out.println(jsonObject);
        out.print(jsoncallback+ "(" + jsonObject + ")");
        out.close();
		return  null;
	}
}
