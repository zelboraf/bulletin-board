package pl.coderslab.bulletinBoard.security;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.bulletinBoard.form.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity//(name = "users")
@Table(name = "admins")
@Getter
@Setter
public class User extends BaseEntity {

    private String password;
    private int enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}