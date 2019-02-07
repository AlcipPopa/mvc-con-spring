package eu.alchip.repositories;

import eu.alchip.model.db.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    List<AppUser> findUser(String mail);
}
