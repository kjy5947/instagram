package com.team1.insta.user.dto;

import java.util.Date;

import lombok.Data;

@Data
public class EditRequest {
	
	private String uname;
	private String phone_number;
	private Character follow_accept;
	private String real_name;
}
