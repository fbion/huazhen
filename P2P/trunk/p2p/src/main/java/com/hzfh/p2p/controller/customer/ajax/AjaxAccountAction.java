package com.hzfh.p2p.controller.customer.ajax;

import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.payment.model.common.constant.StatusCode;
import com.hzfh.api.payment.model.request.controller.AccountInfoReq;
import com.hzfh.api.payment.model.response.controller.AccountInfoResp;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.common.AuthenticationModel;
import com.hzfh.p2p.model.common.parameter.StatusType;
import com.hzfh.p2p.model.common.state.StateValues;
import com.hzfh.p2p.model.customer.PaymentAccountInformationModel;
import com.hzfh.p2p.model.payment.ControllerModel;
import com.hzfh.p2p.model.payment.PaymentRefundModel;

public class AjaxAccountAction extends CommonAction {
	
	
	private double income;
	private double unIncome;
	private double balance;//账户余额
	private double availableAmount;//Y 可用余额
	private double freezeAmount;//Y 冻结金额
	public double getIncome() {
		return income;
	}
	public double getUnIncome() {
		return unIncome;
	}
	public double getBalance() {
		return balance;
	}
	public double getAvailableAmount() {
		return availableAmount;
	}
	public double getFreezeAmount() {
		return freezeAmount;
	}
	public String getInvestmentIncome(){
		int customerNo = AuthenticationModel.getCustomerId();
		byte status =StatusType.FINISHPAYMENT;
		Double income = PaymentRefundModel.getInvestmentIncome(customerNo,status);
		if(income!=null){
			this.income=income;
		}
		Double unIncome = PaymentRefundModel.getInvestIncomeingByCustomerNo(customerNo);
		if(unIncome!=null){
			this.unIncome=unIncome;
		}
		return SUCCESS;
	}
	/**
	 * 查询余额信息
	 * @return
	 */
	public String getBalanceInfo(){
		
		 PaymentAccountInformation info = PaymentAccountInformationModel.getInfoByCustomerNo(StateValues.getCustomerId());
	        AccountInfoReq accountInfoReq = new AccountInfoReq();
	        accountInfoReq.setPlatformUserNo(String.valueOf(info.getCustomerNo()));
	        accountInfoReq.setPlatformNo(accountInfoReq.getPlatformNo());
	        AccountInfoResp accountInfoResp = ControllerModel.getAccountInfo(accountInfoReq);
	        if(String.valueOf(StatusCode.SUCCESS).equals(accountInfoResp.getCode())){
	        	balance = accountInfoResp.getBalance();
	        	availableAmount = accountInfoResp.getAvailableAmount();
	        	freezeAmount = accountInfoResp.getFreezeAmount();
	        }
		return SUCCESS;
	}
}
