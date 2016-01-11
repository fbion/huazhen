package com.hzfh.weixin.controller.common;

import com.hzfh.weixin.model.baseInfo.CityModel;
import com.hzfh.weixin.model.baseInfo.DepartmentModel;
import com.hzfh.weixin.model.baseInfo.DistrictModel;
import com.hzfh.weixin.model.baseInfo.ProvinceModel;
import com.hzfh.weixin.model.common.view.ListItem;
import com.hzframework.contract.BaseEntity;
import com.hzframework.helper.StringHelper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class EnumListAction extends JsonBaseAction {

	private List<ListItem> listItems;
	private String type;
	private int param1;
	
	

	

	public int getParam1() {
		return param1;
	}

	public void setParam1(int param1) {
		this.param1 = param1;
	}


	public List<ListItem> getListItems() {
		return listItems;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String execute() {
		switch (this.type) {
		// permission here
		case "status":
			listItems = new ArrayList<ListItem>();
			listItems.add(new ListItem("有效", "1"));
			listItems.add(new ListItem("无效", "0"));
			break;
		case "isYes":
			listItems = new ArrayList<ListItem>();
			listItems.add(new ListItem("是", "1"));
			listItems.add(new ListItem("否", "0"));
			break;
		case "getProvince":
			listItems = getListItemList("name", "id", ProvinceModel.getListByEnabled((byte)1));
			listItems.add(0, new ListItem("请选择", ""));
			break;
		case "getProvinceAll":
			listItems = getListItemList("name", "id", ProvinceModel.getList());
			listItems.add(0, new ListItem("请选择", ""));
			break;
		case "getCity":
			listItems = getListItemList("name", "id", CityModel.getCityListByProvinceNoAndEnabled(param1, (byte)1));
			listItems.add(0, new ListItem("请选择", ""));
			break;
		case "getCityAll":
			listItems = getListItemList("name", "id", CityModel.getCityListByProvinceNo(param1));
			listItems.add(0, new ListItem("请选择", ""));
			break;
		case "getDistrict":
			listItems = getListItemList("name", "id", DistrictModel.getDistrictListByCityNoAndEnabled(param1,(byte) 1));
			listItems.add(0, new ListItem("请选择", ""));
			break;
		case "getDistrictAll":
			listItems = getListItemList("name", "id", DistrictModel.getDistrictListByCityNo(param1));
			listItems.add(0, new ListItem("请选择", ""));
			break;
		case "getDepartment":
			listItems = getListItemList("name", "id", DepartmentModel.getListByDistrictNo(param1));
			listItems.add(0, new ListItem("请选择", ""));
			break;
		case "getDepartmentList":
			int deptType = 1;
			int status = 0;
			listItems = getListItemList("name", "id", DepartmentModel.getDeptListByTypeaAndStatus(deptType,status));
			listItems.add(0, new ListItem("请选择", null));
			break;
		case "getDepartmentAll":
			listItems = getListItemList("name", "id", DepartmentModel.getListByDistrictNo(param1));
			listItems.add(0, new ListItem("请选择", ""));
			break;

		}

		return SUCCESS;
	}

	/*
	 * private List<ListItem> getMyAgentAdviser() { List<Integer> workMate =
	 * UserHelper.getUserCache().getWorkMate(); List<AgentAdviser>
	 * agentAdviserList = new ArrayList<AgentAdviser>(); if(workMate != null){
	 * workMate.add(UserHelper.getUserCache().getUserId()); String
	 * workMateString = StringHelper.listToString(workMate); agentAdviserList =
	 * AgentAdviserModel.getMyAgentAdviser(workMateString); } else{
	 * agentAdviserList =
	 * AgentAdviserModel.getMyAgentAdviser(String.valueOf(UserHelper
	 * .getUserCache().getUserId())); } List<ListItem> itemList =
	 * getListItemList("name","id",agentAdviserList); return itemList; }
	 */
	private <T extends BaseEntity> List<ListItem> getListItemList(
			String textName, String valueName, List<T> tList) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        try {
            if (tList != null && tList.size() > 0) {
                for (T t : tList) {
                    Object[] objects = new Object[]{};
                    String text = String.valueOf(t.getClass().getMethod("get" + StringHelper.initialToUpperName(textName)).invoke(t, objects));
                    String value = String.valueOf(t.getClass().getMethod("get"+ StringHelper.initialToUpperName(valueName)).invoke(t, objects));
                    itemList.add(new ListItem(text, value));
                }
            }
        } catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return itemList;
	}
}
