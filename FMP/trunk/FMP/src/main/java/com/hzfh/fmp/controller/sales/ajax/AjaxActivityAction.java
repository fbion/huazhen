package com.hzfh.fmp.controller.sales.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.sales.model.Activity;
import com.hzfh.api.sales.model.ApplyEmployee;
import com.hzfh.api.sales.model.query.ActivityCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.sales.ActivityModel;
import com.hzfh.fmp.model.sales.ApplyEmployeeModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AjaxActivityAction extends JqGridBaseAction<Activity> {
	private boolean showSignButton;

    public boolean isShowSignButton() {
        return showSignButton;
    }

	private Activity info;
	public Activity getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, Activity.class);
    }
    private int byStatus;
    private String byTime;
    
    public int getByStatus() {
		return byStatus;
	}

	public void setByStatus(int byStatus) {
		this.byStatus = byStatus;
	}

	public String getByTime() {
		return byTime;
	}

	public void setByTime(String byTime) {
		this.byTime = byTime;
	}
	private int status;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	private int releaseId;
	
	public int getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(int releaseId) {
		this.releaseId = releaseId;
	}

	private ActivityCondition getCondition(){
    	ActivityCondition activityCondition=new ActivityCondition();
    	activityCondition.setPageSize(this.getPageSize());
    	activityCondition.setPageIndex(this.getPageIndex());
    	 List<SortItem> sortItemList = new ArrayList<SortItem>();
         SortItem sortItem = new SortItem();
         sortItem.setSortFeild(this.getSidx());
         sortItem.setSortType(this.getSortType());
         sortItemList.add(sortItem);
         activityCondition.setSortItemList(sortItemList);
    	 if(this.byStatus>0){
    		 activityCondition.setByStatus(this.byStatus);
    	 }
    	 if(!StringHelper.isNullOrEmpty(this.byTime)){
    		 activityCondition.setByTime(this.byTime);
         }
    	return activityCondition;
    }
    @Override
    public String execute() throws Exception{
    
        PagedList<Activity> activityPagedList= ActivityModel.getPagingList(this.getCondition());
        this.setResultList(activityPagedList.getResultList());
        this.setPageCount(activityPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(activityPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(activityPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
    public String release(){
    	Activity activity=ActivityModel.getInfo(releaseId);
    	activity.setStatus(status);
    	activity.setPublisher(UserHelper.getEditUserNo());
    	activity.setActivityTime(new Date());
    	if (ActivityModel.update(activity) > 0){
				this.setErrDesc(String.valueOf(releaseId));
        }else{
				this.setErrCode("update failed");
				this.setErrDesc("update failed");
		}
    	return SUCCESS;
    }
    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
            //如果是新建第一次提交为储备状态
            info.setStatus(1);
			id = ActivityModel.add(info);
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
                	//如果是更新则不改变状态
                    if (ActivityModel.update(info) > 0){
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
            this.info = ActivityModel.getInfo(Integer.parseInt(this.getId()));
            ApplyEmployee applyEmployee=new ApplyEmployee();
            applyEmployee.setActivityNo(Integer.parseInt(this.getId()));
            applyEmployee.setEmpNo(UserHelper.getEditUserNo());
            ApplyEmployee applyEmployee1=ApplyEmployeeModel.getInfoByAnoEno(applyEmployee);
            if(info.getStatus()==2&&applyEmployee1==null){
            this.showSignButton = true;
            }
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }
        
       
        return SUCCESS;
    }

}
