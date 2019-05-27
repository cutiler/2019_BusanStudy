package util;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class Cookies {
	
	private HashMap<String, Cookie> cookieMap = new HashMap<>();
	
	public void setCookieMap(Cookie[] cookies) {
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
	}
	
	public void createCookie(String id, String value, int maxAge, HttpServletResponse res) {
		Cookie cookie = new Cookie(id,value);
		cookie.setMaxAge(maxAge);
		cookieMap.put(id, cookie);
		res.addCookie(cookie);
		
	}
	
	public void removeCookie(HttpServletResponse res, String id) {
		Cookie cookie = cookieMap.get(id);
		if(cookie != null) {
			cookie.setMaxAge(0);
			cookie.setValue("");
			res.addCookie(cookie);
			cookieMap.remove(id);
		}
	}
	
	

}
