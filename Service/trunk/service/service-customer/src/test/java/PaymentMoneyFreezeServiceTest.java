import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.customer.model.PaymentMoneyFreeze;
import com.hzfh.api.customer.service.PaymentCustomerBankService;
import com.hzfh.api.customer.service.PaymentMoneyFreezeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015/6/12.
 */
public class PaymentMoneyFreezeServiceTest {
    @Test
    public void addTest()throws Exception {
        String url =
                "http://customerservice.hzfh.com:8080/service-customer/paymentMoneyFreeze";
        HessianProxyFactory factory = new HessianProxyFactory();
        PaymentMoneyFreezeService paymentMoneyFreezeService = (PaymentMoneyFreezeService)
                factory.create(PaymentMoneyFreezeService.class, url);
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        PaymentMoneyFreezeService paymentMoneyFreezeService = (PaymentMoneyFreezeService) context.getBean("paymentMoneyFreezeService");
        PaymentMoneyFreeze paymentMoneyFreeze = new PaymentMoneyFreeze();
  /*      paymentMoneyFreeze.setCustomerName("'sd");
        paymentMoneyFreeze.setState("1");
        paymentMoneyFreeze.setCustomerNo("2");
        paymentMoneyFreeze.setSn("11123");*/
        int a = paymentMoneyFreezeService.add(paymentMoneyFreeze);
        System.out.println(a);
    }
}
