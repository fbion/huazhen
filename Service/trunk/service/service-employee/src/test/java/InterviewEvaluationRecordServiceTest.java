import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.employee.model.EmployeeInformation;
import com.hzfh.api.employee.model.InterviewEvaluationRecord;
import com.hzfh.api.employee.model.query.EmployeeInformationCondition;
import com.hzfh.api.employee.model.query.InterviewEvaluationRecordCondition;
import com.hzfh.api.employee.service.EmployeeInformationService;
import com.hzfh.api.employee.service.InterviewEvaluationRecordService;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/31.
 */
public class InterviewEvaluationRecordServiceTest {

    @Test
    public void getPagingListTest() throws  Exception{
//        String url =
//                "http://employeeservice.hzfh.com:8080/service-employee/employeeInformation";
//        HessianProxyFactory factory = new HessianProxyFactory();
//        EmployeeInformationService employeeInformationService = (EmployeeInformationService)factory.create(EmployeeInformationService.class, url);
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        InterviewEvaluationRecordService interviewEvaluationRecordService  = (InterviewEvaluationRecordService) context.
                getBean("interviewEvaluationRecordService");

        InterviewEvaluationRecordCondition interviewEvaluationRecordCondition = new InterviewEvaluationRecordCondition();

        interviewEvaluationRecordCondition.setPageIndex(1);
        interviewEvaluationRecordCondition.setPageSize(2);
        interviewEvaluationRecordCondition.setTotalCount(9);

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem1 = new SortItem();
        sortItem1.setSortFeild("id");
        sortItem1.setSortType(SortType.DESC);
        sortItemList.add(sortItem1);
        interviewEvaluationRecordCondition.setSortItemList(sortItemList);
        interviewEvaluationRecordCondition.setRetestUserNo(8);
        PagedList<InterviewEvaluationRecord> interviewEvaluationRecordPagedList =
                interviewEvaluationRecordService.getPagingList(interviewEvaluationRecordCondition);
        for(InterviewEvaluationRecord interviewEvaluationRecord:interviewEvaluationRecordPagedList.getResultList()){
            System.out.println(interviewEvaluationRecord.getId());
        }
    }
}
