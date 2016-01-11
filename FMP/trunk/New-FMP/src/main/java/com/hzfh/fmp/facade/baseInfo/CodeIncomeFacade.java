package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.CodeIncome;
import com.hzfh.api.baseInfo.model.query.CodeIncomeCondition;
import com.hzfh.api.baseInfo.service.CodeIncomeService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CodeIncomeFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<CodeIncome> getPagingList(CodeIncomeCondition codeIncomeCondition) {
        CodeIncomeService codeIncomeService = (CodeIncomeService) context.getBean("codeIncomeService");

        return  codeIncomeService.getPagingList(codeIncomeCondition);
    }

    public static int add(CodeIncome codeIncome){
        CodeIncomeService codeIncomeService = (CodeIncomeService) context.getBean("codeIncomeService");

        return codeIncomeService.add(codeIncome);
    }

    public static int update(CodeIncome codeIncome){
        CodeIncomeService codeIncomeService = (CodeIncomeService) context.getBean("codeIncomeService");

        return codeIncomeService.update(codeIncome);
    }

    public static List<CodeIncome> getList(){
        CodeIncomeService codeIncomeService = (CodeIncomeService) context.getBean("codeIncomeService");

        return codeIncomeService.getList();
    }

    public static CodeIncome getInfo(int id){
        CodeIncomeService codeIncomeService = (CodeIncomeService) context.getBean("codeIncomeService");

        return codeIncomeService.getInfo(id);
    }
}
