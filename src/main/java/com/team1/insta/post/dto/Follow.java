package com.team1.insta.post.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Follow {

	private String fid;
	private String from_user;
	private String to_user;
	private Date follow_time;
	private char follow_condition;
}
