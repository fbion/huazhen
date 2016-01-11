package com.hzfh.fmp.model.common;

import com.hzfh.api.baseInfo.model.*;
import com.hzfh.api.customer.model.*;
import com.hzfh.api.employee.model.*;
import com.hzfh.api.market.model.DrawSetting;
import com.hzfh.api.permission.model.Role;
import com.hzfh.api.permission.model.User;
import com.hzfh.api.product.model.*;
import com.hzfh.api.sales.model.Creditor;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.fmp.model.baseInfo.*;
import com.hzfh.fmp.model.common.enumeration.DeptType;
import com.hzfh.fmp.model.common.enumeration.PositionType;
import com.hzfh.fmp.model.common.helper.ListItemHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.properties.DictionaryHelper;
import com.hzfh.fmp.model.common.view.ListItem;
import com.hzfh.fmp.model.customer.*;
import com.hzfh.fmp.model.employee.*;
import com.hzfh.fmp.model.market.DrawSettingModel;
import com.hzfh.fmp.model.permission.RoleModel;
import com.hzfh.fmp.model.permission.UserModel;
import com.hzfh.fmp.model.product.*;
import com.hzfh.fmp.model.sales.CreditorModel;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;

public class EnumListModel {

    /**
     * listItem  取值方法
     */
    /*public static List<ListItem> getUnAssignGroups(String userNo) {
        List<Group> allGroupList = ActIdUserModel.getGroupList();
		List<Group> assignGroupList = ActIdUserModel.getAssignGroupList(userNo);
		if (allGroupList != null && allGroupList.size() > 0
				&& assignGroupList != null && assignGroupList.size() > 0) {
			for (Group assignGroup : assignGroupList) {
				for (int i = 0; i < allGroupList.size(); i++)
					if (allGroupList.get(i).getId().equals(assignGroup.getId())) {
						allGroupList.remove(allGroupList.get(i));
					}
			}
		}
		List<Group> unAssignGroups = allGroupList;

		List<ListItem> itemList = new ArrayList<ListItem>();
		if (unAssignGroups != null && unAssignGroups.size() > 0) {
			for (Group unAssignGroup : unAssignGroups) {
				itemList.add(new ListItem(unAssignGroup.getName(),
						unAssignGroup.getId()));
			}
		}
		return itemList;
	}*/

	/*public static List<ListItem> getAssignGroupList(String userNo) {
		List<Group> assignGroupList = ActIdUserModel.getAssignGroupList(userNo);

		List<ListItem> itemList = new ArrayList<ListItem>();
		if (assignGroupList != null && assignGroupList.size() > 0) {
			for (Group assignGroup : assignGroupList) {
				itemList.add(new ListItem(assignGroup.getName(), assignGroup
						.getId()));
			}
		}
		return itemList;
	}*/
    public static List<ListItem> deptSubForCustomer() {
        List<Department> deptList = DepartmentModel.getList();
        List<Department> departments = new ArrayList<Department>();
        List<ListItem> itemList = new ArrayList<ListItem>();
        for (Department department : deptList) {
            if (department.getId() == 5) { // 财富管理中心
                departments.add(department);
            }
            if (department.getId() == 10) {// 渠道业务部
                departments.add(department);
            }
            if (department.getId() == 11) {// 直销业务部门
                departments.add(department);
            }
            if (department.getId() == 13) {// 新金融事业部
                departments.add(department);
            }
            if (department.getId() == 14) {// 公益西桥店
                departments.add(department);
            }
            if (department.getId() == 15) {// 亚运村门店
                departments.add(department);
            }
            if (department.getId() == 16) {// 平谷门店
                departments.add(department);
            }
            if (department.getId() == 17) {// 房山门店
                departments.add(department);
            }
            if (department.getId() == 18) {// 通州门店
                departments.add(department);
            }
            if (department.getId() == 19) {// 其他门店
                departments.add(department);
            }
        }

        if (departments != null) {
            itemList = ListItemHelper.getListItemList("name", "id", departments);
        }

        return itemList;
    }

