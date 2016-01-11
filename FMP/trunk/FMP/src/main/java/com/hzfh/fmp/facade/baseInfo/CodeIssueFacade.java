package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.CodeIssue;
import com.hzfh.api.baseInfo.model.query.CodeIssueCondition;
import com.hzfh.api.baseInfo.service.CodeIssueService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CodeIssueFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<CodeIssue> getPagingList(CodeIssueCondition codeIssueCondition) {
        CodeIssueService codeIssueService = (CodeIssueService) context.getBean("codeIssueService");

        return  codeIssueService.getPagingList(codeIssueCondition);
    }

    public static int add(CodeIssue codeIssue){
        CodeIssueService codeIssueService = (CodeIssueService) context.getBean("codeIssueService");

        return codeIssueService.add(codeIssue);
    }

    public static int update(CodeIssue codeIssue){
        CodeIssueService codeIssueService = (CodeIssueService) context.getBean("codeIssueService");

        return codeIssueService.update(codeIssue);
    }

    public static List<CodeIssue> getList(){
        CodeIssueService codeIssueService = (CodeIssueService) context.getBean("codeIssueService");

        return codeIssueService.getList();
    }

    public static CodeIssue getInfo(int id){
        CodeIssueService codeIssueService = (CodeIssueService) context.getBean("codeIssueService");

        return codeIssueService.getInfo(id);
    }
}
