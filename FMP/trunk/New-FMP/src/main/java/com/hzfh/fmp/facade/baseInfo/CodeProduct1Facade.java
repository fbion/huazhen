package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.CodeProduct1;
import com.hzfh.api.baseInfo.model.query.CodeProduct1Condition;
import com.hzfh.api.baseInfo.service.CodeProduct1Service;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CodeProduct1Facade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<CodeProduct1> getPagingList(CodeProduct1Condition codeProduct1Condition) {
        CodeProduct1Service codeProduct1Service = (CodeProduct1Service) context.getBean("codeProduct1Service");

        return  codeProduct1Service.getPagingList(codeProduct1Condition);
    }

    public static int add(CodeProduct1 codeProduct1){
        CodeProduct1Service codeProduct1Service = (CodeProduct1Service) context.getBean("codeProduct1Service");

        return codeProduct1Service.add(codeProduct1);
    }

    public static int update(CodeProduct1 codeProduct1){
        CodeProduct1Service codeProduct1Service = (CodeProduct1Service) context.getBean("codeProduct1Service");

        return codeProduct1Service.update(codeProduct1);
    }

    public static List<CodeProduct1> getList(){
        CodeProduct1Service codeProduct1Service = (CodeProduct1Service) context.getBean("codeProduct1Service");

        return codeProduct1Service.getList();
    }

    public static CodeProduct1 getInfo(int id){
        CodeProduct1Service codeProduct1Service = (CodeProduct1Service) context.getBean("codeProduct1Service");

        return codeProduct1Service.getInfo(id);
    }
}
