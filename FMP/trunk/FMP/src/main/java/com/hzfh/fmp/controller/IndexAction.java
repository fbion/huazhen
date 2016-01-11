package com.hzfh.fmp.controller;

import com.hzfh.api.baseInfo.model.Letter;
import com.hzfh.api.employee.model.AchievementCommission;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.model.Subsidy;
import com.hzfh.api.product.model.Product;
import com.hzfh.api.product.model.query.ProductCondition;
import com.hzfh.fmp.controller.common.CommonAction;
import com.hzfh.fmp.model.baseInfo.LetterModel;
import com.hzfh.fmp.model.common.PageAlias;
import com.hzfh.fmp.model.common.enumeration.ProductStatus;
import com.hzfh.fmp.model.common.enumeration.TagPermission;
import com.hzfh.fmp.model.common.enumeration.TagPermissionType;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.properties.ParamHelper;
import com.hzfh.fmp.model.common.state.StateValues;
import com.hzfh.fmp.model.employee.AchievementCommissionModel;
import com.hzfh.fmp.model.employee.SubsidyModel;
import com.hzfh.fmp.model.permission.view.TagPermissionView;
import com.hzfh.fmp.model.product.ProductModel;
import com.hzframework.helper.StringHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by paul on 14-10-31.
 */
public class IndexAction extends CommonAction {

	private List<Product> productList;
	private List<Subsidy> subsidyList;
	private String pageVar;
	private int commissionMoneyMonth = 0;
	private int commissionMonth;
	private int subsidyTotal=0;
	private int subsidyMonth=0;
	private int sendMonth;
	
