package com.hzfh.fmp.controller.sales.ajax;

import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.api.sales.model.query.P2pSubscribeCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.enumeration.StatusType;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.properties.RoleHelper;
import com.hzfh.fmp.model.customer.P2pCustomerModel;
import com.hzfh.fmp.model.sales.P2pSubscribeModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class AjaxP2pSubscribeAction extends JqGridBaseAction<P2pSubscribe> {

    private String p2pCustomer;

    public void setP2pCustomer(String p2pCustomer) {
        this.p2pCustomer = p2pCustomer;
    }

    private String realName;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    private String cellphone;

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    private String provinceNo;

    public String getProvinceNo() {
        return provinceNo;
    }

    public void setProvinceNo(String provinceNo) {
        this.provinceNo = provinceNo;
    }

    private String cityNo;

    public String getCityNo() {
        return cityNo;
    }

    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }

    private String districtNo;

    public String getDistrictNo() {
        return districtNo;
    }

    public void setDistrictNo(String districtNo) {
        this.districtNo = districtNo;
    }

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String deptNo;

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    private String cardType;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    private String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    private String empNo;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String visitTime;

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private String isTest;

    public String getIsTest() {
        return isTest;
    }

    public void setIsTest(String isTest) {
        this.isTest = isTest;
    }

    private String p2pProductNo;

    public String getP2pProductNo() {
        return p2pProductNo;
    }

    public void setP2pProductNo(String p2pProductNo) {
        this.p2pProductNo = p2pProductNo;
    }

    private String subscribeNo;

    public void setSubscribeNo(String subscribeNo) {
        this.subscribeNo = subscribeNo;
    }

    private String customerNo;

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    private String byP2pCustomerNo;
    private String byDeptNo;
    private String byEmpNo;
    private String byStatus;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    private String id;


    public String getByP2pCustomerNo() {
        return byP2pCustomerNo;
    }

    public void setByP2pCustomerNo(String byP2pCustomerNo) {
        this.byP2pCustomerNo = byP2pCustomerNo;
    }

    public String getByDeptNo() {
        return byDeptNo;
    }

    public void setByDeptNo(String byDeptNo) {
        this.byDeptNo = byDeptNo;
    }

    public String getByEmpNo() {
        return byEmpNo;
    }

    public void setByEmpNo(String byEmpNo) {
        this.byEmpNo = byEmpNo;
    }

    public String getByStatus() {
        return byStatus;
    }

    public void setByStatus(String byStatus) {
        this.byStatus = byStatus;
    }

    private String byP2pProductNo;

    public String getByP2pProductNo() {
        return byP2pProductNo;
    }

    public void setByP2pProductNo(String byP2pProductNo) {
        this.byP2pProductNo = byP2pProductNo;
    }


    @Override
    public String execute() throws Exception {
        P2pSubscribeCondition p2pSubscribeCondition = new P2pSubscribeCondition();
        p2pSubscribeCondition.setPageSize(this.getPageSize());
        p2pSubscribeCondition.setPageIndex(this.getPageIndex());

        if (!StringHelper.isNullOrEmpty(this.byDeptNo)) {
            p2pSubscribeCondition.setByDeptNo(Integer.parseInt(this.byDeptNo));
        }
        if (!StringHelper.isNullOrEmpty(this.byEmpNo)) {
            p2pSubscribeCondition.setByEmpNo(Integer.parseInt(this.byEmpNo));
        }
        if (!StringHelper.isNullOrEmpty(this.byP2pCustomerNo)) {
            p2pSubscribeCondition.setByP2pCustomerNo(Integer.parseInt(this.byP2pCustomerNo));
        }
        if (!StringHelper.isNullOrEmpty(this.byP2pProductNo)) {
            p2pSubscribeCondition.setByP2pProductNo(Integer.parseInt(byP2pProductNo));
        }
        if (!StringHelper.isNullOrEmpty(this.byStatus)) {
            p2pSubscribeCondition.setByStatus(Integer.parseInt(byStatus));
        }
        if (UserHelper.getUserCache().getRoleId() == RoleHelper.ROLE_CS_MANAGER) {
            p2pSubscribeCondition.setEmpNo(StatusType.NOISASSIGNEMP);
        } else {
            p2pSubscribeCondition.setEmpNo(StatusType.ISASSIGNEMP);
        }
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        p2pSubscribeCondition.setSortItemList(sortItemList);

        PagedList<P2pSubscribe> p2pSubscribePagedList = P2pSubscribeModel.getPagingList(p2pSubscribeCondition);
        this.setResultList(p2pSubscribePagedList.getResultList());
        this.setPageCount(p2pSubscribePagedList.getPagingInfo().getPageCount());
        this.setPageIndex(p2pSubscribePagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(p2pSubscribePagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit() {
        P2pSubscribe p2pSubscribe = new P2pSubscribe();

        p2pSubscribe.setP2pCustomer(Integer.parseInt(this.p2pCustomer));
        p2pSubscribe.setRealName(this.realName);
        p2pSubscribe.setCellphone(this.cellphone);
        p2pSubscribe.setProvinceNo(Integer.valueOf(this.provinceNo));
        p2pSubscribe.setCityNo(Integer.valueOf(this.cityNo));
        p2pSubscribe.setDistrictNo(Integer.valueOf(this.districtNo));
        p2pSubscribe.setAddress(this.address);
        p2pSubscribe.setDeptNo(Integer.valueOf(this.deptNo));
        p2pSubscribe.setCardType(Byte.valueOf(this.cardType));
        p2pSubscribe.setCardNumber(this.cardNumber);
        p2pSubscribe.setAmount(Long.valueOf(this.amount));
        p2pSubscribe.setEmpNo(Integer.valueOf(this.empNo));
        p2pSubscribe.setStatus(Byte.valueOf(this.status));
        p2pSubscribe.setVisitTime(Timestamp.valueOf(this.visitTime));
        p2pSubscribe.setResult(this.result);
        p2pSubscribe.setIsTest(Byte.valueOf(this.isTest));
        p2pSubscribe.setP2pProductNo(Integer.valueOf(this.p2pProductNo));
        p2pSubscribe.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
            p2pSubscribe.setInUserNo(UserHelper.getEditUserNo());
            if (P2pSubscribeModel.add(p2pSubscribe) <= 0) {
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }
        } else {
            if (this.getId().isEmpty()) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            } else {
                if (this.getOper().equalsIgnoreCase("edit")) {
                    p2pSubscribe.setId(Integer.parseInt(this.getId()));
                    if (P2pSubscribeModel.update(p2pSubscribe) <= 0) {
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }

        return SUCCESS;
    }

    public String updateP2pSubscribeStatus() {

        int id = Integer.parseInt(this.id);

        // P2pSubscribeModel p2pSubscribeModel = new P2pSubscribeModel();
        int updateCount = P2pSubscribeModel.updateP2pSubScribeStatus(id, 2);

        if (updateCount >= 0) {

        }
        return SUCCESS;
    }

    public String updateById() {
        if (this.customerNo.isEmpty()) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
            return SUCCESS;
        }
        int subscribeId = Integer.valueOf(this.subscribeNo);
        int customerNo = Integer.valueOf(this.customerNo);
        int p2pCustomerId = Integer.valueOf(this.p2pCustomer);
        //关联p2p预约和自然人客户
        if (P2pSubscribeModel.updateP2pSubscribeByP2pCustomerNo(p2pCustomerId, customerNo) <= 0) {
            this.setErrCode("updateP2pSubscribeById Failed");
            this.setErrDesc("updateP2pSubscribeById Failed");
            return SUCCESS;
        }
        //关联p2p客户和自然人客户
        if(P2pCustomerModel.updateP2pCustomerById(p2pCustomerId, customerNo) <= 0){
            this.setErrCode("updateP2pCustomerById Failed");
            this.setErrDesc("updateP2pCustomerById Failed");
            return SUCCESS;
        }
        return SUCCESS;
    }
/*
    public String assignEmpNo(){
        if(this.realName == null){
            this.setErrDesc("No realName");
            this.setErrCode("No realName");
            return SUCCESS;
        }
        return SUCCESS;
    }*/

}
