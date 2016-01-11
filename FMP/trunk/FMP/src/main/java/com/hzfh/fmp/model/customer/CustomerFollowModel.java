package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.CustomerFollow;
import com.hzfh.api.customer.model.query.CustomerFollowCondition;
import com.hzfh.fmp.facade.customer.CustomerFollowFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class CustomerFollowModel {
    public static PagedList<CustomerFollow> getPagingList(CustomerFollowCondition customerFollowCondition) {
        return CustomerFollowFacade.getPagingList(customerFollowCondition);
    }

    public static int add(CustomerFollow customerFollow) {
        return CustomerFollowFacade.add(customerFollow);
    }

    public static int update(CustomerFollow customerFollow) {
        return CustomerFollowFacade.update(customerFollow);
    }

    public static List<CustomerFollow> getList() {
        return CustomerFollowFacade.getList();
    }

    public static CustomerFollow getInfo(int id) {
        return CustomerFollowFacade.getInfo(id);
    }

	
	public static List<CustomerFollow> getCustomerFollowListLastThree(String customerFollowId) {
		return CustomerFollowFacade.getCustomerFollowListLastThree(customerFollowId);
	}
}
