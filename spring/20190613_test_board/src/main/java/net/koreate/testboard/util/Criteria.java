package net.koreate.testboard.util;

public class Criteria {
	
	private int page;		// 현재 페이지.
	private int pagePerNum; // 보여줄 게시글 수
	
	public Criteria() {
		this(1,10);
		System.out.println("Criteria 기본 생성자 호출");
	}
	
	public Criteria(int page, int pagePerNum) {
		System.out.println("cri 생성자 호출");
		setPage(page);
		setPagePerNum(pagePerNum);
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page < 1) {
			page = 1;
			return;
		}
		this.page = page;
	}
	public int getPagePerNum() {
		return pagePerNum;
	}
	public void setPagePerNum(int pagePerNum) {
		
		if(pagePerNum > 100 || pagePerNum < 1) {
			pagePerNum = 10;
			return;
		}		
		
		this.pagePerNum = pagePerNum;
	}	

	public int getPageStart() {
		return (page-1)*pagePerNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", pagePerNum=" + pagePerNum + "]";
	}
	
	

}
