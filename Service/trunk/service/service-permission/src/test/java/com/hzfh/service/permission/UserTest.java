package com.hzfh.service.permission;

import com.hzfh.api.permission.model.User;
import com.hzfh.api.permission.model.query.UserCondition;
import com.hzfh.api.permission.service.UserService;
import com.hzframework.contract.PagedList;
import com.hzframework.contract.SortItem;
import com.hzframework.contract.SortType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

	@Test
	// success
	public void addTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserService userService = (UserService) context.getBean("userService");
		User user = new User();
		user.setName("admin");
		user.setPassword("admin");
		user.setLastLogin(null);
		int id = userService.add(user);
		System.out.println(id);
	}

	@Test
	// success
	public void updateTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserService userService = (UserService) context.getBean("userService");
		User user = new User();
		user.setName("admin");
		user.setPassword("admin");
		user.setId(1);
		int ret = userService.update(user);
		System.out.println(ret);
	}

	@Test
	// success
	public void deleteTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserService userService = (UserService) context.getBean("userService");
		int ret = userService.delete(2);
		System.out.println(ret);

	}

	@Test
	//success
	public void getListTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserService userService = (UserService) context.getBean("userService");
		List<User> userList = userService.getList();
		for (User user : userList) {
			System.out.println(user.getId() + "," + user.getName() + ","
					+ user.getPassword());
		}
	}

	@Test
	// success
	public void getInfoTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserService userService = (UserService) context.getBean("userService");
		User user = userService.getInfo(1);
		System.out.println(user.getId() + "," + user.getName() + ","
				+ user.getPassword());
	}
	
	@Test
	//success
	public void getPagingListTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserService userService = (UserService) context.getBean("userService");
		UserCondition userCondition=new UserCondition();
		userCondition.setName("hull");
		userCondition.setPageIndex(1);
		userCondition.setPageSize(4);
		List<SortItem> sortItemList=new ArrayList<SortItem>();
		SortItem sortItem1=new SortItem();
		sortItem1.setSortFeild("id");
		sortItem1.setSortType(SortType.ASC);
		sortItemList.add(sortItem1);
		userCondition.setSortItemList(sortItemList);
		PagedList<User> userPagedList=userService.getPagingList(userCondition);
		for(User user:userPagedList.getResultList()){
			System.out.println(user.getId()+","+user.getName()+","+user.getPassword());
		}
	}

    @Test
    public void getLogin(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");

        User u = new User();
        u.setId(999);
        u.setName("hull");
        u.setPassword("hull");

        User u1 = userService.login(u);
    }
    
    
    //getPwdById
    @Test
    public void getPwdById(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        int id = 4 ;
        String pwd  = userService.getPwdById(id);
        System.out.println(pwd);
    }
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
}
