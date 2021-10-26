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
			messageHelper.setSubject(user.getUname() + "�떂, �뜑�슧 媛꾪렪�븯寃� Instagram�뿉 �떎�떆 濡쒓렇�씤 �빐蹂댁꽭�슂");
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
					+ "       "+user.getUname() +"�떂 �븞�뀞�븯�꽭�슂.<br> <br>\r\n"
					+ "        Instagram 濡쒓렇�씤怨� 愿��젴�븯�뿬 遺덊렪�쓣 �겮爾먮뱶�젮 二꾩넚�빀�땲�떎. 鍮꾨�踰덊샇瑜� �엸�쑝�뀲�굹�슂? �쉶�썝�떂�씠 濡쒓렇�씤�븳 寃껋씠 留욌떎硫� 吏�湲� 諛붾줈 怨꾩젙�뿉 濡쒓렇�씤�븯嫄곕굹 鍮꾨�踰덊샇瑜� �옱�꽕�젙�븷 �닔 �엳�뒿�땲�떎.\r\n"
					+ "        <br><br>\r\n"
					+ "        <div style=\"color: white;\r\n"
					+ "    background-color: skyblue;\r\n"
					+ "    border: none;\r\n"
					+ "    border-radius: 5px;\r\n"
					+ "    width: 100%;\r\n"
					+ "    height: 40px;\r\n"
					+ "    text-align: center;\r\n"
					+ "    display: table;\">\r\n"
					+ "            <a href=\"\" style=\"text-decoration: none; color: white; vertical-align: middle; display: table-cell;\">"+user.getUname()+"(�쑝)濡�\r\n"
					+ "                濡쒓렇�씤</a>\r\n"
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
					+ "                鍮꾨�踰덊샇 �옱�꽕�젙\r\n"
					+ "            </a>\r\n"
					+ "        </div>\r\n"
					+ "        <br><br>\r\n"
					+ "        濡쒓렇�씤 留곹겕�굹 鍮꾨�踰덊샇 �옱�꽕�젙�쓣 �슂泥��븯吏� �븡�� 寃쎌슦 �씠 硫붿떆吏�瑜� 臾댁떆�븯怨� 硫붿떆吏�瑜� 諛쏆� �씠�쑀�뿉 ���빐 �옄�꽭�엳 �븣�븘蹂댁꽭�슂.\r\n"
					+ "        <br><br>\r\n"
					+ "        �쉶�썝�떂�쓽 Instagram 鍮꾨�踰덊샇瑜� �븣怨� �엳嫄곕굹 �씠 �씠硫붿씪�뿉�꽌 濡쒓렇�씤 留곹겕瑜� �겢由��븳 �궗�엺留� �쉶�썝�떂�쓽 怨꾩젙�뿉 濡쒓렇�씤�븷 �닔 �엳�뒿�땲�떎.\r\n"
					+ "    </div>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "\r\n"
					+ "</html>"; 


			messageHelper.setText(htmlContent,true); // 硫붿씪 �궡�슜


			mailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<User> entity = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(user);

		return entity;
	}

}
