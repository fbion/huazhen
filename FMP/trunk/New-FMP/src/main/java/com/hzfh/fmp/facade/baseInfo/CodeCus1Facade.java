package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.CodeCus1;
import com.hzfh.api.baseInfo.model.query.CodeCus1Condition;
import com.hzfh.api.baseInfo.service.CodeCus1Service;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CodeCus1Facade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<CodeCus1> getPagingList(CodeCus1Condition codeCus1Condition) {
        CodeCus1Service codeCus1Service = (CodeCus1Service) context.getBean("codeCus1Service");

        return  codeCus1Service.getPagingList(codeCus1Condition);
    }

    public static int add(CodeCus1 codeCus1){
        CodeCus1Service codeCus1Service = (CodeCus1Service) context.getBean("codeCus1Service");

        return codeCus1Service.add(codeCus1);
    }

    public static int update(CodeCus1 codeCus1){
        CodeCus1Service codeCus1Service = (CodeCus1Service) context.getBean("codeCus1Service");

        return codeCus1Service.update(codeCus1);
    }

    public static List<CodeCus1> getList(){
        CodeCus1Service codeCus1Service = (CodeCus1Service) context.getBean("codeCus1Service");

        return codeCus1Service.getList();
    }

    public static CodeCus1 getInfo(int id){
        CodeCus1Service codeCus1Service = (CodeCus1Service) context.getBean("codeCus1Service");

        return codeCus1Service.getInfo(id);
    }
}
