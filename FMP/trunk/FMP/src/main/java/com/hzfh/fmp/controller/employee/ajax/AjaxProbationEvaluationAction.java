package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.*;
import com.hzfh.api.employee.model.query.ProbationEvaluationCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.*;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AjaxProbationEvaluationAction extends JqGridBaseAction<ProbationEvaluation> {
	private int id;
	
	public void setId(int id) {
		this.id = id;
	}

	private ProbationEvaluation info;
	public ProbationEvaluation getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, ProbationEvaluation.class);
    }
    
    private int count1;
    private int count2;
    public int getCount1() {
		return count1;
	}
	public void setCount1(int count1) {
		this.count1 = count1;
	}
	public int getCount2() {
		return count2;
	}
	public void setCount2(int count2) {
		this.count2 = count2;
	}

	private List<String> scoreList1 = new ArrayList<String>();
	private List<String> scoreList2 = new ArrayList<String>();
	private List<String> scoreList3 = new ArrayList<String>();
	private List<String> scaleList = new ArrayList<String>();
	private List<String> contentList = new ArrayList<String>();
	public List<String> getScoreList1() {
		return scoreList1;
	}
	public void setScoreList1(String scoreList1) {
		for(int i=0;i<JSON.parseArray(scoreList1).size();i++){
			this.scoreList1.add(JSON.parseArray(scoreList1).get(i).toString());
		}
	}
	public List<String> getScoreList2() {
		return scoreList2;
	}
	public void setScoreList2(String scoreList2) {
		for(int i=0;i<JSON.parseArray(scoreList2).size();i++){
			this.scoreList2.add(JSON.parseArray(scoreList2).get(i).toString());
		}
	}
	public List<String> getScoreList3() {
		return scoreList3;
	}
	public void setScoreList3(String scoreList3) {
		for(int i=0;i<JSON.parseArray(scoreList3).size();i++){
			this.scoreList3.add(JSON.parseArray(scoreList3).get(i).toString());
		}
	}
	public List<String> getScaleList() {
		return scaleList;
	}
	public void setScaleList(String scaleList) {
		for(int i=0;i<JSON.parseArray(scaleList).size();i++){
			this.scaleList.add(JSON.parseArray(scaleList).get(i).toString());
		}
	}
	public List<String> getContentList() {
		return contentList;
	}

	public void setContentList(String contentList) {
		for(int i=0;i<JSON.parseArray(contentList).size();i++){
			this.contentList.add(JSON.parseArray(contentList).get(i).toString());
		}
	}
	
	private String byName;
    private String bySelectCompany;
    private String bySelectDepartment;
    private String bySelectPositionNo;
    private String byactivitiStatus;
    private String byYear;
    private String byMonth;
    private String showAllList;
    private String showPassedList;
    
	public String getShowPassedList() {
		return showPassedList;
	}

	public void setShowPassedList(String showPassedList) {
		this.showPassedList = showPassedList;
	}

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

	public String getBySelectPositionNo() {
		return bySelectPositionNo;
	}

	public void setBySelectPositionNo(String bySelectPositionNo) {
		this.bySelectPositionNo = bySelectPositionNo;
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
	
	private String empNo;
	private String empName;
	private String startTime;
	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	private String activitiID;
    
    public void setActivitiID(String activitiID) {
		this.activitiID = activitiID;
	}
	public ProbationEvaluationCondition getCondition(){
		ProbationEvaluationCondition probationEvaluationCondition = new ProbationEvaluationCondition();
        probationEvaluationCondition.setPageSize(this.getPageSize());
        probationEvaluationCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        probationEvaluationCondition.setSortItemList(sortItemList);
        
        if ("query".equals(this.showAllList)) {
        	probationEvaluationCondition.setWorkMateString(null);
        }else if("query".equals(this.showPassedList)){
        	probationEvaluationCondition.setWorkMateString(null);
        	probationEvaluationCondition.setActivitiStatus(1);
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
	            probationEvaluationCondition.setWorkMateString(workMateString);
	        } else {
	        	probationEvaluationCondition.setWorkMateString(String.valueOf(EmployeeModel.getEmpByUserId(UserHelper.getUserCache().getUserId()).getId()));
	        }
	    }
	    if(!StringHelper.isNullOrEmpty(this.byName)){
	    	Employee e = EmployeeModel.getEmpByEmpName(this.byName);
	    	if(e!=null){
	    		probationEvaluationCondition.setEmpNo(e.getId());
	    	}else{
	    		probationEvaluationCondition.setEmpNo(-1);
	    	}
	    }
	    if(!StringHelper.isNullOrEmpty(this.bySelectPositionNo)){
	    	probationEvaluationCondition.setPositionNo(Integer.valueOf(this.bySelectPositionNo));
	    }
	    if(!StringHelper.isNullOrEmpty(this.bySelectCompany)){
	    	probationEvaluationCondition.setCompanyNo(Integer.valueOf(this.bySelectCompany));
	    }
	    if(!StringHelper.isNullOrEmpty(this.bySelectDepartment)){
	    	probationEvaluationCondition.setDeptNo(Integer.valueOf(this.bySelectDepartment));
	    }
	    if(!StringHelper.isNullOrEmpty(this.byactivitiStatus)){
	    	probationEvaluationCondition.setActivitiStatus(Integer.valueOf(this.byactivitiStatus));
	    }
	    
	    if(!StringHelper.isNullOrEmpty(this.byYear)&&!"".equals(this.byYear)&&!"0".equals(this.byYear)){
        	if(StringHelper.isNullOrEmpty(this.byMonth)||"".equals(this.byMonth)||"0".equals(this.byMonth)){
        		probationEvaluationCondition.setDateDown(this.byYear+"-"+"01"+"-"+"01");
        		probationEvaluationCondition.setDateUp(Integer.valueOf(this.byYear)+1+"-"+"01"+"-"+"01");
        	}else{
        		probationEvaluationCondition.setDateDown(this.byYear+"-"+this.byMonth+"-"+"01");
        		int nextMonth = Integer.valueOf(this.byMonth);
        		if(Integer.valueOf(this.byMonth)<12){
        			nextMonth = Integer.valueOf(this.byMonth)+1;
        		}else{
        			nextMonth=1;
        			this.byYear = Integer.valueOf(this.byYear)+1+"";
        		}
        		probationEvaluationCondition.setDateUp(this.byYear+"-"+nextMonth+"-"+"01");
        	}
        }
	    
        return probationEvaluationCondition;
	}

	@Override
    public String execute() throws Exception{
    	

        PagedList<ProbationEvaluation> probationEvaluationPagedList= ProbationEvaluationModel.getPagingList(this.getCondition());
        List<ProbationEvaluation> list = new ArrayList<ProbationEvaluation>();
        list = probationEvaluationPagedList.getResultList();
        ProbationEvaluation evaluation = new ProbationEvaluation();
        if("query".equals(this.showPassedList)){
        	for (int i = 0; i < list.size(); i++) {
        		evaluation = list.get(i);
        		String actNo = evaluation.getActivitiNo();
        		if(!StringHelper.isNullOrEmpty(actNo)){
        			ProbationWorkSummary summary = new ProbationWorkSummary();
        			summary = ProbationWorkSummaryModel.getInfoByActivitiNo(actNo);
        			if(summary!=null){
        				evaluation.setStartDate(summary.getStartTime());
        				evaluation.setEndDate(summary.getEndTime());
        			}
        		}
			}
        }
        this.setResultList(list);
        this.setPageCount(probationEvaluationPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(probationEvaluationPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(probationEvaluationPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
    	int editUserNo = UserHelper.getEditUserNo();
		info.setEditUserNo(editUserNo);
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
			int inUserNo = UserHelper.getEditUserNo();
            info.setInUserNo(inUserNo);
            if(!StringHelper.isNullOrEmpty(this.activitiID)){
        		info.setActivitiNo(this.activitiID);
        	}
			id = ProbationEvaluationModel.add(info);//id是返回的插入成功后的主键值
			List<ProbationEvaluationContentTemplate> pectList = ProbationEvaluationContentTemplateModel.getList();
			ProbationEvaluationScore pes = null;
			for(int i=0;i<pectList.size();i++){
				pes = new ProbationEvaluationScore();
				pes.setRecordNo(id);
				pes.setContentNo(pectList.get(i).getId());
				pes.setInUserNo(inUserNo);
				pes.setEditUserNo(editUserNo);
				if(this.getScoreList1().size()>i){
        			pes.setScore(Double.valueOf(this.getScoreList1().get(i)));
        		}else{
        			pes.setScore(Double.valueOf(this.getScoreList2().get(i-this.getScoreList1().size())));
        		}
        		ProbationEvaluationScoreModel.add(pes);
			}
			ProbationEvaluationContent pec =null;
			for(int j=0;j<this.getContentList().size();j++){
				pec = new ProbationEvaluationContent();
				pec.setRecordNo(id);
				pec.setContent(this.getContentList().get(j).toString());
				byte scale = 0;
				double score = 0;
				if(!StringHelper.isNullOrEmpty(this.getScaleList().get(j))){
					scale = Byte.valueOf(this.getScaleList().get(j));
				}
				if(!StringHelper.isNullOrEmpty(this.getScoreList3().get(j))){
					score = Double.valueOf(this.getScoreList3().get(j));
				}
				pec.setScale(scale);
				pec.setScore(score);
				pec.setInUserNo(inUserNo);
				pec.setEditUserNo(editUserNo);
				ProbationEvaluationContentModel.add(pec);
			}
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
                    if (ProbationEvaluationModel.update(info) > 0){
                    	List<ProbationEvaluationScore> probationEvaluationScoreList = ProbationEvaluationScoreModel.getListByRecordNo(info.getId());
                    	ProbationEvaluationScore ps = new ProbationEvaluationScore();
                    	for(int i=0; i<probationEvaluationScoreList.size();i++){
                    		ps = probationEvaluationScoreList.get(i);
                    		if(this.getScoreList1().size()>i){
                    			ps.setScore(Double.valueOf(this.getScoreList1().get(i)));
                    		}else{
                    			ps.setScore(Double.valueOf(this.getScoreList2().get(i-this.getScoreList1().size())));
                    		}
                    		ps.setEditUserNo(editUserNo);
                    		ProbationEvaluationScoreModel.update(ps);
                    	}
                    	List<ProbationEvaluationContent> probationEvaluationContentList = ProbationEvaluationContentModel.getListByRecordNo(info.getId());
                    	ProbationEvaluationContent pec = new ProbationEvaluationContent();
                    	for(int i=0; i<probationEvaluationContentList.size();i++){
                    		pec = probationEvaluationContentList.get(i);
                    		pec.setContent(this.contentList.get(i));
                    		pec.setScore(Double.valueOf(this.scoreList3.get(i)));
                    		pec.setScale(Byte.valueOf(this.scaleList.get(i)));
                    		pec.setEditUserNo(editUserNo);
                    		ProbationEvaluationContentModel.update(pec);
                    	}
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
		this.empName = UserHelper.getUserCache().getEmpName();
        if (StringHelper.isNullOrEmpty((this.id)+"")||this.id==0) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
            info = new ProbationEvaluation();
            List<ProbationEvaluationContent> pcList = new ArrayList<ProbationEvaluationContent>();
            for(int i=0;i<4;i++){
            	pcList.add(new ProbationEvaluationContent());
            }
            info.setProbationEvaluationContentList(pcList);
            List<ProbationEvaluationContentTemplate> probationEvaluationContentTemplateList = ProbationEvaluationContentTemplateModel.getList();
            info.setProbationEvaluationContentTemplateList(probationEvaluationContentTemplateList);
            countSize();
        } else {
            this.info = ProbationEvaluationModel.getInfo(this.id);
            info.setProbationEvaluationContentList(ProbationEvaluationContentModel.getListByRecordNo(info.getId()));
            List<ProbationEvaluationScore> probationEvaluationScoreList = ProbationEvaluationScoreModel.getListByRecordNo(info.getId());
            List<ProbationEvaluationContentTemplate> probationEvaluationContentTemplateList = new ArrayList<ProbationEvaluationContentTemplate>();
            ProbationEvaluationContentTemplate probationEvaluationContentTemplate = new ProbationEvaluationContentTemplate();
            for(ProbationEvaluationScore ps:probationEvaluationScoreList){
            	probationEvaluationContentTemplate = ProbationEvaluationContentTemplateModel.getInfo(ps.getContentNo());
            	probationEvaluationContentTemplate.setScore(ps.getScore());
            	probationEvaluationContentTemplateList.add(probationEvaluationContentTemplate);
            }
            info.setProbationEvaluationContentTemplateList(probationEvaluationContentTemplateList);
            countSize();
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

	public void countSize(){
		List<ProbationEvaluationContentTemplate> probationEvaluationContentTemplateList = ProbationEvaluationContentTemplateModel.getList();
		for(ProbationEvaluationContentTemplate p : probationEvaluationContentTemplateList){
			if(p.getType()==1){
				count1++;
			}else if(p.getType()==2){
				count2++;
			}
		}
	}
	
	public String getEmployeeStartTime(){
		EmployeeDetail ed = EmployeeDetailModel.getEmpDetailByEmpNo(Integer.valueOf(empNo)); 
		Date d = null;
		if(ed!=null){
			d = ed.getStartTime();
		}
		if(d==null){
			this.startTime = "";
			return SUCCESS;
		}
		this.startTime = new SimpleDateFormat("yyyy-MM-dd").format(d);
		return SUCCESS;
	}
	public String getProbationDate() {
		if(this.id!=0){
			this.info = ProbationEvaluationModel.getInfo(this.id);
		}
		
		return SUCCESS;
	}
}
