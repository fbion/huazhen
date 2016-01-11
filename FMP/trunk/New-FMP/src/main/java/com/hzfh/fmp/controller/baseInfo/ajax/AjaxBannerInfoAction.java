package com.hzfh.fmp.controller.baseInfo.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.baseInfo.model.BannerInfo;
import com.hzfh.api.baseInfo.model.query.BannerInfoCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.baseInfo.BannerInfoModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxBannerInfoAction extends JqGridBaseAction<BannerInfo> {
    private BannerInfo info;
    public BannerInfo getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, BannerInfo.class);
    }
    private String byTitle;
    private String byLocation;
    private String byType;
    private String byStatus;

    public String getByTitle() {
        return byTitle;
    }

    public void setByTitle(String byTitle) {
        this.byTitle = byTitle;
    }

    public String getByLocation() {
        return byLocation;
    }

    public void setByLocation(String byLocation) {
        this.byLocation = byLocation;
    }

    public String getByType() {
        return byType;
    }

    public void setByType(String byType) {
        this.byType = byType;
    }

    public String getByStatus() {
        return byStatus;
    }

    public void setByStatus(String byStatus) {
        this.byStatus = byStatus;
    }

    @Override
    public String execute() throws Exception{
        BannerInfoCondition bannerInfoCondition = new BannerInfoCondition();
        bannerInfoCondition.setPageSize(this.getPageSize());
        bannerInfoCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        bannerInfoCondition.setSortItemList(sortItemList);

        if(!StringHelper.isNullOrEmpty(this.byTitle)){
            bannerInfoCondition.setByTitle(this.byTitle);
        }
        if(!StringHelper.isNullOrEmpty(this.byLocation)){
            bannerInfoCondition.setByLocation(Integer.parseInt(this.byLocation));
        }
        if(!StringHelper.isNullOrEmpty(this.byType)){
            bannerInfoCondition.setByType(Integer.parseInt(this.byType));
        }
        if(!StringHelper.isNullOrEmpty(this.byStatus)){
            bannerInfoCondition.setByStatus(Integer.parseInt(this.byStatus));
        }

        PagedList<BannerInfo> bannerInfoPagedList= BannerInfoModel.getPagingList(bannerInfoCondition);
        this.setResultList(bannerInfoPagedList.getResultList());
        this.setPageCount(bannerInfoPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(bannerInfoPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(bannerInfoPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        info.setEditUserNo(UserHelper.getEditUserNo());
        int id = 0;
        if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
            id = BannerInfoModel.add(info);
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
                    if (BannerInfoModel.update(info) > 0){
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
            this.info = BannerInfoModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
