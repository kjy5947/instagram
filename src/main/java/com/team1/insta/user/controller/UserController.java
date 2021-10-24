package com.team1.insta.user.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team1.insta.user.dao.mapper.UserMapper;
import com.team1.insta.user.dto.EditRequest;
import com.team1.insta.user.dto.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
public class UserController {
	
	@Value("${file.dir}")
	private String fileDir;
	
	private final UserMapper userMapper;
	private final UserMapper usermp;
	
	/*
	@GetMapping("users/{userName}/profile")
	public String editProfilePage() {
	    return "post/personal/profileEdit";
	}
	@PostMapping("/upload")
	public String saveFile(@RequestParam MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			String fullPath = fileDir + file.getOriginalFilename();
			log.info("파일 저장 fullPath={}", fullPath);
			file.transferTo(new File(fullPath));
		}
		return "post/personal/profileEdit";
	}
	*/
	@GetMapping("/users/{userName}")
	public String editUserPage() {
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
		
		
		// to do: DB를 조회해서 user객체를 담아서 넘겨주기
	    return "user/update";
	}
	

}
