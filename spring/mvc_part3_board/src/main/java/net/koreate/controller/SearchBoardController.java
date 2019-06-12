package net.koreate.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.koreate.service.BoardService;
import net.koreate.util.SearchCriteria;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {
	
	@Inject
	BoardService service;
	
	@GetMapping("/list")
	/*@RequestParam(name="searchType", required=false) String searchType, 
	@RequestParam(name="keyword", required=false) String keyword
	*/
	public String list(SearchCriteria cri) {
		System.out.println(cri);
		
		return "sboard/listPage";
	}
	
}







