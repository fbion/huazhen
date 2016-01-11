package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.AgentAdviser;
import com.hzfh.api.customer.model.query.AgentAdviserCondition;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.fmp.facade.customer.AgentAdviserFacade;
import com.hzfh.fmp.model.customer.view.AgentAdviserView;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzframework.contract.PagedList;
import net.hydromatic.linq4j.Linq4j;
import net.hydromatic.linq4j.function.EqualityComparer;
import net.hydromatic.linq4j.function.Function1;
import net.hydromatic.linq4j.function.Function2;

import java.util.List;

public class AgentAdviserModel {
    public static PagedList<AgentAdviser> getPagingList(AgentAdviserCondition agentAdviserCondition) {
        return AgentAdviserFacade.getPagingList(agentAdviserCondition);
    }

    public static int add(AgentAdviser agentAdviser) {
        return AgentAdviserFacade.add(agentAdviser);
    }

    public static int update(AgentAdviser agentAdviser) {
        return AgentAdviserFacade.update(agentAdviser);
    }
    
    public static int updateTradeTotalById(int id, double tradeTotal) {
        return AgentAdviserFacade.updateTradeTotalById(id, tradeTotal);
    }

    public static List<AgentAdviser> getList() {
        return AgentAdviserFacade.getList();
    }

    public static AgentAdviser getInfo(int id) {
        return AgentAdviserFacade.getInfo(id);
    }

    public static List<AgentAdviser> getMyAgentAdviser(String workMateString) {
        return AgentAdviserFacade.getMyAgentAdviser(workMateString);
    }
    
    public static List<AgentAdviser> getNoPagingList(AgentAdviserCondition agentAdviserCondition) {
        return AgentAdviserFacade.getNoPagingList(agentAdviserCondition);
    }

    public static List<AgentAdviser> getListForExcelT(AgentAdviserCondition agentAdviserCondition){
        return AgentAdviserFacade.getListForExcel(agentAdviserCondition);
    }
    
    
    public static List<AgentAdviserView> getListForExcel(AgentAdviserCondition agentAdviserCondition) {
        List<AgentAdviser> AgentAdviserList = getNoPagingList(agentAdviserCondition);
   
   		List<Employee> empList = EmployeeModel.getList();

        List<AgentAdviserView> agentAdviserViewViewList = Linq4j.asEnumerable(AgentAdviserList)
                .join(
                		Linq4j.asEnumerable(empList),
                        new Function1<AgentAdviser, Integer>() {
                            @Override
                            public Integer apply(AgentAdviser adviser) {
                                return adviser.getManagerNo();
                            }
                        },
                        new Function1<Employee, Integer>() {
                            @Override
                            public Integer apply(Employee o) {
                                return o.getUserNo();
                            }
                        },
                        new Function2<AgentAdviser, Employee, AgentAdviserView>() {
                            @Override
                            public AgentAdviserView apply(AgentAdviser agentAdviser, Employee e) {
                            	AgentAdviserView agentAdviserView = new AgentAdviserView(agentAdviser);
                                if (e != null)
                                	agentAdviserView.setManageString(e.getName());
                                return agentAdviserView;
                            }
                        },
                        new EqualityComparer<Integer>() {
                            @Override
                            public boolean equal(Integer aByte, Integer aByte2) {
                                return aByte == aByte2;
                            }

                            @Override
                            public int hashCode(Integer aByte) {
                                return 0;
                            }
                        }, false, true
                     )
                     .toList();
        
        
        return agentAdviserViewViewList;
    }
    
    
    

    
    
}
