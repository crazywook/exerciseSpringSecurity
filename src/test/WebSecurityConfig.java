package test;

import org.apache.log4j.Logger;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	public static Logger logger = Logger.getLogger(WebSecurityConfig.class);

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		logger.info("http: "+http);

		http.authorizeRequests().antMatchers("/main/**").hasRole("User");

		http.httpBasic().and().authorizeRequests()
			.antMatchers("/login")
			.anonymous();

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
