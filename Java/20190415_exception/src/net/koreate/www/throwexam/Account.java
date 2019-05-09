package net.koreate.www.throwexam;

public class Account {
	
	private long balance;
	
	public Account() {}
	
	public long getBalance() {
		
		return this.balance;
	} 
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) throws BalanceInsufficientException{
		if(balance < money) {
			throw new BalanceInsufficientException("잔고부족 오류 : "+(money - balance)+" 모자름");
		}
		balance -= money;
	}

}
