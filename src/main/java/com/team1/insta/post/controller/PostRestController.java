package com.team1.insta.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team1.insta.post.dao.mapper.PostMapper;
import com.team1.insta.post.dto.CommentManage;
import com.team1.insta.post.dto.Follow;
import com.team1.insta.user.dao.mapper.UserMapper;
import com.team1.insta.user.dto.User;

@RestController
@RequestMapping("/postRest")
public class PostRestController {

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	PostMapper postMapper;
	
	@PostMapping(value = "/commentGetUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getCommentUser(@RequestBody CommentManage commentManage) {
		
		User user = userMapper.getUser(commentManage.getUser_id());
		
		ResponseEntity<User> userEntity =  ResponseEntity
				.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(user);
		
		return userEntity;
	}
	
	@PostMapping(value = "/leaveComment", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> leaveComment(@RequestBody CommentManage commentManage) {
				
		postMapper.leaveComment(commentManage.getPid(), commentManage.getUser_id(), commentManage.getContents());
		
		User user = userMapper.getUser(commentManage.getUser_id());
		
		ResponseEntity<User> userEntity =  ResponseEntity
				.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(user);
		
		return userEntity;
	}
	
	@PostMapping(value = "/addfollow", produces = MediaType.APPLICATION_JSON_VALUE)
	public void addfollow(@RequestBody Follow follow) {
				
		postMapper.addFollow(follow.getFrom_user(), follow.getTo_user());
		
	}
	
	@PostMapping(value = "/deleteFollow", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteFollow(@RequestBody Follow follow) {
		
		postMapper.deleteFollow(follow.getFrom_user(), follow.getTo_user());
		
	}
	
	@PostMapping(value = "/FollowDecide", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Follow>> FollowDecide(@RequestBody Follow follow) {
		
		List<Follow> followList =  postMapper.FollowDecide(follow.getFrom_user(), follow.getTo_user());
		
		ResponseEntity<List<Follow>> followListEntity =  ResponseEntity
				.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(followList);
		
		
		return followListEntity;
	}
}
