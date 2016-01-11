package com.hzfh.api.payment.service;

import com.hzfh.api.payment.model.common.PaymentData;
import com.hzfh.api.payment.model.common.entity.CreditAssignment;
import com.hzfh.api.payment.model.common.entity.Repayment;
import com.hzfh.api.payment.model.common.entity.Tender;
import com.hzfh.api.payment.model.common.entity.Transfer;
import com.hzfh.api.payment.model.request.gateway.*;

public interface GatewayService {
	/**
	 * 注册
	 * @param registerReq
	 * @return 
	 */
	public PaymentData register(RegisterReq registerReq);
	/**
	 * 充值
	 * @param rechargeReq
	 */
	public PaymentData recharge(RechargeReq rechargeReq);
	/**
	 * 提现
	 * @param withdrawReq
	 */
	public PaymentData withdraw(WithdrawReq withdrawReq);
	/**
	 * 绑定银行卡
	 * @param bindBankCardReq
	 */
	public PaymentData rindBankCard(BindBankCardReq bindBankCardReq);
	/**
	 * 取消绑卡
	 * @param unbindBankCardReq
	 */
	public PaymentData unbindBankCard(UnbindBankCardReq unbindBankCardReq);
	/**
	 * 企业用户注册
	 * @param enterpriseRegisterReq
	 */
	public PaymentData enterpriseRegister(EnterpriseRegisterReq enterpriseRegisterReq);
	
	//public void cpTransaction(CpTransactionReq<T> cpTransactionReq);
	
	/**
	 * 转账
	 * @param transferReq
	 */
	public PaymentData transfer(CpTransactionReq<Transfer> transferReq);
	/**
	 * 投标
	 * @param tenderReq
	 */
	public PaymentData tender (CpTransactionReq<Tender> tenderReq);
	/**
	 * 还款
	 * @param repaymentReq
	 */
	public PaymentData repayment (CpTransactionReq<Repayment> repaymentReq);
	/**
	 * 债权转让
	 * @param creditAssignmentReq
	 */
	public PaymentData creditAssignment (CpTransactionReq<CreditAssignment> creditAssignmentReq);
	/**
	 * 自动投标授权
	 * @param authorizeAutoTransferReq
	 */
	public PaymentData authorizeAutoTransfer(AuthorizeAutoTransferReq authorizeAutoTransferReq);
	/**
	 * 自动还款授权
	 * @param authorizeAutoRepaymentReq
	 */
	public PaymentData authorizeAutoRepayment(AuthorizeAutoRepaymentReq authorizeAutoRepaymentReq);
	/**
	 * 重置密码
	 * @param resetPasswordReq
	 */
	public PaymentData resetPassword(ResetPasswordReq resetPasswordReq);
	/**
	 * 重置手机号
	 * @param resetMobileReq
	 * @return
	 */
	public PaymentData resetMobile(ResetMobileReq resetMobileReq);
}