    public static List<ListItem> empManagerListByDept(int empManagerDept) {
        List<Employee> empList = UserHelper.getUserCache().getEmployeeWorkMateList();
        List<ListItem> itemList = new ArrayList<ListItem>();
        List<Employee> result = new ArrayList<Employee>();
        if (empList != null && empList.size() > 0) {
            for (Employee employee : empList) {
                if (employee.getDeptNo() == empManagerDept) {
                    result.add(employee);
                }
            }
        }

        if (result != null && result.size() > 0) {
            itemList = ListItemHelper.getListItemList("name", "userNo", result);
            itemList.add(0, new ListItem(UserHelper.getUserCache().getEmpName(), String.valueOf(UserHelper.getUserCache().getUserId())));
        }
        return itemList;
    }

    public static List<ListItem> empManagerListByStatus(int empManagerStauts) {
        // UserHelper.getUserCache().getEmpName();
        List<Employee> empList = UserHelper.getUserCache().getEmployeeWorkMateList();
        List<ListItem> itemList = new ArrayList<ListItem>();
        List<Employee> result = new ArrayList<Employee>();
        if (empList != null && empList.size() > 0) {
            for (Employee employee : empList) {
                if (employee.getStatus() == empManagerStauts) {
                    result.add(employee);
                }
            }
        }

        if (result != null && result.size() > 0) {
            itemList = ListItemHelper.getListItemList("name", "userNo", result);
        }
        return itemList;
    }

    public static List<ListItem> getBannerLocationList() {
        List<BannerLocation> bannerLocationList = BannerLocationModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", bannerLocationList);
        return itemList;
    }

    public static List<ListItem> getP2pProductList() {
        List<P2pProduct> p2pProductList = P2pProductModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", p2pProductList);
        return itemList;
    }

    public static List<ListItem> getP2pCustomerListRealName() {
        List<P2pCustomer> p2pCustoemrList = P2pCustomerModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("realName", "id",
                p2pCustoemrList);
        return itemList;
    }

    public static List<ListItem> getP2pCustomerList() {
        List<P2pCustomer> p2pCustoemrList = P2pCustomerModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("userName", "id",
                p2pCustoemrList);
        return itemList;
    }

    public static List<ListItem> getCreditorList() {
        List<Creditor> creditorList = CreditorModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemListA("projectName", "roomNumber", "remainAmount", "id",
                creditorList);
        return itemList;
    }

    public static List<ListItem> getCreditorListByProductNo(int productNo) {
        List<Creditor> creditorList = CreditorModel.getListByPrductNo(productNo);
        List<ListItem> itemList = ListItemHelper.getListItemListA("projectName", "roomNumber", "remainAmount", "id",
                creditorList);
        return itemList;
    }

    public static List<ListItem> p2pCustomerListWithRealName() {
        List<P2pCustomer> p2pCustoemrList = P2pCustomerModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("realName", "id",
                p2pCustoemrList);
        return itemList;
    }

