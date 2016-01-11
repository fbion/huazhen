package com.hzfh.fmp.controller.market.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.market.model.ActivityUsers;
import com.hzfh.api.market.model.DrawSetting;
import com.hzfh.api.market.model.WinningRecord;
import com.hzfh.api.market.model.query.WinningRecordCondition;
import com.hzfh.api.sales.model.query.ApplyEmployeeCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.market.ActivityUsersModel;
import com.hzfh.fmp.model.market.DrawSettingModel;
import com.hzfh.fmp.model.market.WinningRecordModel;
import com.hzfh.fmp.model.common.helper.ExcelHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxWinningRecordAction extends JqGridBaseAction<WinningRecord> {
	private WinningRecord info;
	private String winRecordId;
	public String getWinRecordId() {
		return winRecordId;
	}

	public void setWinRecordId(String winRecordId) {
		this.winRecordId = winRecordId;
	}
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
        PagedList<WinningRecord> winningRecordPagedList = WinningRecordModel.getPagingList(this.getCondition());
        for(WinningRecord winningRecord : winningRecordPagedList.getResultList()){
        	ActivityUsers activityUsers = ActivityUsersModel.getInfo(winningRecord.getUserId());
        	winningRecord.setUserImgPath(activityUsers.getUserImgPath());
        	winningRecord.setUserName(activityUsers.getUserName());
        	winningRecord.setName(activityUsers.getName());
        	winningRecord.setCellphone(activityUsers.getCellphone());
        	
        	DrawSetting drawSetting = DrawSettingModel.getInfo(winningRecord.getDrawNo());
        	winningRecord.setDrawAwards(drawSetting.getDrawAwards());
        	
        	if(winningRecord.getIsAward()==0){
        		winningRecord.setIsAwardStr("否");
        	}else{
        		winningRecord.setIsAwardStr("是");
        	}
        }
        drawSettingList = DrawSettingModel.getInfoListByStatus(drawStatus);
        this.setResultList(winningRecordPagedList.getResultList());
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
	private WinningRecordCondition getCondition() {
    	WinningRecordCondition winningRecordCondition = new WinningRecordCondition();
        winningRecordCondition.setPageSize(this.getPageSize());
        winningRecordCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        winningRecordCondition.setSortItemList(sortItemList);
        if(!StringHelper.isNullOrEmpty(this.byName)){
        	winningRecordCondition.setUserName(this.byName);
        }
        	
        if(drawNo != 0){
        	winningRecordCondition.setDrawNo(this.drawNo);
        }
		return winningRecordCondition;
	}
	public String exportExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.getExcelForWinningRecordList();
        return null;
    }
	
	public String getAward(){
		this.info = WinningRecordModel.getInfo(Integer.parseInt(this.winRecordId));
		this.info.setIsAward(1);
		int id = WinningRecordModel.update(this.info);
		if(id>0){
			this.setErrCode("0000");
			this.setErrDesc("领奖成功");
			return SUCCESS;
		}else{
			this.setErrCode("9999");
			this.setErrDesc("领奖失败，请刷新重试");
			return SUCCESS;
		}
	}
	
	public String undoGetAward(){
		this.info = WinningRecordModel.getInfo(Integer.parseInt(this.winRecordId));
		this.info.setIsAward(0);
		int id = WinningRecordModel.update(this.info);
		if(id>0){
			this.setErrCode("0000");
			this.setErrDesc("撤销成功");
			return SUCCESS;
		}else{
			this.setErrCode("9999");
			this.setErrDesc("撤销失败，请刷新重试");
			return SUCCESS;
		}
	}

}
