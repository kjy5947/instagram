package com.team1.insta.user.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PasswordToken {

	private String id;
	private String user_id;
	private Date create_date;
	private Date expiration_date;	
	
}
