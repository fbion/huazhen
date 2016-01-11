package com.hzfh.fmp.controller.product.ajax;


import com.alibaba.fastjson.JSON;
import com.hzfh.api.product.model.FinancierPersonal;
import com.hzfh.api.product.model.query.FinancierPersonalCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.EnumListCacheModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.product.FinancierPersonalModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;

public class AjaxFinancierPersonalAction extends JqGridBaseAction<FinancierPersonal> {

    private FinancierPersonal info;

    public FinancierPersonal getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, FinancierPersonal.class);
    }

    private String managerNo;

    public String getManagerNo() {
        return managerNo;
    }

    public void setManagerNo(String managerNo) {
        this.managerNo = managerNo;
    }

    private String byName;
    private String showAllList;

    public void setByName(String byName) {
        this.byName = byName;
    }

    public void setShowAllList(String showAllList) {
        this.showAllList = showAllList;
    }

    @Override
    public String execute() throws Exception {
        FinancierPersonalCondition financierPersonalCondition = new FinancierPersonalCondition();
        financierPersonalCondition.setPageSize(this.getPageSize());
        financierPersonalCondition.setPageIndex(this.getPageIndex());
        if ("query".equals(this.showAllList)) {
            financierPersonalCondition.setWorkMateString(null);
        }else{
            List<Integer> workmate = UserHelper.getUserCache().getWorkMate();
            if (workmate != null) {
                workmate.add(UserHelper.getUserCache().getUserId());
                String workMateString = StringHelper.listToString(workmate);
                financierPersonalCondition.setWorkMateString(workMateString);
            } else {
                financierPersonalCondition.setWorkMateString(String.valueOf(UserHelper.getUserCache().getUserId()));
            }
        }

        if (!StringHelper.isNullOrEmpty(this.byName)) {
            financierPersonalCondition.setName(this.byName);
        }
        if (!StringHelper.isNullOrEmpty(this.getIsTest())) {
        	financierPersonalCondition.setIsTest(Byte.valueOf(this.getIsTest()));
        }else{
        	financierPersonalCondition.setIsTest((byte) 0);
        }

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        financierPersonalCondition.setSortItemList(sortItemList);

        PagedList<FinancierPersonal> financierPersonalPagedList = FinancierPersonalModel.getPagingList(financierPersonalCondition);
        this.setResultList(financierPersonalPagedList.getResultList());
        this.setPageCount(financierPersonalPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(financierPersonalPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(financierPersonalPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit() {
        info.setEditUserNo(UserHelper.getEditUserNo());
        int id = 0;
        if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
            id = FinancierPersonalModel.add(info);
            if (id > 0) {
                this.setErrDesc(String.valueOf(id));
            } else {
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }

        } else {
            if (info.getId() == 0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            } else {
                if (this.getOper().equalsIgnoreCase("edit")) {
                    if (FinancierPersonalModel.update(info) > 0) {
                        this.setErrDesc(String.valueOf(info.getId()));
                    } else {
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }

                }
            }
        }
        EnumListCacheModel.getFinancierPersonalList(false);
        return SUCCESS;
    }

    public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.info = FinancierPersonalModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }
}