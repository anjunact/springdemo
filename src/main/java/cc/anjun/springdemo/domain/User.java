package cc.anjun.springdemo.domain;

import java.util.LinkedList;

import lombok.Data;

@Data
public class User {
		private Long id;
		private String name;
		private String password;
		private Integer age;
		private String email;
		private LinkedList<Post> posts = new LinkedList<Post>();
}
