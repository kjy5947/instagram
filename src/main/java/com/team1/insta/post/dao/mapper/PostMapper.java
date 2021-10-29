package com.team1.insta.post.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team1.insta.post.dto.CommentManage;
import com.team1.insta.post.dto.Follow;
import com.team1.insta.post.dto.Images;
import com.team1.insta.post.dto.LikeManage;
import com.team1.insta.post.dto.Post;
import com.team1.insta.post.dto.PostJoinImages;
import com.team1.insta.post.dto.TagPerson;

public interface PostMapper {

	public List<Post> getPostList(@Param("userId") String userId);
	public List<Images> getImagesList(@Param("pId") String pId);
	public PostJoinImages getPostJoinImages(@Param("pId") String pId);
	public List<LikeManage> getLikeManage(@Param("pId") String pId);
	public List<TagPerson> getTagPersonByUserId(@Param("userId") String userId);
	public List<Follow> getFollower(@Param("userId") String userId);
	public List<Follow> getFollowing(@Param("userId") String userId);
	public List<CommentManage> getCommentList(@Param("pId") String pId);
	public void leaveComment(@Param("pId") String pId, @Param("user_id") String user_id, @Param("contents") String contents);
	public int addFollow(@Param("from_user") String from_user, @Param("to_user") String to_user);
	public int deleteFollow(@Param("from_user") String from_user, @Param("to_user") String to_user);
	public List<Follow> FollowDecide(@Param("from_user") String from_user, @Param("to_user") String to_user);
	
}
