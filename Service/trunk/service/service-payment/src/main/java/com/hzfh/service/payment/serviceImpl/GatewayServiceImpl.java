package com.hzfh.service.payment.serviceImpl;

import com.hzfh.api.payment.model.PaymentGatewayRequest;
import com.hzfh.api.payment.model.common.PaymentData;
import com.hzfh.api.payment.model.common.constant.ServiceType;
import com.hzfh.api.payment.model.common.entity.CreditAssignment;
import com.hzfh.api.payment.model.common.entity.Repayment;
import com.hzfh.api.payment.model.common.entity.Tender;
import com.hzfh.api.payment.model.common.entity.Transfer;
import com.hzfh.api.payment.model.request.GatewayRequest;
import com.hzfh.api.payment.model.request.gateway.*;
import com.hzfh.api.payment.service.GatewayService;
import com.hzfh.service.payment.dao.PaymentGatewayRequestDao;
import com.hzfh.service.payment.serviceImpl.Helper.SignUtil;
import com.hzfh.service.payment.serviceImpl.Helper.UrlHelper;
import com.hzframework.helper.HttpHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service("gatewayService")
public class GatewayServiceImpl implements GatewayService {
	@Autowired
	private PaymentGatewayRequestDao paymentGatewayRequestDao;
	
	private int  addGateRequestData(String url,String xml,String sign){
		Map<String, String> params = new HashMap<String, String>();
		params.put("req", xml);
		params.put("sign", sign);
		String param = HttpHelper.getPostParams(params);
		
		PaymentGatewayRequest paymentGatewayRequest = new PaymentGatewayRequest();
		paymentGatewayRequest.setUrl(url);
		paymentGatewayRequest.setParam(param);
		return paymentGatewayRequestDao.add(paymentGatewayRequest);
	}
	
	@Override
	public PaymentData register(RegisterReq registerReq) {
		GatewayRequest<RegisterReq> gatewayRequest = new GatewayRequest<RegisterReq>();
		gatewayRequest.setReq(registerReq);
		
		String url = UrlHelper.bulidGatewayUrl(ServiceType.TO_REGISTER);
		//String url = PaymentPath.GATEWAY_PATH+ServiceType.TO_REGISTER;
		
		String xml = gatewayRequest.getReq();
		String sign = SignUtil.sign(xml);
		addGateRequestData(url,xml,sign);
		PaymentData paymentData= new PaymentData();
		paymentData.setXml(xml);
		paymentData.setSign(sign);
		paymentData.setUrl(url);
		return paymentData;
	}

	@Override
	public PaymentData recharge(RechargeReq rechargeReq) {
		GatewayRequest<RechargeReq> gatewayRequest = new GatewayRequest<RechargeReq>();
		
		int customerNo = Integer.parseInt(rechargeReq.getPlatformUserNo());
		double money = Double.parseDouble(rechargeReq.getAmount());
		/*PaymentAccountOperFacade.updateMoneyAmount(money, customerNo);
		PaymentAccountOperFacade.updateMoneyWithDarw(money, customerNo);*/
		
		
		gatewayRequest.setReq(rechargeReq);
		//String url = PaymentPath.GATEWAY_PATH+ServiceType.TO_RECHARGE;
		String url="";
		url = UrlHelper.bulidGatewayUrl(ServiceType.TO_RECHARGE);
		String xml = gatewayRequest.getReq();
		String sign = SignUtil.sign(xml);
		addGateRequestData(url,xml,sign);
		PaymentData paymentData= new PaymentData();
		paymentData.setXml(xml);
		paymentData.setSign(sign);
		paymentData.setUrl(url);
		
		return paymentData;
	}

	@Override
	public PaymentData withdraw(WithdrawReq withdrawReq) {
		GatewayRequest<WithdrawReq> gatewayRequest = new GatewayRequest<WithdrawReq>();
		
		int customerNo = Integer.parseInt(withdrawReq.getPlatformUserNo());
		double money = Double.parseDouble(withdrawReq.getAmount());
		/*PaymentAccountOperFacade.updateMoneyAmount(money, customerNo);
		PaymentAccountOperFacade.updateMoneyWithDarw(money, customerNo);*/
		
		gatewayRequest.setReq(withdrawReq);
		//String url = PaymentPath.GATEWAY_PATH+ServiceType.TO_WITHDRAW;
		String url = UrlHelper.bulidGatewayUrl(ServiceType.TO_WITHDRAW);
		String xml = gatewayRequest.getReq();
		String sign = SignUtil.sign(xml);
		addGateRequestData(url,xml,sign);
		PaymentData paymentData= new PaymentData();
		paymentData.setXml(xml);
		paymentData.setSign(sign);
		paymentData.setUrl(url);
		return paymentData;
		
	}

