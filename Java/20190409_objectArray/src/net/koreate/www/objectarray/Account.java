package net.koreate.www.objectarray;

public class Account {
	
	//계좌주
	String name;
	//계좌번호
	String accountNumber;
	//예금액
	int money;
	//비밀번호
	String password;
	
	
	
	public Account(String name, String accountNumber, int money, String password) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.money = money;
		this.password = password;
	}



	public void printAccount() {
		System.out.println("Account [name=" + this.name +
				", accountNumber=" + this.accountNumber +
				", money=" + this.money);
	}
	




	
	
	
	

}
