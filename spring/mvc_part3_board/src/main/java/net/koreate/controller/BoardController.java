package net.koreate.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.koreate.service.BoardService;
import net.koreate.vo.BoardVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	BoardService service;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public void register() {}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(BoardVO boardVO) {
		System.out.println("register : "+boardVO);
		String msg = service.register(boardVO);
		System.out.println(msg);
		return "home";
	}
	
	@RequestMapping(value="/listAll",method=RequestMethod.GET)
	public String listAll(Model model) {
		List<BoardVO> boardList = service.listAll();
		model.addAttribute("boardList", boardList);
		return "/board/listAll";
	}
	
	
}




