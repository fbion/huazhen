package com.hzfh.fmp.controller.product.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.product.model.PartnerIssuer;
import com.hzfh.api.product.model.query.PartnerIssuerCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.EnumListCacheModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.product.PartnerIssuerModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxPartnerIssuerAction extends JqGridBaseAction<PartnerIssuer> {
    private PartnerIssuer info;

    public PartnerIssuer getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, PartnerIssuer.class);
    }


    private String byName;
    private String byPartnerIssuertype;
    private String byRelationLevel;
    private String byImportance;
    private String showAllList;

    public String getByName() {
        return byName;
    }

    public void setByName(String byName) {
        this.byName = byName;
    }

    public void setByPartnerIssuertype(String byPartnerIssuertype) {
        this.byPartnerIssuertype = byPartnerIssuertype;
    }

    public void setByRelationLevel(String byRelationLevel) {
        this.byRelationLevel = byRelationLevel;
    }

    public void setByImportance(String byImportance) {
        this.byImportance = byImportance;
    }

    public void setShowAllList(String showAllList) {
        this.showAllList = showAllList;
    }

    @Override
    public String execute() throws Exception{

        PartnerIssuerCondition partnerIssuerCondition = new PartnerIssuerCondition();
        partnerIssuerCondition.setPageSize(this.getPageSize());
        partnerIssuerCondition.setPageIndex(this.getPageIndex());
        if ("query".equals(this.showAllList)) {
            partnerIssuerCondition.setWorkMateString(null);
        } else {
            List<Integer> workmate = UserHelper.getUserCache().getWorkMate();
            if (workmate != null) {
                workmate.add(UserHelper.getUserCache().getUserId());
                String workMateString = StringHelper.listToString(workmate);
                partnerIssuerCondition.setWorkMateString(workMateString);
            } else {
                partnerIssuerCondition.setWorkMateString(String.valueOf(UserHelper.getUserCache().getUserId()));
            }
        }
        if (!StringHelper.isNullOrEmpty(this.byName)) {
            partnerIssuerCondition.setName(this.byName);
        }
        if (StringHelper.isNullOrEmpty(this.byPartnerIssuertype)) {
            partnerIssuerCondition.setPartnerIssuertype(0);
        }
        else{
            partnerIssuerCondition.setPartnerIssuertype(Integer.parseInt(this.byPartnerIssuertype));
        }
        if (StringHelper.isNullOrEmpty(this.byRelationLevel)) {
            partnerIssuerCondition.setRelationLevel(0);
        }else{
            partnerIssuerCondition.setRelationLevel(Integer.parseInt(this.byRelationLevel));
        }
        if (StringHelper.isNullOrEmpty(this.byImportance)) {
            partnerIssuerCondition.setImportance(0);
        }
        else{
            partnerIssuerCondition.setImportance(Integer.parseInt(this.byImportance));
        }
        if (StringHelper.isNullOrEmpty(this.getIsTest())) {
        	partnerIssuerCondition.setIsTest((byte) 0);
        }else{
        	partnerIssuerCondition.setIsTest(Byte.valueOf(this.getIsTest()));
        }
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        partnerIssuerCondition.setSortItemList(sortItemList);
        PagedList<PartnerIssuer> partnerIssuerPagedList= PartnerIssuerModel.getPagingList(partnerIssuerCondition);
        this.setResultList(partnerIssuerPagedList.getResultList());
        this.setPageCount(partnerIssuerPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(partnerIssuerPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(partnerIssuerPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
}




    public String edit(){
        info.setEditUserNo(UserHelper.getEditUserNo());

        int id = 0;
        if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
            id = PartnerIssuerModel.add(info);
            if (id > 0){
                this.setErrDesc(String.valueOf(id));
            }else{
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }

        }
        else
        {
            if (this.info.getId()==0) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            }
            else{
                if (this.getOper().equalsIgnoreCase("edit")) {
                    if (PartnerIssuerModel.update(info) > 0){
                        this.setErrDesc(String.valueOf(this.info.getId()));
                    }else{
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }

                }
            }
        }
        EnumListCacheModel.getIssuerList(false);
        return SUCCESS;
    }

    public String getInfoById() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            this.info = PartnerIssuerModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}