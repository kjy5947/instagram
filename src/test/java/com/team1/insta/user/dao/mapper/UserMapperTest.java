package com.team1.insta.user.dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team1.insta.user.dto.User;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class UserMapperTest {

	@Autowired
	UserMapper userMapper;
	
	@Test
	public void getUser() {
		for(User user : userMapper.getList()) {
			log.info(user);
		}
	}
	
	@Test
	public void getUname() {
		log.info(userMapper.idCheck("melosa0520"));
	}
}
