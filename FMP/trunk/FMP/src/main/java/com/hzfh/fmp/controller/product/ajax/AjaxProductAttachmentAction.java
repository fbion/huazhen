package com.hzfh.fmp.controller.product.ajax;

import com.hzfh.api.product.model.ProductAttachment;
import com.hzfh.api.product.model.query.ProductAttachmentCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.product.ProductAttachmentModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by paul on 15-1-21.
 */
public class AjaxProductAttachmentAction extends JqGridBaseAction<ProductAttachment> {
    private String productNo;
    public String getProductNo() {
        return productNo;
    }
    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String path;
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    private String type;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    private String status;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String execute() throws Exception{
        ProductAttachmentCondition productAttachmentCondition = new ProductAttachmentCondition();
        productAttachmentCondition.setPageSize(this.getPageSize());
        productAttachmentCondition.setPageIndex(this.getPageIndex());

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        productAttachmentCondition.setSortItemList(sortItemList);

        PagedList<ProductAttachment> productAttachmentPagedList= ProductAttachmentModel.getPagingList(productAttachmentCondition);
        this.setResultList(productAttachmentPagedList.getResultList());
        this.setPageCount(productAttachmentPagedList.getPagingInfo().getPageCount());
        this.setPageIndex(productAttachmentPagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(productAttachmentPagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String uploadFile() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            ProductAttachment productAttachment = new ProductAttachment();
            productAttachment.setProductNo(Integer.parseInt(this.getId()));
            productAttachment.setName(this.name);
            productAttachment.setPath(this.path);
            productAttachment.setType(Byte.valueOf(this.type));
            productAttachment.setStatus((byte) 1);
            productAttachment.setInUserNo(UserHelper.getEditUserNo());
            int fileID = ProductAttachmentModel.add(productAttachment);

            if (fileID > 0)
                this.setErrDesc(String.valueOf(fileID));
            else {
                this.setErrCode("uploadFailed");
                this.setErrDesc("NoID");
            }
        }
        return SUCCESS;
    }

    public String deleteFile() {
        if (StringHelper.isNullOrEmpty(this.getId())) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        } else {
            if (ProductAttachmentModel.updateStatus(Integer.parseInt(this.getId()),(byte)0) < 0){
                this.setErrCode("deleteFailed");
                this.setErrDesc("deleteFailed");
            }
        }
        return SUCCESS;
    }

    public String getFileList(){
        if (StringHelper.isNullOrEmpty(this.productNo)) {
            this.setErrCode("NoID");
            this.setErrDesc("NoID");
        }
        else{
            this.setResultList(ProductAttachmentModel.getListByProductNo(Integer.parseInt(this.productNo)));
        }

        return SUCCESS;
    }
}
