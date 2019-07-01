package net.koreate.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.koreate.test.vo.LoginDTO;
import net.koreate.test.vo.ValidationMemberVO;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {		
		return "home";
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "/user/login";
	}
	
	@PostMapping("/user/login")
	public String login(LoginDTO dto) {
		System.out.println("/user/login : "+dto);
		return "redirect:/";
	}
	
	@GetMapping("/user/join")
	public String join() {
		return "/user/join";
	}
	
	@GetMapping("/user/joinVal")
	public String joinVal() {
		return "/user/joinVal";
	}
	
	@PostMapping("/user/joinPost")
	public String join(ValidationMemberVO vo) {
		System.out.println("joinPost : "+vo);
		return "redirect:/";
	}
	
	@PostMapping("/user/uIdCheck")
	@ResponseBody
	public boolean uIdCheck(String u_id) {
		boolean isCheckId = false;
		if(u_id != null && !u_id.equals("serke@nate.com")) {
			isCheckId = true;
		}
		return isCheckId;
	}
	
	
}
