package net.koreate.www.clazz.system.gc;

public class Employee {
	
	public int eno;
	public Employee(int eno) {
		this.eno = eno;
		System.out.println("Employee("+eno+") 가 메모리에 생성됨.");
	}
	
	@Override
	public void finalize() {
		System.out.println("Employee ("+eno+") 가 메모리에 삭제됨.");
	}

}
