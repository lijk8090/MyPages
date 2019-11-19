package cn.com.infosec.mypages.entity;

import java.util.List;

public class PageEntity<T> {

	private int totalNO;
	private int pageNO;
	private int pageSize;

	private List<T> data;

	public PageEntity() {
		super();
		this.totalNO = 0;
		this.pageNO = 1;
		this.pageSize = 10;
		this.data = null;
	}

	public PageEntity(int totalNO, int pageNO, int pageSize, String orderby, List<T> data) {
		super();
		this.totalNO = totalNO;
		this.pageNO = pageNO;
		this.pageSize = pageSize;
		this.data = data;
	}

	public int getTotalNO() {
		return totalNO;
	}

	public void setTotalNO(int totalNO) {
		this.totalNO = totalNO;
	}

	public int getPageNO() {
		return pageNO;
	}

	public void setPageNO(int pageNO) {
		this.pageNO = pageNO;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "PageEntity [totalNO=" + totalNO + ", pageNO=" + pageNO + ", pageSize=" + pageSize + ", data=" + data + "]";
	}

}
