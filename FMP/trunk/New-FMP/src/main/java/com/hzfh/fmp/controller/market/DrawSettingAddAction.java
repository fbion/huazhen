package com.hzfh.fmp.controller.market;

import java.util.List;

import com.hzfh.api.market.model.ActivityUsers;
import com.hzfh.api.market.model.DrawSetting;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.market.ActivityUsersModel;
import com.hzfh.fmp.model.market.DrawSettingModel;
import com.hzfh.fmp.model.permission.view.TagPermissionView;

public class DrawSettingAddAction extends CommonAction {
	


	public boolean showEditButton;

    public boolean isShowEditButton() {
        return showEditButton;
    }

    public boolean showSubmitButton;
    
    public boolean isShowSubmitButton() {
        return showSubmitButton;
    }

    private String pageVar;

    public String getPageVar() {
        return pageVar;
    }

    private int id;

    public void setId(int id) {
        this.id = id;
    }
	private String checkValue;
	public String getCheckValue() {
		return checkValue;
	}

	public void setCheckValue(String checkValue) {
		this.checkValue = checkValue;
	}

    @Override
    public String execute() throws Exception {
    	checkValue="";
    	if(id!=0){
    		List<ActivityUsers> userList = ActivityUsersModel.getIntrinsicUsersByDrawNo(id);
        	if(userList.size()>0){
        		for (ActivityUsers activityUsers : userList) {
            		if(activityUsers!=null){
            			checkValue += activityUsers.getId()+",";
            		}
        		}
            	checkValue = checkValue.substring(0,checkValue.length()-1);
        		
        	}
        	
    	}
    	
    	
        this.setPageAlias(PageAlias.drawSettingAdd);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate())
            this.showSubmitButton = true;

        if (this.getPagePermissionView() != null && this.getPagePermissionView().isEdit()) {
            this.showEditButton = true;
            this.showSubmitButton = true;
        }
        
        initPageVar();

        return SUCCESS;
    }

    public String executeDetail() throws Exception {
        this.setPageAlias(PageAlias.drawSettingAdd);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        this.initPageVar();
        
        return SUCCESS;
    }

    private void initPageVar() {
        StringBuilder sb = new StringBuilder();

        sb.append("<script type=\"text/javascript\">");
        sb.append("var PageVar={");
        sb.append(String.format("%1$s:'%2$s',", "ID", this.id));
        sb.append(String.format("%1$s:'%2$s',", "UserId", UserHelper.getEditUserNo()));
        sb.append("};");

        sb.append("var ElementVar={");
        for(TagPermissionView tagPermissionView: this.getPagePermissionView().getTagPermissionViewList()){
            sb.append(String.format("%1$s:'%2$s',", tagPermissionView.getTagName(), String.valueOf(tagPermissionView.getTagPermissionType())));
        }
        sb.append("};");

        sb.append("</script>");

        this.pageVar = sb.toString();
    }

}