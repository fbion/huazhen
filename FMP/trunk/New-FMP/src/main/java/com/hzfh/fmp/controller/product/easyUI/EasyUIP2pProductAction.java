package com.hzfh.fmp.controller.product.easyUI;

import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.query.P2pProductCondition;
import com.hzfh.fmp.controller.common.EasyUIBaseAction;
import com.hzfh.fmp.model.product.P2pProductModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.MathHelper;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class EasyUIP2pProductAction extends EasyUIBaseAction<P2pProduct> {
    private String name;
    private String type;
    private int status;
    private String startTime;
    private String endTime;

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String execute() throws Exception {
        P2pProductCondition p2pProductCondition = new P2pProductCondition();
        p2pProductCondition.setPageSize(this.getPageSize());
        p2pProductCondition.setPageIndex(this.getPage());
        List<SortItem> sortItemList = new ArrayList<>();
        for (SortItem sortItem : this.getSortList()) {
            SortItem newSortItem = new SortItem();
            newSortItem.setSortFeild(sortItem.getSort());
            newSortItem.setSortType("asc".equalsIgnoreCase(sortItem.getOrder()) ? SortType.ASC : SortType.DESC);
            sortItemList.add(newSortItem);
        }
        p2pProductCondition.setSortItemList(sortItemList);
        p2pProductCondition.setByProductName(this.name);
        if (!StringHelper.isNullOrEmpty(this.type)) {
            p2pProductCondition.setType(Byte.parseByte(this.type));
        }
        p2pProductCondition.setStartTime(this.startTime);
        p2pProductCondition.setEndTime(this.endTime);
        p2pProductCondition.setByStatus(this.status);
        if (!StringHelper.isNullOrEmpty(this.getIsTest())) {
            p2pProductCondition.setIsTest(Byte.valueOf(this.getIsTest()));
        }
        PagedList<P2pProduct> p2pProductPagedList = P2pProductModel.getPagingList(p2pProductCondition);
        for (P2pProduct p2pProduct : p2pProductPagedList.getResultList()) {
            if (p2pProduct.getEnd() != null) {
                int days = DateHelper.daysBetween(DateHelper.getTodayDate(), p2pProduct.getEnd());
                p2pProduct.setEditComment(String.valueOf(days));
                if (days < 0) {
                    p2pProduct.setEditComment("已结束");
                }
            } else {
                p2pProduct.setEditComment("");
            }
            double salesMoney = p2pProduct.getTotalAmout() - p2pProduct.getRemainAmout();
            double progress = MathHelper.multiply(MathHelper.divide(salesMoney, p2pProduct.getTotalAmout(), 2), 100);

            p2pProduct.setDescription(ProductModel.getInfo(p2pProduct.getProductNo()).getName());
            p2pProduct.setProgress(progress);
        }
        this.setRows(p2pProductPagedList.getResultList());
        this.setTotal(p2pProductPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }


}
