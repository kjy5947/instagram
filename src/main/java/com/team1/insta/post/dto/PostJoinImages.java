package com.team1.insta.post.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PostJoinImages {

	private String pid;
	private String user_id;
	private Date post_time;
	private Date modify_time;
	private String pcontents;
	private char status;
	private String pimg;
	private String iid;

	
}
