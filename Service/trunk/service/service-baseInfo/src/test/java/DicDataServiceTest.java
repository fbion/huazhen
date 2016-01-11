import com.hzfh.api.baseInfo.model.City;
import com.hzfh.api.baseInfo.service.CityService;
import com.hzfh.api.baseInfo.service.DicDataService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2015/5/20.
 */
public class DicDataServiceTest {
    @Test
    public void getDicDataByTypeAndCode(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DicDataService dicDataService = (DicDataService) context.getBean("dicDataService");

        String result = dicDataService.getDicDataByTypeAndCode(9,1).getValue();
        System.out.println(result);
    }
}
