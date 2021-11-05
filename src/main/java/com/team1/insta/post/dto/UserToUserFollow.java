package com.team1.insta.post.dto;

import lombok.Data;

@Data
public class UserToUserFollow {

	private String user_id; // follow를 신청한 사람
	private String to_user; //follow를 받은 사람
	private char follow_condition;
//	private 
//	private
//	private
}
