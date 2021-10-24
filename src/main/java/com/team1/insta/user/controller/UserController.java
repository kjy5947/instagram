package com.team1.insta.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.team1.insta.user.dao.mapper.UserMapper;
import com.team1.insta.user.dto.EditRequest;
import com.team1.insta.user.dto.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequiredArgsConstructor
@Log4j
@Controller
public class UserController {
	
	private final UserMapper userMapper;

	@PostMapping("/users/{userName}")
	public String editUser(Model model, @PathVariable String userName, @ModelAttribute EditRequest editrequest) {
		
		String editedname = editrequest.getUname();
		String phoneNum = editrequest.getPhone_number();
		Character followacpt = editrequest.getFollow_accept();
		String realName = editrequest.getReal_name();
		
		
		log.info(editrequest);
		
		User user = userMapper.getUserByUsername(userName);
		
		
		userMapper.updateUserInfo(userName, editedname, phoneNum, followacpt, realName);
		
		
		// to do: DB를 조회해서 user객체를 담아서 넘겨주기
	    return "user/info";
	}
	

}
