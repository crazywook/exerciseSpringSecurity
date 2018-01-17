package test.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import test.modifier.CustomHttpServletRequestWrapper;

public class OriginalHeader implements Filter {	
	
	Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {		
		
		HttpServletRequest httpReq = (HttpServletRequest)req;
		String servletPath = httpReq.getServletPath();
		
//		if(ignoreFilter(servletPath)) {
		if(req == null) {			
//			req.getRequestDispatcher(httpReq.getServletPath()).forward(req, res);			
		}else {
			logger.info("servletPath: "+servletPath);
			HttpSession session = httpReq.getSession();		
			
			String[] initPath = new String[]{"/login", "/", "index", "/jsp/basic/index.jsp"};
			List<String> initPathList = Arrays.asList(initPath);
			if(initPathList.contains(servletPath)) {
				session.setAttribute("redirectUrl", "/main");
			}else {
				session.setAttribute("redirectUrl", servletPath);
			}
			logger.info("redirectUrl: "+session.getAttribute("redirectUrl"));
			String lowerHeaderToken = (String)httpReq.getHeader("x-csrf-token");
			String upperHeaderToken = (String)httpReq.getHeader("X-CSRF-TOKEN");
			CustomHttpServletRequestWrapper reqWrapper = new CustomHttpServletRequestWrapper(httpReq);
			if(lowerHeaderToken != null) {
				reqWrapper.addHeader("X-CSRF-TOKEN", upperHeaderToken);
				System.out.println("lower: "+lowerHeaderToken);
				System.out.println("upper: "+upperHeaderToken);
			} else {
				System.out.println("token is null");
			}

			chain.doFilter(reqWrapper, res);
		}
	}

	public boolean ignoreFilter(String servletPath) {
		
		String[] pathSplit = servletPath.split("\\.");
		if(pathSplit.length == 2 && pathSplit[1].length() >= 2) {
			return true;
		}else return false; 		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
