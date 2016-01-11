package com.hzfh.fmp.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.fmp.controller.common.AjaxBaseAction;
import com.hzfh.fmp.model.UserCache;
import com.hzfh.fmp.model.common.enumeration.CustomerSource;
import com.hzfh.fmp.model.common.helper.EncodeHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.CustomerPersonalModel;
import com.hzfh.fmp.model.customer.P2pCustomerModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.StringHelper;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


public class AjaxP2pCustomerAction extends AjaxBaseAction {
    private P2pCustomer p2pCustomer;

    public P2pCustomer getP2pCustomer() {
        return p2pCustomer;
    }

    public void setP2pCustomer(P2pCustomer p2pCustomer) {
        this.p2pCustomer = p2pCustomer;
    }

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String realName;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    private List<P2pCustomer> infoList;
    private int userId;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setInfoList(String infoList) {
        /*JSONArray infoArray = JSONArray.fromObject(infoList);
//        infoArray[registerTime]
        this.infoList = (List<P2pCustomer>) JSONArray.toCollection(infoArray, P2pCustomer.class);*/


//        this.infoList = (List<P2pCustomer>)JSON.parseArray(infoList,P2pCustomer.class);
        this.infoList = (List<P2pCustomer>) JSONArray.parseArray(infoList,P2pCustomer.class);
    }

    public String getP2pCustomerById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("no id");
        }
        this.p2pCustomer = P2pCustomerModel.getInfo(Integer.valueOf(this.getId()));
        if (p2pCustomer == null) {
            this.setErrCode("p2pCustomer id null!");
        } else {
            this.userName = p2pCustomer.getUserName();
            this.realName = p2pCustomer.getRealName();
        }
        return SUCCESS;
    }

    public String checkUserName() {
        P2pCustomer p2pCustomerForCheckUserName = P2pCustomerModel.selectByUserName(userName.trim());
        if (p2pCustomerForCheckUserName != null) {
            this.setErrCode("failed");
            this.setErrDesc("该用户名已注册，请更换其他用户名");
        }
        return SUCCESS;
    }

    public String assignEmpNo() {
        try {
            int deptNo = EmployeeModel.getEmpByUserId(this.userId).getDeptNo();
            for (P2pCustomer p2pCustomer : infoList) {
                P2pCustomerModel.updateDeptNoAndEmpNoById(p2pCustomer.getId(), deptNo, this.userId);
            }
        } catch (Exception e) {
            this.setErrCode("failure");
        }
        return SUCCESS;
    }

    public String buildCustomer() {
        for (P2pCustomer p2pCustomer : infoList) {
            if (!StringHelper.isNullOrEmpty(p2pCustomer.getCardNumber()) && CustomerPersonalModel.cardCheck(p2pCustomer.getCardNumber(), 0, "m-" + EncodeHelper.encryptDES(p2pCustomer.getCardNumber())).size() > 0) {
                this.setErrCode("failure");
                this.setErrDesc(this.getErrDesc() + "'" + p2pCustomer.getCardNumber() + "',");
                continue;
            }
            if (!StringHelper.isNullOrEmpty(p2pCustomer.getCellphone()) && CustomerPersonalModel.checkCustomerPersonalByNameAndCellphone(0, null, p2pCustomer.getCellphone(), "m-" + EncodeHelper.encryptDES(p2pCustomer.getCellphone())).size() > 0) {
                this.setErrCode("failure");
                this.setErrDesc(this.getErrDesc() + "'" + p2pCustomer.getCellphone() + "',");
                continue;
            }
            CustomerPersonal customerPersonal = new CustomerPersonal();
            customerPersonal.setEmail(p2pCustomer.getEmail());
            if(!StringHelper.isNullOrEmpty(p2pCustomer.getCellphone())){
                customerPersonal.setCellphone1("m-" + EncodeHelper.encryptDES(p2pCustomer.getCellphone()));
            }
            customerPersonal.setQq(p2pCustomer.getQq());
            customerPersonal.setWeixin(p2pCustomer.getWeixin());
            if(!StringHelper.isNullOrEmpty(p2pCustomer.getPhone())){
                customerPersonal.setPhone("m-" + EncodeHelper.encryptDES(p2pCustomer.getPhone()));
            }
            customerPersonal.setName(p2pCustomer.getRealName());
            customerPersonal.setAgentNo(p2pCustomer.getEmpNo());
            customerPersonal.setAddress(p2pCustomer.getAddress());
            customerPersonal.setCardType(p2pCustomer.getCardType());
            if(!StringHelper.isNullOrEmpty(p2pCustomer.getCardNumber())){
                customerPersonal.setCardNumber("m-" + EncodeHelper.encryptDES(p2pCustomer.getCardNumber()));
            }
            customerPersonal.setSex(p2pCustomer.getSex());
            customerPersonal.setCompanyName(p2pCustomer.getCompanyName());
            customerPersonal.setMarry(p2pCustomer.getMarry());
            customerPersonal.setP2pCustomerNo(p2pCustomer.getId());
            customerPersonal.setInUserNo(UserHelper.getEditUserNo());
            customerPersonal.setEditUserNo(UserHelper.getEditUserNo());
            customerPersonal.setFindTime(DateHelper.getCurrentTime());
            customerPersonal.setSourceType(CustomerSource.P2P);
            int customerId = CustomerPersonalModel.add(customerPersonal);
            P2pCustomerModel.updateP2pCustomerById(p2pCustomer.getId(), customerId);
        }
        return SUCCESS;
    }
}
