package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.servlet.DispatcherServlet;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	public CustomAuthenticationFailureHandler() {
		this.setDefaultFailureUrl("/login?error");
	}
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
//		String password = request.getAttribute("password").toString();
//		logger.info("password: " + password);
//		logger.info("encoded: " + passwordEncoder.encode(password));
		
		logger.info("login failed123.. {}");
		response.setStatus(401);
		PrintWriter out = response.getWriter();		
		out.write("login fail");
//		super.onAuthenticationFailure(request, response, exception);
		
	}
}
