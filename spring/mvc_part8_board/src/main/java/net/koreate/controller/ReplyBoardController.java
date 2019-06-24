package net.koreate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sboard/*")
public class ReplyBoardController {
	
	@GetMapping("register")
	public String registerGET() {return "sboard/register";}

}
