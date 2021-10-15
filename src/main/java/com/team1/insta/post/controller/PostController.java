package com.team1.insta.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



//@RequestMapping("/post")

//@RestController

@RequestMapping("/post")
@Controller
public class PostController {

//	@GetMapping(value = "/getStr", produces = "text/html; charset=EUC-KR")
//	public String getString() {
//	    return "<h1>�ȳ��ϼ��� REST ��Ʈ�ѷ� �Դϴ�.</h1>";
//	}

	
	
//	@GetMapping(value ={"/personal", "/personal/*"})
	@RequestMapping(value ={"/personal", "/personal/*"}, method= {RequestMethod.GET})
	public String getString() {
		
	    return "post/personal";
	}
}
