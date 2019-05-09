package io.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {
	
	public static void main(String[] args) {
		// exists 경로가 존재하는지 확인
		
		File fir = new File("C:/Temp/dir");
		
		if(!fir.exists()) {
			System.out.println("디렉토리가 존재하지 않습니다.");
			//fir.mkdir();
			fir.mkdirs();
		}
		
		File file = new File("C:/Temp/file3.txt");
		if(file.exists() == false) {
			// 새로운 파일 생성
			try {
				file.createNewFile();
				System.out.println("file1.txt 파일 생성");
			} catch (IOException e) {				
				System.out.println("file1.txt 파일 생성 실패 : "+ e.getMessage());
			}
		}
		
		File temp = new File("c:/Temp");
		if(!temp.exists()) { 
			temp.mkdirs();			
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		File[] contents = temp.listFiles();
		System.out.println(contents.length);
		System.out.println("날짜                            시간                  형태                        크기               이름");
		System.out.println("=========================================================");
		for(File f : contents) {
			System.out.print(sdf.format(new Date(f.lastModified())));
			if(f.isDirectory()) {
				System.out.println("\t<DIR>\t\t\t"+f.getName());
			}else {
				System.out.println("\t\t\t"+f.length()+"\t"+f.getName());
			}
		}
		
		
	}

}
