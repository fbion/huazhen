package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.query.DepartmentCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.EnumListCacheModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;

public class AjaxDepartmentAction extends JqGridBaseAction<Department> {

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String telephone;

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	private String empNo;

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	private String fax;

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	private String comment;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	private String duty;

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	private String parentNo;

	public String getParentNo() {
		return parentNo;
	}

	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}

	private String companyNo;

	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}

	public String getDeptType() {
		return deptType;
	}

	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}

	private String deptType;

	private List<Department> resultList;

	private int param;

	public void setParam(int param) {
		this.param = param;
	}

	@Override
	public List<Department> getResultList() {
		return resultList;
	}

	@Override
	public void setResultList(List<Department> resultList) {
		this.resultList = resultList;
	}

	@Override
	public String execute() throws Exception {
		DepartmentCondition departmentCondition = new DepartmentCondition();
		departmentCondition.setPageSize(this.getPageSize());
		departmentCondition.setPageIndex(this.getPageIndex());

		if (StringHelper.isNullOrEmpty(this.companyNo)) {
			departmentCondition.setCompanyNO(0);
		} else {
			departmentCondition.setCompanyNO(Integer.parseInt(this.companyNo));
		}

		if (!StringHelper.isNullOrEmpty(this.name)) {
			departmentCondition.setName(this.name);
		}
		if (StringHelper.isNullOrEmpty(this.getIsTest())) {
			departmentCondition.setIsTest((byte) 0);
		} else {
			departmentCondition.setIsTest(Byte.valueOf(this.getIsTest()));
		}

		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem = new SortItem();
		sortItem.setSortFeild(this.getSidx());
		sortItem.setSortType(this.getSortType());
		sortItemList.add(sortItem);
		departmentCondition.setSortItemList(sortItemList);

		PagedList<Department> departmentPagedList = DepartmentModel
				.getPagingList(departmentCondition);
		this.setResultList(departmentPagedList.getResultList());
		this.setPageCount(departmentPagedList.getPagingInfo().getPageCount());
		this.setPageIndex(departmentPagedList.getPagingInfo().getPageIndex());
		this.setRecordCount(departmentPagedList.getPagingInfo().getTotalCount());
		return SUCCESS;
	}

	public String edit() {
		info.setEditUserNo(UserHelper.getEditUserNo());
		int id = 0;
		if (this.getOper().equalsIgnoreCase("add")) {
			info.setInUserNo(UserHelper.getEditUserNo());
			id = DepartmentModel.add(info);
			if (id > 0) {
				this.setErrDesc(String.valueOf(id));
			} else {
				this.setErrCode("add failed");
				this.setErrDesc("add failed");
			}

		} else {
			if (info.getId() == 0) {
				this.setErrCode("NoID");
				this.setErrDesc("NoID");
			} else {
				if (this.getOper().equalsIgnoreCase("edit")) {
					if (DepartmentModel.update(info) > 0) {
						this.setErrDesc(String.valueOf(info.getId()));
					} else {
						this.setErrCode("update failed");
						this.setErrDesc("update failed");
					}

				}
			}
		}
        EnumListCacheModel.getDeptListByCompanyNo(info.getCompanyNo(),false);
        EnumListCacheModel.getDeptList(false);
		return SUCCESS;
	}

	public String getDepartmentByDistrictNo() {
		this.resultList = DepartmentModel.getDepartmentByDistrictNo(this.param);
		return SUCCESS;

	}

	// next blow is all for Add

	private Department info;

	public Department getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = JSON.parseObject(info, Department.class);
	}

	public String getInfoById() {
		if (StringHelper.isNullOrEmpty(this.getId())) {
			this.setErrCode("NoID");
			this.setErrDesc("NoID");
		} else {
			this.info = DepartmentModel.getInfo(Integer.parseInt(this.getId()));
			if (this.info == null) {
				this.setErrCode("No Info");
				this.setErrDesc("No Info");
			}
		}

		return SUCCESS;
	}

}
