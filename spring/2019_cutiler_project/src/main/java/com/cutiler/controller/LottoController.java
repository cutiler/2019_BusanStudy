package com.cutiler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lotto/")
public class LottoController {
	
	@GetMapping("/home")
	public String lottoHome() {		
		return "lotto/lottoHome";
	}

}
