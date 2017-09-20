package cc.anjun.springdemo.service;

import org.springframework.stereotype.Service;

import cc.anjun.springdemo.domain.User;

@Service
public class UserService {
	public User find() {
		User u = new User();
		u.setName("张三");
		u.setEmail("A@QQ.COM");
		return u;
	}
}
