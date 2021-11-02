package com.team1.insta.post.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team1.insta.post.dao.mapper.PostMapper;
import com.team1.insta.post.dto.CommentManage;
import com.team1.insta.post.dto.LikeManage;
import com.team1.insta.user.dao.mapper.UserMapper;
import com.team1.insta.user.dto.User;

@RestController
@RequestMapping("/fileUploadRest")
public class FileUploadRestController {


	@Autowired
	UserMapper userMapper;

	@Autowired
	PostMapper postMapper;

//	@PostMapping(value = "/postingImages", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Map<String, Integer> likeRealTimeLookup(HttpServletRequest request) {
//
//		Cookie[] cookies = request.getCookies();
//
//		String uname = "";
//		for(Cookie cookie :cookies) {
//			if(cookie.getName().equals("sid")) {
//				uname = cookie.getValue();
//			}
//		}
//		User user = userMapper.getUserByUsername(uname);
//		String pid = postMapper.getNewPID(uname);
//
//		
////		Map<String, Integer> cnt = new HashMap<>();
////
////
////
////		List<LikeManage> likeManage = postMapper.getLikeManage(pid);
////		List<CommentManage> commentManage =postMapper.getCommentList(pid);
////
////		cnt.put("like", likeManage.size());
////		cnt.put("comment", commentManage.size());
//
//
//		//		ResponseEntity<List<LikeManage>> likeListEntity =  ResponseEntity
//		//				.status(HttpStatus.OK)
//		//				.contentType(MediaType.APPLICATION_JSON)
//		//				.body(likeManage);
//
//		return cnt;
//	}
	
	@PostMapping(value = "/posting", produces = MediaType.APPLICATION_JSON_VALUE)
	public void posting(@Param("content") String content, @Param("user_id") String userId, @Param("pid") String pid) {
		
		List<String> taggedName = new ArrayList<>();
		String contentName = content;
		for(int i = 0 ; i < content.length() ; i += contentName.indexOf(" ") ) {
			int tagFirstIndex = contentName.indexOf("@")+1;
			int tagLastIndex = contentName.indexOf(" ");
			
			if(tagFirstIndex > tagLastIndex) {
				contentName = contentName.substring(tagLastIndex+1);
			} else {
				taggedName.add(contentName.substring(tagFirstIndex, tagLastIndex));
				contentName = contentName.substring(tagLastIndex+1);
			}
		}
		
		List<String> taggedText = new ArrayList<>();
		String contentText = content;
		for(int i = 0 ; i < content.length() ; i += contentText.indexOf(" ") ) {
			int tagFirstIndex = contentText.indexOf("#")+1;
			int tagLastIndex = contentText.indexOf(" ");
			
			if(tagFirstIndex > tagLastIndex) {
				contentText = contentText.substring(tagLastIndex+1);
			} else {
				taggedText.add(contentText.substring(tagFirstIndex, tagLastIndex));
				contentText = contentText.substring(tagLastIndex+1);
			}
		}
		
		postMapper.uppdatePost(pid, userId, content);
		List<User> taggedUserList = new ArrayList<>();
		
		for(String tagName : taggedName) {
			taggedUserList.add(userMapper.getUserByUsername(tagName));
		}
		
		for(User user : taggedUserList) {
			postMapper.addTagPerson(pid, user.getUser_id());
		}
		
		for(String text : taggedText) {
			postMapper.addTagText(pid, text);
		}
		
		
		
	}
}
