package pl.coderslab.bulletinBoard;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
@AllArgsConstructor
@Log
public class OrderController {

	private final ItemInterface itemInterface;
	private final OrganisationInterface organisationInterface;
	private final OrganisationTypeInterface organisationTypeInterface;
	private final OrderInterface orderInterface;
	private final OrderService orderService;

	@GetMapping("/")
	public String getStep(HttpSession session) {
		List<Item> items = itemInterface.findAll();
		session.setAttribute("items", items);
		return "step_1";
	}

	@PostMapping("/step1")
	public String postStep1(HttpSession session, @RequestParam int[] itemArray) {
		List<Item> selectedItems = itemInterface.findAllByIds(itemArray);
		session.setAttribute("selectedItems", selectedItems);
		return "step_2";
	}

	@PostMapping("/step2")
	public String postStep2(HttpSession session, Model model, @RequestParam int numberOfBags) {
		session.setAttribute("numberOfBags", numberOfBags);
		model.addAttribute("cities", organisationInterface.findCities());
		model.addAttribute("organisationTypes", organisationTypeInterface.findAll());
		return "step_3";
	}

	@PostMapping("/step3")
	public String postStep3(HttpSession session, Model model,
	                        @RequestParam(required = false) String city,
	                        @RequestParam(required = false) long[] types,
	                        @RequestParam String name) {
		List<Organisation> organisations = orderService.findOrganisations(city, types, name);
		if (organisations.isEmpty()) {
			organisations.add(new Organisation("Brak wyników wyszukiwania"));
		}
		model.addAttribute("organisations", organisations);
		return "step_4";
	}



	@PostMapping("/step4")
	public String postStep4(HttpSession session, Model model, @RequestParam long selectedOrganisationId) {
		session.setAttribute("organisationId", selectedOrganisationId);
		return "step_5";
	}

	@PostMapping("/step5")
	public String postStep5(HttpSession session, Model model,
	                        @RequestParam String name,
	                        @RequestParam String street,
	                        @RequestParam String city,
	                        @RequestParam String postCode,
	                        @RequestParam String phone,
	                        @RequestParam String pickupDate,
	                        @RequestParam String pickupTime,
	                        @RequestParam String notice) {
		List<Item> selectedItems = (List<Item>) session.getAttribute("selectedItems");
		int numberOfBags = (int) session.getAttribute("numberOfBags");
		long organisationId = ((long) session.getAttribute("organisationId"));
		Organisation organisation = organisationInterface.getOne(organisationId);
		Order order = new Order(name, street, city, postCode, phone,
				LocalDate.parse(pickupDate), LocalTime.parse(pickupTime), notice,
				organisation, numberOfBags, selectedItems);
		session.setAttribute("order", order);
		return "step_6";
	}

	@PostMapping("/step6")
	public String postStep5(HttpSession session, Model model) {
		Order order = (Order) session.getAttribute("order");
		order.setOrderDate(LocalDate.now());
		order.setOrderTime(LocalTime.now());
		orderInterface.save(order);
		return "step_7";
	}

}
