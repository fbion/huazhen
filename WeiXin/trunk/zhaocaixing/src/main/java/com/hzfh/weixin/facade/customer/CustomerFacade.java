package com.hzfh.weixin.facade.customer;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.query.P2pCustomerCondition;
import com.hzfh.api.customer.service.CustomerPersonalService;
import com.hzfh.api.customer.service.P2pCustomerService;
import com.hzframework.contract.PagedList;

public class CustomerFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-customer.xml");

    public static PagedList<P2pCustomer> getPagingList(P2pCustomerCondition p2pCustomerCondition) {
        P2pCustomerService p2pCustomerService = (P2pCustomerService) context.getBean("p2pCustomerService");

        return  p2pCustomerService.getPagingList(p2pCustomerCondition);
    }

    public static int add(P2pCustomer p2pCustomer){
        P2pCustomerService p2pCustomerService = (P2pCustomerService) context.getBean("p2pCustomerService");

        return p2pCustomerService.add(p2pCustomer);
    }

    public static int update(P2pCustomer p2pCustomer){
        P2pCustomerService p2pCustomerService = (P2pCustomerService) context.getBean("p2pCustomerService");

        return p2pCustomerService.update(p2pCustomer);
    }

    public static List<P2pCustomer> getList(){
        P2pCustomerService p2pCustomerService = (P2pCustomerService) context.getBean("p2pCustomerService");

        return p2pCustomerService.getList();
    }

    public static P2pCustomer getInfo(int id){
        P2pCustomerService p2pCustomerService = (P2pCustomerService) context.getBean("p2pCustomerService");

        return p2pCustomerService.getInfo(id);
    }

	public static P2pCustomer selectByUserName(String userName) {
		 P2pCustomerService p2pCustomerService = (P2pCustomerService) context.getBean("p2pCustomerService");
		return p2pCustomerService.selectByUserName(userName);
	}

	public static int updateLastLoginTime(int id,Timestamp lastLoginTime) {
		 P2pCustomerService p2pCustomerService = (P2pCustomerService) context.getBean("p2pCustomerService");
		return p2pCustomerService.updateLastLoginTime(id,lastLoginTime);
	}

	public static int updatePswdById(int id, String password) {
		 P2pCustomerService p2pCustomerService = (P2pCustomerService) context.getBean("p2pCustomerService");
		return p2pCustomerService.updatePswdById(id, password);
	}

	public static String selectPswd(int id) {
		 P2pCustomerService p2pCustomerService = (P2pCustomerService) context.getBean("p2pCustomerService");
		return p2pCustomerService.selectPswd(id);
	}

	public static int updateEmpNoById(int id, int empNo) {
		 P2pCustomerService p2pCustomerService = (P2pCustomerService) context.getBean("p2pCustomerService");
		return p2pCustomerService.updateEmpNoById(id, empNo);
	}

	public static int updateStatusById(int id, byte status) {
		 P2pCustomerService p2pCustomerService = (P2pCustomerService) context.getBean("p2pCustomerService");
		return p2pCustomerService.updateStatusById(id, status);
	}

	public static P2pCustomer selectByEmail(String email) {
		 P2pCustomerService p2pCustomerService = (P2pCustomerService) context.getBean("p2pCustomerService");
		return p2pCustomerService.selectByEmail(email);
	}

	public static P2pCustomer selectByEmailAndStatus(String email, byte status) {
		 P2pCustomerService p2pCustomerService = (P2pCustomerService) context.getBean("p2pCustomerService");
		return p2pCustomerService.selectByEmailAndStatus(email, status);
	}

	public static String selectSecretKey(int id) {
		P2pCustomerService p2pCustomerService = (P2pCustomerService) context.getBean("p2pCustomerService");
		return p2pCustomerService.selectSecretKey(id);
	}

	public static CustomerPersonal getCustomerByCardNumber(String cardNumber) {
		CustomerPersonalService customerPersonalService = (CustomerPersonalService) context.getBean("customerPersonalService");
		return customerPersonalService.getCustomerByCardNumber(cardNumber);
	}
}
