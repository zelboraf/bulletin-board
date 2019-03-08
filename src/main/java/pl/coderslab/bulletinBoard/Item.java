package pl.coderslab.bulletinBoard;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "items")
@Data
public class Item extends BaseEntity {

}
