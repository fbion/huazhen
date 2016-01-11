package com.hzfh.service.customer.mapper;

import java.util.List;

import com.hzfh.api.customer.model.ActivityAwardRelation;
import com.hzfh.api.customer.model.query.ActivityAwardRelationCondition;
import com.hzframework.data.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/10/12 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("activityAwardRelationMapper")
public interface ActivityAwardRelationMapper extends BaseMapper<ActivityAwardRelation, ActivityAwardRelationCondition> {

	int updateCidById(@Param("id")int id,@Param("mid") int mid);

	List<ActivityAwardRelation> getInfoByActId(@Param("id")int id);

	List<ActivityAwardRelation> getInfoByConId(@Param("id")int id);

	int deleteInfoByCondId(@Param("id")int id);

	ActivityAwardRelation getInfoByRelatedNo(@Param("type")int type,@Param("id")int id);
}