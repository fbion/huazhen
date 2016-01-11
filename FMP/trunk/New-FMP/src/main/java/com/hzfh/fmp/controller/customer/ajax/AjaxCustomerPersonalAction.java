package com.hzfh.fmp.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.fmp.controller.common.AjaxBaseAction;
import com.hzfh.fmp.model.baseInfo.LetterModel;
import com.hzfh.fmp.model.baseInfo.SmsModel;
import com.hzfh.fmp.model.common.EnumListCacheModel;
import com.hzfh.fmp.model.common.helper.EncodeHelper;
import com.hzfh.fmp.model.common.helper.ListItemHelper;
import com.hzfh.fmp.model.common.view.ListItem;
import com.hzfh.fmp.model.customer.CustomerPersonalModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.P2pCustomerModel;
import com.hzfh.fmp.model.customer.PaymentAccountInformationModel;
import com.hzfh.fmp.model.payment.PaymentRefundModel;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzframework.helper.ArrayHelper;
import com.hzframework.helper.StringHelper;
import net.sf.json.JSONArray;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class AjaxCustomerPersonalAction extends AjaxBaseAction{
    private CustomerPersonal info;
    private int customerPersonalNo;
    private String cardNumber;
    private String nameCheck;
    private String cellPhoneCheck;
    private List<CustomerPersonal> infoList;

    public void setInfoList(String infoList) {
        JSONArray infoArray = JSONArray.fromObject(infoList);
        this.infoList = (List<CustomerPersonal>) JSONArray.toCollection(infoArray, CustomerPersonal.class);
    }
    public String getNameCheck() {
        return nameCheck;
    }

    public void setNameCheck(String nameCheck) {
        this.nameCheck = nameCheck;
    }

    public String getCellPhoneCheck() {
        return cellPhoneCheck;
    }

    public void setCellPhoneCheck(String cellPhoneCheck) {
        this.cellPhoneCheck = cellPhoneCheck;
    }
    public CustomerPersonal getInfo() {
        return info;
    }
    public int getCustomerPersonalNo() {
        return customerPersonalNo;
    }
    public void setCustomerPersonalNo(int customerPersonalNo) {
        this.customerPersonalNo = customerPersonalNo;
    }
    public void setInfo(String info) {
        this.info = JSON.parseObject(info, CustomerPersonal.class);
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String edit(){
        info.setEditUserNo(UserHelper.getEditUserNo());

        if (!StringHelper.isNullOrEmpty(this.info.getCardNumber())) {
            info.setCardNumber("m-"+EncodeHelper.encryptDES(this.info.getCardNumber()));
        }

        if (!StringHelper.isNullOrEmpty(this.info.getPhone())) {
            info.setPhone("m-"+EncodeHelper.encryptDES(this.info.getPhone()));
        }

        if (!StringHelper.isNullOrEmpty(this.info.getCellphone1())) {
            info.setCellphone1("m-"+EncodeHelper.encryptDES(this.info.getCellphone1()));
        }

        if (!StringHelper.isNullOrEmpty(this.info.getCellphone2())) {
            info.setCellphone2("m-"+EncodeHelper.encryptDES(this.info.getCellphone2()));
        }
        int id = 0;
        if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
            id = CustomerPersonalModel.add(info);
            if (id > 0){
                this.setErrDesc(String.valueOf(id));
            }else{
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }
        }
        else
        {
            if (info.getId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            }
            else{
                if (this.getOper().equalsIgnoreCase("edit")) {
                    if(!info.getName().equals(CustomerPersonalModel.getInfo(info.getId()).getName())){
                        if(SalesModel.getListByCustomerNo(info.getId()).size()>0){
                            SalesModel.updateCustomerNameByCustomerNo(info.getId(),info.getName());
                        }
                    }
                    if (CustomerPersonalModel.update(info) > 0){
                        this.setErrDesc(String.valueOf(info.getId()));
                    }else{
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }
//        EnumListCacheModel.getCustomerPersonList(false);
        return SUCCESS;
    }

    public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.info = CustomerPersonalModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }
    public String cardCheck() {
        String cardNumber = this.getCardNumber();
        int id = 0;
        if (!StringHelper.isNullOrEmpty(this.getId())) {
            id = Integer.parseInt(this.getId());
        }
        String desCardNumber = "m-"+ EncodeHelper.encryptDES(this.cardNumber);
        List<CustomerPersonal> customerPersonalList = CustomerPersonalModel.cardCheck(cardNumber, id,desCardNumber);
        if (customerPersonalList.size() > 0) {
            this.setErrCode("failed");
            this.setErrDesc("您输入的身份证已经存在，请重新输入！");
        } else {
            this.setErrCode("ok");
            this.setErrDesc("身份证录入成功！");
        }
        return SUCCESS;
    }


    public String cellPhoneCheck() {
        int id = Integer.parseInt(this.getId());
        String nameCheck = this.nameCheck;
        String cellphoneCheck = this.cellPhoneCheck;
        String desCellphoneCheck = "m-"+EncodeHelper.encryptDES(this.cellPhoneCheck);

        List<CustomerPersonal> customerPersonalList = CustomerPersonalModel.checkCustomerPersonalByNameAndCellphone(id, nameCheck, cellphoneCheck,desCellphoneCheck);
        if (!ArrayHelper.isNullOrEmpty(customerPersonalList)) {
            this.setErrCode("failed");
            this.setErrDesc("您输入的手机号已经存在，请重新输入！");
        } else {
            this.setErrCode("ok");
            this.setErrDesc("手机号可以使用！");
        }
        return SUCCESS;
    }
    private int status0ManagerNo;
    private int status1ManagerNo;

    public int getStatus1ManagerNo() {
        return status1ManagerNo;
    }

    public void setStatus1ManagerNo(int status1ManagerNo) {
        this.status1ManagerNo = status1ManagerNo;
    }

    public int getStatus0ManagerNo() {
        return status0ManagerNo;
    }

    public void setStatus0ManagerNo(int status0ManagerNo) {
        this.status0ManagerNo = status0ManagerNo;
    }

    private List<ListItem> empStatus0List;
    private List<ListItem> empStatus1List;

    public List<ListItem> getEmpStatus0List() {
        return empStatus0List;
    }

    public void setEmpStatus0List(List<ListItem> empStatus0List) {
        this.empStatus0List = empStatus0List;
    }

    public List<ListItem> getEmpStatus1List() {
        return empStatus1List;
    }

    public void setEmpStatus1List(List<ListItem> empStatus1List) {
        this.empStatus1List = empStatus1List;
    }

    public String getChangeManager(){
        List<CustomerPersonal> temp0 = CustomerPersonalModel.getCustomerPersonalListByManagerNo(this.status0ManagerNo);
        this.empStatus0List = ListItemHelper.getListItemList("name", "id", temp0);
        List<CustomerPersonal> temp1 = CustomerPersonalModel.getCustomerPersonalListByManagerNo(this.status1ManagerNo);
        this.empStatus1List = ListItemHelper.getListItemList("name", "id", temp1);
        return SUCCESS;

    }
    private List<CustomerPersonal> empStatus0CustomerValue;
    private List<CustomerPersonal> empStatus1CustomerValue;

    public void setEmpStatus0CustomerValue(String empStatus0CustomerValue) {
        List<CustomerPersonal> customerPersonals = new ArrayList<CustomerPersonal>();
        for (int i = 0; i < JSON.parseArray(empStatus0CustomerValue).size(); i++) {
            JSON json= (JSON) JSON.toJSON(JSON.parseArray(empStatus0CustomerValue).get(i));
            CustomerPersonal customerPersonal = JSON.toJavaObject(json, CustomerPersonal.class);
            customerPersonals.add(customerPersonal);
        }
        this.empStatus0CustomerValue = customerPersonals;
    }

    public void setEmpStatus1CustomerValue(String empStatus1CustomerValue) {
        List<CustomerPersonal> customerPersonals = new ArrayList<CustomerPersonal>();
        for (int i = 0; i < JSON.parseArray(empStatus1CustomerValue).size(); i++) {
            JSON json= (JSON) JSON.toJSON(JSON.parseArray(empStatus1CustomerValue).get(i));
            CustomerPersonal customerPersonal = JSON.toJavaObject(json, CustomerPersonal.class);
            customerPersonals.add(customerPersonal);
        }
        this.empStatus1CustomerValue = customerPersonals;
    }

    public String updateCustomerManagerNo(){
        int a = 1;
        if (this.status0ManagerNo!=0 && empStatus0CustomerValue!=null && empStatus0CustomerValue.size()>0 ) {
            CustomerPersonal tempCustomerPersonal = new CustomerPersonal();
            int result = -1;
            for (int i = 0; i < empStatus0CustomerValue.size(); i++) {
                int customerNo = Integer.valueOf(empStatus0CustomerValue.get(i).getId());
                tempCustomerPersonal = CustomerPersonalModel.getInfo(customerNo);
                if (tempCustomerPersonal.getAgentNo()==this.status0ManagerNo) {
                    continue;
                }
                tempCustomerPersonal.setAgentNo(Integer.valueOf(this.status0ManagerNo));
                String content = "您已被指定为自然人客户"+tempCustomerPersonal.getName()+"的理财顾问，请及时跟进";
                LetterModel.addReminds("您有新的自然人客户",content,this.status0ManagerNo);
                result = CustomerPersonalModel.update(tempCustomerPersonal);
                if(result<0){
                    this.setErrDesc("NO");
                    this.setErrCode("NO");
                    return SUCCESS;
                }
            }

        }
        if (this.status1ManagerNo!=0 && this.empStatus1CustomerValue!=null&&empStatus1CustomerValue.size()>0) {
            CustomerPersonal tempCustomerPersonal = new CustomerPersonal();
            int result = -1;
            for (int i = 0; i < empStatus1CustomerValue.size(); i++) {
                tempCustomerPersonal = CustomerPersonalModel.getInfo(Integer.valueOf(this.empStatus1CustomerValue.get(i).getId()));
                if (tempCustomerPersonal.getAgentNo()==this.status1ManagerNo) {
                    continue;
                }
                tempCustomerPersonal.setAgentNo(Integer.valueOf(this.status1ManagerNo));
                result = CustomerPersonalModel.update(tempCustomerPersonal);

                String content = "您已被指定为自然人客户"+tempCustomerPersonal.getName()+"的理财顾问，请及时跟进";
                LetterModel.addReminds("您有新的自然人客户",content,this.status1ManagerNo);
                if(result<0){
                    this.setErrDesc("NO");
                    this.setErrCode("NO");
                    return SUCCESS;
                }
            }
        }

        this.setErrDesc("OK");
        this.setErrCode("OK");
        return SUCCESS;
    }

    public String ajaxEstablishP2pUser(){

        CustomerPersonal customerPersonal = CustomerPersonalModel.getInfo(this.customerPersonalNo);
        if(customerPersonal.getCellphone1()==null){
            this.setErrCode("failed");
            this.setErrDesc("该客户信息不完善，请补充手机号！");
            return SUCCESS;
        }
        if(P2pCustomerModel.getP2pCustomerByCustomerNo(customerPersonal.getId())!=null){
            this.setErrCode("failed");
            this.setErrDesc("该客户已经创建网站用户！");
            return SUCCESS;
        }
        if(P2pCustomerModel.getInfoByCellphone(customerPersonal.getCellphone1())!=null){
            this.setErrCode("failed");
            this.setErrDesc("该客户已经注册网站用户！");
            return SUCCESS;
        }
        P2pCustomer p2pCustomer = new P2pCustomer();
        p2pCustomer.setEmail(customerPersonal.getEmail());
        p2pCustomer.setUserName(UUID.randomUUID().toString());
        p2pCustomer.setRealName(customerPersonal.getName());
        p2pCustomer.setSecretKey(EncodeHelper.initKey(UUID.randomUUID().toString()));
        p2pCustomer.setCustomerNo(customerPersonal.getId());
        p2pCustomer.setCellphone(customerPersonal.getCellphone1());
        p2pCustomer.setStatus((byte)1);
        int p2pCustoemrNo  = P2pCustomerModel.add(p2pCustomer);

        PaymentAccountInformation paymentAccountInfo=new PaymentAccountInformation();
        paymentAccountInfo.setCustomerNo(p2pCustoemrNo);
        paymentAccountInfo.setCustomerName(customerPersonal.getName());
        String dateStr = "";
        Date date = new Date();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateStr = sdf.format(date);
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        try {
            ts = Timestamp.valueOf(dateStr);
            paymentAccountInfo.setAccrualTimePeriod(ts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        paymentAccountInfo.setAuthenticationTel(1);
        paymentAccountInfo.setAccountType((byte)1);
        PaymentAccountInformationModel.add(paymentAccountInfo);
        if(p2pCustoemrNo > 0){
            customerPersonal.setP2pCustomerNo(p2pCustoemrNo);
            CustomerPersonalModel.update(customerPersonal);
            SalesModel.updateP2pCustomerNoByCustomerNo(customerPersonalNo, p2pCustoemrNo);
            PaymentRefundModel.updateP2pCustomerNoByCustomerNo(89,p2pCustoemrNo);
            if(SmsModel.smsCreateP2pCustomer(customerPersonal.getCellphone1())<=0){
                this.setErrCode("failed");
                this.setErrDesc("已完成创建，未给客户发送提醒短信！");
                return SUCCESS;
            }
        }else{
            this.setErrCode("failed");
            this.setErrDesc("创建失败，请联系管理员！");
            return SUCCESS;
        }
        return SUCCESS;
    }
}
