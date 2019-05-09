package net.koreate.www.clazz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassExample {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Person person = new Person();
		
		Class pClass1 = person.getClass();
		System.out.println(pClass1.getName());
		
		Class pClass2 = Person.class;
		System.out.println(pClass2.getName());
		
		Class pClass3 = Class.forName("net.koreate.www.clazz.Person");
		System.out.println(pClass3.getName());
		System.out.println(pClass3.getSimpleName());
		System.out.println(pClass3.getPackage().getName());
		
		Field[] fields = pClass3.getDeclaredFields();
		System.out.println("Fields =======================================");
		for(Field f : fields) {
			System.out.println(f.getType().getSimpleName()+" "+f.getName());
		}
		
		System.out.println("Constructor =======================================");
		Constructor[] cons = pClass3.getDeclaredConstructors();
		
		for(Constructor c : cons) {
			System.out.print(c.getName()+"(");
			
			Class[] param = c.getParameterTypes();
			for(int i=0; i < param.length; i++) {
			
				System.out.print(param[i].getName());
				if(i < param.length -1) System.out.print(", ");
			}
			System.out.println(")");
		}
		
		
		Method[] methods = pClass3.getDeclaredMethods();
		
		for(Method m : methods) {
			System.out.print(m.getName()+"(");
			Class[] param = m.getParameterTypes();
			for(int i=0; i < param.length; i++) {
				
				System.out.print(param[i].getName());
				if(i < param.length -1) System.out.print(", ");
			}
			
			System.out.println(")");
		}
		
		try {
			Person p = (Person)pClass3.newInstance();
			Person p1 = (Person)Class.forName("net.koreate.www.clazz.Person").newInstance();
		} catch (ClassNotFoundException |InstantiationException | IllegalAccessException e) {
	
			e.printStackTrace();
		}
		
		
	}

}
