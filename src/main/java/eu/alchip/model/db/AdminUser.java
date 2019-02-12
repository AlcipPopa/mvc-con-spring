package eu.alchip.model.db;

import lombok.*;

import java.util.Set;

@ToString
@Data
//@Entity
public class AdminUser extends AppUser {
    private String badgeAdmin;

    public AdminUser(@NonNull String email, int age, String job, String name, String surname, String password, Set<Avatar> avatar, String badgeAdmin) {
        super(email, age, job, name, surname, password, avatar);
        this.badgeAdmin = badgeAdmin;
    }
}
