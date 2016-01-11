package com.hzfh.fmp.facade.customer;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.query.P2pCustomerCondition;
import com.hzfh.api.customer.service.P2pCustomerService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class P2pCustomerFacade {
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
    public static int updateP2pCustomerById(int id,int customerNo){
        P2pCustomerService p2pCustomerService = (P2pCustomerService) context.getBean("p2pCustomerService");
        return p2pCustomerService.updateP2pCustomerById(id,customerNo);
    }

    public static P2pCustomer getP2pCustomerByCustomerNo(int custoemrNo){
        P2pCustomerService p2pCustomerService = (P2pCustomerService) context.getBean("p2pCustomerService");
        return p2pCustomerService.getP2pCustomerByCustomerNo(custoemrNo);
    }

    public static int updateDeptNoAndEmpNoById(int id,int deptNo,int empNo){
        P2pCustomerService p2pCustomerService = (P2pCustomerService) context.getBean("p2pCustomerService");
        return p2pCustomerService.updateDeptNoAndEmpNoById(id,deptNo,empNo);
    }

	public static P2pCustomer selectByUserName(String userName) {
		 P2pCustomerService p2pCustomerService = (P2pCustomerService) context.getBean("p2pCustomerService");
		return p2pCustomerService.selectByUserName(userName);
	}

    public static P2pCustomer getInfoByCellphone(String cellPhone){
        P2pCustomerService p2pCustomerService = (P2pCustomerService) context.getBean("p2pCustomerService");
        return p2pCustomerService.getInfoByCellphone(cellPhone);
    }
}
