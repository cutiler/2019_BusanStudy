package net.koreate.www.clazz.format;

import java.text.MessageFormat;

public class MessageFormatExample {

	public static void main(String[] args) {
		
		String id = "java";
		String name = "최기근";
		String tel  = "010-9486-7166";
		
		String text = "회원 ID : {0} \n 회원이름 : {1} \n 전화번호 :{2}";
		String result = MessageFormat.format(text, id,name,tel);
		System.out.println(result);
		
		String text2 = "INSERT INTO member VALUES({0},{1},{2})";
		Object[] arguments = {id,name,tel};
		String result2 = MessageFormat.format(text2, arguments);
		System.out.println(result2);

		
	}

}
