package com.hzframework.contract;

import java.io.Serializable;

/**
 * Created by paul on 14-12-18.
 */
public class PagingInfo implements Serializable {

	private final int DEFAULT_PAGE_SIZE = 10;
	private int pageIndex;
	private int pageSize;
	private int totalCount;

	public int getPageIndex() {
		if (this.pageIndex == 0)
			pageIndex = 1;
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		if (pageSize == 0)
			pageSize = this.DEFAULT_PAGE_SIZE;
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageCount() {
		if (this.pageSize == 0) {
			throw new ArithmeticException("pageSize");
		}
		return (int) Math.ceil(((double) this.totalCount) / this.pageSize);
	}

	public int getStartIndex() {
		return (this.pageIndex - 1) * this.pageSize;
	}

	public boolean hasPreviousPage() {
		return this.pageIndex > 1;
	}

	// / <summary>
	// / Get a Boolean value indicates the current page on the next page
	// / </summary>
	public boolean hasNextPage() {
		return this.pageIndex < this.getPageCount();
	}
}
