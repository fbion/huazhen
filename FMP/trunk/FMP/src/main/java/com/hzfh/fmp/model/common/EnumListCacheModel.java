package com.hzfh.fmp.model.common;

import java.util.ArrayList;
import java.util.List;

import com.hzfh.api.customer.model.query.CustomerPersonalCondition;
import com.hzfh.fmp.model.common.helper.FlushCacheHelper;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.common.view.ListItem;

public class EnumListCacheModel {

    /**
     * listItem  加缓存方法
     */
    /*public static List<ListItem> getUnAssignGroups(String userNo, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();

        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getUnAssignGroups" + userNo);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getUnAssignGroups(userNo);
        FlushCacheHelper.setCacheForMethod("getUnAssignGroups" + userNo, itemList);
        return itemList;
    }*/

    public static List<ListItem> getBannerLocationList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();

        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getBannerLocationList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getBannerLocationList();
        FlushCacheHelper.setCacheForMethod("getBannerLocationList", itemList);
        return itemList;
    }
    /*public static List<ListItem> getAssignGroupList(String userNo, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getAssignGroupList" + userNo);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getAssignGroupList(userNo);
        FlushCacheHelper.setCacheForMethod("getAssignGroupList" + userNo, itemList);
        return itemList;
    }*/

    public static List<ListItem> deptSubForCustomer(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("deptSubForCustomer");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.deptSubForCustomer();
        FlushCacheHelper.setCacheForMethod("deptSubForCustomer", itemList);
        return itemList;
    }

    public static List<ListItem> empManagerListByDept(int empManagerDept, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();

        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("empManagerListByDept" + empManagerDept);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.empManagerListByDept(empManagerDept);
        FlushCacheHelper.setCacheForMethod("empManagerListByDept" + empManagerDept, itemList);
        return itemList;
    }

    public static List<ListItem> empManagerListByStatus(int empManagerStauts, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();

        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("empManagerListByStatus" + empManagerStauts+UserHelper.getUserCache().getEmpId());
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.empManagerListByStatus(empManagerStauts);
        FlushCacheHelper.setCacheForMethod("empManagerListByStatus" + empManagerStauts+UserHelper.getUserCache().getEmpId(), itemList);
        return itemList;
    }


    public static List<ListItem> getP2pProductList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getP2pProductList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getP2pProductList();
        FlushCacheHelper.setCacheForMethod("getP2pProductList", itemList);
        return itemList;
    }

    public static List<ListItem> getP2pCustomerList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getP2pCustomerList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getP2pCustomerList();
        FlushCacheHelper.setCacheForMethod("getP2pCustomerList", itemList);
        return itemList;
    }

    public static List<ListItem> getP2pCustomerListRealName(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getP2pCustomerListRealName");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getP2pCustomerListRealName();
        FlushCacheHelper.setCacheForMethod("getP2pCustomerListRealName", itemList);
        return itemList;
    }
    public static List<ListItem> getCreditorList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getCreditorList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getCreditorList();
        FlushCacheHelper.setCacheForMethod("getCreditorList", itemList);
        return itemList;
    }
    public static List<ListItem> getCreditorListByProductNo(String productNo,boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getCreditorListByProductNo"+productNo);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getCreditorListByProductNo(Integer.parseInt(productNo));
        FlushCacheHelper.setCacheForMethod("getCreditorListByProductNo"+productNo, itemList);
        return itemList;
    }
    public static List<ListItem> p2pCustomerListWithRealName(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("p2pCustomerListWithRealName");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.p2pCustomerListWithRealName();
        FlushCacheHelper.setCacheForMethod("p2pCustomerListWithRealName", itemList);
        return itemList;
    }

    public static List<ListItem> getDrawAwards(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getDrawAwards");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getDrawAwards();
        FlushCacheHelper.setCacheForMethod("getDrawAwards", itemList);
        return itemList;
    }
    
    public static List<ListItem> getExtendEmp(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getExtendEmp");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getExtendEmp();
        FlushCacheHelper.setCacheForMethod("getExtendEmp", itemList);
        return itemList;
    }

    public static List<ListItem> getWealthManagerListByUserNo(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getWealthManagerListByUserNo");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getWealthManagerListByUserNo();
        FlushCacheHelper.setCacheForMethod("getWealthManagerListByUserNo", itemList);
        return itemList;
    }

    public static List<ListItem> getMyAgentAdviser(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getMyAgentAdviser"+ UserHelper.getEditUserNo());
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getMyAgentAdviser();
        FlushCacheHelper.setCacheForMethod("getMyAgentAdviser"+UserHelper.getEditUserNo(), itemList);
        return itemList;
    }

    public static List<ListItem> getMyAgentBusiness(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getMyAgentBusiness"+ UserHelper.getEditUserNo());
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getMyAgentBusiness();
        FlushCacheHelper.setCacheForMethod("getMyAgentBusiness"+ UserHelper.getEditUserNo(), itemList);
        return itemList;
    }

    public static List<ListItem> getMycustomerPersonList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getMycustomerPersonList"+ UserHelper.getEditUserNo());
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getMycustomerPersonList();
        FlushCacheHelper.setCacheForMethod("getMycustomerPersonList"+ UserHelper.getEditUserNo(), itemList);
        return itemList;
    }
    public static List<ListItem> getMycustomerPersonList1(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getMycustomerPersonList1"+ UserHelper.getEditUserNo());
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getMycustomerPersonList1();
        FlushCacheHelper.setCacheForMethod("getMycustomerPersonList1"+ UserHelper.getEditUserNo(), itemList);
        return itemList;
    }
    public static List<ListItem> getMyCustomerCompanyList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getMyCustomerCompanyList"+ UserHelper.getEditUserNo());
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getMyCustomerCompanyList();
        FlushCacheHelper.setCacheForMethod("getMyCustomerCompanyList"+ UserHelper.getEditUserNo(), itemList);
        return itemList;
    }
    public static List<ListItem> getMyCustomerCompanyList1(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getMyCustomerCompanyList1"+ UserHelper.getEditUserNo());
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getMyCustomerCompanyList1();
        FlushCacheHelper.setCacheForMethod("getMyCustomerCompanyList1"+ UserHelper.getEditUserNo(), itemList);
        return itemList;
    }
    // get product where type and status=Onsale
    public static List<ListItem> getProductByTypeAndStatus(byte type, byte status, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getProductByTypeAndStatus" + type + status);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getProductByTypeAndStatus(type, status);
        FlushCacheHelper.setCacheForMethod("getProductByTypeAndStatus" + type + status, itemList);
        return itemList;
    }
    public static List<ListItem> getP2pProductByTypeAndStatus(byte type, byte status, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getP2pProductByTypeAndStatus" + type + status);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getP2pProductByTypeAndStatus(type, status);
        FlushCacheHelper.setCacheForMethod("getP2pProductByTypeAndStatus" + type + status, itemList);
        return itemList;
    }
    // get p2pProduct where type and status=Onsale
    public static List<ListItem> getP2pProductByStatus(byte status, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getP2pProductByStatus" + status);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getP2pProductByStatus(status);
        FlushCacheHelper.setCacheForMethod("getP2pProductByStatus" + status, itemList);
        return itemList;
    }

    public static List<ListItem> getDeptListByParentNo(int parentNo, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getDeptListByParentNo" + parentNo);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getDeptListByParentNo(parentNo);
        FlushCacheHelper.setCacheForMethod("getDeptListByParentNo" + parentNo, itemList);
        return itemList;
    }
    public static List<ListItem> getDeptListByType(int type, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getDeptListByType" + type);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getDeptListByType(type);
        FlushCacheHelper.setCacheForMethod("getDeptListByType" + type, itemList);
        return itemList;
    }
    public static List<ListItem> getProvinceList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getProvinceList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getProvinceList();
        FlushCacheHelper.setCacheForMethod("getProvinceList", itemList);
        return itemList;
    }

    public static List<ListItem> getCityList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getCityList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getCityList();
        FlushCacheHelper.setCacheForMethod("getCityList", itemList);
        return itemList;
    }

    public static List<ListItem> getDistrictList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getDistrictList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getDistrictList();
        FlushCacheHelper.setCacheForMethod("getDistrictList", itemList);
        return itemList;
    }

    public static List<ListItem> getDeptListByCompanyNo(int CompanyNo, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getDeptListByCompanyNo" + CompanyNo);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getDeptListByCompanyNo(CompanyNo);
        FlushCacheHelper.setCacheForMethod("getDeptListByCompanyNo" + CompanyNo, itemList);
        return itemList;
    }

    public static List<ListItem> getFinancierBusinessList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getFinancierBusinessList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getFinancierBusinessList();
        FlushCacheHelper.setCacheForMethod("getFinancierBusinessList", itemList);
        return itemList;
    }

    public static List<ListItem> getFinancierPersonalList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getFinancierPersonalList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getFinancierPersonalList();
        FlushCacheHelper.setCacheForMethod("getFinancierPersonalList", itemList);
        return itemList;
    }

    public static List<ListItem> getCustomerAgentAdviserList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getCustomerAgentAdviserList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getCustomerAgentAdviserList();
        FlushCacheHelper.setCacheForMethod("getCustomerAgentAdviserList", itemList);
        return itemList;
    }

    public static List<ListItem> getCustomerAgentBusinessList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getCustomerAgentBusinessList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getCustomerAgentBusinessList();
        FlushCacheHelper.setCacheForMethod("getCustomerAgentBusinessList", itemList);
        return itemList;
    }

    public static List<ListItem> getPositionByDept(int deptNo, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getPositionByDept" + deptNo);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getPositionByDept(deptNo);
        FlushCacheHelper.setCacheForMethod("getPositionByDept" + deptNo, itemList);
        return itemList;
    }

    public static List<ListItem> getSalesList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getSalesList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getSalesList();
        FlushCacheHelper.setCacheForMethod("getSalesList", itemList);
        return itemList;
    }

    public static List<ListItem> getIssuerList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getIssuerList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getIssuerList();
        FlushCacheHelper.setCacheForMethod("getIssuerList", itemList);
        return itemList;
    }

    public static List<ListItem> getAgentAdviser(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getAgentAdviser");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getAgentAdviser();
        FlushCacheHelper.setCacheForMethod("getAgentAdviser", itemList);
        return itemList;
    }

    public static List<ListItem> getAgentBusinessList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getAgentBusinessList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getAgentBusinessList();
        FlushCacheHelper.setCacheForMethod("getAgentBusinessList", itemList);
        return itemList;
    }

    public static List<ListItem> getEmpList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getEmpList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getEmpList();
        FlushCacheHelper.setCacheForMethod("getEmpList", itemList);
        return itemList;
    }
    public static List<ListItem> getEmpListNoTest(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getEmpList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getEmpListNoTest();
        FlushCacheHelper.setCacheForMethod("getEmpList", itemList);
        return itemList;
    }

    public static List<ListItem> getEmpListById(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getEmpListById");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getEmpListById();
        FlushCacheHelper.setCacheForMethod("getEmpListById", itemList);
        return itemList;
    }

    public static List<ListItem> getRecipientList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getRecipientList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getRecipientList();
        FlushCacheHelper.setCacheForMethod("getRecipientList", itemList);
        return itemList;
    }

    public static List<ListItem> getEmpListForEmp(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getEmpListForEmp");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getEmpListForEmp();
        FlushCacheHelper.setCacheForMethod("getEmpListForEmp", itemList);
        return itemList;
    }

    public static List<ListItem> getProductList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getProductList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getProductList();
        FlushCacheHelper.setCacheForMethod("getProductList", itemList);
        return itemList;
    }

    public static List<ListItem> getRoleList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getRoleList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getRoleList();
        FlushCacheHelper.setCacheForMethod("getRoleList", itemList);
        return itemList;
    }

    public static List<ListItem> getProductListByType(byte type, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getProductListByType" + type);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getProductListByType(type);
        FlushCacheHelper.setCacheForMethod("getProductListByType" + type, itemList);
        return itemList;
    }

    public static List<ListItem> getWealthManagerListByStore(Byte storeNo, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getWealthManagerListByStore" + storeNo);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getWealthManagerListByStore(storeNo);
        FlushCacheHelper.setCacheForMethod("getWealthManagerListByStore" + storeNo, itemList);
        return itemList;
    }
    public static List<ListItem> getWealthManagerListByStoreIsUse(Byte storeNo, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getWealthManagerListByStoreIsUse" + storeNo);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getWealthManagerListByStoreIsUse(storeNo);
        FlushCacheHelper.setCacheForMethod("getWealthManagerListByStoreIsUse" + storeNo, itemList);
        return itemList;
    }
    public static List<ListItem> getProductListByStatus(byte statusLeft, byte statusRight, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getProductListByStatus" + statusLeft + statusRight);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getProductListByStatus(statusLeft, statusRight);
        FlushCacheHelper.setCacheForMethod("getProductListByStatus" + statusLeft + statusRight, itemList);
        return itemList;
    }

    public static List<ListItem> getStoreList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getStoreList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getStoreList();
        FlushCacheHelper.setCacheForMethod("getStoreList", itemList);
        return itemList;
    }

    public static List<ListItem> getUserList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getUserList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getUserList();
        FlushCacheHelper.setCacheForMethod("getUserList", itemList);
        return itemList;
    }

    public static List<ListItem> getCompanylistFromEmpToTree(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getCompanylistFromEmpToTree");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getCompanylistFromEmpToTree();
        FlushCacheHelper.setCacheForMethod("getCompanylistFromEmpToTree", itemList);
        return itemList;
    }

    public static List<ListItem> getDeptlistToTree(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getDeptlistToTree");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getDeptlistToTree();
        FlushCacheHelper.setCacheForMethod("getDeptlistToTree", itemList);
        return itemList;
    }
    public static List<ListItem> getPositionlistToTree(boolean isReadCached) {
    	List<ListItem> itemList = new ArrayList<ListItem>();
    	if (isReadCached) {
    		itemList = FlushCacheHelper.getCacheForMethod("getPositionlistToTree");
    		if (itemList != null && itemList.size() != 0) {
    			return itemList;
    		}
    	}
    	itemList = EnumListModel.getPositionlistToTree();
    	FlushCacheHelper.setCacheForMethod("getPositionlistToTree", itemList);
    	return itemList;
    }

    public static List<ListItem> getEmployeeTree(String param,boolean isReadCached,String param2) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getEmployeeTree"+param+param2);
            if (itemList!=null) {
                return itemList;
            }
        }
        itemList = EnumListModel.getEmployeeTree(param,param2);
        FlushCacheHelper.setCacheForMethod("getEmployeeTree"+param+param2,itemList);
        return itemList;
    }

    public static List<ListItem> getDicDataListByType(int dicTypeNo, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getDicDataListByType" + dicTypeNo);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getDicDataListByType(dicTypeNo);
        FlushCacheHelper.setCacheForMethod("getDicDataListByType" + dicTypeNo, itemList);
        return itemList;
    }

    public static List<ListItem> getRolesByUserId(String userId, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getRolesByUserId" + userId);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getRolesByUserId(userId);
        FlushCacheHelper.setCacheForMethod("getRolesByUserId" + userId, itemList);
        return itemList;
    }

    public static List<ListItem> getUnAssignRoles(String userId, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getUnAssignRoles" + isReadCached);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getUnAssignRoles(userId);
        FlushCacheHelper.setCacheForMethod("getUnAssignRoles" + isReadCached, itemList);
        return itemList;
    }

    public static List<ListItem> getDicTypeNoList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getDicTypeNoList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getDicTypeNoList();
        FlushCacheHelper.setCacheForMethod("getDicTypeNoList", itemList);
        return itemList;
    }

    public static List<ListItem> getEmpListByParentNo(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        int userId = UserHelper.getUserCache().getUserId();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getEmpListByParentNo"+userId);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getEmpListByParentNo();
        FlushCacheHelper.setCacheForMethod("getEmpListByParentNo"+userId, itemList);
        return itemList;
    }

    public static List<ListItem> getDeptList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getDeptList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getDeptList();
        FlushCacheHelper.setCacheForMethod("getDeptList", itemList);
        return itemList;
    }

    // compamy of employee
    public static List<ListItem> getCompanylistFromEmp(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getCompanylistFromEmp");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getCompanylistFromEmp();
        FlushCacheHelper.setCacheForMethod("getCompanylistFromEmp", itemList);
        return itemList;
    }

    public static List<ListItem> getEmpListByDept(int deptNo, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getEmpListByDept" + deptNo);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getEmpListByDept(deptNo);
        FlushCacheHelper.setCacheForMethod("getEmpListByDept" + deptNo, itemList);
        return itemList;
    }

    public static List<ListItem> getEmpListByPositionNo(int positionNo, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getEmpListByPositionNo" + positionNo);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getEmpListByPositionNo(positionNo);
        FlushCacheHelper.setCacheForMethod("getEmpListByPositionNo" + positionNo, itemList);
        return itemList;
    }

    public static List<ListItem> getEmployeeManagerByDept(int deptNo, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getEmployeeManagerByDept" + deptNo);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getEmployeeManagerByDept(deptNo);
        FlushCacheHelper.setCacheForMethod("getEmployeeManagerByDept" + deptNo, itemList);
        return itemList;
    }

    public static List<ListItem> getCustomerCompanyList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getCustomerCompanyList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getCustomerCompanyList();
        FlushCacheHelper.setCacheForMethod("getCustomerCompanyList", itemList);
        return itemList;
    }

    public static List<ListItem> getCustomerPersonList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getCustomerPersonList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getCustomerPersonList();
        FlushCacheHelper.setCacheForMethod("getCustomerPersonList", itemList);
        return itemList;
    }

    public static List<ListItem> getPartnerList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getPartnerList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getPartnerList();
        FlushCacheHelper.setCacheForMethod("getPartnerList", itemList);
        return itemList;
    }

    public static List<ListItem> getPositionList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getPositionList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getPositionList();
        FlushCacheHelper.setCacheForMethod("getPositionList", itemList);
        return itemList;
    }

    public static List<ListItem> getPositionLevelList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getPositionLevelList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getPositionLevelList();
        FlushCacheHelper.setCacheForMethod("getPositionLevelList", itemList);
        return itemList;
    }

    public static List<ListItem> getPositionLevelListByDept(int dept, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getPositionLevelListByDept" + dept);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getPositionLevelListByDept(dept);
        FlushCacheHelper.setCacheForMethod("getPositionLevelListByDept" + dept, itemList);
        return itemList;
    }

    public static List<ListItem> getUnusedUserList(boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getUnusedUserList");
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getUnusedUserList();
        FlushCacheHelper.setCacheForMethod("getUnusedUserList", itemList);
        return itemList;
    }

    public static List<ListItem> getPositionListBydept(int dept, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getPositionListBydept" + dept);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getPositionListBydept(dept);
        FlushCacheHelper.setCacheForMethod("getPositionListBydept" + dept, itemList);
        return itemList;
    }

    public static List<ListItem> getCityListByProvince(int dept, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getCityListByProvince" + dept);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getCityListByProvince(dept);
        FlushCacheHelper.setCacheForMethod("getCityListByProvince" + dept, itemList);
        return itemList;
    }

    public static List<ListItem> getDistrictListByCity(int city, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getDistrictListByCity" + city);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getDistrictListByCity(city);
        FlushCacheHelper.setCacheForMethod("getDistrictListByCity" + city, itemList);
        return itemList;
    }

    public static List<ListItem> getDeptTypeBydeptNo(int deptNo, boolean isReadCached) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getDeptTypeBydeptNo" + deptNo);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getDeptTypeBydeptNo(deptNo);
        FlushCacheHelper.setCacheForMethod("getDeptTypeBydeptNo" + deptNo, itemList);
        return itemList;
    }

    public static List<ListItem> getEmployeeByStatus(int status, boolean isReadCached,int userNo) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getEmployeeByStatus" + status + userNo);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getEmployeeByStatus(status);
        FlushCacheHelper.setCacheForMethod("getEmployeeByStatus" + status + userNo, itemList);
        return itemList;
    }
    public static List<ListItem> getEmployeeByStatusAgainst(int status, boolean isReadCached,int userNo) {
        List<ListItem> itemList = new ArrayList<ListItem>();
        if (isReadCached) {
            itemList = FlushCacheHelper.getCacheForMethod("getEmployeeByStatusAgainst" + status + userNo);
            if (itemList != null && itemList.size() != 0) {
                return itemList;
            }
        }
        itemList = EnumListModel.getEmployeeByStatusAgainst(status);
        FlushCacheHelper.setCacheForMethod("getEmployeeByStatusAgainst" + status + userNo, itemList);
        return itemList;
    }

}
