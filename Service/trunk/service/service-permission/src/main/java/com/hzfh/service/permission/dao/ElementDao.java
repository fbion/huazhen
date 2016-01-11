package com.hzfh.service.permission.dao;

import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.query.ElementCondition;
import com.hzframework.data.dao.BaseDao;

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


public interface ElementDao extends BaseDao<Element, ElementCondition> {

    Element getRoot();

    List<Element> getChildNodes(int id);

    Element getElementByAlias(String alias);

    List<Element> get1stLevelMenuList();

    List<Element> getMenuListByLevel(int level, int elementId);

}