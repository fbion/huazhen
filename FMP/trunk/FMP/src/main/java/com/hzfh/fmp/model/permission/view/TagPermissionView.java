package com.hzfh.fmp.model.permission.view;

import com.hzfh.fmp.model.common.enumeration.TagPermissionType;

/**
 * Created by paul on 15-4-7.
 */
public class TagPermissionView {
    private String tagName;
    private TagPermissionType tagPermissionType;

    public TagPermissionType getTagPermissionType() {
        return tagPermissionType;
    }

    public String getTagName() {
        return tagName;
    }

    public TagPermissionView(String tagName, TagPermissionType tagPermissionType) {
        this.tagName = tagName;
        this.tagPermissionType = tagPermissionType;
    }
}
