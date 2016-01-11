package com.hzfh.p2p.model.product;

import java.util.List;

import com.hzfh.api.product.model.Product;
import com.hzfh.api.product.model.query.ProductCondition;
import com.hzfh.p2p.facade.product.ProductFacade;
import com.hzframework.contract.PagedList;


public class ProductModel {
	public static Product getInfo(int id) {
        return ProductFacade.getInfo(id);
    }
	public static PagedList<Product> getPagingList(ProductCondition ProductCondition) {
        return ProductFacade.getPagingList(ProductCondition);
    }

    public static int add(Product Product) {
        return ProductFacade.add(Product);
    }

    public static int update(Product Product) {
        return ProductFacade.update(Product);
    }

    public static List<Product> getList() {
        return ProductFacade.getList();
    }
	public static int updateReduceRemainAmount(int productNo, long money) {
		return ProductFacade.updateReduceRemainAmount(productNo,money);
	}

}
