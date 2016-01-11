import com.hzfh.api.product.model.Product;
import com.hzfh.api.product.service.ProductService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by paul on 14-12-23.
 */
public class ProductTask {
	@Test
	public void updateRemain(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductService productService = (ProductService) context.getBean("productService");
		Product product = new Product();
		product.setId(1);
		product.setRemainAmount(2000);
		product.setRemainSmall(1);
		int i = productService.updateRemain(product);
		if(i>0)
			System.out.println(i);
		
		System.out.println("认购成功！");
		Product product2 =productService.getInfo(product.getId());
		System.out.println(product2.getRemainAmount()+"====>>>"+product2.getRemainSmall());
	}
	
	@Test
	public void updateReRemain(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductService productService = (ProductService) context.getBean("productService");
		Product product = new Product();
		product.setId(1);
		product.setRemainAmount(2000);
		product.setRemainSmall(1);
		int i = productService.updateReRemain(product);
		if(i>0)
			System.out.println(i);
		System.out.println("已退款！");
		Product product2 =productService.getInfo(product.getId());
		System.out.println(product2.getRemainAmount()+"====>>>"+product2.getRemainSmall());
		
	}
	
	
	
}
