package com.hzfh.fmp.model.sales;

import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.api.sales.model.query.P2pSubscribeCondition;
import com.hzfh.fmp.facade.sales.P2pSubscribeFacade;
import com.hzframework.contract.PagedList;

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


    public static int updateP2pSubScribeStatus(int id,int status){

    return P2pSubscribeFacade.updateP2pSubScribeStatus(id,status);

    }
    @Deprecated
    public static int updateP2pSubscribeById(int id,int customerNo){
        return P2pSubscribeFacade.updateP2pSubscribeById(id,customerNo);
    }
    @Deprecated
    public static int updateEmpNoById(int id,int deptNo,int empNo){
        return P2pSubscribeFacade.updateEmpNoById(id,deptNo,empNo);
    }


    public static int updateP2pSubscribeByP2pCustomerNo(int p2pCustomerNo, int customerNo) {
        return P2pSubscribeFacade.updateP2pSubscribeByP2pCustomerNo(p2pCustomerNo,customerNo);

    }

    public static int updateEmpNoByP2pCustomerNo(int p2pCustomerNo, int deptNo, int userNo) {
        return P2pSubscribeFacade.updateEmpNoByP2pCustomerNo(p2pCustomerNo,deptNo,userNo);
    }
}
