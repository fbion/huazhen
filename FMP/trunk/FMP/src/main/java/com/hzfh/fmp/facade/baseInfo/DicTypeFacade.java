package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.DicType;
import com.hzfh.api.baseInfo.model.query.DicTypeCondition;
import com.hzfh.api.baseInfo.service.DicTypeService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DicTypeFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<DicType> getPagingList(DicTypeCondition dicTypeCondition) {
        DicTypeService dicTypeService = (DicTypeService) context.getBean("dicTypeService");

        return  dicTypeService.getPagingList(dicTypeCondition);
    }

    public static int add(DicType dicType){
        DicTypeService dicTypeService = (DicTypeService) context.getBean("dicTypeService");

        return dicTypeService.add(dicType);
    }

    public static int update(DicType dicType){
        DicTypeService dicTypeService = (DicTypeService) context.getBean("dicTypeService");

        return dicTypeService.update(dicType);
    }

    public static List<DicType> getList(){
        DicTypeService dicTypeService = (DicTypeService) context.getBean("dicTypeService");

        return dicTypeService.getList();
    }

    public static DicType getInfo(int id){
        DicTypeService dicTypeService = (DicTypeService) context.getBean("dicTypeService");

        return dicTypeService.getInfo(id);
    }
}
