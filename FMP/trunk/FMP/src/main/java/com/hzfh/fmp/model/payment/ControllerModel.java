package com.hzfh.fmp.model.payment;

import com.hzfh.api.payment.model.common.entity.CpTransactionRecord;
import com.hzfh.api.payment.model.common.entity.FreezereRecord;
import com.hzfh.api.payment.model.common.entity.RechargeRecord;
import com.hzfh.api.payment.model.common.entity.WithdrawRecord;
import com.hzfh.api.payment.model.request.controller.*;
import com.hzfh.api.payment.model.response.controller.*;
import com.hzfh.fmp.facade.payment.ControllerFacade;

/**
 * Created by Administrator on 2015/6/11.
 */
public class ControllerModel {
	public static AccountInfoResp getAccountInfo(AccountInfoReq accountInfoReq){
		return ControllerFacade.getAccountInfo(accountInfoReq);
	};
    public static FreezeResp getFreeze(FreezeReq freezeReq){
        return ControllerFacade.getFreeze(freezeReq);
    }	
	public UnfreezeResp getUnfreeze (UnfreezeReq unfreezeReq){
		return ControllerFacade.getUnfreeze(unfreezeReq);
	};
	
	public static DirectTransactionResp getDirectTransaction(DirectTransactionReq directTransactionReq){
		return ControllerFacade.getDirectTransaction(directTransactionReq);
		
	};
	
	public static AutoTransactionResp getAutoTransaction (AutoTransactionReq autoTransactionReq){
		return ControllerFacade.getAutoTransaction(autoTransactionReq);
		
	};
	
	public static CompleteTransactionResp getCompleteTransaction (CompleteTransactionReq completeTransactionReq){
		return ControllerFacade.getCompleteTransaction(completeTransactionReq);
		
	};
	
	public static CancelAuthorizeAutoTransferResp getCancelAuthorizeAutoTransfer (CancelAuthorizeAutoTransferReq cancelAuthorizeAutoTransferReq){
		return ControllerFacade.getCancelAuthorizeAutoTransfer(cancelAuthorizeAutoTransferReq);
	};
	
	public static CancelAuthorizeAutoRepaymentRepaymentResp getCancelAuthorizeAutoRepaymentRepayment(CancelAuthorizeAutoRepaymentRepaymentReq cancelAuthorizeAutoRepaymentRepaymentReq){
		return ControllerFacade.getCancelAuthorizeAutoRepaymentRepayment(cancelAuthorizeAutoRepaymentRepaymentReq);
	};

	public static WhdebitnocardRechargeResp getWhdebitnocardRecharge(WhdebitnocardRechargeReq whdebitnocardRechargeReq){
		return ControllerFacade.getWhdebitnocardRecharge(whdebitnocardRechargeReq);
	};
	
	public static PlatformInfoResp getPlatformInfo(PlatformInfoReq platformInfoReq){
		return ControllerFacade.getPlatformInfo(platformInfoReq);
	};
	
	public static ProjectQueryResp getProjectQuery(ProjectQueryReq projectQueryReq){
		return ControllerFacade.getProjectQuery(projectQueryReq);
	};
  
}
