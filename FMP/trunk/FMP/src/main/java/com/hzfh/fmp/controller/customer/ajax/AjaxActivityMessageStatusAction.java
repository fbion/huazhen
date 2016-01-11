package com.hzfh.fmp.controller.customer.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.customer.model.ActivityMessageStatus;
import com.hzfh.api.customer.model.query.ActivityMessageStatusCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.customer.ActivityMessageStatusModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxActivityMessageStatusAction extends JqGridBaseAction<ActivityMessageStatus> {
	private ActivityMessageStatus info;
	public ActivityMessageStatus getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, ActivityMessageStatus.class);
    }

    @Override
    public String execute(){
    	ActivityMessageStatusCondition activityMessageStatusCondition = new ActivityMessageStatusCondition();
        activityMessageStatusCondition.setPageSize(this.getPageSize());
        activityMessageStatusCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        activityMessageStatusCondition.setSortItemList(sortItemList);

        PagedList<ActivityMessageStatus> activityMessageStatusPagedList= ActivityMessageStatusModel.getPagingList(activityMessageStatusCondition);
        this.setResultList(activityMessageStatusPagedList.getResultList());
        this.setPageCount(activityMessageStatusPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(activityMessageStatusPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(activityMessageStatusPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = ActivityMessageStatusModel.add(info);
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
                    if (ActivityMessageStatusModel.update(info) > 0){
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
            this.info = ActivityMessageStatusModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
