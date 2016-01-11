package com.hzfh.service.permission;

import com.hzfh.api.permission.model.Role;
import com.hzfh.api.permission.service.RoleService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RoleTest {
	@Test
	public void getRoleByUserId(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		RoleService roleService=(RoleService) context.getBean("roleService");
		Role role=roleService.getRoleByUserId(1);
		System.out.println(role.getName());
	}
}
