package net.koreate.testboard.util;

public class Criteria {
	
	private int page;
	private int pagePerNum;
	
	public Criteria() {
		this(1,10);
		System.out.println("Criteria 기본 생성자 호출");
	}
	
	public Criteria(int page, int pagePerNum) {
		System.out.println("cri 생성자 호출");
		this.page = page;
		this.pagePerNum = pagePerNum;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagePerNum() {
		return pagePerNum;
	}
	public void setPagePerNum(int pagePerNum) {
		this.pagePerNum = pagePerNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", pagePerNum=" + pagePerNum + "]";
	}
	
	

}
