package com.team1.insta.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team1.insta.user.dao.mapper.UserMapper;




//@RequestMapping("/post")

//@RestController

@RequestMapping("/post")
@Controller
public class PostController {

//	@GetMapping(value = "/getStr", produces = "text/html; charset=EUC-KR")
//	public String getString() {
//	    return "<h1>�ȳ��ϼ��� REST ��Ʈ�ѷ� �Դϴ�.</h1>";
//	}
	
	@Autowired
	UserMapper usermp;
	
//	@GetMapping(value ={"/personal", "/personal/*"})
	@RequestMapping(value ={"/personal", "/personal/"}, method= {RequestMethod.GET})
	public String getString(Model model) {
		
		model.addAttribute("oneUser", usermp.getUser(6));
		
	    return "post/personal";
	}
	
	@RequestMapping(value ={"/upload", "/upload/*"}, method= {RequestMethod.GET})
	public String getUload() {
		
	    return "post/upload";
	}
	
}
