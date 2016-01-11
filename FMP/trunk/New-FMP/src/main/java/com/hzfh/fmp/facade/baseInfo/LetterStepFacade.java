package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.LetterStep;
import com.hzfh.api.baseInfo.service.LetterStepService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2015/4/20.
 */
public class LetterStepFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");
    public static int add(LetterStep letterStep){
        LetterStepService letterStepService = (LetterStepService) context.getBean("letterStepService");
        return letterStepService.add(letterStep);
    }
    public static List<LetterStep> getListByLetterNo(int letterNo){
        LetterStepService letterStepService = (LetterStepService) context.getBean("letterStepService");
        return letterStepService.getListByLetterNo(letterNo);
    }
}
