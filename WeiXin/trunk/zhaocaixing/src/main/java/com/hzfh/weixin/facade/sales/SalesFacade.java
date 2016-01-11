package com.hzfh.weixin.facade.sales;

import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.api.sales.service.SalesService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SalesFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-sales.xml");

    public static PagedList<Sales> getPagingList(SalesCondition salesCondition) {
        SalesService salesService = (SalesService) context.getBean("salesService");

        return  salesService.getPagingList(salesCondition);
    }

    public static int add(Sales sales){
        SalesService salesService = (SalesService) context.getBean("salesService");

        return salesService.add(sales);
    }

    public static int update(Sales sales){
        SalesService salesService = (SalesService) context.getBean("salesService");

        return salesService.update(sales);
    }

    public static List<Sales> getList(){
        SalesService salesService = (SalesService) context.getBean("salesService");

        return salesService.getList();
    }

    public static Sales getInfo(int id){
        SalesService salesService = (SalesService) context.getBean("salesService");

        return salesService.getInfo(id);
    }

	public static int updateStatus(int id, byte status) {
		 SalesService salesService = (SalesService) context.getBean("salesService");

	        return salesService.updateStatus(id,status);
	}


}
