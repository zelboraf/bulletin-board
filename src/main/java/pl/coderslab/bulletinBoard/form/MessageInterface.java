package pl.coderslab.bulletinBoard.form;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageInterface extends JpaRepository<Message, Long> {

}
