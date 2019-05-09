package oracle.base;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
	
	// 도서관리 번호
	private int num;
	// 도서 제목
	private String title;
	// 도서 저자
	private String author;
	// 등록일
	private Date regDate;
	
	
	public Book() {}

	public Book(int num, String title, String author) {
		this.num = num;
		this.title = title;
		this.author = author;
	}

	public Book(int num, String title, String author, Date regDate) {
		super();
		this.num = num;
		this.title = title;
		this.author = author;
		this.regDate = regDate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getRegDate() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.regDate);
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Book{ [num : "+this.num+"] [title : " +this.title +"] [author : " + this.author + "][regdate : "+getRegDate()+"]}";
	}

}
