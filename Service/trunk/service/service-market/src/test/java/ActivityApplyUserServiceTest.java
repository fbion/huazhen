
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.market.model.ActivityApplyUser;
import com.hzfh.api.market.model.query.ActivityApplyUserCondition;
import com.hzfh.api.market.service.ActivityApplyUserService;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;


public class ActivityApplyUserServiceTest {
	@Test
	public  void getLotteriesByRandTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ActivityApplyUserService activityApplyUserService = (ActivityApplyUserService) context.getBean("activityApplyUserService");
		ActivityApplyUser activityApplyUser = activityApplyUserService.getInfoByCellphone("13624985994",1);
		if(activityApplyUser == null){
			System.out.println("not found");
		}
		System.out.println(activityApplyUser.getId());
		
	}
	
	@Test
	public void getPagingListTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ActivityApplyUserService activityApplyUserService = (ActivityApplyUserService) context.getBean("activityApplyUserService");
		ActivityApplyUserCondition activityApplyUserCondition = new ActivityApplyUserCondition();
		List<SortItem> sortItemList = new ArrayList<SortItem>();
		SortItem sortItem = new SortItem();
		sortItem.setSortFeild("id");
		sortItem.setSortType(SortType.DESC);
		sortItemList.add(sortItem);
		activityApplyUserCondition.setSortItemList(sortItemList);
		activityApplyUserCondition.setPageIndex(1);
		activityApplyUserCondition.setPageSize(10);
		activityApplyUserCondition.setActivityNo(21);
		PagedList<ActivityApplyUser> pl = activityApplyUserService.getPagingList(activityApplyUserCondition);
		System.out.println(pl.getPagingInfo().getTotalCount());
		for(ActivityApplyUser activityApplyUser:pl.getResultList()){
			System.out.println(activityApplyUser.getId());
		}
	}

}
