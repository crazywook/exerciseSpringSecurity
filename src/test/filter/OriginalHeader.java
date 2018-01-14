package test.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import test.modifier.CustomHttpServletRequestWrapper;
import test.util.MyToString;

public class OriginalHeader implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest)req;
		
//		MyToString.showEnumeration(httpReq.getHeaderNames());
		
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
