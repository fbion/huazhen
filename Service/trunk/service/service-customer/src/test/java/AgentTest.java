import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.customer.model.AgentAdviser;
import com.hzfh.api.customer.model.query.AgentAdviserCondition;
import com.hzfh.api.customer.service.AgentAdviserService;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;


public class AgentTest {
	@Test
	public void agentAdviserTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AgentAdviserService adviser=(AgentAdviserService) context.getBean("agentAdviserService");
		List<AgentAdviser> list=adviser.getList();
		for(AgentAdviser agent:list){
			System.out.println(agent.getName()+"=======>>>>"+agent.getManagerNo());
		}
	}
	
	
	
	@Test
	public void getPagingList() throws MalformedURLException{
		String url = "http://localhost:8080/service-customer/agentAdviser";
        HessianProxyFactory factory = new HessianProxyFactory();
        AgentAdviserService agentAdviserService = (AgentAdviserService) factory.create(AgentAdviserService.class, url);
        AgentAdviserCondition agentAdviserCondition = new AgentAdviserCondition();
        agentAdviserCondition.setPageIndex(1);
        agentAdviserCondition.setPageSize(10);
        agentAdviserCondition.setTotalCount(3);
        List workMate = new ArrayList();
        workMate.add(0, 1);
        workMate.add(1, 2);
        workMate.add(2, 3);
        workMate.add(3, 4);
        workMate.add(4, 5);
        workMate.add(5, 6);
        workMate.add(6, 7);
        workMate.add(7, 8);
        workMate.add(8, 9);
        String workMateString =StringHelper.listToString(workMate);
        agentAdviserCondition.setWorkMateString(workMateString);
        //System.out.println(workMate.toString());
        //agentAdviserCondition.setWorkMate(workMate);
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem1 = new SortItem();
        sortItem1.setSortFeild("name");
        sortItem1.setSortType(SortType.DESC);
        sortItemList.add(sortItem1);

        SortItem sortItem2 = new SortItem();
        sortItem2.setSortFeild("code");
        sortItem2.setSortType(SortType.DESC);
        sortItemList.add(sortItem2);
        agentAdviserCondition.setSortItemList(sortItemList);

        PagedList<AgentAdviser> agentAdviserPagedList = agentAdviserService.getPagingList(agentAdviserCondition);
        System.out.println("getPagingListTest");
        for (AgentAdviser agentAdviser : agentAdviserPagedList.getResultList())
        {
            System.out.println(agentAdviser.getId()+":=======>"+agentAdviser.getName()+
            		":=======>"+agentAdviser.getCode()+
            		":=======>"+agentAdviser.getManagerNo());
        }
	}
	
	
	
	
	
	
}
