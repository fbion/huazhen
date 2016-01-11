package com.hzfh.fmp.model.sales;

import com.hzfh.api.employee.model.KnowledgeAttachment;
import com.hzfh.api.sales.model.ActivityAttachment;
import com.hzfh.api.sales.model.query.ActivityAttachmentCondition;
import com.hzfh.fmp.facade.employee.KnowledgeAttachmentFacade;
import com.hzfh.fmp.facade.sales.ActivityAttachmentFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class ActivityAttachmentModel {
    public static PagedList<ActivityAttachment> getPagingList(ActivityAttachmentCondition activityAttachmentCondition) {
        return ActivityAttachmentFacade.getPagingList(activityAttachmentCondition);
    }

    public static int add(ActivityAttachment activityAttachment) {
        return ActivityAttachmentFacade.add(activityAttachment);
    }

    public static int update(ActivityAttachment activityAttachment) {
        return ActivityAttachmentFacade.update(activityAttachment);
    }

    public static List<ActivityAttachment> getList() {
        return ActivityAttachmentFacade.getList();
    }

    public static ActivityAttachment getInfo(int id) {
        return ActivityAttachmentFacade.getInfo(id);
    }

	public static List<ActivityAttachment> getListByActivityNo(int activityNo) {
		// TODO Auto-generated method stub
		return ActivityAttachmentFacade.getListByActivityNo(activityNo);
	}
	public static int updateStatus(int id, byte status) {
		// TODO Auto-generated method stub
		return ActivityAttachmentFacade.updateStatus(id,status);
	}

	public static List<ActivityAttachment> getListBySalesNo(int activityNo) {
		return ActivityAttachmentFacade.getListBySalesNo(activityNo);
	}

    public static List<ActivityAttachment> getListBySalesNoAndType(int activityNo,int type) {
        return ActivityAttachmentFacade.getListBySalesNoAndType(activityNo,type);
    }
}
