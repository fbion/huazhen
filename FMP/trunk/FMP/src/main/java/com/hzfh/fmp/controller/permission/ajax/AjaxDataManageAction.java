package com.hzfh.fmp.controller.permission.ajax;

import com.hzfh.api.permission.model.Element;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.FlushCacheHelper;
import com.hzfh.fmp.model.common.state.StateValues;


public class AjaxDataManageAction extends JqGridBaseAction<Element> {
	private String isTest;
	public String getIsTest() {
		return isTest;
	}
	public void setIsTest(String isTest) {
		this.isTest = isTest;
	}

	@Override
	public String execute() throws Exception{
		StateValues.setIsTest(isTest);
		return SUCCESS;
	}
    
	public void controlIsTest(String isTest){
    	
    }
	
	public String flushAllCache(){
		FlushCacheHelper.flushAllCache();
		this.setErrCode("OK");
		return SUCCESS;
	}
	
	public String flushBaseInfoCache(){
		FlushCacheHelper.flushBaseInfoCache();
		this.setErrCode("OK");
		return SUCCESS;
	}
	
	public String flushCustomerCache(){
		FlushCacheHelper.flushCustomerCache();
		this.setErrCode("OK");
		return SUCCESS;
	}
	public String flushEnumListForDictionary(){
		FlushCacheHelper.flushEmployeeCache();;
		this.setErrCode("OK");
		return SUCCESS;
	}
	public String flushPermissionCache(){
		FlushCacheHelper.flushPermissionCache();
		this.setErrCode("OK");
		return SUCCESS;
	}
	public String flushProductCache(){
		FlushCacheHelper.flushProductCache();
		this.setErrCode("OK");
		return SUCCESS;
	}
	public String flushSalesCache(){
		FlushCacheHelper.flushSalesCache();
		this.setErrCode("OK");
		return SUCCESS;
	}
	/*public String flushWorkflowCache(){
		FlushCacheHelper.flushWorkflowCache();
		this.setErrCode("OK");
		return SUCCESS;
	}*/
	
	
	
	
	
	
	
	
	
}
