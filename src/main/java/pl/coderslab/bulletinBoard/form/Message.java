package pl.coderslab.bulletinBoard.form;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Getter
@Setter
public class Message extends BaseEntity {

	@Size(min = 2, max = 64)
	private String surname;
	@Size(min = 5, max = 1024)
	private String text;
	private LocalDateTime dateTime;

	public Message() {}

}
