package com.hzfh.p2p.controller.common;

import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.p2p.model.baseInfo.CityModel;
import com.hzfh.p2p.model.baseInfo.DepartmentModel;
import com.hzfh.p2p.model.baseInfo.DistrictModel;
import com.hzfh.p2p.model.baseInfo.ProvinceModel;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.view.ListItem;
import com.hzfh.p2p.model.product.P2pProductModel;
import com.hzfh.p2p.model.sales.P2pSubscribeModel;
import com.hzframework.contract.BaseEntity;
import com.hzframework.helper.StringHelper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class EnumListAction extends JsonBaseAction {

	private List<ListItem> listItems;
	private String type;
	
	
	//private String param1;
	
	private int param1;
	

	public int getParam1() {
		return param1;
	}

	public void setParam1(int param1) {
		this.param1 = param1;
	}

/*
	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}*/

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
		case "getDepartmentAll":
			listItems = getListItemList("name", "id", DepartmentModel.getListByDistrictNo(param1));
			listItems.add(0, new ListItem("请选择", ""));
			break;
		case "getMoneyChangeType":
			listItems = new ArrayList<ListItem>();
			listItems.add(new ListItem("充值", "01"));
			listItems.add(new ListItem("支付", "02"));
			listItems.add(new ListItem("付款", "03"));
			listItems.add(new ListItem("收款", "04"));
			break;
		case "getMoneyChangeTypeAll":
			listItems = new ArrayList<ListItem>();
			listItems.add(new ListItem("充值", "1"));
			listItems.add(new ListItem("提现", "3"));
			listItems.add(new ListItem("冻结", "2"));
			listItems.add(new ListItem("收款", "9"));
			listItems.add(new ListItem("支付", "10"));
			listItems.add(0, new ListItem("所有", "00"));
			break;
		case "reservationProductSelect":
			listItems = getListItemList("name", "id", this.getP2pProductListBySubscribeP2pProductNo());
			listItems.add(0, new ListItem("全部", ""));
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
	
	private List<P2pProduct>  getP2pProductListBySubscribeP2pProductNo(){
		List<P2pProduct> p2pProductList = new ArrayList<P2pProduct>();
		List<P2pSubscribe> p2pSubscribeList = P2pSubscribeModel.getListByP2pCustomerNo(AuthenticationModel.getCustomerId());
		for(P2pSubscribe ps:p2pSubscribeList){
			P2pProduct pp = P2pProductModel.getInfo(ps.getP2pProductNo());
			if(pp!=null){
				boolean flag = true;
				for(int i=0;i<p2pProductList.size();i++){
					if(p2pProductList.get(i).getId()==pp.getId()){
						flag = false;
						break;
					}
				}
				if(flag){
					p2pProductList.add(pp);
				}
			}
		}
		return p2pProductList;
	}
	
}
