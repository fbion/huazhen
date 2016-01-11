package com.hzfh.fmp.controller.sales.ajax;

import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.fmp.controller.common.AjaxBaseAction;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.sales.P2pSubscribeModel;
import net.sf.json.JSONArray;

import java.util.List;


public class AjaxP2pSubscribeAction extends AjaxBaseAction {
    private List<P2pSubscribe> infoList;
    private int userId;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setInfoList(String infoList) {
        JSONArray infoArray = JSONArray.fromObject(infoList);
        this.infoList = (List<P2pSubscribe>) JSONArray.toCollection(infoArray, P2pSubscribe.class);
    }

    public String assignEmpNo(){
        try{
            int deptNo = EmployeeModel.getEmpByUserId(this.userId).getDeptNo();
            for(P2pSubscribe p2pSubscribe:infoList){
                P2pSubscribeModel.updateEmpNoById(p2pSubscribe.getId(),deptNo,this.userId);
            }
        }catch (Exception e){
            this.setErrCode("failure");
        }
        return SUCCESS;
    }

}
