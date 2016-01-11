package com.hzfh.fmp.controller.market.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.market.model.DrawSetting;
import com.hzfh.api.market.model.query.DrawSettingCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.market.DrawSettingModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxDrawSettingAction extends JqGridBaseAction<DrawSetting> {
	private DrawSetting info;
	public DrawSetting getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, DrawSetting.class);
    }

    @Override
    public String execute(){
    	DrawSettingCondition drawSettingCondition = new DrawSettingCondition();
        drawSettingCondition.setPageSize(this.getPageSize());
        drawSettingCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        drawSettingCondition.setSortItemList(sortItemList);

        PagedList<DrawSetting> drawSettingPagedList= DrawSettingModel.getPagingList(drawSettingCondition);
        this.setResultList(drawSettingPagedList.getResultList());
        this.setPageCount(drawSettingPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(drawSettingPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(drawSettingPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = DrawSettingModel.add(info);
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
                    if (DrawSettingModel.update(info) > 0){
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
            this.info = DrawSettingModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
