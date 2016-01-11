package com.hzfh.service.workFlow.model.customer;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.service.workFlow.facade.customer.CustomerPersonalFacade;

/**
 * Created by ulei0 on 2015/9/11.
 */
public class CustomerPersonalModel {
    public static CustomerPersonal getInfo(int id){
        return CustomerPersonalFacade.getInfo(id);
    }

    public static int updateTradeTotalById(int id, double tradeTotal) {
        return CustomerPersonalFacade.updateTradeTotalById(id, tradeTotal);
    }
}
