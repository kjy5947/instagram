package com.team1.insta.post.dto;

import java.util.Date;

import lombok.Data;

@Data
public class LikeManage {
	
	private String lid;
	private String pid;
	private String user_id;
	private Date like_time;
	
}
