package com.hzfh.service.workFlow.facade.baseInfo;

import com.hzfh.api.baseInfo.model.Letter;
import com.hzfh.api.baseInfo.service.LetterService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015/11/17.
 */
public class LetterFacade {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-serviceTask.xml");
    public static int add(Letter letter){
        LetterService letterService = (LetterService) context.getBean("letterService");

        return letterService.add(letter);
    }
}
