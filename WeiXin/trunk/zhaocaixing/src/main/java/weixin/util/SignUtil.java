package weixin.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
/**
 * 请求校验工具类
 * @author Administrator
 *
 */
public class SignUtil {
	private static String token ="weixinCourse";
	/**
	 * 校验签名
	 * @param signatrue
	 * @param timetamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(String signature,String timestamp,String nonce){
		String[] paramArr = new String[] {token,timestamp,nonce};
		Arrays.sort(paramArr);
		String content = paramArr[0].concat(paramArr[1]).concat(paramArr[2]);
		String cipherText = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] digest = md.digest(content.toString().getBytes());
			cipherText = byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return cipherText !=null ? cipherText.equals(signature.toUpperCase()) :false;
		
	}
	/**
	 * 将字节数组转换为十六进制字符串
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray){
		String strDigest = "";
		for(int i=0 ;i< byteArray.length;i++){
			strDigest += byteToHexStr(byteArray[i]); 
		}
		return  strDigest;
	}

	/**
	 * 将字节转换为十六进制字符串
	 * @param b
	 * @return
	 */
	private static String byteToHexStr(byte mByte) {
		char[] Digit = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];
		String s = new String(tempArr);
		return s;
	}
}
