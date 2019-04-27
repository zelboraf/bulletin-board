package pl.coderslab.bulletinBoard.orderForm;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	@Column(nullable = false, unique = true)
	@Size(min = 2, max = 64)
	protected String name;

	public BaseEntity(String name) {
		this.name = name;
	}
}

