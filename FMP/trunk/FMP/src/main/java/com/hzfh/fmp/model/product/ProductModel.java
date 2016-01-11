package com.hzfh.fmp.model.product;

import com.hzfh.api.product.model.Product;
import com.hzfh.api.product.model.query.ProductCondition;
import com.hzfh.fmp.facade.product.ProductFacade;
import com.hzfh.fmp.model.common.helper.FlushCacheHelper;
import com.hzframework.contract.PagedList;

import java.util.Date;
import java.util.List;

public class ProductModel {
    public static PagedList<Product> getPagingList(ProductCondition productCondition) {
        return ProductFacade.getPagingList(productCondition);
    }

    public static int add(Product product)
    {
        int id = ProductFacade.add(product);
        FlushCacheHelper.flushProductCache();
        return  id;
    }

    public static int update(Product product) {
        return  ProductFacade.update(product);
    }

    public static List<Product> getList() {
        return ProductFacade.getList();
    }

    public static Product getInfo(int id) {
        return ProductFacade.getInfo(id);
    }

    public static List<Product> getListByType(byte type) {
        return ProductFacade.getListByType(type);
    }

    public static int updateStatus(int id, byte status) {
        return ProductFacade.updateStatus(id, status);
    }

    public static int updateManager(int id, int emp) {
        return ProductFacade.updateManager(id, emp);
    }

    public static int updateBasicInfo(Product product){
        return ProductFacade.updateBasicInfo(product);
    }
    //认购成功
	public static int updateRemain(Product product) {
		return ProductFacade.updateRemain(product);
	}
	//取消订单
	public static int updateReRemain(Product product) {
		return ProductFacade.updateReRemain(product);
	}

    public static int updateStatusAndTime(Product product) {
        return ProductFacade.updateStatusAndTime(product);
    }
    //更新创建时间
    public static int updateStartTime(int id, Date start) {
		return ProductFacade.updateStartTime(id,start);
	}

	public static List<Product> getProductByTypeAndStatus(byte type, byte status) {
		return ProductFacade.getProductByTypeAndStatus(type,status);
	}

    public static List<Product> getProductListWithNoPaging(ProductCondition productCondition) {
        return ProductFacade.getProductListWithNoPaging(productCondition);
    }
    //mengchong 
    public static int updateAddRemainAmountAndRemainSmall(int id, long remainAmount){
		return ProductFacade.updateAddRemainAmountAndRemainSmall(id, remainAmount);
	}
    public static int updateReduceRemainAmountAndRemainSmall(int id,long remainAmount){
        return ProductFacade.updateReduceRemainAmountAndRemainSmall(id,remainAmount);
    }

	public static List<Product> getProductListByStatus(byte statusLeft,byte statusRight) {
		return ProductFacade.getProductListByStatus(statusLeft,statusRight);
	}

    public static int updateReduceRemainAmount(int productNo, long money) {
        return ProductFacade.updateReduceRemainAmount(productNo,money);
    }

    public static int updateAddRemainAmount(int productNo, long money) {
        return ProductFacade.updateAddRemainAmount(productNo,money);
    }

    public static Product getInfoByActivitiNo(String activitiNo) {
        return  ProductFacade.getInfoByActivitiNo(activitiNo);
    }
}
