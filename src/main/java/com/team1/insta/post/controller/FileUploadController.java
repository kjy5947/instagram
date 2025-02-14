package com.team1.insta.post.controller;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.team1.insta.post.dao.mapper.PostMapper;
import com.team1.insta.user.dao.mapper.UserMapper;
import com.team1.insta.user.dto.User;

@Controller
public class FileUploadController {

	@Autowired
	UserMapper userMapper;
	@Autowired
	PostMapper postMapper;

	@RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
	public String dragAndDrop(Model model) {

		return "post/fileUpload";

	}

	@RequestMapping(value = "/posting", method = RequestMethod.GET)
	public String posting() {

		return "post/posting";

	}

	@RequestMapping(value = "/postingImages")
	public String postingImages(HttpServletRequest request, Model model) {
		Cookie[] cookies = request.getCookies();

		String uname = "";
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("sid")) {
				uname = cookie.getValue();
			}
		}
		User user = userMapper.getUserByUsername(uname);
		model.addAttribute("user", user);
		model.addAttribute("pid", postMapper.getLastPID(uname));
		return "post/contents";
	}

	@RequestMapping(value = "/fileUpload/addPosting")
	public String addPosting(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();

		String uname = "";
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("sid")) {
				uname = cookie.getValue();
			}
		}
		postMapper.addPost(uname);
		return "success";
	}

	@RequestMapping(value = "/fileUpload/post") // ajax에서 호출하는 부분
	@ResponseBody
	public String upload(MultipartHttpServletRequest multipartRequest, HttpServletRequest request) { // Multipart로 받는다.
		Cookie[] cookies = request.getCookies();

		String uname = "";
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("sid")) {
				uname = cookie.getValue();
			}
		}
		String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		Iterator<String> itr = multipartRequest.getFileNames();

		String rootPath = request.getSession().getServletContext().getRealPath("/");
		rootPath = rootPath.replace("\\", "/");
		String attach_path = "resources/images/";

		while (itr.hasNext()) { // 받은 파일들을 모두 돌린다.
			MultipartFile mpf = multipartRequest.getFile(itr.next());

			String originalFilename = mpf.getOriginalFilename(); // 파일명
			String pimg = uname + "_" + currentTime + "_" + originalFilename;
			String fileFullPath = rootPath + attach_path + pimg; // 파일 전체 경로

			try {
				// 파일 저장
				mpf.transferTo(new File(fileFullPath)); // 파일저장 실제로는 service에서 처리
				Thread.sleep(1000);
				postMapper.addImages("../resources/images/" + pimg, uname);

				System.out.println("originalFilename => " + originalFilename);
				System.out.println("fileFullPath => " + fileFullPath);

			} catch (Exception e) {
				System.out.println("postTempFile_ERROR======>" + fileFullPath);
				e.printStackTrace();
			}

		}

		return "success";
	}
}
