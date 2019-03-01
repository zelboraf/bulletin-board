package pl.coderslab.bulletinBoard;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private Benefactor benefactor;
	@ManyToOne
	private Organisation organisation;
	@OneToMany
	private List<Item> items = new ArrayList<>();
	private int packageCount;

}
