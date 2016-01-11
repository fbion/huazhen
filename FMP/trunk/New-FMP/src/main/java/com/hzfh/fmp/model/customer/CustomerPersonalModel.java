package com.hzfh.fmp.model.customer;

import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.query.CustomerPersonalCondition;
import com.hzfh.fmp.facade.customer.CustomerPersonalFacade;
import com.hzfh.fmp.model.common.helper.EncodeHelper;
import com.hzframework.contract.PagedList;

import java.util.List;

public class CustomerPersonalModel {

    public static CustomerPersonal getInfo(int id) {
        CustomerPersonal customerPersonal = CustomerPersonalFacade.getInfo(id);

        return decryptDES(customerPersonal);
    }


    public static PagedList<CustomerPersonal> getPagingList(CustomerPersonalCondition customerPersonalCondition) {
        PagedList<CustomerPersonal> customerPersonalPagedList = CustomerPersonalFacade.getPagingList(customerPersonalCondition);
        for(CustomerPersonal customerPersonal:customerPersonalPagedList.getResultList()){
            decryptDES(customerPersonal);
        }
        return customerPersonalPagedList;
    }

    public static int add(CustomerPersonal customerPersonal) {
        return CustomerPersonalFacade.add(customerPersonal);
    }

    public static int update(CustomerPersonal customerPersonal) {
        //write Log by  Zorro
        ChangeManagerLogModel.addChangeManagerLog(customerPersonal);
        return CustomerPersonalFacade.update(customerPersonal);
    }

    public static List<CustomerPersonal> getList() {
        List<CustomerPersonal> customerPersonalList = CustomerPersonalFacade.getList();
        for(CustomerPersonal customerPersonal:customerPersonalList){
            decryptDES(customerPersonal);
        }
        return customerPersonalList;
    }



    public static CustomerPersonal decryptDES(CustomerPersonal customerPersonal){
        if(customerPersonal.getCardNumber()!=null&&customerPersonal.getCardNumber().split("-")[0].equalsIgnoreCase("m")){
            customerPersonal.setCardNumber(EncodeHelper.decryptDES(customerPersonal.getCardNumber().split("-")[1]));
        }
        if(customerPersonal.getCellphone1()!=null&&customerPersonal.getCellphone1().split("-")[0].equalsIgnoreCase("m")){
            customerPersonal.setCellphone1(EncodeHelper.decryptDES(customerPersonal.getCellphone1().split("-")[1]));
        }
        if(customerPersonal.getCellphone2()!=null&&customerPersonal.getCellphone2().split("-")[0].equalsIgnoreCase("m")){
            customerPersonal.setCellphone2(EncodeHelper.decryptDES(customerPersonal.getCellphone2().split("-")[1]));
        }
        if(customerPersonal.getPhone()!=null&&customerPersonal.getPhone().split("-")[0].equalsIgnoreCase("m")){
            customerPersonal.setPhone(EncodeHelper.decryptDES(customerPersonal.getPhone().split("-")[1]));
        }
        return customerPersonal;
    }

    public static List<CustomerPersonal> getMyCustomerCompanyList(String workMateString) {
        List<CustomerPersonal> customerPersonalList = CustomerPersonalFacade.getMyCustomerPersonalList(workMateString);
        for(CustomerPersonal customerPersonal:customerPersonalList){
            decryptDES(customerPersonal);
        }
        return customerPersonalList;
    }

    public static List<CustomerPersonal> cardCheck(String cardNumber, int id,String desCardNumber) {
        List<CustomerPersonal> customerPersonalList = CustomerPersonalFacade.cardCheck(cardNumber, id, desCardNumber);

        for(CustomerPersonal customerPersonal:customerPersonalList){
            decryptDES(customerPersonal);
        }
        return customerPersonalList;
    }


    public static List<CustomerPersonal> getNoPagingList(CustomerPersonalCondition customerPersonalCondition) {
        List<CustomerPersonal> customerPersonalList = CustomerPersonalFacade.getNoPagingList(customerPersonalCondition);

        for(CustomerPersonal customerPersonal:customerPersonalList){
            decryptDES(customerPersonal);
        }
        return customerPersonalList;
    }
    public static List<CustomerPersonal> getListForExcelT(CustomerPersonalCondition customerPersonalCondition) {
        List<CustomerPersonal> customerPersonalList = CustomerPersonalFacade.getListForExcel(customerPersonalCondition);

        for(CustomerPersonal customerPersonal:customerPersonalList){
            decryptDES(customerPersonal);
        }
        return customerPersonalList;
    }

    public static List<CustomerPersonal> checkCustomerPersonalByNameAndCellphone(int id, String name, String cellPhone,String desCellPhone) {
    List<CustomerPersonal> customerPersonalList = CustomerPersonalFacade.checkCustomerPersonalByNameAndCellphone(id, name, cellPhone,desCellPhone);
        for(CustomerPersonal customerPersonal:customerPersonalList){
            decryptDES(customerPersonal);
        }
        return customerPersonalList;
    }


    public static List<CustomerPersonal> getCustomerPersonalListByManagerNo(int managerNo) {
        List<CustomerPersonal> customerPersonalList = CustomerPersonalFacade.getCustomerPersonalListByManagerNo(managerNo);

        for(CustomerPersonal customerPersonal:customerPersonalList){
            decryptDES(customerPersonal);
        }
        return customerPersonalList;
    }

    public static int updateTradeTotalById(int id, double tradeTotal) {
        return CustomerPersonalFacade.updateTradeTotalById(id, tradeTotal);
    }

    public static CustomerPersonal getInfoByP2pCustsomerNo(int p2pCustomerNo){
        return CustomerPersonalFacade.getInfoByP2pCustsomerNo(p2pCustomerNo);
    }

    public static List<CustomerPersonal> getCurrentWeekCustomerPerson(CustomerPersonalCondition customerPersonalCondition){
        return CustomerPersonalFacade.getCurrentWeekCustomerPerson(customerPersonalCondition);
    }

}
