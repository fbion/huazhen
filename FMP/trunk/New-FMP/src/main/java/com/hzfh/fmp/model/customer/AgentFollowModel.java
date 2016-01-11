package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.AgentFollow;
import com.hzfh.api.customer.model.query.AgentFollowCondition;
import com.hzfh.fmp.facade.customer.AgentFollowFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class AgentFollowModel {
    public static PagedList<AgentFollow> getPagingList(AgentFollowCondition agentFollowCondition) {
        return AgentFollowFacade.getPagingList(agentFollowCondition);
    }

    public static int add(AgentFollow agentFollow) {
        return AgentFollowFacade.add(agentFollow);
    }

    public static int update(AgentFollow agentFollow) {
        return AgentFollowFacade.update(agentFollow);
    }

    public static List<AgentFollow> getList() {
        return AgentFollowFacade.getList();
    }

    public static AgentFollow getInfo(int id) {
        return AgentFollowFacade.getInfo(id);
    }
}
