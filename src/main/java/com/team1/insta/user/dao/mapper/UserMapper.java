package com.team1.insta.user.dao.mapper;

import java.util.List;

import com.team1.insta.user.dto.User;

public interface UserMapper {

	public List<User> getList();
	
	public User getUser(Integer uid);
}
