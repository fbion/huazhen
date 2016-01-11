package com.hzfh.service.workFlow.facade.product;

import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.api.product.model.query.P2pProductCondition;
import com.hzfh.api.product.service.P2pProductService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class P2pProductFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-serviceTask.xml");

    public static P2pProduct getInfo(int id) {
        P2pProductService p2pProductService = (P2pProductService) context.getBean("p2pProductService");

        return p2pProductService.getInfo(id);
    }


    public static P2pProduct getP2pByProductNo(int productNo) {
        P2pProductService p2pProductService = (P2pProductService) context.getBean("p2pProductService");
        return p2pProductService.getP2pByProductNo(productNo);
    }

    public static int updateRemainAmountByProductNo(int productNo, long money) {
        P2pProductService p2pProductService = (P2pProductService) context.getBean("p2pProductService");
        return p2pProductService.updateRemainAmountByProductNo(productNo, money);
    }

    public static int updateOrderCountByProductNo(int productNo, int count) {
        P2pProductService p2pProductService = (P2pProductService) context.getBean("p2pProductService");
        return p2pProductService.updateOrderCountByProductNo(productNo, count);
    }

    public static int updateStatusById(int id, byte status) {
        P2pProductService p2pProductService = (P2pProductService) context.getBean("p2pProductService");
        return p2pProductService.updateStatusById(id, status);
    }


}
