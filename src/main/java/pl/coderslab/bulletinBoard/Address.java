package pl.coderslab.bulletinBoard;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

public abstract class Address {

	private String name;
	private String city;
	private String street;
	private String postalCode;
	private String phoneNumber;

}
