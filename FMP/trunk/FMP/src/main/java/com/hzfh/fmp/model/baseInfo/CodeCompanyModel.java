package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.CodeCompany;
import com.hzfh.fmp.facade.baseInfo.CodeCompanyFacade;

public class CodeCompanyModel {

	
	public static int getCode(){
		return CodeCompanyFacade.add(new CodeCompany());
		
	}
	




}
