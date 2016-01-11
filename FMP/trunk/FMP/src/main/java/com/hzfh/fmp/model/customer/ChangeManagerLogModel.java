package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.ChangeManagerLog;
import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.query.ChangeManagerLogCondition;
import com.hzfh.fmp.facade.customer.ChangeManagerLogFacade;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ChangeManagerLogModel {
    public static PagedList<ChangeManagerLog> getPagingList(ChangeManagerLogCondition changeManagerLogCondition) {
        return ChangeManagerLogFacade.getPagingList(changeManagerLogCondition);
    }

    public static int add(ChangeManagerLog changeManagerLog) {
        return ChangeManagerLogFacade.add(changeManagerLog);
    }

    public static int update(ChangeManagerLog changeManagerLog) {
        return ChangeManagerLogFacade.update(changeManagerLog);
    }

    public static List<ChangeManagerLog> getList() {
        return ChangeManagerLogFacade.getList();
    }

    public static ChangeManagerLog getInfo(int id) {
        return ChangeManagerLogFacade.getInfo(id);
    }
    
  	//write Log by  Zorro
    public static int addChangeManagerLog(CustomerPersonal customerPersonal){
    	ChangeManagerLog changeManagerLog = new ChangeManagerLog();
    	changeManagerLog.setUserNo(UserHelper.getUserCache().getUserId());
    	changeManagerLog.setUserName(UserHelper.getUserCache().getEmpName());
    	changeManagerLog.setCustomerNo(customerPersonal.getId());
    	changeManagerLog.setCustomerName(customerPersonal.getName());
    	String managerName = EmployeeModel.getEmpByUserId(customerPersonal.getAgentNo()).getName(); 
    	changeManagerLog.setManagerName(managerName);
    	int result = ChangeManagerLogModel.add(changeManagerLog);
    	return result;
    }
    
}
