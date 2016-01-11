import java.io.IOException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.payment.service.SignService;
import com.hzframework.helper.HttpHelper;

/**
 * Created by Administrator on 2015/7/2.
 */
public class NotifyTest {

	/*@Test
	public void signTest(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		SignService signService=(SignService) context.getBean("signService");
		String verifyXml='<?xml version="1.0" encoding="UTF-8" standalone="yes"?>"<notify><requestNo>2015101512004219301930</requestNo><platformNo>10012459931</platformNo><bizType>REGISTER</bizType><code>1</code><message>注册成功</message><platformUserNo>30134</platformUserNo></notify>';
		String sign = "MIIFLQYJKoZIhvcNAQcCoIIFHjCCBRoCAQExCzAJBgUrDgMCGgUAMC8GCSqGSIb3DQEHAaAiBCA1NGI5YjgyMDI4ZDQzZjczYTE5Njk1ZTI4ZmVjMjUwNaCCA+8wggPrMIIDVKADAgECAhBdhWwmCJ6J4I7FOXDt/QXLMA0GCSqGSIb3DQEBBQUAMCoxCzAJBgNVBAYTAkNOMRswGQYDVQQKExJDRkNBIE9wZXJhdGlvbiBDQTIwHhcNMTQwMzMxMDgxMzM0WhcNMTcwMzMxMDgxMzM0WjCBhjELMAkGA1UEBhMCQ04xGzAZBgNVBAoTEkNGQ0EgT3BlcmF0aW9uIENBMjEWMBQGA1UECxMNcmEueWVlcGF5LmNvbTEUMBIGA1UECxMLRW50ZXJwcmlzZXMxLDAqBgNVBAMUIzA0MUBaeWVlcGF5LmNvbUB5ZWVwYXkuY29tQDAwMDAwMDAxMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDUVZmAbx6za66GdcZS9T09zwWTNxHb/M56UG6/o/ejgWqSytKm/GIYlYc03nZs1Isbvz/WKUrf/TmJ7RjyoXKEyaNMecVqwN2V5me/58n023R5CUO09X0t4jhGRtY6PQkqMt0v+HjjtNNXyVrPi8TseI7Za1GF+pAVkSEqjFnX8QIDAQABo4IBszCCAa8wHwYDVR0jBBgwFoAU8I3ts0G7++8IHlUCwzE37zwUTs0wHQYDVR0OBBYEFM+Hqel2sjNtEREEhcOw/+HGRazZMAsGA1UdDwQEAwIE8DAMBgNVHRMEBTADAQEAMDsGA1UdJQQ0MDIGCCsGAQUFBwMBBggrBgEFBQcDAgYIKwYBBQUHAwMGCCsGAQUFBwMEBggrBgEFBQcDCDCB/wYDVR0fBIH3MIH0MFegVaBTpFEwTzELMAkGA1UEBhMCQ04xGzAZBgNVBAoTEkNGQ0EgT3BlcmF0aW9uIENBMjEMMAoGA1UECxMDQ1JMMRUwEwYDVQQDEwxjcmwxMDRfMTA2ODIwgZiggZWggZKGgY9sZGFwOi8vY2VydDg2My5jZmNhLmNvbS5jbjozODkvQ049Y3JsMTA0XzEwNjgyLE9VPUNSTCxPPUNGQ0EgT3BlcmF0aW9uIENBMixDPUNOP2NlcnRpZmljYXRlUmV2b2NhdGlvbkxpc3Q/YmFzZT9vYmplY3RjbGFzcz1jUkxEaXN0cmlidXRpb25Qb2ludDATBgMqVgEEDBMKeWVlcGF5LmNvbTANBgkqhkiG9w0BAQUFAAOBgQBoIXByRAavrQaQ4blG0X6+n0Z6IOhdhkabLWobkK49l3Fhv2KuUsU+4vNCFa99cDWPKaV+IlNpk29f1i849GXPefAiWMCFggZkJOxUIdJU6gm8OZCEtteCiTq1Z8M6ywktM5Jmm5/y/aYeKSbHNcHMbIbs+BrS6IkZUssl4S1mcTGB4zCB4AIBATA+MCoxCzAJBgNVBAYTAkNOMRswGQYDVQQKExJDRkNBIE9wZXJhdGlvbiBDQTICEF2FbCYInongjsU5cO39BcswCQYFKw4DAhoFADANBgkqhkiG9w0BAQEFAASBgIofpjb5nRY27LpBTVt9hmMekhHlrmAX6JFmYmHOaTalGMi57B1HloP3nT2JzKj5VH5O0XHLo2zq6ejdGI8yHhnEHBW2VK17A4WKm8AppFosqT4X1UsLndnzOqfTjuQgeOwEOldYX0F5mYbRMo9TV7jkZiUv7/648nR47D7RAhFj";
		boolean code = signService.verifySign(verifyXml, sign);
		System.out.println(code);
	}*/
	
    @Test
    public void returnSuccessToYeepay(){
//        String url = UrlHelper.bulidGatewayUrl(ServiceType.TO_ENTERPRISE_REGISTER);
        try {
            HttpHelper.doPost("https://member.yeepay.com/member/bha/toEnterpriseRegister","SUCCESS");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
