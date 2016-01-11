package com.hzfh.fmp.controller.index;

import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.NeedRelease;
import com.hzfh.api.employee.model.Position;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.helper.UrlHelper;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.employee.NeedReleaseModel;
import com.hzfh.fmp.model.employee.PositionModel;

import java.util.List;

public class NeedReleaseTaskIndexAction extends CommonAction {
	private boolean showAddButton;

    public boolean isShowAddButton() {
        return showAddButton;
    }
    private List<NeedRelease> needReleases;
	private String needReleaseListUrl;
	private String needReleaseDetailUrl;
	private String addReleaseUrl;
    
    public String getAddReleaseUrl() {
		return addReleaseUrl;
	}

	public void setAddReleaseUrl(String addReleaseUrl) {
		this.addReleaseUrl = addReleaseUrl;
	}

	public String getNeedReleaseDetailUrl() {
		return needReleaseDetailUrl;
	}

	public void setNeedReleaseDetailUrl(String needReleaseDetailUrl) {
		this.needReleaseDetailUrl = needReleaseDetailUrl;
	}

	public String getNeedReleaseListUrl() {
		return needReleaseListUrl;
	}

	public void setNeedReleaseListUrl(String needReleaseListUrl) {
		this.needReleaseListUrl = needReleaseListUrl;
	}

	public List<NeedRelease> getNeedReleases() {
		return needReleases;
	}

	public void setNeedReleases(List<NeedRelease> needReleases) {
		this.needReleases = needReleases;
	}
	@Override
    public String execute() throws Exception {
	
    	this.setPageAlias(PageAlias.needReleaseTask);
    	needReleases=NeedReleaseModel.getList();
    	 this.showUrl();
    	for (int i = 0; i < needReleases.size(); i++) {
			Department department=DepartmentModel.getDepartmentByDeptNo(needReleases.get(i).getDeptNo());
			needReleases.get(i).setDeptName(department.getName());
			Position position=PositionModel.getPositionByPositionNo(needReleases.get(i).getPositionNo());
			needReleases.get(i).setPositionName(position.getName());
			Employee employee=EmployeeModel.getEmpByUserId(needReleases.get(i).getInUserNo());
			needReleases.get(i).setInUserName(employee.getName());
		}
    	return SUCCESS;
    }
	private void showUrl(){	
		this.needReleaseListUrl = UrlHelper.buildEmployeeSiteUrl("employee/needRelease/list");
		this.needReleaseDetailUrl = UrlHelper.buildEmployeeSiteUrl("employee/needRelease/edit?id=");
	}
	
}
