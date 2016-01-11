package com.hzfh.service.permission.serviceImpl;

import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.query.ElementCondition;
import com.hzfh.api.permission.service.ElementService;
import com.hzfh.service.permission.dao.ElementDao;
import com.hzframework.data.serviceImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*******************************************************************************
 * 
 * Copyright 2015 HZFH. All rights reserved. 
 * Author: GuoZhenYu  
 * Create Date: 2015/4/3 
 * Description:
 * 
 * Revision History:
 *      Date         Author               Description
 * 
 ******************************************************************************/


@Service("elementService")
public class ElementServiceImpl extends BaseServiceImpl<Element, ElementCondition, ElementDao> implements ElementService {
	@Autowired
	private ElementDao elementDao;
	@Override
	public Element getRoot() {
		return elementDao.getRoot();
	}

	@Override
	public List<Element> getChildNodes(int id) {
		return elementDao.getChildNodes(id);
	}

	@Override
	public Element getElementByAlias(String alias) {
		return elementDao.getElementByAlias(alias);
	}

	@Override
	public List<Element> get1stLevelMenuList() {
		return elementDao.get1stLevelMenuList();
	}

	@Override
	public List<Element> getMenuListByLevel(int level,int elementId) {
		return elementDao.getMenuListByLevel(level,elementId);
	}
}