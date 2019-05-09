package io.object;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInOutExample {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		try ( FileOutputStream fos = new FileOutputStream("object.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				FileInputStream fis = new FileInputStream("object.dat");
				ObjectInputStream ois = new ObjectInputStream(fis) ) {

			//fos = new FileOutputStream("object.dat");
			
			oos.writeObject(new Integer(100));
			oos.writeObject(new Double(3.14));
			oos.writeObject(new int[] {1,2,3,4});
			oos.writeObject(new String("최기근"));
			oos.flush();
			
			Integer obj1 = (Integer)ois.readObject();
			Double obj2 = (Double)ois.readObject();
			int[] obj3 = (int[])ois.readObject();
			String obj4 = (String)ois.readObject();
			
			System.out.println(obj1);
			System.out.println(obj2);
			System.out.println(obj3[0]+" / "+ obj3[1]);
			System.out.println(obj4);
			
			
			
		}  catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
