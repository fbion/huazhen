package com.hzfh.fmp.controller.sales.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.KnowledgeAttachment;
import com.hzfh.api.sales.model.ActivityAttachment;
import com.hzfh.api.sales.model.query.ActivityAttachmentCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.sales.ActivityAttachmentModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.KnowledgeAttachmentModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxActivityAttachmentAction extends JqGridBaseAction<ActivityAttachment> {
	private String activityNo;
	
	public String getActivityNo() {
		return activityNo;
	}

	public void setActivityNo(String activityNo) {
		this.activityNo = activityNo;
	}
	private ActivityAttachment info;
	public ActivityAttachment getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, ActivityAttachment.class);
    }
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String path;
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    private String type;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String execute() throws Exception{
    	ActivityAttachmentCondition activityAttachmentCondition = new ActivityAttachmentCondition();
        activityAttachmentCondition.setPageSize(this.getPageSize());
        activityAttachmentCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        activityAttachmentCondition.setSortItemList(sortItemList);

        PagedList<ActivityAttachment> activityAttachmentPagedList= ActivityAttachmentModel.getPagingList(activityAttachmentCondition);
        this.setResultList(activityAttachmentPagedList.getResultList());
        this.setPageCount(activityAttachmentPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(activityAttachmentPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(activityAttachmentPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
    public String uploadFile() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
        	ActivityAttachment activityAttachment = new ActivityAttachment();
        	activityAttachment.setActivityNo(Integer.parseInt(this.getId()));
        	activityAttachment.setName(this.name);
        	activityAttachment.setPath(this.path);
        	if (!StringHelper.isNullOrEmpty(this.type)) {
        	activityAttachment.setType((byte) 1);
        	}
        	activityAttachment.setStatus((byte) 1);
        	activityAttachment.setInUserNo(UserHelper.getEditUserNo());
            int fileID =ActivityAttachmentModel.add(activityAttachment);
            if (fileID > 0)
                this.setErrDesc(String.valueOf(fileID));
            else {
                this.setErrCode("uploadFailed");
                this.setErrDesc("NoID");
            }
        }
        return SUCCESS;
    }

    public String deleteFile() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            if (ActivityAttachmentModel.updateStatus(Integer.parseInt(this.getId()),(byte)0) < 0){
                this.setErrCode("deleteFailed");
                this.setErrDesc("deleteFailed");
            }
        }
        return SUCCESS;
    }

    public String getFileList(){
        if (StringHelper.isNullOrEmpty(this.activityNo)) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        }
        else{
        	if (StringHelper.isNullOrEmpty(this.type)) {
        		//活动中心附件
        		this.setResultList(ActivityAttachmentModel.getListByActivityNo(Integer.parseInt(this.activityNo)));
        	}
        	else{
        		//打款的附件
        		this.setResultList(ActivityAttachmentModel.getListBySalesNo(Integer.parseInt(this.activityNo)));
        	}
        }

        return SUCCESS;
    }


}
