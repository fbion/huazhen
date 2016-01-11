package com.hzfh.fmp.model.common.helper;

import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.baseInfo.model.City;
import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.baseInfo.model.DicType;
import com.hzfh.api.baseInfo.model.Province;
import com.hzfh.api.employee.model.Company;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.Position;
import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.User;
import com.hzfh.api.permission.model.query.MenuCondition;
import com.hzfh.fmp.model.baseInfo.CityModel;
import com.hzfh.fmp.model.baseInfo.DicDataModel;
import com.hzfh.fmp.model.baseInfo.DicTypeModel;
import com.hzfh.fmp.model.baseInfo.ProvinceModel;
import com.hzfh.fmp.model.common.EnumListCacheModel;
import com.hzfh.fmp.model.common.TreeItem;
import com.hzfh.fmp.model.common.TreeMenu;
import com.hzfh.fmp.model.common.cache.CacheManager;
import com.hzfh.fmp.model.common.cache.CachePrefix;
import com.hzfh.fmp.model.common.enumeration.ProductStatus;
import com.hzfh.fmp.model.common.properties.DictionaryHelper;
import com.hzfh.fmp.model.common.view.ListItem;
import com.hzfh.fmp.model.employee.CompanyModel;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.employee.PositionModel;
import com.hzfh.fmp.model.permission.ElementModel;
import com.hzfh.fmp.model.permission.MenuModel;
import com.hzfh.fmp.model.permission.UserModel;

public class FlushCacheHelper {

	/**
	 * 加add 某个方法 itemList 缓存
	 * */
	public static void setCacheForMethod(String keyName, List<ListItem> itemList) {
		if (itemList != null) {
			CacheManager.set(CachePrefix.LIST_ITEM, keyName, 24 * 60 * 60 * 7,itemList);
		}
	}

	/**
	 * 查询select 某个方法 itemList 缓存
	 * 
	 * @return
	 * */
	public static List<ListItem> getCacheForMethod(String keyName) {
		List<ListItem> itemList = (List<ListItem>) CacheManager.get(CachePrefix.LIST_ITEM, keyName);
		return itemList;
	}

	public static void flushMenuTree(int roleNo) {
		List<Element> firstLevelMenu = ElementModel.get1stLevelMenuList();

		MenuCondition menuCondition = new MenuCondition();
		menuCondition.setRoleNo(roleNo);
		List<Element> elementList;
		elementList = MenuModel.getUserElement(menuCondition);
		// 循环privilegeList，将用户赋予相应权限

		// 整个菜单的list
		List<TreeMenu> treeLists = new ArrayList<TreeMenu>();

		for (Element element1 : firstLevelMenu) {
			// 菜单的一个类型，父级菜单对应着几个子级菜单
			TreeMenu treeMenu = new TreeMenu();
			// 多个子级菜单
			List<TreeItem> treeItems = new ArrayList<TreeItem>();
			for (Element element2 : elementList) {
				if (element1.getId() == element2.getParentNo()
						&& element2.getValue() != null) {
					// 一个子级菜单
					TreeItem treeItem = new TreeItem();
					treeItem.setName(element2.getName());
					treeItem.setUrl(UrlHelper.buildLoginSiteUrl(element2
							.getValue()));
					treeItems.add(treeItem);
				}
			}
			if (treeItems.size() > 0) {
				treeMenu.setName(element1.getName());
				treeMenu.setTreeItems(treeItems);
				treeLists.add(treeMenu);
			}
		}
		CacheManager.set(CachePrefix.MENUTREE, String.valueOf(roleNo)
				+ "treeLists", 7 * 24 * 60 * 60, treeLists);

	}

	/**
	 * 刷新缓存 刷新全部字典缓存
	 * */
	public static void flushEnumListForDictionary() {
		List<DicType> dicTypeList = new ArrayList<DicType>();
		dicTypeList = DicTypeModel.getList();
		if (dicTypeList != null) {
			for (DicType dicType : dicTypeList) {
				getDicDataListByType(dicType.getId());
			}
		}

	}

