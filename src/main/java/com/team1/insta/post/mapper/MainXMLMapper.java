package com.team1.insta.post.mapper;

import java.util.List;

import com.team1.insta.post.dto.PidCommentCount;
import com.team1.insta.post.dto.PidComments;
import com.team1.insta.post.dto.PidImageCount;
import com.team1.insta.post.dto.PidImages;
import com.team1.insta.post.dto.PidLike;
import com.team1.insta.post.dto.PidLikeCount;
import com.team1.insta.post.dto.Post;
import com.team1.insta.post.dto.UserToUserFollow;

public interface MainXMLMapper {
	public List<Post> getPostList();
	
	public List<PidLike> getLikeList(String post_id);
	
	public List<PidLikeCount> getLikeCountList(String post_id);
	
	public List<PidImages> getImages(String post_id);
	
	public List<PidImageCount> getImageCount(String post_id);
	
	public List<PidComments> getCommentList(String post_id);
	
	public List<PidCommentCount> getCommentCountList(String post_id);
	
}

