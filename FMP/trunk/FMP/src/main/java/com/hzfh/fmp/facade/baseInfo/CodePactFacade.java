package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.CodePact;
import com.hzfh.api.baseInfo.model.query.CodePactCondition;
import com.hzfh.api.baseInfo.service.CodePactService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CodePactFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<CodePact> getPagingList(CodePactCondition codePactCondition) {
        CodePactService codePactService = (CodePactService) context.getBean("codePactService");

        return  codePactService.getPagingList(codePactCondition);
    }

    public static int add(CodePact codePact){
        CodePactService codePactService = (CodePactService) context.getBean("codePactService");

        return codePactService.add(codePact);
    }

    public static int update(CodePact codePact){
        CodePactService codePactService = (CodePactService) context.getBean("codePactService");

        return codePactService.update(codePact);
    }

    public static List<CodePact> getList(){
        CodePactService codePactService = (CodePactService) context.getBean("codePactService");

        return codePactService.getList();
    }

    public static CodePact getInfo(int id){
        CodePactService codePactService = (CodePactService) context.getBean("codePactService");

        return codePactService.getInfo(id);
    }
}