	@Override
	public PaymentData rindBankCard(BindBankCardReq bindBankCardReq) {
		GatewayRequest<BindBankCardReq> gatewayRequest = new GatewayRequest<BindBankCardReq>();
		gatewayRequest.setReq(bindBankCardReq);
		//
		//String url = PaymentPath.GATEWAY_PATH+ServiceType.TO_BIND_BANKCARD;
		String url = UrlHelper.bulidGatewayUrl(ServiceType.TO_BIND_BANKCARD);
		String xml = gatewayRequest.getReq();
		String sign = SignUtil.sign(xml);;
		addGateRequestData(url,xml,sign);
		PaymentData paymentData= new PaymentData();
		paymentData.setXml(xml);
		paymentData.setSign(sign);
		paymentData.setUrl(url);
		return paymentData;
		
	}

	@Override
	public PaymentData unbindBankCard(UnbindBankCardReq unbindBankCardReq) {
		GatewayRequest<UnbindBankCardReq> gatewayRequest = new GatewayRequest<UnbindBankCardReq>();
		gatewayRequest.setReq(unbindBankCardReq);
		//
		//String url = PaymentPath.GATEWAY_PATH+ServiceType.TO_UNBIND_BANKCARD;
		String url = UrlHelper.bulidGatewayUrl(ServiceType.TO_UNBIND_BANKCARD);
		String xml = gatewayRequest.getReq();
		String sign = SignUtil.sign(xml);
		addGateRequestData(url,xml,sign);
		PaymentData paymentData= new PaymentData();
		paymentData.setXml(xml);
		paymentData.setSign(sign);
		paymentData.setUrl(url);
		return paymentData;
		
	}

	@Override
	public PaymentData enterpriseRegister(EnterpriseRegisterReq enterpriseRegisterReq) {
		GatewayRequest<EnterpriseRegisterReq> gatewayRequest = new GatewayRequest<EnterpriseRegisterReq>();
		gatewayRequest.setReq(enterpriseRegisterReq);
		//
		//String url = PaymentPath.GATEWAY_PATH+ServiceType.TO_ENTERPRISE_REGISTER;
		String url = UrlHelper.bulidGatewayUrl(ServiceType.TO_ENTERPRISE_REGISTER);
		String xml = gatewayRequest.getReq();
		String sign = SignUtil.sign(xml);
		addGateRequestData(url,xml,sign);
		PaymentData paymentData= new PaymentData();
		paymentData.setXml(xml);
		paymentData.setSign(sign);
		paymentData.setUrl(url);
		return paymentData;
	}

	@Override
	public PaymentData authorizeAutoTransfer(AuthorizeAutoTransferReq authorizeAutoTransferReq) {
		GatewayRequest<AuthorizeAutoTransferReq> gatewayRequest = new GatewayRequest<AuthorizeAutoTransferReq>();
		gatewayRequest.setReq(authorizeAutoTransferReq);
		//
		//String url = PaymentPath.GATEWAY_PATH+ServiceType.TO_AUTHORIZE_AUTO_TRANSFER;
		String url = UrlHelper.bulidGatewayUrl(ServiceType.TO_AUTHORIZE_AUTO_TRANSFER);
		String xml = gatewayRequest.getReq();
		String sign = SignUtil.sign(xml);
		addGateRequestData(url,xml,sign);
		PaymentData paymentData= new PaymentData();
		paymentData.setXml(xml);
		paymentData.setSign(sign);
		paymentData.setUrl(url);
		return paymentData;
		
	}

	@Override
	public PaymentData authorizeAutoRepayment(AuthorizeAutoRepaymentReq authorizeAutoRepaymentReq) {
		GatewayRequest<AuthorizeAutoRepaymentReq> gatewayRequest = new GatewayRequest<AuthorizeAutoRepaymentReq>();
		gatewayRequest.setReq(authorizeAutoRepaymentReq);
		//
		//String url = PaymentPath.GATEWAY_PATH+ServiceType.TO_AUTHORIZE_AUTO_REPAYMENT;
		String url = UrlHelper.bulidGatewayUrl(ServiceType.TO_AUTHORIZE_AUTO_REPAYMENT);
		String xml = gatewayRequest.getReq();
		String sign = SignUtil.sign(xml);
		addGateRequestData(url,xml,sign);
		PaymentData paymentData= new PaymentData();
		paymentData.setXml(xml);
		paymentData.setSign(sign);
		paymentData.setUrl(url);
		return paymentData;
		
	}

