package io.object;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableExample {
	
	public static void main(String[] args) throws Exception{
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
		
		Person p = new Person();
		p.field1 = "이순신";
		oos.writeObject(p);
		oos.flush();
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.dat"));
		
		Person p1 = (Person)ois.readObject();
		System.out.println(p1.field1);
		ois.close();
		
		
		
	}

}
