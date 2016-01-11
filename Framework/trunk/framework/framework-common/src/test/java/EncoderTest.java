
import com.hzframework.encrypt.DESEncoder;
import com.hzframework.encrypt.Encoder;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by paul on 14-12-30.
 */
public class EncoderTest {
    @Test
    public void encoderTest() throws Exception {
        String inputStr = "简单加密";
        System.out.println("原文:\n" + inputStr);

        byte[] inputData = inputStr.getBytes();
        String code = Encoder.encryptBASE64(inputData);

        System.out.println("BASE64加密后:  " + code);

        byte[] output = Encoder.decryptBASE64(code);

        String outputStr = new String(output);

        System.out.println("BASE64解密后:  " + outputStr);

        // 验证BASE64加密解密一致性
        if (inputStr.equals(outputStr))
            System.out.println("base64 OK");

        // 验证MD5对于同一内容加密是否一致
        String md51 = new String(Encoder.encryptMD5(inputData));
        String md52 = new String(Encoder.encryptMD5(inputData));
        if (md51.equals(md52))
            System.out.println("MD5 OK");

        // 验证SHA对于同一内容加密是否一致
        if ((new String(Encoder.encryptSHA(inputData))).equals((new String(Encoder
                .encryptSHA(inputData)))))
            System.out.println("SHA OK");

        String key = Encoder.initMacKey();
        System.out.println("Mac密钥:" + key);

        // 验证HMAC对于同一内容，同一密钥加密是否一致
        String hmac1 =new String(Encoder.encryptHMAC(inputData, key));
        String hmac2 =new String(Encoder.encryptHMAC(inputData, key));
        if (hmac1.equals(hmac2))
            System.out.println("HMAC OK");

        BigInteger md5 = new BigInteger(Encoder.encryptMD5(inputData));
        System.out.println("MD5:\n" + md5.toString(16));

        BigInteger sha = new BigInteger(Encoder.encryptSHA(inputData));
        System.out.println("SHA:\n" + sha.toString(32));

        BigInteger mac = new BigInteger(Encoder.encryptHMAC(inputData, inputStr));
        System.out.println("HMAC:\n" + mac.toString(16));
    }

    @Test
    public void desEncoderTest() throws Exception {
        String inputStr = "hex";
        String key = DESEncoder.initKey("123456").replace("\n", "").replace("\r", "");
        System.err.println("原文:\t" + inputStr);
        String key1 = "GW0EYuUvhV4=";//DESEncoder.initKey();
        System.err.println("密钥1:\t" + key1);

        System.err.println("密钥:\t" + key);

        byte[] inputData = inputStr.getBytes("UTF-8");
        inputData = DESEncoder.encrypt(inputData, key1);

        System.err.println("加密后:\t" + DESEncoder.encryptBASE64(inputData));

        byte[] outputData = DESEncoder.decrypt(inputData, key1);
        String outputStr = new String(outputData);

        System.err.println("解密后:\t" + outputStr);

        if (inputStr.equals(outputStr))
            System.err.println("DES OK");
    }

    @Test
    public void desEncoderTest2() throws Exception {
        String str ="123";
        byte[] inputData = str.getBytes("UTF-8");
        System.err.println("明文1:\t" + inputData);
        inputData = DESEncoder.encrypt(inputData, "2015-04-30 19:14:54.337");
        System.err.println("密文1:\t" + inputData);

        byte[] inputData2 = str.getBytes("UTF-8");
        System.err.println("明文2:\t" + inputData2);
        inputData2 = DESEncoder.encrypt(inputData2, "2015-04-30 19:14:54.337");
        System.err.println("密文2:\t" + inputData2);
    }
}
