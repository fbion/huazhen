package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.Position;
import com.hzfh.api.employee.model.Subsidy;
import com.hzfh.api.employee.model.SubsidyTotal;
import com.hzfh.api.employee.model.query.SubsidyCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.ExcelHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.*;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AjaxSubsidyAction extends JqGridBaseAction<Subsidy> {
	private Subsidy info;
	public Subsidy getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, Subsidy.class);
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

	private String empNo;
	private String sendTime;
	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	private List<Subsidy> subsidyList;
	public List<Subsidy> getSubsidyList() {
		return subsidyList;
	}

	public void setSubsidyList(List<Subsidy> subsidyList) {
		this.subsidyList = subsidyList;
	}
	private String deptName;
	private String positionName;
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	private Date source;
	public Date getSource() {
		return source;
	}

	public void setSource(Date source) {
		this.source = source;
	}

	private SubsidyCondition getCondition(){
		SubsidyCondition subsidyCondition = new SubsidyCondition();
        subsidyCondition.setPageSize(this.getPageSize());
        subsidyCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        subsidyCondition.setSortItemList(sortItemList);
        
        if ("query".equals(this.showAllList)||"query".equals(this.firstShowAllList)) {
        	subsidyCondition.setWorkMateString(null);
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
                subsidyCondition.setWorkMateString(workMateString);
            } else {
            	subsidyCondition.setWorkMateString(String.valueOf(EmployeeModel.getEmpByUserId(UserHelper.getUserCache().getUserId()).getId()));
            }
        }
        if(!StringHelper.isNullOrEmpty(this.byName)){
        	subsidyCondition.setEmpName(this.byName);
        }else{
        	if(!StringHelper.isNullOrEmpty(this.bySelectDepartment)){
        		subsidyCondition.setDeptNo(Byte.valueOf(this.bySelectDepartment));
            }
            if(!StringHelper.isNullOrEmpty(this.bySelectPositionNo)){
            	subsidyCondition.setPositionNo(Byte.valueOf(this.bySelectPositionNo));
            }
        }
        if(!StringHelper.isNullOrEmpty(this.year)&&!StringHelper.isNullOrEmpty(this.month)&&!this.year.equals("0")){
    		subsidyCondition.setDateDown(this.year+"-"+this.month+"-"+"01");
    		int nextMonth = Integer.valueOf(this.month);
    		if(Integer.valueOf(this.month)<12){
    			nextMonth = Integer.valueOf(this.month)+1;
    		}else{
    			nextMonth=1;
    			this.year = Integer.valueOf(this.year)+1+"";
    		}
			subsidyCondition.setDateUp(this.year+"-"+nextMonth+"-"+"01");
        }
        return subsidyCondition;
	}
	
	@Override
    public String execute() throws Exception{
        PagedList<Subsidy> subsidyPagedList= SubsidyModel.getPagingList(this.getCondition());
        this.setResultList(subsidyPagedList.getResultList());
        this.setPageCount(subsidyPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(subsidyPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(subsidyPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = SubsidyModel.add(info);
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
                if (this.getOper().equalsIgnoreCase("edit")) {                    
                    if (SubsidyModel.update(info) > 0){
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
            this.info = SubsidyModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

	public String getInfoByEmpNoAndSendTime() {
        if (StringHelper.isNullOrEmpty(this.getEmpNo())) {
            this.setErrCode("NoEmpNo");
            this.setErrDesc("NoEmpNo");
        }else if(StringHelper.isNullOrEmpty(this.getSendTime())){
        	this.setErrCode("NoSendTime");
            this.setErrDesc("NoSendTime");
        }else {
        	SubsidyCondition subsidyCondition = new SubsidyCondition();
        	subsidyCondition.setEmpNo(Integer.valueOf(this.empNo));
        	subsidyCondition.setSendTime(this.sendTime+"-"+"01");
        	this.subsidyList = SubsidyModel.getInfoByEmpNoAndSendTime(subsidyCondition);
        	if(subsidyList.size()>0){
        		Department d = DepartmentModel.getDepartmentByDeptNo(subsidyList.get(0).getDeptNo());
        		Position p = PositionModel.getPositionByPositionNo(subsidyList.get(0).getPositionNo());
        		this.deptName = d.getName();
        		this.positionName = p.getName();
        		for(int i=0;i<subsidyList.size();i++){
        			SubsidyTotal st = SubsidyTotalModel.getInfo(subsidyList.get(i).getSource());
                    if(st==null){
                        continue;
                    }
        			subsidyList.get(i).setSourceDate(st.getAchieveTime());
        		}
        	}
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }
	
	public String exportExcel(){
		ExcelHelper excelHelper =  new ExcelHelper();
		excelHelper.getExcelForSubsidy(this.getCondition(), this.showAllList);
		
		return null;
	}
}
