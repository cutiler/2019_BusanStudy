
	package io.serialversion;

	import java.io.BufferedOutputStream;
	import java.io.FileOutputStream;
	import java.io.ObjectOutputStream;

	public class SerialVersionUIDOutExample {
		
		public static void main(String[] args) throws Exception {
			
			FileOutputStream fos = new FileOutputStream("object.dat");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			ClassA a = new ClassA();
			a.field1 = 1;
			
			oos.writeObject(a);
			oos.flush();
			oos.close();
			bos.close();
			fos.close();
			
		}

	}



