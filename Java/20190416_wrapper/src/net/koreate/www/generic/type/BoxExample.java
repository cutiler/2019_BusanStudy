package net.koreate.www.generic.type;

public class BoxExample {

	public static void main(String[] args) {
		
		Box appleBox = new Box();
		Apple apple = new Apple();
		appleBox.setObj(apple);
		Apple apple2 = (Apple)appleBox.getObj();
		
		Box box = new Box();
		box.setObj(new Orange());
		Orange orange = null;
		
		if(box.getObj() instanceof Orange) {
			orange = (Orange)box.getObj();
		}
		
		ShowBox<Apple> showBox = new ShowBox<>();
		Apple showApple = showBox.getE();
		
		ShowBox<Orange> showBox2 = new ShowBox<>();
		Orange showOrange = showBox2.getE();
		
		
	}
	
}
