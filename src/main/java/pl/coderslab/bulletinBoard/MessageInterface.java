package pl.coderslab.bulletinBoard;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageInterface extends JpaRepository<Message, Long> {

}
