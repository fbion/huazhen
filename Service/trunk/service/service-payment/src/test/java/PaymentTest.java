import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.payment.model.common.PaymentData;
import com.hzfh.api.payment.model.common.constant.ServiceType;
import com.hzfh.api.payment.model.common.entity.Detail;
import com.hzfh.api.payment.model.common.entity.Details;
import com.hzfh.api.payment.model.common.entity.Tender;
import com.hzfh.api.payment.model.request.controller.AccountInfoReq;
import com.hzfh.api.payment.model.request.gateway.CpTransactionReq;
import com.hzfh.api.payment.model.response.controller.AccountInfoResp;
import com.hzfh.api.payment.service.ControllerService;
import com.hzfh.api.payment.service.GatewayService;
import com.hzfh.service.payment.serviceImpl.Helper.UrlHelper;


public class PaymentTest {

	@Test
	public void Rechargetest() {
		//ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		//ControllerService controllerService=(ControllerService) context.getBean("controllerService");
		/*ControllerServiceImpl controllerServiceImpl = new ControllerServiceImpl();
		AccountInfoReq accountInfoReq = new AccountInfoReq();
		accountInfoReq.setPlatformUserNo("12345678");
		AccountInfoResp accountInfoResp = controllerServiceImpl.getAccountInfo(accountInfoReq);
		System.out.println(accountInfoResp);*/
		
	}
	@Test
	public void Rechargetest1() {
		
		String url;
		try {
			url = UrlHelper.bulidGatewayUrl(ServiceType.TO_REGISTER);
			System.out.println(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void cpTransaction() {
		
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		GatewayService gatewayService=(GatewayService) context.getBean("gatewayService");
		CpTransactionReq<Tender> cpTransactionReq = new CpTransactionReq<Tender>();
        cpTransactionReq.setRequestNo("123456");
        cpTransactionReq.setPlatformUserNo("252");
        cpTransactionReq.setUserType("MEMBER");
        cpTransactionReq.setBizType("TENDER");

        List<Detail> detailList = new ArrayList<Detail>();
        Details details = new Details();
        Detail detail = new Detail();
        detail.setAmount("123");
        detail.setBizType("MEMBER");
        detail.setTargetPlatformUserNo("1234");
        detail.setTargetUserType("MERCHANT");
        detailList.add(detail);

        
        cpTransactionReq.setDetails(details);

        
        Tender tender = new Tender();
        tender.setBorrowerPlatformUserNo("123");
        tender.setTenderAmount("456");
        tender.setTenderDescription("789");
        tender.setTenderName("678");
        tender.setTenderOrderNo("111");
        tender.getExtend();
        cpTransactionReq.setExtend(tender.getExtend());

      
        cpTransactionReq.setNotifyUrl("customer/bindBankcardCallBack");
        cpTransactionReq.setCallbackUrl("customer/bindBankcardCallBack");
        
        PaymentData paymentData = gatewayService.tender(cpTransactionReq);
		System.out.println(paymentData);
	}
	
	@Test
	public void getAccountInfoTest(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		ControllerService controllerService=(ControllerService) context.getBean("controllerService");
		AccountInfoReq accountInfoReq = new AccountInfoReq();
		accountInfoReq.setPlatformUserNo("218");
		accountInfoReq.setPlatformNo(accountInfoReq.getPlatformNo());
		AccountInfoResp accountInfoResp =  controllerService.getAccountInfo(accountInfoReq);
		System.out.println(accountInfoResp);
	}
	/*@Test
	public void autoAccountCheckTest(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
        ActRuTaskService actRuTaskService = (ActRuTaskService) context.getBean("actRuTaskService");
		ActRuTask actRuTask =  actRuTaskService.getInfoByAciIdAndUserId("657501", 258);
		System.out.println(actRuTask);
	}*/

	
}
