package io.object;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Student implements Externalizable{

	String name;
	int age;	
	
	public Student() {}
	
	@Override
	public void readExternal(ObjectInput o) throws IOException, ClassNotFoundException {

		name = o.readUTF();
		age = o.readInt();
		
	}

	@Override
	public void writeExternal(ObjectOutput o) throws IOException {
		
		o.writeUTF(name);
		o.writeInt(age);
		
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
	
}


public class ExternalizableExample  {
	
	public static void main(String[] args) throws Exception {
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
		
		Student s = new Student();
		s.name = "최기근";
		s.age = 20;
		
		oos.writeObject(s);
		oos.flush();
		oos.close();
		
		
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.dat"));
		
		Student readStudent = (Student)ois.readObject();
		System.out.println(readStudent);
		ois.close();
		
		
	}

}
