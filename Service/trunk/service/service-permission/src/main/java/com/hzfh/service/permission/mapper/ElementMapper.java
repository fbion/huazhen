package com.hzfh.service.permission.mapper;

import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.query.ElementCondition;
import com.hzframework.data.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * Copyright 2015 HZFH. All rights reserved.
 * Author: GuoZhenYu
 * Create Date: 2015/4/3
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 ******************************************************************************/


@Service("elementMapper")
public interface ElementMapper extends BaseMapper<Element, ElementCondition> {

    Element getRoot();

    List<Element> getChildNodes(int id);

    Element getElementByAlias(@Param("alias") String alias);

    List<Element> get1stLevelMenuList();

    List<Element> getMenuListByLevel(@Param("level")int level,@Param("elementId") int elementId);
}
