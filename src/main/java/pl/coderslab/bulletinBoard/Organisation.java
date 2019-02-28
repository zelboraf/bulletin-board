package pl.coderslab.bulletinBoard;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Organisation extends Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private OrganisationType organisationType;

}
