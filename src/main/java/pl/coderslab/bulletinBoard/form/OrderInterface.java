package pl.coderslab.bulletinBoard.form;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderInterface extends JpaRepository<Order, Long> {

}
