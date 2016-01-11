package com.hzfh.fmp.controller.market.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.market.model.ActivityUsers;
import com.hzfh.api.market.model.query.ActivityUsersCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.market.ActivityUsersModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxActivityUsersAction extends JqGridBaseAction<ActivityUsers> {
	
	private String checkValue;
	public String getCheckValue() {
		return checkValue;
	}

	public void setCheckValue(String checkValue) {
		this.checkValue = checkValue;
	}
	private List<ActivityUsers> activityUsers;
	
	public List<ActivityUsers> getUserList() {
		return activityUsers;
	}

	public void setUserList(List<ActivityUsers> userList) {
		this.activityUsers = userList;
	}
	private ActivityUsers info;
	public ActivityUsers getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, ActivityUsers.class);
    }

    @Override
    public String execute(){
    	ActivityUsersCondition activityUsersCondition = new ActivityUsersCondition();
        activityUsersCondition.setPageSize(this.getPageSize());
        activityUsersCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        activityUsersCondition.setSortItemList(sortItemList);

        PagedList<ActivityUsers> activityUsersPagedList= ActivityUsersModel.getPagingList(activityUsersCondition);
        this.setResultList(activityUsersPagedList.getResultList());
        this.setPageCount(activityUsersPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(activityUsersPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(activityUsersPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = ActivityUsersModel.add(info);
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
                    if (ActivityUsersModel.update(info) > 0){
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
            this.info = ActivityUsersModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }
	public String getInfoListById() {
		
		if(checkValue!=null){
			String [] arrId =checkValue.split(",");
			for(int i=0;i<arrId.length;i++){
				activityUsers = new ArrayList<ActivityUsers>();
				activityUsers.add(ActivityUsersModel.getInfo(Integer.parseInt(arrId[i])));
			}
		}
		
		this.setErrCode("No Info");
        this.setErrDesc("No Info");
        

        return SUCCESS;
    }

}
