package com.hzfh.fmp.model.common.helper;

import com.hzframework.encrypt.DESEncoder;
import com.hzframework.encrypt.Encoder;
import com.hzframework.helper.PropertyHelper;

import java.io.UnsupportedEncodingException;

/**
 * Created by paul on 15-1-7.
 */
public class EncodeHelper {
    public static String encryptBASE64(String key) {
        try {
            byte[] bytes = toByteArray(key);
            return Encoder.encryptBASE64(bytes);
        } catch (Exception e) {
            return null;
        }
    }

    public static String decryptBASE64(String key) {
        try {
            byte[] bytes = Encoder.decryptBASE64(key);
            return toString(bytes);
        } catch (Exception e) {
            return null;
        }
    }


    /*
     * 加密密码专用，不可逆
     */
    public static String encryptPWD(String userName, String pwd) {
        try {
        	String key = encryptBASE64(userName
                    + "D8FC03F3274BF1E9" + pwd).replace("\n","").replace("\r","");
            //byte[] pwdDES = DESEncoder.encrypt(toByteArray(pwd),key);
            return toString(Encoder.encryptMD5(toByteArray(key)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decryptDES(String data) {
        try {
            String key = PropertyHelper.getContextProperty("security.key").toString();
            byte[] bytes = Encoder.decryptBASE64(data);
            return new String(DESEncoder.decrypt(bytes, key));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encryptDES(String data) {
        try {
            String key = PropertyHelper.getContextProperty("security.key").toString();
            byte[] bytes = toByteArray(data);
            return Encoder.encryptBASE64(DESEncoder.encrypt(bytes, key));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] toByteArray(String str) throws UnsupportedEncodingException {
        return str.getBytes("UTF-8");
    }

    private static String toString(byte[] bytes) throws UnsupportedEncodingException {
        String des = "";
        String tmp = null;

        for (int i = 0; i < bytes.length; i++) {
            tmp = (Integer.toHexString(bytes[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }

    public static String initKey(String seed) {//初始化一个加密key 字符串
        try {
            return DESEncoder.initKey(seed).replace("\n", "").replace("\r", ""); //去掉换行和回车
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
