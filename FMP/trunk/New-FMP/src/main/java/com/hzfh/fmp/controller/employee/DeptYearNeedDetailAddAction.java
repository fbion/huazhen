package com.hzfh.fmp.controller.employee;

import com.hzfh.api.employee.model.DeptYearNeed;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.DeptYearNeedModel;
import com.hzfh.fmp.model.permission.view.TagPermissionView;
import com.hzfh.fmp.model.workFlow.ActRuTaskModel;
import com.hzframework.helper.StringHelper;

public class DeptYearNeedDetailAddAction extends CommonAction {
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
    private int status;
    
    public int getStatus() {
		return status;
	}
    @Override
    public String execute() throws Exception {
    	int userId = UserHelper.getEditUserNo();
    	DeptYearNeed tApplication = new DeptYearNeed();
    	tApplication=DeptYearNeedModel.getInfo(id);
    	if(tApplication!=null){
        	this.status=tApplication.getWorkFlowStatus();

    	}
        this.setPageAlias(PageAlias.deptYearNeedDetailAdd);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate())
            this.showSubmitButton = true;

        if (this.getPagePermissionView() != null && this.getPagePermissionView().isEdit()) {
        	if(this.status==0 && tApplication.getInUserNo()==userId){
        		 this.showEditButton = true;
                 this.showSubmitButton = true;
        	}else{
        		this.showEditButton = false;
                this.showSubmitButton = false;
        	}
        }



        initPageVar();

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