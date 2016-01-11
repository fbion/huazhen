package com.hzfh.fmp.controller.product.easyUI;

import com.hzfh.api.product.model.Product;
import com.hzfh.api.product.model.query.ProductCondition;
import com.hzfh.fmp.controller.common.EasyUIBaseAction;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class EasyUIProductAction extends EasyUIBaseAction<Product> {
    private String name;
    private int status;
    private int type;

    public void setType(int type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String execute() throws Exception {
        ProductCondition productCondition = new ProductCondition();
        productCondition.setPageSize(this.getPageSize());
        productCondition.setPageIndex(this.getPage());
        List<SortItem> sortItemList = new ArrayList<>();
        for (SortItem sortItem : this.getSortList()) {
            SortItem newSortItem = new SortItem();
            newSortItem.setSortFeild(sortItem.getSort());
            newSortItem.setSortType("asc".equalsIgnoreCase(sortItem.getOrder()) ? SortType.ASC : SortType.DESC);
            sortItemList.add(newSortItem);
        }
        productCondition.setSortItemList(sortItemList);
        productCondition.setName(this.name);
        productCondition.setStatus(this.status);
        productCondition.setType(this.type);
        if (!StringHelper.isNullOrEmpty(this.getIsTest())) {
            productCondition.setIsTest(Byte.valueOf(this.getIsTest()));
        }
        PagedList<Product> productPagedList = ProductModel.getPagingList(productCondition);
        this.setRows(productPagedList.getResultList());
        this.setTotal(productPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }


}
