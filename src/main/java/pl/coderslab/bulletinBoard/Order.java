package pl.coderslab.bulletinBoard;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends Address {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate orderDate;
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime orderTime;
	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate pickupDate;
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime pickupTime;
	private String notice;
	@ManyToOne
	private Organisation organisation;
	private int numberOfBags;
	@ManyToMany
	private List<Item> items = new ArrayList<>();

	public Order() {}

}
