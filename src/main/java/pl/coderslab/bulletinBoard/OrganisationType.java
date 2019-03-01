package pl.coderslab.bulletinBoard;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "organisation_types")
@Data
public class OrganisationType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;

}
