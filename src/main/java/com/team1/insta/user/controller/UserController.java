package com.team1.insta.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team1.insta.user.dao.mapper.UserMapper;
import com.team1.insta.user.dto.EditRequest;
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
		
		Cookie[] cookies = request.getCookies();
		String mySid = "";
		PrintWriter outt = response.getWriter();
		
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("sid")) {
				mySid = cookie.getValue();
				if(userName.equals(mySid)) {
					
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
	public String editUser(Model model, @PathVariable String userName, @ModelAttribute EditRequest editrequest) {
		
		String editedname = editrequest.getUname();
		String phoneNum = editrequest.getPhone_number();
		Character followacpt = editrequest.getFollow_accept();
		String realName = editrequest.getReal_name();
		
		
		
		User user = userMapper.getUserByUsername(userName);
		
		
		userMapper.updateUserInfo(userName, editedname, phoneNum, followacpt, realName);
		
		
	    return "user/update";
	}
	

	
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
}
