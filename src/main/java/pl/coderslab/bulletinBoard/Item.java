package pl.coderslab.bulletinBoard;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "items")
@Getter
@Setter
public class Item extends BaseEntity {

}
