package com.hzfh.fmp.controller.sales.ajax;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.query.CustomerPersonalCondition;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.sales.model.Activity;
import com.hzfh.api.sales.model.ApplyEmployee;
import com.hzfh.api.sales.model.query.ApplyEmployeeCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.baseInfo.DicDataModel;
import com.hzfh.fmp.model.common.EnumListCacheModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.properties.DeptHelper;
import com.hzfh.fmp.model.common.view.ListItem;
import com.hzfh.fmp.model.customer.CustomerPersonalModel;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.sales.ApplyEmployeeModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxMySaleAction extends JqGridBaseAction<Activity> {
	private int activityNo;
   	public int getActivityNo() {
		return activityNo;
	}
	public void setActivityNo(int activityNo) {
		this.activityNo = activityNo;
	}
    private int pageCount;
   	private int totalCount;
   	private int pageIndex=1;
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
	private PagedList<ApplyEmployee> applyEmployeePagedList;
    
    public PagedList<ApplyEmployee> getApplyEmployeePagedList() {
		return applyEmployeePagedList;
	}

	public void setApplyEmployeePagedList(
			PagedList<ApplyEmployee> applyEmployeePagedList) {
		this.applyEmployeePagedList = applyEmployeePagedList;
	}
    @Override
    public String execute() throws Exception{
    	this.applyEmployeePagedList = ApplyEmployeeModel.getPagingList(this.getCondition());
    	for (int i = 0; i < applyEmployeePagedList.getResultList().size(); i++) {
    		//除了直属上级看到下级销售情况，还需让最高销售管理者看到所有销售情况
    		
    		//根据部门编号 向缓存里找部门类型并找到职位名称
    		List<ListItem> deptItems = EnumListCacheModel.getDeptList(true);
            for (int l = 0; l < deptItems.size(); l++) {
            	int dNo = Integer.valueOf(deptItems.get(l).getValue());
            	if(applyEmployeePagedList.getResultList().get(i).getDeptNo()==dNo){
            		applyEmployeePagedList.getResultList().get(i).setDeptName(deptItems.get(l).getText());
                }
			}
    		int deptNo=applyEmployeePagedList.getResultList().get(i).getDeptNo();
    		int deNo = Integer.valueOf(deptNo);
            int deptType = DepartmentModel.getInfo(deNo).getDeptType();
            List<ListItem> listItems = EnumListCacheModel.getPositionListBydept(deptType, true);
            for (int j = 0; j < listItems.size(); j++) {
            	int pNo = Integer.valueOf(listItems.get(j).getValue());
            	if(pNo==applyEmployeePagedList.getResultList().get(i).getPositionNo()){
                	applyEmployeePagedList.getResultList().get(i).setPositionName(listItems.get(j).getText());
                }
			}
		}
 		totalCount = applyEmployeePagedList.getPagingInfo().getTotalCount();
 		pageCount = applyEmployeePagedList.getPagingInfo().getPageCount();
     	//如果录入人id等于当前user可修改
        return SUCCESS;
    }
    //活动中心 销售邀请自己的客户
    public ApplyEmployeeCondition getCondition(){
    	ApplyEmployeeCondition applyEmployeeCondition = new ApplyEmployeeCondition();
    	applyEmployeeCondition.setPageIndex(pageIndex);
    	applyEmployeeCondition.setPageSize(6);
    	applyEmployeeCondition.getStartIndex();
 		List<SortItem> sortItemList = new ArrayList<SortItem>();
 		SortItem sortItem = new SortItem();
 		sortItem.setSortFeild("id");
 		sortItem.setSortType(SortType.DESC);
 	    sortItemList.add(sortItem);
 	    applyEmployeeCondition.setSortItemList(sortItemList);
 	    //applyEmployeeCondition.setParentNo(UserHelper.getUserCache().getEmpId());
 	    List<Integer> workmate = UserHelper.getUserCache().getWorkMate();
 	    if (workmate != null) {
           workmate.add(UserHelper.getUserCache().getUserId());
           String workMateString = StringHelper.listToString(workmate);
           applyEmployeeCondition.setWorkMateString(workMateString);
 	    } else {
    	   applyEmployeeCondition.setWorkMateString(String.valueOf(UserHelper.getUserCache().getUserId()));
 	    }
 	    applyEmployeeCondition.setActivityNo(this.activityNo);
 	    applyEmployeeCondition.setSortItemList(sortItemList);
 		return applyEmployeeCondition;
 	}
   

}
