package com.hzfh.fmp.controller.market;

import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.market.model.ActivityUsers;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.market.ActivityUsersModel;
import com.hzframework.helper.StringHelper;

public class ActivityUsersAction extends CommonAction {
	private boolean showAddButton;

    public boolean isShowAddButton() {
        return showAddButton;
    }
    
	private List<ActivityUsers> activityUsers;
	
	
	public List<ActivityUsers> getActivityUsers() {
		return activityUsers;
	}

	public void setActivityUsers(List<ActivityUsers> activityUsers) {
		this.activityUsers = activityUsers;
	}

    @Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.activityUsersList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

		if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate()) {
            this.showAddButton = true;
        }

        return SUCCESS;
    }
    

}
