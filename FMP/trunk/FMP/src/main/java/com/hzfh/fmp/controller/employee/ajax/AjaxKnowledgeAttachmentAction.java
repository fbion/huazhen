package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.KnowledgeAttachment;
import com.hzfh.api.employee.model.query.KnowledgeAttachmentCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.KnowledgeAttachmentModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxKnowledgeAttachmentAction extends JqGridBaseAction<KnowledgeAttachment> {
	private String knowledgeNo;
	public String getKnowledgeNo() {
		return knowledgeNo;
	}
	public void setKnowledgeNo(String knowledgeNo) {
		this.knowledgeNo = knowledgeNo;
	}
	private KnowledgeAttachment info;
	public KnowledgeAttachment getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = JSON.parseObject(info, KnowledgeAttachment.class);
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
    	KnowledgeAttachmentCondition knowledgeAttachmentCondition = new KnowledgeAttachmentCondition();
        knowledgeAttachmentCondition.setPageSize(this.getPageSize());
        knowledgeAttachmentCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        knowledgeAttachmentCondition.setSortItemList(sortItemList);

        PagedList<KnowledgeAttachment> knowledgeAttachmentPagedList= KnowledgeAttachmentModel.getPagingList(knowledgeAttachmentCondition);
        this.setResultList(knowledgeAttachmentPagedList.getResultList());
        this.setPageCount(knowledgeAttachmentPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(knowledgeAttachmentPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(knowledgeAttachmentPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String uploadFile() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
        	KnowledgeAttachment knowledgeAttachment = new KnowledgeAttachment();
        	knowledgeAttachment.setKnowledgeNo(Integer.parseInt(this.getId()));
        	knowledgeAttachment.setName(this.name);
        	knowledgeAttachment.setPath(this.path);
        	knowledgeAttachment.setStatus((byte) 1);
        	knowledgeAttachment.setInUserNo(UserHelper.getEditUserNo());
            int fileID =KnowledgeAttachmentModel.add(knowledgeAttachment);

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
            if (KnowledgeAttachmentModel.updateStatus(Integer.parseInt(this.getId()),(byte)0) < 0){
                this.setErrCode("deleteFailed");
                this.setErrDesc("deleteFailed");
            }
        }
        return SUCCESS;
    }

    public String getFileList(){
        if (StringHelper.isNullOrEmpty(this.knowledgeNo)) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        }
        else{
            this.setResultList(KnowledgeAttachmentModel.getListByKnowledgeNo(Integer.parseInt(this.knowledgeNo)));
        }

        return SUCCESS;
    }

}
