package com.hzfh.fmp.controller.market;

import java.util.List;

import com.hzfh.api.market.model.ActivityUsers;
import com.hzfh.api.market.model.DrawSetting;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.market.ActivityUsersModel;
import com.hzfh.fmp.model.market.DrawSettingModel;

public class DrawSettingAction extends CommonAction {
	private boolean showAddButton;

    public boolean isShowAddButton() {
        return showAddButton;
    }

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.drawSettingList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

		if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate()) {
            this.showAddButton = true;
        }

        return SUCCESS;
    }
    public String resetDrawSeeting() throws Exception  {
        System.out.println("");
        List<DrawSetting> getList = DrawSettingModel.getList();
        for(int i=0;i<getList.size();i++){
        	DrawSetting drawSetting =getList.get(i);
        	drawSetting.setStatus(0);
        	DrawSettingModel.update(drawSetting);
        }
        
        List<ActivityUsers> userList = ActivityUsersModel.getList();
        for(int j=0;j<userList.size();j++){
        	ActivityUsers user = userList.get(j);
        	user.setMark("0");
        	user.setDrawNo(0);
        	user.setIsWin(0);
        	ActivityUsersModel.update(user);
        }
        
        this.setPageAlias(PageAlias.drawSettingList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

		if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate()) {
            this.showAddButton = true;
        }

        return SUCCESS;
    }
    
    
}
