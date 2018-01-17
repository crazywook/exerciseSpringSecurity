package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		
		response.setStatus(201);
		String referer = request.getHeader("referer");
		System.out.println("referer: "+referer);
		Object attr = session.getAttribute("redirectUrl");		
		String redirectUrl = attr == null ? "/main" : (String)attr;
		PrintWriter out = response.getWriter();		
		out.write("{\"redirectUrl\":"+"\""+redirectUrl+"\"}");		
		out.close();		
		
	}
}
