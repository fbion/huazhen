import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.service.CustomerPersonalService;
import org.junit.Test;

import java.net.MalformedURLException;

/**
 * Created by paul on 14-12-24.
 */
public class HessianTest {
    @Test
    public void hessianTest() throws MalformedURLException {//main(String[] args) throws MalformedURLException {
        //String url = "http://localhost:8080/hessian/productQuery";
    	//String url = "http://192.168.1.232:8080/service-product/product";
    	String url = "http://localhost:8080/service-customer/customerPersonal";
        HessianProxyFactory factory = new HessianProxyFactory();
        CustomerPersonalService customerPersonalService = (CustomerPersonalService) factory.create(CustomerPersonalService.class, url);
        CustomerPersonal customerPersonal = new CustomerPersonal();
        customerPersonal.setCode("ads");
        customerPersonal.setName("阿啊啊");
        customerPersonalService.add(customerPersonal);
    }
}
