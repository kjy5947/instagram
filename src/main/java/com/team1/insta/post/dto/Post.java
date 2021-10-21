package com.team1.insta.post.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Post {
	
	private String pid;
	private String uid;
	private Date post_time;
	private Date modify_time;
	private String pcontents;
	private char status;

}
