import com.hzfh.p2p.model.common.helper.EncodeHelper;
import com.hzframework.encrypt.DESEncoder;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2015/7/2.
 */
public class DESTest {

    @Test
    public void test() throws Exception {
        String data = "hex";
        String key = DESEncoder.initKey();
        String mm = EncodeHelper.encryptDES(data,key);
        System.err.println(mm);
        String mw = EncodeHelper.decryptDES(mm,key);
        System.err.println(mw);
    }

}
