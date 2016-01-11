package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.FixedAssets;
import com.hzfh.api.employee.model.query.FixedAssetsCondition;
import com.hzfh.fmp.facade.employee.FixedAssetsFacade;
import com.hzframework.contract.PagedList;

import java.util.List;

public class FixedAssetsModel {
    public static PagedList<FixedAssets> getPagingList(FixedAssetsCondition fixedAssetsCondition) {
        return FixedAssetsFacade.getPagingList(fixedAssetsCondition);
    }

    public static int add(FixedAssets fixedAssets) {
        return FixedAssetsFacade.add(fixedAssets);
    }

    public static int update(FixedAssets fixedAssets) {
        return FixedAssetsFacade.update(fixedAssets);
    }

    public static List<FixedAssets> getList() {
        return FixedAssetsFacade.getList();
    }

    public static FixedAssets getInfo(int id) {
        return FixedAssetsFacade.getInfo(id);
    }
}
