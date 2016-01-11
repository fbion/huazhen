package com.hzfh.fmp.model.permission.view;

import com.hzfh.api.permission.model.RoleElement;
import com.hzfh.fmp.model.common.enumeration.TagPermissionType;
import com.hzfh.fmp.model.permission.RoleElementModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paul on 15-4-7.
 */
public class PagePermissionView {
    private List<TagPermissionView> tagPermissionViewList;
    private Map<String,TagPermissionType> tagPermissionMap;

    private boolean create;
    private boolean read;
    private boolean del;
    private boolean edit;

    public boolean isCreate() {
        return create;
    }

    public boolean isRead() {
        return read;
    }

    public boolean isDel() {
        return del;
    }

    public boolean isEdit() {
        return edit;
    }

    public Map<String, TagPermissionType> getTagPermissionMap() {
        return tagPermissionMap;
    }

    public List<TagPermissionView> getTagPermissionViewList() {
        return tagPermissionViewList;
    }

    public PagePermissionView(String alias, int roleId) {
        RoleElement roleElement = RoleElementModel.getRoleElementByRoleIdAndAlias(alias, roleId);
        /*if(roleElement == null){

        }*/
        this.del = roleElement.getDel() == 1;
        this.create = roleElement.getNewItem() == 1;
        this.edit = roleElement.getEdit() == 1;
        this.read = roleElement.getQuery() == 1;

        List<RoleElement> roleElementList = RoleElementModel.getSubRoleElementsByRoleIdAndParentEleId(roleElement.getEleNo(),roleId);

        if(this.tagPermissionMap == null)
            this.tagPermissionMap = new HashMap<String, TagPermissionType>();

        if (this.tagPermissionViewList == null)
            this.tagPermissionViewList = new ArrayList<TagPermissionView>();

        for (RoleElement roleSubElement : roleElementList){

            TagPermissionType tagPermissionType = TagPermissionType.none;
            if (roleSubElement.getQuery() == 1)
                tagPermissionType = TagPermissionType.query;
            if (roleSubElement.getEdit() == 1)
                tagPermissionType = TagPermissionType.edit;
            this.tagPermissionMap.put(roleSubElement.getName(),tagPermissionType);
            this.tagPermissionViewList.add(new TagPermissionView(roleSubElement.getName(),tagPermissionType));
        }
    }

    public TagPermissionType getTagPermission(String elementName){
        return this.tagPermissionMap.get(elementName);
    }
}
