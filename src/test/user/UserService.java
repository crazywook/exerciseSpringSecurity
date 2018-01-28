package test.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

public class UserService {
	
	private UserDetailsManager userDetailsManager;
	
	public void createUser(User user) {		
		
		List<? extends GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("USER"));
		UserDetails userDetails = new User(user.getName(), user.getPassword(), authorities);
		userDetailsManager.createUser(userDetails);
		JdbcUserDetailsManager jm;
		JdbcDaoImpl dao;
	}
	
	public void loadUser(User user) {
		
		
	}
}
