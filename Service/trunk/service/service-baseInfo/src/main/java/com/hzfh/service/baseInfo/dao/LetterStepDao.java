package com.hzfh.service.baseInfo.dao;

import com.hzfh.api.baseInfo.model.LetterStep;

import java.util.List;

/**
 * Created by Administrator on 2015/4/20.
 */
public interface LetterStepDao {
    public int add(LetterStep letterStep);
    public List<LetterStep> getListByLetterNo(int LetterNo);
}
