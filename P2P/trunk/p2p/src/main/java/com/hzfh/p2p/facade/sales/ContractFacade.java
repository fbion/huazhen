package com.hzfh.p2p.facade.sales;

import com.hzfh.api.sales.model.Contract;
import com.hzfh.api.sales.model.query.ContractCondition;
import com.hzfh.api.sales.service.ContractService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ContractFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-sales.xml");

    public static PagedList<Contract> getPagingList(ContractCondition contractCondition) {
        ContractService contractService = (ContractService) context.getBean("contractService");

        return  contractService.getPagingList(contractCondition);
    }

    public static int add(Contract contract){
        ContractService contractService = (ContractService) context.getBean("contractService");

        return contractService.add(contract);
    }

    public static int update(Contract contract){
        ContractService contractService = (ContractService) context.getBean("contractService");

        return contractService.update(contract);
    }

    public static List<Contract> getList(){
        ContractService contractService = (ContractService) context.getBean("contractService");

        return contractService.getList();
    }

    public static Contract getInfo(int id){
        ContractService contractService = (ContractService) context.getBean("contractService");

        return contractService.getInfo(id);
    }
}
