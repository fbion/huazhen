package com.hzfh.fmp.controller.index;

import com.hzfh.api.employee.model.Department;
import com.hzfh.api.product.model.Decision;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.report.model.CompanySalesDaily;
import com.hzfh.api.report.model.DeptSalesTotal;
import com.hzfh.api.sales.model.ProductTask;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.TaskDecision;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.enumeration.ProductStatus;
import com.hzfh.fmp.model.common.enumeration.ProductType;
import com.hzfh.fmp.model.common.helper.UrlHelper;
import com.hzfh.fmp.model.common.properties.DeptHelper;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.product.DecisionModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.report.CompanySalesTotalModel;
import com.hzfh.fmp.model.report.DeptSalesTotalModel;
import com.hzfh.fmp.model.sales.ProductTaskModel;
import com.hzfh.fmp.model.sales.TaskDecisionModel;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by Zorro 2015/4/21.
 */
public class SalesIndexAction extends CommonAction {
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
	private long productTaskAmoutAll;
	private long salesDirectTaskAmout;
	private long salesChannelTaskAmout;
	private long salesMendianTaskAmout;
	private long salesAmountAll;
	
	private long salesDirectAll;
	private long salesChannelAll;
	private long salesMendianAll;
	private long salesFortuneCenter;
	
	private int  countSalesDirect;
	private int  countSalesChannel;
	private int  countsalesMendian;
	private int  countFortuneCenter;
	
	
	
