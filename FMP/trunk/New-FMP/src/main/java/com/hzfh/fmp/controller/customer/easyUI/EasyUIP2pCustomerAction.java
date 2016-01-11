package com.hzfh.fmp.controller.customer.easyUI;

import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.customer.model.query.P2pCustomerCondition;
import com.hzfh.fmp.controller.common.EasyUIBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.P2pCustomerModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class EasyUIP2pCustomerAction extends EasyUIBaseAction<P2pCustomer> {
    private String userName;
    private int deptNo;
    private int empNo;
    private String showAllList;
    private String showNoAssignList;

    public void setShowAllList(String showAllList) {
        this.showAllList = showAllList;
    }

    public void setShowNoAssignList(String showNoAssignList) {
        this.showNoAssignList = showNoAssignList;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }
    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    @Override
    public String execute() throws Exception {
        P2pCustomerCondition p2pCustomerCondition = new P2pCustomerCondition();
        p2pCustomerCondition.setPageSize(this.getPageSize());
        p2pCustomerCondition.setPageIndex(this.getPage());
        List<SortItem> sortItemList = new ArrayList<>();
        for (SortItem sortItem : this.getSortList()) {
            SortItem newSortItem = new SortItem();
            newSortItem.setSortFeild(sortItem.getSort());
            newSortItem.setSortType("asc".equalsIgnoreCase(sortItem.getOrder()) ? SortType.ASC : SortType.DESC);
            sortItemList.add(newSortItem);
        }
        p2pCustomerCondition.setSortItemList(sortItemList);
        if ("query".equals(this.showAllList)) {
            p2pCustomerCondition.setWorkMateString(null);
        } else if ("query".equals(this.showNoAssignList)) {
            p2pCustomerCondition.setWorkMateString("0");
        } else {
            List<Integer> workmate = UserHelper.getUserCache().getWorkMate();
            if (workmate != null) {
                workmate.add(UserHelper.getUserCache().getUserId());
                String workMateString = StringHelper.listToString(workmate);
                p2pCustomerCondition.setWorkMateString(workMateString);
            } else {
                p2pCustomerCondition.setWorkMateString(String.valueOf(UserHelper.getUserCache().getUserId()));
            }
        }
        if (!StringHelper.isNullOrEmpty(this.userName)) {
        	p2pCustomerCondition.setP2pCustomerName(this.userName);
        }
        if(!StringHelper.isNullOrEmpty(String.valueOf(this.empNo))){
        	p2pCustomerCondition.setByEmpNo(empNo);
        }
        if(!StringHelper.isNullOrEmpty(String.valueOf(this.deptNo))){
            p2pCustomerCondition.setByDeptNo(deptNo);
        }
        PagedList<P2pCustomer> p2pCustomerPagedList = P2pCustomerModel.getPagingList(p2pCustomerCondition);
        this.setRows(p2pCustomerPagedList.getResultList());
        this.setTotal(p2pCustomerPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }


}
