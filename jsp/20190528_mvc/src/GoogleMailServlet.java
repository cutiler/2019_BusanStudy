

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.GoogleAuthenticator;

@WebServlet("/mailTest")
public class GoogleMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	class MyAuthentication extends Authenticator{
		
		PasswordAuthentication pa;
		
		public MyAuthentication() {
			String id="serkemorion@gmail.com";
			String pw="puiopuio1212";
			
			pa = new PasswordAuthentication(id, pw);
		}
		
		public PasswordAuthentication getPasswordAuthentication() {
			return pa;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		Properties p = System.getProperties();
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.port", "587");
		System.out.println(p);
		
		Authenticator auth = new GoogleAuthenticator();
		Session session = Session.getDefaultInstance(p,auth);
		
		MimeMessage msg = new MimeMessage(session);
		
		try {
			msg.setSentDate(new Date());
			InternetAddress to = new InternetAddress("cutiler@nate.com");
			msg.setRecipient(Message.RecipientType.TO, to);
			msg.setSubject("테스트 입니다.");
			msg.setText("테스트 내용입니다.");
			msg.setHeader("Content-Type", "text/html;charset=UTF-8");			
			javax.mail.Transport.send(msg);
			System.out.println("메일 전송 성공");
		}catch(MessagingException e) {
			e.printStackTrace();
			System.out.println("메일 전송 실패");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}
