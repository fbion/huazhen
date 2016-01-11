import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.baseInfo.service.DicDataService;
import org.junit.Test;

import java.net.MalformedURLException;

/**
 * Created by paul on 14-12-24.
 */
public class HessianTest {
    @Test
    public void hessianTest() throws MalformedURLException {//main(String[] args) throws MalformedURLException {
        //String url = "http://localhost:8080/hessian/productQuery";
//        String url = "http://192.168.1.232:8080/service-product/product";
    	String url= "http://localhost:8080/service-baseInfo/dicData";
        HessianProxyFactory factory = new HessianProxyFactory();
        DicDataService dicDataService = (DicDataService) factory.create(DicDataService.class, url);


        DicData dicData = new DicData();
        dicData.setCode((byte)3);
        dicData.setDicTypeNo(1);
        dicData.setValue("9999999");
        dicDataService.add(dicData);
    }
}
