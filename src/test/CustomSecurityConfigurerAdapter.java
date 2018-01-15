package test;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.apache.log4j.Logger;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import test.filter.OriginalHeader;

@Configuration
@EnableWebSecurity
public class CustomSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter implements WebMvcConfigurer{

	public static Logger logger = Logger.getLogger(CustomSecurityConfigurerAdapter.class);	
	
//	@Autowired
//    private MyBasicAuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser("user1").password("user1Pass")
          .authorities("ROLE_USER");
    }
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		logger.info("http: "+http);
		
		http.httpBasic(); //.authenticationEntryPoint(authenticationEntryPoint);
		http.addFilterBefore(new OriginalHeader(), ChannelProcessingFilter.class);
//		http.authorizeRequests().antMatchers("/**").permitAll();
		http.authorizeRequests().antMatchers("/main/**").hasRole("USER");
		
		http.formLogin().loginPage("/login")
			.usernameParameter("username").passwordParameter("password")
//			.successHandler(new CustomAuthenticationSuccessHandler())
			.failureHandler(new CustomAuthenticationFailureHandler())
			.permitAll()
			.and()
			.logout().logoutUrl("/logout");
			
			
		
//		RequestMatcher reqMatcher = null;		
//		http.csrf().requireCsrfProtectionMatcher(reqMatcher);

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
