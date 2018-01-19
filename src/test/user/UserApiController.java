package test.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/api/v0/user")
public class UserApiController {
	
	@Autowired
	PasswordEncoder passwordEncode;
	
	@PostMapping("")
	public String insertUser(@ModelAttribute("usr") @Valid UserDto user, BindingResult bResult, WebRequest req, Errors errors) {
		
		String encodedPassword = passwordEncode.encode("1234");
		
		System.out.println("encoded password: "+encodedPassword);
//		encodedPassword = passwordEncode.encode(user.getPassword());
		
		String responseBody = "{\"password\":\""+encodedPassword+"\"}";
		return responseBody;
	}
	
	private User createUserAccount(UserDto user, BindingResult bReulst) {
		User registerd = null;
		UserDetailsService
		
//		registered = service.
		return registerd;
	}
}
