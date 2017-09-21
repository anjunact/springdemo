package cc.anjun.springdemo.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cc.anjun.springdemo.AppConfig;
import cc.anjun.springdemo.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@WebAppConfiguration
public class UserDAOTest {

	@Autowired
	private UserDao userDAO;
	
	@Test
	public void testListUsers() {
		List<User> users = userDAO.findAll();
		for (User user : users) {
			System.out.println(user);
		}
	}

}
