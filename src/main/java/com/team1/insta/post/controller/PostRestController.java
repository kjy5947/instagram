package com.team1.insta.post.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.team1.insta.post.dao.mapper.PostMapper;
import com.team1.insta.post.dto.Post;

@RestController
@RequestMapping("/postRest")
public class PostRestController {
	
	
	@Autowired
	PostMapper postMapper;
	
	
	
	@RequestMapping(value = "/getPost", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded")
	public ResponseEntity<List<Post>> getPostList(HttpServletRequest request){
		String userId = request.getParameter("userId");

		
		
		List<Post> postList =  postMapper.getPostList(userId);

		ResponseEntity<List<Post>> PostListEntity =  ResponseEntity
				.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(postList);
		
		return PostListEntity;
		
	}

}
