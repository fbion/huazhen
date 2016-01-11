package com.hzfh.fmp.controller.sales.easyUI;

import com.hzfh.api.sales.model.P2pSubscribe;
import com.hzfh.api.sales.model.query.P2pSubscribeCondition;
import com.hzfh.fmp.controller.common.EasyUIBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.state.StateValues;
import com.hzfh.fmp.model.sales.P2pSubscribeModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class EasyUIP2pSubscribeAction extends EasyUIBaseAction<P2pSubscribe> {
    private int p2pProductNo;
    private String customerName;
    private String phone;
    private int deptNo;
    private int status;
    private int empNo;
    private String showAllList;
    private String showNoAssignList;

    public void setShowNoAssignList(String showNoAssignList) {
        this.showNoAssignList = showNoAssignList;
    }

    public void setShowAllList(String showAllList) {
        this.showAllList = showAllList;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public void setP2pProductNo(int p2pProductNo) {
        this.p2pProductNo = p2pProductNo;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String execute() throws Exception {
        P2pSubscribeCondition p2pSubscribeCondition = new P2pSubscribeCondition();
        p2pSubscribeCondition.setPageSize(this.getPageSize());
        p2pSubscribeCondition.setPageIndex(this.getPage());
        List<SortItem> sortItemList = new ArrayList<>();
        for (SortItem sortItem : this.getSortList()) {
            SortItem newSortItem = new SortItem();
            newSortItem.setSortFeild(sortItem.getSort());
            newSortItem.setSortType("asc".equalsIgnoreCase(sortItem.getOrder()) ? SortType.ASC : SortType.DESC);
            sortItemList.add(newSortItem);
        }
        p2pSubscribeCondition.setSortItemList(sortItemList);
        p2pSubscribeCondition.setByP2pProductNo(this.p2pProductNo);
        p2pSubscribeCondition.setByDeptNo(this.deptNo);
        p2pSubscribeCondition.setByStatus(this.status);
        p2pSubscribeCondition.setCustomerName(this.customerName);
        p2pSubscribeCondition.setPhone(this.phone);
        p2pSubscribeCondition.setByEmpNo(this.empNo);
        if ("query".equals(this.showAllList)) {
            p2pSubscribeCondition.setWorkMateString(null);
        } else if ("query".equals(this.showNoAssignList)) {
            p2pSubscribeCondition.setWorkMateString("0");
        } else {
            List<Integer> workmate = UserHelper.getUserCache().getWorkMate();
            if (workmate != null) {
                workmate.add(UserHelper.getUserCache().getUserId());
                String workMateString = StringHelper.listToString(workmate);
                p2pSubscribeCondition.setWorkMateString(workMateString);
            } else {
                p2pSubscribeCondition.setWorkMateString(String.valueOf(UserHelper.getUserCache().getUserId()));
            }
        }
        if(!StringHelper.isNullOrEmpty(this.getIsTest())){
            p2pSubscribeCondition.setIsTest(Byte.valueOf(this.getIsTest()));
        }
        PagedList<P2pSubscribe> p2pSubscribePagedList = P2pSubscribeModel.getPagingList(p2pSubscribeCondition);
        this.setRows(p2pSubscribePagedList.getResultList());
        this.setTotal(p2pSubscribePagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }


}
