package com.team1.insta.post.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;



import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.web.bind.annotation.RestController;


import com.team1.insta.user.controller.UserController;
import com.team1.insta.user.dao.mapper.UserMapper;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import net.sf.json.JSONArray;

import com.google.gson.JsonArray;
import com.team1.insta.post.dao.mapper.PostMapper;
import com.team1.insta.post.dto.CommentManage;
import com.team1.insta.post.dto.Follow;
import com.team1.insta.post.dto.Images;
import com.team1.insta.post.dto.LikeManage;
import com.team1.insta.post.dto.Post;
import com.team1.insta.post.dto.PostJoinImages;
import com.team1.insta.post.dto.TagPerson;
import com.team1.insta.user.dto.KeyConfirm;
import com.team1.insta.user.dto.User;



@Controller
@Slf4j
@RequestMapping("/post")
public class PostController {


//	@GetMapping(value = "/getStr", produces = "text/html; charset=EUC-KR")
//	public String getString() {
//	    return "<h1>占싫놂옙占싹쇽옙占쏙옙 REST 占쏙옙트占싼뤄옙 占쌉니댐옙.</h1>";
//	}
	
	@Autowired
	PostMapper postMapper;
	
	@Autowired
	UserMapper userMapper;

	@Value("${file.dir}")
	private String fileDir;

	
	@GetMapping("/home/{userName}")
	public String getPersonalPage(HttpServletRequest request, Model model, @PathVariable String userName) {
		
		Cookie[] cookie = request.getCookies();
		
		String mySid = "";
		
		//if()
		
		
		log.info(userName);
		model.addAttribute("oneUser", userMapper.getUser(6));
		// to do: DB占쏙옙 占쏙옙회占쌔쇽옙 user占쏙옙체占쏙옙 占쏙옙티占� 占싼곤옙占쌍깍옙
	    return "post/personal";
	}
	
	@PostMapping("/home/{userName}")
	
	public String getString(RedirectAttributes redirectAttribute, @PathVariable String userName, @RequestParam MultipartFile file) 
			throws IllegalStateException, IOException {
		
		System.out.println("../resources/images/" + file.getOriginalFilename());
		
		userMapper.updateUser(6, "../resources/images/" + file.getOriginalFilename());
		redirectAttribute.addFlashAttribute("oneUser", userMapper.getUser(6));
		if (!file.isEmpty()) {
			String fullPath = fileDir + file.getOriginalFilename();
			log.info("占쏙옙占쏙옙 占쏙옙占쏙옙 fullPath={}", fullPath);
			file.transferTo(new File(fullPath));
		}
	    return "redirect:"+ userName;
	}
	

	

	// 寃뚯떆臾� 蹂댁뿬二쇨린 + �뿬�윭媛�吏� �뜲�씠�꽣 view, Javascript濡� �꽆湲곌린

	@GetMapping("/personal")
	public String userInfo(@RequestParam(value ="uname") String uname, Model model) {
		
		User user = userMapper.getUserBytype(new KeyConfirm("", uname));
		
		List<Post> postList =  postMapper.getPostList(user.getUser_id());
		List<List<Images>> imagesList = new ArrayList<>();
		List<PostJoinImages> postJoinImageList = new ArrayList<>();
		List<List<LikeManage>> likeManageList = new ArrayList<>();
		List<PostJoinImages> taggedPostJoinImageList = new ArrayList<>();
		List<List<CommentManage>> commentManageList = new ArrayList<>();
		List<TagPerson> tagpersonList = postMapper.getTagPersonByUserId(user.getUser_id());
		
		for(Post post : postList) {
			imagesList.add(postMapper.getImagesList(post.getPid()));
			postJoinImageList.add(postMapper.getPostJoinImages(post.getPid()));
			likeManageList.add(postMapper.getLikeManage(post.getPid()));	
			commentManageList.add(postMapper.getCommentList(post.getPid()));
		}
		
		for(TagPerson tagperson : tagpersonList) {
			taggedPostJoinImageList.add(postMapper.getPostJoinImages(tagperson.getPid()));
		}
		
		List<Follow> followerList = postMapper.getFollower(user.getUser_id());
		List<Follow> followingrList = postMapper.getFollowing(user.getUser_id());
		 
		
		model.addAttribute("user", user);
		
		model.addAttribute("postList", JSONArray.fromObject(postList));
		model.addAttribute("imagesList", JSONArray.fromObject(imagesList));
		model.addAttribute("postJoinImageList", JSONArray.fromObject(postJoinImageList));
		model.addAttribute("likeManageList", JSONArray.fromObject(likeManageList));
		model.addAttribute("taggedPostJoinImageList", JSONArray.fromObject(taggedPostJoinImageList));
		model.addAttribute("followerList", JSONArray.fromObject(followerList));
		model.addAttribute("followingrList", JSONArray.fromObject(followingrList));		
		model.addAttribute("commentManageList", JSONArray.fromObject(commentManageList));		
		
		return "post/personal";
	}

}
