package com.cutiler.www;

import java.util.Scanner;

public class BookManagement {
	Scanner sc = new Scanner(System.in);
	
	// 도서목록
	Book[] books = new Book[100];
	// 프로그램 실행 flag
	boolean isRun = true;
	// 메인 메뉴 선택 번호
	int selectNo = 0;
	// 도서관리 번호
	int count=1;
	
	String title;
	String author;

	public BookManagement(){
		run();
	}
	
	public void run() {
		
		
		
		while(isRun) {
			System.out.println("================================================");
			System.out.println("1.도서등록 | 2. 도서목록 | 3.도서수정 | 4.도서삭제 | 5. 종료");
			System.out.println("================================================");
			selectNo = getSelectNum("번호를 선택하세요>");
			
			switch(selectNo) {
				case 1 :
					registerBook();					
					break;
				case 2 :
					selectBook();
					break;
				case 3 :
					updateBook();
					break;
				case 4 : 
					deleteBook();
					break;
				case 5 : 
					terminate();
					break;	
				default : 
					System.out.println("등록된 메뉴가 아닙니다.");
			
			}
		}
	}
	
	// 프로그램 종료
	public void terminate() {
		System.out.println("프로그램 종료");
		isRun = false;
	}

	// 도서 등록
	public void  registerBook() {
		System.out.println("1. 도서등록");
		
		title = getData("등록할 책의 제목을 입력하세요 >");
		author = getData("등록할 책의 저자입력하세요 >");

		
		books[count-1] = new Book(count, title, author);
		count++;
		System.out.println("등록완료");
	}
	
	// 도서 목록 출력
	public void selectBook() {
		System.out.println("2. 도서목록");
		for(Book b : books) printBookInfo(b);

		
	}

	// 도서 정보 수정
	public void updateBook() {
		System.out.println("3. 도서수정");
		selectNo = getSelectNum("수정할 책의 도서관리번호를 입력하세요 >");
		printBookInfo(books[selectNo]);
		// case문 하나 더 만들어서 수정.
		
		while(isRun) {
			System.out.println("==========================");
			System.out.println("1.제목수정 | 2.저자수정 | 3.수정완료");
			System.out.println("==========================");
			selectNo = getSelectNum("번호를 선택하세요>");
			
			switch(selectNo) {
				case 1 :
					mdBookTitle(getSelectNum("수정할 책의 도서관리 번호를 입력하세요 >"));					
					break;
				case 2 :
					mdBookAuthor();
					break;
				case 3 :
					System.out.println("수정완료");
					isRun = false;
					break;				
				default : 
					System.out.println("등록된 메뉴가 아닙니다.");
			
			}
		}
	}
	
	// 도서 목록에서 책 정보 삭제
	public void deleteBook() {
		System.out.println("4. 도서삭제");
		// 인덱스 번호를 받아서 삭제하고
		// 뒤의 책 번호를 한칸씩 앞으로 당김.
		// 마지막 null대입.
	}
	
	// 책 정보 출력
	public void printBookInfo(Book b) {
		System.out.println(b.toString());
	}
	
	// 도서관리번호로 책 정보 찾기
	public Book findBook(int num) {
		return null;
	}
	
	// 사용자에게 메시지를 전달 받아 출력하고 문자열 값 받아 반환
	String getData(String message) {
		System.out.println(message);
		return sc.next();
	}
	
	// 번호 선택 받기
	int getSelectNum(String message) {
		System.out.println(message);
		return sc.nextInt();
	}
	
	public void mdBookTitle(int index) {
		if( books[index] != null) {
			printBookInfo(books[index]);
			
		}else System.out.println("책의 정보가 존재하지 않습니다.");
		
	}
	
	public void mdBookAuthor(){
		
	}
		
	public static void main(String[] args) {
		new BookManagement();
	}

}
