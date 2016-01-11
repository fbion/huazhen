package com.hzfh.fmp.model.baseInfo;

import com.hzfh.api.baseInfo.model.LetterStep;
import com.hzfh.fmp.facade.baseInfo.LetterStepFacade;

import java.util.List;

/**
 * Created by Administrator on 2015/4/20.
 */
public class LetterStepModel {
    public static int add(LetterStep letterStep){
        return LetterStepFacade.add(letterStep);
    }
    public static List<LetterStep> getListByLetterNo(int letterNo){
        return LetterStepFacade.getListByLetterNo(letterNo);
    }
}
