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
					deleteBook(getSelectNum("수정할 책의 도서관리 번호를 입력하세요 >"));		
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
		for(Book b : books) {
			if(b != null) printBookInfo(b);
			}
		//for(int i=0; i < count-1; i++)printBookInfo(books[i]);
		
	}

	// 도서 정보 수정
	public void updateBook() {
		System.out.println("3. 도서수정");
		selectNo = getSelectNum("수정할 책의 도서관리번호를 입력하세요 >");
		printBookInfo(books[selectNo-1]);
		// case문 하나 더 만들어서 수정.
		int selectNo2;
		boolean isRun2 = true;
		while(isRun2) {
			System.out.println("==========================");
			System.out.println("1.제목수정 | 2.저자수정 | 3.수정완료");
			System.out.println("==========================");
			selectNo2 = getSelectNum("번호를 선택하세요>");
			
			switch(selectNo2) {
				case 1 :
					mdBookTitle(selectNo);					
					break;
				case 2 :
					mdBookAuthor(selectNo);
					break;
				case 3 :								
					System.out.println("수정완료");
					isRun2 = false;
					break;				
				default : 
					System.out.println("등록된 메뉴가 아닙니다.");
			
			}
		}
	}
	
	// 도서 목록에서 책 정보 삭제
	public void deleteBook(int index) {

		// 인덱스 번호를 받아서 삭제하고
		// 뒤의 책 번호를 한칸씩 앞으로 당김.
		// 마지막 null대입.

		//
		// 책을 등록할때 null이 아니면 거기에 객체를 생성해서 넣어주고
		// 책의 리스트를 출력할때 null이면 출력하지 않음.
		// 책을 삭제할때 삭제할곳을 null으로 해주면
		// 책을 새로 등록할때 null인곳을 찾아서 책을 새로 등록시켜줌.
		
		if( books[index-1] != null) {			
			System.out.println("4. 도서삭제");
			if(books[index] != null) {
				for(int i =(index-1); i < count; i++) {
					books[index-1].title = books[index].title;
					books[index-1].author = books[index].author;
				}
				count--;
				books[count] = null;				
			}		
			
		}else System.out.println("책의 정보가 존재하지 않습니다.");
		
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
		if( books[index-1] != null) {
			
			System.out.println("제목 수정");
			books[index-1].title = getData("제목 입력 >");
			System.out.println("제목 수정 완료");
		}else System.out.println("책의 정보가 존재하지 않습니다.");
		
	}
	
	public void mdBookAuthor(int index){
	if( books[index-1] != null) {
			
			System.out.println("저자 수정");
			books[index-1].author = getData("저자 입력 >");
			System.out.println("저자 수정 완료");
		}else System.out.println("책의 정보가 존재하지 않습니다.");
		
		
	}
		
	public static void main(String[] args) {
		new BookManagement();
	}

}
