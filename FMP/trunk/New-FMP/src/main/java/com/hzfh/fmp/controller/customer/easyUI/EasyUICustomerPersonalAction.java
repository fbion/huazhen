package com.hzfh.fmp.controller.customer.easyUI;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.query.CustomerPersonalCondition;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.fmp.controller.common.EasyUIBaseAction;
import com.hzfh.fmp.model.common.helper.EncodeHelper;
import com.hzfh.fmp.model.common.helper.ExcelHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.properties.DeptHelper;
import com.hzfh.fmp.model.customer.CustomerPersonalModel;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.ArrayHelper;
import com.hzframework.helper.StringHelper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class EasyUICustomerPersonalAction extends EasyUIBaseAction<CustomerPersonal> {

    private int isSales;
    private int resultStatus;
    private int riskHobby;
    private int relationLevel;
    private int sourceType;
    private String cellphone;
    private String name;
    private String endTime;
    private String startTime;
    private int agentNo;
    private String showAllList;
    private String showDirectList;
    private String showChannelList;
    private String showShopList;

    public void setShowAllList(String showAllList) {
        this.showAllList = showAllList;
    }
    public void setShowDirectList(String showDirectList) {
        this.showDirectList = showDirectList;
    }
    public void setShowChannelList(String showChannelList) {
        this.showChannelList = showChannelList;
    }
    public void setShowShopList(String showShopList) {
        this.showShopList = showShopList;
    }
    public void setAgentNo(int agentNo) {
        this.agentNo = agentNo;
    }
    public void setIsSales(int isSales) {
        this.isSales = isSales;
    }
    public void setResultStatus(int resultStatus) {
        this.resultStatus = resultStatus;
    }
    public void setRiskHobby(int riskHobby) {
        this.riskHobby = riskHobby;
    }
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
    public void setRelationLevel(int relationLevel) {
        this.relationLevel = relationLevel;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String execute() throws Exception {
        PagedList<CustomerPersonal> customerPersonalPagedList = CustomerPersonalModel.getPagingList(getCondition());
        this.setRows(customerPersonalPagedList.getResultList());
        this.setTotal(customerPersonalPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String exportExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.getExcelForCustomerPersonal(getCondition(), this.showAllList);
        return null;
    }
    public CustomerPersonalCondition getCondition(){
        CustomerPersonalCondition customerPersonalCondition = new CustomerPersonalCondition();
        customerPersonalCondition.setPageSize(this.getPageSize());
        customerPersonalCondition.setPageIndex(this.getPage());
        List<SortItem> sortItemList = new ArrayList<>();
        for (SortItem sortItem : this.getSortList()) {
            SortItem newSortItem = new SortItem();
            newSortItem.setSortFeild(sortItem.getSort());
            newSortItem.setSortType("asc".equalsIgnoreCase(sortItem.getOrder()) ? SortType.ASC : SortType.DESC);
            sortItemList.add(newSortItem);
        }
        customerPersonalCondition.setSortItemList(sortItemList);
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
        customerPersonalCondition.setName(this.name);
        if(!StringHelper.isNullOrEmpty(this.cellphone)){
            customerPersonalCondition.setCellphone1(this.cellphone);
            customerPersonalCondition.setCellphone2("m-"+ EncodeHelper.encryptDES(this.cellphone));
        }
        customerPersonalCondition.setRiskHobby(this.riskHobby);
        customerPersonalCondition.setRelationLevel(this.relationLevel);
        if(!StringHelper.isNullOrEmpty(this.startTime)){
            customerPersonalCondition.setFindTimeDown(Timestamp.valueOf(this.startTime));
        }
        if(!StringHelper.isNullOrEmpty(this.endTime)){
            customerPersonalCondition.setFindTimeUp(Timestamp.valueOf(this.endTime));
        }
        customerPersonalCondition.setSourceType(Integer.valueOf(this.sourceType));
        customerPersonalCondition.setResultStatus(this.resultStatus);
        if(!StringHelper.isNullOrEmpty(String.valueOf(this.isSales))){
            customerPersonalCondition.setIsSales(isSales);
        }else{
            customerPersonalCondition.setIsSales((byte) -1);
        }
        if (StringHelper.isNullOrEmpty(this.getIsTest())) {
            customerPersonalCondition.setIsTest((byte) 0);
        }
        if (!StringHelper.isNullOrEmpty(String.valueOf(this.agentNo))) {
            customerPersonalCondition.setEmpNo(Integer.valueOf(this.agentNo));
        }
        return customerPersonalCondition;
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
}
