package com.team1.insta.post.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;



import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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
import com.team1.insta.post.dto.UserToUserFollow;
import com.team1.insta.user.dto.KeyConfirm;
import com.team1.insta.user.dto.User;



@Controller
@Slf4j
public class PostController {

	@Autowired
	UserMapper userMapper;

	@Autowired
	PostMapper postMapper;
	


   @Value("${file.dir}")
   private String fileDir;

   
	@GetMapping("/home/{userName}")
	public String getPersonalPage(HttpServletRequest request, Model model, @PathVariable String userName) {

		log.info("get home : " + userName);
		Cookie[] cookies = request.getCookies();
		
		//팔로우 정보
		
		
		
		
		
		
		
		/////////////////////////////////////////////////////////////////
		// 수환님 코드 추가하기.
		User user = userMapper.getUserBytype(new KeyConfirm("", userName));
		log.info("수환님 user : " + user);
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

		/////////////////////////////////////////////////////////////////
		// 로그인한 cookie정보 얻어오기.
		String mySid = "";
		String urlusername ="";

		if(cookies == null) {
		
			return "redirect:" + "user/login";
		}else {
			
			for(Cookie cookie :cookies)
				if(cookie.getName().equals("sid"))
					mySid = cookie.getValue();
		/////////////////////////////////////////////////////////////////
			
		/////////////////////////////////////////////////////////////////
			// 팔로우 버튼의 모양
			
			User unameUser = null;
			UserToUserFollow followState = null;
			unameUser = userMapper.getUserByUsername(mySid);
			
			followState = userMapper.getFollowInfo(unameUser.getUser_id(), userMapper.getUserByUsername(userName).getUser_id());
			log.info("followState : " + followState);
			if(followState != null) {
				if(followState.getFollow_accept() == 'N') {
					if(followState.getFollow_condition().equals("A")) {
						log.info("요청됨으로 설정함");
						request.setAttribute("follow", "요청됨");
						request.setAttribute("classFollow", "ing");
					}else if(followState.getFollow_condition().equals("Y")) {
						log.info("언팔로 설정함");
						request.setAttribute("follow", "언팔");
						request.setAttribute("classFollow", "unfollow");
					}
				}else{//getFollow_accept() == 'Y'로 되어있는 경우
					log.info("언팔로 설정함");
					request.setAttribute("follow", "언팔");
					request.setAttribute("classFollow", "unfollow");
				}
			}else {	//followState == null인 경우.
				
				request.setAttribute("follow", "팔로우");
				if(userMapper.getUserByUsername(userName).getFollow_accept() == 'N') {
					log.info("ing 여기찍혀야함");
					request.setAttribute("classFollow", "ing");
				}else {
					log.info("follow?");
					request.setAttribute("classFollow", "follow");
				}
				
			}
			
			
			
			
			model.addAttribute("oneUser", userMapper.getUserByUsername(userName));
			User urlUser = userMapper.getUserByUsername(userName);      
			urlusername = urlUser.getUname();
			request.setAttribute("username", userName);//어떤 유저페이지인지 username정보
			model.addAttribute("loginUser", userMapper.getUserByUsername(mySid));
			
			
		/////////////////////////////////////////////////////////////////
			//   수환님꺼 코드 //
			model.addAttribute("user", user);
			model.addAttribute("postList", JSONArray.fromObject(postList));
			model.addAttribute("imagesList", JSONArray.fromObject(imagesList));
			model.addAttribute("postJoinImageList", JSONArray.fromObject(postJoinImageList));
			model.addAttribute("likeManageList", JSONArray.fromObject(likeManageList));
			model.addAttribute("taggedPostJoinImageList", JSONArray.fromObject(taggedPostJoinImageList));
			model.addAttribute("followerList", JSONArray.fromObject(followerList));
			model.addAttribute("followingrList", JSONArray.fromObject(followingrList));		
			model.addAttribute("commentManageList", JSONArray.fromObject(commentManageList));		
			// 끝 - 수환님꺼 코드 //
			request.setAttribute("flwstate", "mu");
			return "post/personal/personal"; 
			
			
		}//else


	}//getString 끝

   
   @PostMapping("/home/{userName}")  
   public String getString(HttpServletRequest request, MultipartHttpServletRequest multireq, RedirectAttributes redirectAttribute, Model model,
         @PathVariable String userName, @RequestParam MultipartFile file, @RequestParam String button) 
         throws IllegalStateException, IOException {
	   	   String urlusername = "";
	   	   User urlUser;
	   	   String mySid = "";
           urlUser = userMapper.getUserByUsername(userName);
           log.info("Post페이지의 유저정보 : " + urlUser);
           urlusername = urlUser.getUname();
           log.info("Post페이지의 이름 : " + urlusername);
           Cookie[] cookies = request.getCookies();
			request.setAttribute("username", userName);//어떤 유저페이지인지 username정보
        
		//////////////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////////////////			
         if(cookies == null) {
            
            return "user/login";
         }else {
         
            for(Cookie cookie :cookies)
               if(cookie.getName().equals("sid"))
                     mySid = cookie.getValue();
            
            // 고른 이미지로 업데이트 

            if (!file.isEmpty()) {
            	
                userMapper.updateUser(userName, "../resources/images/" + file.getOriginalFilename());
                redirectAttribute.addFlashAttribute("oneUser", userMapper.getUserByUsername(mySid));
            	
            	//String relativePath = multireq.getSession().getServletContext().getRealPath("resources/images");
            	//String fullPath = fileDir + file.getOriginalFilename();
            	String root_path = request.getSession().getServletContext().getRealPath("/");
            	root_path = root_path.replace("\\", "/");
            	log.info("root path : " + root_path);
            	String attach_path = "/resources/images/";

            	//String fullPath = relativePath + file.getOriginalFilename();
            	String fullPath = root_path + attach_path + file.getOriginalFilename();
            	
               log.info(" fullPath={}", fullPath);
               file.transferTo(new File(fullPath));
      
            }
            // !이미지 업데이트 끝
            //////////////////////////////////////
            log.info(userName);
            request.setAttribute("flwstate", "mu");
            //model.addAttribute("oneUser", userMapper.getUser(mySid));
            
            
            if(urlusername.equals(mySid)) {
               return "redirect:"+ userName; 
            }
            else {
               return "redirect:"+ userName;
            }//else
             
         }//else

       
   }//home post내용 끝
//   
   @PostMapping("/follow/{userName}")
   public String getFollow(HttpServletRequest request, HttpServletResponse response,@RequestParam String button, @PathVariable String userName) {
	   
	   Cookie[] cookies = request.getCookies();
	   log.info("follow 컨트롤러 들렸다가 감");
	   ///////////////////////////////////////////////
	   //쿠키값 꺼내기
	   String mySid = "";

		if(cookies == null) {
		
			return "redirect:" + "user/login";
		}else {
			
			for(Cookie cookie :cookies)
				if(cookie.getName().equals("sid"))
					mySid = cookie.getValue();
		}
	   ///////////////////////////////////////////////////
		User unameUser = null;
		UserToUserFollow followState = null;
		unameUser = userMapper.getUserByUsername(mySid);//쿠키에 저장된 로그인유저
		
		
	   if(button.equals("follow")) {
		   log.info("--------------------------------");
		   log.info("follow버튼을 누름");
			User u = userMapper.getUserByUsername(userName);
			followState = userMapper.getFollowInfo(unameUser.getUser_id(), u.getUser_id());
			if(u.getFollow_accept() == 'Y') {
				
				if(followState == null) {//follow관계가 아니라면,
					userMapper.addFollow(userMapper.existUser(mySid), userMapper.existUser(userName), "Y");
					request.setAttribute("follow", "언팔");
					request.setAttribute("classFollow", "unfollow");
				}else {
					
				}
			}else {//getFollow_accept() == 'N'일떄
				if(followState == null) {//follow관계가 아니라면,
					request.setAttribute("follow", "요청됨");
					request.setAttribute("classFollow", "ing");
					userMapper.addFollow(userMapper.existUser(mySid),userMapper.existUser(userName),"A");
				}
			}
		}else if(button.equals("cancel")) {
			log.info("--------------------------------");
			   log.info("cancel버튼을 누름");
			userMapper.cancelFollow(userMapper.existUser(mySid), userMapper.existUser(userName));
			request.setAttribute("follow", "팔로우");
			request.setAttribute("classFollow", "follow");
		}else {
			log.info("param button값 : 없음.");
		}
	   
	   String urlusername = "";
   	   User urlUser;
       urlUser = userMapper.getUserByUsername(userName);
       log.info("Post페이지의 유저정보 : " + urlUser);
       urlusername = urlUser.getUname();
       log.info("Post페이지의 이름 : " + urlusername);
		
       String usernameInfo ="";
       request.setAttribute("usernameInfo", userName);
	   //return "redirect:"+ "/home/" + userName;
       return "post/personal/editedcookie"; 
   }
   
   
   
   

   // 寃뚯떆臾  蹂댁뿬二쇨린 +  뿬 윭媛 吏   뜲 씠 꽣 view, Javascript濡   꽆湲곌린

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
		
			
			model.addAttribute("loginUser", userMapper.getUserByUsername(mySid));

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
		}//else

	}
}

