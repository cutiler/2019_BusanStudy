package io.object;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExtendSerializableExample {
	
	public static void main(String[] args) throws Exception{
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
		
		Child c = new Child();
		c.field1 = "홍길동";
		c.field2 = "최기근";
		oos.writeObject(c);
		oos.flush();
		oos.close();		
		
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.dat"));
		
		Child readChild = (Child)ois.readObject();
		System.out.println("readChild.field1 : "+readChild.field1);
		System.out.println("readChild.field2 : "+readChild.field2);
		ois.close();
		
	}

}
