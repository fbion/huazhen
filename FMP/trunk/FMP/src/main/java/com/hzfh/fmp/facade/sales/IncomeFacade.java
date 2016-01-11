package com.hzfh.fmp.facade.sales;

import com.hzfh.api.sales.model.Income;
import com.hzfh.api.sales.model.query.IncomeCondition;
import com.hzfh.api.sales.service.IncomeService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class IncomeFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-sales.xml");

    public static PagedList<Income> getPagingList(IncomeCondition incomeCondition) {
        IncomeService incomeService = (IncomeService) context.getBean("incomeService");

        return  incomeService.getPagingList(incomeCondition);
    }

    public static int add(Income income){
        IncomeService incomeService = (IncomeService) context.getBean("incomeService");

        return incomeService.add(income);
    }

    public static int update(Income income){
        IncomeService incomeService = (IncomeService) context.getBean("incomeService");

        return incomeService.update(income);
    }

    public static List<Income> getList(){
        IncomeService incomeService = (IncomeService) context.getBean("incomeService");

        return incomeService.getList();
    }

    public static Income getInfo(int id){
        IncomeService incomeService = (IncomeService) context.getBean("incomeService");

        return incomeService.getInfo(id);
    }
}
