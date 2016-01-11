import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.market.model.WinningRecord;
import com.hzfh.api.market.model.query.WinningRecordCondition;
import com.hzfh.api.market.service.WinningRecordService;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;


public class WinningRecordServiceTest {
	@Test
	public  void getWinningRecordPagedListTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		WinningRecordService winningRecordService = (WinningRecordService) context.getBean("winningRecordService");
		
		WinningRecordCondition winningRecordCondition = new WinningRecordCondition();
        winningRecordCondition.setPageSize(10);
        winningRecordCondition.setPageIndex(1);

        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild("id");
        sortItem.setSortType(SortType.DESC);
        sortItemList.add(sortItem);
        winningRecordCondition.setSortItemList(sortItemList);
        
        
//        winningRecordCondition.setUserName();
        PagedList<WinningRecord> winningRecordPagedList = winningRecordService.getPagingList(winningRecordCondition);
        for(WinningRecord winningRecord : winningRecordPagedList.getResultList()){
        	System.out.println(winningRecord.getId());
        }
        System.out.println(winningRecordPagedList.getResultList().size());
	}
	
	@Test
	public void updateTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		WinningRecordService winningRecordService = (WinningRecordService) context.getBean("winningRecordService");
		
		WinningRecord winningRecord = new WinningRecord();
		winningRecord.setId(1632);
		winningRecord.setIsAward(1);
		
		System.out.println(winningRecordService.update(winningRecord));
	}
}
