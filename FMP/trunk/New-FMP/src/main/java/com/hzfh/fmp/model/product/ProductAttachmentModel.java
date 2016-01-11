package com.hzfh.fmp.model.product;

import com.hzfh.api.product.model.ProductAttachment;
import com.hzfh.api.product.model.query.ProductAttachmentCondition;
import com.hzfh.fmp.facade.product.ProductAttachmentFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ProductAttachmentModel {
    public static PagedList<ProductAttachment> getPagingList(ProductAttachmentCondition productAttachmentCondition) {
        return ProductAttachmentFacade.getPagingList(productAttachmentCondition);
    }

    public static int add(ProductAttachment productAttachment) {
        return ProductAttachmentFacade.add(productAttachment);
    }

    public static int update(ProductAttachment productAttachment) {
        return ProductAttachmentFacade.update(productAttachment);
    }

    public static List<ProductAttachment> getList() {
        return ProductAttachmentFacade.getList();
    }

    public static ProductAttachment getInfo(int id) {
        return ProductAttachmentFacade.getInfo(id);
    }
    
    
    public static List<ProductAttachment> getListByProductNo(int productNo) {
        return ProductAttachmentFacade.getListByProductNo(productNo);
    }
    
    public static int updateStatus(int id,byte status) {
        return ProductAttachmentFacade.updateStatus(id,status);
    }
}
