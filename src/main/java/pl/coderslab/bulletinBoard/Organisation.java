package pl.coderslab.bulletinBoard;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "organisations")
@Data
public class Organisation extends Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private OrganisationType organisationType;

}
