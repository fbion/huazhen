package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.service.DesService;
import com.hzframework.encrypt.DESEncoder;
import com.hzframework.encrypt.Encoder;
import com.hzframework.helper.PropertyHelper;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2015/8/18.
 */
public class DesServiceImpl implements DesService {

    public String encryptDES(String data){
        try {
            String key = "GW0EYuUvhV4=";
            byte[] bytes = toByteArray(data);
            return Encoder.encryptBASE64(DESEncoder.encrypt(bytes, key));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public String decryptDES(String data) {
        try {
            String key = "GW0EYuUvhV4=";
            byte[] bytes = Encoder.decryptBASE64(data);
            return new String(DESEncoder.decrypt(bytes, key));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private static byte[] toByteArray(String str) throws UnsupportedEncodingException {
        return str.getBytes("UTF-8");
    }
}
