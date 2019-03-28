package pl.coderslab.bulletinBoard;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends Address {

	private LocalDate orderDate;
	private LocalTime orderTime;
	private LocalDate pickupDate;
	private LocalTime pickupTime;
	private String notice;
	@ManyToOne
	private Organisation organisation;
	private int numberOfBags;
	@ManyToMany
	private List<Item> items = new ArrayList<>();

	public Order() {}

	public Order(String name, String city, String street, String postCode, String phone,
	             LocalDate pickupDate, LocalTime pickupTime, String notice,
	             Organisation organisation, int numberOfBags, List<Item> items) {
		super(name, city, street, postCode, phone);
		this.pickupDate = pickupDate;
		this.pickupTime = pickupTime;
		this.notice = notice;
		this.organisation = organisation;
		this.numberOfBags = numberOfBags;
		this.items = items;
	}


}
