package com.hzfh.service.baseInfo.daoImpl;

import com.hzfh.api.baseInfo.model.LetterStep;
import com.hzfh.service.baseInfo.dao.LetterStepDao;
import com.hzfh.service.baseInfo.mapper.LetterStepMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/4/20.
 */
@Service("letterStepDao")
public class LetterStepDaoImpl implements LetterStepDao{
    @Autowired
    private LetterStepMapper letterStepMapper;

    @Override
    public int add(LetterStep letterStep) {
        return letterStepMapper.add(letterStep);
    }

    @Override
    public List<LetterStep> getListByLetterNo(int letterNo){
        return letterStepMapper.getListByLetterNo(letterNo);
    }
}
