package stack;

import java.util.Stack;

class Coin{
	
	private int value;
	
	public Coin(int value){
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
}


public class StackExample {
	
	public static void main(String[] args) {
		
		Stack<Coin> coinBox = new Stack<>();
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
		
		// 값을 가져오는 peek
		
		Coin coin = coinBox.peek();
		System.out.println("value : "+coin.getValue());
		System.out.println(coinBox.size());
		
		while(!coinBox.isEmpty()) {
			Coin c = coinBox.pop();
			System.out.println(c.getValue()+"원");
		}
		System.out.println(coinBox.size());
		
		
		
	}

}