	public int getSendMonth() {
		return sendMonth;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public List<Subsidy> getSubsidyList() {
		return subsidyList;
	}
	public String getPageVar() {
		return pageVar;
	}
	public int getCommissionMoneyMonth() {
		return commissionMoneyMonth;
	}
	public int getSubsidyTotal() {
		return subsidyTotal;
	}
	public int getSubsidyMonth() {
		return subsidyMonth;
	}
	public int getCommissionMonth() {
		return commissionMonth;
	}


	// ALL Tags true or false
	public boolean showProductIndex = false;// 产品部门
	public boolean showPresidentIndex = false;// 总裁
	public boolean showSalesIndex = false;// 销售部门
	public boolean showSalesDirectorIndex = false;// 销售总监
	public boolean showNeedReleaseIndex=false;//招聘专员
	public boolean showActivityIndex=false;//活动中心
	private boolean showSubsidy;
	private boolean showAchievementCommission;
	private boolean showSubsidyAndAchievementCommission;
	
	public boolean isShowActivityIndex() {
		return showActivityIndex;
	}
	public void setShowActivityIndex(boolean showActivityIndex) {
		this.showActivityIndex = showActivityIndex;
	}
	public boolean isShowNeedReleaseIndex() {
		return showNeedReleaseIndex;
	}
	public void setShowNeedReleaseIndex(boolean showNeedReleaseIndex) {
		this.showNeedReleaseIndex = showNeedReleaseIndex;
	}
	public boolean isShowProductIndex() {
		return showProductIndex;
	}

	public boolean isShowPresidentIndex() {
		return showPresidentIndex;
	}

	public void setShowPresidentIndex(boolean showPresidentIndex) {
		this.showPresidentIndex = showPresidentIndex;
	}

	public boolean isShowSalesIndex() {
		return showSalesIndex;
	}

	public void setShowSalesIndex(boolean showSalesIndex) {
		this.showSalesIndex = showSalesIndex;
	}

	public boolean isShowSalesDirectorIndex() {
		return showSalesDirectorIndex;
	}

	public void setShowSalesDirectorIndex(boolean showSalesDirectorIndex) {
		this.showSalesDirectorIndex = showSalesDirectorIndex;
	}

	public void setShowProductIndex(boolean showProductIndex) {
		this.showProductIndex = showProductIndex;
	}
	
	public boolean isShowSubsidy() {
		return showSubsidy;
	}

	public boolean isShowAchievementCommission() {
		return showAchievementCommission;
	}
	
	public boolean isShowSubsidyAndAchievementCommission() {
		return showSubsidyAndAchievementCommission;
	}
    private List<Letter> letterLista;

    public List<Letter> getLetterLista() {
        return letterLista;
    }

    public void setLetterLista(List<Letter> letterLista) {
        this.letterLista = letterLista;
    }

    @Override
	public String execute() throws Exception{
		this.setPageAlias(PageAlias.index);

		String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;

		this.initSubsidyAndAchievementCommission();
		this.initShowSubsidy();
		this.intiShowAchievementCommission();
		
		List<Product> pL = new ArrayList<Product>();
		pL = this.getProductListWithNoPaging();
		if (pL != null && pL.size() > 0) {
			productList = pL;
		} else {
			productList = null;
		}

		this.initShowPresidentIndex();
		this.initShowProductIndex();
		this.initShowSalesDirectorIndex();
		this.initShowSalesIndex();
		this.needReleaseTaskIndex();
		this.activityIndex();
		// this.initPageVar();
		return SUCCESS;
	}

	private void initShowProductIndex(){
		if (this.getPagePermissionView().getTagPermission(TagPermission.PRODUCT_INDEX) == TagPermissionType.query) {
			this.showProductIndex = true;
		} else {
			this.showProductIndex = false;
		}
	}

	private void initShowPresidentIndex() {
		 if (this.getPagePermissionView().getTagPermission(TagPermission.PRESIDENT_INDEX) == TagPermissionType.query) {
			this.showPresidentIndex = true;
		} else {
			this.showPresidentIndex = false;
		}
	}

	private void initShowSalesIndex() {
		if(this.getPagePermissionView().getTagPermission(TagPermission.SALES_INDEX) == TagPermissionType.query) {
			this.showSalesIndex = true;
		} else {
			this.showSalesIndex = false;
		}
	}
	private void needReleaseTaskIndex() {
		if(this.getPagePermissionView().getTagPermission(TagPermission.NEED_REALEASETASK_INDEX) == TagPermissionType.query) {
			this.showNeedReleaseIndex = true;
		} else {
			this.showNeedReleaseIndex = false;
		}
	}
	private void activityIndex() {
		if(this.getPagePermissionView().getTagPermission(TagPermission.ACTIVITY_INDEX) == TagPermissionType.query) {
			this.showActivityIndex = true;
		} else {
			this.showActivityIndex = false;
		}
	}
	private void initShowSalesDirectorIndex() {
		if(this.getPagePermissionView().getTagPermission(TagPermission.SALES_DIRECTOR_INDEX) == TagPermissionType.query) {
			this.showSalesDirectorIndex = true;
		} else {
			this.showSalesDirectorIndex = false;
		}
	}
	
	private void initSubsidyAndAchievementCommission() throws Exception {
		if(this.getPagePermissionView().getTagPermission(TagPermission.SUB_AND_ACH) == TagPermissionType.query) {
			this.showSubsidyAndAchievementCommission = true;
		} else {
			this.showSubsidyAndAchievementCommission = false;
		}
	}

	private void initPageVar() {
		StringBuilder sb = new StringBuilder();
		sb.append("<script type=\"text/javascript\">");
		sb.append("var PageVar={");
		// sb.append(String.format("%1$s:'%2$s',", "ID", this.id));
		// sb.append(String.format("%1$s:'%2$s',", "ProductNo",
		// this.productNo));
		// sb.append(String.format("%1$s:'%2$s',", "StatusNotReceive",
		// TaskStatus.NOT_RECEIVE));
		// sb.append(String.format("%1$s:'%2$s',", "StatusReceived",
		// TaskStatus.RECEIVED));
		// sb.append(String.format("%1$s:'%2$s',", "StatusAudit",
		// TaskStatus.AUDIT));
		sb.append("};");

		sb.append("var ElementVar={");
		for (TagPermissionView tagPermissionView : this.getPagePermissionView()
				.getTagPermissionViewList()) {
			sb.append(String.format("%1$s:'%2$s',",
					tagPermissionView.getTagName(),
					String.valueOf(tagPermissionView.getTagPermissionType())));
		}
		sb.append("};");
		sb.append("</script>");
		this.pageVar = sb.toString();
	}

	private List<Product> getProductListWithNoPaging() {
		ProductCondition productCondition = new ProductCondition();
		List<Employee> empList = new ArrayList<Employee>();
		empList = UserHelper.getUserCache().getEmployeeWorkMateList();
		List<Integer> workMateList = new ArrayList<Integer>();
		List<Product> pList = new ArrayList<Product>();
		if (empList != null) {
			for (Employee emp : empList) {
				workMateList.add(emp.getUserNo());
			}
		}

		workMateList.add(UserHelper.getUserCache().getUserId());
		productCondition.setWorkMateString(StringHelper
				.listToString(workMateList));
		productCondition.setStatusLeft(ProductStatus.STORE);
		productCondition.setStatusRight(ProductStatus.ON_SALE);
		String isTest=StateValues.getIsTest();
		if (!StringHelper.isNullOrEmpty(isTest)) {
			 productCondition.setIsTest(Byte.valueOf(isTest));
	    } else {
	       	productCondition.setIsTest((byte) 0);
	    }
		
		if (productCondition != null) {
			pList = ProductModel.getProductListWithNoPaging(productCondition);
		}

		return pList;
	}
	
	private void initShowSubsidy(){
    	int empNo= Integer.valueOf(UserHelper.getUserCache().getEmpId());
    	this.subsidyList = SubsidyModel.getListByEmpNo(empNo);
		if (subsidyList!=null&&subsidyList.size()>0) {
			this.showSubsidy=true;
			
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd");//可以方便地修改日期格式 
			int currentDay = Integer.valueOf(dateFormat.format(now));
			Calendar t = Calendar.getInstance();
			int month = t.get(Calendar.MONTH)+1;
			if (currentDay>=ParamHelper.INDEX_PAYMENT_DAY) {
				if (month==12) {
					month=1;
				}else{
					month = t.get(Calendar.MONTH)+2;
				}
			}
			
			this.sendMonth = month;
			
			for (Subsidy subsidy : subsidyList) {
				Date d = new Date();
				d = subsidy.getSendTime();
				SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MM");//可以方便地修改日期格式 
				int sendMonth = Integer.valueOf(dateFormatMonth.format(d));
				
				if (sendMonth>=month) {
					subsidyTotal += subsidy.getMoney();
				}
				if (sendMonth==month) {
					subsidyMonth += subsidy.getMoney();
				}
			}
    	
		}else{
			this.showSubsidy=false;
		}
	}

	private void intiShowAchievementCommission(){
		List<AchievementCommission> achievementCommissions = AchievementCommissionModel.getListByEmpNo(UserHelper.getUserCache().getEmpId());
			if (achievementCommissions!=null&&achievementCommissions.size()>0) {
				this.showAchievementCommission=true;
				this.commissionMonth = achievementCommissions.get(0).getMonth();
				this.commissionMoneyMonth = (int)achievementCommissions.get(0).getCommissionMoney();
			}else{
				this.showAchievementCommission=false;
			}
	}
	

}
