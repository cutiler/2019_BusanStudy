package net.koreate.www.abstracttest;

public class AnimalExample {
	
	static void animalSound(Animal animal) {
		animal.sound();
	}
	
	public static void main(String[] args) {
		Animal dog = new Dog();
		Animal cat = new Cat();
		
		dog.breathe();
		dog.sound();		
		dog.kind = "Dog";
		
		cat.breathe();
		cat.sound();
		cat.kind = "Cat";
		
		animalSound(dog);
		animalSound(cat);
		
		animalSound(new Dog());
		animalSound(new Cat());
		
		System.out.println("===============================");
		
		Animal animal = new Animal() {	
			
			@Override
			public void sound() {
				System.out.println("뭔소린지....");
			}
		};
		
		animalSound(animal);
		animalSound(new Animal() 
			{
			
				@Override
				public void sound() {
					System.out.println("이건 또 뭔....");
				}
			
			}		
		);
		
	}

}
