package com.hzfh.fmp.model.sales;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.sales.model.ApplyCustomer;
import com.hzfh.api.sales.model.query.ApplyCustomerCondition;
import com.hzfh.fmp.facade.customer.CustomerPersonalFacade;
import com.hzfh.fmp.facade.sales.ApplyCustomerFacade;
import com.hzfh.fmp.model.common.helper.EncodeHelper;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ApplyCustomerModel {
    public static PagedList<ApplyCustomer> getPagingList(ApplyCustomerCondition applyCustomerCondition) {
    	
    	PagedList<ApplyCustomer> applyCustomerPagedList = ApplyCustomerFacade.getPagingList(applyCustomerCondition);
        for(ApplyCustomer applyCustomer:applyCustomerPagedList.getResultList()){
            decryptDES(applyCustomer);
        }
        return applyCustomerPagedList;
    }
    public static int add(ApplyCustomer applyCustomer) {
        return ApplyCustomerFacade.add(applyCustomer);
    }

    public static int update(ApplyCustomer applyCustomer) {
        return ApplyCustomerFacade.update(applyCustomer);
    }

    public static List<ApplyCustomer> getList() {
        return ApplyCustomerFacade.getList();
    }

    public static ApplyCustomer getInfo(int id) {
        return ApplyCustomerFacade.getInfo(id);
    }
	public static List<ApplyCustomer> getListByEmpNo(ApplyCustomer applyCustomer) {
		List<ApplyCustomer> applyCustomers=ApplyCustomerFacade.getListByEmpNo(applyCustomer);
		for(ApplyCustomer aCustomer:applyCustomers){
            decryptDES(aCustomer);
        }
		// TODO Auto-generated method stub
		return applyCustomers;
	}
	public static ApplyCustomer getInfoByCus(ApplyCustomer applyCustomer) {
		// TODO Auto-generated method stub
		return ApplyCustomerFacade.getInfoByCus(applyCustomer);
	}

    public static ApplyCustomer decryptDES(ApplyCustomer applyCustomer){
    	
        if(applyCustomer.getTel()!=null&&applyCustomer.getTel().split("-")[0].equalsIgnoreCase("m")){
        	applyCustomer.setTel(EncodeHelper.decryptDES(applyCustomer.getTel().split("-")[1]));
        }
        if(applyCustomer.getMark()!=null&&applyCustomer.getMark().split("-")[0].equalsIgnoreCase("m")){
        	applyCustomer.setMark(EncodeHelper.decryptDES(applyCustomer.getMark().split("-")[1]));
        }
        return applyCustomer;
    }

}
