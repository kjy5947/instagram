package com.team1.insta.post.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.team1.insta.post.mapper.MainXMLMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class MainController {
	
	@Autowired
	MainXMLMapper mainMapper;
	
//	@GetMapping("/mainpage/main") 
//	public void getMain() {
//		log.info("메인화면 정상적인 작동");
//	}
	
	@GetMapping("/mainpage/main")
	public void index(Model model) {
		model.addAttribute("posts", mainMapper.getPostList());
	}
	
}
