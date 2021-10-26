package com.team1.insta.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team1.insta.user.dao.mapper.UserMapper;
import com.team1.insta.user.dto.User;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;




import com.team1.insta.user.dto.EditRequest;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Log4j
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
			log.info("占쏙옙占쏙옙 占쏙옙占쏙옙 fullPath={}", fullPath);
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
		
		
		// to do: DB占쏙옙 占쏙옙회占쌔쇽옙 user占쏙옙체占쏙옙 占쏙옙티占� 占싼곤옙占쌍깍옙
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
		
		//log.info(user);
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
