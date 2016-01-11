/**
 * Created by Administrator on 2015/4/15.
 */

import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.baseInfo.model.Letter;
import com.hzfh.api.baseInfo.model.query.LetterCondition;
import com.hzfh.api.baseInfo.service.LetterService;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.misc.Sort;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LetterServiceTest {
    @Test
    public void getListLimitTest() throws Exception{

//        String url =
//                "http://baseinfoservice.hzfh.com:8080/service-baseInfo/letter";
//        HessianProxyFactory factory = new HessianProxyFactory();
//        LetterService letterService = (LetterService)factory.create(LetterService.class, url);

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        LetterService letterService = (LetterService) context.getBean("letterService");
        List<Letter> letterList  = letterService.getListLimitByEmpId(8);
        System.out.println(letterList.size());
    }
    @Test
    public void getListByTimeTest() throws Exception{

//        String url =
//                "http://baseinfoservice.hzfh.com:8080/service-baseInfo/letter";
//        HessianProxyFactory factory = new HessianProxyFactory();
//        LetterService letterService = (LetterService)factory.create(LetterService.class, url);

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        LetterService letterService = (LetterService) context.getBean("letterService");
        List<Letter> letterList  = letterService.getListByTime();
        System.out.println(letterList.size());
    }
    @Test
    public void getListTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        LetterService letterService = (LetterService) context.getBean("letterService");
        List<Letter> letterList = letterService.getList();
        System.out.println(letterList.size());
    }
    @Test
    public void getInfoTest() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        LetterService letterService = (LetterService) context.getBean("letterService");

        Letter letter = letterService.getInfo(2);
        System.out.println(letter);
    }
//    @Test
//    public void updateIsReadByIdTest(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        LetterService letterService = (LetterService) context.getBean("letterService");
//        int result = letterService.updateIsReadById(4);
//        System.out.println(result);
//    }
    @Test
    public void updateSolveTimeByIdTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        LetterService letterService = (LetterService) context.getBean("letterService");
        Letter letter = new Letter();
        letter.setId(39);
        letter.setSolvePlan("12456");
        letter.setSolveUserNo(2);
        letter.setInUserNo(3);
        int result = letterService.updateSolve(letter);
        System.out.println(result);
    }
    @Test
    public void updateCloseTimeByIdTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        LetterService letterService = (LetterService) context.getBean("letterService");
        Letter letter = new Letter();
        letter.setId(2);
        letter.setCloseUserNo(3);
        int result = letterService.updateClose(letter);
        System.out.println(result);
    }
    @Test
    public void addTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        LetterService letterService = (LetterService) context.getBean("letterService");
        Letter letter = new Letter();
        letter.setRecipient(2);
        letter.setEditUserNo(3);
        letter.setCloseUserNo(2);
        letter.setContent("22546");
        letter.setImportantDegree(2);
        letter.setIsRead((byte) 0);
        letter.setLevel((byte) 2);
        letter.setSendDeplicate(2);
        letter.setStatus(0);
        letter.setSubject("aaa");
        letter.setType((byte) 1);
        letter.setInUserNo(0);
        letter.setExpectFinishTime(new Date());
        letter.setEditComment("sdfgv");
        int result = letterService.add(letter);
        System.out.println(result);
    }
    @Test
    public void updateTest() throws Exception{
        String url =
                "http://baseinfoservice.hzfh.com:8080/service-baseInfo/letter";
        HessianProxyFactory factory = new HessianProxyFactory();
        LetterService letterService = (LetterService)factory.create(LetterService.class, url);

//                ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        LetterService letterService = (LetterService) context.getBean("letterService");
        Letter letter = new Letter();
        letter.setRecipient(2);
        letter.setEditUserNo(3);
        letter.setCloseUserNo(2);
        letter.setContent("22546");
        letter.setImportantDegree(10);
        letter.setIsRead((byte)0);
        letter.setLevel((byte)2);
        letter.setSendDeplicate(2);
        letter.setStatus(0);
        letter.setSubject("aaa");
        letter.setType((byte)1);
        letter.setInUserNo(0);
        letter.setEditComment("sdfgv");
        letter.setSolvePlan("1dsc");
        letter.setId(2);
        int result = letterService.update(letter);
        System.out.println(result);
    }
    @Test
    public void getPagingListTest() throws Exception {
        String url =
                "http://baseinfoservice.hzfh.com:8080/service-baseInfo/letter";
        HessianProxyFactory factory = new HessianProxyFactory();

        LetterService letterService = (LetterService)factory.create(LetterService.class, url);
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        LetterService letterService = (LetterService) context.getBean("letterService");
        LetterCondition letterCondition = new LetterCondition();
        letterCondition.setEmpId(176);
        letterCondition.setType("2,3");
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild("id");
        sortItem.setSortType(SortType.DESC);
        sortItemList.add(sortItem);
        letterCondition.setSortItemList(sortItemList);
        PagedList<Letter> letterPagedList = letterService.getPagingList(letterCondition);
        for (Letter letter : letterPagedList.getResultList()) {
            System.out.println(letter.getId() + ":"
                    + letter.getStatus());
        }
    }
}
