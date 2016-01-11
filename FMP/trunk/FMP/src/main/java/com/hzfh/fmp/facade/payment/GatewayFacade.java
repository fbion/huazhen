package com.hzfh.fmp.facade.payment;

import com.hzfh.api.payment.model.common.PaymentData;
import com.hzfh.api.payment.model.common.entity.CreditAssignment;
import com.hzfh.api.payment.model.common.entity.Repayment;
import com.hzfh.api.payment.model.common.entity.Tender;
import com.hzfh.api.payment.model.common.entity.Transfer;
import com.hzfh.api.payment.model.request.gateway.*;
import com.hzfh.api.payment.service.GatewayService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015/6/8.
 */
public class GatewayFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-payment.xml");

    public static PaymentData register(RegisterReq registerReq){
        GatewayService gatewayService = (GatewayService) context.getBean("gatewayService");
        return  gatewayService.register(registerReq);
    }

    public static PaymentData rindBankCard(BindBankCardReq bindBankCardReq){
        GatewayService gatewayService = (GatewayService) context.getBean("gatewayService");
        return gatewayService.rindBankCard(bindBankCardReq);
    }

    public static PaymentData unbindBankCardCallback(UnbindBankCardReq unbindBankCardReq){
        GatewayService gatewayService = (GatewayService) context.getBean("gatewayService");
        return  gatewayService.unbindBankCard (unbindBankCardReq);
    }

	public static PaymentData recharge(RechargeReq rechargeReq) {
		GatewayService gatewayService = (GatewayService) context.getBean("gatewayService");
		return gatewayService.recharge(rechargeReq);
	}

	public static PaymentData withdraw(WithdrawReq withdrawReq) {
		GatewayService gatewayService = (GatewayService) context.getBean("gatewayService");
	    return gatewayService.withdraw (withdrawReq);
	}

	public static PaymentData enterpriseRegister(
			EnterpriseRegisterReq enterpriseRegisterReq) {
		GatewayService gatewayService = (GatewayService) context.getBean("gatewayService");
	    return gatewayService.enterpriseRegister (enterpriseRegisterReq);
	}

	public static PaymentData transfer(CpTransactionReq<Transfer> transferReq) {
		GatewayService gatewayService = (GatewayService) context.getBean("gatewayService");
	    return gatewayService.transfer (transferReq);
	}

	public static PaymentData tender(CpTransactionReq<Tender> tenderReq) {
		GatewayService gatewayService = (GatewayService) context.getBean("gatewayService");
	    return gatewayService.tender (tenderReq);
	}

	public static PaymentData repayment(CpTransactionReq<Repayment> repaymentReq) {
		GatewayService gatewayService = (GatewayService) context.getBean("gatewayService");
	    return gatewayService.repayment (repaymentReq);
	}

	public static PaymentData creditAssignment(
			CpTransactionReq<CreditAssignment> creditAssignmentReq) {
		GatewayService gatewayService = (GatewayService) context.getBean("gatewayService");
	    return gatewayService.creditAssignment (creditAssignmentReq);
	}

	public static PaymentData resetPassword(ResetPasswordReq resetPasswordReq) {
		GatewayService gatewayService = (GatewayService) context.getBean("gatewayService");
	    return gatewayService.resetPassword (resetPasswordReq);
	}
}
