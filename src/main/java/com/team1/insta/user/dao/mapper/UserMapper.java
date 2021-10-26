package com.team1.insta.user.dao.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Param;


import com.team1.insta.user.dto.KeyConfirm;

import com.team1.insta.user.dto.User;

public interface UserMapper {

	public List<User> getList();
	public int newUser(User user);
	public int idCheck(String uname);
	public User getUserBytype(KeyConfirm keyconfirm);
	public void setPassword(@Param("newPassword") String newPassword, @Param("userId") String userId);
	
	public User getUser(int user_id);
	
	public User getUserByUsername(String uname);
	
	public void updateUser(@Param("user_id") int user_id, @Param("profile_img") String profile_img);
	
	public void updateUserInfo(@Param("stdname") String stdname, @Param("uname") String uname, @Param("phone_number") 
	String phone_number, @Param("follow_accept") Character follow_accept, @Param("real_name") String real_name );
}
