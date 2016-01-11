package com.hzfh.fmp.facade.baseInfo;

import com.hzfh.api.baseInfo.model.DicData;
import com.hzfh.api.baseInfo.model.query.DicDataCondition;
import com.hzfh.api.baseInfo.service.DicDataService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DicDataFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");

    public static PagedList<DicData> getPagingList(DicDataCondition dicDataCondition) {
        DicDataService dicDataService = (DicDataService) context.getBean("dicDataService");

        return  dicDataService.getPagingList(dicDataCondition);
    }

    public static int add(DicData dicData){
        DicDataService dicDataService = (DicDataService) context.getBean("dicDataService");

        return dicDataService.add(dicData);
    }

    public static int update(DicData dicData){
        DicDataService dicDataService = (DicDataService) context.getBean("dicDataService");

        return dicDataService.update(dicData);
    }

    public static List<DicData> getList(){
        DicDataService dicDataService = (DicDataService) context.getBean("dicDataService");

        return dicDataService.getList();
    }

    public static DicData getInfo(int id){
        DicDataService dicDataService = (DicDataService) context.getBean("dicDataService");

        return dicDataService.getInfo(id);
    }


	public static List<DicData> getDicDataListByType(int dicTypeNo) {
		DicDataService dicDataService = (DicDataService) context.getBean("dicDataService");
		return dicDataService.getDicDataListByType(dicTypeNo);
	}


    public static DicData getDicDataByTypeAndCode(int dicTypeNo,int code){
        DicDataService dicDataService = (DicDataService) context.getBean("dicDataService");
        return dicDataService.getDicDataByTypeAndCode(dicTypeNo,code);
    }
}
