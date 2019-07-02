package net.koreate.testboard.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.koreate.testboard.service.BoardService;
import net.koreate.testboard.util.Criteria;
import net.koreate.testboard.util.PageMaker;
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
	public String listPage(Model model,
			Criteria cri) {
		System.out.println("listPage 요청");		
		int totalCount = service.readTotalCount();
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		List<BoardVO> boardList = service.readListCri(cri);
		
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("boardList", boardList);
		
		return "/board/listPage";
	}
	
	@GetMapping("/readPage")
	public String readPage(@RequestParam("bno") int bno,
			Criteria cri,
			RedirectAttributes rttr) {
		System.out.println("readPage 요청");
		service.updateViewCount(bno);
		rttr.addAttribute("bno",bno);		
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPagePerNum());		
		
		return "redirect:/board/readUpdate";
	}
	
	@GetMapping("/readUpdate")
	public String readUpdate(@RequestParam("bno") int bno,
			Criteria cri,
			Model model) {
		System.out.println("bno 값은 : "+bno);
		System.out.println("readUpdate 호출");		
		BoardVO board = service.readPage(bno);
		model.addAttribute("board", board);
		model.addAttribute("cri",cri);
		return "/board/readPage";
	}
	
	@GetMapping("/modify")
	public String modify(@RequestParam("bno") int bno,
			Criteria cri,			
			Model model) {
		System.out.println("modify 호출");
		BoardVO board = service.readPage(bno);
		model.addAttribute("board", board);
		model.addAttribute("cri",cri);
		return "/board/modify";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board,
			Criteria cri,
			RedirectAttributes rttr) {
		System.out.println("수정 작업 요청");
		String msg = service.updatePage(board);
		rttr.addFlashAttribute("result", msg);
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPagePerNum());		
		return "redirect:/board/listPage";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") int bno,
			Criteria cri,
			RedirectAttributes rttr	) {
		System.out.println("게시물 삭제 요청");
		String msg = service.remove(bno);
		rttr.addFlashAttribute("result",msg);
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPagePerNum());
		return "redirect:/board/listPage";
	}
	
}	
