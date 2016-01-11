package com.hzfh.api.permission.service;

import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.query.ElementCondition;
import com.hzframework.data.service.BaseService;

import java.util.List;


/**
 * ****************************************************************************
 * <p/>
 * Copyright 2015 HZFH. All rights reserved.
 * Author: GuoZhenYu
 * Create Date: 2015/4/3
 * Description:
 * <p/>
 * Revision History:
 * Date         Author               Description
 * <p/>
 * ****************************************************************************
 */

public interface ElementService extends BaseService<Element, ElementCondition> {

    Element getRoot();

    List<Element> getChildNodes(int id);

    Element getElementByAlias(String alias);

    List<Element> get1stLevelMenuList();

    List<Element> getMenuListByLevel(int level, int elementId);
}