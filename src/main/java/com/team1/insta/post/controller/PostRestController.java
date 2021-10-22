package com.team1.insta.post.controller;



import java.util.ArrayList;
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
import com.team1.insta.post.dto.PostJoinImages;
import com.team1.insta.user.dao.mapper.UserMapper;
import com.team1.insta.user.dto.KeyConfirm;
import com.team1.insta.user.dto.User;

@RestController
@RequestMapping("/postRest")
public class PostRestController {
	
	
	@Autowired
	PostMapper postMapper;
	
	@Autowired
	UserMapper userMapper;
	
	
	
	@RequestMapping(value = "/getPost", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded")
	public ResponseEntity<List<PostJoinImages>> getPostList(HttpServletRequest request){
		
		
		String uname = request.getParameter("uname");
		KeyConfirm keycf = new KeyConfirm();
		keycf.setKeyType("id");
		keycf.setKey(uname);
		System.out.println(keycf);
		
		User user = userMapper.getUser(keycf);
		
		List<Post> postList =  postMapper.getPostList(user.getUser_id());
		List<PostJoinImages> postJoinImagesList = new ArrayList<PostJoinImages>();
		
		for(Post post : postList) {
			postJoinImagesList.add(postMapper.getPostJoinImages(post.getPid()));
		}	
		
		ResponseEntity<List<PostJoinImages>> PostJoinImagesListEntity =  ResponseEntity
				.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(postJoinImagesList);
		
		return PostJoinImagesListEntity;
		
	}

}
