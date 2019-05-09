package net.koreate.www.trywithresources;

import java.nio.file.FileSystemNotFoundException;
import java.util.Scanner;

public class TryWithResourcesExample {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int selectNo = 0;
		
		try {
		selectNo = sc.nextInt();
		System.out.println(selectNo);
		}catch(java.util.InputMismatchException e) {
			System.out.println("정수만 입력해 주세요!");
		}finally {
			if(sc != null) {
				sc.close();
			}
		}
		
		// try - with - resource
		
		try(Scanner sc1 = new Scanner(System.in)){
			selectNo = sc1.nextInt();
		}catch(java.util.InputMismatchException e) {
			System.out.println("작성 오류");
		}
		
		try(FileOutputStream fos = new FileOutputStream("net.koreate.www.trywithresources.FileOutputStream")){
			fos.write();
		}catch(FileSystemNotFoundException e) {
			System.out.println("해당 파일을 찾을 수 없습니다.");
		}catch(Exception e) {
			
		}
		
		
	}

}
