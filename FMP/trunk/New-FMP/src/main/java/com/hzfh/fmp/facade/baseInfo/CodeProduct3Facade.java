package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.CodeProduct3;
import com.hzfh.api.baseInfo.model.query.CodeProduct3Condition;
import com.hzfh.api.baseInfo.service.CodeProduct3Service;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CodeProduct3Facade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<CodeProduct3> getPagingList(CodeProduct3Condition codeProduct3Condition) {
        CodeProduct3Service codeProduct3Service = (CodeProduct3Service) context.getBean("codeProduct3Service");

        return  codeProduct3Service.getPagingList(codeProduct3Condition);
    }

    public static int add(CodeProduct3 codeProduct3){
        CodeProduct3Service codeProduct3Service = (CodeProduct3Service) context.getBean("codeProduct3Service");

        return codeProduct3Service.add(codeProduct3);
    }

    public static int update(CodeProduct3 codeProduct3){
        CodeProduct3Service codeProduct3Service = (CodeProduct3Service) context.getBean("codeProduct3Service");

        return codeProduct3Service.update(codeProduct3);
    }

    public static List<CodeProduct3> getList(){
        CodeProduct3Service codeProduct3Service = (CodeProduct3Service) context.getBean("codeProduct3Service");

        return codeProduct3Service.getList();
    }

    public static CodeProduct3 getInfo(int id){
        CodeProduct3Service codeProduct3Service = (CodeProduct3Service) context.getBean("codeProduct3Service");

        return codeProduct3Service.getInfo(id);
    }
}
