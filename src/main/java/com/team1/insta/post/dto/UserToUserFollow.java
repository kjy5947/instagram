package com.team1.insta.post.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class UserToUserFollow {

	private String from_user; // follow를 신청한 사람
	private String to_user; //follow를 받은 사람
	private char follow_accept;
	private String fid; 
	private Date follow_time;
	private String follow_condition;
}
