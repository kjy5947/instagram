package com.team1.insta.post.controller;

import javax.servlet.http.HttpServletRequest;

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
//	    return "<h1>ï¿½È³ï¿½ï¿½Ï¼ï¿½ï¿½ï¿½ REST ï¿½ï¿½Æ®ï¿½Ñ·ï¿½ ï¿½Ô´Ï´ï¿½.</h1>";
//	}
	
	@Autowired
	UserMapper usermp;
	
//	@GetMapping(value ={"/personal", "/personal/*"})
	@RequestMapping(value ={"/personal", "/personal/","/personal/*"}, method= {RequestMethod.GET})
	public String getString(Model model) {
		
		model.addAttribute("oneUser", usermp.getUser(6));
		System.out.println("what the fuck GET PAGE!!!!!?");
	    return "post/personal";
	}
	
	@RequestMapping(value ={"/personal", "/personal/","/personal/*"}, method= {RequestMethod.POST})
	public String getString(HttpServletRequest request,String imagesrc, Model model) {
		
		
	
		System.out.println("../resources/images/" + imagesrc);
		System.out.println("¹«¾ùÀÌ Àß¸øµÈ°Å½Ã¿À");
		
		usermp.updateUser(6, "../resources/images/" + imagesrc);
		model.addAttribute("oneUser2", usermp.getUser(6));
		System.out.println("what the fuck!!!!!?");
		
	    return "post/personal/profile";
	}
	
	@RequestMapping(value ={"/upload", "/upload/"}, method= {RequestMethod.GET})
	public String getUload() {
		
	    return "post/upload";
	}
	
}
