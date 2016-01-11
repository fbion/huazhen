package com.hzfh.p2p.controller.product;

import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.query.P2pProductCondition;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.baseInfo.DicDataModel;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.MoneyHelper;
import com.hzfh.p2p.model.common.helper.UrlHelper;
import com.hzfh.p2p.model.common.parameter.StatusType;
import com.hzfh.p2p.model.product.P2pProductModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.MathHelper;
import com.hzframework.helper.StringHelper;

public class P2pProductAction extends CommonAction {

	
	
	private int pageIndex=1;
	private PagedList<P2pProduct> Pagedp2pProductList;
	private int pageCount;
	private int totalCount;
	
	
	

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public PagedList<P2pProduct> getPagedp2pProductList() {
		return Pagedp2pProductList;
	}

	public void setPagedp2pProductList(PagedList<P2pProduct> pagedp2pProductList) {
		Pagedp2pProductList = pagedp2pProductList;
	}

	public int getPageIndex() {
		return pageIndex <= pageCount?pageIndex:pageCount;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	//参数
	private String byStatus;
	private String durationDown;
	private String durationUp;
	private String incomeDown;
	private String incomeUp;
	private String sortByIncome = "";
	private String sortByDuration = "";
	private String productType;//产品类型
	
	//url
	private String statusUrl;//状态Url
	private String durationUrl;//产品期限Url
	private String incomeUrl;//产品收益Url
	private String incomeSortUrl;//年化收益排序Url
	private String durationSortUrl;//项目期限排序Url
	private String pageUrl;//页码Url
	private String productTypeUrl;//产品类型Url
	private String mainUrl;//主url
	
	public String getByStatus() {
		return byStatus;
	}

	public void setByStatus(String byStatus) {
		this.byStatus = byStatus;
	}

	public void setDurationDown(String durationDown) {
		this.durationDown = durationDown;
	}

	public void setDurationUp(String durationUp) {
		this.durationUp = durationUp;
	}

	public void setIncomeDown(String incomeDown) {
		this.incomeDown = incomeDown;
	}

	public void setIncomeUp(String incomeUp) {
		this.incomeUp = incomeUp;
	}

	public String getDurationUp() {
		return durationUp;
	}

	public String getIncomeUp() {
		return incomeUp;
	}

	public void setSortByIncome(String sortByIncome) {
		this.sortByIncome = sortByIncome;
	}

	public void setSortByDuration(String sortByDuration) {
		this.sortByDuration = sortByDuration;
	}

	
	public String getStatusUrl() {
		return statusUrl;
	}

	public String getDurationUrl() {
		return durationUrl;
	}

	public String getIncomeUrl() {
		return incomeUrl;
	}

	public String getIncomeSortUrl() {
		return incomeSortUrl;
	}

	public String getDurationSortUrl() {
		return durationSortUrl;
	}

	public String getMainUrl() {
		return mainUrl;
	}

	public String getPageUrl() {
		return pageUrl;
	}
	public String getProductTypeUrl() {
		return productTypeUrl;
	}


	private String defaultSortUrl;
	private int sort;
	public String getDefaultSortUrl() {
		return defaultSortUrl;
	}

	public void setDefaultSortUrl(String defaultSortUrl) {
		this.defaultSortUrl = defaultSortUrl;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	private boolean sortByIncomeOn;
	private boolean sortByDurationOn;
	public boolean isSortByIncomeOn() {
		return sortByIncomeOn;
	}

	public void setSortByIncomeOn(boolean sortByIncomeOn) {
		this.sortByIncomeOn = sortByIncomeOn;
	}

	public boolean isSortByDurationOn() {
		return sortByDurationOn;
	}

	public void setSortByDurationOn(boolean sortByDurationOn) {
		this.sortByDurationOn = sortByDurationOn;
	}
	
	private List<DicData> productTypeDicDataList;//4 产品类型
	
	public List<DicData> getProductTypeDicDataList() {
		return productTypeDicDataList;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	
	public void addSortItem(List<SortItem> sortItemList,String feild,String type){
		SortItem sortItem = new SortItem();
		sortItem.setSortFeild(feild);
		if("desc".equals(type)){
			sortItem.setSortType(SortType.DESC);
		}else{
			sortItem.setSortType(SortType.ASC);
		}
		sortItemList.add(sortItem);
	}
	public P2pProductCondition getCondition(){
		P2pProductCondition p2pProductCondition = new P2pProductCondition();
		p2pProductCondition.setPageIndex(pageIndex);
		p2pProductCondition.setPageSize(5);
		//p2pProductCondition.setP2pCustomerNo(AuthenticationModel.getCustomerId());
		p2pProductCondition.getStartIndex();
		List<SortItem> sortItemList = new ArrayList<SortItem>();
		
		if(!StringHelper.isNullOrEmpty(this.sortByIncome)){
			/*SortItem sortItem2 = new SortItem();
			sortItem2.setSortFeild("income");
			SortItem sortItem4 = new SortItem();
			sortItem4.setSortFeild("floating_income");
			if("desc".equals(this.sortByIncome)){
				sortItem2.setSortType(SortType.DESC);
				sortItem4.setSortType(SortType.DESC);
			}else{
				sortItem2.setSortType(SortType.ASC);
				sortItem4.setSortType(SortType.ASC);
			}
			sortItemList.add(sortItem2);
			sortItemList.add(sortItem4);*/
			addSortItem(sortItemList,"income",this.sortByIncome);
			//addSortItem(sortItemList,"floating_income",this.sortByIncome);//浮动收益
		}
		if(!StringHelper.isNullOrEmpty(this.sortByDuration)){
			/*SortItem sortItem3 = new SortItem();
			sortItem3.setSortFeild("duration");
			if("desc".equals(this.sortByDuration)){
				sortItem3.setSortType(SortType.DESC);
			}else{
				sortItem3.setSortType(SortType.ASC);
			}
			sortItemList.add(sortItem3);*/
			addSortItem(sortItemList,"duration",this.sortByDuration);
		}
		
		/*SortItem sortItem1 = new SortItem();
		sortItem1.setSortFeild("id");
		sortItem1.setSortType(SortType.DESC);
		sortItemList.add(sortItem1);*/
		addSortItem(sortItemList, "level", "desc");
		addSortItem(sortItemList,"id","desc");
		
		if(!StringHelper.isNullOrEmpty(this.byStatus)){
			if("20".equals(this.byStatus)){
				p2pProductCondition.setStatus1(20);
				p2pProductCondition.setStatus2(30);
			}
			if("40".equals(this.byStatus)){
				p2pProductCondition.setStatus1(40);
				p2pProductCondition.setStatus2(40);
			}
			if("50".equals(this.byStatus)){
				p2pProductCondition.setStatus1(50);
				p2pProductCondition.setStatus2(50);
			}
		}
		if(!StringHelper.isNullOrEmpty(this.productType)){
			p2pProductCondition.setType(Byte.valueOf(this.productType));
		}
		
		if(!StringHelper.isNullOrEmpty(this.durationDown)&&!StringHelper.isNullOrEmpty(this.durationUp)){
			int durationD = Integer.valueOf(this.durationDown)*30;
			if(durationD==360) durationD+=6;
			int durationU = Integer.valueOf(this.durationUp)*30;
			if(durationU==360) durationU+=5;
			if(durationU==90) durationU-=1;
            p2pProductCondition.setDurationDown(durationD);
			p2pProductCondition.setDurationUp(durationU);
		}

		if(!StringHelper.isNullOrEmpty(this.incomeDown)&&!StringHelper.isNullOrEmpty(this.incomeUp)){
				p2pProductCondition.setIncomeDown(Integer.valueOf(this.incomeDown));
				p2pProductCondition.setIncomeUp(Integer.valueOf(this.incomeUp));
		}
		
		p2pProductCondition.setSortItemList(sortItemList);
		
		return p2pProductCondition;
	}
    @Override
    public String execute() {
        this.setPageAlias(PageAlias.p2pProductList);
        String ret = super.execute();
		if (!ret.equals(SUCCESS))
			return ret;
		
		productTypeDicDataList = DicDataModel.getDicDataListByType(StatusType.PRODUCTTYPE);
		
		this.Pagedp2pProductList = P2pProductModel.getPagingList(this.getCondition());
		totalCount = Pagedp2pProductList.getPagingInfo().getTotalCount();
		pageCount = Pagedp2pProductList.getPagingInfo().getPageCount();
		
		if(Pagedp2pProductList.getResultList().size()>0&&Pagedp2pProductList!=null){
        	for (P2pProduct p2pProduct : Pagedp2pProductList.getResultList()) {
        		p2pProduct.setSwitchTotalAmout(MoneyHelper.getMoney(p2pProduct.getTotalAmout()));
        		p2pProduct.setSwitchRemainAmout(MoneyHelper.getMoney(p2pProduct.getRemainAmout()));
        		p2pProduct.setLogoPath(UrlHelper.bulidBannerImg(p2pProduct.getLogoPath()));
        		
        		double salesMoney = p2pProduct.getTotalAmout()-p2pProduct.getRemainAmout();
                double progress = MathHelper.divide(salesMoney,p2pProduct.getTotalAmout(),2)*100;
                p2pProduct.setProgress(progress);
        		}
        }
		this.mainUrl = UrlHelper.buildWWWSiteUrl(PageAlias.p2pProductList)+"?1=1";
		
		
		this.statusUrl = this.urlMake("statusUrl");
		this.durationUrl = this.urlMake("durationUrl");
		this.incomeUrl = this.urlMake("incomeUrl");
		this.incomeSortUrl = this.urlMake("incomeSortUrl");
		this.durationSortUrl = this.urlMake("durationSortUrl");
		this.pageUrl = this.urlMake("pageUrl");
		this.defaultSortUrl = this.urlMake("defaultSortUrl");
		this.productTypeUrl = this.urlMake("productTypeUrl");
		
		
		return SUCCESS;
    }
    
    public String urlMake(String str){
    	String url = mainUrl;
    	switch (str) {
			case "statusUrl":
				if(durationDown!=null) url+="&durationDown="+durationDown;
				if(durationUp!=null) url+="&durationUp="+durationUp;
				if(incomeDown!=null) url+="&incomeDown="+incomeDown;
				if(incomeUp!=null) url+="&incomeUp="+incomeUp;
				if(sortByIncome!=null) url+="&sortByIncome="+sortByIncome;
				if(sortByDuration!=null) url+="&sortByDuration="+sortByDuration;
				if(productType!=null) url+="&productType="+productType;
				url+="&sortByIncomeOn="+sortByIncomeOn;
				url+="&sortByDurationOn="+sortByDurationOn;
				////if(pageIndex!=0) url+="&pageIndex="+pageIndex;
				url+="&sort="+sort;
				
				break;
			case "durationUrl":
				if(byStatus!=null) url+="&byStatus="+byStatus;
				if(incomeDown!=null) url+="&incomeDown="+incomeDown;
				if(incomeUp!=null) url+="&incomeUp="+incomeUp;
				if(!StringHelper.isNullOrEmpty(sortByIncome)) url+="&sortByIncome="+sortByIncome;
				if(!StringHelper.isNullOrEmpty(sortByDuration)) url+="&sortByDuration="+sortByDuration;
				if(productType!=null) url+="&productType="+productType;
				url+="&sortByIncomeOn="+sortByIncomeOn;
				url+="&sortByDurationOn="+sortByDurationOn;
				//if(pageIndex!=0) url+="&pageIndex="+pageIndex;
				url+="&sort="+sort;
				
				break;
			case "incomeUrl":
				if(byStatus!=null) url+="&byStatus="+byStatus;
				if(durationDown!=null) url+="&durationDown="+durationDown;
				if(durationUp!=null) url+="&durationUp="+durationUp;
				if(!StringHelper.isNullOrEmpty(sortByIncome)) url+="&sortByIncome="+sortByIncome;
				if(!StringHelper.isNullOrEmpty(sortByDuration)) url+="&sortByDuration="+sortByDuration;
				if(productType!=null) url+="&productType="+productType;
				url+="&sortByIncomeOn="+sortByIncomeOn;
				url+="&sortByDurationOn="+sortByDurationOn;
				//if(pageIndex!=0) url+="&pageIndex="+pageIndex;
				url+="&sort="+sort;
				break;
			case "incomeSortUrl":
				if(byStatus!=null) url+="&byStatus="+byStatus;
				if(durationDown!=null) url+="&durationDown="+durationDown;
				if(durationUp!=null) url+="&durationUp="+durationUp;
				if(incomeDown!=null) url+="&incomeDown="+incomeDown;
				if(incomeUp!=null) url+="&incomeUp="+incomeUp;
				if("desc".equals(sortByIncome)) url+="&sortByIncome="+"asc";
				if("asc".equals(sortByIncome)||"".equals(sortByIncome)) url+="&sortByIncome="+"desc";
				if(sortByIncomeOn) url+="&sortByIncomeOn="+false;
				if(!sortByIncomeOn) url+="&sortByIncomeOn="+true;
				if(productType!=null) url+="&productType="+productType;
				//if(sortByDuration!=null) url+="&sortByDuration="+sortByDuration;
				//if(pageIndex!=0) url+="&pageIndex="+pageIndex;
				break;
			case "durationSortUrl":
				if(byStatus!=null) url+="&byStatus="+byStatus;
				if(durationDown!=null) url+="&durationDown="+durationDown;
				if(durationUp!=null) url+="&durationUp="+durationUp;
				if(incomeDown!=null) url+="&incomeDown="+incomeDown;
				if(incomeUp!=null) url+="&incomeUp="+incomeUp;
				//if(sortByIncome!=null) url+="&sortByIncome="+sortByIncome;
				if("desc".equals(sortByDuration)) url+="&sortByDuration="+"asc";
				if("asc".equals(sortByDuration)||"".equals(sortByDuration)) url+="&sortByDuration="+"desc";
				if(sortByDurationOn) url+="&sortByDurationOn="+false;
				if(!sortByDurationOn) url+="&sortByDurationOn="+true;
				if(productType!=null) url+="&productType="+productType;
				//if(pageIndex!=0) url+="&pageIndex="+pageIndex;
				break;
			case "defaultSortUrl":
				if(byStatus!=null) url+="&byStatus="+byStatus;
				if(durationDown!=null) url+="&durationDown="+durationDown;
				if(durationUp!=null) url+="&durationUp="+durationUp;
				if(incomeDown!=null) url+="&incomeDown="+incomeDown;
				if(incomeUp!=null) url+="&incomeUp="+incomeUp;
				if(productType!=null) url+="&productType="+productType;
				//if(sortByIncome!=null) url+="&sortByIncome="+sortByIncome;
				//if(pageIndex!=0) url+="&pageIndex="+pageIndex;
				break;
			case "pageUrl":
				if(byStatus!=null) url+="&byStatus="+byStatus;
				if(durationDown!=null) url+="&durationDown="+durationDown;
				if(durationUp!=null) url+="&durationUp="+durationUp;
				if(incomeDown!=null) url+="&incomeDown="+incomeDown;
				if(incomeUp!=null) url+="&incomeUp="+incomeUp;
				if(!StringHelper.isNullOrEmpty(sortByIncome)) url+="&sortByIncome="+sortByIncome;
				if(!StringHelper.isNullOrEmpty(sortByDuration)) url+="&sortByDuration="+sortByDuration;
				url+="&sortByIncomeOn="+sortByIncomeOn;
				url+="&sortByDurationOn="+sortByDurationOn;
				url+="&sort="+sort;
				if(productType!=null) url+="&productType="+productType;
				break;
			case "productTypeUrl":
				if(byStatus!=null) url+="&byStatus="+byStatus;
				if(durationDown!=null) url+="&durationDown="+durationDown;
				if(durationUp!=null) url+="&durationUp="+durationUp;
				if(incomeDown!=null) url+="&incomeDown="+incomeDown;
				if(incomeUp!=null) url+="&incomeUp="+incomeUp;
				if(!StringHelper.isNullOrEmpty(sortByIncome)) url+="&sortByIncome="+sortByIncome;
				if(!StringHelper.isNullOrEmpty(sortByDuration)) url+="&sortByDuration="+sortByDuration;
				url+="&sortByIncomeOn="+sortByIncomeOn;
				url+="&sortByDurationOn="+sortByDurationOn;
				////if(pageIndex!=0) url+="&pageIndex="+pageIndex;
				url+="&sort="+sort;
				break;
			default:
				break;
		}
    	return url;
    }
}
