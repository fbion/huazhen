package com.hzfh.fmp.controller.employee;

import com.hzfh.api.employee.model.DeptYearNeed;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.employee.DeptYearNeedModel;
import com.hzfh.fmp.model.permission.view.TagPermissionView;

import java.util.List;

public class DeptYearNeedAction extends CommonAction {
	private boolean showAddButton;
	private String pageVar;
    public String getPageVar() {
        return pageVar;
    }
    public boolean isShowAddButton() {
        return showAddButton;
    }
    private List<DeptYearNeed> deptYearNeedList;
    
    public List<DeptYearNeed> getDeptYearNeedList() {
		return deptYearNeedList;
	}

	@Override
    public String execute() throws Exception {
        this.setPageAlias(PageAlias.deptYearNeedList);

        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

		if (this.getPagePermissionView() != null && this.getPagePermissionView().isCreate()) {
            this.showAddButton = true;
        }
		this.deptYearNeedList=DeptYearNeedModel.getList();
		initPageVar();
        return SUCCESS;
    }
    private void initPageVar() {
        StringBuilder sb = new StringBuilder();
        sb.append("<script type=\"text/javascript\">");

        sb.append("var ElementVar={");
        for (TagPermissionView tagPermissionView : this.getPagePermissionView().getTagPermissionViewList()) {
            sb.append(String.format("%1$s:'%2$s',", tagPermissionView.getTagName(), String.valueOf(tagPermissionView.getTagPermissionType())));
        }
        sb.append("};");
        sb.append("</script>");
        this.pageVar = sb.toString();
    }
}
