package net.koreate.www.throwexam;

public class AccountExample {
	
	public static void main(String[] args) {
		
		Account account = new Account();
		
		account.deposit(10000);
		
		System.out.println("잔고 : "+ account.getBalance());
		
		try {
			
			account.withdraw(15000);
			
		} catch (BalanceInsufficientException e) {
			System.out.println(e.getMessage());
		
			e.printStackTrace();
		}
		
	}

}
