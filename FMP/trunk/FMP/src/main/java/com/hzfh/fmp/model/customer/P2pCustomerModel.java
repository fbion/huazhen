package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.query.P2pCustomerCondition;
import com.hzfh.fmp.facade.customer.P2pCustomerFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class P2pCustomerModel {
    public static PagedList<P2pCustomer> getPagingList(P2pCustomerCondition p2pCustomerCondition) {
        return P2pCustomerFacade.getPagingList(p2pCustomerCondition);
    }

    public static int add(P2pCustomer p2pCustomer) {
        return P2pCustomerFacade.add(p2pCustomer);
    }

    public static int update(P2pCustomer p2pCustomer) {
        return P2pCustomerFacade.update(p2pCustomer);
    }

    public static List<P2pCustomer> getList() {
        return P2pCustomerFacade.getList();
    }

    public static P2pCustomer getInfo(int id) {
        return P2pCustomerFacade.getInfo(id);
    }

    public static int updateP2pCustomerById(int id,int customerNo){
        return P2pCustomerFacade.updateP2pCustomerById(id,customerNo);
    }

    public static P2pCustomer getP2pCustomerByCustomerNo(int customerNo){
        return P2pCustomerFacade.getP2pCustomerByCustomerNo(customerNo);
    }

    public static int updateDeptNoAndEmpNoById(int id,int deptNo,int empNo){
        return P2pCustomerFacade.updateDeptNoAndEmpNoById(id,deptNo,empNo);
    }

    public static P2pCustomer selectByUserName(String userName){
    	return P2pCustomerFacade.selectByUserName(userName);
    }

    public static P2pCustomer getInfoByCellphone(String cellphone){
        return  P2pCustomerFacade.getInfoByCellphone(cellphone);
    }

}
