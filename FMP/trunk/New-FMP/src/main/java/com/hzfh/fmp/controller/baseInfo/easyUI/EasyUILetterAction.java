package com.hzfh.fmp.controller.baseInfo.easyUI;

import com.hzfh.api.baseInfo.model.Letter;
import com.hzfh.api.baseInfo.model.query.LetterCondition;
import com.hzfh.api.permission.model.User;
import com.hzfh.fmp.controller.common.EasyUIBaseAction;
import com.hzfh.fmp.model.UserCache;
import com.hzfh.fmp.model.baseInfo.LetterModel;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;

import java.util.ArrayList;
import java.util.List;


public class EasyUILetterAction extends EasyUIBaseAction<Letter> {
    @Override
    public String execute() throws Exception {
        LetterCondition letterCondition = new LetterCondition();
        letterCondition.setPageSize(100);
        letterCondition.setPageIndex(this.getPage());
        letterCondition.setEmpId( UserHelper.getUserCache().getUserId());
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        for (SortItem sortItem : this.getSortList()) {
            SortItem newSortItem = new SortItem();
            newSortItem.setSortFeild(sortItem.getSort());
            newSortItem.setSortType("asc".equalsIgnoreCase(sortItem.getOrder()) ? SortType.ASC : SortType.DESC);
            sortItemList.add(newSortItem);
        }
        letterCondition.setSortItemList(sortItemList);
        letterCondition.setEmpId(UserHelper.getEditUserNo());
        letterCondition.setIsRead(0);
        letterCondition.setRecipient(-1);
        letterCondition.setType("3");
        PagedList<Letter> letterPagedList = LetterModel.getPagingList(letterCondition);
        letterCondition.setIsRead(-1);
        letterCondition.setType("1");
        letterCondition.seteStatus(4);
        PagedList<Letter> taskPagedList = LetterModel.getPagingList(letterCondition);
        letterPagedList.getResultList().addAll(taskPagedList.getResultList());
        this.setRows(letterPagedList.getResultList());
        this.setTotal(letterPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }
}
