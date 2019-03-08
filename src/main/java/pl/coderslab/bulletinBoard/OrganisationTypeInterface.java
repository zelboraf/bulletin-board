package pl.coderslab.bulletinBoard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrganisationTypeInterface extends JpaRepository<OrganisationType, Long> {

}
