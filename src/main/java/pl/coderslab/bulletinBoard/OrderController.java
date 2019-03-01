package pl.coderslab.bulletinBoard;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
public class OrderController {

	private final ItemInterface itemInterface;

	public OrderController(ItemInterface itemInterface) {
		this.itemInterface = itemInterface;
	}

	@GetMapping("/")
	public String getStep(HttpSession session, Model model) {
		List<Item> items = itemInterface.findAll();
		model.addAttribute("items", items);
		session.setAttribute("step", 1);
		return "step_1";
	}

	@GetMapping("/step1")
	public String postStep(@RequestAttribute("czekboksy") int[] czekboksy) {
		log.debug(czekboksy.toString());
		return "step_2";
	}

}
