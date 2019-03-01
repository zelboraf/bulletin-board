package pl.coderslab.bulletinBoard;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "benefactors")
@Data
public class Benefactor extends Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime pickupDateTime;
	private String deliveryNotice;

}
