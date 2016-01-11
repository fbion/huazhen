import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.baseInfo.model.City;
import com.hzfh.api.baseInfo.service.CityService;
import com.hzfh.api.baseInfo.service.DesService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2015/8/18.
 */
public class DesServiceTest {
    @Test
    public void encryptDESTest() throws Exception{

        String url =
                "http://baseinfoservice.hzfh.com:8080/service-baseInfo/des";
        HessianProxyFactory factory = new HessianProxyFactory();
        DesService desService = (DesService)factory.create(DesService.class, url);
        String result = desService.encryptDES("15901233437");
        System.out.println(result);

    }
    @Test
    public void decryptDESTest() throws Exception{

        String url =
                "http://baseinfoservice.hzfh.com:8080/service-baseInfo/des";
        HessianProxyFactory factory = new HessianProxyFactory();
        DesService desService = (DesService)factory.create(DesService.class, url);
        String result = desService.decryptDES("ND21KCp6SxgNEIrhHf5AzQ==");
        System.out.println(result);

    }
}
