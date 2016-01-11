package com.hzfh.fmp.controller.letter.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.baseInfo.model.Email;
import com.hzfh.api.baseInfo.model.EmailFiles;
import com.hzfh.api.customer.model.AgentBusiness;
import com.hzfh.api.product.model.ProductAttachment;
import com.hzfh.fmp.controller.common.BaseAction;
import com.hzfh.fmp.model.baseInfo.EmailFilesModel;
import com.hzfh.fmp.model.baseInfo.EmailModel;
import com.hzfh.fmp.model.common.helper.MailHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.AgentBusinessModel;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;

public class SendLetterForAgentBusinessAction extends BaseAction {
	
	
	private List<AgentBusiness> agentBusinessList;
	private List<ProductAttachment> checkedfiles;
	private String tempSting;
	private String emailTheme;
	private String emailContext;
	private String emailTo;
	private String msg;
	
	
	
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getTempSting() {
		return tempSting;
	}


	public void setTempSting(String tempSting) {
		this.tempSting = tempSting;
	}


	public String getMsg() {
		return msg;
	}
	

	public void setCheckedfiles(String checkedfiles) {
		List<ProductAttachment> productAttachments = new ArrayList<ProductAttachment>();
		for (int i = 0; i < JSON.parseArray(checkedfiles).size(); i++) {
			JSON json= (JSON) JSON.toJSON(JSON.parseArray(checkedfiles).get(i));
			ProductAttachment productAttachment = JSON.toJavaObject(json, ProductAttachment.class);
			productAttachments.add(productAttachment);
		} 
		this.checkedfiles = productAttachments;
	}



	public void setEmailTheme(String emailTheme) {
		this.emailTheme = emailTheme;
	}
	public void setEmailContext(String emailContext) {
		this.emailContext = emailContext;
	}
	public List<AgentBusiness> getAgentBusinessList() {
		return agentBusinessList;
	}

	@Override
	public String execute() throws Exception {
		List<AgentBusiness> tempList = AgentBusinessModel.getAgentBusinessListByManageNo(UserHelper.getUserCache().getUserId());
		if (tempList!=null&&tempList.size()>0) {
			agentBusinessList =	tempList;
		}
		return SUCCESS;
	}
	
	
	public String sendLetterGo(){
		Email email = new Email();
		if (!StringHelper.isNullOrEmpty(this.emailTheme)) {
			email.setSubject(this.emailTheme);
		}
		if (!StringHelper.isNullOrEmpty(this.emailContext)) {
			email.setBody(this.emailContext);
		}
		if (!StringHelper.isNullOrEmpty(this.emailTo)) {
			email.setTo(this.emailTo);
		}

        
		email.setHost(MailHelper.MAIL_HOST);
        email.setUser(MailHelper.MAIL_USER);
        email.setPassword(MailHelper.MAIL_PASS);
        email.setSuffix(MailHelper.MAIL_POSTFIX);
        email.setInUserNo(UserHelper.getUserCache().getUserId());
        email.setStatus((byte)0);
        
        String e = UserHelper.getUserCache().getEmpEmail();
        if (!StringHelper.isNullOrEmpty(e)) {
			String[] arry = e.split("@");
			String temp = arry[0];
			email.setFromName(temp);
			String n = UserHelper.getUserCache().getEmpName();
	        email.setSenderName(n);//MailHelper.MAIL_SENDER_NAME
		}else{
			email.setSenderName(MailHelper.MAIL_SENDER_NAME);
		}
        
		int resultId = EmailModel.add(email);
		int resultAdd =0;
		if (this.checkedfiles!=null&&this.checkedfiles.size()>0) {
			for (ProductAttachment item : checkedfiles) {
				EmailFiles emailFiles = new EmailFiles();
				emailFiles.setFileName(item.getName());
				emailFiles.setFileUrl(item.getPath());
				emailFiles.setEmailNo(resultId);
				resultAdd = EmailFilesModel.add(emailFiles);
			}
		}
		if (resultId>0&&resultAdd>0) {
			this.msg="发送成功！";
		}else{
			this.msg="发送失败！";
		}
		
		return SUCCESS;
	}
	
	
	
	
}
