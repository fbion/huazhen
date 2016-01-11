package com.hzfh.service.baseInfo.serviceImpl;

import com.hzfh.api.baseInfo.model.LetterStep;
import com.hzfh.api.baseInfo.service.LetterStepService;
import com.hzfh.service.baseInfo.dao.LetterStepDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/4/20.
 */
@Service("letterStepService")
public class LetterStepServiceImpl implements LetterStepService {
    @Autowired
    private LetterStepDao letterStepDao;
    @Override
    public int add(LetterStep letterStep){
        return letterStepDao.add(letterStep);
    }
    @Override
    public List<LetterStep> getListByLetterNo(int letterNo) { return letterStepDao.getListByLetterNo(letterNo);}
}
