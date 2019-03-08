package pl.coderslab.bulletinBoard;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)

@Log
public class OrderController {

	private final ItemInterface itemInterface;
	private final OrganisationInterface organisationInterface;
	private final OrganisationTypeInterface organisationTypeInterface;
	private final OrderInterface orderInterface;

	@GetMapping("/")
	public String getStep(HttpSession session) {
		List<Item> items = itemInterface.findAll();
		session.setAttribute("items", items);
		return "step_1";
	}

	@PostMapping("/step1")
	public String postStep1(HttpSession session, @RequestParam int[] itemArray) {
//		List<Item> items = (List<Item>) session.getAttribute("items");
		List<Item> selectedItems = itemInterface.findById(itemArray);
//		for (int i = 0; i < itemArray.length; i++) {
//			selectedItems.add(items.get(itemArray[i] - 1));
//		}
		session.setAttribute("items", selectedItems);
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
	                        @RequestParam(required = false) String selectedCity,
	                        @RequestParam(required = false) long[] selectedOrganisationTypes,
	                        @RequestParam String organisationName) {

		List<Organisation> organisations = new ArrayList<>();
		if (selectedCity != null && selectedOrganisationTypes != null) {
			organisations.addAll(organisationInterface.findAllByCityAndType(selectedCity, selectedOrganisationTypes));
		} else if (selectedCity == null) {
			organisations.addAll(organisationInterface.findAllByType(selectedOrganisationTypes));
		} else {
			organisations.addAll(organisationInterface.findAllByCity(selectedCity));
		}
		if (!organisationName.equals("")) {           // empty textarea returns "" instead of null
			organisations.addAll(organisationInterface.findAllByName(organisationName));
		}
		if (organisations.isEmpty()) {
			return "step_4_no_results";
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
		List<Item> items = (List<Item>) session.getAttribute("items");
		int numberOfBags = (int) session.getAttribute("numberOfBags");
		long organisationId = ((long) session.getAttribute("organisationId"));
		Organisation organisation = organisationInterface.getOne(organisationId);
		Order order = new Order(name, street, city, postCode, phone,
				LocalDate.parse(pickupDate), LocalTime.parse(pickupTime), notice,
				organisation, numberOfBags, items);
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
