package generictest;

public class Child<K,V,M> extends Pair<K,V>{
	
	private M Num;
	
	
	
	

	public Child() {
	
	}

	public Child(K key, V value) {
		super(key, value);	
	}
	
	public Child(K key, V value, M num) {
		super(key, value);
		this.Num = num;
		
	}
	
	

	public M getNum() {
		return Num;
	}

	public void setNum(M num) {
		Num = num;
	}
	
	

}
