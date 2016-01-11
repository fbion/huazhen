package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.CodeNeed1;
import com.hzfh.api.baseInfo.model.query.CodeNeed1Condition;
import com.hzfh.api.baseInfo.service.CodeNeed1Service;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CodeNeed1Facade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<CodeNeed1> getPagingList(CodeNeed1Condition codeNeed1Condition) {
        CodeNeed1Service codeNeed1Service = (CodeNeed1Service) context.getBean("codeNeed1Service");

        return  codeNeed1Service.getPagingList(codeNeed1Condition);
    }

    public static int add(CodeNeed1 codeNeed1){
        CodeNeed1Service codeNeed1Service = (CodeNeed1Service) context.getBean("codeNeed1Service");

        return codeNeed1Service.add(codeNeed1);
    }

    public static int update(CodeNeed1 codeNeed1){
        CodeNeed1Service codeNeed1Service = (CodeNeed1Service) context.getBean("codeNeed1Service");

        return codeNeed1Service.update(codeNeed1);
    }

    public static List<CodeNeed1> getList(){
        CodeNeed1Service codeNeed1Service = (CodeNeed1Service) context.getBean("codeNeed1Service");

        return codeNeed1Service.getList();
    }

    public static CodeNeed1 getInfo(int id){
        CodeNeed1Service codeNeed1Service = (CodeNeed1Service) context.getBean("codeNeed1Service");

        return codeNeed1Service.getInfo(id);
    }
}
