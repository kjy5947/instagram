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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team1.insta.post.dao.mapper.PostMapper;
import com.team1.insta.post.dto.CommentManage;
import com.team1.insta.post.dto.LikeManage;
import com.team1.insta.post.dto.Post;
import com.team1.insta.post.dto.PostJoinImages;
import com.team1.insta.post.dto.PostSupport;
import com.team1.insta.user.dao.mapper.UserMapper;
import com.team1.insta.user.dto.User;

@RestController
@RequestMapping("/fileUploadRest")
public class FileUploadRestController {


	@Autowired
	UserMapper userMapper;

	@Autowired
	PostMapper postMapper;

	@PostMapping(value = "/postingImages", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> postingImages(HttpServletRequest request) {

		Cookie[] cookies = request.getCookies();

		String uname = "";
		for(Cookie cookie :cookies) {
			if(cookie.getName().equals("sid")) {
				uname = cookie.getValue();
			}
		}
		
		User user = userMapper.getUserByUsername(uname);
		String pid = postMapper.getLastPID(uname);
		PostJoinImages pji = null;
		
		while(pji == null) {
			pji = postMapper.getPostJoinImages(pid);
		}
		System.out.println(pji);
		Map<String, Object> map = new HashMap<>();

		map.put("user", user);
		map.put("postJoinImage", pji);

		return map;
	}
	
	@PostMapping(value = "/posting", produces = MediaType.APPLICATION_JSON_VALUE)
	public void posting(@RequestBody PostSupport postSupport) {
		
		
		String content = postSupport.getContent();
		
		String[] contentSplitName = content.split("@");
		
		List<String> taggedName = new ArrayList<>();
		for(int i = 1 ; i < contentSplitName.length ; i++) {
			try {
				taggedName.add(contentSplitName[i].substring(0, contentSplitName[i].lastIndexOf(" ")));
			} catch (Exception e) {
				taggedName.add(contentSplitName[i].substring(0));
			}
		}
			
		
		String[] contentSplitText = content.split("#");
		
		List<String> taggedText = new ArrayList<>();
		for(int i = 1 ; i < contentSplitText.length ; i++) {
			try {
				taggedText.add(contentSplitText[i].substring(0, contentSplitText[i].lastIndexOf(" ")));
			} catch (Exception e) {
				taggedText.add(contentSplitText[i].substring(0));
			}
			
		}
	
		
		
		postMapper.uppdatePost(postSupport.getPid(), postSupport.getUser_id(), content);
		List<User> taggedUserList = new ArrayList<>();
		
		for(String tagName : taggedName) {
			try {
				taggedUserList.add(userMapper.getUserByUsername(tagName));
			} catch (Exception e) {
				
			}
		}
		
		for(User user : taggedUserList) {
			postMapper.addTagPerson(postSupport.getPid(), user.getUser_id());
		}
		
		for(String text : taggedText) {
			postMapper.addTagText(postSupport.getPid(), text);
		}
		
		
		
	}
}
