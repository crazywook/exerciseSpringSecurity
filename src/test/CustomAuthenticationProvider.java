package test;

import java.util.Collections;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomAuthenticationProvider  {

//	@Override
//	public Authentication authenticate(Authentication auth) throws AuthenticationException {
//		String username = auth.getName();
//        String password = auth.getCredentials()
//            .toString();
// 
//        if ("kim".equals(username) && "pass".equals(password)) {
//            return new UsernamePasswordAuthenticationToken
//              (username, password, Collections.emptyList());
//        } else {
//            throw new
//              BadCredentialsException("External system authentication failed");
//        }
//	}
//
//	@Override
//	public boolean supports(Class<?> auth) {
//		// TODO Auto-generated method stub
//		return auth.equals(UsernamePasswordAuthenticationFilter.class);
//	}
	
}
