package com.hzfh.p2p.model.common.helper;

import com.hzframework.encrypt.DESEncoder;
import com.hzframework.encrypt.Encoder;
import com.hzframework.helper.PropertyHelper;
import com.hzframework.helper.StringHelper;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * Created by paul on 15-1-7.
 */
public class EncodeHelper {//编码帮助类
    public static String encryptBASE64(String key) {//把字符串原料放进去，出来就是一个加密后的字符串香肠。
        try {
            byte[] bytes = toByteArray(key);//把字符串变成byte的数组 （切碎）
            return Encoder.encryptBASE64(bytes); //在把字符数组 进行（灌装）加密
        } catch (Exception e) {
            return null;
        }
    }

    public static String decryptBASE64(String key) {//莫非这个是解密的方法？
        try {
            byte[] bytes = Encoder.decryptBASE64(key);//依然把字符串切碎成byte
            //return toString(bytes);
            return new String(bytes);//还你的加密字符key
        } catch (Exception e) {
            return null;
        }
    }


    /*
     * 加密密码专用，不可逆
     */
    public static String encryptPWD(String userName, String pwd, String key) {//密码加密三要述：1用户名。2密码。3加密字符。
        try {
            String temp = encryptDES(pwd, key);//第一步，密码与key(加密key) 搅拌 得到一个temp(临时的字符串)
            key = encryptBASE64(  //然后把 A(userName),B(文件读取的security.key的值=D8FC03F3274BF1E9) ,C(上面的临时的字符串) 。搅拌加密
            			userName + 		//A
            			PropertyHelper.getContextProperty("security.key").toString() + //B 
            			temp)	//C
            		.replace("\n", "").replace("\r", "");//然后把字符串证件的\n(换行) \r(回车符号) 变成空白
            return toString(Encoder.encryptMD5(toByteArray(key)));//然后把获得的key 进行MD5 加密搅拌
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String initKey(String seed) {//初始化一个加密key 字符串
        try {
            return DESEncoder.initKey(seed).replace("\n", "").replace("\r", ""); //去掉换行和回车
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decryptDES(String data, String key) {//中间临时加密组合字符串的一个方法
        try {
            byte[] bytes = toByteArray(data);
            return toString(DESEncoder.decrypt(bytes, key));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decryptDESFMP(String data) {
        try {
            String key = PropertyHelper.getContextProperty("security.key.fmp").toString();
            byte[] bytes = Encoder.decryptBASE64(data);
            return new String(DESEncoder.decrypt(bytes, key));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String decryptDES(String data) {
        try {
            byte[] bytes = toByteArray(data);
            return toString(DESEncoder.decrypt(bytes, PropertyHelper.getContextProperty("des.key").toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String encryptDES(String data, String key) {//给我2个 字符串（A:data。B:key） 还你一个
        try {
            byte[] bytes = toByteArray(data);
            return toString(DESEncoder.encrypt(bytes, key));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //给我一个字符串 ，我还你一个byte[] 的数组
    public static String encryptDES(String data) {
        try {
            byte[] bytes = toByteArray(data);
            return toString(DESEncoder.encrypt(bytes, PropertyHelper.getContextProperty("des.key").toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String encryptDESFMP(String data) {
        try {
            String key = PropertyHelper.getContextProperty("security.key.fmp").toString();
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
    //给我一个数组 ，我还你一个字符串
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

    /**
     获取随机数
     @param length 随机数的位数
     @return 返回生成的随机数
     */
    public static String getRandomKey(int length)//指定想要生成几位的随机数，就还你几位随机数
    {
        String[] vcArray = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        String vNum = "";
        int temp = -1; ////记录上次随机数值，尽量避免产生几个一样的随机数

        ////采用一个简单的算法以保证生成随机数的不同
        java.util.Random rand = new Random();
        for (int i = 1; i < length + 1; i++)
        {
            if (temp != -1)
            {
                rand = new Random(i * temp * (int)new java.util.Date().getTime());
            }

            int t = rand.nextInt(10);

            if (temp != -1 && temp == t)
            {
                return getRandomKey(length);
            }

            temp = t;
            vNum += vcArray[t];
        }

        return vNum; ////返回生成的随机数
    }

    /**
     * 混淆用户id
     * @param p2pCustomerId
     * @return
     */
    public static String generateRandomCustomerId(int p2pCustomerId)//用户id 和随机数的搅拌
    {

        char[] arrayNo = String.valueOf(p2pCustomerId).toCharArray();
        String random;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arrayNo.length; i++)
        {
            random = getRandomKey(3);
            sb.append(random);
            sb.append(arrayNo[i]);
        }

        random = getRandomKey(3);
        sb.append(random);

        return sb.toString();
    }

    /**
     * 解析混淆过的用户ID
     * @param randomCustomerId
     * @return
     */
    public static String extractRandomCustomerId(String randomCustomerId)//再分开
    {
        if (StringHelper.isNullOrEmpty(randomCustomerId) == true)
        {
            return "";
        }

        char[] arrayNo = randomCustomerId.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arrayNo.length; i++)
        {
            if (i % 4 == 3)
            {
                sb.append(arrayNo[i]);
            }
        }

        return sb.toString();
    }
}
