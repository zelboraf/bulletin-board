package pl.coderslab.bulletinBoard;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

@MappedSuperclass
@Data
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	@Size(min = 2, max = 64)
	protected String name;

	protected BaseEntity() {}

	protected BaseEntity(String name) {
		this.name = name;
	}
}
