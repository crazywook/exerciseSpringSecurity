package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.servlet.DispatcherServlet;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	public CustomAuthenticationFailureHandler() {
		this.setDefaultFailureUrl("/login?error");
	}
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		logger.info("login failed... {}");
		super.onAuthenticationFailure(request, response, exception);
		RequestDispatcher dispatcher =  request.getRequestDispatcher("/login");
		dispatcher.forward(request, response);
	}
}
