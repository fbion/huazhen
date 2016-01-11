import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.customer.model.AgentBusiness;
import com.hzfh.api.customer.model.query.AgentBusinessCondition;
import com.hzfh.api.customer.service.ActivityAwardRelationService;
import com.hzfh.api.customer.service.AgentBusinessService;
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


public class AgentBusinessTest {
	@Test
	public void agentBusinessTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AgentBusinessService Business=(AgentBusinessService) context.getBean("agentBusinessService");
		List<AgentBusiness> list=Business.getList();
		for(AgentBusiness agent:list){
			System.out.println(agent.getName()+"=======>>>>"+agent.getManagerNo());
		}
	}
	
	
	
	@Test
	public void getPagingList() throws MalformedURLException{
		String url = "http://localhost:8080/service-customer/agentBusiness";
        HessianProxyFactory factory = new HessianProxyFactory();
        AgentBusinessService agentBusinessService = (AgentBusinessService) factory.create(AgentBusinessService.class, url);
        AgentBusinessCondition agentBusinessCondition = new AgentBusinessCondition();
        agentBusinessCondition.setPageIndex(1);
        agentBusinessCondition.setPageSize(10);
        agentBusinessCondition.setTotalCount(3);
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
        agentBusinessCondition.setWorkMateString(workMateString);
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
        agentBusinessCondition.setSortItemList(sortItemList);

        PagedList<AgentBusiness> agentBusinessPagedList = agentBusinessService.getPagingList(agentBusinessCondition);
        System.out.println("getPagingListTest");
        for (AgentBusiness agentBusiness : agentBusinessPagedList.getResultList())
        {
            System.out.println(agentBusiness.getId()+":=======>"+agentBusiness.getName()+
            		":=======>"+agentBusiness.getCode()+
            		":=======>"+agentBusiness.getManagerNo());
        }
	}

    @Test
    public void getMyAgentBusiness(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AgentBusinessService agentBusinessService = (AgentBusinessService) context.getBean("agentBusinessService");
        List<Integer> workmate = new ArrayList<Integer>();
        workmate.add(115);
        String workMateString = StringHelper.listToString(workmate);
        List<AgentBusiness> agentBusinessList = agentBusinessService.getMyAgentBusiness(workMateString);
        for(AgentBusiness agentBusiness:agentBusinessList){
            System.out.println(agentBusiness.getName());
        }
    }
    @Test
    public void updateTradeTotalById(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AgentBusinessService agentBusinessService = (AgentBusinessService) context.getBean("agentBusinessService");
        agentBusinessService.updateTradeTotalById(53,53);
    }
    @Test
    public void updateTradeTotalByIds(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ActivityAwardRelationService agentBusinessService = (ActivityAwardRelationService) context.getBean("activityAwardRelationService");
        agentBusinessService.updateCidById(5, 1);
    }
	
	
	
}
