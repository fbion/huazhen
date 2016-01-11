import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.log.model.ProductLog;
import com.hzfh.api.log.model.SalesLog;
import com.hzfh.api.log.service.ProductLogService;
import com.hzfh.api.log.service.SalesLogService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015/11/2.
 */
public class SalesLogTest {

    @Test
    public void test() throws Exception {

        String url = "http://logservice.hzfh.com:8080/service-log/salesLog";
        HessianProxyFactory factory = new HessianProxyFactory();
        SalesLogService salesLogService = (SalesLogService) factory.create(SalesLogService.class, url);

//        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
//        SalesLogService salesLogService = (SalesLogService) context.getBean("salesLogService");
        SalesLog salesLog = new SalesLog();
        salesLog.setAction("action");
        salesLog.setAfterData("{id:16;name:hexin}");
        salesLog.setDescription("打款");
        salesLog.setMethod("add");
        salesLog.setSalesNo(16);
        salesLog.setInUserNo(192);
        salesLogService.add(salesLog);
    }
    @Test
    public void testProductLogService() throws Exception {

//        String url = "http://logservice.hzfh.com:8080/service-log/productLog";
//        HessianProxyFactory factory = new HessianProxyFactory();
//        ProductLogService productLogService = (ProductLogService) factory.create(ProductLogService.class, url);

        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductLogService productLogService = (ProductLogService) context.getBean("productLogService");

        ProductLog salesLog = new ProductLog();
        salesLog.setAction("action");
        salesLog.setAfterData("{id:16;name:hexin}");
        salesLog.setDescription("打款");
        salesLog.setMethod("add");
        salesLog.setProductNo(16);
        salesLog.setInUserNo(192);
        productLogService.add(salesLog);
    }
}
