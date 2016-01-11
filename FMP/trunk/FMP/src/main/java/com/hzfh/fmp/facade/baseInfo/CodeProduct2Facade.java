package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.CodeProduct2;
import com.hzfh.api.baseInfo.model.query.CodeProduct2Condition;
import com.hzfh.api.baseInfo.service.CodeProduct2Service;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CodeProduct2Facade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<CodeProduct2> getPagingList(CodeProduct2Condition codeProduct2Condition) {
        CodeProduct2Service codeProduct2Service = (CodeProduct2Service) context.getBean("codeProduct2Service");

        return  codeProduct2Service.getPagingList(codeProduct2Condition);
    }

    public static int add(CodeProduct2 codeProduct2){
        CodeProduct2Service codeProduct2Service = (CodeProduct2Service) context.getBean("codeProduct2Service");

        return codeProduct2Service.add(codeProduct2);
    }

    public static int update(CodeProduct2 codeProduct2){
        CodeProduct2Service codeProduct2Service = (CodeProduct2Service) context.getBean("codeProduct2Service");

        return codeProduct2Service.update(codeProduct2);
    }

    public static List<CodeProduct2> getList(){
        CodeProduct2Service codeProduct2Service = (CodeProduct2Service) context.getBean("codeProduct2Service");

        return codeProduct2Service.getList();
    }

    public static CodeProduct2 getInfo(int id){
        CodeProduct2Service codeProduct2Service = (CodeProduct2Service) context.getBean("codeProduct2Service");

        return codeProduct2Service.getInfo(id);
    }
}
