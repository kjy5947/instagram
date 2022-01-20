package com.team1.insta.user.dto;

import java.util.Date;

import lombok.Data;

@Data
public class EditRequest {
	
	private String uname;
	private String userIntroduce;
	private String followAccept;
	private String realName;
	private String phoneNumber;
	private String uemail;
}
