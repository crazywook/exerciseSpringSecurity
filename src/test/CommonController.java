package test;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.annotation.ConfigureProperties;

@Controller("commonController")
public class CommonController {
	
	Logger logger = Logger.getLogger(getClass());
	
	@PostConstruct
	public void init() {
		BasicConfigurator.configure();
	}
	
	@RequestMapping({".do", "test.do"})
	@ResponseBody
	public String httpsTest(HttpServletRequest req) {
		logger.info(req.getRealPath("/"));
		System.out.println("serveltPath: "+req.getServletPath());
		return "success";
	}

	@RequestMapping("/jspTest")
	public String test(HttpServletRequest req) {
		System.out.println("serveltPath: "+req.getServletPath());
		
		return "redirect:jspTest.jsp";
	}
	
	@RequestMapping("/jspTest2")
	public String test2(HttpServletRequest req) {
		System.out.println("serveltPath: "+req.getServletPath());
		
		return "/test/jspTest.jsp";
	}
	
	@RequestMapping("/main/main")
	@ResponseBody
	public String mainPage(HttpServletRequest req) {
		System.out.println("serveltPath: "+req.getServletPath());
		return "main";
	}
	
	@RequestMapping("/annoTest")
	@ResponseBody
	@ConfigureProperties(properties="properties/oauth/oAuth.properties")
	public String annotationTest(HttpServletRequest req) {
		System.out.println("serveltPath: "+req.getServletPath());
		return "main";
	}
	
	@RequestMapping("/oAuth")
	@ResponseBody
	@ConfigureProperties(properties="properties/oauth/oAuth.properties")
	public String annotationTest(OAuth2Authentication auth) {
		
		OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)auth.getDetails();
		return "main";
	}
	
}
