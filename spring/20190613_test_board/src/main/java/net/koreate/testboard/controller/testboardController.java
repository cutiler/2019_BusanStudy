package net.koreate.testboard.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.koreate.testboard.service.BoardService;
import net.koreate.testboard.vo.BoardVO;

@Controller
@RequestMapping("/board/*")
public class testboardController {
	
	@Inject
	BoardService service;
	
	@GetMapping("/register")
	public void register() {
		System.out.println("글쓰기 화면 요청");		
	}
	
	@PostMapping("/register")
	public String regsiter(BoardVO board,
			RedirectAttributes rttr) {
		
		System.out.println("글쓰기 요청");
		System.out.println(board);
		String msg = service.register(board);
		System.out.println(msg);
		return "redirect:/board/listPage";
	}
	
	@GetMapping("/listPage")
	public String listPage() {
		
		return "home";
	}
}
