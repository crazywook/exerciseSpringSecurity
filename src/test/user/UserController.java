package test.user;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.*;
import org.springframework.ui.*;

@Controller
public class UserController {
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String singupPage(WebRequest req, Model model) {
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "/member/signup.jsp";
	}	
}
