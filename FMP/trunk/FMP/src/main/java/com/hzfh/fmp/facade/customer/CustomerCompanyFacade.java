package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.CustomerCompany;
import com.hzfh.api.customer.model.query.CustomerCompanyCondition;
import com.hzfh.api.customer.service.CustomerCompanyService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CustomerCompanyFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<CustomerCompany> getPagingList(CustomerCompanyCondition customerCompanyCondition) {
        CustomerCompanyService customerCompanyService = (CustomerCompanyService) context.getBean("customerCompanyService");

        return  customerCompanyService.getPagingList(customerCompanyCondition);
    }
    public static List<CustomerCompany> getListForExcel(CustomerCompanyCondition customerCompanyCondition) {
        CustomerCompanyService customerCompanyService = (CustomerCompanyService) context.getBean("customerCompanyService");

        return  customerCompanyService.getListForExcel(customerCompanyCondition);
    }

    public static int add(CustomerCompany customerCompany){
        CustomerCompanyService customerCompanyService = (CustomerCompanyService) context.getBean("customerCompanyService");

        return customerCompanyService.add(customerCompany);
    }

    public static int update(CustomerCompany customerCompany){
        CustomerCompanyService customerCompanyService = (CustomerCompanyService) context.getBean("customerCompanyService");

        return customerCompanyService.update(customerCompany);
    }

    public static List<CustomerCompany> getList(){
        CustomerCompanyService customerCompanyService = (CustomerCompanyService) context.getBean("customerCompanyService");

        return customerCompanyService.getList();
    }

    public static CustomerCompany getInfo(int id){
        CustomerCompanyService customerCompanyService = (CustomerCompanyService) context.getBean("customerCompanyService");

        return customerCompanyService.getInfo(id);
    }

    public static List<CustomerCompany> getMyCustomerCompanyList(String workMateString){
        CustomerCompanyService customerCompanyService = (CustomerCompanyService) context.getBean("customerCompanyService");

        return customerCompanyService.getMyCustomerCompanyList(workMateString);
    }

	public static List<CustomerCompany> cardCheck(String cardNumber,int id) {
		CustomerCompanyService customerCompanyService = (CustomerCompanyService) context.getBean("customerCompanyService");
		return customerCompanyService.cardCheck(cardNumber,id);
	}

	public static List<CustomerCompany> getNoPagingList(CustomerCompanyCondition customerCompanyCondition) {
		CustomerCompanyService customerCompanyService = (CustomerCompanyService) context.getBean("customerCompanyService");

        return  customerCompanyService.getNoPagingList(customerCompanyCondition);
	}

	public static int updateCustomerNoById(int customerNo, int id) {
		CustomerCompanyService customerCompanyService = (CustomerCompanyService) context.getBean("customerCompanyService");

        return  customerCompanyService.updateCustomerNoById(customerNo, id);
	}

    public static int updateTradeTotalById(int id, double tradeTotal){
        CustomerCompanyService customerCompanyService = (CustomerCompanyService) context.getBean("customerCompanyService");
        return customerCompanyService.updateTradeTotalById(id, tradeTotal);
    }

    public static CustomerCompany getInfoByP2pCustomerNo(int p2pCustomerNo){
        CustomerCompanyService customerCompanyService = (CustomerCompanyService) context.getBean("customerCompanyService");
        return customerCompanyService.getInfoByP2pCustomerNo(p2pCustomerNo);
    }
}
