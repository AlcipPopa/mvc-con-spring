package eu.alchip.repositories;

import eu.alchip.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findUser(String mail);
}
