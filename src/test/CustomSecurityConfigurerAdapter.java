package test;

import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.apache.log4j.Logger;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import test.filter.OriginalHeader;

@Configuration
@EnableWebSecurity
public class CustomSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	public static Logger logger = Logger.getLogger(CustomSecurityConfigurerAdapter.class);	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	DataSource dataSource;
	
//	@Autowired
//  private MyBasicAuthenticationEntryPoint authenticationEntryPoint;
	
	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();		
		String password = passwordEncoder.encode("1234");
		logger.info("password: "+password);
		
		String selectUserQuery = "select id, password, enabled from user where id = ?";
		String selectRolesQuery = "select id, roles from user_roles where id = ?";
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(selectUserQuery).authoritiesByUsernameQuery(selectRolesQuery);		
		
//        auth.inMemoryAuthentication()
//          .withUser("user").password(password)
//          .authorities("ROLE_USER");
    }
	
//	@SuppressWarnings("deprecation")
//	@Bean
//	public static NoOpPasswordEncoder passwordEncoder() {
//	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/jsp/**/*.js");
		super.configure(web);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		logger.info("http: "+http);
		
		http.httpBasic(); //.authenticationEntryPoint(authenticationEntryPoint);
		http.addFilterBefore(new OriginalHeader(), ChannelProcessingFilter.class);
//		http.authorizeRequests().antMatchers("/**").permitAll();
		
		http.authorizeRequests().antMatchers("/css/**").permitAll()
			.antMatchers("/img/**").permitAll();
//			.antMatchers("/js/**").permitAll()
//			.antMatchers("/jsp/**/*.js").permitAll();
		
		http.authorizeRequests().antMatchers("/main/**").hasRole("USER");
		
		http.formLogin().loginPage("/login")
			.usernameParameter("username").passwordParameter("password")			
			.successHandler(new CustomAuthenticationSuccessHandler())
			.failureHandler(new CustomAuthenticationFailureHandler())
			.permitAll()
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));		
		
//		http.authenticationProvider(DaoAuth)
		
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
