import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.customer.model.PaymentAccountInformation;
import com.hzfh.api.customer.service.PaymentAccountInformationService;
import com.hzfh.api.customer.service.PaymentCustomerBankService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015/6/18.
 */
public class PaymentAccountInformationServiceTest {
    @Test
    public void getInfo() throws Exception {
        String url =
                "http://customerservice.hzfh.com:8080/service-customer/paymentAccountInformation";
        HessianProxyFactory factory = new HessianProxyFactory();
        PaymentAccountInformationService paymentAccountInformationService = (PaymentAccountInformationService)
                factory.create(PaymentAccountInformationService.class, url);
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        PaymentAccountInformationService paymentAccountInformationService = (PaymentAccountInformationService)
//                context.getBean("paymentAccountInformationService");
        PaymentAccountInformation paymentAccountInformation = paymentAccountInformationService.getInfoByCustomerNo(250);
        System.out.println(paymentAccountInformation.getId());
    }


}
