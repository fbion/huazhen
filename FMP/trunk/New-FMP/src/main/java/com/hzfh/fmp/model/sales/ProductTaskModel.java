package com.hzfh.fmp.model.sales;

import com.hzfh.api.sales.model.ProductTask;
import com.hzfh.api.sales.model.query.ProductTaskCondition;
import com.hzfh.fmp.facade.sales.ProductTaskFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ProductTaskModel {
    public static PagedList<ProductTask> getPagingList(ProductTaskCondition productTaskCondition) {
        return ProductTaskFacade.getPagingList(productTaskCondition);
    }

    public static int add(ProductTask productTask) {
        return ProductTaskFacade.add(productTask);
    }

    public static int update(ProductTask productTask) {
        return ProductTaskFacade.update(productTask);
    }

    public static List<ProductTask> getList() {
        return ProductTaskFacade.getList();
    }

    public static ProductTask getInfo(int id) {
        return ProductTaskFacade.getInfo(id);
    }

    public static List<ProductTask> getListByProductNo(int productNo){
    	return ProductTaskFacade.getListByProductNo(productNo);
    }

    public static int updateStatus(ProductTask productTask){
        return ProductTaskFacade.updateStatus(productTask);
    }
    //认购成功
	public static int updateAmount(ProductTask productTask) {
		return ProductTaskFacade.updateAmount(productTask);
	}
	//已退款
	public static int updateReAmount(ProductTask productTask) {
		return ProductTaskFacade.updateReAmount(productTask);
	}
    //打款审核通过增加当前销售金额
    public static  int updateAddCurrentAmount(int productNo, Long currentAmount, int deptNo){
        return ProductTaskFacade.updateAddCurrentAmount(productNo,currentAmount,deptNo);
    }
    //取消订单减少当前销售金额
    public static int updateReduceCurrentAmount(int productNo, Long currentAmount, int deptNo){
        return ProductTaskFacade.updateReduceCurrentAmount(productNo, currentAmount, deptNo);
    }
//    public List<ProductTask> getTaskByProductNo(int productNO){
//
//    }
}
