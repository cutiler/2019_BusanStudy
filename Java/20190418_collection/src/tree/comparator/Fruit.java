package tree.comparator;

public class Fruit {
	
	private String name;
	private int price;
	
	public Fruit(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Fruit [name=" + name + ", price="+price+ "]";
	}
	
	

}
