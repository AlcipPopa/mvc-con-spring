package eu.alchip.repositories;

import eu.alchip.model.AppUser;

import java.util.List;

public interface UserRepository {
    List<AppUser> findUser(String mail);
}
