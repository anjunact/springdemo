package cc.anjun.springdemo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cc.anjun.springdemo.dao.UserDao;
import cc.anjun.springdemo.domain.User;
import cc.anjun.springdemo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserDao userDao;

	@RequestMapping("/login")
	public String login() {
		return "/user/login";
	}

	@RequestMapping("/test")
	public void userList(Model model) {
		// User u= userService.find();
		// model.addAttribute("user",u);
		// userDao.add(u);
		User user = userDao.findById(1L);
		System.out.println(user.getUsername());
		System.out.println(user.getEmail());
	}

	@RequestMapping("/list")
	public @ResponseBody List<User> findAll() {
		return userDao.findAll();
	}

	@RequestMapping("/list2")
	public @ResponseBody List<User> findAll2() {
		return userDao.findAll2();
	}

	@RequestMapping("/delete/{id}")
	public @ResponseBody void del(@PathVariable("id") Long id) {
		User user = new User();
		user.setId(id);
		userDao.delete(user);
	}

	@RequestMapping("/testTransaction")
	public @ResponseBody void testTransaction() {

		userDao.performSeveralQueries();
	}

	@GetMapping("/add")
	public String add() {
		return "user/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	// public String addUserSubmit(@ModelAttribute User u) {
	public String addUserSubmit(@ModelAttribute User u, @RequestParam("file") MultipartFile formFile) {
		System.out.println(u.getUsername());
		System.out.println(u.getAge());

		try {
			// Create the folder "files" if necessary
			String tomcatFolderPath = System.getProperty("catalina.home");
			File filesFolder = new File(tomcatFolderPath + File.separator + "files");
			if (!filesFolder.exists()) {
				filesFolder.mkdirs();
			}

			// Create the file on server
			File file = new File(filesFolder.getAbsolutePath() + File.separator + formFile.getName());

			FileOutputStream fi = new FileOutputStream(file);
			fi.write(formFile.getBytes());
			fi.close();

			// BufferedOutputStream fileStream = new BufferedOutputStream(new
			// FileOutputStream(file));
			// fileStream.write(formFile.getBytes());
			// fileStream.close();

			System.out.println(filesFolder.getAbsolutePath() + File.separator + formFile.getName());
		} catch (Exception e) {
			// deal with the exception…
		}

		return "redirect:/user/list";
	}

	@ModelAttribute("defaultUser")
	public User defaultUser() {
		User user = new User();
		user.setUsername("Joe");
		user.setAge(18);
		return user;
	}
}
