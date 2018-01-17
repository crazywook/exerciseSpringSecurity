package test.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/user")
public class UserApiController {
	
	@Autowired
	PasswordEncoder passwordEncode;
	
	@RequestMapping("")
	public String insertUser(UserDto user) {
		
		String encodedPassword = passwordEncode.encode("1234");
		
		System.out.println("encoded password: "+encodedPassword);
//		encodedPassword = passwordEncode.encode(user.getPassword());
		
		String responseBody = "{\"password\":\""+encodedPassword+"\"}";
		return responseBody;
	}
}
