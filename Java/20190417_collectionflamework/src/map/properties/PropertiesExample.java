package map.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PropertiesExample {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Properties prop = new Properties();
		prop.put("hi", "hello");
		
		System.out.println(prop.get("hi"));
		System.out.println(prop.getProperty("hi"));
		System.out.println(prop.getProperty("agdaqedsg","Hello World"));
		System.out.println("===========================");
		
		
		Properties properties = new Properties();
		String path = PropertiesExample.class.getResource("../../properties/database.properties").getPath();
		properties.load(new FileReader(path));
		
		String driver = properties.getProperty("driver");
		System.out.println(driver);
		String url = properties.getProperty("url");
		System.out.println(url);
		String username = properties.getProperty("username");
		System.out.println(username);
		String password = properties.getProperty("password");
		System.out.println(password);
		String hangul = properties.getProperty("hangul");
		System.out.println(hangul);
		
	}

}
