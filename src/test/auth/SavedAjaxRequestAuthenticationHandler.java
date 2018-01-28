package test.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

import test.util.UrlCalc;

public class SavedAjaxRequestAuthenticationHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	
	RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	private RequestCache requestCache = new HttpSessionRequestCache();
	protected final Logger logger = Logger.getLogger(getClass());
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		logger.debug("onAuthenticationSuccess: "+request.getServletPath());
		String targetUrl = "";		
		SavedRequest savedRequest = requestCache.getRequest(request, response);		
		
		if(savedRequest == null) {
			targetUrl = determineTargetUrl(request, response);
		}else {
			String targetUrlParameter = getTargetUrlParameter();
			if (isAlwaysUseDefaultTargetUrl()
					|| (targetUrlParameter != null 
						&& StringUtils.hasText(request.getParameter(targetUrlParameter)))
			) {
				requestCache.removeRequest(request, response);
				targetUrl = determineTargetUrl(request, response);
			}
		}
		
		String redirectUrl = UrlCalc.calculateRedirectUrl(request.getContextPath(), targetUrl);
		logger.debug("redirectUrl: "+redirectUrl);
		PrintWriter out = response.getWriter();
		out.write("{\"redirectUrl\":"+"\""+redirectUrl+"\"}");		
		out.close();		
	}
	
	
}
