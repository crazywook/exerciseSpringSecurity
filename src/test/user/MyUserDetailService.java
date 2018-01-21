package test.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities = getAuthorities(username);
		String password = "1234";
		User user = new User(username, password, authorities);
		return user;
	}

	private List<GrantedAuthority> getAuthorities(String username) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		List<String> perms = new ArrayList<>();
		for(String str : perms) {
			authorities.add(new SimpleGrantedAuthority(str));
		}
		return authorities;
	}
	
}
