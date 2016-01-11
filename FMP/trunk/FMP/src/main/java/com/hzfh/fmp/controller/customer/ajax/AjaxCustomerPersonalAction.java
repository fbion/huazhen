package com.hzfh.fmp.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.baseInfo.model.Letter;
import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.model.query.CustomerPersonalCondition;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.baseInfo.LetterModel;
import com.hzfh.fmp.model.baseInfo.SmsModel;
import com.hzfh.fmp.model.common.helper.EncodeHelper;
import com.hzfh.fmp.model.common.helper.ExcelHelper;
import com.hzfh.fmp.model.common.helper.ListItemHelper;
import com.hzfh.fmp.model.common.properties.DeptHelper;
import com.hzfh.fmp.model.common.view.ListItem;
import com.hzfh.fmp.model.customer.CustomerPersonalModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.P2pCustomerModel;
import com.hzfh.fmp.model.customer.PaymentAccountInformationModel;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.payment.PaymentRefundModel;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.ArrayHelper;
import com.hzframework.helper.StringHelper;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class AjaxCustomerPersonalAction extends JqGridBaseAction<CustomerPersonal> {
    private CustomerPersonal info;
    public CustomerPersonal getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, CustomerPersonal.class);
    }
    private String byName;
    private String byRelationLevel;
    private String byRiskHobby;
    private String byCardType;
    private String byEmpNo;
    private String byFindTimeUp;
    private String byFindTimeDown;
    private String showAllList;
    private String showDirectList;
    private String showChannelList;
    private String showShopList;
    private int    byDepartment;
    private String bySourceType;
    private String byResultStatus;
    private String byIsSales;
    private String byCellphone1;

    public String getByCellphone1() {
        return byCellphone1;
    }

    public void setByCellphone1(String byCellphone1) {
        this.byCellphone1 = byCellphone1;
    }

    public String getByName() {
        return byName;
    }

    public void setByName(String byName) {
        this.byName = byName;
    }

    public String getByRelationLevel() {
        return byRelationLevel;
    }

    public void setByRelationLevel(String byRelationLevel) {
        this.byRelationLevel = byRelationLevel;
    }

    public String getByRiskHobby() {
        return byRiskHobby;
    }

    public void setByRiskHobby(String byRiskHobby) {
        this.byRiskHobby = byRiskHobby;
    }

    public String getByCardType() {
        return byCardType;
    }

    public void setByCardType(String byCardType) {
        this.byCardType = byCardType;
    }

    public String getByEmpNo() {
        return byEmpNo;
    }

    public void setByEmpNo(String byEmpNo) {
        this.byEmpNo = byEmpNo;
    }

    public String getByFindTimeUp() {
        return byFindTimeUp;
    }

    public void setByFindTimeUp(String byFindTimeUp) {
        this.byFindTimeUp = byFindTimeUp;
    }

    public String getByFindTimeDown() {
        return byFindTimeDown;
    }

    public void setByFindTimeDown(String byFindTimeDown) {
        this.byFindTimeDown = byFindTimeDown;
    }

    public String getShowAllList() {
        return showAllList;
    }

    public void setShowAllList(String showAllList) {
        this.showAllList = showAllList;
    }

    public String getShowDirectList() {
        return showDirectList;
    }

    public void setShowDirectList(String showDirectList) {
        this.showDirectList = showDirectList;
    }

    public String getShowChannelList() {
        return showChannelList;
    }

    public void setShowChannelList(String showChannelList) {
        this.showChannelList = showChannelList;
    }

    public String getShowShopList() {
        return showShopList;
    }

    public void setShowShopList(String showShopList) {
        this.showShopList = showShopList;
    }

    public int getByDepartment() {
        return byDepartment;
    }

    public void setByDepartment(int byDepartment) {
        this.byDepartment = byDepartment;
    }

    public String getBySourceType() {
        return bySourceType;
    }

    public void setBySourceType(String bySourceType) {
        this.bySourceType = bySourceType;
    }

    public String getByResultStatus() {
        return byResultStatus;
    }

    public void setByResultStatus(String byResultStatus) {
        this.byResultStatus = byResultStatus;
    }

    public String getByIsSales() {
        return byIsSales;
    }

    public void setByIsSales(String byIsSales) {
        this.byIsSales = byIsSales;
    }
    private String getEmpStringByDeptType(int deptType){
        List<String> empList = new ArrayList<>();
        List<Department> departmentList = DepartmentModel.getDeptListByType(deptType);
        if (!ArrayHelper.isNullOrEmpty(departmentList)) {
            for (Department department : departmentList) {
                List<Employee> employeeList = EmployeeModel.getEmpListByDept(department.getId());
                if (!ArrayHelper.isNullOrEmpty(employeeList)) {
                    for (Employee employee : employeeList) {
                        empList.add(String.valueOf(employee.getUserNo()));
                    }
                }
            }
        }
        return StringHelper.listToString(empList);
    }
    private CustomerPersonalCondition getCondition() {
        CustomerPersonalCondition customerPersonalCondition = new CustomerPersonalCondition();
        customerPersonalCondition.setPageSize(this.getPageSize());
        customerPersonalCondition.setPageIndex(this.getPageIndex());
        if(!StringHelper.isNullOrEmpty(this.byCellphone1)){
            customerPersonalCondition.setCellphone1(this.byCellphone1);
            customerPersonalCondition.setCellphone2("m-"+EncodeHelper.encryptDES(this.byCellphone1));
        }
        customerPersonalCondition.setMyCustomer(false);

        if ("query".equals(this.showAllList)) {
            customerPersonalCondition.setWorkMateString(null);
        } else if ("query".equals(this.showDirectList)) {
            customerPersonalCondition.setWorkMateString(this.getEmpStringByDeptType(DeptHelper.TYEP_DIRECT));
        } else if ("query".equals(this.showChannelList)) {
            customerPersonalCondition.setWorkMateString(this.getEmpStringByDeptType(DeptHelper.TYEP_CHANNEL));
        } else if ("query".equals(this.showShopList)) {
            customerPersonalCondition.setWorkMateString(this.getEmpStringByDeptType(DeptHelper.TYEP_SHOP));
        } else {
            List<Integer> workmate = UserHelper.getUserCache().getWorkMate();
            if (workmate != null) {
                workmate.add(UserHelper.getUserCache().getUserId());
                String workMateString = StringHelper.listToString(workmate);
                customerPersonalCondition.setWorkMateString(workMateString);
            } else {
                customerPersonalCondition.setWorkMateString(String.valueOf(UserHelper.getUserCache().getUserId()));
            }
        }
        if (!StringHelper.isNullOrEmpty(this.bySourceType)) {
            customerPersonalCondition.setSourceType(Integer.valueOf(this.bySourceType));
        }

        if (!StringHelper.isNullOrEmpty(this.byFindTimeUp)) {
            customerPersonalCondition.setFindTimeUp(Timestamp.valueOf(this.byFindTimeUp));
        }
        if (!StringHelper.isNullOrEmpty(this.byFindTimeDown)) {
            customerPersonalCondition.setFindTimeDown(Timestamp.valueOf(this.byFindTimeDown));
        }

        if (this.byDepartment>0) {
            List<Integer> deptNos =new ArrayList<Integer>();
            if(this.byDepartment==DeptHelper.DEPT_SALES){
                List<Department> departments= DepartmentModel.getDeptListByParentNo(this.byDepartment);
                List<Employee> emps = EmployeeModel.getEmpListByDept(13);
                for (int i = 0; i < departments.size(); i++) {
                    emps.addAll(EmployeeModel.getEmpListByDept(departments.get(i).getId()));
                    for (int j = 0; j < emps.size(); j++) {
                        int userNo=emps.get(j).getUserNo();
                        deptNos.add(userNo);
                        String deptNo = StringHelper.listToString(deptNos);
                        customerPersonalCondition.setDeptNo(deptNo);
                    }
                }
            }else{
                List<Employee> emps = EmployeeModel.getEmpListByDept(this.byDepartment);
                if(emps.size()>0){
                    for (int i = 0; i < emps.size(); i++) {
                        int userNo=emps.get(i).getUserNo();
                        deptNos.add(userNo);
                    }
                    String deptNo = StringHelper.listToString(deptNos);
                    customerPersonalCondition.setDeptNo(deptNo);

                }else{
                    customerPersonalCondition.setDeptNo("0");
                }
            }

        }

        if (!StringHelper.isNullOrEmpty(this.byName)) {
            customerPersonalCondition.setName(this.byName);
        }
        if (!StringHelper.isNullOrEmpty(this.byEmpNo)) {
            customerPersonalCondition.setEmpNo(Integer.valueOf(this.byEmpNo));
        }
        if(!StringHelper.isNullOrEmpty(this.byIsSales)){
            customerPersonalCondition.setIsSales(Byte.valueOf(byIsSales));
        }else{
            customerPersonalCondition.setIsSales((byte) -1);
        }

        if (StringHelper.isNullOrEmpty(this.byRelationLevel)) {
            customerPersonalCondition.setRelationLevel(0);
        } else {
            customerPersonalCondition.setRelationLevel(Integer
                    .parseInt(this.byRelationLevel));
        }

        if (StringHelper.isNullOrEmpty(this.byRiskHobby)) {
            customerPersonalCondition.setRiskHobby(0);
        } else {
            customerPersonalCondition.setRiskHobby(Integer
                    .parseInt(this.byRiskHobby));
        }
        if(!StringHelper.isNullOrEmpty(this.byResultStatus)){
            customerPersonalCondition.setResultStatus(Byte.valueOf(this.byResultStatus));
        }
        if (StringHelper.isNullOrEmpty(this.getIsTest())) {
            customerPersonalCondition.setIsTest((byte) 0);
        } else {
            customerPersonalCondition.setIsTest(Byte.valueOf(this.getIsTest()));
        }

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        customerPersonalCondition.setSortItemList(sortItemList);

        return customerPersonalCondition;
    }
    @Override
    public String execute(){
        PagedList<CustomerPersonal> customerPersonalPagedList= CustomerPersonalModel.getPagingList(this.getCondition());
        this.setResultList(customerPersonalPagedList.getResultList());
        this.setPageCount(customerPersonalPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(customerPersonalPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(customerPersonalPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
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
    private String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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
    private String nameCheck;
    private String cellPhoneCheck;

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
    public String exportExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.getExcelForCustomerPersonal(getCondition(), this.showAllList);
        return null;
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
    private int customerPersonalNo;

    public int getCustomerPersonalNo() {
        return customerPersonalNo;
    }

    public void setCustomerPersonalNo(int customerPersonalNo) {
        this.customerPersonalNo = customerPersonalNo;
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
