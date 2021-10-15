package com.team1.insta.user.controller;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team1.insta.user.dao.mapper.UserMapper;
import com.team1.insta.user.dto.KeyConfirm;
import com.team1.insta.user.dto.User;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/password")
public class PassWordResetController {
	
	@Autowired
	UserMapper userMapper;
	
	
	@GetMapping("/")
	public String passwordHome() {
		
		return "user/passwordReset";
	}
		
	@PostMapping("/passwordPopup")
	public String popup() {
		
		return "user/passwordPopup";
	}

}
