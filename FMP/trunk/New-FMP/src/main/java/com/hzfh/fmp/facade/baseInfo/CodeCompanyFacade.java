package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.CodeCompany;
import com.hzfh.api.baseInfo.service.CodeCompanyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CodeCompanyFacade {

	private static ApplicationContext context =	new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

	public static int add(CodeCompany codeCompany){
		CodeCompanyService codeCompanyService = (CodeCompanyService) context.getBean("codeCompanyService");
		return codeCompanyService.add(codeCompany);
		
	}
	
	public static List<CodeCompany> getList(){
		CodeCompanyService codeCompanyService = (CodeCompanyService) context.getBean("codeCompanyService");
		return codeCompanyService.getList();
	}
	
}
