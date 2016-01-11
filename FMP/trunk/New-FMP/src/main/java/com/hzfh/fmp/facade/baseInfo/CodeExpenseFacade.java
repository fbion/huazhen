package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.CodeExpense;
import com.hzfh.api.baseInfo.model.query.CodeExpenseCondition;
import com.hzfh.api.baseInfo.service.CodeExpenseService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CodeExpenseFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<CodeExpense> getPagingList(CodeExpenseCondition codeExpenseCondition) {
        CodeExpenseService codeExpenseService = (CodeExpenseService) context.getBean("codeExpenseService");

        return  codeExpenseService.getPagingList(codeExpenseCondition);
    }

    public static int add(CodeExpense codeExpense){
        CodeExpenseService codeExpenseService = (CodeExpenseService) context.getBean("codeExpenseService");

        return codeExpenseService.add(codeExpense);
    }

    public static int update(CodeExpense codeExpense){
        CodeExpenseService codeExpenseService = (CodeExpenseService) context.getBean("codeExpenseService");

        return codeExpenseService.update(codeExpense);
    }

    public static List<CodeExpense> getList(){
        CodeExpenseService codeExpenseService = (CodeExpenseService) context.getBean("codeExpenseService");

        return codeExpenseService.getList();
    }

    public static CodeExpense getInfo(int id){
        CodeExpenseService codeExpenseService = (CodeExpenseService) context.getBean("codeExpenseService");

        return codeExpenseService.getInfo(id);
    }
}
