import com.hzfh.api.customer.model.AgentAdviser;
import com.hzfh.api.customer.model.query.AgentAdviserCondition;
import com.hzfh.api.customer.service.AgentAdviserService;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import com.hzframework.helper.StringHelper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/2/13.
 */
public class AgentAdviserTest {
    @Test
    public void getMyAgentAdviser(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AgentAdviserService agentAdviserService = (AgentAdviserService) context.getBean("agentAdviserService");
        List<Integer> workmate = new ArrayList<Integer>();
        workmate.add(115);
        String workMateString = StringHelper.listToString(workmate);
        AgentAdviserCondition tAgentAdviserCondition= new AgentAdviserCondition();
        tAgentAdviserCondition.setRelationLevel((byte)3);
        List<SortItem> sortItemList = new ArrayList<SortItem>();
        SortItem sortItem = new SortItem();
        sortItem.setSortFeild("id");
        sortItem.setSortType(SortType.DESC);
        sortItemList.add(sortItem);
        tAgentAdviserCondition.setSortItemList(sortItemList);
        List<AgentAdviser> agentAdviserList = agentAdviserService.getNoPagingList(tAgentAdviserCondition);
        System.out.println(agentAdviserList.size());
        /*for(AgentAdviser agentAdviser:agentAdviserList){
            System.out.println(agentAdviser.getName());
        }*/
    }
    @Test
    public void updateTradeTotalById(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AgentAdviserService agentAdviserService = (AgentAdviserService) context.getBean("agentAdviserService");
        agentAdviserService.updateTradeTotalById(180, 180);
    }
}
