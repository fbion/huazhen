package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.KnowledgeBase;
import com.hzfh.api.employee.model.query.KnowledgeBaseCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.KnowledgeBaseModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxKnowledgeBaseAction extends JqGridBaseAction<KnowledgeBase> {
	private KnowledgeBase info;
	public KnowledgeBase getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, KnowledgeBase.class);
    }

    private String byType;
    private String byTitle;

    public String getByType() {
        return byType;
    }

    public void setByType(String byType) {
        this.byType = byType;
    }

    public String getByTitle() {
        return byTitle;
    }

    public void setByTitle(String byTitle) {
        this.byTitle = byTitle;
    }

    @Override
    public String execute() throws Exception{
    	KnowledgeBaseCondition knowledgeBaseCondition = new KnowledgeBaseCondition();
        knowledgeBaseCondition.setPageSize(this.getPageSize());
        knowledgeBaseCondition.setPageIndex(this.getPageIndex());
        if (!StringHelper.isNullOrEmpty(this.byType)) {
            knowledgeBaseCondition.setByType(Integer.parseInt(this.byType));
        }
        if (!StringHelper.isNullOrEmpty(this.byTitle)) {
            knowledgeBaseCondition.setByTitle(this.byTitle);
        }
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        knowledgeBaseCondition.setSortItemList(sortItemList);

        PagedList<KnowledgeBase> knowledgeBasePagedList= KnowledgeBaseModel.getPagingList(knowledgeBaseCondition);
        this.setResultList(knowledgeBasePagedList.getResultList());
        this.setPageCount(knowledgeBasePagedList.getPagingInfo().getPageCount());
        this.setPageIndex(knowledgeBasePagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(knowledgeBasePagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = KnowledgeBaseModel.add(info);
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
            	//录入人id
            	int inUserNo=KnowledgeBaseModel.getInfo(info.getId()).getInUserNo();
            	//如果录入人id等于当前user可修改
            	if(inUserNo==UserHelper.getEditUserNo()){
            		if (this.getOper().equalsIgnoreCase("edit")) {                    
                        if (KnowledgeBaseModel.update(info) > 0){
    						this.setErrDesc(String.valueOf(info.getId()));
                        }else{
    						this.setErrCode("update failed");
                            this.setErrDesc("update failed");
    					}
                            
                    }
            	}else{
					this.setErrCode("修改失败");
                    this.setErrDesc("修改失败");
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
            this.info = KnowledgeBaseModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
