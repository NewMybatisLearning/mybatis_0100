package com.ymd.learn;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ymd.learn.entity.User;

public class UserTest {
	
	SqlSession session = null;
	
	@Before
	public void setup() {
		try {
		String resource = "mybatis-configuration.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSelectUserById() {
		User user = session.selectOne("mapper.selectUserById", 1);
		System.out.println("user  = " + user);
	}
	
	@Test
	public void testSelectUserAll() {
		List<User> users = session.selectList("mapper.selectUserAll");
		users.forEach(user -> {
			System.out.println(user);
		});
	}
	
	@Test
	public void testSelectLikeUsername() {
		List<User> users = session.selectList("mapper.selectLikeUsername", "mi");
		users.forEach(user -> {
			System.out.println(user);
		});
	}
	
	@Test
	public void testInsertUser() {
		User user = new User();
		user.setUsername("lincoln");
		user.setBirthday(new Date());
		user.setAddress("shenzhen songgang");
		user.setSex("1");
		session.insert("mapper.insertUser", user);
		session.commit();
	}
	
	@Test
	public void testUpdateUserById() {
		User user = session.selectOne("mapper.selectUserById", 1);
		user.setUsername("michaelyao");
		session.update("mapper.updateUserById", user);
		session.commit();
	}
	
	@Test
	public void testDeleteUserById() {
		session.delete("mapper.deleteUserById", 7);
		session.commit();
	}
	
	@Test
	public void testSelectByBirthdayRange() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("min", "2018-03-01 00:00:00");
		map.put("max", "2018-03-08 00:00:00");
		
		List<User> users = session.selectList("mapper.getUserByBirthdayRange", map);
		users.forEach(user -> {
			System.out.println(user);
		});
	}
	
	
	
	@After
	public void destory() {
		session.close();
	}
}
