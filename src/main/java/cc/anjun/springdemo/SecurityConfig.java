package cc.anjun.springdemo;
/*
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		super.configure(http);
		http 
	    .authorizeRequests() 
		    .antMatchers("/admin/**").hasRole("ADMIN") 
		    .anyRequest().authenticated() 
	    .and().formLogin();
		
		http.authorizeRequests().anyRequest().authenticated();
		http.formLogin().loginPage("/user/login").permitAll();
		AntPathRequestMatcher pathRequestMatcher = new AntPathRequestMatcher("/logout");
		http.logout().logoutRequestMatcher(pathRequestMatcher);
		

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web
    	.ignoring()
    		.antMatchers("/css/**")
    		.antMatchers("/js/**")
    		.antMatchers("/img/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER").and().withUser("admin")
				.password("admin").roles("USER", "ADMIN");
//		auth.jdbcAuthentication().dataSource(dataSource)
//				.usersByUsernameQuery("select username,password,enabled from t_user where username=?")
//				.authoritiesByUsernameQuery("select username,authority from authorities where username=?");

	}

}
*/
