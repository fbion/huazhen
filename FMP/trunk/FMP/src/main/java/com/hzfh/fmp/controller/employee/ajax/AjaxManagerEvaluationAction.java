package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.ManagerEvaluation;
import com.hzfh.api.employee.model.query.ManagerEvaluationCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.employee.ManagerEvaluationModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxManagerEvaluationAction extends JqGridBaseAction<ManagerEvaluation> {
	private ManagerEvaluation info;
	public ManagerEvaluation getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, ManagerEvaluation.class);
    }
    
    private String byName;
    private String bySelectCompany;
    private String bySelectDepartment;
    private String byactivitiStatus;
    private String byYear;
    private String byMonth;
    private String showAllList;
    public String getByName() {
		return byName;
	}

	public void setByName(String byName) {
		this.byName = byName;
	}

	public String getBySelectCompany() {
		return bySelectCompany;
	}

	public void setBySelectCompany(String bySelectCompany) {
		this.bySelectCompany = bySelectCompany;
	}

	public String getBySelectDepartment() {
		return bySelectDepartment;
	}

	public void setBySelectDepartment(String bySelectDepartment) {
		this.bySelectDepartment = bySelectDepartment;
	}

	public String getByactivitiStatus() {
		return byactivitiStatus;
	}

	public void setByactivitiStatus(String byactivitiStatus) {
		this.byactivitiStatus = byactivitiStatus;
	}

	public String getByYear() {
		return byYear;
	}

	public void setByYear(String byYear) {
		this.byYear = byYear;
	}

	public String getByMonth() {
		return byMonth;
	}

	public void setByMonth(String byMonth) {
		this.byMonth = byMonth;
	}

	public String getShowAllList() {
		return showAllList;
	}

	public void setShowAllList(String showAllList) {
		this.showAllList = showAllList;
	}
	private String empName;
	public String getEmpName() {
		return empName;
	}
	
	private int curEmpNo;
	public int getCurEmpNo() {
		return curEmpNo;
	}

	public void setCurEmpNo(int curEmpNo) {
		this.curEmpNo = curEmpNo;
	}
	private String activitiID;
    
    public void setActivitiID(String activitiID) {
		this.activitiID = activitiID;
	}
	public ManagerEvaluationCondition getCondition(){
		ManagerEvaluationCondition managerEvaluationCondition = new ManagerEvaluationCondition();
        managerEvaluationCondition.setPageSize(this.getPageSize());
        managerEvaluationCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        managerEvaluationCondition.setSortItemList(sortItemList);
        boolean flag = true;
        List<Employee> eList1 = EmployeeModel.getEmpListByDept(4);//运营部门的员工
        for(Employee e:eList1){
        	if(this.curEmpNo == e.getId()){
        		List<Employee> eWorkMate = UserHelper.getUserCache().getEmployeeWorkMateList();//拿到运营的下属员工
        		List<Integer> workmateUserNoList = new ArrayList<Integer>();
        		if(eWorkMate!=null)
	        		for(Employee emp:eWorkMate){
	        			int userNo = emp.getUserNo();
	        			workmateUserNoList.add(userNo);//把员工的userNo放到一个list里
	        		}
        		workmateUserNoList.add(e.getUserNo());
        		String workMateUserNoString = StringHelper.listToString(workmateUserNoList);
        		managerEvaluationCondition.setWorkMateUserNoString(workMateUserNoString);
        		flag = false;
        	}
        }
        if(flag){//非运营部的员工
        	if ("query".equals(this.showAllList)) {
        		managerEvaluationCondition.setWorkMateString(null);
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
        			managerEvaluationCondition.setWorkMateString(workMateString);
        		} else {
        			managerEvaluationCondition.setWorkMateString(String.valueOf(EmployeeModel.getEmpByUserId(UserHelper.getUserCache().getUserId()).getId()));
        		}
        	}
        }
	    if(!StringHelper.isNullOrEmpty(this.byName)){
	    	Employee e = EmployeeModel.getEmpByEmpName(this.byName);
	    	if(e!=null){
	    		managerEvaluationCondition.setEmpNo(e.getId());
	    	}else{
	    		managerEvaluationCondition.setEmpNo(-1);
	    	}
	    }
	    
	    if(!StringHelper.isNullOrEmpty(this.bySelectCompany)){
	    	managerEvaluationCondition.setCompanyNo(Integer.valueOf(this.bySelectCompany));
	    }
	    if(!StringHelper.isNullOrEmpty(this.bySelectDepartment)){
	    	managerEvaluationCondition.setDeptNo(Integer.valueOf(this.bySelectDepartment));
	    }
	    if(!StringHelper.isNullOrEmpty(this.byactivitiStatus)){
	    	managerEvaluationCondition.setActivitiStatus(Integer.valueOf(this.byactivitiStatus));
	    }
	    
	    if(!StringHelper.isNullOrEmpty(this.byYear)&&!"".equals(this.byYear)&&!"0".equals(this.byYear)){
	    	if(StringHelper.isNullOrEmpty(this.byMonth)||"".equals(this.byMonth)||"0".equals(this.byMonth)){
	    		managerEvaluationCondition.setDateDown(this.byYear+"-"+"01"+"-"+"01");
	    		managerEvaluationCondition.setDateUp(Integer.valueOf(this.byYear)+1+"-"+"01"+"-"+"01");
	    	}else{
	    		managerEvaluationCondition.setDateDown(this.byYear+"-"+this.byMonth+"-"+"01");
	    		int nextMonth = Integer.valueOf(this.byMonth);
	    		if(Integer.valueOf(this.byMonth)<12){
	    			nextMonth = Integer.valueOf(this.byMonth)+1;
	    		}else{
	    			nextMonth=1;
	    			this.byYear = Integer.valueOf(this.byYear)+1+"";
	    		}
	    		managerEvaluationCondition.setDateUp(this.byYear+"-"+nextMonth+"-"+"01");
	    	}
	    }
	    //managerEvaluationCondition.setCurEmpNo(UserHelper.getUserCache().getEmpId());
	    
        return managerEvaluationCondition;
	}
	@Override
    public String execute() throws Exception{

		this.curEmpNo = UserHelper.getUserCache().getEmpId();
		PagedList<ManagerEvaluation> managerEvaluationPagedList= ManagerEvaluationModel.getPagingList(this.getCondition());
		this.setResultList(managerEvaluationPagedList.getResultList());
        this.setPageCount(managerEvaluationPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(managerEvaluationPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(managerEvaluationPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = ManagerEvaluationModel.add(info);
            if (id > 0){
				this.setErrDesc(String.valueOf(id));                
            }else{
				this.setErrCode("add failed");
                this.setErrDesc("add failed");
			}
                
        }
        else
        {
            if (info.getId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            }
            else{
            	if(!StringHelper.isNullOrEmpty(this.activitiID)){
            		info.setActivitiNo(this.activitiID);
            	}
                if (this.getOper().equalsIgnoreCase("edit")) {                    
                    if (ManagerEvaluationModel.update(info) > 0){
						this.setErrDesc(String.valueOf(info.getId()));
                    }else{
						this.setErrCode("update failed");
                        this.setErrDesc("update failed");
					}
                        
                }
            }
        }

        return SUCCESS;
    }

	public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
        	if (Integer.valueOf(this.getId())!=0) {
        		this.info = ManagerEvaluationModel.getInfo(Integer.parseInt(this.getId()));
        		if (this.info == null) {
        			this.setErrCode("No Info");
        			this.setErrDesc("No Info");
        		}
        	}
        }
        this.empName = UserHelper.getUserCache().getEmpName();
        return SUCCESS;
    }

}
