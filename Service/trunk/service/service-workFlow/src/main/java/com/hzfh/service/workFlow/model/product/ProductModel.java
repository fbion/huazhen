package com.hzfh.service.workFlow.model.product;

import com.hzfh.api.product.model.Product;
import com.hzfh.service.workFlow.facade.product.ProductFacade;

public class ProductModel {

    public static Product getInfo(int id) {
        return ProductFacade.getInfo(id);
    }

    public static int updateReduceRemainAmount(int productNo, long money) {
        return ProductFacade.updateReduceRemainAmount(productNo, money);
    }

    public static int updateStatus(int id, byte status) {
        return ProductFacade.updateStatus(id, status);
    }

    public static Product getInfoByActivitiNo(String activitiNo) {
        return  ProductFacade.getInfoByActivitiNo(activitiNo);
    }

}
