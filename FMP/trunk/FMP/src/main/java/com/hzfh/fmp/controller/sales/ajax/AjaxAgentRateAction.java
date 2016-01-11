package com.hzfh.fmp.controller.sales.ajax;

import com.hzfh.api.customer.model.AgentAdviser;
import com.hzfh.api.customer.model.AgentBusiness;
import com.hzfh.api.sales.model.AgentRate;
import com.hzfh.api.sales.model.query.AgentRateCondition;
import com.hzfh.fmp.controller.common.JqGridBaseAction;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.properties.RoleHelper;
import com.hzfh.fmp.model.customer.AgentAdviserModel;
import com.hzfh.fmp.model.customer.AgentBusinessModel;
import com.hzfh.fmp.model.sales.AgentRateModel;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.helper.StringHelper;

import java.util.ArrayList;
import java.util.List;


public class AjaxAgentRateAction extends JqGridBaseAction<AgentRate> {
    
	private String productType;
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	private String productNo;
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	private String agentType;
	public String getAgentType() {
		return agentType;
	}
	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}
	private String agentNo;
	public String getAgentNo() {
		return agentNo;
	}
	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}
	private String lowerLimit;
	public String getLowerLimit() {
		return lowerLimit;
	}
	public void setLowerLimit(String lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	private String upperLimit;
	public String getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(String upperLimit) {
		this.upperLimit = upperLimit;
	}
	private String rate;
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	//sales's money from ajaxGetAgentRate
	private String money;
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	
	//search
	private String byProductType;
	private String byProduct;
	private String byAgentType;
	private String byAgent;
    public String getByProductType() {
		return byProductType;
	}
	public void setByProductType(String byProductType) {
		this.byProductType = byProductType;
	}
	public String getByProduct() {
		return byProduct;
	}
	public void setByProduct(String byProduct) {
		this.byProduct = byProduct;
	}
	public String getByAgentType() {
		return byAgentType;
	}
	public void setByAgentType(String byAgentType) {
		this.byAgentType = byAgentType;
	}
	public String getByAgent() {
		return byAgent;
	}
	public void setByAgent(String byAgent) {
		this.byAgent = byAgent;
	}
	
	@Override
    public String execute() throws Exception{
    	AgentRateCondition agentRateCondition = new AgentRateCondition();
        agentRateCondition.setPageSize(this.getPageSize());
        agentRateCondition.setPageIndex(this.getPageIndex());
        if (StringHelper.isNullOrEmpty(this.byProductType)) {
			agentRateCondition.setProductType(0);
		}else{
			agentRateCondition.setProductType(Integer.parseInt(this.byProductType));
		}
        if (StringHelper.isNullOrEmpty(this.byProduct)) {
			agentRateCondition.setProduct(0);
		}else{
			agentRateCondition.setProduct(Integer.parseInt(this.byProduct));
		}
        if (StringHelper.isNullOrEmpty(this.byAgentType)) {
			agentRateCondition.setAgentType(0);
		}else{
			agentRateCondition.setAgentType(Integer.parseInt(this.byAgentType));
		}
        if (StringHelper.isNullOrEmpty(this.byAgent)) {
			agentRateCondition.setAgent(0);
		}else{
			agentRateCondition.setAgent(Integer.parseInt(this.byAgent));
		}
        
        
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild(this.getSidx());
        sortItem.setSortType(this.getSortType());
        sortItemList.add(sortItem);
        agentRateCondition.setSortItemList(sortItemList);

        PagedList<AgentRate> agentRatePagedList= AgentRateModel.getPagingList(agentRateCondition);
        this.setResultList(agentRatePagedList.getResultList());
        this.setPageCount(agentRatePagedList.getPagingInfo().getPageCount());
        this.setPageIndex(agentRatePagedList.getPagingInfo().getPageIndex());
        this.setRecordCount(agentRatePagedList.getPagingInfo().getTotalCount());
        return SUCCESS;
    }

    public String edit(){
        if(this.getOper().equalsIgnoreCase("del")){
            if(StringHelper.isNullOrEmpty(this.getId())){
                this.setErrDesc("NoID");
                this.setErrCode("NoID");
            }
            else{
                AgentRateModel.delete(Integer.parseInt(this.getId()));
            }
            return SUCCESS;
        }
        AgentRate agentRate = new AgentRate();
        
        //agentRate.setProductType(Byte.valueOf(this.productType));
		agentRate.setProductNo(Integer.valueOf(this.productNo));
		agentRate.setAgentType(Byte.valueOf(this.agentType));
        agentRate.setAgentNo(Integer.valueOf(this.agentNo));
		agentRate.setLowerLimit(Long.valueOf(this.lowerLimit));
        if(StringHelper.isNullOrEmpty(this.upperLimit))
            agentRate.setUpperLimit(100000);
        else
            agentRate.setUpperLimit(Long.valueOf(this.upperLimit));
        agentRate.setRate(Double.valueOf(this.rate));
        if (StringHelper.isNullOrEmpty(this.getEditComment()))
		    agentRate.setEditComment(this.getEditComment());
		agentRate.setEditUserNo(UserHelper.getEditUserNo());

        if (this.getOper().equalsIgnoreCase("add")|| this.getId().startsWith("jqg")) {
            agentRate.setInUserNo(UserHelper.getEditUserNo());
            int result = AgentRateModel.add(agentRate);
            if (result <= 0) {
                this.setErrCode("add failed");
                this.setErrDesc("add failed");
            }
        }
        else
        {
            if (this.getId().isEmpty()) {
                this.setErrCode("NoID");
                this.setErrDesc("NoID");
            }
            else{
                if (this.getOper().equalsIgnoreCase("edit")) {
                    agentRate.setId(Integer.parseInt(this.getId()));
                    if (AgentRateModel.update(agentRate) <= 0){
                        this.setErrCode("update failed");
                        this.setErrDesc("update failed");
                    }
                }
            }
        }

        return SUCCESS;
    }
    
    public String getAgentRate(){
    	//Get agentRate from Table(agent_rate) by product and agent
		AgentRate agentRate = new AgentRate();
		agentRate.setProductNo(Integer.valueOf(this.productNo));
		agentRate.setAgentType(Byte.valueOf(this.agentType));
		agentRate.setAgentNo(Integer.valueOf(this.agentNo));
		AgentRate rate=AgentRateModel.getAgentRate(agentRate,Long.parseLong(this.money));
		if(rate == null){
            agentRate.setAgentNo(0);
            AgentRate rateAll = AgentRateModel.getAgentRate(agentRate,Long.parseLong(this.money));
            if(rateAll!=null)
            this.setRate(String.valueOf(rateAll.getRate()));
		}else{
			this.setRate(String.valueOf(rate.getRate()));
		}
    	return SUCCESS;
    }
    
    public String getListByProductNo(){
    	if(StringHelper.isNullOrEmpty(this.productNo)){
    		this.setErrCode("NoID");
    		this.setErrDesc("NoID");
    	}
    	else{
            AgentRateCondition agentRateCondition = new AgentRateCondition();
            agentRateCondition.setProduct(Integer.parseInt(this.productNo));
            if(UserHelper.getUserCache().getRoleId() == RoleHelper.ROLE_PRODUCT_DIRECTOR || UserHelper.getUserCache().getRoleId() == RoleHelper.ROLE_PRODUCT){
                this.setResultList(AgentRateModel.getAgentRateListByCondition(agentRateCondition));
            }
            else {
                List<Integer> workmate = UserHelper.getUserCache().getWorkMate();
                List<Integer> myAgentAdviserRate = new ArrayList<Integer>();
                List<Integer> myAgentBusinessRate = new ArrayList<Integer>();
                myAgentAdviserRate.add(0);
                myAgentBusinessRate.add(0);
                String workmateString = null;
                if(workmate != null){
                    workmate.add(UserHelper.getUserCache().getUserId());
                    workmateString = StringHelper.listToString(workmate);
                }
                else
                    workmateString = String.valueOf(UserHelper.getUserCache().getUserId());
                //得到当前用户的所有销售商
                for(AgentAdviser agentAdviser:AgentAdviserModel.getMyAgentAdviser(workmateString)){
                    myAgentAdviserRate.add(agentAdviser.getId());
                }
                agentRateCondition.setAgentType(2);
                agentRateCondition.setAgentAllString(StringHelper.listToString(myAgentAdviserRate));
                List<AgentRate> agentRateList = new ArrayList<AgentRate>();
                agentRateList = AgentRateModel.getAgentRateListByCondition(agentRateCondition);
                for (AgentBusiness agentBusiness : AgentBusinessModel.getMyAgentBusiness(workmateString)) {
                    myAgentBusinessRate.add(agentBusiness.getId());
                }
                agentRateCondition.setAgentType(1);
                agentRateCondition.setAgentAllString(StringHelper.listToString(myAgentBusinessRate));
                for(AgentRate agentRate : AgentRateModel.getAgentRateListByCondition(agentRateCondition)){
                    agentRateList.add(agentRate);
                }
                agentRateCondition.setAgentType(3);
                agentRateCondition.setAgentAllString(null);
                for (AgentRate agentRate : AgentRateModel.getAgentRateListByCondition(agentRateCondition)) {
                    agentRateList.add(agentRate);
                }
                this.setResultList(agentRateList);
            }
    	}
    	return SUCCESS;
    }

}
