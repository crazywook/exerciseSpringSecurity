package test.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/api/v0/user")
public class UserApiController {
	
	@Autowired
	PasswordEncoder passwordEncode;
	
//	@Autowired
//	JdbcTemplate sqlSession;	
	
	UserDetailsManager userMgr;
	
	private void setUserMgr(UserDetailsManager userMgr) {
		this.userMgr = userMgr;
	}
	
	public UserApiController() {
		setUserMgr(new JdbcUserDetailsManager());
	}
	
	Logger logger = Logger.getLogger(getClass());
	
	@PostMapping("")
	public String insertUser(@ModelAttribute("user") @Valid UserDto userDto, BindingResult bResult, WebRequest req, Errors errors) {
		
		logger.debug(userDto.toString());
		
		if(bResult.hasErrors()) {
			return errors.toString();
		}
		
		String encodedPassword = passwordEncode.encode(userDto.getPassword());
		
//		List<GrantedAuthority> authorities = new ArrayList<>();
		Set<GrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("USER"));
		User user = new User(userDto.getEmail(), encodedPassword, authorities);
		logger.debug(user);
		logger.debug("user: "+user.toString());
		
		logger.debug("name: "+user.getUsername());
		logger.debug("password: "+user.getPassword());
		logger.debug("user: "+user.isEnabled());
		
		userMgr.createUser(user);
		
		System.out.println("encoded password: "+encodedPassword);
//		encodedPassword = passwordEncode.encode(user.getPassword());
		
		String responseBody = "{\"password\":\""+encodedPassword+"\"}";
		return responseBody;
	}
	
	private User createUserAccount(UserDto user, BindingResult bReulst) {
		User registerd = null;
		
//		registered = service.
		return registerd;
	}
}
