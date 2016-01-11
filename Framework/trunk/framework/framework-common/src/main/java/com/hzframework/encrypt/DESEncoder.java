package com.hzframework.encrypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * Created by paul on 14-12-30.
 */
public class DESEncoder extends Encoder {
    public static final String ALGORITHM = "DES";

    /**
     * 转换密钥<br>
     *
     * @param key
     * @return
     * @throws Exception
     */
    private static Key toKey(byte[] key) throws Exception {
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey secretKey = keyFactory.generateSecret(dks);

        // 当使用其他对称加密算法时，如AES、Blowfish等算法时，用下述代码替换上述三行代码
        // SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);

        return secretKey;
    }

    /**
     * 解密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, String key) throws Exception {
        Key k = toKey(decryptBASE64(key));

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, k);

        return cipher.doFinal(data);
    }

    /**
     * 加密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, String key) throws Exception {
        Key k = toKey(decryptBASE64(key));
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, k);

        return cipher.doFinal(data);
    }

    /**
     * 生成密钥
     *
     * @return
     * @throws Exception
     */
    public static String initKey() throws Exception {
        return initKey(null);
    }

    /**
     * 生成密钥
     *
     * @param seed
     * @return
     * @throws Exception
     */
    public static String initKey(String seed) throws Exception {
        SecureRandom secureRandom = null;

        if (seed != null) {
            secureRandom = new SecureRandom(decryptBASE64(seed));
        } else {
            secureRandom = new SecureRandom();
        }

        KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);
        kg.init(secureRandom);

        SecretKey secretKey = kg.generateKey();

        return encryptBASE64(secretKey.getEncoded());
    }
}
