package test;

import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import test.filter.OriginalHeader;

@EnableWebSecurity
public class CustomSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{

	public static Logger logger = Logger.getLogger(CustomSecurityConfigurerAdapter.class);
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		logger.info("http: "+http);
		
		http.httpBasic();
//		http.addFilterAfter(new OriginalHeader(), BasicAuthenticationFilter.class);
//		http.authorizeRequests().antMatchers("/**").permitAll();
		http.authorizeRequests().antMatchers("/main/**").hasRole("ADMIN");
		
		http.formLogin().loginPage("/login")
			.failureHandler(new CustomAuthenticationFailureHandler());	
		

//		http //auto-config="true"
//        .authorizeRequests()
//            .anyRequest().authenticated()
//            .and()
//        .formLogin()
//            .and()
//        .httpBasic();

//		http
//	    .portMapper()
//	        .http(80).mapsTo(8443);

		http.requiresChannel()
			.antMatchers("/login.do")
			.requiresSecure();

//			.antMatchers("/users/{userId}")
//			.access("@authenticationCheckHandler.checkUserId(authentication, #userId)")

	}

}
