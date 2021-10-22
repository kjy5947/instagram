package com.team1.insta.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team1.insta.user.dao.mapper.UserMapper;
import com.team1.insta.user.dto.User;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/")
@Controller
public class UserController {

	@Autowired
	UserMapper userMapper;
	
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
		
		log.info(user);
		return "user/login";
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
