package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.FixedAssets;
import com.hzfh.api.employee.model.query.FixedAssetsCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.employee.FixedAssetsModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxFixedAssetsAction extends JqGridBaseAction<FixedAssets> {
	private FixedAssets info;
	public FixedAssets getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, FixedAssets.class);
    }

    @Override
    public String execute(){
    	FixedAssetsCondition fixedAssetsCondition = new FixedAssetsCondition();
        fixedAssetsCondition.setPageSize(this.getPageSize());
        fixedAssetsCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        fixedAssetsCondition.setSortItemList(sortItemList);

        PagedList<FixedAssets> fixedAssetsPagedList= FixedAssetsModel.getPagingList(fixedAssetsCondition);
        this.setResultList(fixedAssetsPagedList.getResultList());
        this.setPageCount(fixedAssetsPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(fixedAssetsPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(fixedAssetsPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = FixedAssetsModel.add(info);
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
                    if (FixedAssetsModel.update(info) > 0){
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
            this.info = FixedAssetsModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
