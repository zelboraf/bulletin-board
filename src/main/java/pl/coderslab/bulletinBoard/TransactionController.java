package pl.coderslab.bulletinBoard;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransactionController {

	@GetMapping("/")
	public String step1() {
		return "step_1";
	}

	@PostMapping("/step_1")
	public String step2(Session session) {
		session.get()

		return "step_2";
	}

}
