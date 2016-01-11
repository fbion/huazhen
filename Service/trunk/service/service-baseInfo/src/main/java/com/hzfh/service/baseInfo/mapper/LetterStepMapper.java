package com.hzfh.service.baseInfo.mapper;

import com.hzfh.api.baseInfo.model.LetterStep;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/4/20.
 */
@Service("letterStepMapper")
public interface LetterStepMapper {
    public int add(LetterStep letterStep);
    public List<LetterStep> getListByLetterNo(@Param("letterNo")int letterNo);
}
