package com.hzfh.fmp.controller.sales.ajax;

import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.report.model.AddCustomerReport;
import com.hzfh.api.report.model.AddSalesReport;
import com.hzfh.api.report.model.query.AddSalesReportCondition;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.enumeration.ProductType;
import com.hzfh.fmp.model.common.enumeration.SalesStatus;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.properties.DeptHelper;
import com.hzfh.fmp.model.customer.AddCustomerReportModel;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.sales.AddSalesReportModel;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.StringHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/11/6.
 */
public class AjaxAddSalesReport extends JqGridBaseAction<AddSalesReport> {

    private List<AddSalesReport> rows;

    public List<AddSalesReport> getRows() {
        return rows;
    }

    public void setRows(List<AddSalesReport> rows) {
        this.rows = rows;
    }




    private String startTime;
    private String endTime;
    private String showAllList;
    private String showDirectList;
    private String showShopList;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShowDirectList() {
        return showDirectList;
    }

    public void setShowDirectList(String showDirectList) {
        this.showDirectList = showDirectList;
    }

    public String getShowShopList() {
        return showShopList;
    }

    public void setShowShopList(String showShopList) {
        this.showShopList = showShopList;
    }

    public String getShowAllList() {
        return showAllList;
    }

    public void setShowAllList(String showAllList) {
        this.showAllList = showAllList;
    }




    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    private List<Integer> getEmpNosBydeptRecursive(int deptNo){
        List<Employee> empList = new ArrayList<Employee>();
        getEmpNosByDept(deptNo,empList);
        List<Integer> workMate = new ArrayList<Integer>();
        for (Employee employee : empList) {
            workMate.add(employee.getUserNo());
        }
        return workMate;
    }
    private List<Integer> getEmpNosBydept(int deptNo){
        List<Employee> empList = EmployeeModel.getEmpListByDept(deptNo);
        List<Integer> workMate = new ArrayList<Integer>();
        for (Employee employee : empList) {
            workMate.add(employee.getUserNo());
        }
        return workMate;
    }
    @Override
    public String execute(){
        SalesCondition p2pSalesCondition = new SalesCondition();
        SalesCondition otherSalesCondition = new SalesCondition();
        SalesCondition salesCondition = new SalesCondition();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        p2pSalesCondition.setProductType(5);
        if (!StringHelper.isNullOrEmpty(this.status)) {
            p2pSalesCondition.setStatus(Integer.parseInt(this.status));
            otherSalesCondition.setStatus(Integer.parseInt(this.status));
            salesCondition.setStatus(Integer.parseInt(this.status));
        }else{
            p2pSalesCondition.setStatus(SalesStatus.success);
            otherSalesCondition.setStatus(SalesStatus.success);
            salesCondition.setStatus(SalesStatus.success);
        }
        if (!StringHelper.isNullOrEmpty(this.startTime)) {
            p2pSalesCondition.setStartTime(this.startTime);
            otherSalesCondition.setStartTime(this.startTime);
            salesCondition.setStartTime(this.startTime);
        }else{
            p2pSalesCondition.setStartTime(sdf.format(DateHelper.addDay(new Date(),-7)));
            otherSalesCondition.setStartTime(sdf.format(DateHelper.addDay(new Date(),-7)));
            salesCondition.setStartTime(sdf.format(DateHelper.addDay(new Date(),-7)));
        }
        if (!StringHelper.isNullOrEmpty(this.endTime)) {
            p2pSalesCondition.setEndTime(this.endTime);
            otherSalesCondition.setEndTime(this.endTime);
            salesCondition.setEndTime(this.endTime);
        }else{
            p2pSalesCondition.setEndTime(sdf.format(new Date()));
            otherSalesCondition.setEndTime(sdf.format(new Date()));
            salesCondition.setEndTime(sdf.format(new Date()));
        }
        List<Department> departmentList = new ArrayList<Department>();
        if ("query".equals(this.showAllList)) {
            departmentList.add(DepartmentModel.getInfo(5));
            departmentList.add(DepartmentModel.getInfo(13));
            departmentList.addAll(DepartmentModel.getDeptListByType(1));
            departmentList.addAll(DepartmentModel.getDeptListByType(3));
        } else if ("query".equals(this.showDirectList)) {
            departmentList.add(DepartmentModel.getInfo(5));
            departmentList.addAll(DepartmentModel.getDeptListByType(3));
        } else if ("query".equals(this.showShopList)) {
            departmentList.add(DepartmentModel.getInfo(13));
            departmentList.addAll(DepartmentModel.getDeptListByType(1));
        } else{
            departmentList.add(DepartmentModel.getInfo(UserHelper.getUserCache().getDeptId()));
            getWorkMateById(UserHelper.getUserCache().getDeptId(), departmentList);
        }

        List<AddSalesReport> addSalesReportList = new ArrayList<AddSalesReport>();
        for(Department department:departmentList){
            if(department.getDeptType()== DeptHelper.TYEP_CHANNEL){
                continue;
            }
            List<Integer> empNosBydept = getEmpNosBydeptRecursive(department.getId());
            if(empNosBydept.size()!=0){
                p2pSalesCondition.setEmpNos(StringHelper.listToString(empNosBydept));
                otherSalesCondition.setEmpNos(StringHelper.listToString(empNosBydept));
            }else{
                p2pSalesCondition.setEmpNos("-1");
                otherSalesCondition.setEmpNos("-1");
            }
            long deptP2pSalesMoneylong = SalesModel.getP2pSumMoney(p2pSalesCondition)==null?0:SalesModel.getP2pSumMoney(p2pSalesCondition);
            long deptOtherSalesMoneylong = SalesModel.getP2pSumMoney(otherSalesCondition)==null?0:SalesModel.getP2pSumMoney(otherSalesCondition);
            long deptAllSalesMoneylong = deptP2pSalesMoneylong + deptOtherSalesMoneylong;
            if(deptAllSalesMoneylong==0) {
                continue;
            }
            AddSalesReport deptAddSalesReport = null;
            if(department.getParentNo()==1){
                deptAddSalesReport = insertReport(department.getId(),0,department.getName(),
                        deptP2pSalesMoneylong,deptOtherSalesMoneylong,deptAllSalesMoneylong);
            }else{
                deptAddSalesReport = insertReport(department.getId(),department.getParentNo(),department.getName(),
                        deptP2pSalesMoneylong,deptOtherSalesMoneylong,deptAllSalesMoneylong);
            }
            addSalesReportList.add(deptAddSalesReport);
            String empNos = StringHelper.listToString(getEmpNosBydept(department.getId()));
            if(empNos==null||empNos==""){
                continue;
            }
            salesCondition.setEmpNos(empNos);
            List<Sales> salesList = SalesModel.getSumMoneyGroupByEmp(salesCondition);
            for(Sales sales:salesList){
                Employee employee = EmployeeModel.getEmpByUserId(sales.getEmpNo());
                p2pSalesCondition.setEmpNos(String.valueOf(employee.getUserNo()));
                otherSalesCondition.setEmpNos(String.valueOf(employee.getUserNo()));
                long p2pSalesMoney = SalesModel.getP2pSumMoney(p2pSalesCondition)==null?0:SalesModel.getP2pSumMoney(p2pSalesCondition);
                long otherSalesMoney = SalesModel.getP2pSumMoney(otherSalesCondition)==null?0:SalesModel.getP2pSumMoney(otherSalesCondition);
                AddSalesReport addSalesReport = insertReport(Integer.parseInt("10"+String.valueOf(employee.getId())),
                        employee.getDeptNo(),employee.getName(),p2pSalesMoney,otherSalesMoney,sales.getMoney());
                addSalesReportList.add(addSalesReport);
            }
        }
        this.rows = addSalesReportList;
        return SUCCESS;
    }
    private AddSalesReport insertReport(int id,int parentNo,String eleName,long p2pSalesMoney,long otherSalesMoney,long addTotalMoney){
        AddSalesReport empAddSalesReport = new AddSalesReport();
        empAddSalesReport.setId(id);
        empAddSalesReport.set_parentId(parentNo);
        empAddSalesReport.setElementName(eleName);
        empAddSalesReport.setAddTotalMoney(addTotalMoney);
        empAddSalesReport.setP2pSalesMoney(p2pSalesMoney);
        empAddSalesReport.setOtherSalesMoney(otherSalesMoney);
        return empAddSalesReport;
    }
    private void getWorkMateById(int id, List<Department> departmentList) {
        List<Department> departmentWorkMate = DepartmentModel.getDeptListByParentNo(id);
        if (departmentWorkMate != null && departmentWorkMate.size() > 0) {
            departmentList.addAll(departmentWorkMate);
            for (Department WorkMate : departmentWorkMate) {
                this.getWorkMateById(WorkMate.getId(), departmentList);
            }
        }
    }

    private void getEmpNosByDept(int deptno,List<Employee> employeeList){
        List<Employee> empList = EmployeeModel.getEmpListByDept(deptno);
        employeeList.addAll(empList);
        List<Department> departmentList = DepartmentModel.getDeptListByParentNo(deptno);
        if (departmentList != null && departmentList.size() > 0) {
            for(Department department:departmentList){
                this.getEmpNosByDept(department.getId(),employeeList);
            }
        }

    }

}
