package com.team1.insta.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class MainController {
	
	@GetMapping("/mainpage/main")
	public void getMain() {
		log.info("메인화면 정상적인 작동");
	}
}
