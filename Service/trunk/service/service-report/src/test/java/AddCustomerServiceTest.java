import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.report.model.AddCustomerReport;
import com.hzfh.api.report.model.AddSalesReport;
import com.hzfh.api.report.model.PaymentReport;
import com.hzfh.api.report.model.PaymentReportDeatil;
import com.hzfh.api.report.model.query.AddCustomerReportCondition;
import com.hzfh.api.report.model.query.AddSalesReportCondition;
import com.hzfh.api.report.service.AddCustomerReportService;
import com.hzfh.api.report.service.AddSalesReportService;
import com.hzfh.api.report.service.PaymentReportDeatilService;
import com.hzfh.api.report.service.PaymentReportService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/6/15.
 */
public class AddCustomerServiceTest {
    @Test
    public void getInfo() throws Exception{

//        String url =
//                "http://customerservice.hzfh.com:8080/service-report/paymentReportDeatil";
//        HessianProxyFactory factory = new HessianProxyFactory();
//        PaymentReportDeatilService paymentReportDeatilService = (PaymentReportDeatilService)
//                factory.create(PaymentReportDeatilService.class, url);
//
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PaymentReportDeatilService paymentReportDeatilService = (PaymentReportDeatilService) context.getBean("paymentReportDeatilService");
        double a = paymentReportDeatilService.getTotalPayMoneyByPaymentReportNo(21).getPayMoney();
        System.out.print(a);
    }



    @Test
    public void getAddCountByStatusAndTypeTest()throws Exception{
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AddCustomerReportService addCustomerReportService = (AddCustomerReportService) context.getBean("addCustomerReportService");
        String url =
                "http://customerservice.hzfh.com:8080/service-report/addCustomerReport";
        HessianProxyFactory factory = new HessianProxyFactory();
        AddCustomerReportService addCustomerReportService = (AddCustomerReportService)
                factory.create(AddCustomerReportService.class, url);
        AddCustomerReportCondition addCustomerReportCondition = new AddCustomerReportCondition();
        addCustomerReportCondition.setWeek(3);

        List<AddCustomerReport> addCustomerReportList = addCustomerReportService.getListSerch(addCustomerReportCondition);
        System.out.print(addCustomerReportList.size());
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AddCustomerReportService addCustomerReportService = (AddCustomerReportService) context.getBean("addCustomerReportService");
//        int result = addCustomerReportService.getAddCountByTypeAndStatus("1","1,2").size();
//        System.out.println(result);

    }


    @Test
    public void getAddCountTotalTest() throws Exception{
//        String url =
//                "http://customerservice.hzfh.com:8080/service-report/addCustomerReport";
//        HessianProxyFactory factory = new HessianProxyFactory();
//        AddCustomerReportService addCustomerReportService = (AddCustomerReportService)
//                factory.create(AddCustomerReportService.class, url);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PaymentReportDeatilService addCustomerReportService = (PaymentReportDeatilService) context.getBean("paymentReportDeatilService");
//        AddCustomerReport addCustomerReport = addCustomerReportService.getAddCountTotal();
//        System.out.println(addCustomerReport.getEmployeeCount());
        
        List<PaymentReportDeatil> paymentReport = new ArrayList<PaymentReportDeatil>();
        paymentReport = addCustomerReportService.getListByReportNo(7);
        System.out.println(paymentReport);

    }
}
