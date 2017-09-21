package cc.anjun.springdemo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cc.anjun.springdemo.domain.Post;
import cc.anjun.springdemo.domain.User;

@Repository
@Transactional
public class UserDao {
		@Autowired
		JdbcTemplate jdbcTemplate;
		
		public void add(User u) {
			String sql = "insert into t_user (name,password,email)values(?,?,?)";
			jdbcTemplate.update(sql,u.getName(),u.getPassword(),u.getEmail());
		}
		public User findById(Long id) {
			String sql = "select * from t_user where id=?";
			User user = jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserMapper());
			return user;
		}

		private class UserMapper implements RowMapper<User> {
		
			@Override
			public User mapRow(ResultSet row, int rowNum) throws SQLException {
				User user = new User();
				user.setId(row.getLong("id"));
				user.setName(row.getString("name"));
				user.setPassword(row.getString("password"));
				user.setEmail(row.getString("email"));
				return user;
			}
		}
		public List<User> findAll() {
			String sql = "select * from t_user";
			List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
			return userList;
		}
		public List<User> findAll2() {
			String sql = "select u.id, u.name, u.age, p.id as p_id, p.title as p_title, p.date as p_date from t_user u left join t_post p on p.user_id = u.id order by u.id asc, p.date desc";
			return jdbcTemplate.query(sql, new UserWithPosts());
		}
		private class UserWithPosts implements ResultSetExtractor<List<User>> {

			@Override
			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				Map<Long, User> userMap = new ConcurrentHashMap<Long, User>();
				User u = null;
				while (rs.next()) {
					// user already in map?
					Long id = rs.getLong("id");
					u = userMap.get(id);

					// if not, add it
					if(u == null) {
						u = new User();
						u.setId(id);
						u.setName(rs.getString("name"));
						u.setAge(rs.getInt("age"));
						userMap.put(id, u);
					}
					
					// create post if there's one
					Long postId = rs.getLong("p_id");
					if (postId > 0) {
						System.out.println("add post id=" + postId);
						Post p = new Post();
						p.setId(postId);
						p.setTitle(rs.getString("p_title"));
						p.setDate(rs.getDate("p_date"));
//						p.setUser(u);
						u.getPosts().add(p);
					}
				}
				
				return new LinkedList<User>(userMap.values());
			}
			
		}
		public void delete(User u) {
			String sql = "delete from t_user where id=?";
			jdbcTemplate.update(sql,u.getId());
		}
		public long countMinorUsers() {
			String sql = "select count(*) from t_user where age < 18";
			return jdbcTemplate.queryForObject(sql, Long.class);
		}
		public void add(List<User> userList) {
			String sql = "insert into t_user (name, age) values (?, ?)";
			
			List<Object[]> userRows = new ArrayList<Object[]>();
			for (User user : userList) {
		        userRows.add(new Object[] {user.getName(), user.getAge()});
			}
			
			jdbcTemplate.batchUpdate(sql, userRows);
		}
		public void performSeveralQueries() {
			User user = new User();
			
			user.setName("test1");
			user.setAge(15);
			this.add(user);
			
			if(true) {
				throw new RuntimeException("A runtime exception");			
			}

			user.setName("test2");
			user.setAge(18);
			this.add(user);

	    }
}
