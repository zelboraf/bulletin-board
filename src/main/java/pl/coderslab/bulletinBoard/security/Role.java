package pl.coderslab.bulletinBoard.security;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.bulletinBoard.form.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role extends BaseEntity {

}