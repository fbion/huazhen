package com.hzfh.fmp.controller.employee.easyUI;

import com.hzfh.api.employee.model.Department;
import com.hzfh.api.employee.model.query.DepartmentCondition;
import com.hzfh.fmp.controller.common.EasyUIBaseAction;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class EasyUIDepartmentAction extends EasyUIBaseAction<Department> {
	private String companyNo;

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String execute() throws Exception {
        DepartmentCondition departmentCondition = new DepartmentCondition();
        departmentCondition.setPageSize(this.getPageSize());
        departmentCondition.setPageIndex(this.getPage());
        List<SortItem> sortItemList = new ArrayList<>();
        for (SortItem sortItem : this.getSortList()) {
            SortItem newSortItem = new SortItem();
            newSortItem.setSortFeild(sortItem.getSort());
            newSortItem.setSortType("asc".equalsIgnoreCase(sortItem.getOrder()) ? SortType.ASC : SortType.DESC);
            sortItemList.add(newSortItem);
        }
        
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
        departmentCondition.setSortItemList(sortItemList);
        PagedList<Department> departmentPagedList = DepartmentModel.getPagingList(departmentCondition);
        this.setRows(departmentPagedList.getResultList());
        this.setTotal(departmentPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }


}
