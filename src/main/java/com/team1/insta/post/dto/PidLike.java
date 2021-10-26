package com.team1.insta.post.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PidLike {
	private Integer user_id;
	private Date like_time;
}
