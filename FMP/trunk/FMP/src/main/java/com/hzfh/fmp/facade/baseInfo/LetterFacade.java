package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.Letter;
import com.hzfh.api.baseInfo.model.query.LetterCondition;
import com.hzfh.api.baseInfo.service.LetterService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class LetterFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<Letter> getPagingList(LetterCondition letterCondition) {
        LetterService letterService = (LetterService) context.getBean("letterService");

        return  letterService.getPagingList(letterCondition);
    }

    public static int add(Letter letter){
        LetterService letterService = (LetterService) context.getBean("letterService");

        return letterService.add(letter);
    }

    public static int update(Letter letter){
        LetterService letterService = (LetterService) context.getBean("letterService");

        return letterService.update(letter);
    }

    public static List<Letter> getList(){
        LetterService letterService = (LetterService) context.getBean("letterService");

        return letterService.getList();
    }

    public static Letter getInfo(int id){
        LetterService letterService = (LetterService) context.getBean("letterService");

        return letterService.getInfo(id);
    }
    public static List<Letter> getListLimitByEmpId(int empId){
        LetterService letterService = (LetterService) context.getBean("letterService");

        return letterService.getListLimitByEmpId(empId);
    }

    public static int updateSolve(Letter info){
        LetterService letterService = (LetterService) context.getBean("letterService");
        return letterService.updateSolve(info);
    }
    public static int updateClose(Letter info){
        LetterService letterService = (LetterService) context.getBean("letterService");
        return letterService.updateClose(info);
    }

    public static List<Letter> getListByTime(){
        LetterService letterService = (LetterService) context.getBean("letterService");
        return letterService.getListByTime();
    }

}
