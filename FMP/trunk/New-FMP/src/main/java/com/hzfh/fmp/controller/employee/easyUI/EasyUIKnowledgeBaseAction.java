package com.hzfh.fmp.controller.employee.easyUI;

import com.hzfh.api.employee.model.KnowledgeBase;
import com.hzfh.api.employee.model.query.KnowledgeBaseCondition;
import com.hzfh.fmp.controller.common.EasyUIBaseAction;
import com.hzfh.fmp.model.employee.KnowledgeBaseModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class EasyUIKnowledgeBaseAction extends EasyUIBaseAction<KnowledgeBase> {

    private String type;

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String execute() throws Exception{
    	KnowledgeBaseCondition knowledgeBaseCondition = new KnowledgeBaseCondition();
        knowledgeBaseCondition.setPageSize(this.getPageSize());
        knowledgeBaseCondition.setPageIndex(this.getPage());
        List<SortItem> sortItemList = new ArrayList<>();
        for (SortItem sortItem : this.getSortList()) {
            SortItem newSortItem = new SortItem();
            newSortItem.setSortFeild(sortItem.getSort());
            newSortItem.setSortType("asc".equalsIgnoreCase(sortItem.getOrder()) ? SortType.ASC : SortType.DESC);
            sortItemList.add(newSortItem);
        }
        knowledgeBaseCondition.setSortItemList(sortItemList);
        if (!StringHelper.isNullOrEmpty(this.type)) {
            knowledgeBaseCondition.setByType(Integer.parseInt(this.type));
        }
        PagedList<KnowledgeBase> knowledgeBasePagedList= KnowledgeBaseModel.getPagingList(knowledgeBaseCondition);
        this.setRows(knowledgeBasePagedList.getResultList());
        this.setTotal(knowledgeBasePagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

}
