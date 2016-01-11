package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.Subsidy;
import com.hzfh.api.employee.model.SubsidyTotal;
import com.hzfh.api.employee.model.query.SubsidyTotalCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.ExcelHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.employee.SubsidyModel;
import com.hzfh.fmp.model.employee.SubsidyTotalModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AjaxSubsidyTotalAction extends JqGridBaseAction<SubsidyTotal> {
	private SubsidyTotal info;
	public SubsidyTotal getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, SubsidyTotal.class);
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

	private String checkName;
	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}
	private String empNo;
	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	private String id;
	private String deptNo;
	private String positionNo;
	private String subsidyScale;
	private String salesMoney;
	private String subsidy;
	private String achieveTime;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getPositionNo() {
		return positionNo;
	}

	public void setPositionNo(String positionNo) {
		this.positionNo = positionNo;
	}

	public String getSubsidyScale() {
		return subsidyScale;
	}

	public void setSubsidyScale(String subsidyScale) {
		this.subsidyScale = subsidyScale;
	}

	public String getSalesMoney() {
		return salesMoney;
	}

	public void setSalesMoney(String salesMoney) {
		this.salesMoney = salesMoney;
	}

	public String getSubsidy() {
		return subsidy;
	}

	public void setSubsidy(String subsidy) {
		this.subsidy = subsidy;
	}

	public String getAchieveTime() {
		return achieveTime;
	}

	public void setAchieveTime(String achieveTime) {
		this.achieveTime = achieveTime;
	}


	private SubsidyTotalCondition getCondition() {
		SubsidyTotalCondition subsidyTotalCondition = new SubsidyTotalCondition();
        subsidyTotalCondition.setPageSize(this.getPageSize());
        subsidyTotalCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        subsidyTotalCondition.setSortItemList(sortItemList);
        
        if ("query".equals(this.showAllList)||"query".equals(this.firstShowAllList)) {
        	subsidyTotalCondition.setWorkMateString(null);
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
                subsidyTotalCondition.setWorkMateString(workMateString);
            } else {
            	subsidyTotalCondition.setWorkMateString(String.valueOf(EmployeeModel.getEmpByUserId(UserHelper.getUserCache().getUserId()).getId()));
            }
        }
        if(!StringHelper.isNullOrEmpty(this.byName)){
        	subsidyTotalCondition.setEmpName(this.byName);
        }else{
        	if(!StringHelper.isNullOrEmpty(this.bySelectDepartment)){
        		subsidyTotalCondition.setDeptNo(Byte.valueOf(this.bySelectDepartment));
            }
            if(!StringHelper.isNullOrEmpty(this.bySelectPositionNo)){
            	subsidyTotalCondition.setPositionNo(Byte.valueOf(this.bySelectPositionNo));
            }
        }
        if(!StringHelper.isNullOrEmpty(this.year)&&!StringHelper.isNullOrEmpty(this.month)&&!this.year.equals("0")){
    		subsidyTotalCondition.setAchieveTime(this.year+"-"+this.month+"-"+"01");
    		
        }
		return subsidyTotalCondition;
	}
	@Override
    public String execute() throws Exception{
        PagedList<SubsidyTotal> subsidyTotalPagedList= SubsidyTotalModel.getPagingList(this.getCondition());
        this.setResultList(subsidyTotalPagedList.getResultList());
        this.setPageCount(subsidyTotalPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(subsidyTotalPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(subsidyTotalPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
    	if(info==null){
    		info = new SubsidyTotal();
    		info.setInUserNo(UserHelper.getEditUserNo());
    		if(!StringHelper.isNullOrEmpty(this.empNo)){
    			info.setEmpNo(Integer.valueOf(this.empNo));
    			info.setEmpName(EmployeeModel.getInfo(Integer.valueOf(this.empNo)).getName());
    		}
    		if(!StringHelper.isNullOrEmpty(this.deptNo)){
    			info.setDeptNo(Integer.valueOf(this.deptNo));
    		}
    		if(!StringHelper.isNullOrEmpty(this.positionNo)){
    			info.setPositionNo(Integer.valueOf(this.positionNo));
    		}
    		if(!StringHelper.isNullOrEmpty(this.subsidyScale)){
    			info.setSubsidyScale(Float.valueOf(this.subsidyScale));
    		}
    		if(!StringHelper.isNullOrEmpty(this.salesMoney)){
    			info.setSalesMoney(Float.valueOf(this.salesMoney));
    		}
    		if(!StringHelper.isNullOrEmpty(this.subsidy)){
    			info.setSubsidy(Float.valueOf(this.subsidy));
    		}
    		if(!StringHelper.isNullOrEmpty(this.achieveTime)){
    			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        		try {
        			Date d = sdf.parse(achieveTime);
        			String ds = sdf.format(d)+"-01";
        			info.setAchieveTime(sdf.parse(ds));
        		} catch (ParseException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
    		}
    		info.setIsExamine(1);
    		int id = 0;
    		try {
				info.setId(Integer.valueOf(this.id));//不出异常就是正常ID
				id = SubsidyTotalModel.update(info);
			} catch (NumberFormatException e) {
				id = SubsidyTotalModel.add(info);//出异常为jqgrip的自动id
			}
			if (id > 0){
				this.setErrDesc(String.valueOf(id));                
			}else{
				this.setErrCode("failed");
				this.setErrDesc("failed");
			}
    	}else{
    		this.empNo = info.getEmpNo()+"";
    		info.setEditUserNo(UserHelper.getEditUserNo());
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
    		Date d = info.getAchieveTime();
    		String ds = sdf.format(d)+"-01";
    		try {
    			info.setAchieveTime(sdf.parse(ds));
    		} catch (ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		int id = 0;
    		if (this.getOper().equalsIgnoreCase("add")) {
    			info.setInUserNo(UserHelper.getEditUserNo());
    			info.setIsExamine(1);//1表示新建，待审核
    			id = SubsidyTotalModel.add(info);
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
    					if (SubsidyTotalModel.update(info) > 0){
    						this.setErrDesc(String.valueOf(info.getId()));
    					}else{
    						this.setErrCode("update failed");
    						this.setErrDesc("update failed");
    					}
    					
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
            this.info = SubsidyTotalModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

	public String updateIsExamine(){
		if (this.getId().isEmpty()) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
            return SUCCESS;
        }
		if (SubsidyTotalModel.updateIsExamineById(Integer.valueOf(this.getId())) <= 0) {
            this.setErrCode("updateIsExamine failed");
            this.setErrDesc("updateIsExamine failed");
            return SUCCESS;
        }else{
        	SubsidyTotal subsidyTotal = SubsidyTotalModel.getInfo(Integer.valueOf(this.getId()));
        	float money = subsidyTotal.getSubsidy()/6;
        	Date d = subsidyTotal.getAchieveTime();
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	int nmm = 0;
    		for(int i=1;i<=6;i++){
    			int yy = Integer.valueOf(new SimpleDateFormat("yyyy").format(d));
    			int mm = Integer.valueOf(new SimpleDateFormat("MM").format(d));
    			int dd = Integer.valueOf(new SimpleDateFormat("dd").format(d));
    			int nyy = yy;
    			String strD = null;
    			mm+=i;
    			if(mm>12){
    				nyy+=1;
    				nmm+=1;
    				strD = nyy+"-"+nmm+"-"+dd;
    			}else{
    				strD = yy+"-"+mm+"-"+dd;
    			}
    			
    			Date ddd = null;
    			try {
					ddd = sdf.parse(strD);
				} catch (ParseException e) {
					e.printStackTrace();
				}
    			Subsidy subsidy = new Subsidy();
    			subsidy.setEmpNo(subsidyTotal.getEmpNo());
    			subsidy.setEmpName(subsidyTotal.getEmpName());
    			subsidy.setDeptNo(subsidyTotal.getDeptNo());
    			subsidy.setPositionNo(subsidyTotal.getPositionNo());
    			subsidy.setMoney(money);
    			subsidy.setSource(subsidyTotal.getId());
    			subsidy.setSendTime(ddd);
    			subsidy.setIsSend(0);
    			subsidy.setInTime(new Timestamp(i));
    			SubsidyModel.add(subsidy);
    		}
        }
		return SUCCESS;
	}
	
	public String exportExcel(){
		ExcelHelper excelHelper =  new ExcelHelper();
		excelHelper.getExcelForSubsidyTotal(this.getCondition(), this.showAllList);
		
		return null;
	}
	/*public String checkAliasExist() {

        Employee emp = EmployeeModel.get;

        if (emp == null) {
            setErrCode("不存在");
            setErrDesc("员工不存在,请重新填写！");
            return SUCCESS;
        }
        return SUCCESS;
    }*/

	
}
