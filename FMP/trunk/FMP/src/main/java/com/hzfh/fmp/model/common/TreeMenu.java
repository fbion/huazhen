package com.hzfh.fmp.model.common;

import java.io.Serializable;
import java.util.List;

public class TreeMenu implements Serializable {
	private String name;
	private List<TreeItem> treeItems;

	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}

	public List<TreeItem> getTreeItems() {
		return treeItems;
	}

	public void setTreeItems(List<TreeItem> treeItems) {
		this.treeItems = treeItems;
	}

}
