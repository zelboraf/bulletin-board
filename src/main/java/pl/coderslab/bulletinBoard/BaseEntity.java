package pl.coderslab.bulletinBoard;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	protected String name;

	protected BaseEntity() {}

	protected BaseEntity(String name) {
		this.name = name;
	}
}
