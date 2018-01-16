package test;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping("/login.do")
	@ResponseBody
	public String login(HttpServletRequest req) {
		System.out.println("serveltPath: "+req.getServletPath());
		return "success";
	}
	
	@RequestMapping("/main/main")
	@ResponseBody
	public String mainPage(HttpServletRequest req) {
		System.out.println("serveltPath: "+req.getServletPath());
		return "main";
	}
}
