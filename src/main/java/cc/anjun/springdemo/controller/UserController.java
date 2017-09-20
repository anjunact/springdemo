package cc.anjun.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cc.anjun.springdemo.domain.User;
import cc.anjun.springdemo.service.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/list")
	public void userList(Model model) {
		User u= userService.find();
		model.addAttribute("user",u);
	}
}
