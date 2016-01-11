package com.hzfh.fmp.model.product;

import com.hzfh.api.product.model.ProductStages;
import com.hzfh.api.product.model.query.ProductStagesCondition;
import com.hzfh.fmp.facade.product.ProductStagesFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ProductStagesModel {
    public static PagedList<ProductStages> getPagingList(ProductStagesCondition productStagesCondition) {
        return ProductStagesFacade.getPagingList(productStagesCondition);
    }

    public static int add(ProductStages productStages) {
        return ProductStagesFacade.add(productStages);
    }

    public static int update(ProductStages productStages) {
        return ProductStagesFacade.update(productStages);
    }

    public static List<ProductStages> getList() {
        return ProductStagesFacade.getList();
    }

    public static ProductStages getInfo(int id) {
        return ProductStagesFacade.getInfo(id);
    }
    
    //mengchong 2015/03/02 计算当前产品的最大分期数
    public static Integer getProductMaxStage(int product_no){
    	return ProductStagesFacade.getProductMaxStage(product_no);
    } 
    public static int getProductStageId(int product_no,int StagesNumber){
    	return ProductStagesFacade.getProductStageId(product_no,StagesNumber);
    }

}
