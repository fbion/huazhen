import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.baseInfo.model.helper.SnEnum;
import com.hzfh.api.baseInfo.service.SnService;
import com.hzfh.p2p.model.common.helper.EncodeHelper;



public class SnTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");
		SnService snService = (SnService) context.getBean("snService");
		SnEnum snEnum = SnEnum.SN_ENTERPRISEREGISTER;
		String sn = snService.getSn(snEnum);
		System.out.println(sn);
	}
	@Test 
	public void testSn(){
		System.out.println(EncodeHelper.initKey("wangqk0824"));
	}

}
