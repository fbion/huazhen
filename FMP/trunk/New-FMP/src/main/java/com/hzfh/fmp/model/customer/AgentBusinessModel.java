package com.hzfh.fmp.model.customer;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.customer.model.AgentBusiness;
import com.hzfh.api.customer.model.query.AgentBusinessCondition;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.fmp.facade.customer.AgentBusinessFacade;
import com.hzfh.fmp.model.baseInfo.DicDataModel;
import com.hzfh.fmp.model.common.properties.DictionaryHelper;
import com.hzfh.fmp.model.customer.view.AgentBusinessView;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzframework.contract.PagedList;
import net.hydromatic.linq4j.Linq4j;
import net.hydromatic.linq4j.function.EqualityComparer;
import net.hydromatic.linq4j.function.Function1;
import net.hydromatic.linq4j.function.Function2;

import java.util.List;

public class AgentBusinessModel {
    public static PagedList<AgentBusiness> getPagingList(AgentBusinessCondition agentBusinessCondition) {
        return AgentBusinessFacade.getPagingList(agentBusinessCondition);
    }

    public static int add(AgentBusiness agentBusiness) {
        return AgentBusinessFacade.add(agentBusiness);
    }

    public static int update(AgentBusiness agentBusiness) {
        return AgentBusinessFacade.update(agentBusiness);
    }
    
    public static int updateTradeTotalById(int id, double tradeTotal) {
        return AgentBusinessFacade.updateTradeTotalById(id,tradeTotal);
    }
    
    public static List<AgentBusiness> getList() {
        return AgentBusinessFacade.getList();
    }

    public static AgentBusiness getInfo(int id) {
        return AgentBusinessFacade.getInfo(id);
    }

    public static List<AgentBusiness> getMyAgentBusiness(String workMateString) {
        return AgentBusinessFacade.getMyAgentBusiness(workMateString);
    }
    
    public static List<AgentBusiness> getNoPagingList(AgentBusinessCondition agentBusinessCondition) {
        return AgentBusinessFacade.getNoPagingList(agentBusinessCondition);
    }
    public static List<AgentBusiness> getListForExcelT(AgentBusinessCondition agentBusinessCondition) {
        return AgentBusinessFacade.getListForExcel(agentBusinessCondition );
    }
    public static List<AgentBusinessView> getListForExcel(AgentBusinessCondition agentBusinessCondition) {
        List<AgentBusiness> agentBusinessesList = getNoPagingList(agentBusinessCondition);

        List<DicData> relationTypeList = DicDataModel.getDicDataListByType(DictionaryHelper.DIC_TYPE_RELATION);
        	
        List<DicData> importanceTypeList = DicDataModel.getDicDataListByType(DictionaryHelper.DIC_TYPE_IMPORTANT);

   		List<Employee> empList = EmployeeModel.getList();

        List<AgentBusinessView> agentBusinessViewList = Linq4j.asEnumerable(agentBusinessesList)
                .join(
                		Linq4j.asEnumerable(relationTypeList),
                        new Function1<AgentBusiness, Byte>() {
                            @Override
                            public Byte apply(AgentBusiness agentBusiness) {
                                return agentBusiness.getRelationLevel();
                            }
                        },
                        new Function1<DicData, Byte>() {
                            @Override
                            public Byte apply(DicData o) {
                                return o.getCode();
                            }
                        },
                        new Function2<AgentBusiness, DicData, AgentBusinessView>() {
                            @Override
                            public AgentBusinessView apply(AgentBusiness agentBusiness, DicData dicData) {
                            	AgentBusinessView agentBusinessView = new AgentBusinessView(agentBusiness);
                                if (dicData != null)
                                	agentBusinessView.setRelationString(dicData.getValue());
                                return agentBusinessView;
                            }
                        },
                        new EqualityComparer<Byte>() {
                            @Override
                            public boolean equal(Byte aByte, Byte aByte2) {
                                return aByte == aByte2;
                            }

                            @Override
                            public int hashCode(Byte aByte) {
                                return 0;
                            }
                        }, false, true
                     )
                 .join(
                		 Linq4j.asEnumerable(empList),
                         new Function1<AgentBusinessView, Integer>() {
                             @Override
                             public Integer apply(AgentBusinessView agentBusinessView) {
                                 return agentBusinessView.getManagerNo();
                             }
                         },
                         new Function1<Employee, Integer>() {
                             @Override
                             public Integer apply(Employee o) {
                                 return o.getUserNo();
                             }
                         },
                         new Function2<AgentBusinessView, Employee, AgentBusinessView>() {
                             @Override
                             public AgentBusinessView apply(AgentBusinessView agentBusinessView, Employee e) {                   
                                 if (e != null)
                                	 agentBusinessView.setManageString(e.getName());
                                 return agentBusinessView;
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
                   .join(
                		 Linq4j.asEnumerable(importanceTypeList),
                         new Function1<AgentBusinessView, Byte>() {
                             @Override
                             public Byte apply(AgentBusinessView agentBusinessView) {
                                 return agentBusinessView.getContactImportance();
                             }
                         },
                         new Function1<DicData, Byte>() {
                             @Override
                             public Byte apply(DicData o) {
                                 return o.getCode();
                             }
                         },
                         new Function2<AgentBusinessView, DicData, AgentBusinessView>() {
                             @Override
                             public AgentBusinessView apply(AgentBusinessView agentBusinessView, DicData dicData) {                   
                                 if (dicData != null)
                                	 agentBusinessView.setImportanceString(dicData.getValue());
                                 return agentBusinessView;
                             }
                         },
                         new EqualityComparer<Byte>() {
                             @Override
                             public boolean equal(Byte aByte, Byte aByte2) {
                                 return aByte == aByte2;
                             }

                             @Override
                             public int hashCode(Byte aByte) {
                                 return 0;
                             }
                         }, false, true
                         )
                         .toList();
        
        return agentBusinessViewList;
    }
    
    
    
    public static List<AgentBusiness> getAgentBusinessListByManageNo(int mamageNo){
    	return AgentBusinessFacade.getAgentBusinessListByManageNo(mamageNo);	
    }
    
    
    
    
    
    
    
}
