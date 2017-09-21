package cc.anjun.springdemo.domain;

import java.util.LinkedList;

import lombok.Data;

@Data
public class User {
		private Long id;
		private String username;
		private String password;
		private Boolean enable;
		private Integer age;
		private String email;
		private LinkedList<Post> posts = new LinkedList<Post>();
}
