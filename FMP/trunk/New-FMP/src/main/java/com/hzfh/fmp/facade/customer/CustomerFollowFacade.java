package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.CustomerFollow;
import com.hzfh.api.customer.model.query.CustomerFollowCondition;
import com.hzfh.api.customer.service.CustomerFollowService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CustomerFollowFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<CustomerFollow> getPagingList(CustomerFollowCondition customerFollowCondition) {
        CustomerFollowService customerFollowService = (CustomerFollowService) context.getBean("customerFollowService");

        return  customerFollowService.getPagingList(customerFollowCondition);
    }

    public static int add(CustomerFollow customerFollow){
        CustomerFollowService customerFollowService = (CustomerFollowService) context.getBean("customerFollowService");

        return customerFollowService.add(customerFollow);
    }

    public static int update(CustomerFollow customerFollow){
        CustomerFollowService customerFollowService = (CustomerFollowService) context.getBean("customerFollowService");

        return customerFollowService.update(customerFollow);
    }

    public static List<CustomerFollow> getList(){
        CustomerFollowService customerFollowService = (CustomerFollowService) context.getBean("customerFollowService");

        return customerFollowService.getList();
    }

    public static CustomerFollow getInfo(int id){
        CustomerFollowService customerFollowService = (CustomerFollowService) context.getBean("customerFollowService");

        return customerFollowService.getInfo(id);
    }

	public static List<CustomerFollow> getCustomerFollowListLastThree(String customerFollowId) {
		CustomerFollowService customerFollowService = (CustomerFollowService) context.getBean("customerFollowService");
		return customerFollowService.getCustomerFollowListLastThree(customerFollowId);
	}
}
