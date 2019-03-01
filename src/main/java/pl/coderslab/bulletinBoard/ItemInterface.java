package pl.coderslab.bulletinBoard;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemInterface extends JpaRepository<Item, Long> {

}
