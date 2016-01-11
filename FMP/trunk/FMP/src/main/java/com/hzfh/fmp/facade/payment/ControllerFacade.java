package com.hzfh.fmp.facade.payment;

import com.hzfh.api.payment.model.common.entity.CpTransactionRecord;
import com.hzfh.api.payment.model.common.entity.FreezereRecord;
import com.hzfh.api.payment.model.common.entity.RechargeRecord;
import com.hzfh.api.payment.model.common.entity.WithdrawRecord;
import com.hzfh.api.payment.model.request.controller.*;
import com.hzfh.api.payment.model.response.controller.*;
import com.hzfh.api.payment.service.ControllerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015/6/11.
 */
public class ControllerFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-payment.xml");

    public static FreezeResp getFreeze(FreezeReq freezeReq){
        ControllerService controllerService = (ControllerService) context.getBean("controllerService");
        return controllerService.getFreeze(freezeReq);
    }

	public static AccountInfoResp getAccountInfo(AccountInfoReq accountInfoReq) {
		 ControllerService controllerService = (ControllerService) context.getBean("controllerService");
	        return controllerService.getAccountInfo(accountInfoReq);
	}

	public static DirectTransactionResp getDirectTransaction(
			DirectTransactionReq directTransactionReq) {
		 ControllerService controllerService = (ControllerService) context.getBean("controllerService");
	        return controllerService.getDirectTransaction(directTransactionReq);
	}

	public static UnfreezeResp getUnfreeze(UnfreezeReq unfreezeReq) {
		 ControllerService controllerService = (ControllerService) context.getBean("controllerService");
	        return controllerService.getUnfreeze(unfreezeReq);
	}

	public static AutoTransactionResp getAutoTransaction(
			AutoTransactionReq autoTransactionReq) {
		 ControllerService controllerService = (ControllerService) context.getBean("controllerService");
	        return controllerService.getAutoTransaction(autoTransactionReq);
	}
	public static CancelAuthorizeAutoTransferResp getCancelAuthorizeAutoTransfer(CancelAuthorizeAutoTransferReq cancelAuthorizeAutoTransferReq) {
		ControllerService controllerService = (ControllerService) context.getBean("controllerService");
        return controllerService.getCancelAuthorizeAutoTransfer(cancelAuthorizeAutoTransferReq);
	}

	public static CancelAuthorizeAutoRepaymentRepaymentResp getCancelAuthorizeAutoRepaymentRepayment(CancelAuthorizeAutoRepaymentRepaymentReq cancelAuthorizeAutoRepaymentRepaymentReq) {
		ControllerService controllerService = (ControllerService) context.getBean("controllerService");
		return controllerService.getCancelAuthorizeAutoRepaymentRepayment(cancelAuthorizeAutoRepaymentRepaymentReq);
	}

	public static WhdebitnocardRechargeResp getWhdebitnocardRecharge(WhdebitnocardRechargeReq whdebitnocardRechargeReq) {
		ControllerService controllerService = (ControllerService) context.getBean("controllerService");
        return controllerService.getWhdebitnocardRecharge(whdebitnocardRechargeReq);
	}

	public static PlatformInfoResp getPlatformInfo(PlatformInfoReq platformInfoReq) {
		ControllerService controllerService = (ControllerService) context.getBean("controllerService");
        return controllerService.getPlatformInfo(platformInfoReq);
	}

	public static ProjectQueryResp getProjectQuery(ProjectQueryReq projectQueryReq) {
		 ControllerService controllerService = (ControllerService) context.getBean("controllerService");
	     return controllerService.getProjectQuery(projectQueryReq);
	}

	public static CompleteTransactionResp getCompleteTransaction(CompleteTransactionReq completeTransactionReq) {
		ControllerService controllerService = (ControllerService) context.getBean("controllerService");
        return controllerService.getCompleteTransaction(completeTransactionReq);
	}
}
