import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.query.P2pProductCondition;
import com.hzfh.api.product.service.P2pProductService;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/13.
 */
public class P2pProductTest {
        @Test
        public void getPagingListTest() throws MalformedURLException {
            /*String url = "http://productservice.hzfh.com:8080/service-product/p2pProduct";
            HessianProxyFactory factory = new HessianProxyFactory();
            P2pProductService p2pProductService = (P2pProductService) factory.create(P2pProductService.class, url);*/

            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            P2pProductService p2pProductService = (P2pProductService) context.getBean("p2pProductService");

            P2pProductCondition p2pProductCondition = new P2pProductCondition();

            p2pProductCondition.setPageIndex(1);
            p2pProductCondition.setPageSize(100);
//            p2pProductCondition.setByStartRepayIssue("2015-03-10");
//            p2pProductCondition.setByEndRepayIssue("2016-07-31");
            p2pProductCondition.setStartTime("2015-11-01");
            p2pProductCondition.setEndTime("2015-11-06");
            List<SortItem> sortItemList = new ArrayList<SortItem>();
            SortItem sortItem1 = new SortItem();
            sortItem1.setSortFeild("id");
            sortItem1.setSortType(SortType.DESC);
            sortItemList.add(sortItem1);

            p2pProductCondition.setSortItemList(sortItemList);

            PagedList<P2pProduct> p2pProductPagedList = p2pProductService
                    .getPagingList(p2pProductCondition);
            System.out.println("getPagingListTest=" + p2pProductPagedList.getResultList().size());
            for (P2pProduct p2pProduct : p2pProductPagedList.getResultList()) {
                System.out.println(p2pProduct.getId()+""+p2pProduct.getName());
            }
    }

    @Test
    public void getP2pProductByStatus() throws MalformedURLException {
//        String url = "http://productservice.hzfh.com:8080/service-product/p2pProduct";
//        HessianProxyFactory factory = new HessianProxyFactory();
//        P2pProductService p2pProductService = (P2pProductService) factory.create(P2pProductService.class, url);
        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
        P2pProductService p2pProductService = (P2pProductService) context.getBean("p2pProductService");
        List<P2pProduct> p2pProductList = p2pProductService.getP2pProductByStatus((byte) 30);
        System.out.print(p2pProductList.size());


    }
    @Test
    public void getP2pProductByProductNoTest(){
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        P2pProductService p2pProductService = (P2pProductService) context.getBean("p2pProductService");
        System.out.println(p2pProductService.getP2pByProductNo(111).getName());
    }

    @Test
    public void getP2pByProductNo(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        P2pProductService p2pProductService = (P2pProductService) context.getBean("p2pProductService");
        P2pProduct p2pProduct = p2pProductService.getP2pByProductNo(87);
        System.out.println(p2pProduct.getId());
    }
    @Test
    public void updateLogpPathById(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        P2pProductService p2pProductService = (P2pProductService) context.getBean("p2pProductService");
        int p2pProduct = p2pProductService.updateLogpPathById(83, "1");
    }
    @Test
    public void updateStatusByIdTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        P2pProductService p2pProductService = (P2pProductService) context.getBean("p2pProductService");
        System.out.print(p2pProductService.updateStatusById(39,(byte)30));
    }
}
