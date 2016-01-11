import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.baseInfo.model.helper.SnEnum;
import com.hzfh.api.baseInfo.service.SnService;
import com.hzfh.api.customer.model.TradeReqnoInfo;
import com.hzfh.api.payment.model.request.controller.AccountInfoReq;
import com.hzfh.api.payment.model.response.controller.AccountInfoResp;
import com.hzfh.p2p.model.baseInfo.SnModel;
import com.hzfh.p2p.model.common.state.StateValues;
import com.hzfh.p2p.model.customer.TradeReqnoInfoModel;
import com.hzfh.p2p.model.payment.ControllerModel;
import com.hzframework.helper.DateHelper;


public class PaymentTest {

//	@Test
//	public void Rechargetest() {
//		RechargeReq rechargeReq=new RechargeReq();
//		rechargeReq.getPlatformNo();
//		rechargeReq.setPlatformUserNo("123456");
//		rechargeReq.setAmount("1.0");
//		rechargeReq.setFeeMode(FeeMode.PLATFORM);
//		rechargeReq.setCallbackUrl("callbackUrl");
//		rechargeReq.setNotifyUrl("notifyUrl");
//		rechargeReq.setRequestNo("requestNo");
//		GatewayModel.recharge(rechargeReq);
//	}
//	@Test
//	public void registertest(){
//		RegisterReq registerReq=new RegisterReq();
//		registerReq.setCallbackUrl("http://61.135.195.23:8088/p2p/customer/paymentRegister/registerCallback");
//		registerReq.setNotifyUrl("http://61.135.195.23:8088/p2p/customer/paymentRegister/registerNotify");;
//		registerReq.setPlatformUserNo("153");
//		registerReq.setRealName("孟冲");
//		registerReq.setNickName("mc");
//		registerReq.setIdCardNo("130635199007102919");
//		registerReq.setEmail("759518909@qq.com");
//		registerReq.setMobile("13800138000");
//		registerReq.setIdCardType("G2_IDCARD");
//		GatewayModel.register(registerReq);
//	}
//	@Test
//	public void Rechargetest2() {
//		AccountInfoReq accountInfoReq = new AccountInfoReq();
//		accountInfoReq.setPlatformUserNo("250");
//		accountInfoReq.setPlatformNo("12345678910");
//		AccountInfoResp accountInfoResp = ControllerModel.getAccountInfo(accountInfoReq);
//		System.out.println(accountInfoResp);
//	}
//	@Test
//	public void SignTest() {
//		String verifyXml = "hello.com";
// 		boolean t = SignModel.verifySign(verifyXml, "hello");
//		System.out.println(t);
//	}
	
	@Test
	public void snTest(){
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");
//		SnService snService = (SnService) context.getBean("snService");
		
		
		SnEnum s =SnEnum.SN_ENTERPRISEREGISTER;
		
//		String sn =  snService.getSn(s);
		String sn = SnModel.getSn(s);
		
		 System.out.println(sn);
		
	}
	@Test
	public void tradeReqnoInfoAddTest(){
		TradeReqnoInfo tradeReqnoInfo = new TradeReqnoInfo();
		tradeReqnoInfo.setCustomerNo(212);
		tradeReqnoInfo.setStatus((byte) 06);
		tradeReqnoInfo.setSn("123456789");
		tradeReqnoInfo.setIsOk(0);
		int sn = TradeReqnoInfoModel.add(tradeReqnoInfo);
		System.out.println(sn);
	}
	@Test
	public void accountInfoTest(){
		AccountInfoReq accountInfoReq = new AccountInfoReq();
		accountInfoReq.setPlatformNo(accountInfoReq.getPlatformUserNo());
		accountInfoReq.setPlatformUserNo("401");
		AccountInfoResp accountInfoResp = ControllerModel.getAccountInfo(accountInfoReq);
		System.out.println(accountInfoResp);
	}

	@Test
	public void companyAccountInfoTest(){
		AccountInfoReq accountInfoReq = new AccountInfoReq();
		accountInfoReq.setPlatformNo(accountInfoReq.getPlatformNo());
		accountInfoReq.setPlatformUserNo("290");
		AccountInfoResp accountInfoResp = ControllerModel.getAccountInfo(accountInfoReq);
		System.out.print(accountInfoResp);
	}
	@Test
	public void companyAccountInfoTest1(){
		String regEx="[^0-9]";   
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(DateHelper.getToday());  
		String tempTime = m.replaceAll("").trim();
		System.out.print(tempTime);
	}
	


}
