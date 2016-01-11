import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.customer.model.PaymentCustomerBank;
import com.hzfh.api.customer.service.P2pCustomerService;
import com.hzfh.api.customer.service.PaymentCustomerBankService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2015/6/5.
 */
public class PaymentCustomerBankTest {

    @Test
     public void getInfoTest() throws Exception{
        String url =
                "http://customerservice.hzfh.com:8080/service-customer/paymentCustomerBank";
        HessianProxyFactory factory = new HessianProxyFactory();
        PaymentCustomerBankService paymentCustomerBankService = (PaymentCustomerBankService)
                factory.create(PaymentCustomerBankService.class, url);
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        PaymentCustomerBankService paymentCustomerBankService = (PaymentCustomerBankService) context.getBean("paymentCustomerBankService");
        List<PaymentCustomerBank> paymentCustomerBanklist = paymentCustomerBankService.getListByCustomerNo(145);
        System.out.println(paymentCustomerBanklist.size());
    }
    @Test
    public void addTest() throws Exception{
//        String url =
//                "http://customerservice.hzfh.com:8080/service-customer/paymentCustomerBank";
//        HessianProxyFactory factory = new HessianProxyFactory();
//        PaymentCustomerBankService paymentCustomerBankService = (PaymentCustomerBankService)
//                factory.create(PaymentCustomerBankService.class, url);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PaymentCustomerBankService paymentCustomerBankService = (PaymentCustomerBankService) context.getBean("paymentCustomerBankService");
        PaymentCustomerBank paymentCustomerBank = new PaymentCustomerBank();
        paymentCustomerBank.setCustomerName("王亚凤");
        paymentCustomerBank.setBankCard("123345477");
        paymentCustomerBank.setBankName("中国工商");
        paymentCustomerBank.setState(1);
        paymentCustomerBank.setCustomerNo(250);
        int a = paymentCustomerBankService.add(paymentCustomerBank);
        System.out.println(a);
    }
    @Test
    public void unBindCardBankTest() throws Exception{
//        String url =
//                "http://customerservice.hzfh.com:8080/service-customer/paymentCustomerBank";
//        HessianProxyFactory factory = new HessianProxyFactory();
//        PaymentCustomerBankService paymentCustomerBankService = (PaymentCustomerBankService)
//                factory.create(PaymentCustomerBankService.class, url);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PaymentCustomerBankService paymentCustomerBankService = (PaymentCustomerBankService) context.getBean("paymentCustomerBankService");
        paymentCustomerBankService.unBindCardBank(250);

    }
}
