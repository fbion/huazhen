package com.hzfh.fmp.model.customer;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.customer.model.CustomerCompany;
import com.hzfh.api.customer.model.query.CustomerCompanyCondition;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.fmp.facade.customer.CustomerCompanyFacade;
import com.hzfh.fmp.model.baseInfo.DicDataModel;
import com.hzfh.fmp.model.common.properties.DictionaryHelper;
import com.hzfh.fmp.model.customer.view.CustomerCompanyView;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzframework.contract.PagedList;
import net.hydromatic.linq4j.Linq4j;
import net.hydromatic.linq4j.function.EqualityComparer;
import net.hydromatic.linq4j.function.Function1;
import net.hydromatic.linq4j.function.Function2;

import java.util.List;

public class CustomerCompanyModel {
    public static PagedList<CustomerCompany> getPagingList(CustomerCompanyCondition customerCompanyCondition) {
        return CustomerCompanyFacade.getPagingList(customerCompanyCondition);
    }

    public static int add(CustomerCompany customerCompany) {
        return CustomerCompanyFacade.add(customerCompany);
    }

    public static int update(CustomerCompany customerCompany) {
        return CustomerCompanyFacade.update(customerCompany);
    }

    public static List<CustomerCompany> getList() {
        return CustomerCompanyFacade.getList();
    }

    public static CustomerCompany getInfo(int id) {
        return CustomerCompanyFacade.getInfo(id);
    }

    public static List<CustomerCompany> getMyCustomerCompanyList(String workMateString){
        return CustomerCompanyFacade.getMyCustomerCompanyList(workMateString);
    }

	public static List<CustomerCompany> cardCheck(String cardNumber,int id) {
		return CustomerCompanyFacade.cardCheck(cardNumber, id);
	}
	
	//create by Zorro 2014/4/30
	public static List<CustomerCompany> getNoPagingList(CustomerCompanyCondition customerCompanyCondition) {
        return CustomerCompanyFacade.getNoPagingList(customerCompanyCondition);
    }

    public static List<CustomerCompany> getListForExcelT(CustomerCompanyCondition customerCompanyCondition) {
        return CustomerCompanyFacade.getListForExcel(customerCompanyCondition);
    }
	public static List<CustomerCompanyView> getListForExcel(CustomerCompanyCondition customerCompanyCondition) {
        List<CustomerCompany> customerCompanyList = getNoPagingList(customerCompanyCondition);

        
        List<DicData> relationTypeList = DicDataModel.getDicDataListByType(DictionaryHelper.DIC_TYPE_RELATION);
        	
        List<DicData> riskTypeList = DicDataModel.getDicDataListByType(DictionaryHelper.DIC_TYPE_RISK);

   		List<Employee> empList = EmployeeModel.getList();

        List<CustomerCompanyView> customerCompanyViewList = Linq4j.asEnumerable(customerCompanyList)
        		.join(
                		 Linq4j.asEnumerable(relationTypeList),
                         new Function1<CustomerCompany, Byte>() {
                             @Override
                             public Byte apply(CustomerCompany customerCompany) {
                                 return customerCompany.getRelationLevel();
                             }
                         },
                         new Function1<DicData, Byte>() {
                             @Override
                             public Byte apply(DicData o) {
                                 return o.getCode();
                             }
                         },
                         new Function2<CustomerCompany, DicData, CustomerCompanyView>() {
                             @Override
                             public CustomerCompanyView apply(CustomerCompany customerCompany, DicData dicData) { 
                            	 CustomerCompanyView customerCompanyView = new CustomerCompanyView(customerCompany);
                                 if (dicData != null)
                                	 customerCompanyView.setRealtionName(dicData.getValue());
                                 return customerCompanyView;
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
                		 Linq4j.asEnumerable(riskTypeList),
                         new Function1<CustomerCompanyView, Byte>() {
                             @Override
                             public Byte apply(CustomerCompanyView CustomerCompanyView) {
                                 return CustomerCompanyView.getRelationLevel();
                             }
                         },
                         new Function1<DicData, Byte>() {
                             @Override
                             public Byte apply(DicData o) {
                                 return o.getCode();
                             }
                         },
                         new Function2<CustomerCompanyView, DicData, CustomerCompanyView>() {
                             @Override
                             public CustomerCompanyView apply(CustomerCompanyView CustomerCompanyView, DicData dicData) {                   
                                 if (dicData != null)
                                     CustomerCompanyView.setRiskName(dicData.getValue());
                                 return CustomerCompanyView;
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
                         new Function1<CustomerCompanyView, Integer>() {
                             @Override
                             public Integer apply(CustomerCompanyView CustomerCompanyView) {
                                 return CustomerCompanyView.getAgentNo();
                             }
                         },
                         new Function1<Employee, Integer>() {
                             @Override
                             public Integer apply(Employee o) {
                                 return o.getUserNo();
                             }
                         },
                         new Function2<CustomerCompanyView, Employee, CustomerCompanyView>() {
                             @Override
                             public CustomerCompanyView apply(CustomerCompanyView CustomerCompanyView, Employee e) {                   
                                 if (e != null)
                                     CustomerCompanyView.setManageName(e.getName());
                                 return CustomerCompanyView;
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
        
        
        return customerCompanyViewList;
    }

	public static int updateCustomerNoById(int customerNo, int id) {
		return CustomerCompanyFacade.updateCustomerNoById(customerNo, id);
	}

    public static int updateTradeTotalById(int id, double tradeTotal){
        return CustomerCompanyFacade.updateTradeTotalById(id, tradeTotal);
    }

    public static CustomerCompany getInfoByP2pCustomerNo(int p2pCustomerNo){
        return CustomerCompanyFacade.getInfoByP2pCustomerNo(p2pCustomerNo);
    }
	
	
	
	
	
	
	
}
