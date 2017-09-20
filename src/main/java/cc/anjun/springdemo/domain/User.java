package cc.anjun.springdemo.domain;

import lombok.Data;

@Data
public class User {
		private Long id;
		private String name;
		private String password;
		private String email;
}
