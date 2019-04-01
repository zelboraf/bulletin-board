package pl.coderslab.bulletinBoard;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
	public String getRoot() {
		return "redirect:/step1";
	}

	@GetMapping("/step1")
	public String getStep1(Model model) {
		model.addAttribute("items", itemInterface.findAll());
		return "step_1";
	}
	@PostMapping("/step1")
	public String postStep1(HttpSession session,
	                        @RequestParam(required = false) int[] selectedItemIds) {
		if (selectedItemIds == null) {
			session.setAttribute("errorMessage", "Wybierz co najmniej jedną kategorię");
			return "redirect:/step1";
		}
		session.setAttribute("selectedItemIds", selectedItemIds);
		session.removeAttribute("errorMessage");
		return "redirect:/step2";
	}

	@GetMapping("/step2")
	public String getStep2(HttpSession session) {
		Integer numberOfBags = (Integer) session.getAttribute("numberOfBags");
		if (numberOfBags == null) {
			session.setAttribute("numberOfBags", 1);
		}
		return "step_2";
	}
	@PostMapping("/step2")
	public String postStep2(HttpSession session,
	                        @RequestParam(required = false) int numberOfBags,
                            @RequestParam(required = false) String prev) {
		if (prev != null) {
			return "redirect:/step1";
		}
		if (numberOfBags <= 0) {
			session.setAttribute("errorMessage", "Wprowadź liczbę worków - co najmniej 1");
			return "redirect:/step2";
		}
		session.setAttribute("numberOfBags", numberOfBags);
		return "redirect:/step3";
	}

	@GetMapping("/step3")
	public String getStep3(Model model) {
		model.addAttribute("cities", organisationInterface.findCities());
		model.addAttribute("types", organisationTypeInterface.findAll());
		return "step_3";
	}
	@PostMapping("/step3")
	public String postStep3(HttpSession session,
	                        @RequestParam String selectedCity,
	                        @RequestParam(required = false) int[] selectedTypeIds,
	                        @RequestParam(required = false) String selectedName,
	                        @RequestParam(required = false) String prev) {
		if (prev != null) {
			return "redirect:/step2";
		}
		List<Organisation> organisations = orderService.findOrganisations(selectedCity, selectedTypeIds, selectedName);
		if (!selectedCity.equals("")) {
			session.setAttribute("selectedCity", selectedCity);
		}
		if (selectedTypeIds != null) {
			session.setAttribute("selectedTypeIds", selectedTypeIds);
		}
		if (organisations.isEmpty()) {
			session.setAttribute("errorMessage", "Brak wyników wyszukiwania");
			return "redirect:/step3";
		}
		session.setAttribute("organisations", organisations);
		session.removeAttribute("errorMessage");
		return "redirect:/step4";
	}

	@GetMapping("/step4")
	public String getStep4() {
		return "step_4";
	}
	@PostMapping("/step4")
	public String postStep4(HttpSession session,
	                        @RequestParam(required = false) Long organisationId,
	                        @RequestParam(required = false) String prev) {
		if (prev != null) {
			return "redirect:/step3";
		}
		if (organisationId == null) {
			session.setAttribute("errorMessage", "Wybierz jedną organizację");
			return "redirect:/step4";
		}
		session.setAttribute("selectedOrganisationId", organisationId);
		session.removeAttribute("errorMessage");
		return "redirect:/step5";
	}

	@GetMapping("/step5")
	public String getStep5(Model model) {
		model.addAttribute("order", new Order());
		return "step_5";
	}
	@PostMapping("/step5")
	public String postStep5(HttpSession session,
	                        @Valid @ModelAttribute Order order, BindingResult result,
	                        @RequestParam(required = false) String prev) {
		if (prev != null) {
			return "redirect:/step4";
		}
		if (result.hasErrors()) {
			return "step_5";
		}
		order.setItems(itemInterface.findAllByIds((int[]) session.getAttribute("selectedItemIds")));
		order.setNumberOfBags((int) session.getAttribute("numberOfBags"));
		order.setOrganisation(organisationInterface.getOne((Long) session.getAttribute("selectedOrganisationId")));
		session.setAttribute("order", order);
		session.removeAttribute("errorMessage");
		return "redirect:/step6";
	}

	@GetMapping("/step6")
	public String getStep6() {
		return "step_6";
	}
	@PostMapping("/step6")
	public String postStep6(HttpSession session,
	                        @RequestParam(required = false) String prev) {
		if (prev != null) {
			return "redirect:/step5";
		}
		Order order = (Order) session.getAttribute("order");
		order.setOrderDate(LocalDate.now());
		order.setOrderTime(LocalTime.now());
		orderInterface.save(order);
		return "step_7";
	}

}
