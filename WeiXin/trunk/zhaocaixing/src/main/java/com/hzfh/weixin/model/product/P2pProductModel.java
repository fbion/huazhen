package com.hzfh.weixin.model.product;

import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.query.P2pProductCondition;
import com.hzfh.weixin.facade.product.P2pProductFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class P2pProductModel {
    public static PagedList<P2pProduct> getPagingList(P2pProductCondition p2pProductCondition) {
        return P2pProductFacade.getPagingList(p2pProductCondition);
    }

    public static int add(P2pProduct p2pProduct) {
        return P2pProductFacade.add(p2pProduct);
    }

    public static int update(P2pProduct p2pProduct) {
        return P2pProductFacade.update(p2pProduct);
    }

    public static List<P2pProduct> getList() {
    	List<P2pProduct> list = P2pProductFacade.getList();
        return P2pProductFacade.getList();
    }

    public static P2pProduct getInfo(int id) {
        return P2pProductFacade.getInfo(id);
    }
    public static List<P2pProduct> selectByStatus(byte status){
    	return P2pProductFacade.selectByStatus(status);
    }
    
    public static P2pProduct getP2pByProductNo(int productNo){
    	return P2pProductFacade.getP2pByProductNo(productNo);
    }

	public static int updateRemainAmountByProductNo(int productNo, long money) {
		return  P2pProductFacade.updateRemainAmountByProductNo(productNo,money);
	}

	public static int updateOrderCountByProductNo(int productNo, int count) {
		return P2pProductFacade.updateOrderCountByProductNo(productNo,count);
	}
}
