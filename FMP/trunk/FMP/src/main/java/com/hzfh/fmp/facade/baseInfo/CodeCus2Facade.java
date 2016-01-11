package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.CodeCus2;
import com.hzfh.api.baseInfo.model.query.CodeCus2Condition;
import com.hzfh.api.baseInfo.service.CodeCus2Service;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CodeCus2Facade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<CodeCus2> getPagingList(CodeCus2Condition codeCus2Condition) {
        CodeCus2Service codeCus2Service = (CodeCus2Service) context.getBean("codeCus2Service");

        return  codeCus2Service.getPagingList(codeCus2Condition);
    }

    public static int add(CodeCus2 codeCus2){
        CodeCus2Service codeCus2Service = (CodeCus2Service) context.getBean("codeCus2Service");

        return codeCus2Service.add(codeCus2);
    }

    public static int update(CodeCus2 codeCus2){
        CodeCus2Service codeCus2Service = (CodeCus2Service) context.getBean("codeCus2Service");

        return codeCus2Service.update(codeCus2);
    }

    public static List<CodeCus2> getList(){
        CodeCus2Service codeCus2Service = (CodeCus2Service) context.getBean("codeCus2Service");

        return codeCus2Service.getList();
    }

    public static CodeCus2 getInfo(int id){
        CodeCus2Service codeCus2Service = (CodeCus2Service) context.getBean("codeCus2Service");

        return codeCus2Service.getInfo(id);
    }
}
