package book;

import java.util.Date;

import oracle.base.Book;

public class BookRowNum extends Book{
		
	private int rnum;
	
	public BookRowNum(int rnum, int num, String title, String author, Date regDate) {
		super(num, title, author, regDate);
		this.rnum = rnum;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	@Override
	public String toString() {
		return "BookRowNum [rnum=" + rnum + "]" + super.toString();
	}
	
	
	

}
