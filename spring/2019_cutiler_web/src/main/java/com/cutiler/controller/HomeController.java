package com.cutiler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {		
		return "home";
	}
	
	@GetMapping("/board")
	public String board() {
		System.out.println("게시판 요청");
		
		return "board";
	}
	
	@GetMapping("/tetris")
	public void tetris() {}
	
	@GetMapping("/lotto")
	public void lotto() {}
	
}
