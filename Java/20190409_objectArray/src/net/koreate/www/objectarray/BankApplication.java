package net.koreate.www.objectarray;

import java.util.Scanner;

public class BankApplication {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Account[] accounts = new Account[100];
		
		boolean isRun = true;
		
		int selectNo = 0;
		
		while(isRun) {
			System.out.println("=======================================");
			System.out.println("1. 계좌생성 | 2. 계좌조회 | 3. 입금 | 4. 출금 | 5. 종료");
			System.out.println("=======================================");
			
			System.out.println("번호를 선택해 주세요 > ");
			selectNo = sc.nextInt();
			
			switch(selectNo) {

			case 1:
				System.out.println("계좌생성");
				System.out.println("계좌주 이름을 입력해주세요 > ");
				String name = sc.next();
				System.out.println("계좌번호 > ");
				String accountNumber = sc.next();
				System.out.println("초기 입금액 >");
				int money = sc.nextInt();
				System.out.println("비밀번호 입력 > ");
				String password = sc.next();
				
				Account account = new Account(name,accountNumber,money,password);
				
				boolean isChecked = true;
				
				for(Account a : accounts) {
					if(a != null && a.accountNumber.equals(accountNumber)) {
						System.out.println("이미 계좌가 존재합니다.");
						isChecked = false;
						break;
					}
				}
				
				if(isChecked) {
					for(int i=0; i< accounts.length; i++) {
						if(accounts[i] == null) {
							accounts[i] = account;
							System.out.println("계좌생성이 완료 되었습니다.");
							break;
						}						
					}
				}				
				break;
				
			case 2:
				/*
				 * for(Account a : accounts) { if( a != null) a.printAccount(); }
				 */
				
				System.out.println("계좌 조회");
				System.out.println("계좌번호 입력 > ");
				accountNumber = sc.next();
				System.out.println("비밀번호 입력 > ");
				password = sc.next();
				
				for(Account a : accounts) {
					if(a != null && a.accountNumber.equals(accountNumber) && a.password.equals(password)) {
						a.printAccount();
						break;						
					}
				}
				
				break;
			case 3:
				System.out.println("입금 ");
				System.out.println("계좌번호를 입력해주세요 > ");
				accountNumber = sc.next();
				System.out.println("입금액을 입력해주세요 > ");
				money = sc.nextInt();
				
				Account a = null;
				
				for(int i=0; i < accounts.length; i++) {
					if(accounts[i] != null && accounts[i].accountNumber.equals(accountNumber)) {
						a = accounts[i];
						break;
					}
				}
				
				if(a != null) {
					a.money = a.money + money;
					System.out.println("입금 완료");
				}else {
					System.out.println("존재하지 않는 계좌 입니다.");
				}
				
				break;
			case 4:
				System.out.println("출금");
				System.out.println("출금 게좌");
				accountNumber = sc.next();
				System.out.println("비밀번호 입력 > ");
				password = sc.next();
				System.out.println("출금 금액 >");
				money = sc.nextInt();
				
				Account a1 = null;
				
				for(Account account1 : accounts) {
					if(accounts != null && account1.accountNumber.equals(accountNumber) &&account1.password.equals(password)) { 
						a1 = account1;
						break;
					}
					
				}
				
				if(a1 != null) {
					if((a1.money = money) >= 0 ) {
						System.out.println(a1.name+"님의 게좌에서 "+money+"만큼 출금되었습니다.");
					}else {
						System.out.println("출금액이 예금액보다 클 수 없습니다.");
					}
					
				} else {
					System.out.println("일치 하는 계좌 정보가 없습니다.");
				}
				
				break;
			case 5: default:
				isRun = false;
				System.out.println("시스템 종료");
				break;
			
			}
		}
		
		sc.close();

	}

}
