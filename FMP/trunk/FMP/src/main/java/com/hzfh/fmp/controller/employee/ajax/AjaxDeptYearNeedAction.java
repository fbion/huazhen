package com.hzfh.fmp.controller.employee.ajax;

import com.alibaba.fastjson.JSON;
import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.DeptYearNeed;
import com.hzfh.api.employee.model.DeptYearNeedDetail;
import com.hzfh.api.employee.model.Position;
import com.hzfh.api.employee.model.query.DeptYearNeedCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.employee.DeptYearNeedDetailModel;
import com.hzfh.fmp.model.employee.DeptYearNeedModel;
import com.hzfh.fmp.model.employee.PositionModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;

public class AjaxDeptYearNeedAction extends JqGridBaseAction<DeptYearNeed> {
	private DeptYearNeed info;
	private List<DeptYearNeedDetail> detailInfos;
	private List<Department> departmentList;
	private List<Position> positionList;
	private List<DeptYearNeedDetail> deptYearNeedDetails;
    private int byYear;
    private String bySelectDepartment;
	public DeptYearNeed getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = JSON.parseObject(info, DeptYearNeed.class);
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public List<Position> getPositionList() {
		return positionList;
	}

	public void setPositionList(List<Position> positionList) {
		this.positionList = positionList;
	}

	public List<DeptYearNeedDetail> getDeptYearNeedDetails() {
		return deptYearNeedDetails;
	}

	public int getByYear() {
		return byYear;
	}

	public void setByYear(int byYear) {
		this.byYear = byYear;
	}

	public String getBySelectDepartment() {
		return bySelectDepartment;
	}

	public void setBySelectDepartment(String bySelectDepartment) {
		this.bySelectDepartment = bySelectDepartment;
	}
	
	private String empName;
    public String getEmpName() {
		return empName;
	}

	public void setDeptYearNeedDetails(String deptYearNeedDetails) {
		List<DeptYearNeedDetail> detailInfos = new ArrayList<>();
		for (int i = 0; i < JSON.parseArray(deptYearNeedDetails).size(); i++) {
			JSON deptYearNeedDetailJson = (JSON) JSON.toJSON(JSON.parseArray(
					deptYearNeedDetails).get(i));
			DeptYearNeedDetail deptYearNeedDetail = JSON.toJavaObject(
					deptYearNeedDetailJson, DeptYearNeedDetail.class);
			detailInfos.add(deptYearNeedDetail);

		}
		this.deptYearNeedDetails = detailInfos;
	}

	private DeptYearNeedCondition getCondition() {
		DeptYearNeedCondition deptYearNeedCondition = new DeptYearNeedCondition();
		deptYearNeedCondition.setPageSize(this.getPageSize());
		deptYearNeedCondition.setPageIndex(this.getPageIndex());
	    
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        deptYearNeedCondition.setSortItemList(sortItemList);
        if(!StringHelper.isNullOrEmpty(Integer.toString(this.byYear))){
        	deptYearNeedCondition.setFinancialYear(this.byYear);
        }
        if(!StringHelper.isNullOrEmpty(this.bySelectDepartment)){
        	deptYearNeedCondition.setDeptNo(Byte.valueOf(this.bySelectDepartment));
        }
		return deptYearNeedCondition;
	}
	@Override
    public String execute() throws Exception{
        PagedList<DeptYearNeed> extendProbationApplicationPagedList= DeptYearNeedModel.getPagingList(this.getCondition());
        this.setResultList(extendProbationApplicationPagedList.getResultList());
        this.setPageCount(extendProbationApplicationPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(extendProbationApplicationPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(extendProbationApplicationPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
	public String edit() {
		if (this.getOper().equalsIgnoreCase("add")) {
			int id = 0;
			// user deptNo get companyNo
			Department department = DepartmentModel.getInfo(info.getDeptNo());
			info.setCompanyNo(department.getCompanyNo());
			info.setInUserNo(UserHelper.getEditUserNo());
			id = DeptYearNeedModel.add(info);
			int addEmp = 0;
			int nowEmp = 0;
			for (DeptYearNeedDetail detailInfo : deptYearNeedDetails) {
				addEmp = addEmp + detailInfo.getAddEmp();
				nowEmp = nowEmp + detailInfo.getNowEmp();
				detailInfo.setEditUserNo(UserHelper.getEditUserNo());
				int id1 = 0;
				if (detailInfo.getId() == 0) {
					detailInfo.setDeptYearNeedNo(id);
					detailInfo.setInUserNo(UserHelper.getEditUserNo());
					id1 = DeptYearNeedDetailModel.add(detailInfo);
					if (id1 <= 0) {
						this.setErrCode("add failed");
						this.setErrDesc("add failed");
						return SUCCESS;
					}
					this.setErrDesc(String.valueOf(id));
				} else {
					if (DeptYearNeedDetailModel.update(detailInfo) <= 0) {
						this.setErrCode("update failed");
						this.setErrDesc("update failed");
						return SUCCESS;
					}
					this.setErrDesc(String.valueOf(detailInfo.getId()));
				}
				if (id > 0) {
					this.setErrDesc(String.valueOf(id));
				} else {
					this.setErrCode("add failed");
					this.setErrDesc("add failed");
				}
			}
			info.setAddEmpTotal(addEmp);
			info.setNowEmpTotal(nowEmp);
			info.setId(id);
			DeptYearNeedModel.update(info);
		} else {
			if (info.getId() == 0) {
				this.setErrCode("NoID");
				this.setErrDesc("NoID");
			} else {
				if (this.getOper().equalsIgnoreCase("edit")) {
					int id = info.getId();
					int addEmp = 0;
					int nowEmp = 0;
					for (DeptYearNeedDetail detailInfo : deptYearNeedDetails) {
						addEmp = addEmp + detailInfo.getAddEmp();
						nowEmp = nowEmp + detailInfo.getNowEmp();
						int id1 = 0;
						detailInfo.setDeptYearNeedNo(id);
						detailInfo.setEditUserNo(UserHelper.getEditUserNo());
						id1 = DeptYearNeedDetailModel.update(detailInfo);
						if (id1 <= 0) {
							this.setErrCode("update failed");
							this.setErrDesc("update failed");
							return SUCCESS;
						}
						this.setErrDesc(String.valueOf(id));
					}
					info.setAddEmpTotal(addEmp);
					info.setNowEmpTotal(nowEmp);
					info.setId(id);
					Department department = DepartmentModel.getInfo(info.getDeptNo());
					info.setCompanyNo(department.getCompanyNo());
					info.setEditUserNo(UserHelper.getEditUserNo());
					int updateInfo = DeptYearNeedModel.update(info);
					if (updateInfo > 0) {
						this.setErrDesc(String.valueOf(info.getId()));
					} else {
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
			this.info = DeptYearNeedModel
					.getInfo(Integer.parseInt(this.getId()));
			this.deptYearNeedDetails = DeptYearNeedDetailModel
					.getInfoByNeedNo(Integer.parseInt(this.getId()));
			for (int i = 0; i < deptYearNeedDetails.size(); i++) {
				int positionNo = deptYearNeedDetails.get(i).getPositionNo();
				String positionName = PositionModel.getInfo(positionNo)
						.getName();
				deptYearNeedDetails.get(i).setPositionName(positionName);
			}
			if (this.info == null) {
				this.setErrCode("No Info");
				this.setErrDesc("No Info");
			}
		}
		this.empName = UserHelper.getUserCache().getEmpName();
		return SUCCESS;
	}

}
