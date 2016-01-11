package com.hzfh.fmp.model.sales;

import com.hzfh.api.sales.model.AgentRate;
import com.hzfh.api.sales.model.query.AgentRateCondition;
import com.hzfh.fmp.facade.sales.AgentRateFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class AgentRateModel {
    public static PagedList<AgentRate> getPagingList(AgentRateCondition agentRateCondition) {
        return AgentRateFacade.getPagingList(agentRateCondition);
    }

    public static int add(AgentRate agentRate) {
        return AgentRateFacade.add(agentRate);
    }

    public static int update(AgentRate agentRate) {
        return AgentRateFacade.update(agentRate);
    }

    public static List<AgentRate> getList() {
        return AgentRateFacade.getList();
    }

    public static AgentRate getInfo(int id) {
        return AgentRateFacade.getInfo(id);
    }

	public static AgentRate getAgentRate(AgentRate agentRate, long money) {
		return AgentRateFacade.getAgentRate(agentRate,money);
	}

	public static List<AgentRate> getAgentRateListByCondition(AgentRateCondition agentRateCondition) {
		return AgentRateFacade.getAgentRateListByCondition(agentRateCondition);
	}
    public static int delete(int id){
        return AgentRateFacade.delete(id);
    }
}
