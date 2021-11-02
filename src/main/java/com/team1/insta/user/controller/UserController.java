package com.team1.insta.user.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team1.insta.user.dao.mapper.UserMapper;
import com.team1.insta.user.dto.EditRequest;
import com.team1.insta.user.dto.PasswordInfo;
import com.team1.insta.user.dto.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Log4j
@Controller
public class UserController {
	
	
	@Value("${file.dir}")
	private String fileDir;
	
	private final UserMapper userMapper;
	//private final UserMapper usermp;

	@GetMapping("/users/{userName}")
	public String editUserPage(HttpServletRequest request, HttpServletResponse response, Model model, @PathVariable String userName)
			throws IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Cookie[] cookies = request.getCookies();
		String mySid = "";
		PrintWriter outt = response.getWriter();
		
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("sid")) {
				mySid = cookie.getValue();
				if(userName.equals(mySid)) {
					
					model.addAttribute("editedUser", userMapper.getUserByUsername(mySid));
				}else {
					System.out.println("이거 맞냐고");
					outt.println("<script>alert('이동할 수 없는 링크 입니다.'); location.href='redirect:/';</script>");
					outt.flush();
				}
			}
		}
	    return "user/update";
	}
	
	
	@PostMapping("/users/{userName}")
	public String editUser(HttpServletRequest request,HttpServletResponse response, Model model, @PathVariable String userName, @ModelAttribute EditRequest editrequest)
			throws IOException, ServletException {
		
		//@RequestParam("username") String username
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String followacpt ="";
		String editedname = editrequest.getUname();
		log.info("이미 있는 계정 :"+ editedname);
		if(userMapper.existUser(editedname)!=null && !userName.equals(userMapper.existUser(editedname))) {
			
			out.println("<script language='javascript'>alert('이미 등록된 계정입니다.');"+"location.href='/insta/users/"+userName+"';</script>");
			out.flush();
//				return "redirect:" + "/users/" + userName;
		}
		String introduce = editrequest.getUserIntroduce();
		if(editrequest.getFollowAccept() == null) {
			followacpt = "N";
		}else {
			followacpt = "Y";
		}
		String realName = editrequest.getRealName();
		String phoneNum = editrequest.getPhoneNumber();
		
		log.info("follow state : " + followacpt);
		
		
		userMapper.updateUserInfo(userName, editedname, introduce, followacpt, realName, phoneNum);
		String usernameInfo ="";
		
		request.setAttribute("usernameInfo", userName);
		Cookie[] cookies = request.getCookies();
		String mySid = "";
		///쿠키 재 지정
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("sid")) {
				
				cookie = new Cookie("sid", editedname);
				response.addCookie(cookie);
				System.out.println("나의 쿠키내용 : " + cookie.getValue());
			}
		}
		
	    return "post/personal/editedcookie";
		
	}
	// 개인정보 수정 끝
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@PostMapping("/users/profile/{userName}")
	public String profilehey(HttpServletRequest request, @PathVariable String userName,RedirectAttributes redirectAttribute,
			@RequestParam MultipartFile file) throws IllegalStateException, IOException {
		
		
		log.info(userName);
		User urlUser;
		String urlusername = ""; // url에 담긴 유저이름을 담을 변수
		String mySid = ""; // 쿠키에서 긁어온 유저정보를 담을 변수
		urlUser = userMapper.getUserByUsername(userName);
		
		Cookie[] cookies = request.getCookies();
		
		
		if(cookies == null) {
			
			return "user/login";
		}else {// cookie값이 존재할때 내가 찾는 cookie값이 있는지 체크.
			for (Cookie cookie : cookies)
				if(cookie.getName().equals("sid"))
					mySid = cookie.getValue();
			
			
			userMapper.updateUser(userName, "../resources/images/" + file.getOriginalFilename());
			redirectAttribute.addFlashAttribute("oneUser", userMapper.getUserByUsername(mySid));
			
			if(!file.isEmpty()) {
				
				String root_path = request.getSession().getServletContext().getRealPath("/");
            	root_path = root_path.replace("\\", "/");
            	log.info("root path : " + root_path);
            	String attach_path = "/resources/images/";

            	String fullPath = root_path + attach_path + file.getOriginalFilename();
            	
               log.info(" fullPath={}", fullPath);
               file.transferTo(new File(fullPath));
			}//!file.isEmpty()의 if문.
			
			if(urlusername.equals(mySid)) {
               return "redirect:/users/"+ userName; 
            }
            else {
               return "redirect:/users/"+ userName;
            }
		}//else
		
		
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	
	@PostMapping("/user/input")
	public String insertUser(@RequestParam("uemail") String uemail, @RequestParam("phone_number") String phone_number,
			@RequestParam("real_name") String real_name, @RequestParam("uname") String uname, @RequestParam("password") String password) {
		User user = new User();
		user.setUemail(uemail);
		user.setPhone_number(phone_number);
		user.setReal_name(real_name);
		user.setUname(uname);
		user.setPassword(password);
		
		userMapper.newUser(user);
		
		if(userMapper.idCheck(uname) == 1) {
			return "user/joined";
		} else {
			return "user/join";
		}
		
	}
	
	// 아이디 체크
    @PostMapping("/idCheck")
    @ResponseBody
    public String idCheck(@RequestParam("uname") String uname){
    	log.info("userIdCheck 진입");
    	log.info("전달받은 uname:"+uname);
        String cnt = Integer.toString(userMapper.idCheck(uname));
        log.info("확인 결과:"+cnt);

        return cnt;
    }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//비밀번호 변경 시작
	@GetMapping("/password/{userName}")
	public String editUserPasswordPage(HttpServletRequest request, HttpServletResponse response, Model model, @PathVariable String userName)
			throws IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Cookie[] cookies = request.getCookies();
		String mySid = "";
		PrintWriter outt = response.getWriter();
		
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("sid")) {
				mySid = cookie.getValue();
				if(userName.equals(mySid)) {
					
					model.addAttribute("editedUser", userMapper.getUserByUsername(mySid));
				}else {
					outt.println("<script>alert('이동할 수 없는 링크 입니다.'); location.href='redirect:/';</script>");
					outt.flush();
				}
			}
		}
	    return "user/userpassword/userPasswordChange";
	}
	
	//post 비밀번호 변경
	@PostMapping("/password/{userName}")
	public String editPostUserPasswordPage(HttpServletRequest request,HttpServletResponse response, @PathVariable String userName, @ModelAttribute PasswordInfo pwdinfouser, Model model)
			throws IOException, ServletException {
		
		log.info("password POST");
		
		User userinfo = userMapper.getUserByUsername(userName);
		String userpassword = userinfo.getPassword();//로그인중인 user의 현재비밀번호.
		String convertedpassword = request.getParameter("beforepassword");
		String newpassword = request.getParameter("secondpassword");
		log.info("현재 로그인중인 비밀번호 : " + userpassword);
		log.info("작성한 이전 비밀번호 : " + convertedpassword);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		String mySid = "";
		request.setAttribute("usernameInfo", userName);
		
		
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("sid")) {
				mySid = cookie.getValue();
				if(userName.equals(mySid)) {
					
					model.addAttribute("oneUser", userMapper.getUserByUsername(mySid));
				}else {
					out.println("<script>alert('이동할 수 없는 링크 입니다.'); location.href='redirect:/';</script>");
					out.flush();
				}
			}
		}
		///////////////////////////////////////////////////////////////////////////////
		if(userpassword.equals(convertedpassword)) {
				userMapper.setPassword(newpassword, userinfo.getUser_id());
				out.println("<script>alert('비밀번호를 변경하였습니다.'); location.href='" + "/insta/home/" + userName+ "';</script>");
				out.flush();
		}else {
			out.println("<script>alert('이전 비밀번호가 틀렸습니다.'); location.href='" + "/insta/password/" + userName+ "';</script>");
			out.flush();
		}
		
	    return "post/personal/editedcookie";
		
	}
}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////