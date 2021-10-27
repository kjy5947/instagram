package com.team1.insta.user.controller;



import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team1.insta.user.dao.mapper.UserMapper;

@Controller
@RequestMapping("")
public class LoginController {
	
	@Autowired
	UserMapper userMapper;
	
	@GetMapping("")
	public String home() {
		return "user/login";
	}
	
	@PostMapping("")
	public String idCheck(@RequestParam("idvalue") String id, @RequestParam("pwvalue") String pw, HttpSession session, Model model, HttpServletResponse res) throws IOException {
		boolean isNumeric = true;
		boolean idCheck = false;
        for (int i = 0; i < id.length(); i++) {
            if (!Character.isDigit(id.charAt(i))) {
                isNumeric = false;
            }
        }
		if(id.contains("@")) 
		{
			for(int i = 0; i < userMapper.getList().size(); i++) {
				if(userMapper.getList().get(i).getUemail().equals(id))
				{
					idCheck = true;
					if(userMapper.getList().get(i).getPassword().equals(pw))
					{
						//session.setAttribute("sid", id);
						Cookie cookie = new Cookie("sid", id);
						
						cookie.setMaxAge(60*120);//2시간 동안 쿠키값유지하게 해줌.
						res.addCookie(cookie);
						
						return "mainpage/main";
					}
				}
			}
			if(idCheck) 
			{
				model.addAttribute("pwcheck", "fail");				
			}
			else
			{
				model.addAttribute("idcheck", "fail");
			}
			

		}
		else if(isNumeric || Pattern.matches("^\\d{3}-\\d{4}-\\d{4}$", id))
		{
			for(int i = 0; i < userMapper.getList().size(); i++) {
				if(userMapper.getList().get(i).getPhone_number().equals(id))
				{
					idCheck = true;
					if(userMapper.getList().get(i).getPassword().equals(pw))
					{
						session.setAttribute("sid", id);
						return "mainpage/main";
					}
				}
			}
			if(idCheck) 
			{
				model.addAttribute("pwcheck", "fail");				
			}
			else
			{
				model.addAttribute("idcheck", "fail");
			}
		}
		else
		{
			for(int i = 0; i < userMapper.getList().size(); i++) {
				if(userMapper.getList().get(i).getUname().equals(id))
				{
					idCheck = true;
					if(userMapper.getList().get(i).getPassword().equals(pw))
					{
						session.setAttribute("sid", id);
						return "mainpage/main";
					}
				}
			}
			if(idCheck) 
			{
				model.addAttribute("pwcheck", "fail");				
			}
			else
			{
				model.addAttribute("idcheck", "fail");
			}
		}
		
		return "user/login";	
	}

}