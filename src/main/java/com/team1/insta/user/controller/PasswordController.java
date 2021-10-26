package com.team1.insta.user.controller;


import java.util.Date;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;


import com.team1.insta.user.dao.mapper.TokenMapper;
import com.team1.insta.user.dao.mapper.UserMapper;
import com.team1.insta.user.dto.KeyConfirm;
import com.team1.insta.user.dto.PasswordToken;
import com.team1.insta.user.dto.User;

@Controller
public class PasswordController {

	@Autowired
	UserMapper userMapper;

	@Autowired
	TokenMapper tokenMapper;

	@GetMapping("/password")
	public String passwordHome(HttpServletRequest request) {

		return "user/passwordReset";
	}


	@GetMapping("/change")
	public String passwordChange(
			@RequestParam(value = "email") String email, 
			@RequestParam(value = "token") String tokenId,
			HttpSession session, Model model ) {

		KeyConfirm keyconf = new KeyConfirm();
		keyconf.setKey(email);
		keyconf.setKeyType("email");

		User user =  userMapper.getUserBytype(keyconf);
		PasswordToken passwordToken = null;
		
		passwordToken =  tokenMapper.getToken(tokenId);

	
		Date now =new Date();
		Date expirationDate = null;
		try {
			expirationDate = passwordToken.getExpiration_date();
		}catch (Exception e) {
			return "user/passwordError";
		}
		
		if (now.before(expirationDate)) {
			model.addAttribute("user", user);
			model.addAttribute("token_id", passwordToken.getId());
			return "user/passwordChange";

		} else {
			return "user/passwordError";
		}

	}

	@PostMapping("/passwordCheck")
	public String passwordChange(
			String newPassword,
			String passwordCheck,
			String user_id,
			String token_id
			) {
		
			tokenMapper.deleteToken(token_id);
			userMapper.setPassword(newPassword, user_id);
			return null;
			
	}
}
