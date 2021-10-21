package com.team1.insta.post.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team1.insta.post.dto.Images;
import com.team1.insta.post.dto.Post;

public interface PostMapper {

	public List<Post> getPostList(@Param("userId") String userId);
	public List<Images> getImagesList(@Param("pId") String pId);
	
}
