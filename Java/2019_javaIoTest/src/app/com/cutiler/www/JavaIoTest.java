package app.com.cutiler.www;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaIoTest {
	
	public static final int bonus_num = 7;
	public static final int lotto_ind = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File fileindex = new File("C:\\work\\java\\2019_javaIoTest\\src\\app\\com\\cutiler\\www\\filetest.txt");
		
		int[] lottoNum = new int[8];
		int[] readFileTest = new int[8];
		
		lottoNum[lotto_ind] = 1;
		lottoNum[1] = 12; lottoNum[2] = 13; lottoNum[3] = 29; lottoNum[4] = 30;
		lottoNum[5] = 40; lottoNum[6] = 43; lottoNum[bonus_num] = 20;
		
		boolean isFileExist = fileindex.exists();
		
//		file 메소드. createNewFile() 생성 //delete() 파일 삭제 //mkdir make directory //mkdirs 경로 생성
				
		System.out.println("isFileExist 값 : "+isFileExist);
		if(isFileExist) {
			System.out.println("파일이 존재합니다.");		
			
		}else {
			System.out.println("파일이 존재하지 않아 파일을 생성합니다.");
			fileindex.createNewFile();						
		}		
		
		
		for(int i : lottoNum) {
			System.out.print(i+" ");
		}System.out.println();
		
		FileOutputStream ofstream = new FileOutputStream("C:\\work\\java\\2019_javaIoTest\\src\\app\\com\\cutiler\\www\\filetest.txt");
		
		for(int i : lottoNum) {
			ofstream.write(i);
		}
		ofstream.close();
		
		FileInputStream ifstream = new FileInputStream("C:\\work\\java\\2019_javaIoTest\\src\\app\\com\\cutiler\\www\\filetest.txt");
		
		for(int i : readFileTest) {
			readFileTest[i] = ifstream.read();
			System.out.print(readFileTest[i]+" ");
		}
		ifstream.close();



	}

}
