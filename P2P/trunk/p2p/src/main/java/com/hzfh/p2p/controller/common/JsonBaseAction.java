package com.hzfh.p2p.controller.common;

import java.util.Collections;
import java.util.List;

/**
 * Created by paul on 14-12-19.
 */
public abstract class JsonBaseAction<T> extends BaseAction {

    public enum MessageType {
        Info, Warning, Error
    }

    public class Message<T> {

        private MessageType type;
        private T data;
        private String description;

        public MessageType getType() {
            return type;
        }

        public void setType(MessageType type) {
            this.type = type;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }

    public Message message;

    public Message getMessage() {
        return message;
    }
    private List<T> resultList = Collections.emptyList();
	private int pageSize = 0;
	private int pageIndex = 0;
	private int pageCount = 0;
	private int recordCount = 0;// 记录数

	public List<T> getResultList() {
		return resultList;
	}
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	
}

