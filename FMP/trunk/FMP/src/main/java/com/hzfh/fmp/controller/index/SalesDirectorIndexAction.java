package com.hzfh.fmp.controller.index;

import com.hzfh.api.employee.model.Department;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.report.model.DeptSalesTotal;
import com.hzfh.api.sales.model.ProductTask;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.common.helper.UrlHelper;
import com.hzfh.fmp.model.common.properties.DeptHelper;
import com.hzfh.fmp.model.employee.DepartmentModel;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzfh.fmp.model.report.DeptSalesTotalModel;
import com.hzfh.fmp.model.sales.ProductTaskModel;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by Zorro 2015/4/21.
 */
public class SalesDirectorIndexAction extends CommonAction {
	private String productID;
	private Product product;
	private long salesAmount;
	private String salesType;
	private String productDetailUrl;
	private String salesDetailUrl;
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
	private long productTaskAmoutAll;
	private int countFortuneCenterMoney;
	private List<DeptSalesTotal> director = new ArrayList<DeptSalesTotal>();
	private List<DeptSalesTotal> channel = new ArrayList<DeptSalesTotal>();
	private List<DeptSalesTotal> shop = new ArrayList<DeptSalesTotal>();
	
	
	public List<DeptSalesTotal> getShop() {
		return shop;
	}
	public List<DeptSalesTotal> getDirector() {
		return director;
	}
	public List<DeptSalesTotal> getChannel() {
		return channel;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductID() {
		return productID;
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
	public String getProductDetailUrl() {
		return productDetailUrl;
	}
	public String getSalesDetailUrl() {
		return salesDetailUrl;
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
	public long getSalesAmountAll() {
		return salesAmountAll;
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
	public long getSalesFortuneCenter() {
		return salesFortuneCenter;
	}
	public int getCountSalesDirect() {
		return countSalesDirect;
	}
	public int getCountSalesChannel() {
		return countSalesChannel;
	}
	public int getCountsalesMendian() {
		return countsalesMendian;
	}
	public int getCountFortuneCenter() {
		return countFortuneCenter;
	}
	public long getProductTaskAmoutAll() {
		return productTaskAmoutAll;
	}
	public int getCountFortuneCenterMoney() {
		return countFortuneCenterMoney;
	}
	@Override
    public String execute() throws Exception {
		if (StringHelper.isNullOrEmpty(this.productID)) {
            return ERROR;
        }
        int id = Integer.parseInt(this.productID);
        product = ProductModel.getInfo(id);
        this.salesAmountAll = product.getSumMoney();
        this.showTask(id);
        this.showUrl(product);
        this.showSalseEachDepartment(id);
       
        return SUCCESS;
        
    }
	private void showTask(int productNo){
		List<ProductTask> productTaskList = new ArrayList<ProductTask>();
		productTaskList = ProductTaskModel.getListByProductNo(productNo);
		List<Integer> listDirect = new ArrayList<Integer>();
		listDirect = this.getDeptSalesDirect();
		List<Integer> listChannel = new ArrayList<Integer>();
		listChannel = this.getDeptSalesChannel();
		
		if (productTaskList!=null&&productTaskList.size()>0) {
			for (ProductTask productTask : productTaskList) {
				this.productTaskAmoutAll += productTask.getTaskAmout();
				if (listDirect.contains(productTask.getDeptNo())) {
					this.salesDirectTaskAmout += productTask.getTaskAmout(); 
				}
				if (listChannel.contains(productTask.getDeptNo())) {
					this.salesChannelTaskAmout += productTask.getTaskAmout();
				}
			}
		}
	}
	
	private List<Integer> getDeptSalesDirect(){
		List<Integer> list = new ArrayList<Integer>();
		List<Department> departments = new ArrayList<Department>();
		departments = DepartmentModel.getDirect();
		if (departments!=null&&departments.size()>0) {
			for (Department department : departments) {
				list.add(department.getId());
			}
		}
		return list;
	}
	
	private List<Integer> getDeptSalesChannel(){
		List<Integer> list = new ArrayList<Integer>();
		List<Department> departments = new ArrayList<Department>();
		departments = DepartmentModel.getChannel();
		if (departments!=null&&departments.size()>0) {
			for (Department department : departments) {
				list.add(department.getId());
			}
		}
		return list;
	}
	
	private List<Integer> getShopsAll(){
		List<Integer> list = new ArrayList<Integer>();
		List<Department> departments = new ArrayList<Department>();
		departments = DepartmentModel.getShopsAll();
		if (departments!=null) {
		for (Department department : departments) {
			list.add(department.getId());
		}
		}
		return list;
	}
	
	private void showSalseEachDepartment(int productNo){
		List<DeptSalesTotal> deptSalesTotals = new ArrayList<DeptSalesTotal>();
		deptSalesTotals = DeptSalesTotalModel.getListByProductNo(productNo);
		List<Integer> allDirect = new ArrayList<Integer>();
		List<Integer> allChannel = new ArrayList<Integer>();
		allDirect = this.getDeptSalesDirect();
		allChannel = this.getDeptSalesChannel();
		List<Integer> allShops = new ArrayList<Integer>();
		allShops = this.getShopsAll();
		
		if (deptSalesTotals!=null&&deptSalesTotals.size()>0) {
			for (DeptSalesTotal deptSalesTotal : deptSalesTotals) {
				 this.salesAmount += deptSalesTotal.getMoneyTotal();
				 if (deptSalesTotal.getDeptNo()==DeptHelper.DEPT_SALES) {
					this.salesDirectAll += deptSalesTotal.getMoneyTotal();
					this.countFortuneCenterMoney += deptSalesTotal.getCount();
				}
				if (allDirect.contains(deptSalesTotal.getDeptNo())) {
					this.director.add(deptSalesTotal);
					this.salesDirectAll += deptSalesTotal.getMoneyTotal();
					this.countSalesDirect += deptSalesTotal.getCount();
				}
				if (allChannel.contains(deptSalesTotal.getDeptNo())) {
					this.channel.add(deptSalesTotal);
					this.salesChannelAll += deptSalesTotal.getMoneyTotal();
					this.countSalesChannel += deptSalesTotal.getCount();
				}
				if (allShops.contains(deptSalesTotal.getDeptNo())) {
					this.shop.add(deptSalesTotal);
					this.salesMendianAll += deptSalesTotal.getMoneyTotal();
					this.countsalesMendian += deptSalesTotal.getCount();
				}
			}
			this.salesFortuneCenter = this.salesDirectAll+this.salesChannelAll;
			this.countFortuneCenter = countSalesDirect + countSalesChannel;
		}
	}
	private void showUrl(Product product){	
		this.productDetailUrl = UrlHelper.buildProductSiteUrl("product/product/edit?id=")+this.productID;
        this.salesDetailUrl = UrlHelper.buildSalesSiteUrl("sales/sales/list?byProductType="+product.getType()+"&&byProduct="+this.productID);
	}
	
	
}
