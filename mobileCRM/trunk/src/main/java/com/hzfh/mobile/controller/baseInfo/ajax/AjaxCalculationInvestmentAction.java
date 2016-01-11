package com.hzfh.mobile.controller.baseInfo.ajax;

import com.hzfh.mobile.controller.common.CommonAction;
import com.hzfh.mobile.model.common.properties.ParamHelper;
import com.hzframework.helper.MathHelper;

public class AjaxCalculationInvestmentAction extends CommonAction {
	private int n;//期限 deadline
	private double loanRates;//贷款利率 年 %
	private int finishedAutomobile;//车款 元
	private double downPayment;//首付比例 %
	private String errcode;
	
	public String getErrcode() {
		return errcode;
	}

	private double x;//投资额****
	
	public double getX() {
		return x;
	}
	public void setN(int n) {
		this.n = n;
	}
	public void setLoanRates(double loanRates) {
		this.loanRates = loanRates;
	}
	public void setFinishedAutomobile(int finishedAutomobile) {
		this.finishedAutomobile = finishedAutomobile;
	}
	public void setDownPayment(double downPayment) {
		this.downPayment = downPayment;
	}
	
	private double totalLoanInterest;//总贷款利息*****
	private double rente;//定期利息******
	private double profitRatex;//计算利润率
	 
	public double getProfitRatex() {
		return profitRatex;
	}
	public double getTotalLoanInterest() {
		return totalLoanInterest;
	}
	public double getRente() {
		return rente;
	}
	@Override
    public String execute(){
		downPayment = downPayment/100;//首付比例
		loanRates = loanRates/100;//贷款利率
		try {
			double ww = ParamHelper.AUTO_FINANCING_PLAN_COSTRATE;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double a=ParamHelper.AUTO_FINANCING_PLAN_COSTRATE/100;//不含人工的总成本率;costRate
		double rate = ParamHelper.AUTO_FINANCING_PLAN_RATE/100;//定期利率
		double profitRate = ParamHelper.AUTO_FINANCING_PLAN_PROFITRATE;//利润率
		double loanValue = finishedAutomobile*(1-downPayment);//贷款额  
		double k = ParamHelper.AUTO_FINANCING_PLAN_K;//1.46
		double y = ParamHelper.AUTO_FINANCING_PLAN_Y;//2
		
		double loanPIA = loanValue*(loanRates/12)* (Math.pow((1+loanRates/12),n))/((Math.pow((1+loanRates/12),n))-1)*n;//贷款本息和
		totalLoanInterest = loanPIA - loanValue;//总贷款利息
		
		x = (totalLoanInterest+loanValue)/((a-rate)*(n/12));//投资额
		
		rente = x*rate*n/12;//定期利息
		
		double mounthMoney = loanPIA/n;//月还款额
		double totalMoney = n*x-mounthMoney*n*(1+n)/2;//总可用资金
		double aveMoney =totalMoney/n;//月平均可用资金
		double costMoney = (a*x)+aveMoney*y/100*(n/12);//成本
		double totalRevenue = totalMoney*k/100;//总收益
		profitRatex = (totalRevenue-costMoney)/x/(n/12)*100;//利润率 计算得出
		
		x = MathHelper.round(x, 2);
		totalLoanInterest = MathHelper.round(totalLoanInterest, 2);
		rente = MathHelper.round(rente, 2);
		
		if(profitRatex<profitRate){
			errcode = "00";
			return SUCCESS;
		}
        return SUCCESS;
    }
}
