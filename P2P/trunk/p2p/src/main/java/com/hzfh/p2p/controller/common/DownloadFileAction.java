package com.hzfh.p2p.controller.common;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.InputStream;

public class DownloadFileAction extends ActionSupport{
	//下载文件原始存放路径
	private final static String DOWNLOADFILEPATH="/upload";
	
	//文件参数变量
	private String fileName;

	//从下载文件原始存放路径读取得到文件输出流
	public InputStream getDownloadFile(){
		return ServletActionContext.getServletContext().getResourceAsStream(DOWNLOADFILEPATH+"/"+fileName);
	}
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