	@Override
	public PaymentData resetPassword(ResetPasswordReq resetPasswordReq) {
		GatewayRequest<ResetPasswordReq> gatewayRequest = new GatewayRequest<ResetPasswordReq>();
		gatewayRequest.setReq(resetPasswordReq);
		//
		//String url = PaymentPath.GATEWAY_PATH+ServiceType.TO_RESET_PASSWORD;
		String url = UrlHelper.bulidGatewayUrl(ServiceType.TO_RESET_PASSWORD);
		String xml = gatewayRequest.getReq();
		String sign = SignUtil.sign(xml);
		addGateRequestData(url,xml,sign);
		PaymentData paymentData= new PaymentData();
		paymentData.setXml(xml);
		paymentData.setSign(sign);
		paymentData.setUrl(url);
		return paymentData;
	}

	@Override
	public PaymentData transfer(CpTransactionReq<Transfer> transferReq) {
		GatewayRequest<CpTransactionReq<Transfer>> gatewayRequest = new GatewayRequest<CpTransactionReq<Transfer>>();
		gatewayRequest.setReq(transferReq);
		//
		//String url = PaymentPath.GATEWAY_PATH+ServiceType.TO_CP_TRANSACTION;
		String url = UrlHelper.bulidGatewayUrl(ServiceType.TO_CP_TRANSACTION);
		String xml = gatewayRequest.getReq();
		String sign = SignUtil.sign(xml);
		addGateRequestData(url,xml,sign);
		PaymentData paymentData= new PaymentData();
		paymentData.setXml(xml);
		paymentData.setSign(sign);
		paymentData.setUrl(url);
		return paymentData;
	}

	@Override
	public PaymentData tender(CpTransactionReq<Tender> tenderReq) {
		GatewayRequest<CpTransactionReq<Tender>> gatewayRequest = new GatewayRequest<CpTransactionReq<Tender>>();
		gatewayRequest.setReq(tenderReq);
		//
		//String url = PaymentPath.GATEWAY_PATH+ServiceType.TO_CP_TRANSACTION;
		String url = UrlHelper.bulidGatewayUrl(ServiceType.TO_CP_TRANSACTION);
		String xml = gatewayRequest.getReq().replace("/>","></property>");
		String sign = SignUtil.sign(xml);
		addGateRequestData(url,xml,sign);
		PaymentData paymentData= new PaymentData();
		paymentData.setXml(xml);
		paymentData.setSign(sign);
		paymentData.setUrl(url);
		return paymentData;
	}

	@Override
	public PaymentData repayment(CpTransactionReq<Repayment> repaymentReq) {
		GatewayRequest<CpTransactionReq<Repayment>> gatewayRequest = new GatewayRequest<CpTransactionReq<Repayment>>();
		gatewayRequest.setReq(repaymentReq);
		//
		//String url = PaymentPath.GATEWAY_PATH+ServiceType.TO_CP_TRANSACTION;
		String url = UrlHelper.bulidGatewayUrl(ServiceType.TO_CP_TRANSACTION);
		String xml = gatewayRequest.getReq().replace("/>", "></property>");
		String sign = SignUtil.sign(xml);
		addGateRequestData(url,xml,sign);
		PaymentData paymentData= new PaymentData();
		paymentData.setXml(xml);
		paymentData.setSign(sign);
		paymentData.setUrl(url);
		return paymentData;
	}

	@Override
	public PaymentData creditAssignment(CpTransactionReq<CreditAssignment> creditAssignmentReq) {
		GatewayRequest<CpTransactionReq<CreditAssignment>> gatewayRequest = new GatewayRequest<CpTransactionReq<CreditAssignment>>();
		gatewayRequest.setReq(creditAssignmentReq);
		//
		//String url = PaymentPath.GATEWAY_PATH+ServiceType.TO_CP_TRANSACTION;
		String url =UrlHelper.bulidGatewayUrl(ServiceType.TO_CP_TRANSACTION);
		String xml = gatewayRequest.getReq().replace("/>","></property>");
		String sign = SignUtil.sign(xml);
		addGateRequestData(url,xml,sign);
		PaymentData paymentData= new PaymentData();
		paymentData.setXml(xml);
		paymentData.setSign(sign);
		paymentData.setUrl(url);
		return paymentData;
	}

	@Override
	public PaymentData resetMobile(ResetMobileReq resetMobileReq) {
		GatewayRequest<ResetMobileReq> gatewayRequest = new GatewayRequest<ResetMobileReq>();
		gatewayRequest.setReq(resetMobileReq);
		//String url = PaymentPath.GATEWAY_PATH+ServiceType.TO_RESET_PASSWORD;
		String url = UrlHelper.bulidGatewayUrl(ServiceType.TO_RESET_MOBILE);
		String xml = gatewayRequest.getReq();
		String sign = SignUtil.sign(xml);
		addGateRequestData(url,xml,sign);
		PaymentData paymentData= new PaymentData();
		paymentData.setXml(xml);
		paymentData.setSign(sign);
		paymentData.setUrl(url);
		return paymentData;
	}
}
