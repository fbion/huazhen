package com.hzfh.p2p.model.baseInfo;

import com.hzfh.api.baseInfo.model.Letter;
import com.hzfh.api.baseInfo.model.query.LetterCondition;
import com.hzfh.p2p.facade.baseInfo.LetterFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class LetterModel {
	
	 public static int addReminds(String subject,String content,int recipient) {
	        Letter letter = new Letter();
	        letter.setSubject(subject);
	        letter.setContent(content);
	        letter.setRecipient(recipient);
	    	letter.setIsRead((byte)0);
	    	letter.setType((byte)3);
	    	letter.setInUserNo(10000);
	    	letter.setImportantDegree((byte)2);//重要程度 默认一般
	        return LetterFacade.add(letter);
	    }
	    public static int addNotice(String subject,String content) {
	        Letter letter = new Letter();
	        letter.setSubject(subject);
	        letter.setContent(content);
	        letter.setRecipient(0);
	        letter.setType((byte)2);
	        letter.setInUserNo(10000);
	        letter.setImportantDegree((byte)2);//重要程度 默认一般
	        return LetterFacade.add(letter);
	    }
    public static PagedList<Letter> getPagingList(LetterCondition letterCondition) {
        return LetterFacade.getPagingList(letterCondition);
    }

    public static int add(Letter letter) {

        return LetterFacade.add(letter);
    }

    public static int update(Letter letter) {
        return LetterFacade.update(letter);
    }

    public static List<Letter> getList() {
        return LetterFacade.getList();
    }

    public static Letter getInfo(int id) {
        return LetterFacade.getInfo(id);
    }

    public static List<Letter> getListLimitByEmpId(int empId){
        return LetterFacade.getListLimitByEmpId(empId);
    }



    public static int updateSolve(Letter info){ return LetterFacade.updateSolve(info);}
    public static int updateClose(Letter info){ return LetterFacade.updateClose(info);}

    public static List<Letter> getListByTime(){
        return LetterFacade.getListByTime();
    }
}
