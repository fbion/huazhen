package com.hzfh.p2p.facade.payment;

import com.hzfh.api.payment.model.common.entity.CpTransactionRecord;
import com.hzfh.api.payment.model.common.entity.FreezereRecord;
import com.hzfh.api.payment.model.common.entity.RechargeRecord;
import com.hzfh.api.payment.model.common.entity.WithdrawRecord;
import com.hzfh.api.payment.model.request.controller.AccountInfoReq;
import com.hzfh.api.payment.model.request.controller.AutoTransactionReq;
import com.hzfh.api.payment.model.request.controller.CancelAuthorizeAutoRepaymentRepaymentReq;
import com.hzfh.api.payment.model.request.controller.CancelAuthorizeAutoTransferReq;
import com.hzfh.api.payment.model.request.controller.CompleteTransactionReq;
import com.hzfh.api.payment.model.request.controller.DirectTransactionReq;
import com.hzfh.api.payment.model.request.controller.FreezeReq;
import com.hzfh.api.payment.model.request.controller.PlatformInfoReq;
import com.hzfh.api.payment.model.request.controller.ProjectQueryReq;
import com.hzfh.api.payment.model.request.controller.QueryReq;
import com.hzfh.api.payment.model.request.controller.UnfreezeReq;
import com.hzfh.api.payment.model.request.controller.WhdebitnocardRechargeReq;
import com.hzfh.api.payment.model.response.controller.AccountInfoResp;
import com.hzfh.api.payment.model.response.controller.AutoTransactionResp;
import com.hzfh.api.payment.model.response.controller.CancelAuthorizeAutoRepaymentRepaymentResp;
import com.hzfh.api.payment.model.response.controller.CancelAuthorizeAutoTransferResp;
import com.hzfh.api.payment.model.response.controller.CompleteTransactionResp;
import com.hzfh.api.payment.model.response.controller.DirectTransactionResp;
import com.hzfh.api.payment.model.response.controller.FreezeResp;
import com.hzfh.api.payment.model.response.controller.PlatformInfoResp;
import com.hzfh.api.payment.model.response.controller.ProjectQueryResp;
import com.hzfh.api.payment.model.response.controller.QueryResp;
import com.hzfh.api.payment.model.response.controller.UnfreezeResp;
import com.hzfh.api.payment.model.response.controller.WhdebitnocardRechargeResp;
import com.hzfh.api.payment.service.ControllerService;
import com.hzfh.api.payment.service.SignService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015/6/11.
 */
public class SignFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-payment.xml");

	public static boolean verifySign(String verifyXml, String sign) {
		SignService signService = (SignService) context.getBean("signService");
	    return signService.verifySign(verifyXml,sign);
	}
}
