package com.team1.insta.post.controller;



import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.team1.insta.post.dao.mapper.PostMapper;
import com.team1.insta.post.dto.LikeManage;
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
	public ResponseEntity<List<PostJoinImages>> getPostList(HttpServletRequest request, Model model){
		
		
		String uname = request.getParameter("uname");
		
		User user = userMapper.getUser(new KeyConfirm("id", uname));

		List<Post> postList =  postMapper.getPostList(user.getUser_id());
		
		List<PostJoinImages> postJoinImagesList = new ArrayList<PostJoinImages>();
		
		List<List<LikeManage>> postLikeManageList = new ArrayList<List<LikeManage>>();
		
		for(Post post : postList) {
			postJoinImagesList.add(postMapper.getPostJoinImages(post.getPid()));
			postMapper.getLikeManage(post.getPid());
		}	
		
		model.addAttribute("postLikeManageList", postLikeManageList);
		
		
		ResponseEntity<List<PostJoinImages>> postPlusImagesListEntity =  ResponseEntity
				.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(postJoinImagesList);
		
		return postPlusImagesListEntity;
		
	}
	

}
