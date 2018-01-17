package test.user;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.stereotype.*;
import org.springframework.ui.*;

@Controller
public class UserController {
	
	@RequestMapping("/signup")
	public String singupPage(WebRequest req, Model model) {
		
		return "/register.jsp";
	}
}
