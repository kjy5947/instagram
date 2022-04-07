package com.team1.insta.user.dto;

import java.util.Date;
import lombok.Data;

@Data
public class User {

	private String user_id;
	private String real_name;
	private String uname;
	private String uemail;
	private Date join_date;
	private String password;
	private String phone_number;
	private char follow_accept;
	private String profile_img;
	private String user_introduce;
	
}
