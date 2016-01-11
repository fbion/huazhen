package com.hzfh.service.permission.mapper;

import com.hzfh.api.permission.model.Element;
import com.hzfh.api.permission.model.query.MenuCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuMapper")
public interface MenuMapper {

	List<Element> getUserElement(MenuCondition menuCondition);

	List<Element> getUserElementByRoleNoAndLevel(@Param("roleNo")int roleNo,@Param("parentNo")int parentNo,@Param("level")String level);

}
