package com.springboard.adv.controller;

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
		return "redirect:boardSimpleList";	// 연습중이므로
	}
	
	@RequestMapping(value="/boardSimpleList")
	public String simpleBoardList(Model model) throws Exception {
		model.addAttribute("simpleList", service.listAllSimple());
		return "boardEx02/bSimpleList";
	}
	
	@RequestMapping(value="/boardWrite", method = RequestMethod.GET)
	public String boardWrite() throws Exception {
		return "boardEx02/bWrite";
	}
	
	@RequestMapping(value="/boardWrite", method = RequestMethod.POST)
	public String boardWrite(Model model, BoardDTO bdto) throws Exception {
		service.insertBoard(bdto);
		return "redirect:boardSimpleList";
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

}
