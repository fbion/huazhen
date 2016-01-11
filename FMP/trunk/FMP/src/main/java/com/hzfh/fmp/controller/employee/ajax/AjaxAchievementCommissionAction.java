package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.AchievementCommission;
import com.hzfh.api.employee.model.query.AchievementCommissionCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.ExcelHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.AchievementCommissionModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxAchievementCommissionAction extends JqGridBaseAction<AchievementCommission> {
	private AchievementCommission info;
	public AchievementCommission getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, AchievementCommission.class);
    }
    
    private String byName;
    private String bySelectDepartment;
    private String bySelectPositionNo;

	public String getByName() {
		return byName;
	}

	public void setByName(String byName) {
		this.byName = byName;
	}

	public String getBySelectDepartment() {
		return bySelectDepartment;
	}

	public void setBySelectDepartment(String bySelectDepartment) {
		this.bySelectDepartment = bySelectDepartment;
	}

	public String getBySelectPositionNo() {
		return bySelectPositionNo;
	}

	public void setBySelectPositionNo(String bySelectPositionNo) {
		this.bySelectPositionNo = bySelectPositionNo;
	}

	private String showAllList;
	public String getShowAllList() {
		return showAllList;
	}
	public void setShowAllList(String showAllList) {
		this.showAllList = showAllList;
	}
	
	private String firstShowAllList;
	public String getFirstShowAllList() {
		return firstShowAllList;
	}
	public void setFirstShowAllList(String firstShowAllList) {
		this.firstShowAllList = firstShowAllList;
	}
	
	private String year;
	private String month;
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	
	private AchievementCommissionCondition getCondition(){
		AchievementCommissionCondition achievementCommissionCondition = new AchievementCommissionCondition();
        achievementCommissionCondition.setPageSize(this.getPageSize());
        achievementCommissionCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        achievementCommissionCondition.setSortItemList(sortItemList);
        if ("query".equals(this.showAllList)||"query".equals(this.firstShowAllList)) {
        	achievementCommissionCondition.setWorkMateString(null);
        }else{
            List<Integer> workmate = UserHelper.getUserCache().getWorkMate();
            if (workmate != null) {
            	List<Integer> workmateEmpNoList = new ArrayList<Integer>();
            	for(int i=0;i<workmate.size();i++){
            		int empNo = EmployeeModel.getEmpByUserId(workmate.get(i)).getId(); 
            		workmateEmpNoList.add(empNo);
            	}
            	workmateEmpNoList.add(EmployeeModel.getEmpByUserId(UserHelper.getUserCache().getUserId()).getId());
                String workMateString = StringHelper.listToString(workmateEmpNoList);
                achievementCommissionCondition.setWorkMateString(workMateString);
            } else {
            	achievementCommissionCondition.setWorkMateString(String.valueOf(EmployeeModel.getEmpByUserId(UserHelper.getUserCache().getUserId()).getId()));
            }
        }
        if(!StringHelper.isNullOrEmpty(this.byName)){
        	achievementCommissionCondition.setEmpName(this.byName);
        }else{
        	if(!StringHelper.isNullOrEmpty(this.bySelectDepartment)){
            	achievementCommissionCondition.setDeptNo(Byte.valueOf(this.bySelectDepartment));
            }
            if(!StringHelper.isNullOrEmpty(this.bySelectPositionNo)){
            	achievementCommissionCondition.setPositionNo(Byte.valueOf(this.bySelectPositionNo));
            }
        }
        if(!StringHelper.isNullOrEmpty(this.year)){
        	achievementCommissionCondition.setYear(Integer.valueOf(year));
        }
        if(!StringHelper.isNullOrEmpty(this.month)){
        	achievementCommissionCondition.setMonth(Integer.valueOf(month));
        }
        
        return achievementCommissionCondition;
	}
	
	@Override
    public String execute() throws Exception{
		PagedList<AchievementCommission> achievementCommissionPagedList= AchievementCommissionModel.getPagingList(this.getCondition());
		this.setResultList(achievementCommissionPagedList.getResultList());
		this.setPageCount(achievementCommissionPagedList.getPagingInfo().getPageCount());
		this.setPageIndex(achievementCommissionPagedList.getPagingInfo().getPageIndex());
		this.setRecordCount(achievementCommissionPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
	public String exportExcel(){
		ExcelHelper excelHelper =  new ExcelHelper();
		excelHelper.getExcelForAchievementCommission(this.getCondition(), this.showAllList);
		return null;
	}
	
	

}
