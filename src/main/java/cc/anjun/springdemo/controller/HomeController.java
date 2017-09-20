package cc.anjun.springdemo.controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.anjun.springdemo.domain.User;
import cc.anjun.springdemo.service.UserService;

@RestController
public class HomeController {
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
//	@Autowired
//	UserService userService;

	@GetMapping("/index")
	public String index() {

		return dataSource.toString();

	}
	@GetMapping("/user")
	public User findUser() {
//		return userService.find();
		UserService userService = (UserService)applicationContext.getBean("userService");	
		return userService.find();
	}
	@GetMapping("/listBean")
	public String[] listBean(){
		String[] list = applicationContext.getBeanDefinitionNames();
		return list;
	}
}
