package com.team1.insta.post.mapper;

import java.util.List;

import com.team1.insta.post.dto.PidCommentCount;
import com.team1.insta.post.dto.PidComments;
import com.team1.insta.post.dto.PidImages;
import com.team1.insta.post.dto.PidLike;
import com.team1.insta.post.dto.PidLikeCount;
import com.team1.insta.post.dto.Post;

public interface MainXMLMapper {
	public List<Post> getPostList();
	
	public List<PidLike> getLikeList(Integer post_id);
	
	public List<PidLikeCount> getLikeCountList(Integer post_id);
	
	public List<PidImages> getImages(Integer post_id);
	
	public List<PidComments> getCommentList(Integer post_id);
	
	public List<PidCommentCount> getCommentCountList(Integer post_id);
	

}