    public static List<ListItem> getExtendEmp() {
        List<EmployeeInformation> emoloyeeInformationList = EmployeeInformationModel
                .getExtendEmp();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id",
                emoloyeeInformationList);
        return itemList;
    }

    public static List<ListItem> getDrawAwards() {
        List<DrawSetting> emoloyeeInformationList = DrawSettingModel.getInfoListByStatus(2);
        List<ListItem> itemList = ListItemHelper.getListItemList("drawAwards", "id",
                emoloyeeInformationList);
        return itemList;
    }

    public static List<ListItem> getWealthManagerListByUserNo() {
        List<Employee> employeeList = EmployeeModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "userNo",
                employeeList);
        return itemList;
    }

    public static List<ListItem> getMyAgentAdviser() {
        List<Integer> workMate = UserHelper.getUserCache().getWorkMate();
        List<AgentAdviser> agentAdviserList = new ArrayList<AgentAdviser>();
        if (workMate != null) {
            workMate.add(UserHelper.getUserCache().getUserId());
            String workMateString = StringHelper.listToString(workMate);
            agentAdviserList = AgentAdviserModel
                    .getMyAgentAdviser(workMateString);
        } else {
            agentAdviserList = AgentAdviserModel.getMyAgentAdviser(String
                    .valueOf(UserHelper.getUserCache().getUserId()));
        }
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id",
                agentAdviserList);
        return itemList;
    }

    public static List<ListItem> getMyAgentBusiness() {
        List<Integer> workMate = UserHelper.getUserCache().getWorkMate();
        List<AgentBusiness> agentBusinessList = new ArrayList<AgentBusiness>();
        if (workMate != null) {
            workMate.add(UserHelper.getUserCache().getUserId());
            String workMateString = StringHelper.listToString(workMate);
            agentBusinessList = AgentBusinessModel
                    .getMyAgentBusiness(workMateString);
        } else {
            agentBusinessList = AgentBusinessModel.getMyAgentBusiness(String
                    .valueOf(UserHelper.getUserCache().getUserId()));
        }
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id",
                agentBusinessList);
        return itemList;
    }

    public static List<ListItem> getMycustomerPersonList() {
        List<Integer> workMate = UserHelper.getUserCache().getWorkMate();
        List<CustomerPersonal> customerPersonalList = new ArrayList<CustomerPersonal>();
        if (workMate != null) {
            workMate.add(UserHelper.getUserCache().getUserId());
            String workMateString = StringHelper.listToString(workMate);
            customerPersonalList = CustomerPersonalModel
                    .getMyCustomerCompanyList(workMateString);
        } else {
            customerPersonalList = CustomerPersonalModel
                    .getMyCustomerCompanyList(String.valueOf(UserHelper
                            .getUserCache().getUserId()));
        }
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id",
                customerPersonalList);
        return itemList;
    }

    public static List<ListItem> getMycustomerPersonList1() {

        List<CustomerPersonal> customerPersonalList = new ArrayList<CustomerPersonal>();

        customerPersonalList = CustomerPersonalModel
                .getMyCustomerCompanyList(String.valueOf(UserHelper
                        .getUserCache().getUserId()));

        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id",
                customerPersonalList);
        return itemList;
    }

    public static List<ListItem> getMyCustomerCompanyList1() {
        List<CustomerCompany> customerCompanyList = new ArrayList<CustomerCompany>();

        customerCompanyList = CustomerCompanyModel
                .getMyCustomerCompanyList(String.valueOf(UserHelper
                        .getUserCache().getUserId()));

        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id",
                customerCompanyList);
        return itemList;
    }

    public static List<ListItem> getMyCustomerCompanyList() {
        List<Integer> workMate = UserHelper.getUserCache().getWorkMate();
        List<CustomerCompany> customerCompanyList = new ArrayList<CustomerCompany>();
        if (workMate != null) {
            workMate.add(UserHelper.getUserCache().getUserId());
            String workMateString = StringHelper.listToString(workMate);
            customerCompanyList = CustomerCompanyModel
                    .getMyCustomerCompanyList(workMateString);
        } else {
            customerCompanyList = CustomerCompanyModel
                    .getMyCustomerCompanyList(String.valueOf(UserHelper
                            .getUserCache().getUserId()));
        }
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id",
                customerCompanyList);
        return itemList;
    }

    // get product where type and status=Onsale
    public static List<ListItem> getProductByTypeAndStatus(byte type, byte status) {
        List<Product> productList = ProductModel.getProductByTypeAndStatus(type, status);
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", productList);
        return itemList;
    }

    public static List<ListItem> getP2pProductByTypeAndStatus(byte type, byte status) {
        List<Product> productList = ProductModel.getProductByTypeAndStatus(type, status);
        List<ListItem> itemList = null;
        try {
            itemList = ListItemHelper.getListItemListP2pProduct("name", "end", "id", productList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return itemList;
    }

    public static List<ListItem> getP2pProductByStatus(byte status) {
        List<P2pProduct> p2pProductList = P2pProductModel.getP2pProductByStatus(status);
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", p2pProductList);
        return itemList;
    }

    public static List<ListItem> getDeptListByParentNo(int parentNo) {
        List<Department> departmentList = DepartmentModel.getDeptListByParentNo(parentNo);
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", departmentList);
        return itemList;
    }

    public static List<ListItem> getDeptListByType(int type) {
        List<Department> departmentList = DepartmentModel.getDeptListByType(type);
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", departmentList);
        return itemList;
    }

    public static List<ListItem> getProvinceList() {
        List<Province> provinceList = ProvinceModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", provinceList);
        return itemList;
    }

    public static List<ListItem> getCityList() {
        List<City> cityList = CityModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", cityList);
        return itemList;
    }

    public static List<ListItem> getDistrictList() {
        List<District> districtsList = DistrictModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", districtsList);
        return itemList;
    }

    public static List<ListItem> getDeptListByCompanyNo(int CompanyNo) {
        List<Department> departmentList = DepartmentModel.getDeptListByCompanyNo(CompanyNo);
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", departmentList);
        return itemList;
    }

    public static List<ListItem> getFinancierBusinessList() {
        List<FinancierBusiness> financierBusinessList = FinancierBusinessModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", financierBusinessList);
        return itemList;
    }

    public static List<ListItem> getFinancierPersonalList() {
        List<FinancierPersonal> financierPersonalList = FinancierPersonalModel
                .getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", financierPersonalList);
        return itemList;
    }

    public static List<ListItem> getCustomerAgentAdviserList() {
        List<AgentAdviser> agentAdviserList = AgentAdviserModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", agentAdviserList);
        return itemList;
    }

    public static List<ListItem> getCustomerAgentBusinessList() {
        List<AgentBusiness> agentBusinessList = AgentBusinessModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id",
                agentBusinessList);
        return itemList;
    }

    // get Position by department
    public static List<ListItem> getPositionByDept(int deptNo) {
        List<Position> positionList = PositionModel.getPositionByDept(deptNo);
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", positionList);
        return itemList;
    }

    public static List<ListItem> getSalesList() {
        List<Sales> salesList = SalesModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", salesList);
        return itemList;
    }

    public static List<ListItem> getIssuerList() {
        List<PartnerIssuer> list = PartnerIssuerModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", list);
        return itemList;
    }

    // get all adviser
    public static List<ListItem> getAgentAdviser() {
        List<AgentAdviser> list = AgentAdviserModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", list);
        return itemList;
    }

    // get all AgentBusiness to list
    public static List<ListItem> getAgentBusinessList() {
        List<AgentBusiness> list = AgentBusinessModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", list);
        return itemList;
    }

    // get name and userNo　to select
    public static List<ListItem> getEmpList() {
        List<ListItem> itemList = new ArrayList<ListItem>();
        List<Employee> employeeList = EmployeeModel.getList();
        itemList = ListItemHelper.getListItemList("name", "userNo", employeeList);
        return itemList;
    }

    public static List<ListItem> getEmpListNoTest() {
        List<ListItem> itemList = new ArrayList<ListItem>();
        List<Employee> employeeList = EmployeeModel.getEmpListNoTest();
        itemList = ListItemHelper.getListItemList("name", "userNo", employeeList);
        return itemList;
    }

    public static List<ListItem> getEmpListById() {
        List<ListItem> itemList = new ArrayList<ListItem>();
        List<Employee> employeeList = EmployeeModel.getList();
        itemList = ListItemHelper.getListItemList("name", "id", employeeList);
        return itemList;
    }

    public static List<ListItem> getRecipientList() {
        List<ListItem> itemList = new ArrayList<ListItem>();
        List<Employee> employeeList = EmployeeModel.getList();
        itemList = ListItemHelper.getListItemList("name", "id", employeeList);
        return itemList;
    }

    // employee name and id to select
    public static List<ListItem> getEmpListForEmp() {
        List<ListItem> itemList = new ArrayList<ListItem>();
        List<Employee> empListForEmp = EmployeeModel.getList();
        itemList = ListItemHelper.getListItemList("name", "id", empListForEmp);
        return itemList;
    }

    public static List<ListItem> getProductList() {
        List<Product> productList = ProductModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", productList);
        return itemList;
    }

    // role list
    public static List<ListItem> getRoleList() {

        List<Role> roleList = RoleModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", roleList);

        return itemList;
    }

    public static List<ListItem> getProductListByType(byte type) {

        List<Product> productList = ProductModel.getListByType(type);
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", productList);

        return itemList;
    }

    public static List<ListItem> getWealthManagerListByStore(Byte storeNo) {

        List<Employee> employeeList = EmployeeModel.getEmpByPositionNoAndStoreNo(PositionType.WEALTHMANAGER, (int) storeNo);
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "userNo", employeeList);

        return itemList;
    }

    public static List<ListItem> getWealthManagerListByStoreIsUse(Byte storeNo) {

        List<Employee> employeeList = EmployeeModel.getEmpByPositionNoAndStoreNoIsUse(PositionType.WEALTHMANAGER, (int) storeNo, 2);
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "userNo", employeeList);

        return itemList;
    }


    public static List<ListItem> getProductListByStatus(byte statusLeft,
                                                        byte statusRight) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        List<Product> productList = ProductModel.getProductListByStatus(
                statusLeft, statusRight);
        itemList = ListItemHelper.getListItemList("name", "id", productList);
        return itemList;
    }

    public static List<ListItem> getStoreList() {
        List<Department> list = DepartmentModel
                .getDeptListByType(DeptType.STORE);
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", list);
        return itemList;
    }

    public static List<ListItem> getUserList() {
        List<User> userList = UserModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", userList);
        return itemList;
    }

    public static List<ListItem> getCompanylistFromEmpToTree() {
        List<Company> companylistFromEmp = CompanyModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemListForTree("id", "", "name", null, null, companylistFromEmp);
        return itemList;
    }

    public static List<ListItem> getDeptlistToTree() {
        List<Department> dataList = DepartmentModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemListForTree("id", "companyNo", "name", "parentNo", "deptType", dataList);
        return itemList;
    }

    public static List<ListItem> getPositionlistToTree() {
        List<Position> dataList = PositionModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemListForTree("id", "deptNo", "name", null, null, dataList);
        return itemList;
    }

    public static List<ListItem> getEmployeeTree(String param, String param2) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        List<Employee> dataList = null;
        if ("all".equals(param)) {
            dataList = EmployeeModel.getList();
        } else if ("on".equals(param)) {
            dataList = EmployeeModel.getEmpListByStatus(1);
            List<Employee> dataList1 = EmployeeModel.getEmpListByStatus(4);
            List<Employee> dataList2 = EmployeeModel.getEmpListByStatus(5);
            if (dataList1 != null) {
                for (Employee e : dataList1) {
                    dataList.add(e);
                }
            }
            if (dataList2 != null) {
                for (Employee e : dataList2) {
                    dataList.add(e);
                }
            }
        } else if ("out".equals(param))
            dataList = EmployeeModel.getEmpListByStatus(2);
        else if ("test".equals(param))
            dataList = EmployeeModel.getEmpListIsTest((byte) 1);
        String id = "id";
        if ("empNo".equals(param2)) id = "id";
        if ("userNo".equals(param2)) id = "userNo";
        itemList = ListItemHelper.getListItemListForTree(id, "deptNo", "name", null, null, dataList);
        return itemList;
    }

    // dicData(key value)list by dicTypeNO
    public static List<ListItem> getDicDataListByType(int dicTypeNo) {
        List<DicData> dicDataList = DicDataModel.getDicDataListByType(dicTypeNo);
        List<ListItem> itemList = ListItemHelper.getListItemList("value", "code", dicDataList);
        return itemList;
    }

    // 通过userId获取对应的roles
    public static List<ListItem> getRolesByUserId(String userId) {
        List<Role> rolesList = RoleModel.getRolesByUserId(userId);
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", rolesList);
        return itemList;
    }

    // 通过userId获取未分配的角色unAssignRoles
    public static List<ListItem> getUnAssignRoles(String userId) {
        List<Role> allRoleList = RoleModel.getList();
        List<Role> assignRoleList = RoleModel.getRolesByUserId(userId);
        if (allRoleList != null && allRoleList.size() > 0
                && assignRoleList != null && assignRoleList.size() > 0) {
            for (Role assignedRole : assignRoleList) {
                for (int i = 0; i < allRoleList.size(); i++)
                    if (allRoleList.get(i).getId() == assignedRole.getId()) {
                        allRoleList.remove(allRoleList.get(i));
                    }
            }
        }
        List<Role> unAssignRoleList = allRoleList;
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id",
                unAssignRoleList);
        return itemList;
    }

    // DicType here
    public static List<ListItem> getDicTypeNoList() {
        List<DicType> dicTypeList = DicTypeModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", dicTypeList);
        return itemList;
    }

    public static List<ListItem> getEmpListByParentNo() {
        List<Employee> empList = UserHelper.getUserCache()
                .getEmployeeWorkMateList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "userNo", empList);
        return itemList;
    }

    // get dept
    public static List<ListItem> getDeptList() {
        List<Department> deptList = DepartmentModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", deptList);
        return itemList;
    }

    // compamy of employee
    public static List<ListItem> getCompanylistFromEmp() {
        List<Company> companylistFromEmp = CompanyModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", companylistFromEmp);
        return itemList;
    }

    public static List<ListItem> getEmpListByDept(int deptNo) {
        List<Employee> empList = EmployeeModel.getEmpListByDept(deptNo);
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", empList);
        return itemList;
    }

    public static List<ListItem> getEmpListByPositionNo(int positionNo) {
        List<Employee> empList = EmployeeModel.getEmpListByPositionNo(positionNo);
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", empList);
        return itemList;
    }

    public static List<ListItem> getEmployeeManagerByDept(int deptNo) {
        if (deptNo != 0) {
            int parentDept = DepartmentModel.getParentDeptByDept(deptNo);
            List<Employee> empList1 = EmployeeModel.getEmpListByDept(deptNo);
            List<Employee> empList2 = EmployeeModel
                    .getEmpListByDept(parentDept);
            List<Employee> empManagerList = new ArrayList<Employee>();
            empManagerList.addAll(empList1);
            empManagerList.addAll(empList2);
            List<ListItem> itemList = ListItemHelper.getListItemList("name", "id",
                    empManagerList);
            return itemList;
        } else {
            return null;
        }
    }

    public static List<ListItem> getCustomerCompanyList() {

        List<CustomerCompany> customerCompanyList = CustomerCompanyModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", customerCompanyList);

        return itemList;
    }

    public static List<ListItem> getCustomerPersontById(int id) {
        List<CustomerPersonal> customerPersonalList = new ArrayList<>();
        customerPersonalList.add(CustomerPersonalModel.getInfo(id));
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", customerPersonalList);

        return itemList;
    }

    public static List<ListItem> getPartnerList() {
        List<ListItem> itemList = new ArrayList<ListItem>();
        List<PartnerIssuer> partnerIssuerList = PartnerIssuerModel.getList();
        itemList = ListItemHelper.getListItemList("name", "id", partnerIssuerList);
        return itemList;
    }

    // position List
    public static List<ListItem> getPositionList() {
        List<Position> positionList = PositionModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", positionList);
        return itemList;
    }

    // PositionLevel List
    public static List<ListItem> getPositionLevelList() {
        List<PositionLevel> positionLevelList = PositionLevelModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id",
                positionLevelList);
        return itemList;
    }

    // get PositionLevel by dept
    public static List<ListItem> getPositionLevelListByDept(int dept) {
        List<PositionLevel> positionLevelList = PositionLevelModel
                .getPositionLevelListByDept(dept);
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id",
                positionLevelList);
        return itemList;
    }

    public static List<ListItem> getUnusedUserList() {
        List<ListItem> userList = getUserList();
        List<ListItem> empList = getEmpList();

        List<ListItem> unusedList = new ArrayList<ListItem>();

        for (ListItem user : userList) {
            if (user.getText().equalsIgnoreCase("admin")) {
                continue;
            }
            boolean bUsed = false;
            int i = 0;
            for (; i < empList.size(); ) {
                if (empList.get(i).getValue().equals(user.getValue())) {
                    bUsed = true;
                    break;
                }
                i++;
            }
            if (bUsed) {
                empList.remove(i);
            } else {
                unusedList.add(user);
            }
        }

        return unusedList;
    }

    // position list by dept
    public static List<ListItem> getPositionListBydept(int dept) {
        List<Position> positionList = PositionModel.getPositionListBydept(dept);
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", positionList);
        return itemList;
    }

    public static List<ListItem> getSuppliersList() {
        List<Suppliers> positionList = SuppliersModel.getList();
        List<ListItem> itemList = ListItemHelper.getListItemList("supplierName", "id", positionList);
        return itemList;
    }

    public static List<ListItem> getCityListByProvince(int dept) {
        List<City> positionList = CityModel.getCityListByProvinceNo(dept);
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", positionList);
        return itemList;
    }

    public static List<ListItem> getDistrictListByCity(int city) {
        List<District> positionList = DistrictModel
                .getDistrictListByCityNo(city);
        List<ListItem> itemList = ListItemHelper.getListItemList("name", "id", positionList);
        return itemList;
    }

    public static List<ListItem> getDeptTypeBydeptNo(int deptNo) {
        if (deptNo == 0) {
            return null;
        }

        List<Department> deptList = DepartmentModel.getDeptTypeBydeptNo(deptNo);

        if (deptList != null && deptList.size() > 0) {
            return ListItemHelper.getListItemList("name", "deptType", deptList);
        } else {
            return null;
        }
    }

    public static List<ListItem> getEmployeeByStatus(int status) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (status == DictionaryHelper.DIC_EMPLOYEE_STATUS_DUTY) {
            List<Employee> empDutys = new ArrayList<Employee>();
            empDutys = EmployeeModel
                    .getEmployeeSubordinateListByStatus(DictionaryHelper.DIC_EMPLOYEE_STATUS_DUTY);
            // if (empDutys!=null&&empDutys.size()>0) {
            itemList = ListItemHelper.getListItemList("name", "userNo", empDutys);
            itemList.add(0, new ListItem(UserHelper.getUserCache().getEmpName(), String
                    .valueOf(UserHelper.getUserCache().getUserId())));

            // }
        } else if (status == DictionaryHelper.DIC_EMPLOYEE_STATUS_DIMISSION) {
            List<Employee> empDimissions = EmployeeModel
                    .getEmployeeSubordinateListByStatus(DictionaryHelper.DIC_EMPLOYEE_STATUS_DIMISSION);
            List<Employee> empDimissionsNew = new ArrayList<Employee>();
            if (empDimissions != null && empDimissions.size() > 0) {
                for (Employee e : empDimissions) {
                    if (CustomerPersonalModel
                            .getCustomerPersonalListByManagerNo(e.getUserNo())
                            .size() > 0) {
                        empDimissionsNew.add(e);
                    }
                }
            }
            if (empDimissionsNew != null && empDimissionsNew.size() > 0) {
                itemList = ListItemHelper.getListItemList("name", "userNo", empDimissionsNew);
            }
        } else {
        }
        return itemList;
    }

    public static List<ListItem> getEmployeeByStatusAgainst(int status) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        List<Employee> empDimissions = EmployeeModel.getEmployeeSubordinateListByStatusAgainst(DictionaryHelper.DIC_EMPLOYEE_STATUS_DIMISSION);
        if (empDimissions != null && empDimissions.size() > 0) {
            itemList = ListItemHelper.getListItemList("name", "userNo", empDimissions);
        }
        return itemList;
    }
}
