package com.hzfh.api.baseInfo.service;

import com.hzfh.api.baseInfo.model.LetterStep;

import java.util.List;

/**
 * Created by Administrator on 2015/4/20.
 */
public interface LetterStepService {
    public int add(LetterStep letterStep);
    public List<LetterStep> getListByLetterNo(int letterNo);
}
