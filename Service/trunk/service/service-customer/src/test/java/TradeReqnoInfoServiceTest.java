import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.customer.model.TradeReqnoInfo;
import com.hzfh.api.customer.service.PaymentCustomerBankService;
import com.hzfh.api.customer.service.TradeReqnoInfoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015/6/19.
 */
public class TradeReqnoInfoServiceTest {

    @Test
    public void addTest() throws Exception {
        String url =
                "http://customerservice.hzfh.com:8080/service-customer/tradeReqnoInfo";
        HessianProxyFactory factory = new HessianProxyFactory();
        TradeReqnoInfoService tradeReqnoInfoService = (TradeReqnoInfoService)
                factory.create(TradeReqnoInfoService.class, url);
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        TradeReqnoInfoService tradeReqnoInfoService = (TradeReqnoInfoService) context.getBean("tradeReqnoInfoService");
        TradeReqnoInfo tradeReqnoInfo = new TradeReqnoInfo();
        tradeReqnoInfo.setCustomerNo(5);
        tradeReqnoInfo.setIsOk(1);
        tradeReqnoInfo.setId(5);
        tradeReqnoInfo.setSn("11236644");
        tradeReqnoInfo.setStatus((byte) 1);
        int a = tradeReqnoInfoService.add(tradeReqnoInfo);
    }
}
