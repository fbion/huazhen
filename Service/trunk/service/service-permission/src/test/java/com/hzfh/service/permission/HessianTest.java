package com.hzfh.service.permission;

import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.permission.model.User;
import com.hzfh.api.permission.service.UserService;
import org.junit.Test;

import java.net.MalformedURLException;

/**
 * Created by paul on 14-12-24.
 */
public class HessianTest {
    @Test
    public void hessianTest() throws MalformedURLException {//main(String[] args) throws MalformedURLException {
        //String url = "http://localhost:8080/hessian/productQuery";
    	//String url = "http://192.168.1.232:8080/service-product/product";
    	String url = "http://192.168.1.232:8080/service-permission/user";
        HessianProxyFactory factory = new HessianProxyFactory();
//        RoleService roleService = (RoleService) factory.create(RoleService.class, url);
//        Role role = new Role();
//        role.setId(999);
//        role.setName("RoleTony");
//        role.setComment("tony角色");
//        role.setEditComment("修改备注");
//        System.out.println("hessian测试完成请查看通过与否！");
        
        UserService userService = (UserService) factory.create(UserService.class, url);
        User u = new User();
        u.setId(999);
        u.setName("hull");
        u.setPassword("hull");

        User u1 = userService.login(u);
        System.out.println("hessian测试完成请查看通过与否！");
        
    }
}
