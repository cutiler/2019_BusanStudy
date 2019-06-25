package net.koreate.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.koreate.service.BoardService;
import net.koreate.util.SearchCriteria;
import net.koreate.vo.BoardVO;

@Controller
@RequestMapping("/sboard/*")
public class ReplyBoardController {
	
	@Inject
	BoardService service;
	
	@GetMapping("register")
	public String registerGET() {return "sboard/register";}
	
	@PostMapping("register")
	public String registerPost(BoardVO board) throws Exception{
		System.out.println("registerPost : " + board);
		service.registReply(board);
		return "redirect:/sboard/listReply";
	}
	
	@GetMapping("listReply")
	public String listReply(
			@ModelAttribute("cri") SearchCriteria cri,
			Model model) throws Exception{
		// 검색 조건에 맞는 페이징 처리된 게시물 항목(한번에 client에 보여줄 게시물)
		model.addAttribute("list",service.listReplyCriteria(cri));
		// 페이징 블럭 정보
		model.addAttribute("pageMaker",service.getPageMaker(cri));
		return "sboard/listReply";
	}
	

}
