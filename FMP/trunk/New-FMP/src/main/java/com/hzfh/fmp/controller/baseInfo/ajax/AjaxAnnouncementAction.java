package com.hzfh.fmp.controller.baseInfo.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.baseInfo.model.Announcement;
import com.hzfh.api.baseInfo.model.query.AnnouncementCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.baseInfo.AnnouncementModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxAnnouncementAction extends JqGridBaseAction<Announcement> {
    private Announcement info;
    public Announcement getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, Announcement.class);
    }

    private String bySubject;
    private String byType;
    private String byStatus;

    public String getBySubject() {
        return bySubject;
    }

    public void setBySubject(String bySubject) {
        this.bySubject = bySubject;
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
        AnnouncementCondition announcementCondition = new AnnouncementCondition();
        announcementCondition.setPageSize(this.getPageSize());
        announcementCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        announcementCondition.setSortItemList(sortItemList);
        if(!StringHelper.isNullOrEmpty(this.bySubject)){
            announcementCondition.setBySubject(this.bySubject);
        }
        if(!StringHelper.isNullOrEmpty(this.byType)){
            announcementCondition.setByType(Integer.parseInt(this.byType));
        }
        if(!StringHelper.isNullOrEmpty(this.byStatus)){
            announcementCondition.setByStatus(Integer.parseInt(this.byStatus));
        }

        PagedList<Announcement> announcementPagedList= AnnouncementModel.getPagingList(announcementCondition);
        this.setResultList(announcementPagedList.getResultList());
        this.setPageCount(announcementPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(announcementPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(announcementPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        info.setEditUserNo(UserHelper.getEditUserNo());
        int id = 0;
        if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
            id = AnnouncementModel.add(info);
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
                    if (AnnouncementModel.update(info) > 0){
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
            this.info = AnnouncementModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
