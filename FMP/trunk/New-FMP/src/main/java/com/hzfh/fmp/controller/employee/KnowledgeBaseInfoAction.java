package com.hzfh.fmp.controller.employee;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.KnowledgeBase;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.baseInfo.DicDataModel;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.employee.KnowledgeBaseModel;
import com.hzfh.fmp.model.permission.view.TagPermissionView;

public class KnowledgeBaseInfoAction extends CommonAction {
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
    
    public int getId() {
		return id;
	}

	private KnowledgeBase knowledgeBase;
	
    public KnowledgeBase getKnowledgeBase() {
		return knowledgeBase;
	}

	public void setKnowledgeBase(KnowledgeBase knowledgeBase) {
		this.knowledgeBase = knowledgeBase;
	}

	@Override
    public String execute() throws Exception {
    	 this.setPageAlias(PageAlias.knowledgeBaseInfo);
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
        this.knowledgeBase=KnowledgeBaseModel.getInfo(id);
        Employee employee=EmployeeModel.getEmpByUserId(knowledgeBase.getInUserNo());
        knowledgeBase.setInUserName(employee.getName());
		int code=knowledgeBase.getType();
		DicData dcData=DicDataModel.getDicDataByTypeAndCode(42, code);
		knowledgeBase.setTypeName(dcData.getValue());
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