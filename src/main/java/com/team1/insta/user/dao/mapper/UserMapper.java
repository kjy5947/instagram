package com.team1.insta.user.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team1.insta.user.dto.User;

public interface UserMapper {

	public List<User> getList();
	
	public User getUser(int user_id);
	
	public void updateUser(@Param("user_id") int user_id, @Param("profile_img") String profile_img);
}
