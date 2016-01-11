package com.hzfh.service.permission.daoImpl;

import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.query.ElementCondition;
import com.hzfh.service.permission.dao.ElementDao;
import com.hzfh.service.permission.mapper.ElementMapper;
import com.hzframework.data.daoImpl.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service("elementDao")
public class ElementDaoImpl extends BaseDaoImpl<Element, ElementCondition, ElementMapper> implements ElementDao {
    @Autowired
    private ElementMapper elementMapper;

    @Override
    public Element getRoot() {
        return elementMapper.getRoot();
    }

    @Override
    public List<Element> getChildNodes(int id) {
        return elementMapper.getChildNodes(id);
    }

    @Override
    public Element getElementByAlias(String alias) {
        return elementMapper.getElementByAlias(alias);
    }

    @Override
    public List<Element> get1stLevelMenuList() {
        return elementMapper.get1stLevelMenuList();
    }

    @Override
    public List<Element> getMenuListByLevel(int level, int elementId) {
        return elementMapper.getMenuListByLevel(level, elementId);
    }
}