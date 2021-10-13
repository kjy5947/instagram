package com.team1.insta.user.dao.mapper;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Ignore;
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
	
	@Autowired
	HikariConnector hikari;
	
	@Ignore
	@Test
	public void getUser() {
		for(User user : userMapper.getList()) {
			log.info(user);
		}
	}

	@Test
	public void testConnection() {

		Connection con = hikari.getConnection();	

			
		System.out.println("con="+con);
		
	}
}
