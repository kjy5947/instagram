package com.team1.insta.post.dto;

import lombok.Data;

@Data
public class CommentManage {

	private String cid;
	private String pid;
	private String user_id;
	private String contents;
}
