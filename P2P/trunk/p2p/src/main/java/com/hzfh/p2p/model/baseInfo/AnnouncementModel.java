package com.hzfh.p2p.model.baseInfo;

import com.hzfh.api.baseInfo.model.Announcement;
import com.hzfh.api.baseInfo.model.query.AnnouncementCondition;
import com.hzfh.p2p.facade.baseInfo.AnnouncementFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class AnnouncementModel {
    public static PagedList<Announcement> getPagingList(AnnouncementCondition announcementCondition) {
        return AnnouncementFacade.getPagingList(announcementCondition);
    }

    public static int add(Announcement announcement) {
        return AnnouncementFacade.add(announcement);
    }

    public static int update(Announcement announcement) {
        return AnnouncementFacade.update(announcement);
    }

    public static List<Announcement> getList() {
        return AnnouncementFacade.getList();
    }

    public static Announcement getInfo(int id) {
        return AnnouncementFacade.getInfo(id);
    }

	public static List<Announcement> getAnnouncementTitleList(AnnouncementCondition announcementCondition) {
		return AnnouncementFacade.getAnnouncementTitleList(announcementCondition);
	}
}
