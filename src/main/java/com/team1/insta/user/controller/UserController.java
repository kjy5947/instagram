package com.team1.insta.user.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class UserController {

	
	@GetMapping("/users/{userName}")
	public String getPersonalPage(Model model, @PathVariable String userName) {
		
		log.info(userName);
		model.addAttribute("oneUser", usermp.getUser(6));
		// to do: DB�� ��ȸ�ؼ� user��ü�� ��Ƽ� �Ѱ��ֱ�
	    return "post/personal";
	}
	

}
