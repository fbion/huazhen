package com.hzfh.fmp.model.common.view;

import java.io.Serializable;

import com.hzframework.helper.StringHelper;

/**
 * Created by paul on 15-1-6.
 */
public class ListItem implements Serializable {
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {

        return text;
    }

	public ListItem() {
	}

	public ListItem(String text, String value) {
        this.text = text;
        this.value = value;
    }
	public ListItem(String id,String pId,String name){
		this.id = Integer.valueOf(id);
		this.pId = Integer.valueOf(pId);
		this.name = name;
	}
	public ListItem(String id,String pId,String name,String parentNo,String type){
		this.id = Integer.valueOf(id);
		this.pId = Integer.valueOf(pId);
		this.name = name;
		if(!StringHelper.isNullOrEmpty(parentNo))
			this.parentNo = Integer.valueOf(parentNo);
		if(!StringHelper.isNullOrEmpty(type))
			this.type = Byte.valueOf(type);
	}

    public void setText(String text) {
        this.text = text;
    }

    private String text;
    private String value;
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentNo() {
		return parentNo;
	}

	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	private int id;
    private int pId;
    private String name;
    private int parentNo;
    private byte type;
    
}
