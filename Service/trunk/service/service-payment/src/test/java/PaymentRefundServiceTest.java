import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.payment.model.query.PaymentRefundCondition;
import com.hzfh.api.payment.service.PaymentRefundService;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2015/9/1.
 */
public class PaymentRefundServiceTest {

    @Test
    public void getPagingListTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        PaymentRefundService paymentRefundService = (PaymentRefundService) context
                .getBean("paymentRefundService");

        PaymentRefundCondition paymentRefundCondition = new PaymentRefundCondition();
        // productCondition.setId(1);
        paymentRefundCondition.setPageIndex(1);
        paymentRefundCondition.setPageSize(20);

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem1 = new SortItem();
        sortItem1.setSortFeild("id");
        sortItem1.setSortType(SortType.DESC);
        sortItemList.add(sortItem1);
        paymentRefundCondition.setSortItemList(sortItemList);

        paymentRefundCondition.setSalesNos("13213");
        PagedList<PaymentRefund> paymentRefundPagedList = paymentRefundService
                .getPagingList(paymentRefundCondition);
        System.out.println("getPagingListTest");
       System.out.println(paymentRefundPagedList.getResultList().size());
    }
    @Test
    public void cancelSendSmsByIdsTest() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        PaymentRefundService paymentRefundService = (PaymentRefundService) context
                .getBean("paymentRefundService");
        int a  = paymentRefundService.updatePayMoneyBySalesNoAndHonour(905,0);
    }
}
