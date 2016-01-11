import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.baseInfo.service.DesService;
import com.hzfh.fmp.model.common.helper.EncodeHelper;
import com.hzframework.encrypt.DESEncoder;
import com.hzframework.encrypt.Encoder;
import org.junit.Test;

/**
 * Created by Administrator on 2015/7/2.
 */
public class DESTest {
    @Test
    public void test() throws Exception {
        String a = "13716498307";
        byte[] bytes = a.getBytes();
        System.out.println(bytes.length);
        String key = "GW0EYuUvhV4=";
        byte m[] =  DESEncoder.encrypt(bytes,key);
        System.out.print(m.length);

    }

    @Test
    public void encryptDESTest() throws Exception{

        String url =
                "http://baseinfoservice.hzfh.com:8080/service-baseInfo/des";
        HessianProxyFactory factory = new HessianProxyFactory();
        DesService desService = (DesService)factory.create(DesService.class, url);
        String result = desService.encryptDES("13716498307");
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
