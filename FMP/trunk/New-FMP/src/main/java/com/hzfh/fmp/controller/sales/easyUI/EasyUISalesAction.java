package com.hzfh.fmp.controller.sales.easyUI;

import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.query.SalesCondition;
import com.hzfh.fmp.controller.common.EasyUIBaseAction;
import com.hzfh.fmp.model.common.enumeration.ProductType;
import com.hzfh.fmp.model.common.helper.ExcelHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.properties.DeptHelper;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.product.P2pProductModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.ArrayHelper;
import com.hzframework.helper.StringHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class EasyUISalesAction extends EasyUIBaseAction<Sales> {
    private int status;
    private int productType;
    private int productNo;
    private int peopleType;
    private int peopleNo;
    private String deptNo;
    private int empNo;
    private String customerName;
    private String isExpire;
    private int payType;
    private String showAllList;
    private String showDirectList;
    private String showChannelList;
    private String showShopList;
    private String showSalesListForP2p;

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

    public String getShowSalesListForP2p() {
        return showSalesListForP2p;
    }

    public void setShowSalesListForP2p(String showSalesListForP2p) {
        this.showSalesListForP2p = showSalesListForP2p;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public int getPeopleType() {
        return peopleType;
    }

    public void setPeopleType(int peopleType) {
        this.peopleType = peopleType;
    }

    public int getPeopleNo() {
        return peopleNo;
    }

    public void setPeopleNo(int peopleNo) {
        this.peopleNo = peopleNo;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIsExpire() {
        return isExpire;
    }

    public void setIsExpire(String isExpire) {
        this.isExpire = isExpire;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    @Override
    public String execute() throws Exception {
        PagedList<Sales> salesPagedList = SalesModel.getPagingList(this.getCondition());
        this.setRows(salesPagedList.getResultList());
        this.setTotal(salesPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
    public SalesCondition getCondition(){
        SalesCondition salesCondition = new SalesCondition();
        salesCondition.setPageSize(this.getPageSize());
        salesCondition.setPageIndex(this.getPage());
        if (!StringHelper.isNullOrEmpty(this.customerName)) {
            salesCondition.setCustomerName(this.customerName);
        }else {
            if ("query".equals(this.showAllList)) {
                salesCondition.setWorkMateString(null);
            } else if ("query".equals(this.showDirectList)) {
                salesCondition.setWorkMateString(this.getEmpStringByDeptType(DeptHelper.TYEP_DIRECT));
            } else if ("query".equals(this.showChannelList)) {
                salesCondition.setWorkMateString(this.getEmpStringByDeptType(DeptHelper.TYEP_CHANNEL));
            } else if ("query".equals(this.showShopList)) {
                salesCondition.setWorkMateString(this.getEmpStringByDeptType(DeptHelper.TYEP_SHOP));
            } else if("query".equals(this.showSalesListForP2p)){
                salesCondition.setProductType(ProductType.P2P);
            }
            else {
                List<Integer> workMate = UserHelper.getUserCache().getWorkMate();
                if (workMate != null) {
                    workMate.add(UserHelper.getUserCache().getUserId());
                    String workMateString = StringHelper.listToString(workMate);
                    salesCondition.setWorkMateString(workMateString);
                } else {
                    salesCondition.setWorkMateString(String.valueOf(UserHelper.getUserCache().getUserId()));
                }
            }
        }
        if (!StringHelper.isNullOrEmpty(this.deptNo)){
            List<Department> departmentList = new ArrayList<Department>();
            getWorkMateById(Integer.valueOf(this.deptNo), departmentList);
            List<Integer> workMate = new ArrayList<Integer>();
            for (Department department : departmentList) {
                workMate.add(department.getId());
            }
            workMate.add(Integer.valueOf(this.deptNo));
            salesCondition.setByDeptNo(StringHelper.listToString(workMate));
        }
        if (!StringHelper.isNullOrEmpty(String.valueOf(this.productType)) ){
            salesCondition.setProductType(this.productType);
        }
        if (!StringHelper.isNullOrEmpty(String.valueOf(this.productNo))) {
            salesCondition.setProduct(this.productNo);
        }

        if (!StringHelper.isNullOrEmpty(String.valueOf(this.peopleType)) ){
            salesCondition.setAgentType(this.peopleType);
        }
        if (!StringHelper.isNullOrEmpty(String.valueOf(this.peopleNo)) ){
            salesCondition.setAgent(this.peopleNo);
        }
        if (!StringHelper.isNullOrEmpty(this.getIsTest())) {
            salesCondition.setIsTest(Byte.valueOf(this.getIsTest()));
        } else {
            salesCondition.setIsTest((byte) 0);
        }

        if (!StringHelper.isNullOrEmpty(String.valueOf(this.status)) ){
            salesCondition.setStatus(this.status);
        }
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");

        if (!StringHelper.isNullOrEmpty(this.isExpire)&&this.isExpire.equals("true")) {
            salesCondition.setRepaymentDate(sdf.format(new Date()));
        }
        if (!StringHelper.isNullOrEmpty(String.valueOf(this.empNo))) {
            salesCondition.setByEmpNo(this.empNo);
        }
        if (!StringHelper.isNullOrEmpty(String.valueOf(this.payType)) ){
            salesCondition.setPayType(this.payType);
        }

        List<SortItem> sortItemList = new ArrayList<>();

        for (SortItem sortItem : this.getSortList()) {
            SortItem newSortItem = new SortItem();
            newSortItem.setSortFeild(sortItem.getSort());
            newSortItem.setSortType("asc".equalsIgnoreCase(sortItem.getOrder()) ? SortType.ASC : SortType.DESC);
            sortItemList.add(newSortItem);
        }
        salesCondition.setSortItemList(sortItemList);
        return salesCondition;
    }
    public String exportExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.getExcelForSales(this.getCondition());
        return null;
    }
    private String getEmpStringByDeptType(int deptType) {
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
    private void getWorkMateById(int id, List<Department> departmentList) {
        List<Department> departmentWorkMate = DepartmentModel.getDeptListByParentNo(id);
        if (departmentWorkMate != null && departmentWorkMate.size() > 0) {
            departmentList.addAll(departmentWorkMate);
            for (Department WorkMate : departmentWorkMate) {
                this.getWorkMateById(WorkMate.getId(), departmentList);
            }
        }
    }

}
