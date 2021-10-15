package com.team1.insta.user.dao.mapper;

import java.util.List;

import com.team1.insta.user.dto.User;
import com.team1.insta.user.dto.UserName;

public interface UserMapper {

	public List<User> getList();
	public int newUser(User user);
	public List<UserName> getUname();
}
