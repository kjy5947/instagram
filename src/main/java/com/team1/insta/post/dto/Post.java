
package com.team1.insta.post.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Post {
	private String pid;
	private String user_id;
	private Date post_time;
	private Date modify_time;
	private String pcontents;
	private String uname;
	private String profile_img;
	private String follow_accept;
	private List<PidLike> likeList;
	private List<PidLikeCount> likeCountList;
	private List<PidImages> imageList;
	private List<PidImageCount> imageCountList;
	private List<PidComments> commentList;
	private List<PidCommentCount> commentCountList;
}
