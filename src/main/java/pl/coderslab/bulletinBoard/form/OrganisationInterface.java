package pl.coderslab.bulletinBoard.form;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface OrganisationInterface extends JpaRepository<Organisation, Long> {

	@Query(value = "SELECT DISTINCT city FROM organisations ORDER BY city ", nativeQuery = true)
	List<String> findCities();

	@Query(value = "SELECT * FROM organisations WHERE city = ?1 AND organisation_type_id IN ?2 ", nativeQuery = true)
	List<Organisation> findAllByCityAndType(String city, int[] types);

	@Query(value = "SELECT * FROM organisations WHERE name LIKE %?1%", nativeQuery = true)
	List<Organisation> findAllByName(String name);

	@Query(value = "SELECT * FROM organisations WHERE organisation_type_id IN ?1 ", nativeQuery = true)
	List<Organisation> findAllByType(int[] types);

	@Query(value = "SELECT * FROM organisations WHERE city = ?1 ", nativeQuery = true)
	List<Organisation> findAllByCity(String city);

}