	/**
	 * 刷新缓存 字典缓存刷新方法
	 * */
	public static void getDicDataListByType(int dicTypeNo) {
		List<DicData> dicDataList = DicDataModel.getDicDataListByType(dicTypeNo);
		if (dicDataList != null) {
			List<ListItem> itemList = new ArrayList<ListItem>();
			itemList = ListItemHelper.getListItemList("value", "code",
					dicDataList);
			CacheManager.set(CachePrefix.LIST_ITEM, "getDicDataListByType"
					+ String.valueOf(dicTypeNo), 24 * 60 * 60 * 7, itemList);
		}
	}

	
	
	
	/**
	 * 刷新权限的方法
	 * */
	public static void flushPermissionCache() {
		// permission
		EnumListCacheModel.getRoleList(false);
		EnumListCacheModel.getUnusedUserList(false);
		EnumListCacheModel.getUserList(false);
		
		List<User> userList = UserModel.getList();
		if (userList==null) {
			return;
		}
		for (User user : userList) {
			EnumListCacheModel.getRolesByUserId(String.valueOf(user.getId()), false);
			EnumListCacheModel.getUnAssignRoles(String.valueOf(user.getId()), false);
		}
		
	}
	
	/**
	 * 刷新客户的方法
	 * */
	public static void flushCustomerCache(){
		// customer
		EnumListCacheModel.getMycustomerPersonList(false);
		EnumListCacheModel.getCustomerPersonList(false);

		EnumListCacheModel.getMyCustomerCompanyList(false);
		EnumListCacheModel.getCustomerCompanyList(false);
		EnumListCacheModel.getMyAgentBusiness(false);
		EnumListCacheModel.getCustomerAgentBusinessList(false);
		EnumListCacheModel.getMyAgentAdviser(false);
		EnumListCacheModel.getCustomerAgentAdviserList(false);
		EnumListCacheModel.getAgentBusinessList(false);
		EnumListCacheModel.getAgentAdviser(false);
		EnumListCacheModel.p2pCustomerListWithRealName(false);
		EnumListCacheModel.getP2pCustomerList(false);
	}
	
	/**
	 * 刷新产品的方法
	 * */
	public static void flushProductCache(){
		// product
		EnumListCacheModel.getProductList(false);
		EnumListCacheModel.getPartnerList(false);
		EnumListCacheModel.getIssuerList(false);
		EnumListCacheModel.getFinancierPersonalList(false);
		EnumListCacheModel.getFinancierBusinessList(false);
		EnumListCacheModel.getP2pProductList(false);
		EnumListCacheModel.getProductListByStatus(ProductStatus.PREHEAT,ProductStatus.ON_SALE, false);
		
		List<DicData> dicDataList = DicDataModel.getDicDataListByType(DictionaryHelper.DIC_TYPE_PRODUCT_TYPE); 
		if (dicDataList==null) {
			return;
		}
		for (DicData dicData : dicDataList) {
			EnumListCacheModel.getProductByTypeAndStatus(dicData.getCode(),ProductStatus.ON_SALE, false);
			EnumListCacheModel.getProductListByType(dicData.getCode(), false);
		}
	}
	
	
	/**
	 * 刷新打款的方法
	 * */
	public static void flushSalesCache(){
		// sales here
		EnumListCacheModel.getSalesList(false);
	}
	
	/**
	 * 刷新baseInfo的方法
	 * */
	public static void flushBaseInfoCache(){
		
		FlushCacheHelper.flushEnumListForDictionary();
		// baseInfo here
		EnumListCacheModel.getProvinceList(false);
		EnumListCacheModel.getCityList(false);
		EnumListCacheModel.getDistrictList(false);
		
		List<Province> provinceList = ProvinceModel.getList();
		if (provinceList==null) {
			return;
		}
		for (Province province : provinceList) {
			EnumListCacheModel.getCityListByProvince(province.getId(), false);
		}
		List<City> cityList = CityModel.getList();
		if (cityList==null) {
			return;
		}
		for (City city : cityList) {
			EnumListCacheModel.getDistrictListByCity(city.getId(), false);
		}
		
	}
	
	/**
	 * 刷新workflow的方法
	 * */
	/*public static void flushWorkflowCache(){
		// workflow here
		
		List<User> userList = UserModel.getList();
		if (userList==null) {
			return;
		}
		for (User user : userList) {
			EnumListCacheModel.getAssignGroupList(String.valueOf(user.getId()), false);
			EnumListCacheModel.getUnAssignGroups(String.valueOf(user.getId()), false);
		}
		
	}*/
	
