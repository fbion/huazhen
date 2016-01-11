package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.query.CustomerPersonalCondition;
import com.hzfh.api.customer.service.CustomerPersonalService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CustomerPersonalFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<CustomerPersonal> getPagingList(CustomerPersonalCondition customerPersonalCondition) {
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");

        return  customerPersonalService.getPagingList(customerPersonalCondition);
    }

    public static int add(CustomerPersonal customerPersonal){
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");

        return customerPersonalService.add(customerPersonal);
    }

    public static int update(CustomerPersonal customerPersonal){
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");

        return customerPersonalService.update(customerPersonal);
    }
    public static List<CustomerPersonal> getListForExcel(CustomerPersonalCondition customerPersonalCondition){
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");
        return customerPersonalService.getListForExcel(customerPersonalCondition);
    }

    public static List<CustomerPersonal> getList(){
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");

        return customerPersonalService.getList();
    }

    public static CustomerPersonal getInfo(int id){
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");

        return customerPersonalService.getInfo(id);
    }

    public static List<CustomerPersonal> getMyCustomerPersonalList(String workMateString){
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");

        return customerPersonalService.getMyCustomerPersonalList(workMateString);
    }

	public static List<CustomerPersonal> cardCheck(String cardNumber,int id,String desCardNumber) {
		CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");
		return customerPersonalService.cardCheck(cardNumber, id,desCardNumber);
	}

	public static List<CustomerPersonal> getNoPagingList(CustomerPersonalCondition customerPersonalCondition) {
		 CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");
	        return  customerPersonalService.getNoPagingList(customerPersonalCondition);
	}

    public static List<CustomerPersonal> checkCustomerPersonalByNameAndCellphone(int id,String name, String cellPhone,String desCellPhone) {
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");
        return customerPersonalService.checkCustomerPersonalByNameAndCellphone(id, name, cellPhone,desCellPhone);
    }

	public static List<CustomerPersonal> getCustomerPersonalListByManagerNo(int managerNo) {
		CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");
        return customerPersonalService.getCustomerPersonalListByManagerNo(managerNo);
	}

    public static int updateTradeTotalById(int id, double tradeTotal) {
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");
        return customerPersonalService.updateTradeTotalById(id, tradeTotal);
    }

    public static CustomerPersonal getInfoByP2pCustsomerNo(int p2pCustomerNo){
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");
        return customerPersonalService.getInfoByP2pCustsomerNo(p2pCustomerNo);
    }

}
