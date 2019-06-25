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
	
	// 구현할것
	// 1. 최신 회차 정보 받아오기
	// 2 .로그인했으면 로그인 정보 받아오기.
	// 1&2 정보 싫어서 리다이렉트 시킬것.
	@GetMapping("/lotto")
	public String lotto() {return "/lotto/lotto";}
	
}
