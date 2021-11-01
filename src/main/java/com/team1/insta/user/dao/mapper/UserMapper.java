package com.team1.insta.user.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.team1.insta.user.dto.EditRequest;
import com.team1.insta.user.dto.KeyConfirm;
import com.team1.insta.user.dto.User;

public interface UserMapper {

	public List<User> getList();
	public int newUser(User user);
	public int idCheck(String uname);

	public User getUserBytype(KeyConfirm keyconfirm);
	public void setPassword(@Param("newPassword") String newPassword, @Param("userId") String userId);
	
	public User getUser(@Param("user_id") String user_id);

	public User getUserByUsername(@Param("uname") String uname);
	
	public void updateUser(@Param("uname") String uname, @Param("profile_img") String profile_img);
	
	public void updateUserInfo(@Param("stdname") String stdname, @Param("uname") String uname, 
			@Param("userIntroduce") String userIntroduce, @Param("followAccept") String followAccept,
			@Param("realName") String realName, @Param("phoneNumber") String phoneNumber);
	
	public String existUser(@Param("uname") String uname);
	
}
