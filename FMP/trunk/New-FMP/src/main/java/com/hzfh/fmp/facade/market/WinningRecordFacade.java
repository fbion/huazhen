package com.hzfh.fmp.facade.market;

import com.hzfh.api.market.model.WinningRecord;
import com.hzfh.api.market.model.query.WinningRecordCondition;
import com.hzfh.api.market.service.WinningRecordService;
import com.hzframework.contract.PagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class WinningRecordFacade {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-market.xml");

    public static PagedList<WinningRecord> getPagingList(WinningRecordCondition winningRecordCondition) {
        WinningRecordService winningRecordService = (WinningRecordService) context.getBean("winningRecordService");

        return  winningRecordService.getPagingList(winningRecordCondition);
    }

    public static int add(WinningRecord winningRecord){
        WinningRecordService winningRecordService = (WinningRecordService) context.getBean("winningRecordService");

        return winningRecordService.add(winningRecord);
    }

    public static int update(WinningRecord winningRecord){
        WinningRecordService winningRecordService = (WinningRecordService) context.getBean("winningRecordService");

        return winningRecordService.update(winningRecord);
    }

    public static List<WinningRecord> getList(){
        WinningRecordService winningRecordService = (WinningRecordService) context.getBean("winningRecordService");

        return winningRecordService.getList();
    }

    public static WinningRecord getInfo(int id){
        WinningRecordService winningRecordService = (WinningRecordService) context.getBean("winningRecordService");

        return winningRecordService.getInfo(id);
    }
}
