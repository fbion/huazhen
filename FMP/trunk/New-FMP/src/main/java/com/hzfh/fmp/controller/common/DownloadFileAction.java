package com.hzfh.fmp.controller.common;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.InputStream;

public class DownloadFileAction extends ActionSupport{
	
	private final static String DOWNLOADFILEPATH="/upload";
	
	
	private String fileName;

	
	public InputStream getDownloadFile(){
		return ServletActionContext.getServletContext().getResourceAsStream(DOWNLOADFILEPATH+"/"+fileName);
	}
	
	@Override
	public String execute() throws Exception{
		return SUCCESS;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
