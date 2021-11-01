package com.team1.insta.post.controller;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.team1.insta.post.dto.Post;
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
		List<Post> post = (ArrayList<Post>) mainMapper.getPostList();
		post.get(0).getPid();
		
		for (int i = 0, len = post.size(); i < len; ++i) {
			Post temp;
			temp = post.get(i);
			temp.setLikeList(mainMapper.getLikeList(post.get(i).getPid()));
			temp.setLikeCountList(mainMapper.getLikeCountList(post.get(i).getPid()));
			temp.setImageList(mainMapper.getImages(post.get(i).getPid()));
			temp.setImageCountList(mainMapper.getImageCount(post.get(i).getPid()));
			temp.setCommentList(mainMapper.getCommentList(post.get(i).getPid()));
			temp.setCommentCountList(mainMapper.getCommentCountList(post.get(i).getPid()));
			post.remove(i);
			post.add(i, temp);
		}
		
		model.addAttribute("posts", post);
		
	}
	
}