	/**
	 * 刷新employee的方法
	 * */
	public static void flushEmployeeCache(){
		// employee here
		EnumListCacheModel.getEmpListByParentNo(false);
		EnumListCacheModel.getEmpListById(false);
		EnumListCacheModel.getEmpList(false);
		EnumListCacheModel.getEmpListForEmp(false);
		EnumListCacheModel.getCompanylistFromEmp(false);
		EnumListCacheModel.getDeptList(false);
		EnumListCacheModel.deptSubForCustomer(false);
		EnumListCacheModel.getExtendEmp(false);
		EnumListCacheModel.getPositionList(false);
		EnumListCacheModel.getPositionLevelList(false);
		EnumListCacheModel.getStoreList(false);
		EnumListCacheModel.getWealthManagerListByUserNo(false);
		EnumListCacheModel.getRecipientList(false);
		EnumListCacheModel.getCompanylistFromEmpToTree(false);
		EnumListCacheModel.getDeptlistToTree(false);

		EnumListCacheModel.getEmployeeTree("all", false,"empNo");
		EnumListCacheModel.getEmployeeTree("all", false,"userNo");
		EnumListCacheModel.getEmployeeTree("on", false,"empNo");
		EnumListCacheModel.getEmployeeTree("on", false,"userNo");
		EnumListCacheModel.getEmployeeTree("out", false,"empNo");
		EnumListCacheModel.getEmployeeTree("out", false,"userNo");
		EnumListCacheModel.getEmployeeTree("test", false,"empNo");
		EnumListCacheModel.getEmployeeTree("test", false,"userNo");
		
		List<Department> departmentList = DepartmentModel.getList();
		if (departmentList==null) {
			return;
		}
		for (Department department : departmentList) {
			EnumListCacheModel.getWealthManagerListByStore((byte)department.getId(), false);
			EnumListCacheModel.getDeptTypeBydeptNo(department.getId(), false);
			EnumListCacheModel.getPositionLevelListByDept(department.getId(), false);
			EnumListCacheModel.getDeptListByParentNo(department.getId(), false);
			EnumListCacheModel.getEmpListByDept(department.getId(), false);
			EnumListCacheModel.empManagerListByDept(department.getId(), false);
			EnumListCacheModel.getEmpListByDept(department.getId(), false);
			EnumListCacheModel.getEmployeeManagerByDept(department.getId(), false);
		}
		
		List<Company> companyList = CompanyModel.getList();
		if (companyList==null) {
			return;
		}
		for (Company company : companyList) {
			EnumListCacheModel.getDeptListByCompanyNo(company.getId(), false);
		}
		
		
		List<DicData> dicDataList = DicDataModel.getDicDataListByType(DictionaryHelper.DIC_TYPE_DEPT_TYPE);
		if (dicDataList==null) {
			return;
		}
		for (DicData dicData : dicDataList) {
			EnumListCacheModel.getPositionListBydept(dicData.getCode(), false);
			EnumListCacheModel.getPositionByDept(dicData.getCode(), false);
		}
		
		
		EnumListCacheModel.empManagerListByStatus(DictionaryHelper.DIC_EMPLOYEE_STATUS_DUTY, false);
		EnumListCacheModel.empManagerListByStatus(DictionaryHelper.DIC_EMPLOYEE_STATUS_DIMISSION, false);
		EnumListCacheModel.empManagerListByStatus(DictionaryHelper.DIC_EMPLOYEE_STATUS_RETIRE, false);
		EnumListCacheModel.empManagerListByStatus(DictionaryHelper.DIC_EMPLOYEE_STATUS_INTERNSHIP, false);
		EnumListCacheModel.empManagerListByStatus(DictionaryHelper.DIC_EMPLOYEE_STATUS_PROBATION, false);
		
		List<Position> positionList = PositionModel.getList();
		if (positionList==null) {
			return;
		}
		for (Position position : positionList) {
			EnumListCacheModel.getEmpListByPositionNo(position.getId(), false);	
		}
	
	}
	
	
	
	
	/**
	 * 刷新全部缓存的方法
	 */
	public static void flushAllCache() {
		FlushCacheHelper.flushBaseInfoCache();
		FlushCacheHelper.flushCustomerCache();
		FlushCacheHelper.flushEnumListForDictionary();
		FlushCacheHelper.flushPermissionCache();
		FlushCacheHelper.flushProductCache();
		FlushCacheHelper.flushSalesCache();
		//FlushCacheHelper.flushWorkflowCache();
	}

}
