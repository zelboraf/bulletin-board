package pl.coderslab.bulletinBoard;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "organisations")
@Data
public class Organisation extends Address {

	private String description;
	@ManyToOne
	private OrganisationType organisationType;

	public Organisation() {}

	public Organisation(String name, String city, String street, String postalCode, String phoneNumber, String organisationName, String description, OrganisationType organisationType) {
		super(name, city, street, postalCode, phoneNumber);
		this.description = description;
		this.organisationType = organisationType;
	}

}
