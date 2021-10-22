package com.team1.insta.user.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.team1.insta.user.dto.PasswordToken;

public interface TokenMapper {
	
	public PasswordToken getToken(@Param("tokenId") String tokenId);
	public void createToken(@Param("tokenId") String tokenId, @Param("userId") String userId);
	public void deleteToken(@Param("tokenId") String tokenId);
	

}
