package pl.coderslab.bulletinBoard.form;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemInterface extends JpaRepository<Item, Long> {

	@Query(value = "SELECT * FROM items WHERE id IN ?1 ", nativeQuery = true)
	List<Item> findAllByIds(int[] itemArray);

}
