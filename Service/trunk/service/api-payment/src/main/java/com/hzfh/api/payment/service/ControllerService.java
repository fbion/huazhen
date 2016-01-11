package com.hzfh.api.payment.service;

import com.hzfh.api.payment.model.common.entity.CpTransactionRecord;
import com.hzfh.api.payment.model.common.entity.FreezereRecord;
import com.hzfh.api.payment.model.common.entity.RechargeRecord;
import com.hzfh.api.payment.model.common.entity.WithdrawRecord;
import com.hzfh.api.payment.model.request.controller.*;
import com.hzfh.api.payment.model.response.controller.*;

public interface ControllerService {
	/**
	 * 账户查询
	 * @param accountInfoReq
	 * @return AccountInfoResp 账户信息
	 */
	public AccountInfoResp getAccountInfo(AccountInfoReq accountInfoReq);
	/**
	 * 资金冻结
	 * @param freezeReq
	 * @return FreezeResp
	 */
	public FreezeResp getFreeze(FreezeReq freezeReq);
	/**
	 * 资金解冻
	 * @param unfreezeReq
	 * @return
	 */
	public UnfreezeResp getUnfreeze (UnfreezeReq unfreezeReq);
	/**
	 * 直接转账
	 * @param directTransactionReq
	 * @return
	 */
	public DirectTransactionResp getDirectTransaction(DirectTransactionReq directTransactionReq);
	/**
	 * 自动转账授权
	 * @param autoTransactionReq
	 * @return
	 */
	public AutoTransactionResp getAutoTransaction (AutoTransactionReq autoTransactionReq);
	/**
	 * 提现记录
	 * @param queryReq
	 * @return WithdrawRecordResp
	 */
	public QueryWithdrawRecordResp getWithdrawRecord (QueryReq queryReq);
	/**
	 * 充值记录
	 * @param queryReq
	 * @return RechargeRecordResp
	 */
	public QueryRechargeRecordResp getRechargeRecord (QueryReq queryReq);
	/**
	 * 转账记录
	 * @param queryReq
	 * @return CpTransactionRecordResp
	 */
	public QueryCpTransactionRecordResp getCpTransactionRecord (QueryReq queryReq);
	/**
	 * 冻结/解冻接口
	 * @param queryReq
	 * @return FreezereRecordResp
	 */
	public QueryFreezereRecordResp getFreezereRecord (QueryReq queryReq);
	
	/**
	 * 转账确认
	 * @param completeTransactionReq
	 * @return
	 */
	public CompleteTransactionResp getCompleteTransaction (CompleteTransactionReq completeTransactionReq);
	/**
	 * 取消自动投标授权
	 * @param cancelAuthorizeAutoTransferReq
	 * @return
	 */
	public CancelAuthorizeAutoTransferResp getCancelAuthorizeAutoTransfer (CancelAuthorizeAutoTransferReq cancelAuthorizeAutoTransferReq);
	/**
	 * 取消自动还款授权
	 * @param cancelAuthorizeAutoRepaymentRepaymentReq
	 * @return
	 */
	public CancelAuthorizeAutoRepaymentRepaymentResp getCancelAuthorizeAutoRepaymentRepayment(CancelAuthorizeAutoRepaymentRepaymentReq cancelAuthorizeAutoRepaymentRepaymentReq);
	/**
	 * 代扣充值
	 * @param whdebitnocardRechargeReq
	 * @return
	 */
	public WhdebitnocardRechargeResp getWhdebitnocardRecharge(WhdebitnocardRechargeReq whdebitnocardRechargeReq);
	/**
	 * 平台信息
	 * @param platformInfoReq
	 * @return
	 */
	public PlatformInfoResp getPlatformInfo(PlatformInfoReq platformInfoReq);
	/**
	 * 项目(标的)查询
	 * @param projectQueryReq
	 * @return
	 */
	public ProjectQueryResp getProjectQuery(ProjectQueryReq projectQueryReq);
}
