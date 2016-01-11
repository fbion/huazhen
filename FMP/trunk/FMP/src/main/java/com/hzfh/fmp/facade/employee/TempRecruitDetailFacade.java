package com.hzfh.fmp.facade.employee;

import com.hzfh.api.employee.model.TempRecruitDetail;
import com.hzfh.api.employee.model.query.TempRecruitDetailCondition;
import com.hzfh.api.employee.service.TempRecruitDetailService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TempRecruitDetailFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-employee.xml");

    public static PagedList<TempRecruitDetail> getPagingList(TempRecruitDetailCondition tempRecruitDetailCondition) {
        TempRecruitDetailService tempRecruitDetailService = (TempRecruitDetailService) context.getBean("tempRecruitDetailService");

        return  tempRecruitDetailService.getPagingList(tempRecruitDetailCondition);
    }

    public static int add(TempRecruitDetail tempRecruitDetail){
        TempRecruitDetailService tempRecruitDetailService = (TempRecruitDetailService) context.getBean("tempRecruitDetailService");

        return tempRecruitDetailService.add(tempRecruitDetail);
    }

    public static int update(TempRecruitDetail tempRecruitDetail){
        TempRecruitDetailService tempRecruitDetailService = (TempRecruitDetailService) context.getBean("tempRecruitDetailService");

        return tempRecruitDetailService.update(tempRecruitDetail);
    }
    public static int updateByNeedNo(TempRecruitDetail tempRecruitDetail){
        TempRecruitDetailService tempRecruitDetailService = (TempRecruitDetailService) context.getBean("tempRecruitDetailService");

        return tempRecruitDetailService.updateByNeedNo(tempRecruitDetail);
    }
    public static List<TempRecruitDetail> getList(){
        TempRecruitDetailService tempRecruitDetailService = (TempRecruitDetailService) context.getBean("tempRecruitDetailService");

        return tempRecruitDetailService.getList();
    }

    public static TempRecruitDetail getInfo(int id){
        TempRecruitDetailService tempRecruitDetailService = (TempRecruitDetailService) context.getBean("tempRecruitDetailService");
        return tempRecruitDetailService.getInfo(id);
    }

	public static TempRecruitDetail getInfoByNeedNo(int id) {
		TempRecruitDetailService tempRecruitDetailService = (TempRecruitDetailService) context.getBean("tempRecruitDetailService");
        return tempRecruitDetailService.getInfoByNeedNo(id);
	}
}
