package net.koreate.www.throwexam;


// 통장 잔고 부족 예외
public class BalanceInsufficientException extends Exception{
	
	public BalanceInsufficientException() {}
	public BalanceInsufficientException(String message) {
		super(message);
	}

}
