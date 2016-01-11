package com.hzfh.fmp.controller.index;

import com.hzfh.api.product.model.Decision;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.report.model.CompanySalesDaily;
import com.hzfh.api.sales.model.ProductTask;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.TaskDecision;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.enumeration.ProductStatus;
import com.hzfh.fmp.model.common.enumeration.ProductType;
import com.hzfh.fmp.model.common.helper.UrlHelper;
import com.hzfh.fmp.model.common.properties.DeptHelper;
import com.hzfh.fmp.model.common.properties.DictionaryHelper;
import com.hzfh.fmp.model.customer.CustomerCompanyModel;
import com.hzfh.fmp.model.customer.CustomerPersonalModel;
import com.hzfh.fmp.model.product.DecisionModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.report.CompanySalesTotalModel;
import com.hzfh.fmp.model.sales.ProductTaskModel;
import com.hzfh.fmp.model.sales.SalesModel;
import com.hzfh.fmp.model.sales.TaskDecisionModel;
import com.hzframework.helper.StringHelper;

import java.util.List;

/**
 * Created by paul on 15-2-6.
 */
public class ProductIndexAction extends CommonAction {
	private boolean showSalesStatus;
	private boolean showReview;
	private boolean showOnlineReview;
	private String productID;
	private Product product;
	private long salesAmount;
	private String salesType;
	private int salesCount;
	private int salesTotal;
	private byte riskControlReviewStatus;
	private byte productDirectorReviewStatus;
	private String productDetailUrl;
	private String salesDetailUrl;
	private String updateStatusUrl;
	public List<CompanySalesDaily> companySalesTotalList;
	public List<Sales> salesList;
	public List<Product> productListOnSales;
	private byte presidentReviewStatus;
	private byte financeReviewStatus;
	private byte showSalesChannel;
	private byte onlineRiskControlReviewStatus0;
	private byte onlinePresidentReviewStatus0;
	private byte onlineFinanceReviewStatus0;
	private byte onlineRiskControlReviewStatus1;
	private byte onlinePresidentReviewStatus1;
	private byte onlineFinanceReviewStatus1;

	public byte getFinanceReviewStatus() {
		return financeReviewStatus;
	}

	public void setFinanceReviewStatus(byte financeReviewStatus) {
		this.financeReviewStatus = financeReviewStatus;
	}

	public byte getPresidentReviewStatus() {
		return presidentReviewStatus;
	}

	public void setPresidentReviewStatus(byte presidentReviewStatus) {
		this.presidentReviewStatus = presidentReviewStatus;
	}

	public List<Product> getProductListOnSales() {
		return productListOnSales;
	}

	public void setProductListOnSales(List<Product> productListOnSales) {
		this.productListOnSales = productListOnSales;
	}

	public String getUpdateStatusUrl() {
		return updateStatusUrl;
	}

	public void setUpdateStatusUrl(String updateStatusUrl) {
		this.updateStatusUrl = updateStatusUrl;
	}

	public boolean isShowSalesStatus() {
		return showSalesStatus;
	}

	public boolean isShowReview() {
		return showReview;
	}

