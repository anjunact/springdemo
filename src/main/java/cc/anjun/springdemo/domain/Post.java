package cc.anjun.springdemo.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Post {
	private long id;
	private String title;
	private Date date;
	private User user;
}
