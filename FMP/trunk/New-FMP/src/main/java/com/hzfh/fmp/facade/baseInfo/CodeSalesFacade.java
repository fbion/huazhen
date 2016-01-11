package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.CodeSales;
import com.hzfh.api.baseInfo.model.query.CodeSalesCondition;
import com.hzfh.api.baseInfo.service.CodeSalesService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CodeSalesFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<CodeSales> getPagingList(CodeSalesCondition codeSalesCondition) {
        CodeSalesService codeSalesService = (CodeSalesService) context.getBean("codeSalesService");

        return  codeSalesService.getPagingList(codeSalesCondition);
    }

    public static int add(CodeSales codeSales){
        CodeSalesService codeSalesService = (CodeSalesService) context.getBean("codeSalesService");

        return codeSalesService.add(codeSales);
    }

    public static int update(CodeSales codeSales){
        CodeSalesService codeSalesService = (CodeSalesService) context.getBean("codeSalesService");

        return codeSalesService.update(codeSales);
    }

    public static List<CodeSales> getList(){
        CodeSalesService codeSalesService = (CodeSalesService) context.getBean("codeSalesService");

        return codeSalesService.getList();
    }

    public static CodeSales getInfo(int id){
        CodeSalesService codeSalesService = (CodeSalesService) context.getBean("codeSalesService");

        return codeSalesService.getInfo(id);
    }
}
