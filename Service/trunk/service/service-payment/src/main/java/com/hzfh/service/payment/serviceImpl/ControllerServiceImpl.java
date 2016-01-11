package com.hzfh.service.payment.serviceImpl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzfh.api.payment.model.PaymentConnectionRequest;
import com.hzfh.api.payment.model.common.constant.ServiceType;
import com.hzfh.api.payment.model.request.ControllerRequest;
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
import com.hzfh.api.payment.model.response.controller.QueryCpTransactionRecordResp;
import com.hzfh.api.payment.model.response.controller.QueryFreezereRecordResp;
import com.hzfh.api.payment.model.response.controller.QueryRechargeRecordResp;
import com.hzfh.api.payment.model.response.controller.QueryWithdrawRecordResp;
import com.hzfh.api.payment.model.response.controller.UnfreezeResp;
import com.hzfh.api.payment.model.response.controller.WhdebitnocardRechargeResp;
import com.hzfh.api.payment.service.ControllerService;
import com.hzfh.service.payment.dao.PaymentConnectionRequestDao;
import com.hzfh.service.payment.serviceImpl.Helper.SignUtil;
import com.hzfh.service.payment.serviceImpl.Helper.UrlHelper;
import com.hzframework.helper.HttpHelper;
import com.hzframework.xml.XStreamHandler;
@Service("controllerService")
public class ControllerServiceImpl implements ControllerService {

