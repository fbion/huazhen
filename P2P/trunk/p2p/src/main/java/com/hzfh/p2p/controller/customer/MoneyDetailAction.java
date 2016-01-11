package com.hzfh.p2p.controller.customer;

import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.payment.model.common.constant.StatusCode;
import com.hzfh.api.payment.model.request.controller.AccountInfoReq;
import com.hzfh.api.payment.model.response.controller.AccountInfoResp;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.controller.payment.notify.BindBankCardNotifyAction;
import com.hzfh.p2p.model.common.PageAlias;
import com.hzfh.p2p.model.common.helper.LogHelper;
import com.hzfh.p2p.model.common.parameter.PaymentType;
import com.hzfh.p2p.model.common.parameter.StatusType;
import com.hzfh.p2p.model.common.state.StateValues;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzfh.p2p.model.customer.PaymentMoneyRechargeModel;
import com.hzfh.p2p.model.payment.ControllerModel;
import com.hzfh.p2p.model.payment.PaymentRefundModel;
import com.hzfh.p2p.model.sales.SalesModel;
import com.hzframework.helper.MathHelper;

/**
 * Created by paul on 15-2-5.
 */
public class MoneyDetailAction extends CommonAction{
	public static final LogHelper logger = LogHelper.getLogger(MoneyDetailAction.class.getName());
	private double withdrawMoney;//可提现余额
	private PaymentAccountInformation paymentAccountInformation;//总额  冻结金额  可用余额  
	private double income; //累计收益
	private double unIncome;//即将受益
	private long principal;//待收本金   待还款，待审核
	private double balance;//账户余额
	private double availableAmount;//Y 可用余额
	private double freezeAmount;//Y 冻结金额
	
	public double getWithdrawMoney() {
		return withdrawMoney;
	}
	public PaymentAccountInformation getPaymentAccountInformation() {
		return paymentAccountInformation;
	}
	public double getIncome() {
		return income;
	}
	public double getUnIncome() {
		return unIncome;
	}
	public long getPrincipal() {
		return principal;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAvailableAmount() {
		return availableAmount;
	}
	public void setAvailableAmount(double availableAmount) {
		this.availableAmount = availableAmount;
	}
	public double getFreezeAmount() {
		return freezeAmount;
	}
	public void setFreezeAmount(double freezeAmount) {
		this.freezeAmount = freezeAmount;
	}
	@Override
	public String execute(){
        this.setPageAlias(PageAlias.moneyDetail);
        String ret = super.execute();
        if (!ret.equals(SUCCESS))
            return ret;

        int customerNo = StateValues.getCustomerId();
      //paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(customerNo);
        paymentAccountInformation = PaymentAccountInformationModel.getInfoByCustomerNo(StateValues.getCustomerId());
        AccountInfoReq accountInfoReq = new AccountInfoReq();
        accountInfoReq.setPlatformUserNo(String.valueOf(paymentAccountInformation.getCustomerNo()));
        accountInfoReq.setPlatformNo(accountInfoReq.getPlatformNo());
        AccountInfoResp accountInfoResp=new AccountInfoResp();
		try {
			accountInfoResp = ControllerModel.getAccountInfo(accountInfoReq);
		} catch (Exception e) {
			logger.error("账户查询，易宝服务连接异常", e);
		}
        if(String.valueOf(StatusCode.SUCCESS).equals(accountInfoResp.getCode())){
        	balance = accountInfoResp.getBalance();
        	availableAmount = accountInfoResp.getAvailableAmount();
        	freezeAmount = accountInfoResp.getFreezeAmount();
        	if(paymentAccountInformation!=null){
        		double availableBalance = availableAmount;//总额-冻结
        		//double rechargeMoney = PaymentMoneyRechargeModel.getRechargeMoneyByCustomerNoAndStatusAndToday(customerNo,PaymentType.RECHARGE_SUCCESS);
        		withdrawMoney = MathHelper.divide(availableBalance,1,2);
        	}
        }
       
        byte status =StatusType.FINISHPAYMENT;
        Double di = PaymentRefundModel.getInvestmentIncome(customerNo,status);
        Double du = PaymentRefundModel.getInvestIncomeingByCustomerNo(customerNo);
        if(di!=null)
        	income = di;
        if(du!=null) 
        	unIncome = du;
		status = StatusType.AUTHENTICATIONOK;
		Long principalMoney = SalesModel.getWillHavingPrincipal(customerNo,status);
		if(principalMoney!=null){
			principal = principalMoney;
		}
        return SUCCESS;
	}
}
