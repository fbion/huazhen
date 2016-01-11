package com.hzfh.fmp.controller.payment.callback;

import com.hzfh.api.payment.model.response.gateway.EnterpriseRegisterCallback;
import com.hzfh.fmp.controller.common.CallBackAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.UrlHelper;


public class EnterpriseRegisterCallbackAction extends CallBackAction<EnterpriseRegisterCallback> {
	private String errCode="0000";
	private String message="企业p2p用户开户成功！";
	public String getErrCode() {
		return errCode;
	}
	public String getMessage() {
		return message;
	}
	private String customerCompanyListUrl;
	
	public String getCustomerCompanyListUrl() {
		return customerCompanyListUrl;
	}
	@Override
	    public String execute() throws Exception{
			
	        this.setPageAlias(PageAlias.customerCompanyList);
	        String ret = super.execute();
	        if (!ret.equals(SUCCESS))
	            return ret;
	        customerCompanyListUrl = UrlHelper.buildCustomerSiteUrl("/customer/customerCompany/list??navSub=法人客户管理");
	        if(!verifySign()){
		    	this.errCode="0001";
		    	this.message="企业p2p用户开户失败！";
		    	return SUCCESS;
		    }
	        EnterpriseRegisterCallback enterpriseRegisterCallback=this.getResp();
	        /*if(!"1".equals(enterpriseRegisterCallback.getCode())){
	        	this.errCode="0002";
	        	this.message="企业p2p用户开户失败！";
	        }*/
	        
	        return SUCCESS;
	    }
	
}
