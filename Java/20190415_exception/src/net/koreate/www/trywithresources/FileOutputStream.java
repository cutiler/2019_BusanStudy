package net.koreate.www.trywithresources;

public class FileOutputStream implements AutoCloseable {
	
	public String file;
	
	public FileOutputStream(String file) {
		this.file = file;
	}
	
	public void write() {
		System.out.println(file+"을 내보냅니다.");
	}

	@Override
	public void close() throws Exception {
		System.out.println(file+"자원을 해제합니다.");
		
	}
	
	

}
