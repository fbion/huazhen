package com.hzfh.fmp.controller.product.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.product.model.FinancierBusiness;
import com.hzfh.api.product.model.query.FinancierBusinessCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.EnumListCacheModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.product.FinancierBusinessModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxFinancierBusinessAction extends JqGridBaseAction<FinancierBusiness> {

    private FinancierBusiness info;
    public FinancierBusiness getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, FinancierBusiness.class);
    }

    private String byName;
    private String byRelationLevel;
    private String byImportance;
    private String showAllList;

    public void setByName(String byName) {
        this.byName = byName;
    }

    public void setByImportance(String byImportance) {
        this.byImportance = byImportance;
    }

    public void setByRelationLevel(String byRelationLevel) {
        this.byRelationLevel = byRelationLevel;
    }

    public void setShowAllList(String showAllList) {
        this.showAllList = showAllList;
    }

    @Override
    public String execute() throws Exception{
    	FinancierBusinessCondition financierBusinessCondition = new FinancierBusinessCondition();
        financierBusinessCondition.setPageSize(this.getPageSize());
        financierBusinessCondition.setPageIndex(this.getPageIndex());
        if ("query".equals(this.showAllList)) {
            financierBusinessCondition.setWorkMateString(null);
        }else{
            List<Integer> workmate = UserHelper.getUserCache().getWorkMate();
            if (workmate!=null) {
                workmate.add(UserHelper.getUserCache().getUserId());
                String workMateString = StringHelper.listToString(workmate);
                financierBusinessCondition.setWorkMateString(workMateString);
            }else{
                financierBusinessCondition.setWorkMateString(String.valueOf(UserHelper.getUserCache().getUserId()));
            }
        }
        if (!StringHelper.isNullOrEmpty(this.byName)) {
			financierBusinessCondition.setName(this.byName);
		}

        if (StringHelper.isNullOrEmpty(this.byRelationLevel)) {
			financierBusinessCondition.setRelationLevel(0);
		}else{
			financierBusinessCondition.setRelationLevel(Integer.parseInt(this.byRelationLevel));
		}
        if (StringHelper.isNullOrEmpty(this.byImportance)) {
			financierBusinessCondition.setImportance(0);
		}else{
			financierBusinessCondition.setImportance(Integer.parseInt(this.byImportance));
		}
        if (StringHelper.isNullOrEmpty(this.getIsTest())) {
        	financierBusinessCondition.setIsTest((byte) 0);
        }else{
        	financierBusinessCondition.setIsTest(Byte.valueOf(this.getIsTest()));
        }
        
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        financierBusinessCondition.setSortItemList(sortItemList);

        PagedList<FinancierBusiness> financierBusinessPagedList= FinancierBusinessModel.getPagingList(financierBusinessCondition);
        this.setResultList(financierBusinessPagedList.getResultList());
        this.setPageCount(financierBusinessPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(financierBusinessPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(financierBusinessPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
    public String edit(){
        info.setEditUserNo(UserHelper.getEditUserNo());
        int id = 0;
        if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
            id = FinancierBusinessModel.add(info);
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
                    if (FinancierBusinessModel.update(info) > 0){
                        this.setErrDesc(String.valueOf(info.getId()));
                    }else{
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }

                }
            }
        }
        EnumListCacheModel.getFinancierBusinessList(false);
        return SUCCESS;
    }

    public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.info = FinancierBusinessModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}

