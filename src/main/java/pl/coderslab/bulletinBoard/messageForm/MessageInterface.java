package pl.coderslab.bulletinBoard.messageForm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageInterface extends JpaRepository<Message, Long> {

}
