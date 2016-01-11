package com.hzfh.fmp.controller.market.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.market.model.ActivityUsers;
import com.hzfh.api.market.model.DrawSetting;
import com.hzfh.api.market.model.WinningRecord;
import com.hzfh.api.market.model.query.WinningRecordCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.market.ActivityUsersModel;
import com.hzfh.fmp.model.market.DrawSettingModel;
import com.hzfh.fmp.model.market.WinningRecordModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxWinningRecordAction extends JqGridBaseAction<WinningRecord> {
	private WinningRecord info;
	private List<DrawSetting> drawSettingList;
	private static int drawStatus = 1;
	
	
	public List<DrawSetting> getDrawSettingList() {
		return drawSettingList;
	}

	public void setDrawSettingList(List<DrawSetting> drawSettingList) {
		this.drawSettingList = drawSettingList;
	}

	public WinningRecord getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = JSON.parseObject(info, WinningRecord.class);
    }
    private String byName;

    public String getByName() {
		return byName;
	}

	public void setByName(String byName) {
		this.byName = byName;
	}
	private int drawNo;
	
	public int getDrawNo() {
		return drawNo;
	}

	public void setDrawNo(int drawNo) {
		this.drawNo = drawNo;
	}

	@Override
    public String execute(){
    	WinningRecordCondition winningRecordCondition = new WinningRecordCondition();
        winningRecordCondition.setPageSize(this.getPageSize());
        winningRecordCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        winningRecordCondition.setSortItemList(sortItemList);
        if (!StringHelper.isNullOrEmpty(this.byName)){
        	ActivityUsers actUser = ActivityUsersModel.getInfoByUsername(this.byName);
        	if(actUser!=null){
        		winningRecordCondition.setUserid(actUser.getId());
        	}
        }
        if(drawNo != 0){
        	winningRecordCondition.setDrawNo(this.drawNo);
        }
        

        PagedList<WinningRecord> winningRecordPagedList = WinningRecordModel.getPagingList(winningRecordCondition);
        
        List<WinningRecord> list = winningRecordPagedList.getResultList();
        for(int i=0;i<list.size();i++){
        	DrawSetting drawSetting =DrawSettingModel.getInfo(list.get(i).getDrawNo());
        	list.get(i).setDrawAwards(drawSetting.getDrawAwards());
        	
        	
        	
        	ActivityUsers actUser=null;
			try {
				actUser = ActivityUsersModel.getInfo(list.get(i).getUserId());
			} catch (Exception e) {
				e.printStackTrace();
			}
        	list.get(i).setUserImgPath(actUser.getUserImgPath());
        	list.get(i).setUserName(actUser.getUserName());
        	list.get(i).setName(actUser.getName());
        	list.get(i).setCellphone(actUser.getCellphone());
        	
        	if(list.get(i).getIsAward()==0){
        		list.get(i).setIsAwardStr("否");
        	}else{
        		list.get(i).setIsAwardStr("是");
        	}
        }
        drawSettingList = DrawSettingModel.getInfoListByStatus(drawStatus);
        this.setResultList(list);
        this.setPageCount(winningRecordPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(winningRecordPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(winningRecordPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
            info.setInUserNo(UserHelper.getEditUserNo());
			id = WinningRecordModel.add(info);
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
                    if (WinningRecordModel.update(info) > 0){
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
            this.info = WinningRecordModel.getInfo(Integer.parseInt(this.getId()));
            if (this.info == null) {
                this.setErrCode("No Info");
                this.setErrDesc("No Info");
            }
        }

        return SUCCESS;
    }

}
