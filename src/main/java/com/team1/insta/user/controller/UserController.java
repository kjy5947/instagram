package com.team1.insta.user.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class UserController {

	
	@GetMapping("/users/{userName}")
	public String getPersonalPage(Model model, @PathVariable String userName) {
		
		log.info(userName);
		model.addAttribute("oneUser", usermp.getUser(6));
		// to do: DB를 조회해서 user객체를 담아서 넘겨주기
	    return "post/personal";
	}
	

}
