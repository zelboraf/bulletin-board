package pl.coderslab.bulletinBoard.security;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.bulletinBoard.orderForm.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role extends BaseEntity {

}