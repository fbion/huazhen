package com.hzfh.service.workFlow.model.product;

import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.service.workFlow.facade.product.P2pProductFacade;

public class P2pProductModel {

    public static P2pProduct getInfo(int id) {
        return P2pProductFacade.getInfo(id);
    }

    public static P2pProduct getP2pByProductNo(int productNo) {
        return P2pProductFacade.getP2pByProductNo(productNo);
    }

    public static int updateRemainAmountByProductNo(int productNo, long money){
        return  P2pProductFacade.updateRemainAmountByProductNo(productNo,money);
    }
    public static int updateOrderCountByProductNo(int productNo,int count){
        return P2pProductFacade.updateOrderCountByProductNo(productNo,count);
    }
    public static int updateStatusById(int id, byte status){
        return P2pProductFacade.updateStatusById(id, status);
    }

}
