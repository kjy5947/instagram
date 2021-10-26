package com.team1.insta.user.controller;

import java.util.UUID;
import java.util.regex.Pattern;

import javax.mail.internet.MimeMessage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;



import com.team1.insta.user.dao.mapper.TokenMapper;
import com.team1.insta.user.dao.mapper.UserMapper;
import com.team1.insta.user.dto.KeyConfirm;
import com.team1.insta.user.dto.User;

import lombok.extern.log4j.Log4j;


@RestController
public class PasswordRestController {

	@Autowired
	UserMapper userMapper;

	@Autowired
	public JavaMailSender mailSender;

	@Autowired
	TokenMapper tokenMapper;


	@PostMapping("/passwordReset")
	public ResponseEntity<User> passwordIdCheck(
			@RequestBody String findkey,
			HttpSession session
			) {


		String emailPatten = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
		String phonePatten = "^01(?:0|1|[6-9])[-]?(\\d{3}|\\d{4})[-]?(\\d{4})$";
		findkey = findkey.substring(1, findkey.length()-1);

		KeyConfirm keyconf = new KeyConfirm();


		if(Pattern.matches(emailPatten, findkey)) {
			keyconf.setKeyType("email");
		} else if (Pattern.matches(phonePatten, findkey)) {
			keyconf.setKeyType("phone");
		} else {
			keyconf.setKeyType("id");
		}
		keyconf.setKey(findkey);

		User user = userMapper.getUserBytype(keyconf);

		if(user == null) {
			return null;
		}

		String tokenId = UUID.randomUUID().toString();
		String userId = user.getUser_id();

		tokenMapper.createToken(tokenId, userId);


		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom("instagram");
			messageHelper.setTo(user.getUemail());
			messageHelper.setSubject(user.getUname() + "님, 더욱 간편하게 Instagram에 다시 로그인 해보세요");
			String htmlContent = "<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Document</title>\r\n"
					+ "</head>\r\n"
					+ "<style>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "</style>\r\n"
					+ "\r\n"
					+ "<body>\r\n"
					+ "\r\n"
					+ "    <div style=\"text-align: justify;\r\n"
					+ "width: 400px;\" id=\"main\">\r\n"
					+ "        <img style=\"  width: 200px;\r\n"
					+ "    text-align: left;\r\n"
					+ "    display: block;\" src=\"https://static.xx.fbcdn.net/rsrc.php/v3/yb/r/QTa-gpOyYBa.png\" alt=\"\" srcset=\"\"> <br>\r\n"
					+ "\r\n"
					+ "       "+user.getUname() +"님 안녕하세요.<br> <br>\r\n"
					+ "        Instagram 로그인과 관련하여 불편을 끼쳐드려 죄송합니다. 비밀번호를 잊으셨나요? 회원님이 로그인한 것이 맞다면 지금 바로 계정에 로그인하거나 비밀번호를 재설정할 수 있습니다.\r\n"
					+ "        <br><br>\r\n"
					+ "        <div style=\"color: white;\r\n"
					+ "    background-color: skyblue;\r\n"
					+ "    border: none;\r\n"
					+ "    border-radius: 5px;\r\n"
					+ "    width: 100%;\r\n"
					+ "    height: 40px;\r\n"
					+ "    text-align: center;\r\n"
					+ "    display: table;\">\r\n"
					+ "            <a href=\"\" style=\"text-decoration: none; color: white; vertical-align: middle; display: table-cell;\">"+user.getUname()+"(으)로\r\n"
					+ "                로그인</a>\r\n"
					+ "        </div>\r\n"
					+ "        <br><br>\r\n"
					+ "        <div style=\"color: white;\r\n"
					+ "    background-color: skyblue;\r\n"
					+ "    border: none;\r\n"
					+ "    border-radius: 5px;\r\n"
					+ "    width: 100%;\r\n"
					+ "    height: 40px;\r\n"
					+ "    text-align: center;\r\n"
					+ "    display: table;\r\n"
					+ "    \">\r\n"
					+ "            <a href=\"http://localhost:8080/insta/change?email="+user.getUemail() +"&token="+ tokenId+"\" style=\"text-decoration: none;\r\n"
					+ "    color: white;\r\n"
					+ "    vertical-align: middle;\r\n"
					+ "    display: table-cell;\">\r\n"
					+ "                비밀번호 재설정\r\n"
					+ "            </a>\r\n"
					+ "        </div>\r\n"
					+ "        <br><br>\r\n"
					+ "        로그인 링크나 비밀번호 재설정을 요청하지 않은 경우 이 메시지를 무시하고 메시지를 받은 이유에 대해 자세히 알아보세요.\r\n"
					+ "        <br><br>\r\n"
					+ "        회원님의 Instagram 비밀번호를 알고 있거나 이 이메일에서 로그인 링크를 클릭한 사람만 회원님의 계정에 로그인할 수 있습니다.\r\n"
					+ "    </div>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "\r\n"
					+ "</html>"; 


			messageHelper.setText(htmlContent,true); // 메일 내용


			mailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<User> entity = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(user);

		return entity;
	}

}
