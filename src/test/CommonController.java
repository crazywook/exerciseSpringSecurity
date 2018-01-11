package test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController {

	@RequestMapping({".do", "test.do"})
	@ResponseBody
	public String httpsTest(HttpServletRequest req) {
		System.out.println("serveltPath: "+req.getServletPath());
		return "success";
	}

	@RequestMapping("/login.do")
	@ResponseBody
	public String login(HttpServletRequest req) {
		System.out.println("serveltPath: "+req.getServletPath());
		return "success";
	}
}
