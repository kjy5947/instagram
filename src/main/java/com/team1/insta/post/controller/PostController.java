package com.team1.insta.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team1.insta.post.dao.mapper.PostMapper;
import com.team1.insta.post.dto.Post;
import com.team1.insta.user.dao.mapper.UserMapper;
import com.team1.insta.user.dto.KeyConfirm;
import com.team1.insta.user.dto.User;


@RequestMapping("/post")
@Controller
public class PostController {

	
	@Autowired
	PostMapper postMapper;
	
	@Autowired
	UserMapper userMapper;
	
	
//	@GetMapping(value ={"/personal", "/personal/*"})
	@RequestMapping(value ={"/personal"}, method= {RequestMethod.GET})
	public String getString() {
		
	    return "post/personal";
	}
	
	@RequestMapping(value ={"/upload", "/upload/*"}, method= {RequestMethod.GET})
	public String getUload() {
		
	    return "post/upload";
	}
	
	@GetMapping("/personal/uname")
	public String userInfo(@RequestParam(value ="uname") String uname) {
		
		User user = userMapper.getUser(new KeyConfirm("", uname));
		
		List<Post> postList =  postMapper.getPostList(user.getUser_id());
		
		
		return null;
	}
}
