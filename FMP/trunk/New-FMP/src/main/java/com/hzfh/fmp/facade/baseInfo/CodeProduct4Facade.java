package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.CodeProduct4;
import com.hzfh.api.baseInfo.model.query.CodeProduct4Condition;
import com.hzfh.api.baseInfo.service.CodeProduct4Service;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CodeProduct4Facade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<CodeProduct4> getPagingList(CodeProduct4Condition codeProduct4Condition) {
        CodeProduct4Service codeProduct4Service = (CodeProduct4Service) context.getBean("codeProduct4Service");

        return  codeProduct4Service.getPagingList(codeProduct4Condition);
    }

    public static int add(CodeProduct4 codeProduct4){
        CodeProduct4Service codeProduct4Service = (CodeProduct4Service) context.getBean("codeProduct4Service");

        return codeProduct4Service.add(codeProduct4);
    }

    public static int update(CodeProduct4 codeProduct4){
        CodeProduct4Service codeProduct4Service = (CodeProduct4Service) context.getBean("codeProduct4Service");

        return codeProduct4Service.update(codeProduct4);
    }

    public static List<CodeProduct4> getList(){
        CodeProduct4Service codeProduct4Service = (CodeProduct4Service) context.getBean("codeProduct4Service");

        return codeProduct4Service.getList();
    }

    public static CodeProduct4 getInfo(int id){
        CodeProduct4Service codeProduct4Service = (CodeProduct4Service) context.getBean("codeProduct4Service");

        return codeProduct4Service.getInfo(id);
    }
}
