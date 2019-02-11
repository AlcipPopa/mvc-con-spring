package eu.alchip.repositories;

<<<<<<< Updated upstream
=======
import eu.alchip.model.db.AppUser;
>>>>>>> Stashed changes
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, String> {
}
