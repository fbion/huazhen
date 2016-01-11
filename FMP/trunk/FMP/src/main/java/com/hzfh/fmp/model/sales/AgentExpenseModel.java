package com.hzfh.fmp.model.sales;

import com.hzfh.api.sales.model.AgentExpense;
import com.hzfh.api.sales.model.query.AgentExpenseCondition;
import com.hzfh.fmp.facade.sales.AgentExpenseFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class AgentExpenseModel {
    public static PagedList<AgentExpense> getPagingList(AgentExpenseCondition agentExpenseCondition) {
        return AgentExpenseFacade.getPagingList(agentExpenseCondition);
    }

    public static int add(AgentExpense agentExpense) {
        return AgentExpenseFacade.add(agentExpense);
    }

    public static int update(AgentExpense agentExpense) {
        return AgentExpenseFacade.update(agentExpense);
    }

    public static List<AgentExpense> getList() {
        return AgentExpenseFacade.getList();
    }

    public static AgentExpense getInfo(int id) {
        return AgentExpenseFacade.getInfo(id);
    }
}