	@Autowired
	private PaymentConnectionRequestDao paymentConnectionRequestDao; 
	private int  addConnectionRequestData(String url,String param,String service){
		PaymentConnectionRequest paymentConnectionRequest= new PaymentConnectionRequest();
		paymentConnectionRequest.setUrl(url);
		paymentConnectionRequest.setParam(param);
		paymentConnectionRequest.setService(service);
		return paymentConnectionRequestDao.add(paymentConnectionRequest);
	}
	@Override
	public AccountInfoResp getAccountInfo(AccountInfoReq accountInfoReq) {
		AccountInfoResp accountInfoResp = new AccountInfoResp();
		ControllerRequest<AccountInfoReq> controllerRequest = new ControllerRequest<AccountInfoReq>();
		controllerRequest.setReq(accountInfoReq);
		String xml = controllerRequest.getReq();
		String sign = SignUtil.sign(xml);
		Map<String, String> params = new HashMap<String, String>();		
		try {
			params.put("req",  URLEncoder.encode(xml, "utf-8"));
			params.put("sign",URLEncoder.encode(sign, "utf-8"));
			params.put("service", URLEncoder.encode(ServiceType.ACCOUNT_INFO, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String param = HttpHelper.getPostParams(params);
		//String url = PaymentPath.CONNECTIOIN_PATH;
		String url = UrlHelper.bulidConnectionUrl();
		//保存请求数据到payment数据库
		addConnectionRequestData(url,param,ServiceType.ACCOUNT_INFO);
		
		
		try {
			String xmlStr = HttpHelper.doPost(url, param);
			accountInfoResp = XStreamHandler.toBean(xmlStr, AccountInfoResp.class);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return accountInfoResp;
	}

	@Override
	public FreezeResp getFreeze(FreezeReq freezeReq) {
		FreezeResp freezeResp = new FreezeResp();
		ControllerRequest<FreezeReq> controllerRequest = new ControllerRequest<FreezeReq>();
		controllerRequest.setReq(freezeReq);
		String xml = controllerRequest.getReq();
		String sign = SignUtil.sign(controllerRequest.getReq());
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("req", URLEncoder.encode(xml, "utf-8"));
			params.put("sign",URLEncoder.encode(sign, "utf-8"));
			params.put("service",URLEncoder.encode(ServiceType.FREEZE, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String param = HttpHelper.getPostParams(params);
		//String url = PaymentPath.CONNECTIOIN_PATH;
		String url = UrlHelper.bulidConnectionUrl();
		//保存请求数据到payment数据库
		addConnectionRequestData(url,param,ServiceType.FREEZE);
		
		
		try {
			String xmlStr = HttpHelper.doPost(url, param);
			freezeResp = XStreamHandler.toBean(xmlStr, FreezeResp.class);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return freezeResp;
	}

	@Override
	public UnfreezeResp getUnfreeze(UnfreezeReq unfreezeReq) {
		UnfreezeResp unfreezeResp = new UnfreezeResp();
		ControllerRequest<UnfreezeReq> controllerRequest = new ControllerRequest<UnfreezeReq>();
		controllerRequest.setReq(unfreezeReq);
		String xml = controllerRequest.getReq();
		String sign = SignUtil.sign(controllerRequest.getReq());
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("req", URLEncoder.encode(xml, "utf-8"));
			params.put("sign",URLEncoder.encode(sign, "utf-8"));
			params.put("service",URLEncoder.encode(ServiceType.UNFREEZE, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String param = HttpHelper.getPostParams(params);
		//String url = PaymentPath.CONNECTIOIN_PATH;
		String url = UrlHelper.bulidConnectionUrl();
		//保存请求数据到payment数据库
		addConnectionRequestData(url,param,ServiceType.UNFREEZE);
		
		
		try {
			String xmlStr = HttpHelper.doPost(url, param);
			unfreezeResp = XStreamHandler.toBean(xmlStr, UnfreezeResp.class);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return unfreezeResp;
	}

	@Override
	public DirectTransactionResp getDirectTransaction(DirectTransactionReq directTransactionReq) {
		DirectTransactionResp directTransactionResp = new DirectTransactionResp();
		ControllerRequest<DirectTransactionReq> controllerRequest = new ControllerRequest<DirectTransactionReq>();
		controllerRequest.setReq(directTransactionReq);
		String xml = controllerRequest.getReq();
		String sign = SignUtil.sign(controllerRequest.getReq());
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("req", URLEncoder.encode(xml, "utf-8"));
			params.put("sign",URLEncoder.encode(sign, "utf-8"));
			params.put("service",URLEncoder.encode(ServiceType.DIRECT_TRANSACTION, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String param = HttpHelper.getPostParams(params);
		//String url = PaymentPath.CONNECTIOIN_PATH;
		String url = UrlHelper.bulidConnectionUrl();
		//保存请求数据到payment数据库
		addConnectionRequestData(url,param,ServiceType.DIRECT_TRANSACTION);
		
		
		try {
			String xmlStr = HttpHelper.doPost(url, param);
			directTransactionResp = XStreamHandler.toBean(xmlStr, DirectTransactionResp.class);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return directTransactionResp;
	}

	@Override
	public AutoTransactionResp getAutoTransaction(AutoTransactionReq autoTransactionReq) {
		AutoTransactionResp autoTransactionResp = new AutoTransactionResp();
		ControllerRequest<AutoTransactionReq> controllerRequest = new ControllerRequest<AutoTransactionReq>();
		controllerRequest.setReq(autoTransactionReq);
		String xml = controllerRequest.getReq();
		String sign = SignUtil.sign(controllerRequest.getReq());
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("req", URLEncoder.encode(xml, "utf-8"));
			params.put("sign",URLEncoder.encode(sign, "utf-8"));
			params.put("service",URLEncoder.encode(ServiceType.AUTO_TRANSACTION, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String param = HttpHelper.getPostParams(params);
		//String url = PaymentPath.CONNECTIOIN_PATH;
		String url = UrlHelper.bulidConnectionUrl();
		//保存请求数据到payment数据库
		addConnectionRequestData(url,param,ServiceType.AUTO_TRANSACTION);
		
		
		try {
			String xmlStr = HttpHelper.doPost(url, param);
			autoTransactionResp = XStreamHandler.toBean(xmlStr, AutoTransactionResp.class);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return autoTransactionResp;
	}

	

	@Override
	public CompleteTransactionResp getCompleteTransaction(CompleteTransactionReq completeTransactionReq) {
		CompleteTransactionResp completeTransactionResp = new CompleteTransactionResp();
		ControllerRequest<CompleteTransactionReq> controllerRequest = new ControllerRequest<CompleteTransactionReq>();
		controllerRequest.setReq(completeTransactionReq);
		String xml = controllerRequest.getReq();
		String sign = SignUtil.sign(controllerRequest.getReq());
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("req", URLEncoder.encode(xml, "utf-8"));
			params.put("sign",URLEncoder.encode(sign, "utf-8"));
			params.put("service",URLEncoder.encode(ServiceType.COMPLETE_TRANSACTION, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String param = HttpHelper.getPostParams(params);
		//String url = PaymentPath.CONNECTIOIN_PATH;
		String url = UrlHelper.bulidConnectionUrl();
		//保存请求数据到payment数据库
		addConnectionRequestData(url,param,ServiceType.COMPLETE_TRANSACTION);
		
		
		try {
			String xmlStr = HttpHelper.doPost(url, param);
			completeTransactionResp = XStreamHandler.toBean(xmlStr, CompleteTransactionResp.class);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return completeTransactionResp;
	}

	@Override
	public CancelAuthorizeAutoTransferResp getCancelAuthorizeAutoTransfer(CancelAuthorizeAutoTransferReq cancelAuthorizeAutoTransferReq) {
		CancelAuthorizeAutoTransferResp cancelAuthorizeAutoTransferResp = new CancelAuthorizeAutoTransferResp();
		ControllerRequest<CancelAuthorizeAutoTransferReq> controllerRequest = new ControllerRequest<CancelAuthorizeAutoTransferReq>();
		controllerRequest.setReq(cancelAuthorizeAutoTransferReq);
		String xml = controllerRequest.getReq();
		String sign = SignUtil.sign(controllerRequest.getReq());
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("req", URLEncoder.encode(xml, "utf-8"));
			params.put("sign",URLEncoder.encode(sign, "utf-8"));
			params.put("service",URLEncoder.encode(ServiceType.CANCEL_AUTHORIZE_AUTO_TRANSFER, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String param = HttpHelper.getPostParams(params);
		//String url = PaymentPath.CONNECTIOIN_PATH;
		String url = UrlHelper.bulidConnectionUrl();
		//保存请求数据到payment数据库
		addConnectionRequestData(url,param,ServiceType.CANCEL_AUTHORIZE_AUTO_TRANSFER);
		
		
		try {
			String xmlStr = HttpHelper.doPost(url, param);
			cancelAuthorizeAutoTransferResp = XStreamHandler.toBean(xmlStr, CancelAuthorizeAutoTransferResp.class);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return cancelAuthorizeAutoTransferResp;
	}

	@Override
	public CancelAuthorizeAutoRepaymentRepaymentResp getCancelAuthorizeAutoRepaymentRepayment(
			CancelAuthorizeAutoRepaymentRepaymentReq cancelAuthorizeAutoRepaymentRepaymentReq) {
		CancelAuthorizeAutoRepaymentRepaymentResp cancelAuthorizeAutoRepaymentRepaymentResp = new CancelAuthorizeAutoRepaymentRepaymentResp();
		ControllerRequest<CancelAuthorizeAutoRepaymentRepaymentReq> controllerRequest = new ControllerRequest<CancelAuthorizeAutoRepaymentRepaymentReq>();
		controllerRequest.setReq(cancelAuthorizeAutoRepaymentRepaymentReq);
		String xml = controllerRequest.getReq();
		String sign = SignUtil.sign(controllerRequest.getReq());
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("req", URLEncoder.encode(xml, "utf-8"));
			params.put("sign",URLEncoder.encode(sign, "utf-8"));
			params.put("service",URLEncoder.encode(ServiceType.CANCEL_AUTHORIZE_AUTO_REPAYMENT, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String param = HttpHelper.getPostParams(params);
		//String url = PaymentPath.CONNECTIOIN_PATH;
		String url = UrlHelper.bulidConnectionUrl();
		//保存请求数据到payment数据库
		addConnectionRequestData(url,param,ServiceType.CANCEL_AUTHORIZE_AUTO_REPAYMENT);
		
		
		try {
			String xmlStr = HttpHelper.doPost(url, param);
			cancelAuthorizeAutoRepaymentRepaymentResp = XStreamHandler.toBean(xmlStr, CancelAuthorizeAutoRepaymentRepaymentResp.class);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return cancelAuthorizeAutoRepaymentRepaymentResp;
	}

	@Override
	public WhdebitnocardRechargeResp getWhdebitnocardRecharge(
			WhdebitnocardRechargeReq whdebitnocardRechargeReq) {
		WhdebitnocardRechargeResp whdebitnocardRechargeResp = new WhdebitnocardRechargeResp();
		ControllerRequest<WhdebitnocardRechargeReq> controllerRequest = new ControllerRequest<WhdebitnocardRechargeReq>();
		controllerRequest.setReq(whdebitnocardRechargeReq);
		String xml = controllerRequest.getReq();
		String sign = SignUtil.sign(controllerRequest.getReq());
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("req", URLEncoder.encode(xml, "utf-8"));
			params.put("sign",URLEncoder.encode(sign, "utf-8"));
			params.put("service",URLEncoder.encode(ServiceType.WHDEBITNOCARD_RECHARGE, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String param = HttpHelper.getPostParams(params);
		//String url = PaymentPath.CONNECTIOIN_PATH;
		String url = UrlHelper.bulidConnectionUrl();
		//保存请求数据到payment数据库
		addConnectionRequestData(url,param,ServiceType.WHDEBITNOCARD_RECHARGE);
		
		
		try {
			String xmlStr = HttpHelper.doPost(url, param);
			whdebitnocardRechargeResp = XStreamHandler.toBean(xmlStr, WhdebitnocardRechargeResp.class);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return whdebitnocardRechargeResp;
	}

	@Override
	public PlatformInfoResp getPlatformInfo(PlatformInfoReq platformInfoReq) {
		PlatformInfoResp req = new PlatformInfoResp();
		ControllerRequest<PlatformInfoReq> controllerRequest = new ControllerRequest<PlatformInfoReq>();
		controllerRequest.setReq(platformInfoReq);
		String xml = controllerRequest.getReq();
		String sign = SignUtil.sign(controllerRequest.getReq());
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("req", URLEncoder.encode(xml, "utf-8"));
			params.put("sign",URLEncoder.encode(sign, "utf-8"));
			params.put("service",URLEncoder.encode(ServiceType.PLATFORM_INFO, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String param = HttpHelper.getPostParams(params);
		//String url = PaymentPath.CONNECTIOIN_PATH;
		String url = UrlHelper.bulidConnectionUrl();
		//保存请求数据到payment数据库
		addConnectionRequestData(url,param,ServiceType.PLATFORM_INFO);
		
		
		try {
			String xmlStr = HttpHelper.doPost(url, param);
			req = XStreamHandler.toBean(xmlStr, PlatformInfoResp.class);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return req;
	}

	@Override
	public ProjectQueryResp getProjectQuery(ProjectQueryReq projectQueryReq) {
		ProjectQueryResp req = new ProjectQueryResp();
		ControllerRequest<ProjectQueryReq> controllerRequest = new ControllerRequest<ProjectQueryReq>();
		controllerRequest.setReq(projectQueryReq);
		String xml = controllerRequest.getReq();
		String sign = SignUtil.sign(controllerRequest.getReq());
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("req", URLEncoder.encode(xml, "utf-8"));
			params.put("sign",URLEncoder.encode(sign, "utf-8"));
			params.put("service",URLEncoder.encode(ServiceType.PROJECT_QUERY, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String param = HttpHelper.getPostParams(params);
		//String url = PaymentPath.CONNECTIOIN_PATH;
		String url = UrlHelper.bulidConnectionUrl();
		//保存请求数据到payment数据库
		addConnectionRequestData(url,param,ServiceType.PROJECT_QUERY);
		
		
		try {
			String xmlStr = HttpHelper.doPost(url, param);
			req = XStreamHandler.toBean(xmlStr, ProjectQueryResp.class);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return req;
	}

	@Override
	public QueryWithdrawRecordResp getWithdrawRecord(QueryReq queryReq) {
		QueryWithdrawRecordResp req = new QueryWithdrawRecordResp();
		ControllerRequest<QueryReq> controllerRequest = new ControllerRequest<QueryReq>();
		controllerRequest.setReq(queryReq);
		String xml = controllerRequest.getReq();
		String sign = SignUtil.sign(controllerRequest.getReq());
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("req", URLEncoder.encode(xml, "utf-8"));
			params.put("sign",URLEncoder.encode(sign, "utf-8"));
			params.put("service",URLEncoder.encode(ServiceType.QUERY, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String param = HttpHelper.getPostParams(params);
		//String url = PaymentPath.CONNECTIOIN_PATH;
		String url = UrlHelper.bulidConnectionUrl();
		//保存请求数据到payment数据库
		addConnectionRequestData(url,param,ServiceType.QUERY);
		
		
		try {
			String xmlStr = HttpHelper.doPost(url, param);
			System.out.println(xmlStr);
			req = XStreamHandler.toBean(xmlStr,req.getClass());
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return req;
	}

	@Override
	public QueryRechargeRecordResp getRechargeRecord(QueryReq queryReq) {
		QueryRechargeRecordResp req = new QueryRechargeRecordResp();
		ControllerRequest<QueryReq> controllerRequest = new ControllerRequest<QueryReq>();
		controllerRequest.setReq(queryReq);
		String xml = controllerRequest.getReq();
		String sign = SignUtil.sign(controllerRequest.getReq());
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("req", URLEncoder.encode(xml, "utf-8"));
			params.put("sign",URLEncoder.encode(sign, "utf-8"));
			params.put("service",URLEncoder.encode(ServiceType.QUERY, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String param = HttpHelper.getPostParams(params);
		//String url = PaymentPath.CONNECTIOIN_PATH;
		String url = UrlHelper.bulidConnectionUrl();
		//保存请求数据到payment数据库
		addConnectionRequestData(url,param,ServiceType.QUERY);
		
		
		try {
			String xmlStr = HttpHelper.doPost(url, param);
			req = XStreamHandler.toBean(xmlStr,req.getClass());
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return req;
	}

	@Override
	public QueryCpTransactionRecordResp getCpTransactionRecord(QueryReq queryReq) {
		QueryCpTransactionRecordResp req = new QueryCpTransactionRecordResp();
		ControllerRequest<QueryReq> controllerRequest = new ControllerRequest<QueryReq>();
		controllerRequest.setReq(queryReq);
		String xml = controllerRequest.getReq();
		String sign = SignUtil.sign(controllerRequest.getReq());
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("req", URLEncoder.encode(xml, "utf-8"));
			params.put("sign",URLEncoder.encode(sign, "utf-8"));
			params.put("service",URLEncoder.encode(ServiceType.QUERY, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String param = HttpHelper.getPostParams(params);
		//String url = PaymentPath.CONNECTIOIN_PATH;
		String url = UrlHelper.bulidConnectionUrl();
		//保存请求数据到payment数据库
		addConnectionRequestData(url,param,ServiceType.QUERY);
		
		
		try {
			String xmlStr = HttpHelper.doPost(url, param);
			System.out.println(xmlStr);
			req = XStreamHandler.toBean(xmlStr,req.getClass());
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return req;
	}
	
	@Override
	public QueryFreezereRecordResp getFreezereRecord(QueryReq queryReq) {
		QueryFreezereRecordResp req = new QueryFreezereRecordResp();
		ControllerRequest<QueryReq> controllerRequest = new ControllerRequest<QueryReq>();
		controllerRequest.setReq(queryReq);
		String xml = controllerRequest.getReq();
		String sign = SignUtil.sign(controllerRequest.getReq());
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("req", URLEncoder.encode(xml, "utf-8"));
			params.put("sign",URLEncoder.encode(sign, "utf-8"));
			params.put("service",URLEncoder.encode(ServiceType.QUERY, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String param = HttpHelper.getPostParams(params);
		//String url = PaymentPath.CONNECTIOIN_PATH;
		String url = UrlHelper.bulidConnectionUrl();
		//保存请求数据到payment数据库
		addConnectionRequestData(url,param,ServiceType.QUERY);
		try {
			String xmlStr = HttpHelper.doPost(url, param);
			System.out.println(xmlStr);
			req = XStreamHandler.toBean(xmlStr,req.getClass());
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return req;
	}

}