	public long getSalesAmountAll() {
		return salesAmountAll;
	}
	public int getCountFortuneCenter() {
		return countFortuneCenter;
	}
	public int getCountsalesMendian() {
		return countsalesMendian;
	}
	public int getCountSalesDirect() {
		return countSalesDirect;
	}
	public int getCountSalesChannel() {
		return countSalesChannel;
	}
	public long getSalesFortuneCenter() {
		return salesFortuneCenter;
	}
	public long getSalesDirectAll() {
		return salesDirectAll;
	}
	public long getSalesChannelAll() {
		return salesChannelAll;
	}
	public long getSalesMendianAll() {
		return salesMendianAll;
	}
	public List<CompanySalesDaily> getCompanySalesTotalList() {
		return companySalesTotalList;
	}
	public long getSalesDirectTaskAmout() {
		return salesDirectTaskAmout;
	}
	public long getSalesChannelTaskAmout() {
		return salesChannelTaskAmout;
	}
	public long getSalesMendianTaskAmout() {
		return salesMendianTaskAmout;
	}
	public long getProductTaskAmoutAll() {
		return productTaskAmoutAll;
	}
	public byte getFinanceReviewStatus() {
		return financeReviewStatus;
	}
	public byte getPresidentReviewStatus() {
		return presidentReviewStatus;
	}
	public List<Product> getProductListOnSales() {
		return productListOnSales;
	}
	public String getUpdateStatusUrl() {
		return updateStatusUrl;
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
	public String getProductDetailUrl() {
		return productDetailUrl;
	}
	public String getSalesDetailUrl() {
		return salesDetailUrl;
	}
	public List<Sales> getSalesList() {
		return salesList;
	}
	public byte getShowSalesChannel() {
		return showSalesChannel;
	}
	public byte getOnlineRiskControlReviewStatus0() {
		return onlineRiskControlReviewStatus0;
	}
	public byte getOnlinePresidentReviewStatus0() {
		return onlinePresidentReviewStatus0;
	}
	public byte getOnlineFinanceReviewStatus0() {
		return onlineFinanceReviewStatus0;
	}
	public byte getOnlineRiskControlReviewStatus1() {
		return onlineRiskControlReviewStatus1;
	}
	public byte getOnlinePresidentReviewStatus1() {
		return onlinePresidentReviewStatus1;
	}
	public byte getOnlineFinanceReviewStatus1() {
		return onlineFinanceReviewStatus1;
	}

	
	@Override
    public String execute() throws Exception {
        if (StringHelper.isNullOrEmpty(this.productID)) {
            return ERROR;
        }
        
        
        int id = Integer.parseInt(this.productID);
        product = ProductModel.getInfo(id);       
        this.showSalseEachDepartment(id);
//        this.showDecision(id);
//        this.showDecisionTask(id);
//        this.showCompanyTotal();
        this.showSalesList();
        this.showTask(id);
        this.showUrl(product);
        this.showSalse(product);
       
        return SUCCESS;
        
    }
	
	
	
	private void showDecisionTask(int productNo){
		
		List<ProductTask> productTaskList = ProductTaskModel.getListByProductNo(productNo);   
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
	}
	
	private void showDecision(int productNo){
		  List<Decision> decisionList = DecisionModel.getListByProductNo(productNo);
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
	}
	
	private void showTask(int productNo){
		List<ProductTask> productTaskList = new ArrayList<ProductTask>();
		productTaskList = ProductTaskModel.getListByProductNo(productNo);
		if (productTaskList!=null&&productTaskList.size()>0) {
			for (ProductTask productTask : productTaskList) {
				this.productTaskAmoutAll += productTask.getTaskAmout();
				if (DeptHelper.DEPT_SALES_DIRECT.contains(productTask.getDeptNo())) {
					this.salesDirectTaskAmout = productTask.getCurrAmout(); 
				}
				if (DeptHelper.DEPT_SALES_CHANNEL.contains(productTask.getDeptNo())) {
					this.salesChannelTaskAmout = productTask.getCurrAmout();
				}
				if (DeptHelper.DEPT_SALES_SHOP==productTask.getDeptNo()) {
					this.salesMendianTaskAmout = productTask.getCurrAmout();
				}
				
				
			}
		}
		
	}
	
	
	private void showSalse(Product product){
	    if (product.getStatus() == ProductStatus.ON_SALE)
//	        this.salesAmount = product.getSumMoney() - product.getRemainAmount();
	    	this.salesAmountAll = product.getSumMoney();
	        if (product.getType() == ProductType.TRUST) {
	            this.salesType = "小额打款:   ";
	            this.salesCount = 50 - product.getRemainSmall();
	            this.salesTotal = 50;
	        } else if (product.getType() == ProductType.ASSETS_CONTROL) {
	            this.salesType = "小额打款:   ";
	            this.salesCount = 200 - product.getRemainSmall();
	            this.salesTotal = 200;
	        } else {
	            this.salesType = "打款:   ";
	            this.salesCount = 200 - product.getRemainSmall();
	            this.salesTotal = 200;
	        }
	}
	
	
	private void showSalseEachDepartment(int productNo){
		List<DeptSalesTotal> deptSalesTotals = new ArrayList<DeptSalesTotal>();
		deptSalesTotals = DeptSalesTotalModel.getListByProductNo(productNo);
		List<Department> departments = new ArrayList<Department>();
		List<Department> deptNoA = new ArrayList<Department>();//财富管理中心的子部门
		List<Department> deptNoB = new ArrayList<Department>();//新金融事业部的子部门
		departments = DepartmentModel.getList();
		
		
		if (departments!=null&&departments.size()>0) {
			for (Department department : departments) {
				if (department.getParentNo()==5) {//财富管理中心的子部门 （之后需要改成从数据库跟根据编号查）
					deptNoA.add(department);
				}
				if (department.getParentNo()==42) {//新金融事业部的子部门
					deptNoB.add(department);
				}
			}
		}
		
		
		List<Integer> deptNoADirect = new ArrayList<Integer>();
		List<Integer> deptNoAChannel = new ArrayList<Integer>();
		List<Integer> deptNoBMendian = new ArrayList<Integer>();
		if (deptNoA!=null&&deptNoA.size()>0) {
			for (Department d : deptNoA) {
				if (d.getDeptType()==4) { //渠道
					deptNoAChannel.add(d.getId());
				}
				if (d.getDeptType()==3) { //直销
					deptNoADirect.add(d.getId());
				}
			}
		}
		if (deptNoB!=null&&deptNoB.size()>0) {
			for (Department dept : deptNoB) {
				deptNoBMendian.add(dept.getId());
			}
		}
		
		
		//countSalesDirect countSalesChannel countsalesMendian
		if (deptSalesTotals!=null&&deptSalesTotals.size()>0) {
			for (DeptSalesTotal deptSalesTotal : deptSalesTotals) {
				 this.salesAmount += deptSalesTotal.getMoneyTotal();
				
				if (deptNoADirect.contains(deptSalesTotal.getDeptNo())) {
					this.salesDirectAll += deptSalesTotal.getMoneyTotal();
					this.countSalesDirect = deptSalesTotal.getCount();
				}
				if (deptNoAChannel.contains(deptSalesTotal.getDeptNo())) {
					this.salesChannelAll += deptSalesTotal.getMoneyTotal();
					this.countSalesChannel = deptSalesTotal.getCount();
				}
				if (deptNoBMendian.contains(deptSalesTotal.getDeptNo())) {
					this.salesMendianAll += deptSalesTotal.getMoneyTotal();
					this.countsalesMendian = deptSalesTotal.getCount();
				}
			}

			this.salesFortuneCenter = this.salesDirectAll+this.salesChannelAll;
			this.countFortuneCenter = countSalesDirect + countSalesChannel;
		}
	}
	
	
	private void showUrl(Product product){	
		this.productDetailUrl = UrlHelper.buildProductSiteUrl("product/product/edit?id=")+this.productID;
        this.salesDetailUrl = UrlHelper.buildSalesSiteUrl("sales/sales/list?byProductType="+product.getType()+"&&byProduct="+this.productID);
        this.updateStatusUrl = UrlHelper.buildSalesSiteUrl("sales/sales/updateStatusBySalesId.action");
	}
	
	
	private void showCompanyTotal(){
		  //SalesTotal
        this.companySalesTotalList = CompanySalesTotalModel.getListByProductNo(this.productID);
	}
	
	private void showSalesList(){
		   //get sales list  when status equal to one	
//        List<Sales> sList = SalesModel.getSalesListByProductAndStatus(Integer.parseInt(this.productID), 1);
//
//        int countSalesDirect = 0;
//    	int countSalesChannel = 0;
//        if (sList!=null) {
//			for (Sales sales : sList) {
//				if (DeptHelper.DEPT_SALES_DIRECT.contains(sales.getDeptNo())) {
//					countSalesDirect++;
//				}
//				if (DeptHelper.DEPT_SALES_CHANNEL.contains(sales.getDeptNo())) {
//					countSalesChannel++;
//				}
//			}
//		}
//        this.countSalesDirect = countSalesDirect;		
//        this.countSalesChannel = countSalesChannel;
//               
	}
	
	
	
}
