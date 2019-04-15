package pl.coderslab.bulletinBoard.security;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class SecurityController {

	private final UserService userService;

	@GetMapping("/admin")
	@ResponseBody
	public String adminMapping() {
		return  "Admin";
	}

	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "admin";
	}

	@GetMapping("/user")
	@ResponseBody
	public String user() {
		return "user";
	}

}
