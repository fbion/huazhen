import com.hzframework.helper.HttpHelper;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
/**
 * Created by paul on 15-3-25.
 */
public class HttpHelperTest {
    @Test
    public void doPostTest(){
        try {
            System.out.print("#");
            HashMap map = new HashMap();
//            map.put("isAutoLogin","0");
//            map.put("password","MTIzNDU2");
//            map.put("userName","test16");
//            map.put("verifyCode","PZHJ");
            System.out.print(HttpHelper.doPost("http://localhost:8081/upload/upload",map));
            System.out.print("#");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
