package com.hzfh.fmp.facade.permission;

import com.hzfh.api.permission.model.User;
import com.hzfh.api.permission.model.query.UserCondition;
import com.hzfh.api.permission.service.UserService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.List;

public class UserFacade {
	private static ApplicationContext context = new ClassPathXmlApplicationContext(
			"spring/hessian-permission.xml");

	public static PagedList<User> getPagingList(UserCondition userCondition) {
		UserService userService = (UserService) context.getBean("userService");

		return userService.getPagingList(userCondition);
	}

	public static int add(User user) {
		UserService userService = (UserService) context.getBean("userService");

		return userService.add(user);
	}

	public static int update(User user) {
		UserService userService = (UserService) context.getBean("userService");

		return userService.update(user);
	}

	public static List<User> getList() {
		UserService userService = (UserService) context.getBean("userService");

		return userService.getList();
	}

	public static User getInfo(int id) {
		UserService userService = (UserService) context.getBean("userService");

		return userService.getInfo(id);
	}
	public static User login(User user){
		UserService userService = (UserService) context.getBean("userService");

		return userService.login(user);
	}

	public static int updatePwd(int id, String password) {
		UserService userService = (UserService) context.getBean("userService");
		return userService.updatePwd(id,password);
	}

	public static String getPwdById(int id) {
		UserService userService = (UserService) context.getBean("userService");
		return userService.getPwdById(id);
	}

	public static User getUserByUserName(String userName) {
		UserService userService = (UserService) context.getBean("userService");
		return userService.getUserByUserName(userName);
	}

	public static int updateLastLoginById(int id, Timestamp currentTime) {
		UserService userService = (UserService) context.getBean("userService");
		return userService.updateLastLoginById(id,currentTime);
	}
}
