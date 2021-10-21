package com.team1.insta.user.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team1.insta.user.dto.KeyConfirm;
import com.team1.insta.user.dto.User;

public interface UserMapper {

	public List<User> getList();
	public int newUser(User user);
	public int idCheck(String uname);
	public User getUser(KeyConfirm keyconfirm);
	public void setPassword(@Param("newPassword") String newPassword, @Param("userId") String userId);
}