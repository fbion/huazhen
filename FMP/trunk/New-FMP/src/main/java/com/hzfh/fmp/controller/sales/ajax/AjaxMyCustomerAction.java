package com.hzfh.fmp.controller.sales.ajax;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.query.CustomerPersonalCondition;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.sales.model.Activity;
import com.hzfh.api.sales.model.ApplyCustomer;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.baseInfo.DicDataModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.properties.DictionaryHelper;
import com.hzfh.fmp.model.customer.CustomerPersonalModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.sales.ApplyCustomerModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;

import java.util.ArrayList;
import java.util.List;


public class AjaxMyCustomerAction extends JqGridBaseAction<Activity> {
    private int pageCount;
   	private int totalCount;
   	private int pageIndex=1;
   	private int activityNo;
	public int getActivityNo() {
		return activityNo;
	}
	public void setActivityNo(int activityNo) {
		this.activityNo = activityNo;
	}
	public int getPageCount() {
   		return pageCount;
   	}
   	public void setPageCount(int pageCount) {
   		this.pageCount = pageCount;
   	}
   	public int getTotalCount() {
   		return totalCount;
   	}
   	public void setTotalCount(int totalCount) {
   		this.totalCount = totalCount;
   	}
   	public int getPageIndex() {
   		return pageIndex <= pageCount?pageIndex:pageCount;
   	}
   	public void setPageIndex(int pageIndex) {
   		this.pageIndex = pageIndex;
   	}
	private PagedList<CustomerPersonal> customerPersonalPagedList;
    
    public PagedList<CustomerPersonal> getCustomerPersonalPagedList() {
		return customerPersonalPagedList;
	}

	public void setCustomerPersonalPagedList(
			PagedList<CustomerPersonal> customerPersonalPagedList) {
		this.customerPersonalPagedList = customerPersonalPagedList;
	}
    @Override
    public String execute() throws Exception{
    	this.customerPersonalPagedList = CustomerPersonalModel.getPagingList(this.getCondition());
 		totalCount = customerPersonalPagedList.getPagingInfo().getTotalCount();
 		pageCount = customerPersonalPagedList.getPagingInfo().getPageCount();
 		for (int i = 0; i < customerPersonalPagedList.getResultList().size(); i++) {
 			int customerNo=customerPersonalPagedList.getResultList().get(i).getId();
 			ApplyCustomer applyCustomer=new ApplyCustomer();
 			applyCustomer.setActivityNo(activityNo);
 			applyCustomer.setCustomerNo(customerNo);
 			ApplyCustomer applyCustomer1=ApplyCustomerModel.getInfoByCus(applyCustomer);
 			if(applyCustomer1!=null){
 				customerPersonalPagedList.getResultList().get(i).setInvit(1);
 			}
 			
 			List<DicData> relationTypeList = DicDataModel.getDicDataListByType(DictionaryHelper.DIC_TYPE_RELATION);
			List<DicData> riskTypeList = DicDataModel.getDicDataListByType(DictionaryHelper.DIC_TYPE_RISK);
			customerPersonalPagedList.getResultList().get(i).setLevel(relationTypeList.get(customerPersonalPagedList.getResultList().get(i).getRelationLevel()-1).getValue());
		    customerPersonalPagedList.getResultList().get(i).setHobby(riskTypeList.get(customerPersonalPagedList.getResultList().get(i).getRiskHobby()-1).getValue());
		}
     	//如果录入人id等于当前user可修改
        return SUCCESS;
    }
    //活动中心 销售邀请自己的客户
    public CustomerPersonalCondition getCondition(){
    	CustomerPersonalCondition customerPersonalCondition = new CustomerPersonalCondition();
    	customerPersonalCondition.setPageIndex(pageIndex);
    	customerPersonalCondition.setPageSize(6);
    	customerPersonalCondition.getStartIndex();
 		List<SortItem> sortItemList = new ArrayList<SortItem>();
 		 SortItem sortItem = new SortItem();
 		 sortItem.setSortFeild("id");
 		 sortItem.setSortType(SortType.DESC);
 	     sortItemList.add(sortItem);
 	     customerPersonalCondition.setSortItemList(sortItemList);
 	     customerPersonalCondition.setEmpNo(UserHelper.getEditUserNo());
 	     customerPersonalCondition.setSortItemList(sortItemList);
 		return customerPersonalCondition;
 	}
   

}
