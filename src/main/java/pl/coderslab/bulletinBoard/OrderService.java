package pl.coderslab.bulletinBoard;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
@AllArgsConstructor
public class OrderService {

	private final OrganisationInterface organisationInterface;

	public List<Organisation> findOrganisations(String city, long[] types, String name) {
		List<Organisation> organisations = new ArrayList<>();
		if (city != null && types != null) {
			organisations.addAll(organisationInterface.findAllByCityAndType(city, types));
		} else if (city != null) {
			organisations.addAll(organisationInterface.findAllByCity(city));
		} else {
			organisations.addAll(organisationInterface.findAllByType(types));
		}
		if (!name.equals("")) {           // empty textarea returns "" instead of null
			organisations.addAll(organisationInterface.findAllByName(name));
		}
		return organisations;
	}

}
