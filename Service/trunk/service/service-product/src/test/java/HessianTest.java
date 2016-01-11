import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.query.P2pProductCondition;
import com.hzfh.api.product.service.P2pProductService;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 14-12-24.
 */
public class HessianTest {
    @Test
    public void hessianTest() throws MalformedURLException {//main(String[] args) throws MalformedURLException {
        //String url = "http://localhost:8080/hessian/productQuery";
    	//http://productservice.hzfh.com:8080/service-product/p2pProduct
        String url = "http://productservice.hzfh.com:8080/service-product/p2pProduct";
        
        HessianProxyFactory factory = new HessianProxyFactory();
        P2pProductService p2pProductService = (P2pProductService) factory.create(P2pProductService.class, url);

        P2pProductCondition p2pProductCondition = new P2pProductCondition();

		p2pProductCondition.setPageIndex(1);
		p2pProductCondition.setPageSize(10);
		p2pProductCondition.setTotalCount(3);
//		p2pProductCondition.setByStatus(0);
		p2pProductCondition.setByProductName("E");
//		p2pProductCondition.setByStatus(0);
		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem1 = new SortItem();
		sortItem1.setSortFeild("id");
		sortItem1.setSortType(SortType.DESC);
		sortItemList.add(sortItem1);

		p2pProductCondition.setSortItemList(sortItemList);

		PagedList<P2pProduct> p2pProductPagedList = p2pProductService
				.getPagingList(p2pProductCondition);
		System.out.println("getPagingListTest");
		for (P2pProduct p2pProduct : p2pProductPagedList.getResultList()) {
			System.out.println(p2pProduct.getId()+""+p2pProduct.getName());
		}
//        List<Product> productList = productService.getList();
//
//        for (Product product : productList)
//        {
//            System.out.println(product.getId()+":"+product.getName()+":"+product.getCode());
//        }

//        Product product = new Product();
//        product.setCode("ads");
//        product.setName("阿啊啊");
//        productService.add(product);
      
    }
}
