package test.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonApiController {
	
	@RequestMapping("/test")	
	public String postTest(String j_username) {
		System.out.println("j_username: "+j_username);
		return j_username;
	}
}
