package oracle.base;

import java.util.Scanner;

import oracle.pstmt.OraclePSTMTImpl;
import oracle.util.DBHelper;
import oracle.util.OracleDAO;
/*
 * 
 *
 */
public class BookManagement {
	Scanner scanLine = new Scanner(System.in);
	Scanner scanSelectnum = new Scanner(System.in);
	
	//DATABASE DAO
	OracleDAO dao;
	
	// 프로그램 실행 flag
	boolean isRun = true;
	// 메인 메뉴 선택 번호
	int selectNo = 0;

	public BookManagement(OracleDAO dao){
		this.dao = dao;
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
		isRun = false;
		DBHelper.close();
		System.out.println("프로그램 종료");
		
	}

	// 도서 등록
	public void  registerBook() {
		System.out.println("1. 도서등록");
		String title = getData("등록할 도서의 제목을 입력해주세요 >");
		String author = getData("등록할 도서의 저자를 입력해주세요 >");
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		dao.insert(book);
		System.out.println("등록완료");
	}
	
	
	// 도서 목록 출력
	public void selectBook() {
		System.out.println("2. 도서목록");
		if(dao.select() != null) {
			for(Book b : dao.select()) {
				printBookInfo(b);
			}
		}
	}

	// 도서 정보 수정
	public void updateBook() {
		System.out.println("3. 도서수정");
			int num = getSelectNum("수정하실 책의 관리번호를 입력하세요 > ");
			
			Book b = dao.selectBook(num);
			
			System.out.println("UPDATE BOOK : "+b);
			
			if(b == null) {
				System.out.println("등록된 번호의 책이 존재하지않습니다.");
				return;
			}
		
			boolean isUpdate = true;
			
			while(isUpdate) {
				
				System.out.println("============================");
				System.out.println("1.제목 수정 | 2. 저자 수정 |3. 수정완료");
				System.out.println("============================");
				
				selectNo = getSelectNum("번호입력 >");
				
				switch(selectNo) {
					case 1 : 
						System.out.println("제목 수정");
						String title = getData("제목 입력 >");
						b.setTitle(title);
						//b.setRegDate(new Date());
						System.out.println("제목 수정 완료");					
						break;
					case 2 : 
						System.out.println("저자 수정");
						String author = getData("저자 입력 >");
						b.setAuthor(author);
						//b.setRegDate(new Date());
						System.out.println("저자 수정 완료");
						break;
					case 3 :
						dao.update(b);
						System.out.println("수정완료");
						isUpdate = false;
						break;
				}
			}
	}
	
	// 도서 목록에서 책 정보 삭제
	public void deleteBook() {
		System.out.println("4. 도서삭제");
		int num = getSelectNum("삭제할 책의 관리번호를 입력해 주세요 > ");
		
		Book b = dao.selectBook(num);
		
		System.out.println("DELETE BOOK : "+b);
		
		if(b != null) {
			dao.delete(num);
			System.out.println("삭제완료");
			return;
		}
		
		System.out.println("해당되는 도서번호의 책이 존재하지 않습니다.");
		
	}
	
	// 책 정보 출력
	public void printBookInfo(Book b) {
		System.out.println(b.toString());
	}
	
	
	// 사용자에게 메시지를 전달 받아 출력하고 문자열 값 받아 반환
	String getData(String message) {
		System.out.println(message);
		return scanLine.nextLine();
	}
	
	// 번호 선택 받기
	int getSelectNum(String message) {
		System.out.println(message);
		return scanSelectnum.nextInt();
	}
		
	public static void main(String[] args) {
	//	Connection con = DBHelper.getConnection();
		//con = DBHelper.getConnection();
		//new BookManagement(new OracleStatementImpl());
		new BookManagement(new OraclePSTMTImpl());
	}

}
