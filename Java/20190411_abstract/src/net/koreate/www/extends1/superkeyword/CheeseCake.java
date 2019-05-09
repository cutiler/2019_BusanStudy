package net.koreate.www.extends1.superkeyword;

public class CheeseCake extends Cake {
	
	public int size;
	
	
	
	public CheeseCake(int size1, int size2) {
		super(size1);
		this.size = size2;
	}

	@Override
	public void showCakeSize() {
		System.out.println("부모 케익 사이즈 : "+ super.size);
		System.out.println("치즈 케익 사이즈 : "+ this.size);
	}

	

}
