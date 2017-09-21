package cc.anjun.springdemo.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import cc.anjun.springdemo.AppConfig;
import cc.anjun.springdemo.domain.User;

@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class UserDAOTest2 extends AbstractTestNGSpringContextTests {
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