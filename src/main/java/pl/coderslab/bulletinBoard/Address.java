package pl.coderslab.bulletinBoard;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@MappedSuperclass
@Getter
@Setter
public abstract class Address extends BaseEntity {

	@Size(min = 2, max = 32)
	protected String city;
	@Size(min = 2, max = 64)
	protected String street;
	@Pattern(regexp = "\\d{2}-\\d{3}", message = "Niepoprawny format")
	protected String postCode;
//	@Digits(integer = 9, fraction = 0, message = "Niepoprawny format")
	protected String phone;

	protected Address() {}

	public Address(String name, String city, String street, String postCode, String phone) {
		super(name);
		this.city = city;
		this.street = street;
		this.postCode = postCode;
		this.phone = phone;
	}

}
