package pl.coderslab.bulletinBoard;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class Address extends BaseEntity {

	protected String city;
	protected String street;
	protected String postCode;
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
