import com.hzfh.api.baseInfo.model.CodeAdviser;
import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.baseInfo.model.query.DicDataCondition;
import com.hzfh.api.baseInfo.service.CodeAdviserService;
import com.hzfh.api.baseInfo.service.DicDataService;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by paul on 14-12-23.
 */
public class BaseinfoServiceTest {
    @Test
    public void getListTest()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DicDataService dicDataService = (DicDataService) context.getBean("dicDataService");

        List<DicData> dicDataList = dicDataService.getList();

        System.out.println("getListTest");
        for (DicData dicData : dicDataList)
        {
            System.out.println(dicData.getId()+":"+dicData.getDicTypeNo()+":"+dicData.getValue());
        }
    }

    @Test
    public void getPagingListTest() {
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DicDataService dicDataService = (DicDataService) context.getBean("dicDataService");

        DicDataCondition dicDataCondition = new DicDataCondition();
        //productCondition.setId(1);
        dicDataCondition.setPageIndex(1);
        dicDataCondition.setPageSize(2);

        dicDataCondition.setTotalCount(5);

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem1 = new SortItem();
        sortItem1.setSortFeild("name");
        sortItem1.setSortType(SortType.DESC);
        sortItemList.add(sortItem1);

        SortItem sortItem2 = new SortItem();
        sortItem2.setSortFeild("code");
        sortItem2.setSortType(SortType.DESC);
        sortItemList.add(sortItem2);

        dicDataCondition.setSortItemList(sortItemList);

        PagedList<DicData> dicDataPagedList = dicDataService.getPagingList(dicDataCondition);
        System.out.println("getPagingListTest");
        for (DicData dicData : dicDataPagedList.getResultList())
        {
            System.out.println(dicData.getId()+":"+dicData.getValue()+":"+dicData.getCode());
        }
    }

    @Test
    public void getInfoTest(){
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DicDataService dicDataService = (DicDataService) context.getBean("dicDataService");
        
        DicData dicDate = dicDataService.getInfo(1);

        System.out.println("getInfoTest");
        System.out.println(dicDate.getId()+":"+dicDate.getValue()+":"+dicDate.getCode());
    }

    @Test
    public void addTest(){
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DicDataService dicDataService = (DicDataService) context.getBean("dicDataService");

        DicData dicData= new DicData();
        dicData.setDicTypeNo(9);
        dicData.setCode((byte)1);
        dicData.setValue("字典的值");
        int id = dicDataService.add(dicData);

        System.out.println("addTest");
        System.out.println(id);
    }

    @Test
    public void updateTest(){
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DicDataService dicDataService = (DicDataService) context.getBean("dicDataService");

        DicData dicData= new DicData();
        dicData.setValue("name33312211这个字典的值出现了");
        dicData.setCode((byte)2);
        dicData.setId(1);

        int ret = dicDataService.update(dicData);

        System.out.println(ret);
    }

    @Test
    public void deleteTest(){
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DicDataService dicDataService = (DicDataService) context.getBean("dicDataService");
        int ret = dicDataService.delete(5);
        System.out.println(ret);
    }
    
    
    @Test
    public void getDicDataByTypeListTest(){
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DicDataService dicDataService = (DicDataService) context.getBean("dicDataService");
        List<DicData> dicDatalist = dicDataService.getDicDataListByType(2);
        for (DicData dic : dicDatalist) {
        	  System.out.println(dic.getCode()+"=====>"+dic.getValue());
		}
    }
    
    @Test
    public void baseInfo(){
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CodeAdviserService dicDataService = (CodeAdviserService) context.getBean("codeAdviserService");
        dicDataService.add(new CodeAdviser());
        
        int code = dicDataService.getList().get(0).getId();
        Date t = dicDataService.getList().get(0).getInTime();
        System.out.println(code+"=======>>>>"+t);
      
    }
    
    
}
