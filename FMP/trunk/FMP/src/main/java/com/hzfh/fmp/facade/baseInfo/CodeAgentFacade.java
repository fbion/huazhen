package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.CodeAgent;
import com.hzfh.api.baseInfo.model.query.CodeAgentCondition;
import com.hzfh.api.baseInfo.service.CodeAgentService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CodeAgentFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<CodeAgent> getPagingList(CodeAgentCondition codeAgentCondition) {
        CodeAgentService codeAgentService = (CodeAgentService) context.getBean("codeAgentService");

        return  codeAgentService.getPagingList(codeAgentCondition);
    }

    public static int add(CodeAgent codeAgent){
        CodeAgentService codeAgentService = (CodeAgentService) context.getBean("codeAgentService");

        return codeAgentService.add(codeAgent);
    }

    public static int update(CodeAgent codeAgent){
        CodeAgentService codeAgentService = (CodeAgentService) context.getBean("codeAgentService");

        return codeAgentService.update(codeAgent);
    }

    public static List<CodeAgent> getList(){
        CodeAgentService codeAgentService = (CodeAgentService) context.getBean("codeAgentService");

        return codeAgentService.getList();
    }

    public static CodeAgent getInfo(int id){
        CodeAgentService codeAgentService = (CodeAgentService) context.getBean("codeAgentService");

        return codeAgentService.getInfo(id);
    }
}
