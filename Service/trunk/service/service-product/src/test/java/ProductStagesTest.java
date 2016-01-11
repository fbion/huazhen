import com.hzfh.api.product.service.ProductStagesService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015/3/2.
 */
public class ProductStagesTest {

    @Test
    public void getProductStageIdTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductStagesService productStagesService = (ProductStagesService) context.getBean("productStagesService");
        int productNo = 24;
        int stagesNumber = 2;
        int result = productStagesService.getProductStageId(productNo,stagesNumber);
        System.out.print(result);
    }

    @Test
    public void  getProductMaxStageTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductStagesService productStagesService = (ProductStagesService) context.getBean("productStagesService");
        int productNo = 24;
        int result = productStagesService.getProductMaxStage(productNo);
        System.out.print(result);
    }

}
