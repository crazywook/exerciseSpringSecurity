package test.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomDaoAuthenticationProvider extends DaoAuthenticationProvider {

	@Autowired
	PasswordEncoder passwordEncoder;	
	
	
}
