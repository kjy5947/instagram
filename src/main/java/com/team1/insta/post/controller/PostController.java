package com.team1.insta.post.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team1.insta.user.dao.mapper.UserMapper;

import lombok.extern.log4j.Log4j;




//@RequestMapping("/post")

//@RestController

@Controller
@Log4j
public class PostController {

//	@GetMapping(value = "/getStr", produces = "text/html; charset=EUC-KR")
//	public String getString() {
//	    return "<h1>�ȳ��ϼ��� REST ��Ʈ�ѷ� �Դϴ�.</h1>";
//	}
	
	@Autowired
	private UserMapper usermp;
	
	@GetMapping("/home/{userName}")
	public String getPersonalPage(Model model, @PathVariable String userName) {
		
		log.info(userName);
		model.addAttribute("oneUser", usermp.getUser(6));
		// to do: DB�� ��ȸ�ؼ� user��ü�� ��Ƽ� �Ѱ��ֱ�
	    return "post/personal";
	}
	

	@PostMapping("/home/{userName}")
	public String getString(String imagesrc, RedirectAttributes redirectAttribute, @PathVariable String userName) {
		
		System.out.println("../resources/images/" + imagesrc);
		System.out.println("������ �߸��ȰŽÿ�");
		
		usermp.updateUser(6, "../resources/images/" + imagesrc);
		redirectAttribute.addFlashAttribute("oneUser2", usermp.getUser(6));
		System.out.println("what the fuck!!!!!?");
		
	    return "redirect:"+ userName;
	}
	
	
	
	@RequestMapping(value ={"/upload", "/upload/"}, method= {RequestMethod.GET})
	public String getUload() {
		
	    return "post/upload";
	}
	

	
}
