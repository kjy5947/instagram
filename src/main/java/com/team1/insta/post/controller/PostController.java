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
public class PostController {




	@Autowired
	PostMapper postMapper;

	@Autowired
	UserMapper userMapper;

	@Value("${file.dir}")
	private String fileDir;



	@GetMapping("/home/{userName}")
	public String getPersonalPage(HttpServletRequest request, Model model, @PathVariable String userName) {

		log.info(userName);
		Cookie[] cookies = request.getCookies();

		String mySid = "";
		String urlusername ="";

		if(cookies == null) {

			return "redirect:" + "user/login";
		}else {

			for(Cookie cookie :cookies)
				if(cookie.getName().equals("sid"))
					mySid = cookie.getValue();
			//////////////////////////////////////
			//log.info("home�럹�씠吏� : " + mySid);
			model.addAttribute("oneUser", userMapper.getUserByUsername(mySid));
			//log.info("home�럹�씠吏�2 : " + mySid);
			User urlUser = userMapper.getUserByUsername(userName);

			urlusername = urlUser.getUname();
			//log.info("home�럹�씠吏�2 : " + urluserId);
			if(urlusername.equals(mySid)) {
				return "post/personal"; 
			}
			else {
				return "redirect:" + "/";
			}

		}

	}

	@PostMapping("/home/{userName}")

	public String getString(HttpServletRequest request, RedirectAttributes redirectAttribute, Model model,
			@PathVariable String userName, @RequestParam MultipartFile file) 
					throws IllegalStateException, IOException {
		log.info("�씠寃� �궡 �씠由꾩씠�떎!? : " + userName);
		String urlusername = "";
		User urlUser;
		urlUser = userMapper.getUserByUsername(userName);
		log.info("Post�럹�씠吏��쓽 �쑀���젙蹂� : " + urlUser);
		urlusername = urlUser.getUname();
		log.info("Post�럹�씠吏��쓽 �씠由� : " + urlusername);
		Cookie[] cookies = request.getCookies();

		String mySid = "";

		if(cookies == null) {

			return "user/login";
		}else {

			for(Cookie cookie :cookies)
				if(cookie.getName().equals("sid"))
					mySid = cookie.getValue();

			// 怨좊Ⅸ �씠誘몄�濡� �뾽�뜲�씠�듃 
			userMapper.updateUser(userName, "../resources/images/" + file.getOriginalFilename());
			redirectAttribute.addFlashAttribute("oneUser", userMapper.getUserByUsername(mySid));
			if (!file.isEmpty()) {
				String fullPath = fileDir + file.getOriginalFilename();
				log.info(" fullPath={}", fullPath);
				file.transferTo(new File(fullPath));
			}
			// !�씠誘몄� �뾽�뜲�씠�듃 �걹
			//////////////////////////////////////
			log.info(userName);
			//model.addAttribute("oneUser", userMapper.getUser(mySid));


			if(urlusername.equals(mySid)) {
				return "redirect:"+ userName; 
			}
			else {
				return "redirect:"+ userName;
			}

		}




	}//getString �걹




	// 野껊슣�뻻�눧  癰귣똻肉т틠�눊由� +  肉� �쑎揶� �릯   �쑓 �뵠 苑� view, Javascript嚥�   苑녷묾怨뚮┛

	// 개인페이지


	@GetMapping("/post/personal")
	public String userInfo(@RequestParam(value ="uname") String uname, Model model, HttpServletRequest request) {

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

		// cookie

		Cookie[] cookies = request.getCookies();
		
		String mySid = null;
		
		if(cookies == null) {

			return "redirect:" + "user/login";
		}else {

			for(Cookie cookie :cookies) {
				if(cookie.getName().equals("sid")) {
					mySid = cookie.getValue();
				}
			}
			System.out.println(mySid);
//			model.addAttribute("loginUser", userMapper.getUserByUsername(mySid));

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
}

