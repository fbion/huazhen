package com.hzfh.fmp.controller.baseInfo.ajax;

import com.hzfh.api.baseInfo.model.DicType;
import com.hzfh.api.baseInfo.model.query.DicTypeCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.baseInfo.DicTypeModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxDicTypeAction extends JqGridBaseAction<DicType> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String execute() throws Exception {
        DicTypeCondition dicTypeCondition = new DicTypeCondition();
        dicTypeCondition.setPageSize(this.getPageSize());
        dicTypeCondition.setPageIndex(this.getPageIndex());

        if (StringHelper.isNullOrEmpty(this.status))
            dicTypeCondition.setStatus((byte)1);
        else
            dicTypeCondition.setStatus(Byte.valueOf(this.status));
        if (!StringHelper.isNullOrEmpty(this.name))
            dicTypeCondition.setName(this.name);

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        dicTypeCondition.setSortItemList(sortItemList);

        PagedList<DicType> dicTypePagedList = DicTypeModel.getPagingList(dicTypeCondition);
        this.setResultList(dicTypePagedList.getResultList());
        this.setPageCount(dicTypePagedList.getPagingInfo().getPageCount());
        this.setPageIndex(dicTypePagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(dicTypePagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit() {
        DicType dicType = new DicType();

        dicType.setName(this.name);
        dicType.setRemarks(this.remarks);
        dicType.setStatus(Byte.parseByte(this.status));
        dicType.setEditComment(this.getEditComment());
        dicType.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")) {
        	dicType.setInUserNo(UserHelper.getEditUserNo());
            if (DicTypeModel.add(dicType) <= 0) {
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }
        } else {
            if (this.getId().isEmpty()) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            } else {
                if (this.getOper().equalsIgnoreCase("edit")) {
                    dicType.setId(Integer.parseInt(this.getId()));
                    if (DicTypeModel.update(dicType) <= 0) {
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }

        return SUCCESS;
    }

}
