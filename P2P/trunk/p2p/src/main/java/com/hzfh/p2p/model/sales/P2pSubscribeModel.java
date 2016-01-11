package com.hzfh.p2p.model.sales;

import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.api.sales.model.query.P2pSubscribeCondition;
import com.hzfh.p2p.facade.sales.P2pSubscribeFacade;
import com.hzframework.contract.PagedList;

import java.sql.Timestamp;
import java.util.List;

public class P2pSubscribeModel {
    public static PagedList<P2pSubscribe> getPagingList(P2pSubscribeCondition p2pSubscribeCondition) {
        return P2pSubscribeFacade.getPagingList(p2pSubscribeCondition);
    }

    public static int add(P2pSubscribe p2pSubscribe) {
        return P2pSubscribeFacade.add(p2pSubscribe);
    }

    public static int update(P2pSubscribe p2pSubscribe) {
        return P2pSubscribeFacade.update(p2pSubscribe);
    }

    public static List<P2pSubscribe> getList() {
        return P2pSubscribeFacade.getList();
    }

    public static P2pSubscribe getInfo(int id) {
        return P2pSubscribeFacade.getInfo(id);
    }
    
    public static int updateEmpNoById(int id,int deptNo,int empNo){
    	return P2pSubscribeFacade.updateEmpNoById(id,deptNo,empNo);
    }
    
    public static int updateVisitTimeAndVisitTimeAndStatus(int id,Timestamp visitTime,String result,byte status){
    	return P2pSubscribeFacade.updateVisitTimeAndVisitTimeAndStatus(id,visitTime,result,status);
    }

	public static List<P2pSubscribe> getListByP2pCustomerNo(int customerNo) {
		// TODO Auto-generated method stub
		return P2pSubscribeFacade.getListByP2pCustomerNo(customerNo);
	}



}
