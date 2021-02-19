package com.springboard.adv.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboard.adv.dto.BoardDTO;
import com.springboard.adv.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value="/")
	public String main(Model model) throws Exception {
//		return "redirect:boardSimpleList";	// 연습중이므로
		return "redirect:boardList";
	}
	
	@RequestMapping(value="/boardSimpleList")
	public String simpleBoardList(Model model) throws Exception {
		model.addAttribute("simpleList", service.listAllSimple());
		// 프린트 System.out.println("getAllBoardCount=" + service.getAllBoardCount());
		// 프린트
//		List<BoardDTO> list = service.getSearchBoard();
//		for (BoardDTO item : list) {
//			System.out.println(item);
//		}
		return "boardEx02/bSimpleList";
	}
	
	@RequestMapping(value="/boardWrite", method = RequestMethod.GET)
	public String boardWrite() throws Exception {
		return "boardEx02/bWrite";
	}
	
	@RequestMapping(value="/boardWrite", method = RequestMethod.POST)
	public String boardWrite(Model model, BoardDTO bdto) throws Exception {
		service.insertBoard(bdto);
//		return "redirect:boardSimpleList";
		return "redirect:boardList";
	}
	
	@RequestMapping(value="/boardInfo", method = RequestMethod.GET)
	public String boardInfo(@RequestParam ("num") int num, Model model) throws Exception {
		model.addAttribute("bdto", service.getOneBoard(num));
		return "boardEx02/bInfo";
	}
	
	@RequestMapping(value="/boardUpdate", method=RequestMethod.GET)
	public String boardUpdate(@RequestParam ("num") int num, Model model) throws Exception {
		model.addAttribute("bdto", service.getOneBoard(num));
		return "boardEx02/bUpdate";
	}
	
	@RequestMapping(value="/boardUpdate", method=RequestMethod.POST)
	public String boardUpdate(BoardDTO bdto, Model model) throws Exception {
		if(service.updateBoard(bdto))	model.addAttribute("success",true);
		else							model.addAttribute("success",false);
		
		return "boardEx02/bUpdatePro";
	}
	@RequestMapping(value="/boardDelete", method=RequestMethod.GET)
	public String boardDelete(@RequestParam ("num") int num, Model model) throws Exception {
		model.addAttribute("bdto", service.getOneBoard(num));
		return "boardEx02/bDelete";
	}
	
	@RequestMapping(value="/boardDelete", method=RequestMethod.POST)
	public String boardDelete(BoardDTO bdto, Model model) throws Exception {
		if(service.deleteBoard(bdto))	model.addAttribute("success",true);
		else							model.addAttribute("success",false);
		
		return "boardEx02/bDeletePro";
	}
	
	@RequestMapping(value="/boardReplyWrite", method=RequestMethod.GET)
	public String boardReplyWrite(@RequestParam ("num") int num, Model model) throws Exception {
		model.addAttribute("bdto", service.getOneBoard(num));
		return "boardEx02/bReply";
	}
	
	@RequestMapping(value="/boardReplyWrite", method=RequestMethod.POST)
	public String boardReplyWrite(Model model, BoardDTO bdto) throws Exception {
		service.insertReplyBoard(bdto);
		
//		return "redirect:boardSimpleList";
		return "redirect:boardList";
	}
	@RequestMapping(value="/boardList")
	public String boardList(@RequestParam (name="onePageViewCount", defaultValue = "10") int onePageViewCount,
							@RequestParam (name="currentPageNumber", defaultValue = "1") int currentPageNumber,
							@RequestParam (name="searchKeyword", defaultValue = "total") String searchKeyword,
							@RequestParam (name="searchWord", defaultValue = "") String searchWord,
							Model model) throws Exception {
		
		// [(검색/페이징처리 전)전체 게시글 개수]
//		int totalBoardCount = service.getAllBoardCount(); 		// 페이징처리 전
//		List<BoardDTO> boardList = service.getSearchBoard();	// 검색 처리 전
//		model.addAttribute("boardList", boardList);

		// 페이지 시작 게시글 인덱스
//		int startBoardIdx = 1;
		int startBoardIdx = (currentPageNumber-1)*onePageViewCount;
		
		// [검색 기능 시작]
		// 검색 관련 정보 map 인 searchInfo 생성
		Map<String, Object> searchInfo = new HashMap<String, Object>();
		searchInfo.put("onePageViewCount", onePageViewCount); 
		searchInfo.put("startBoardIdx", startBoardIdx);
		searchInfo.put("searchKeyword", searchKeyword);
		searchInfo.put("searchWord", searchWord);
		List<BoardDTO> boardList = service.getSearchBoard(searchInfo);	
		
		// 게시글 전체 개수를 반환하는 관련정보 map 생성
		Map<String, String> searchCountInfo = new HashMap<String, String>();
		searchInfo.put("searchKeyword", searchKeyword);
		searchInfo.put("searchWord", searchWord);
		
		// [페이징 처리 순서]
		// 전체 페이지개수 = 전체게시글 수 / 한페이지에서 보여주는 글 수 
		int totalBoardCount = 100;
//		int totalBoardCount = service.getAllBoardCount(searchCountInfo);
		
		// 나머지가 0이면 추가x, 나머지가 0이 아니면 +1페이지 처리 
		// 시작페이지
		// 끝페이지
		// 끝페이지가 전체 페이지 개수보다 크다면 
		// 게시물이 한페이지에 보여지는 것보다 작다면
		
		
		// [model.addAttribute()] - 검색처리 관련
		model.addAttribute("totalBoardCount", totalBoardCount);
		model.addAttribute("onePageViewCount", onePageViewCount);
		model.addAttribute("onePageViewCount", 10);
		model.addAttribute("searchKeyword", searchKeyword);
		model.addAttribute("searchWord", searchWord);
		
		model.addAttribute("boardList", boardList);
		
		// [model.addAttribute()] - 페이징처리 관련
		
		// [테스트를 위한 printout]
		System.out.println("========================");
		System.out.println("totalBoardCount : " + totalBoardCount);
		System.out.println("onePageViewCount : " + onePageViewCount);
		System.out.println("searchKeyword : " + searchKeyword);
		System.out.println("searchWord : " + searchWord);
		System.out.println("========================");
		
		return "boardEx02/bList";
	}
}
