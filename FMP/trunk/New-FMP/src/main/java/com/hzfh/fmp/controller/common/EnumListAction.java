package com.hzfh.fmp.controller.common;

import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.customer.model.query.CustomerPersonalCondition;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.DeptYearNeed;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.fmp.model.common.EnumListCacheModel;
import com.hzfh.fmp.model.common.enumeration.PaymentType;
import com.hzfh.fmp.model.common.enumeration.ProductStatus;
import com.hzfh.fmp.model.common.enumeration.StatusType;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.properties.DeptHelper;
import com.hzfh.fmp.model.common.properties.DictionaryHelper;
import com.hzfh.fmp.model.common.view.ListItem;
import com.hzfh.fmp.model.employee.CompanyModel;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.employee.DeptYearNeedModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.employee.PositionModel;
import com.hzframework.helper.ArrayHelper;
import com.hzframework.helper.StringHelper;

public class EnumListAction extends JsonBaseAction {

    private List<ListItem> listItems;
    private String type;
    private String param1;
    private String param2;
    private String value;


    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public List<ListItem> getListItems() {
        return listItems;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    /**
     * 注意注意注意注意注意注意注意注意注意注意注意注意注意
     * 再添加 case "XXX" 的时候请务必先全类查询一下。
     * 以确保其唯一
     */

    @Override
    public String execute() throws Exception {
        switch (this.type) {
            case "bannerLocationList":
                listItems = EnumListCacheModel.getBannerLocationList(true);
                return SUCCESS;
            case "bannerLocationListAll":
                listItems = EnumListCacheModel.getBannerLocationList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
        }
        switch (this.type) {
            case "status":
                listItems = new ArrayList<ListItem>();
                listItems.add(new ListItem("有效", "1"));
                listItems.add(new ListItem("无效", "0"));
                return SUCCESS;
            case "isYes":
                listItems = new ArrayList<ListItem>();
                listItems.add(new ListItem("是", "1"));
                listItems.add(new ListItem("否", "0"));
                return SUCCESS;
            case "isYesAll":
                listItems = new ArrayList<ListItem>();
                listItems.add(new ListItem("是", "1"));
                listItems.add(new ListItem("否", "0"));
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "myself":
                listItems = new ArrayList<ListItem>();
                String empId = String.valueOf(UserHelper.getUserCache().getEmpId());
                String empName = UserHelper.getUserCache().getEmpName();
                listItems.add(0, new ListItem(empName, empId));
                return SUCCESS;
            // to be continue
        }

        /**
         * permission here
         * */
        switch (this.type) {
            case "role":
                listItems = EnumListCacheModel.getRoleList(true);
                return SUCCESS;
            case "roleAll":
                listItems = EnumListCacheModel.getRoleList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            // 通过用户ID查用户对应的角色roles mengchong 2015/2/9
            case "roleByUserId":
                listItems = EnumListCacheModel.getRolesByUserId(param1, false);
                return SUCCESS;
            case "unAssignRoles":
                listItems = EnumListCacheModel.getUnAssignRoles(param1, false);
                return SUCCESS;
            case "user":
                listItems = EnumListCacheModel.getUserList(true);
                return SUCCESS;
            case "userForNew":
                listItems = EnumListCacheModel.getUnusedUserList(true);
                listItems.add(0, new ListItem("暂无用户", "0"));
                return SUCCESS;
            case "userAll":
                listItems = EnumListCacheModel.getUserList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            // to be continue
        }

        /**
         * customer here
         * */
        switch (this.type) {
            case "myCustomerPerson":
                listItems = new ArrayList<ListItem>();
                listItems = EnumListCacheModel.getMycustomerPersonList(true);
                return SUCCESS;
            case "myCustomerPersonAll":
                listItems = new ArrayList<ListItem>();
                listItems = EnumListCacheModel.getMycustomerPersonList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "myCustomerPerson1":
                listItems = new ArrayList<ListItem>();
                listItems = EnumListCacheModel.getMycustomerPersonList1(false);
                return SUCCESS;

            case "myCustomerPersonAll1":
                listItems = new ArrayList<ListItem>();
                listItems = EnumListCacheModel.getMycustomerPersonList1(false);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "customerPerson":
                if(!StringHelper.isNullOrEmpty(this.param1) && !"0".equals(this.param1)){
                    listItems = EnumListCacheModel.getCustomerPersonList(this.param1,true);
                }
                return SUCCESS;
            case "myCustomerCompany":
                listItems = new ArrayList<ListItem>();
                listItems = EnumListCacheModel.getMyCustomerCompanyList(true);
                return SUCCESS;
            case "myCustomerCompany1":
                listItems = new ArrayList<ListItem>();
                listItems = EnumListCacheModel.getMyCustomerCompanyList1(false);
                return SUCCESS;
            case "myCustomerCompanyAll":
                listItems = new ArrayList<ListItem>();
                listItems = EnumListCacheModel.getMyCustomerCompanyList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "customerCompany":
                listItems = EnumListCacheModel.getCustomerCompanyList(true);
                return SUCCESS;
            case "customerCompanyAll":
                listItems = EnumListCacheModel.getCustomerCompanyList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "myAgentBusiness":
                listItems = new ArrayList<ListItem>();
                listItems = EnumListCacheModel.getMyAgentBusiness(true);
                return SUCCESS;
            case "myAgentBusinessAll":
                listItems = new ArrayList<ListItem>();
                listItems = EnumListCacheModel.getMyAgentBusiness(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "customerAgentBusiness":
                listItems = EnumListCacheModel.getCustomerAgentBusinessList(true);
                return SUCCESS;
            case "customerAgentBusinessAll":
                listItems = EnumListCacheModel.getCustomerAgentBusinessList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "myAgentAdviser":
                listItems = new ArrayList<ListItem>();
                listItems = EnumListCacheModel.getMyAgentAdviser(true);
                return SUCCESS;
            case "myAgentAdviserAll":
                listItems = new ArrayList<ListItem>();
                listItems = EnumListCacheModel.getMyAgentAdviser(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "customerAgentAdviser":
                listItems = EnumListCacheModel.getCustomerAgentAdviserList(true);
                return SUCCESS;
            case "customerAgentAdviserAll":
                listItems = EnumListCacheModel.getCustomerAgentAdviserList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "agentBusiness":
                listItems = EnumListCacheModel.getAgentBusinessList(true);
                return SUCCESS;
            case "agentBusinessAll":
                listItems = EnumListCacheModel.getAgentBusinessList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "agentAdviser":
                listItems = EnumListCacheModel.getAgentAdviser(true);
                return SUCCESS;
            case "agentAdviserAll":
                listItems = EnumListCacheModel.getAgentAdviser(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "p2pCustomerList":
                listItems = EnumListCacheModel.getP2pCustomerList(true);
                return SUCCESS;
            case "p2pCustomerListRealName":
                listItems = EnumListCacheModel.getP2pCustomerListRealName(true);
                return SUCCESS;
            case "p2pCustomerListWithRealName":
                listItems = EnumListCacheModel.p2pCustomerListWithRealName(true);
                return SUCCESS;
            case "p2pCustomerListAll":
                listItems = EnumListCacheModel.getP2pCustomerList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;

            case "creditorList":
                listItems = EnumListCacheModel.getCreditorList(false);
                listItems.add(0, new ListItem("请选择", "0"));
                return SUCCESS;
            case "creditorListByProduct":
                listItems = EnumListCacheModel.getCreditorListByProductNo(param1, false);
                listItems.add(0, new ListItem("请选择", "0"));
                return SUCCESS;
            // to be continue
        }

        /**
         * product here
         * */
        switch (this.type) {
            case "productList":
                listItems = EnumListCacheModel.getProductList(true);
                return SUCCESS;
            case "productListAll":
                listItems = EnumListCacheModel.getProductList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "productNo":
                byte type = Byte.valueOf(this.param1);
                listItems = EnumListCacheModel.getProductListByType(type, true);
                return SUCCESS;
            case "p2pProductNoList":
                type = (byte) 5;
                listItems = EnumListCacheModel.getProductListByType(type, false);
                return SUCCESS;
            case "productNoAll":
                type = Byte.valueOf(this.param1);
                listItems = EnumListCacheModel.getProductListByType(type, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "productListByStatus30ForCustomerFollow":
                listItems = EnumListCacheModel.getProductListByStatus(
                        ProductStatus.PREHEAT, ProductStatus.ON_SALE, true);
                listItems.add(0, new ListItem("未推荐", "0"));
                return SUCCESS;
            case "PartnerList":// The upstream cooperation Company list
                listItems = EnumListCacheModel.getPartnerList(true);
                return SUCCESS;
            case "PartnerListAll":
                listItems = EnumListCacheModel.getPartnerList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "productByTypeAndStatus":
                type = Byte.valueOf(this.param1);
                listItems = EnumListCacheModel.getProductByTypeAndStatus(type,
                        ProductStatus.ON_SALE, false);
                return SUCCESS;
            case "p2pProductByTypeAndStatus":
                type = (byte) 5;
                listItems = EnumListCacheModel.getProductByTypeAndStatus(type,
                        ProductStatus.ON_SALE, false);
                return SUCCESS;
            case "p2pProduct":
                type = (byte) 5;
                listItems = EnumListCacheModel.getP2pProductByTypeAndStatus(type,
                        ProductStatus.ON_SALE, false);
                return SUCCESS;
            case "p2pProductByStatus":
                listItems = EnumListCacheModel.getP2pProductByStatus(ProductStatus.ON_SALE, true);
                return SUCCESS;
            case "productByTypeAndStatusAll":
                type = Byte.valueOf(this.param1);
                listItems = EnumListCacheModel.getProductByTypeAndStatus(type,
                        ProductStatus.ON_SALE, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "issuerNo":
                listItems = EnumListCacheModel.getIssuerList(true);
                return SUCCESS;
            case "issuerNoAll":
                listItems = EnumListCacheModel.getIssuerList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "financierPersonal":
                listItems = EnumListCacheModel.getFinancierPersonalList(true);
                return SUCCESS;
            case "financierPersonalAll":
                listItems = EnumListCacheModel.getFinancierPersonalList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "FinancierBusiness":
                listItems = EnumListCacheModel.getFinancierBusinessList(true);
                return SUCCESS;
            case "FinancierBusinessAll":
                listItems = EnumListCacheModel.getFinancierBusinessList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "p2pProductList":
                listItems = EnumListCacheModel.getP2pProductList(true);
                return SUCCESS;
            case "p2pProductListAll":
                listItems = EnumListCacheModel.getP2pProductList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "p2pProductRepayIssue":
                listItems = EnumListCacheModel.getDicDataListByType(45, true);
                return SUCCESS;
            // to be continue
        }

        /**
         * sales here
         * */
        switch (this.type) {
            case "salesList":
                listItems = EnumListCacheModel.getSalesList(true);
                return SUCCESS;
            case "salesListAll":
                listItems = EnumListCacheModel.getSalesList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "empDirectorSales":
                // listItems.add(1, new ListItem("","1"));
                return SUCCESS;
            case "empDirectorSalesAll":
                listItems = new ArrayList<ListItem>();
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            // to be continue
        }

        /**
         * baseInfo here
         * */

        switch (this.type) {
            case "province":
                listItems = EnumListCacheModel.getProvinceList(true);
                return SUCCESS;
            case "provinceAll":
                listItems = EnumListCacheModel.getProvinceList(true);
                listItems.add(0, new ListItem("未选择", "0"));
                return SUCCESS;
            case "city":
                listItems = EnumListCacheModel.getCityList(true);
                return SUCCESS;
            case "cityAll":
                listItems = EnumListCacheModel.getCityList(true);
                listItems.add(0, new ListItem("未选择", "0"));
                return SUCCESS;
            case "district":
                listItems = EnumListCacheModel.getDistrictList(true);
                return SUCCESS;
            case "districtAll":
                listItems = EnumListCacheModel.getDistrictList(true);
                listItems.add(0, new ListItem("未选择", "0"));
                return SUCCESS;
            case "cityLink":
                int p = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getCityListByProvince(p, true);
                return SUCCESS;
            case "cityLinkAll":
                p = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getCityListByProvince(p, true);
                listItems.add(0, new ListItem("未选择", "0"));
                return SUCCESS;
            case "districtLink":
                int c = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getDistrictListByCity(c, true);
                return SUCCESS;
            case "districtLinkAll":
                c = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getDistrictListByCity(c, true);
                listItems.add(0, new ListItem("未选择", "0"));
                return SUCCESS;
            // to be continue
        }

        /*switch (this.type) {// workflow mengchong 2015/05/18
            case "assignGroups":
                listItems = EnumListCacheModel.getAssignGroupList(param1, true);
                return SUCCESS;
            case "unAssignGroups":
                listItems = EnumListCacheModel.getUnAssignGroups(param1, true);
                return SUCCESS;
            // to be continue
        }*/

        /**
         * employee here
         */

        switch (this.type) {
            case "empManager": // 负责人(绑定userId，empName)
                listItems = EnumListCacheModel.getEmpListByParentNo(true);
                listItems.add(
                        0,
                        new ListItem(UserHelper.getUserCache().getEmpName(), String
                                .valueOf(UserHelper.getUserCache().getUserId())));
                return SUCCESS;
            case "empManagerAll":
                listItems = new ArrayList<ListItem>();
                listItems = EnumListCacheModel.getEmpListByParentNo(true);
                listItems.add(0, new ListItem("全部", "0"));
                listItems.add(1,new ListItem(UserHelper.getUserCache().getEmpName(), String.valueOf(UserHelper.getUserCache().getUserId())));
                return SUCCESS;
            case "empListById": // (Id，Name)
                listItems = EnumListCacheModel.getEmpListById(true);
                return SUCCESS;
            case "empListByIdAll": // (Id，Name)
                listItems = EnumListCacheModel.getEmpListById(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "empList":// emplist(userNo,name)
                listItems = EnumListCacheModel.getEmpList(true);
                listItems.add(0, new ListItem("", "0"));
                return SUCCESS;
            case "empManagerListByDept":
                int empManagerDept = Integer.parseInt(this.param1);
                listItems = EnumListCacheModel.empManagerListByDept(empManagerDept, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "empManagerListByStatus1":
                int empManagerStatus = Integer.parseInt(this.param1);
                listItems = EnumListCacheModel.empManagerListByStatus(empManagerStatus, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "empManagerListByStatus":
                int empManagerStatus1 = Integer.parseInt(this.param1);
                listItems = EnumListCacheModel.empManagerListByStatus(empManagerStatus1, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "empListJq":
                listItems = EnumListCacheModel.getEmpListNoTest(true);
                listItems.add(0, new ListItem("", "0"));
                return SUCCESS;
            case "empListJqQ":
                listItems = EnumListCacheModel.getEmpListNoTest(true);
                listItems.add(0, new ListItem("全体员工", "0"));
                return SUCCESS;
            case "empListAllJq":
                listItems = EnumListCacheModel.getEmpList(true);
                listItems.add(0, new ListItem("", "0"));
                listItems.add(0, new ListItem("全部", "-1"));
                return SUCCESS;
            case "empListAllJqQ":
                listItems = EnumListCacheModel.getEmpList(true);
                listItems.add(0, new ListItem("全体员工", "0"));
                listItems.add(0, new ListItem("全部", "-1"));
                return SUCCESS;
            case "empListAll":
                listItems = EnumListCacheModel.getEmpList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "empListForEmp":// emplist(id,name)
                listItems = EnumListCacheModel.getEmpListForEmp(true);
                return SUCCESS;
            case "empListForEmp1":// emplist(id,name)
                listItems = EnumListCacheModel.getEmpListForEmp(true);
                listItems.add(0, new ListItem("请选择", "0"));
                return SUCCESS;
            case "empListForEmpAll":
                listItems = EnumListCacheModel.getEmpListForEmp(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "empNo":// get Manager by department
                int deptNo = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getEmpListByDept(deptNo, true);
                return SUCCESS;
            case "empNo1":// get Manager by department
                deptNo = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getEmpListByDept(deptNo, true);
                listItems.add(0, new ListItem("请选择", "0"));
                return SUCCESS;
            case "empNoAll":
                deptNo = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getEmpListByDept(deptNo, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "empListByPositionNo":
                int positionNo = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getEmpListByPositionNo(positionNo, true);
                return SUCCESS;
            case "empListByPositionNo1":
                positionNo = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getEmpListByPositionNo(positionNo, true);
                listItems.add(0, new ListItem("请选择", "0"));
                return SUCCESS;
            case "employeeManagerByDept":// get Manager by department and
                // department's parent' department
                int deptNo1 = 0;
                if (!StringHelper.isNullOrEmpty(this.param1)) {
                    deptNo1 = Integer.valueOf(this.param1);
                }
                listItems = EnumListCacheModel.getEmployeeManagerByDept(deptNo1, true);
                return SUCCESS;
            case "employeeManagerByDeptAll":
                deptNo1 = 0;
                if (!StringHelper.isNullOrEmpty(this.param1)) {
                    deptNo1 = Integer.valueOf(this.param1);
                }
                listItems = EnumListCacheModel.getEmployeeManagerByDept(deptNo1, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "productManagerNo":
                listItems = EnumListCacheModel.getEmpListByDept(6, true);
                return SUCCESS;
            case "productManagerNoAll":
                listItems = EnumListCacheModel.getEmpListByDept(6, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "zhixiaoEmp":
                listItems = EnumListCacheModel.getEmpListByDept(11, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "zhixiaoEmpAll":
                listItems = EnumListCacheModel.getEmpListByDept(11, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "empCompanylist":
                listItems = EnumListCacheModel.getCompanylistFromEmp(true);
                return SUCCESS;
            case "empCompanylist1":
                listItems = EnumListCacheModel.getCompanylistFromEmp(true);
                listItems.add(0, new ListItem("请选择", "0"));
                return SUCCESS;
            case "empCompanylistAll":
                listItems = EnumListCacheModel.getCompanylistFromEmp(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "dept":
                listItems = EnumListCacheModel.getDeptList(true);
                return SUCCESS;
            case "dept1":
                listItems = EnumListCacheModel.getDeptList(true);
                listItems.add(0, new ListItem("请选择", "0"));
                return SUCCESS;
            case "deptAll":
                listItems = EnumListCacheModel.getDeptList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "deptForCustomerAll":
                listItems = EnumListCacheModel.deptSubForCustomer(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "myDept":
                listItems = new ArrayList<ListItem>();
                String deptName = UserHelper.getUserCache().getDeptName();
                String deptId = String.valueOf(UserHelper.getUserCache()
                        .getDeptId());
                listItems.add(0, new ListItem(deptName, deptId));
                return SUCCESS;
            case "extendEmp":
                listItems = EnumListCacheModel.getExtendEmp(true);
                return SUCCESS;
            case "drawAwards":
                listItems = EnumListCacheModel.getDrawAwards(false);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "deptByParent":
                int deptParentNo = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getDeptListByParentNo(deptParentNo, true);
                return SUCCESS;
            case "deptByParentAll":
                deptParentNo = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getDeptListByParentNo(deptParentNo, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "positionList":
                listItems = EnumListCacheModel.getPositionList(true);
                return SUCCESS;
            case "positionListAll":
                listItems = EnumListCacheModel.getPositionList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "positionListAll1":
                listItems = EnumListCacheModel.getPositionList(true);
                listItems.add(0, new ListItem("请选择", "0"));
                return SUCCESS;
            case "positionLevelList":
                listItems = EnumListCacheModel.getPositionLevelList(true);
                return SUCCESS;
            case "positionLe                velAll":
                listItems = EnumListCacheModel.getPositionLevelList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "deptListByCompany":
                int companyNo = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getDeptListByCompanyNo(companyNo, true);
                return SUCCESS;
            case "deptListByCompany1":
                companyNo = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getDeptListByCompanyNo(companyNo, true);
                listItems.add(0, new ListItem("请选择", "0"));
                return SUCCESS;
            case "deptListByCompanyAll":
                companyNo = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getDeptListByCompanyNo(companyNo, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "positionLevelListByDept":
                int d = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getPositionListBydept(d, true);
                return SUCCESS;
            case "positionLevelListByDeptAll":
                d = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getPositionLevelListByDept(d, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "positionListBydept":
                int de = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getPositionLevelListByDept(de, true);
                return SUCCESS;
            case "deptListByType":
                int deptTypeT = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getDeptListByType(deptTypeT, true);
                if (deptTypeT == 3) {
                    listItems.remove(0);
                }
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "positionListBydept1":
                int d1 = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getPositionListBydept(d1, true);
                return SUCCESS;
            case "deptYearNeedByYear":
                int y = Integer.valueOf(this.param1);
                List<DeptYearNeed> deptYearNeeds = DeptYearNeedModel
                        .getListByYear(y);
                for (int i = 0; i < deptYearNeeds.size(); i++) {
                    Department dept = DepartmentModel.getInfo(deptYearNeeds.get(i)
                            .getDeptNo());
                    deptYearNeeds.get(i).setDeptName(dept.getName());
                }
                return SUCCESS;
            case "positionListBydeptAll":
                de = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getPositionListBydept(de, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "positionListBydeptTypeAll":
                int deNo = Integer.valueOf(this.param1);
                int deptType = 0;
                List<Department> deptList = DepartmentModel.getList();
                for (int i = 0; i < deptList.size(); i++) {
                    if (deNo == deptList.get(i).getId()) {
                        deptType = deptList.get(i).getDeptType();
                        return SUCCESS;
                    }
                }
                listItems = EnumListCacheModel.getPositionListBydept(deptType, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "suppliersList":
                listItems = EnumListCacheModel.getSuppliers(true);
                return SUCCESS;
            case "suppliersListAll":
                listItems = EnumListCacheModel.getSuppliers(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "positionListBydeptType1":
                int deNo1 = Integer.valueOf(this.param1);
                int deptType1 = DepartmentModel.getInfo(deNo1).getDeptType();
                listItems = EnumListCacheModel.getPositionListBydept(deptType1, true);
                return SUCCESS;
            case "positionListBydeptType2":
                if (param1 != null && !"".equals(param1) && !"0".equals(param1)) {
                    deNo1 = Integer.valueOf(this.param1);
                    deptType1 = DepartmentModel.getInfo(deNo1).getDeptType();
                    listItems = EnumListCacheModel.getPositionListBydept(deptType1, true);
                } else {
                    listItems = EnumListCacheModel.getPositionListBydept(0, true);
                }
                listItems.add(0, new ListItem("请选择", "0"));
                return SUCCESS;
            case "positionNo":
                byte type = Byte.valueOf(this.param1);
                listItems = EnumListCacheModel.getPositionByDept(type, true);
                return SUCCESS;
            case "positionNoAll":
                deptNo = Integer.valueOf(this.param1);
                listItems = EnumListCacheModel.getPositionByDept(deptNo, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "store": // 门店
                listItems = EnumListCacheModel.getStoreList(true);
                return SUCCESS;
            case "storeAll":
                listItems = EnumListCacheModel.getStoreList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "wealthManagers":// 理财经理
                byte storeNo = 0;
                if (this.param1 != null) {
                    storeNo = Byte.valueOf(this.param1);
                }
                listItems = EnumListCacheModel.getWealthManagerListByStore(storeNo, true);
                return SUCCESS;
            case "wealthManagersIsUse":// 理财经理
                byte storeNoIs = 0;
                if (this.param1 != null) {
                    storeNoIs = Byte.valueOf(this.param1);
                }
                listItems = EnumListCacheModel.getWealthManagerListByStoreIsUse(storeNoIs, true);
                return SUCCESS;
            case "wealthManagersAll":
                storeNo = 0;
                if (this.param1 != null) {
                    storeNo = Byte.valueOf(this.param1);
                }
                listItems = EnumListCacheModel.getWealthManagerListByStore(storeNo, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "deptTypeBydeptNo":
                deptNo = Integer.parseInt(this.param1);
                listItems = EnumListCacheModel.getDeptTypeBydeptNo(deptNo, true);
                return SUCCESS;
            case "deptTypeBydeptNoAll":
                type = Byte.parseByte(this.param1);
                listItems = EnumListCacheModel.getDeptTypeBydeptNo(type, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "wealthManagersByUserNo":
                listItems = EnumListCacheModel.getWealthManagerListByUserNo(true);
                listItems.add(0, new ListItem("无", "0"));
                return SUCCESS;
            case "recipientList":
                listItems = EnumListCacheModel.getRecipientList(true);
                return SUCCESS;
            case "recipientListAll":
                listItems = EnumListCacheModel.getRecipientList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "empCompanylistToTree":
                listItems = EnumListCacheModel.getCompanylistFromEmpToTree(true);
                return SUCCESS;
            case "deptlistToTree":
                listItems = EnumListCacheModel.getDeptlistToTree(true);
                return SUCCESS;
            case "positionlistToTree":
                listItems = EnumListCacheModel.getPositionlistToTree(true);
                return SUCCESS;
            case "employeeListToTree":
                listItems = EnumListCacheModel.getEmployeeTree(param1, true, param2);
                return SUCCESS;
            case "valueToInputById":
                if (StringHelper.isNullOrEmpty(param1) || "0".equals(param1))
                    return SUCCESS;
                if ("empNo".equals(param2))
                    value = EmployeeModel.getInfo(Integer.valueOf(param1)).getName();
                if ("userNo".equals(param2))
                    value = EmployeeModel.getEmpByUserId(Integer.valueOf(param1)).getName();
                if ("positionNo".equals(param2))
                    value = PositionModel.getInfo(Integer.valueOf(param1)).getName();
                if ("deptNo".equals(param2))
                    value = DepartmentModel.getInfo(Integer.valueOf(param1)).getName();
                if ("companyNo".equals(param2))
                    value = CompanyModel.getInfo(Integer.valueOf(param1)).getName();
                return SUCCESS;
            case "employeeVerifyAll":
                listItems = EnumListCacheModel.getDicDataListByType(49, true);
                listItems.add(0, new ListItem("全部", "-1"));
                // to be continue
        }

        /**
         * dictionary here
         * */
        switch (this.type) {
            case "dicTypeNoAll":
                listItems = EnumListCacheModel.getDicTypeNoList(true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "dicDicDataForEmployeeSex":// sex for employee
                listItems = EnumListCacheModel.getDicDataListByType(1, true);
                return SUCCESS;
            case "dicDicDataForEmployeeSexAll":
                listItems = EnumListCacheModel.getDicDataListByType(1, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "payType":
                listItems = EnumListCacheModel.getDicDataListByType(2, true);
                return SUCCESS;
            case "payTypeAll":
                listItems = EnumListCacheModel.getDicDataListByType(2, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "tendType":
                listItems = EnumListCacheModel.getDicDataListByType(3, true);
                return SUCCESS;
            case "tendTypeAll":
                listItems = EnumListCacheModel.getDicDataListByType(3, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "productType":
                listItems = EnumListCacheModel.getDicDataListByType(4, true);
                return SUCCESS;
            case "productTypeNotP2p":
                listItems = EnumListCacheModel.getDicDataListByType(4, true);
                listItems.remove(4);
                return SUCCESS;
            case "productTypeAll":
                listItems = EnumListCacheModel.getDicDataListByType(4, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "customerType":
                listItems = EnumListCacheModel.getDicDataListByType(5, true);
                return SUCCESS;
            case "customerTypeAll":
                listItems = EnumListCacheModel.getDicDataListByType(5, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "agentType":
                listItems = EnumListCacheModel.getDicDataListByType(6, true);
                return SUCCESS;
            case "agentTypeAll":
                listItems = EnumListCacheModel.getDicDataListByType(6, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            // sourceType
            case "customerSourcetype":
                listItems = EnumListCacheModel.getDicDataListByType(6, true);
                return SUCCESS;
            case "customerSourcetypeAll":
                listItems = EnumListCacheModel.getDicDataListByType(6, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "protocolStatusAll":
                listItems = EnumListCacheModel.getDicDataListByType(7, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "salesStatus":
                listItems = EnumListCacheModel.getDicDataListByType(7, true);
                return SUCCESS;
            case "salesStatusAll":
                listItems = EnumListCacheModel.getDicDataListByType(7, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "dicTypeNo":// dictionary type list
                listItems = EnumListCacheModel.getDicTypeNoList(true);
                return SUCCESS;
            case "contractType":
                listItems = EnumListCacheModel.getDicDataListByType(8, true);
                return SUCCESS;
            case "contractTypeAll":
                listItems = EnumListCacheModel.getDicDataListByType(8, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "dicDicDataForEmployeeMarry":// marital status
                listItems = EnumListCacheModel.getDicDataListByType(9, true);
                return SUCCESS;
            case "dicDicDataForEmployeeMarryAll":
                listItems = EnumListCacheModel.getDicDataListByType(9, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;

            case "employeeStatusAll":
                listItems = EnumListCacheModel.getDicDataListByType(10, true);
                return SUCCESS;
            case "employeeStatus":
                listItems = EnumListCacheModel.getDicDataListByType(10, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "dicDataforEmployeeDetailPositionStatus":// is one on the job?
                listItems = EnumListCacheModel.getDicDataListByType(10, true);
                return SUCCESS;
            case "dicDataforEmployeeDetailPositionStatusAll":
                listItems = EnumListCacheModel.getDicDataListByType(10, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "dicDataforCustomerCompanyAgentNo":
                listItems = EnumListCacheModel.getDicDataListByType(10, true);
                return SUCCESS;
            case "dicDataforCustomerCompanyAgentNoAll":
                listItems = EnumListCacheModel.getDicDataListByType(10, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;

            case "activityType":// customer relationship
                // level
                listItems = EnumListCacheModel.getDicDataListByType(53, true);
                return SUCCESS;
            case "activityTypeAll":// customer relationship
                // level
                listItems = EnumListCacheModel.getDicDataListByType(53, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "conditionRelation":// customer relationship
                // level
                listItems = EnumListCacheModel.getDicDataListByType(56, true);
                return SUCCESS;
            case "conditionDescription1":// customer relationship
                // level
                listItems = EnumListCacheModel.getDicDataListByType(63, true);
                return SUCCESS;
            case "conditionDescription2":// customer relationship
                // level
                listItems = EnumListCacheModel.getDicDataListByType(64, true);
                return SUCCESS;
            case "conditionDescription3":// customer relationship
                // level
                listItems = EnumListCacheModel.getDicDataListByType(65, true);
                return SUCCESS;
            case "conditionDescription4":// customer relationship
                // level
                listItems = EnumListCacheModel.getDicDataListByType(66, true);
                return SUCCESS;
            case "conditionDescription5":// customer relationship
                // level
                listItems = EnumListCacheModel.getDicDataListByType(67, true);
                return SUCCESS;
            case "conditionDescription6":// customer relationship
                // level
                listItems = EnumListCacheModel.getDicDataListByType(68, true);
                return SUCCESS;
            case "activityRewardType":// customer relationship
                // level
                listItems = EnumListCacheModel.getDicDataListByType(57, true);
                return SUCCESS;
            case "activityStatuses":// customer relationship
                // level
                listItems = EnumListCacheModel.getDicDataListByType(54, true);
                return SUCCESS;
            case "activityStatusesAll":// customer relationship
                // level
                listItems = EnumListCacheModel.getDicDataListByType(54, true);
                listItems.add(0, new ListItem("全部", "2"));
                return SUCCESS;
            case "isDisplay":// customer relationship
                // level
                listItems = EnumListCacheModel.getDicDataListByType(55, true);
                return SUCCESS;

            case "dicDataforCustomerCompanyRelationLevel":// customer relationship
                // level
                listItems = EnumListCacheModel.getDicDataListByType(11, true);
                return SUCCESS;
            case "dicDataforCustomerCompanyRelationLevelAll":
                listItems = EnumListCacheModel.getDicDataListByType(11, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "dicDataforCustomerCompanyRiskHobby":// Risk hobby
                listItems = EnumListCacheModel.getDicDataListByType(12, true);
                return SUCCESS;
            case "dicDataforCustomerCompanyRiskHobbyAll":
                listItems = EnumListCacheModel.getDicDataListByType(12, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;

            case "dicDataforCustomerCompanyCardType":// IdCard for everybody
                listItems = EnumListCacheModel.getDicDataListByType(13, true);
                return SUCCESS;
            case "dicDataforCustomerCompanyCardTypeAll":
                listItems = EnumListCacheModel.getDicDataListByType(13, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "dicDataforCustomerAgentBussinessImportance":
                listItems = EnumListCacheModel.getDicDataListByType(15, true);
                return SUCCESS;
            case "dicDataforCustomerAgentBussinessImportanceAll":
                listItems = EnumListCacheModel.getDicDataListByType(15, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "cusCompanyCardType":// customerCompanyCardType
                listItems = EnumListCacheModel.getDicDataListByType(14, true);
                return SUCCESS;
            case "cusCompanyCardTypeAll":
                listItems = EnumListCacheModel.getDicDataListByType(14, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "p2pProductPartStatus":
                listItems = EnumListCacheModel.getDicDataListByType(16, true);
                listItems.remove(0);
                listItems.remove(0);
                return SUCCESS;
            case "p2pProductPartStatusAll":
                listItems = EnumListCacheModel.getDicDataListByType(16, true);
                listItems.remove(0);
                listItems.remove(0);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "productStatus":
                listItems = EnumListCacheModel.getDicDataListByType(16, true);
                return SUCCESS;
            case "productStatusAll":
                listItems = EnumListCacheModel.getDicDataListByType(16, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "dicDataforProductpartnerIssuertype":
                listItems = EnumListCacheModel.getDicDataListByType(17, true);
                return SUCCESS;
            case "dicDataforProductpartnerIssuertypeAll":
                listItems = EnumListCacheModel.getDicDataListByType(17, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "upStreamType":
                listItems = EnumListCacheModel.getDicDataListByType(19, true);
                return SUCCESS;
            case "upStreamTypeAll":
                listItems = EnumListCacheModel.getDicDataListByType(19, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "protocolStatus":
                listItems = EnumListCacheModel.getDicDataListByType(21, true);
                return SUCCESS;
            case "taskStatus":
                listItems = new ArrayList<ListItem>();
                listItems = EnumListCacheModel.getDicDataListByType(22, true);
                return SUCCESS;
            case "taskStatusAll":
                listItems = new ArrayList<ListItem>();
                listItems = EnumListCacheModel.getDicDataListByType(22, true);
                listItems.add(0, new ListItem("全部", "-1"));
                return SUCCESS;
            case "quotaType":// 大小配额类型 mengc 2015/02/27
                listItems = EnumListCacheModel.getDicDataListByType(23, true);
                return SUCCESS;
            case "cusFollowType":// 跟踪类型 tony 2015/3/11
                listItems = EnumListCacheModel.getDicDataListByType(24, true);
                return SUCCESS;
            case "cusFollowTypeAll":
                listItems = EnumListCacheModel.getDicDataListByType(24, true);
                listItems.add(0, new ListItem("未选择", "0"));
                return SUCCESS;
            case "deptTypeFromDicData":
                listItems = EnumListCacheModel
                        .getDicDataListByType(DictionaryHelper.DIC_TYPE_DEPT_TYPE, true);
                return SUCCESS;
            case "deptTypeFromDicDataAll":
                listItems = EnumListCacheModel
                        .getDicDataListByType(DictionaryHelper.DIC_TYPE_DEPT_TYPE, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "deptType":
                listItems = EnumListCacheModel.getDicDataListByType(25, true);
                return SUCCESS;
            case "deptTypeAll":
                listItems = EnumListCacheModel.getDicDataListByType(25, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "assetsType":
                listItems = EnumListCacheModel.getDicDataListByType(73, true);
                return SUCCESS;
            case "assetsTypeAll":
                listItems = EnumListCacheModel.getDicDataListByType(73, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "assetsLocation":
                listItems = EnumListCacheModel.getDicDataListByType(74, true);
                return SUCCESS;
            case "assetsLocationAll":
                listItems = EnumListCacheModel.getDicDataListByType(74, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "assetsTypeGlobal":
                listItems = EnumListCacheModel.getDicDataListByType(75, true);
                return SUCCESS;
            case "assetsTypeGlobalAll":
                listItems = EnumListCacheModel.getDicDataListByType(75, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "assetsStatus":
                listItems = EnumListCacheModel.getDicDataListByType(76, true);
                return SUCCESS;
            case "assetsStatusAll":
                listItems = EnumListCacheModel.getDicDataListByType(76, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "p2pCustomerStatus":
                listItems = EnumListCacheModel.getDicDataListByType(26, true);
                return SUCCESS;
            // 预约状态
            case "orderStatus":
                listItems = EnumListCacheModel.getDicDataListByType(27, true);
                return SUCCESS;
            case "orderStatusAll":
                listItems = EnumListCacheModel.getDicDataListByType(27, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            // 优先级
            case "priority":
                listItems = EnumListCacheModel.getDicDataListByType(28, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;

            // getEmployeeByStatus Zorro 2015/5/28
            case "employeeStatusDuty":
                listItems = EnumListCacheModel
                        .getEmployeeByStatusAgainst(DictionaryHelper.DIC_EMPLOYEE_STATUS_DIMISSION, false, UserHelper.getUserCache().getUserId());
                return SUCCESS;
            case "employeeStatusDimission":
                listItems = EnumListCacheModel
                        .getEmployeeByStatus(DictionaryHelper.DIC_EMPLOYEE_STATUS_DIMISSION, false, UserHelper.getUserCache().getUserId());
                return SUCCESS;
            case "paymentRefundStatus":
                listItems = EnumListCacheModel
                        .getDicDataListByType(PaymentType.PAYMENTREFUND_DICTYPE, true);
                return SUCCESS;
            case "paymentRefundStatusAll":
                listItems = EnumListCacheModel
                        .getDicDataListByType(PaymentType.PAYMENTREFUND_DICTYPE, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "customerFollowResultStatus":
                listItems = EnumListCacheModel
                        .getDicDataListByType(StatusType.CUSTOMERFOLLOW_RESULTSTATUS, true);
                return SUCCESS;
            case "customerFollowResultStatusAll":
                listItems = EnumListCacheModel
                        .getDicDataListByType(StatusType.CUSTOMERFOLLOW_RESULTSTATUS, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "customerPersonalSourceTypeList":
                listItems = EnumListCacheModel
                        .getDicDataListByType(DictionaryHelper.DIC_CUSTOMER_SOURCE_TYPE, true);
                return SUCCESS;
            case "customerPersonalSourceTypeListAll":
                listItems = EnumListCacheModel
                        .getDicDataListByType(DictionaryHelper.DIC_CUSTOMER_SOURCE_TYPE, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "letterStatus":
                listItems = EnumListCacheModel.getDicDataListByType(30, true);
                return SUCCESS;
            case "letterStatusAll":
                listItems = EnumListCacheModel.getDicDataListByType(30, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "letterType":
                listItems = EnumListCacheModel.getDicDataListByType(31, true);
                return SUCCESS;
            case "letterTypeAll":
                listItems = EnumListCacheModel.getDicDataListByType(31, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "empEducationList":
                listItems = EnumListCacheModel.getDicDataListByType(33, true);
                listItems.add(0, new ListItem(" ", "0"));
                return SUCCESS;
            case "politicalStatus":
                listItems = EnumListCacheModel.getDicDataListByType(34, true);
                listItems.add(0, new ListItem(" ", "0"));
                return SUCCESS;
            case "empDegreeList":
                listItems = EnumListCacheModel.getDicDataListByType(35, true);
                listItems.add(0, new ListItem(" ", "0"));
                return SUCCESS;
            case "resumeSource":// 简历来源
                listItems = EnumListCacheModel.getDicDataListByType(36, true);
                //listItems.add(0, new ListItem("请选择", "0"));
                return SUCCESS;
            case "paymentMoneyRechargeState":// 充值状态
                listItems = EnumListCacheModel.getDicDataListByType(37, true);
                // listItems.add(0, new ListItem("请选择", "0"));
                return SUCCESS;
            case "paymentMoneyWithdrawState":// 提现状态
                listItems = EnumListCacheModel.getDicDataListByType(38, true);
                // listItems.add(0, new ListItem("请选择", "0"));
                return SUCCESS;
            case "dicDicDataForKnowledgeAll":// sex for employee
                listItems = EnumListCacheModel.getDicDataListByType(42, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "dicDicDataForKnowledge":// sex for employee
                listItems = EnumListCacheModel.getDicDataListByType(42, true);
                return SUCCESS;
            // to be continue
            case "dicDicDataAttendanceType":// sex for employee
                listItems = EnumListCacheModel.getDicDataListByType(43, true);
                return SUCCESS;
            case "dicDicDataAttendanceTypeAll":// sex for employee
                listItems = EnumListCacheModel.getDicDataListByType(43, true);
                listItems.add(0, new ListItem("全部", "-1"));
                return SUCCESS;
            case "dicDicDataAttendanceStatus":// sex for employee
                listItems = EnumListCacheModel.getDicDataListByType(44, true);
                return SUCCESS;
            case "dicDicDataAttendanceStatusAll":// sex for employee
                listItems = EnumListCacheModel.getDicDataListByType(44, true);
                listItems.add(0, new ListItem("全部", "-1"));
                return SUCCESS;

            case "dicDicDataAnnouncementStatus":// sex for employee
                listItems = EnumListCacheModel.getDicDataListByType(46, true);
                return SUCCESS;
            case "dicDicDataAnnouncementStatusAll":// sex for employee
                listItems = EnumListCacheModel.getDicDataListByType(46, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "dicDicDataAnnouncementType":// sex for employee
                listItems = EnumListCacheModel.getDicDataListByType(47, true);
                return SUCCESS;
            case "dicDicDataAnnouncementTypeAll":// sex for employee
                listItems = EnumListCacheModel.getDicDataListByType(47, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "dicDicDataBannerInfoType":// sex for employee
                listItems = EnumListCacheModel.getDicDataListByType(48, true);
                return SUCCESS;
            case "dicDicDataBannerInfoTypeAll":// sex for employee
                listItems = EnumListCacheModel.getDicDataListByType(48, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "dicDicPayType":// sex for employee
                listItems = EnumListCacheModel.getDicDataListByType(50, true);
                return SUCCESS;
            case "dicDicPayTypeAll":// sex for employee
                listItems = EnumListCacheModel.getDicDataListByType(50, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "dicSmsStatus":
                listItems = EnumListCacheModel.getDicDataListByType(51, true);
                return SUCCESS;
            case "dicSmsStatusAll":
                listItems = EnumListCacheModel.getDicDataListByType(51, true);
                listItems.add(0, new ListItem("全部", "-1"));
                return SUCCESS;
            case "excelType":
                listItems = EnumListCacheModel.getDicDataListByType(52, true);
                return SUCCESS;
            case "excelTypeAll":
                listItems = EnumListCacheModel.getDicDataListByType(52, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "remindType":
                listItems = EnumListCacheModel.getDicDataListByType(69, true);
                listItems.add(0, new ListItem("--", "-1"));
                return SUCCESS;
            case "remindTypeAll":
                listItems = EnumListCacheModel.getDicDataListByType(69, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "paymentType":
                listItems = EnumListCacheModel.getDicDataListByType(70, true);
                return SUCCESS;
            case "paymentTypeAll":
                listItems = EnumListCacheModel.getDicDataListByType(70, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "examineStatus":
                listItems = EnumListCacheModel.getDicDataListByType(71, true);
                return SUCCESS;
            case "examineStatusAll":
                listItems = EnumListCacheModel.getDicDataListByType(71, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
            case "salesType":
                listItems = EnumListCacheModel.getDicDataListByType(72, true);
                return SUCCESS;
            case "salesTypeAll":
                listItems = EnumListCacheModel.getDicDataListByType(72, true);
                listItems.add(0, new ListItem("全部", "0"));
                return SUCCESS;
        }

        return SUCCESS;
    }

}