	public boolean isShowOnlineReview() {
		return showOnlineReview;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public Product getProduct() {
		return product;
	}

	public long getSalesAmount() {
		return salesAmount;
	}

	public String getSalesType() {
		return salesType;
	}

	public int getSalesTotal() {
		return salesTotal;
	}

	public int getSalesCount() {
		return salesCount;
	}

	public byte getRiskControlReviewStatus() {
		return riskControlReviewStatus;
	}

	public byte getProductDirectorReviewStatus() {
		return productDirectorReviewStatus;
	}

	public void setShowSalesStatus(boolean showSalesStatus) {
		this.showSalesStatus = showSalesStatus;
	}

	public String getProductDetailUrl() {
		return productDetailUrl;
	}

	public void setProductDetailUrl(String productDetailUrl) {
		this.productDetailUrl = productDetailUrl;
	}

	public String getSalesDetailUrl() {
		return salesDetailUrl;
	}

	public void setSalesDetailUrl(String salesDetailUrl) {
		this.salesDetailUrl = salesDetailUrl;
	}

	public List<Sales> getSalesList() {
		return salesList;
	}

	public void setSalesList(List<Sales> salesList) {
		this.salesList = salesList;
	}

	public byte getShowSalesChannel() {
		return showSalesChannel;
	}

	public void setShowSalesChannel(byte showSalesChannel) {
		this.showSalesChannel = showSalesChannel;
	}

	public byte getOnlineRiskControlReviewStatus0() {
		return onlineRiskControlReviewStatus0;
	}

	public void setOnlineRiskControlReviewStatus0(
			byte onlineRiskControlReviewStatus0) {
		this.onlineRiskControlReviewStatus0 = onlineRiskControlReviewStatus0;
	}

	public byte getOnlinePresidentReviewStatus0() {
		return onlinePresidentReviewStatus0;
	}

	public void setOnlinePresidentReviewStatus0(
			byte onlinePresidentReviewStatus0) {
		this.onlinePresidentReviewStatus0 = onlinePresidentReviewStatus0;
	}

	public byte getOnlineFinanceReviewStatus0() {
		return onlineFinanceReviewStatus0;
	}

	public void setOnlineFinanceReviewStatus0(byte onlineFinanceReviewStatus0) {
		this.onlineFinanceReviewStatus0 = onlineFinanceReviewStatus0;
	}

	public byte getOnlineRiskControlReviewStatus1() {
		return onlineRiskControlReviewStatus1;
	}

	public void setOnlineRiskControlReviewStatus1(
			byte onlineRiskControlReviewStatus1) {
		this.onlineRiskControlReviewStatus1 = onlineRiskControlReviewStatus1;
	}

	public byte getOnlinePresidentReviewStatus1() {
		return onlinePresidentReviewStatus1;
	}

	public void setOnlinePresidentReviewStatus1(
			byte onlinePresidentReviewStatus1) {
		this.onlinePresidentReviewStatus1 = onlinePresidentReviewStatus1;
	}

	public byte getOnlineFinanceReviewStatus1() {
		return onlineFinanceReviewStatus1;
	}

	public void setOnlineFinanceReviewStatus1(byte onlineFinanceReviewStatus1) {
		this.onlineFinanceReviewStatus1 = onlineFinanceReviewStatus1;
	}

	@Override
    public String execute() throws Exception {
        if (StringHelper.isNullOrEmpty(this.productID)) {
            return ERROR;
        }
        int id = Integer.parseInt(this.productID);
        product = ProductModel.getInfo(id);

        if (product.getStatus() == ProductStatus.ON_SALE)
        this.salesAmount = product.getSumMoney() - product.getRemainAmount();

        if (product.getType() == ProductType.TRUST) {
            this.salesType = "小额打款数量";
            this.salesCount = 50 - product.getRemainSmall();
            this.salesTotal = 50;
        } else if (product.getType() == ProductType.ASSETS_CONTROL) {
            this.salesType = "小额打款数量";
            this.salesCount = 200 - product.getRemainSmall();
            this.salesTotal = 200;
        } else {
            this.salesType = "打款数量";
            this.salesCount = 200 - product.getRemainSmall();
            this.salesTotal = 200;
        }
        List<Decision> decisionList = DecisionModel.getListByProductNo(id);
        if (decisionList != null && decisionList.size() > 0) {
            this.showReview = true;
            for (Decision decision:decisionList){
                if (decision.getDepNo() == DeptHelper.DEPT_RISK_CONTROL)
                    this.riskControlReviewStatus = decision.getIsOk();
                if(decision.getDepNo() == DeptHelper.DEPT_PRODUCT)
                    this.productDirectorReviewStatus = decision.getIsOk();
            }

        } else
            this.showReview = false;


        List<ProductTask> productTaskList = ProductTaskModel.getListByProductNo(id);   

        if (productTaskList!=null && productTaskList.size()>0) {       
        	this.showOnlineReview = true;	
        	List<TaskDecision> taskDecisionList = null;	
        	for (int i = 0; i < productTaskList.size(); i++) { 		
    			taskDecisionList=TaskDecisionModel.getListByTaskNo(productTaskList.get(i).getId());
        		if (DeptHelper.DEPT_SALES_DIRECT.contains(productTaskList.get(i).getDeptNo())) { 
        			for (TaskDecision taskDecision : taskDecisionList) {
	        			if (taskDecisionList != null && taskDecisionList.size() > 0){
	            		        	if (taskDecision.getDepNo() == DeptHelper.DEPT_RISK_CONTROL){
	            		        		this.onlineRiskControlReviewStatus0 = taskDecision.getIsOk();
	            		        	}
	            		        	if (taskDecision.getDepNo() == DeptHelper.DEPT_PRESIDENT){
	            		        		this.onlinePresidentReviewStatus0 = taskDecision.getIsOk();
	            		        	}
	            		        	if (taskDecision.getDepNo() == DeptHelper.DEPT_FINANCE){
	            		        		this.onlineFinanceReviewStatus0 = taskDecision.getIsOk();
	            		        	}
	    					}
							
	        			}
        		}else{
        			for (TaskDecision taskDecision : taskDecisionList) {
                			if (taskDecisionList != null && taskDecisionList.size() > 0){
                    		        	if (taskDecision.getDepNo() == DeptHelper.DEPT_RISK_CONTROL){
                    		        		this.onlineRiskControlReviewStatus1 = taskDecision.getIsOk();
                    		        	}
                    		        	if (taskDecision.getDepNo() == DeptHelper.DEPT_PRESIDENT){
                    		        		this.onlinePresidentReviewStatus1 = taskDecision.getIsOk();
                    		        	}
                    		        	if (taskDecision.getDepNo() == DeptHelper.DEPT_FINANCE){
                    		        		this.onlineFinanceReviewStatus1 = taskDecision.getIsOk();
                    		        	}
            					}
        						
                			}
        			}
        		}
		}else{
			this.showOnlineReview = false;
		}
        
        this.productDetailUrl = UrlHelper.buildProductSiteUrl("product/product/edit?id=")+this.productID;
        this.salesDetailUrl = UrlHelper.buildSalesSiteUrl("sales/sales/list?byProductType="+product.getType()+"&&byProduct="+this.productID);
        //SalesTotal
        this.companySalesTotalList = CompanySalesTotalModel.getListByProductNo(this.productID);
        //get sales list  when status equal to one	
        List<Sales> sList = SalesModel.getSalesListByProductAndStatus(Integer.parseInt(this.productID), 1);
        String tempName = "";
        for (int i = 0; i < sList.size(); i++) {
        		if (sList.get(i).getCustomerType()==DictionaryHelper.DIC_CUSTOMERPERSONAL) {
        			tempName = CustomerPersonalModel.getInfo(sList.get(i).getCustomerNo()).getName();
        			if (!StringHelper.isNullOrEmpty(tempName)) {
        				sList.get(i).setBankAddress(tempName);
        			}else{
        				sList.get(i).setBankAddress("");
					}
				}else{
					tempName = CustomerCompanyModel.getInfo(sList.get(i).getCustomerNo()).getName();
        			if (!StringHelper.isNullOrEmpty(tempName)) {
        				sList.get(i).setBankAddress(tempName);
        			}else{
        				sList.get(i).setBankAddress("");
					}
				}
        		
        }
        
        if (sList.size()>=5) {
        	this.salesList=sList.subList(0, 5);
		}else{
			this.salesList=sList;
		}
        this.updateStatusUrl = UrlHelper.buildSalesSiteUrl("sales/sales/updateStatusBySalesId.action");
      
        return SUCCESS;
        
    }
}
