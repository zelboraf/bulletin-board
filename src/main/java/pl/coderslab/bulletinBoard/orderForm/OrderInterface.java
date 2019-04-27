package pl.coderslab.bulletinBoard.orderForm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderInterface extends JpaRepository<Order, Long> {

}
