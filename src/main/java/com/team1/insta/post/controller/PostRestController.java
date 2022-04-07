package com.team1.insta.post.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team1.insta.post.dao.mapper.PostMapper;
import com.team1.insta.post.dto.CommentManage;
import com.team1.insta.post.dto.Follow;
import com.team1.insta.post.dto.LikeManage;
import com.team1.insta.post.dto.PostJoinImages;
import com.team1.insta.user.dao.mapper.UserMapper;
import com.team1.insta.user.dto.User;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/postRest")
public class PostRestController {

	@Autowired
	UserMapper userMapper;

	@Autowired
	PostMapper postMapper;

	@PostMapping(value = "/commentGetUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getCommentUser(@RequestBody CommentManage commentManage) {

		log.info("commentManage의 user_id 값 : " + commentManage.getUser_id());
		User user = null;
		user = userMapper.getUser(commentManage.getUser_id());

		ResponseEntity<User> userEntity = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
				.body(user);

		return userEntity;
	}

	@PostMapping(value = "/leaveComment", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> leaveComment(@RequestBody CommentManage commentManage) {

		postMapper.leaveComment(commentManage.getPid(), commentManage.getUser_id(), commentManage.getContents());

		User user = userMapper.getUser(commentManage.getUser_id());

		ResponseEntity<User> userEntity = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
				.body(user);

		return userEntity;
	}

	@PostMapping(value = "/addfollow", produces = MediaType.APPLICATION_JSON_VALUE)
	public void addfollow(@RequestBody Follow follow) {

		postMapper.addFollow(follow.getFrom_user(), follow.getTo_user());

	}

	@PostMapping(value = "/deleteFollow", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteFollow(@RequestBody Follow follow) {

		postMapper.deleteFollow(follow.getFrom_user(), follow.getTo_user());

	}

	@PostMapping(value = "/FollowDecide", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Follow>> FollowDecide(@RequestBody Follow follow) {

		List<Follow> followList = postMapper.FollowDecide(follow.getFrom_user(), follow.getTo_user());

		ResponseEntity<List<Follow>> followListEntity = ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON).body(followList);

		return followListEntity;
	}

	@PostMapping(value = "/likeDecide", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LikeManage>> likeDecide(@RequestBody LikeManage likeManage) {

		List<LikeManage> likeList = postMapper.likeDecide(likeManage.getPid(), likeManage.getUser_id());

		ResponseEntity<List<LikeManage>> likeListEntity = ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON).body(likeList);

		return likeListEntity;
	}

	@PostMapping(value = "/addLike", produces = MediaType.APPLICATION_JSON_VALUE)
	public void addLike(@RequestBody LikeManage likeManage) {

		List<LikeManage> likeList = postMapper.likeDecide(likeManage.getPid(), likeManage.getUser_id());

		if (likeList.size() < 1) {
			postMapper.addLike(likeManage.getPid(), likeManage.getUser_id());
		}

	}

	@PostMapping(value = "/deleteLike", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteLike(@RequestBody LikeManage likeManage) {

		postMapper.deleteLike(likeManage.getPid(), likeManage.getUser_id());

	}

	@PostMapping(value = "/likeRealTimeLookup", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Integer> likeRealTimeLookup(@Param("pid") String pid) {

		Map<String, Integer> cnt = new HashMap<>();

		List<LikeManage> likeManage = postMapper.getLikeManage(pid);
		List<CommentManage> commentManage = postMapper.getCommentList(pid);

		cnt.put("like", likeManage.size());
		cnt.put("comment", commentManage.size());

//		ResponseEntity<List<LikeManage>> likeListEntity =  ResponseEntity
//				.status(HttpStatus.OK)
//				.contentType(MediaType.APPLICATION_JSON)
//				.body(likeManage);

		return cnt;
	}
}
