package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.EvaluationContent;
import com.hzfh.api.employee.model.EvaluationScore;
import com.hzfh.api.employee.model.InterviewEvaluationRecord;
import com.hzfh.api.employee.model.query.InterviewEvaluationRecordCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.employee.EvaluationContentModel;
import com.hzfh.fmp.model.employee.EvaluationScoreModel;
import com.hzfh.fmp.model.employee.InterviewEvaluationRecordModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxInterviewEvaluationRecordAction extends JqGridBaseAction<InterviewEvaluationRecord> {
	private InterviewEvaluationRecord info;
	public InterviewEvaluationRecord getInfo() {
        return info;
    }
	private InterviewEvaluationRecord info1;
	private InterviewEvaluationRecord info2;
	public InterviewEvaluationRecord getInfo1() {
		return info1;
	}
	public void setInfo1(String info1) {
		this.info1 = JSON.parseObject(info1, InterviewEvaluationRecord.class);
	}
	public InterviewEvaluationRecord getInfo2() {
		return info2;
	}
	public void setInfo2(String info2) {
		this.info2 = JSON.parseObject(info2, InterviewEvaluationRecord.class);
	}

	private List<EvaluationScore> evaluationScoreList;
	public List<EvaluationScore> getEvaluationScoreList() {
		return evaluationScoreList;
	}
	public void setEvaluationScoreList(List<EvaluationScore> evaluationScoreList) {
		this.evaluationScoreList = evaluationScoreList;
	}
	
	private String totalScore1;
	private String totalScore2;
	public String getTotalScore1() {
		return totalScore1;
	}
	public void setTotalScore1(String totalScore1) {
		this.totalScore1 = totalScore1;
	}
	public String getTotalScore2() {
		return totalScore2;
	}
	public void setTotalScore2(String totalScore2) {
		this.totalScore2 = totalScore2;
	}

	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private InterviewEvaluationRecord interviewEvaluationRecord1;
	private InterviewEvaluationRecord interviewEvaluationRecord2;
	public InterviewEvaluationRecord getInterviewEvaluationRecord1() {
		return interviewEvaluationRecord1;
	}
	public void setInterviewEvaluationRecord1(
			InterviewEvaluationRecord interviewEvaluationRecord1) {
		this.interviewEvaluationRecord1 = interviewEvaluationRecord1;
	}
	public InterviewEvaluationRecord getInterviewEvaluationRecord2() {
		return interviewEvaluationRecord2;
	}
	public void setInterviewEvaluationRecord2(
			InterviewEvaluationRecord interviewEvaluationRecord2) {
		this.interviewEvaluationRecord2 = interviewEvaluationRecord2;
	}
	
	private List<EvaluationContent> evaluationContentList1 = new ArrayList<EvaluationContent>();
	private List<EvaluationContent> evaluationContentList2 = new ArrayList<EvaluationContent>();
	public List<EvaluationContent> getEvaluationContentList1() {
		return evaluationContentList1;
	}
	public void setEvaluationContentList1(
			List<EvaluationContent> evaluationContentList1) {
		this.evaluationContentList1 = evaluationContentList1;
	}
	public List<EvaluationContent> getEvaluationContentList2() {
		return evaluationContentList2;
	}
	public void setEvaluationContentList2(
			List<EvaluationContent> evaluationContentList2) {
		this.evaluationContentList2 = evaluationContentList2;
	}
	
	private String byName;
    private String bySelectPositionNo;
    private String byYear;
    private String byMonth;
    private String showAllList;
	public String getByName() {
		return byName;
	}
	public void setByName(String byName) {
		this.byName = byName;
	}
	public String getBySelectPositionNo() {
		return bySelectPositionNo;
	}
	public void setBySelectPositionNo(String bySelectPositionNo) {
		this.bySelectPositionNo = bySelectPositionNo;
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
	
	
	private List<String> scoreList1 = new ArrayList<String>();
	private List<String> scoreList2 = new ArrayList<String>();
	private boolean showReTest;
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
	public boolean isShowReTest() {
		return showReTest;
	}
	public void setShowReTest(boolean showReTest) {
		this.showReTest = showReTest;
	}
	
	private int empNo1;
	private int empNo2;
	public int getEmpNo1() {
		return empNo1;
	}
	public int getEmpNo2() {
		return empNo2;
	}
	public InterviewEvaluationRecordCondition getCondition(){
		InterviewEvaluationRecordCondition interviewEvaluationRecordCondition = new InterviewEvaluationRecordCondition();
        interviewEvaluationRecordCondition.setPageSize(this.getPageSize());
        interviewEvaluationRecordCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        interviewEvaluationRecordCondition.setSortItemList(sortItemList);
        interviewEvaluationRecordCondition.setRetestUserNo(UserHelper.getUserCache().getUserId());
        if ("query".equals(this.showAllList)) {
        	interviewEvaluationRecordCondition.setWorkMateString(null);
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
	            interviewEvaluationRecordCondition.setWorkMateString(workMateString);
	        } else {
	        	interviewEvaluationRecordCondition.setWorkMateString(String.valueOf(EmployeeModel.getEmpByUserId(UserHelper.getUserCache().getUserId()).getId()));
	        }
	    }
        if(!StringHelper.isNullOrEmpty(this.byName)){
        	interviewEvaluationRecordCondition.setName(this.byName);
        }
        if(!StringHelper.isNullOrEmpty(this.bySelectPositionNo)){
        	interviewEvaluationRecordCondition.setPositionNo(Integer.valueOf(this.bySelectPositionNo));
        }
        if(!StringHelper.isNullOrEmpty(this.byYear)&&!"".equals(this.byYear)&&!"0".equals(this.byYear)){
        	if(StringHelper.isNullOrEmpty(this.byMonth)||"".equals(this.byMonth)||"0".equals(this.byMonth)){
        		interviewEvaluationRecordCondition.setDateDown(this.byYear+"-"+"01"+"-"+"01");
        		interviewEvaluationRecordCondition.setDateUp(Integer.valueOf(this.byYear)+1+"-"+"01"+"-"+"01");
        	}else{
        		interviewEvaluationRecordCondition.setDateDown(this.byYear+"-"+this.byMonth+"-"+"01");
        		int nextMonth = Integer.valueOf(this.byMonth);
        		if(Integer.valueOf(this.byMonth)<12){
        			nextMonth = Integer.valueOf(this.byMonth)+1;
        		}else{
        			nextMonth=1;
        			this.byYear = Integer.valueOf(this.byYear)+1+"";
        		}
        		interviewEvaluationRecordCondition.setDateUp(this.byYear+"-"+nextMonth+"-"+"01");
        	}
        }
        return interviewEvaluationRecordCondition;
	}
	@Override
    public String execute() throws Exception{
		
        PagedList<InterviewEvaluationRecord> interviewEvaluationRecordPagedList= InterviewEvaluationRecordModel.getPagingList(this.getCondition());
        this.setResultList(interviewEvaluationRecordPagedList.getResultList());
        this.setPageCount(interviewEvaluationRecordPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(interviewEvaluationRecordPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(interviewEvaluationRecordPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info1.setEditUserNo(UserHelper.getEditUserNo());
		if(info2!=null){
			info2.setEditUserNo(UserHelper.getEditUserNo());
		}
		int id1 = 0;
		int id2 = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
			EvaluationScore evaluationScore = new EvaluationScore();
            if(info2==null){
            	///初试
            	info1.setInUserNo(UserHelper.getEditUserNo());
            	id1 = InterviewEvaluationRecordModel.add(info1);
            	
            	interviewEvaluationRecord1 = InterviewEvaluationRecordModel.getInfo(id1);
            	List<EvaluationContent> evaluationContentList = EvaluationContentModel.getListByTypeAndParentNo((byte) 1,0);//父级
            	if(evaluationContentList.size()>0){
            		evaluationScore.setEvaluationRecordNo(interviewEvaluationRecord1.getId());
            		evaluationScore.setEvaluationContentNo(evaluationContentList.get(0).getId());
            		EvaluationScoreModel.add(evaluationScore);
            		
            		List<EvaluationContent> childrenList1 = EvaluationContentModel.getListByTypeAndParentNo((byte) 1,evaluationContentList.get(0).getId());//子级1
            		
            		for(int i=0;i<childrenList1.size();i++){
            			evaluationScore.setEvaluationRecordNo(interviewEvaluationRecord1.getId());
            			evaluationScore.setEvaluationContentNo(childrenList1.get(i).getId());
            			double score = 0.0;
            			if(this.getScoreList1().get(i)!=""&&this.getScoreList1().get(i)!=null){
            				score = Double.valueOf((String) this.getScoreList1().get(i));
            			}
            			evaluationScore.setScore(score);
            			EvaluationScoreModel.add(evaluationScore);
            		}
            		evaluationScore = new EvaluationScore();
            		evaluationScore.setEvaluationRecordNo(interviewEvaluationRecord1.getId());
            		evaluationScore.setEvaluationContentNo(evaluationContentList.get(1).getId());
            		EvaluationScoreModel.add(evaluationScore);
            		
            		List<EvaluationContent> childrenList2 = EvaluationContentModel.getListByTypeAndParentNo((byte) 1,evaluationContentList.get(1).getId());//子级2
            		for(int i=childrenList1.size();i<childrenList2.size()+childrenList1.size();i++){
            			evaluationScore.setEvaluationRecordNo(interviewEvaluationRecord1.getId());
            			evaluationScore.setEvaluationContentNo(childrenList2.get(i-childrenList1.size()).getId());
            			double score = 0.0;
            			if(!"".equals(this.getScoreList1().get(i))||this.getScoreList1().get(i)!=null){
            				score = Double.valueOf((String) this.getScoreList1().get(i));
            			}
            			evaluationScore.setScore(score);
            			EvaluationScoreModel.add(evaluationScore);
            		}
            	}
            }else{
            	///复试
            	info1.setInUserNo(UserHelper.getEditUserNo());
            	id1 = InterviewEvaluationRecordModel.update(info1);
            	info2.setInUserNo(UserHelper.getEditUserNo());
                id2 = InterviewEvaluationRecordModel.add(info2);
    			
    			interviewEvaluationRecord2 = InterviewEvaluationRecordModel.getInfo(id2);
    			List<EvaluationContent> evaluationContentList = EvaluationContentModel.getListByTypeAndParentNo((byte) 2,0);//父级
    			int num = 0;
    			for(int i=0;i<evaluationContentList.size();i++){
    				List<EvaluationContent> childrenList = EvaluationContentModel.getListByTypeAndParentNo((byte) 2,evaluationContentList.get(i).getId());//子级
    				if(childrenList.size()<=0){
    					evaluationScore.setEvaluationRecordNo(interviewEvaluationRecord2.getId());
        				evaluationScore.setEvaluationContentNo(evaluationContentList.get(i).getId());
        				double score = 0.0;
        				if(!StringHelper.isNullOrEmpty(this.getScoreList2().get(i))&&!"".equals(this.getScoreList2().get(i))&&this.getScoreList2().get(i)!=null){
        					score = Double.valueOf((String) this.getScoreList2().get(i));///
        				}
        				evaluationScore.setScore(score);
        				EvaluationScoreModel.add(evaluationScore);
        				num+=1;
    				}else{
    					evaluationScore = new EvaluationScore();
    	    			evaluationScore.setEvaluationRecordNo(interviewEvaluationRecord2.getId());
    	    			evaluationScore.setEvaluationContentNo(evaluationContentList.get(i).getId());
    	    			EvaluationScoreModel.add(evaluationScore);
    	    			for(int j=num;j<childrenList.size()+num;j++){
    	    				evaluationScore.setEvaluationRecordNo(interviewEvaluationRecord2.getId());
    	    				evaluationScore.setEvaluationContentNo(childrenList.get(j-num).getId());
    	    				double score = 0.0;
    	    				if(!StringHelper.isNullOrEmpty(this.getScoreList2().get(j))&&!"".equals(this.getScoreList2().get(j))&&this.getScoreList2().get(j)!=null){
    	    					score = Double.valueOf((String) this.getScoreList2().get(j));
    	    				}
    	    				evaluationScore.setScore(score);
    	    				EvaluationScoreModel.add(evaluationScore);
    	    			}
    				}
    			}
            }
            
            if (id2 > 0){
				this.setErrDesc(String.valueOf(id2));                
            }else if(id1>0){
            	this.setErrDesc(String.valueOf(id1));
            }else{
				this.setErrCode("add failed");
                this.setErrDesc("add failed");
			}
                
        }
        else
        {
            if (info1.getId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            }
            else{
                if (this.getOper().equalsIgnoreCase("edit")) {
                	info = InterviewEvaluationRecordModel.getInfo(info1.getId());
                	List<InterviewEvaluationRecord> interviewEvaluationRecordList = InterviewEvaluationRecordModel.getInfoListByName(info.getName());
                	EvaluationScore evaluationScore = new EvaluationScore();
                	if(interviewEvaluationRecordList.size()==1){
                		List<EvaluationScore> evaluationScoreList1 = EvaluationScoreModel.getListByEvaluationRecordNo(interviewEvaluationRecordList.get(0).getId());
                		
                		if (InterviewEvaluationRecordModel.update(info1) > 0){
                			//初试的分数
                			//以下循环已写死，待优化
                			for(int i=1;i<7;i++){
                				evaluationScore=evaluationScoreList1.get(i);
                				double score = 0.0;
                				if(!StringHelper.isNullOrEmpty(this.getScoreList1().get(i-1))&&!"".equals(this.getScoreList1().get(i-1))&&this.getScoreList1().get(i-1)!=null){
                					score = Double.valueOf((String) this.getScoreList1().get(i-1));
                				}
                				evaluationScore.setScore(score);
                				EvaluationScoreModel.update(evaluationScore);
                			}
                			for(int i=8;i<12;i++){
                				evaluationScore=evaluationScoreList1.get(i);
                				double score = 0.0;
                				if(!StringHelper.isNullOrEmpty(this.getScoreList1().get(i-2))&&!"".equals(this.getScoreList1().get(i-2))&&this.getScoreList1().get(i-2)!=null){
                					score = Double.valueOf((String) this.getScoreList1().get(i-2));
                				}
                				evaluationScore.setScore(score);
                				EvaluationScoreModel.update(evaluationScore);
                			}
                			this.setErrDesc(String.valueOf(info1.getId()));
                		}else{
                			this.setErrCode("update failed");
                			this.setErrDesc("update failed");
                		}
                	}
                    if(interviewEvaluationRecordList.size()>1){
                		info2.setId(interviewEvaluationRecordList.get(1).getId());
                		List<EvaluationScore> evaluationScoreList2 = EvaluationScoreModel.getListByEvaluationRecordNo(interviewEvaluationRecordList.get(1).getId());
                		if(InterviewEvaluationRecordModel.update(info2) > 0){
                			//复试的分数
                			//以下循环已写死，待优化
                			for(int i=12;i<14;i++){
                				evaluationScore=evaluationScoreList2.get(i-12);
                				double score = 0.0;
                				if(!StringHelper.isNullOrEmpty(this.getScoreList2().get(i-12))&&!"".equals(this.getScoreList2().get(i-12))&&this.getScoreList2().get(i-12)!=null){
                					score = Double.valueOf((String) this.getScoreList2().get(i-12));
                				}
                				evaluationScore.setScore(score);
                				EvaluationScoreModel.update(evaluationScore);
                			}
                			for(int i=15;i<19;i++){
                				evaluationScore=evaluationScoreList2.get(i-12);
                				double score = 0.0;
                				if(!StringHelper.isNullOrEmpty(this.getScoreList2().get(i-13))&&!"".equals(this.getScoreList2().get(i-13))&&this.getScoreList2().get(i-13)!=null){
                					score = Double.valueOf((String) this.getScoreList2().get(i-13));
                				}
                				evaluationScore.setScore(score);
                				EvaluationScoreModel.update(evaluationScore);
                			}
                			this.setErrDesc(String.valueOf(info2.getId()));
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
            this.info = InterviewEvaluationRecordModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

	public String getInfoListByName() {
		if (StringHelper.isNullOrEmpty(this.getName())) {
			List<EvaluationContent> evaluationContentList = EvaluationContentModel.getList();
			for(EvaluationContent e:evaluationContentList){
				if(e.getType()==1){
					evaluationContentList1.add(e);
				}
				/*if(e.getType()==2){
					evaluationContentList2.add(e);
				}*/
			}
			Employee emp = new Employee();
			emp = EmployeeModel.getEmpByUserId(UserHelper.getEditUserNo());
			this.empNo1 = emp.getId();
			this.setErrCode("NoName");
			this.setErrDesc("NoName");
		} else {
			List<InterviewEvaluationRecord> interviewEvaluationRecordList = InterviewEvaluationRecordModel.getInfoListByName(this.getName());
			if(interviewEvaluationRecordList.size()>1){//初试复试都已填过
				interviewEvaluationRecord1 = interviewEvaluationRecordList.get(0);
				interviewEvaluationRecord2 = interviewEvaluationRecordList.get(1);
				for(int i=0;i<interviewEvaluationRecordList.size();i++){
					evaluationScoreList = EvaluationScoreModel.getListByEvaluationRecordNo(interviewEvaluationRecordList.get(i).getId());
					EvaluationContent evaluationContent = new EvaluationContent();
					for(EvaluationScore evaluationScore :evaluationScoreList){
						evaluationContent = EvaluationContentModel.getInfoByIdAndEvaluationRecordNo(evaluationScore.getEvaluationRecordNo(),evaluationScore.getEvaluationContentNo());//sql查出来的会带分数
						if(i==0){
							evaluationContentList1.add(evaluationContent);
						}else{
							evaluationContentList2.add(evaluationContent);
						}
					}
				}
				totalScore1 = interviewEvaluationRecord1.getTotalScore()+"";
				totalScore2 = interviewEvaluationRecord2.getTotalScore()+"";
			}else if(interviewEvaluationRecordList.size()==1) {//只填了初试的
				interviewEvaluationRecord1 = interviewEvaluationRecordList.get(0);
				evaluationScoreList = EvaluationScoreModel.getListByEvaluationRecordNo(interviewEvaluationRecord1.getId());
				EvaluationContent evaluationContent = new EvaluationContent();
				for(EvaluationScore evaluationScore :evaluationScoreList){
					evaluationContent = EvaluationContentModel.getInfoByIdAndEvaluationRecordNo(evaluationScore.getEvaluationRecordNo(),evaluationScore.getEvaluationContentNo());//sql查出来的会带分数
					evaluationContentList1.add(evaluationContent);
				}
				totalScore1 = interviewEvaluationRecord1.getTotalScore()+"";
				if(showReTest){//显示复试
					List<EvaluationContent> evaluationContentList = EvaluationContentModel.getList();
					for(EvaluationContent e:evaluationContentList){
						if(e.getType()==2){
							evaluationContentList2.add(e);
						}
					}
					Employee emp = new Employee();
					emp = EmployeeModel.getEmpByUserId(UserHelper.getEditUserNo());
					this.empNo2 = emp.getId();
					this.setErrCode("0001");
				}
			}else {
				List<EvaluationContent> evaluationContentList = EvaluationContentModel.getList();
				for(EvaluationContent e:evaluationContentList){
					if(e.getType()==1){
						evaluationContentList1.add(e);
					}
					/*if(e.getType()==2){
						evaluationContentList2.add(e);
					}*/
				}
				this.setErrCode("No Info");
                this.setErrDesc("No Info");
			}
		}
		
		return SUCCESS;
	}
	
}
