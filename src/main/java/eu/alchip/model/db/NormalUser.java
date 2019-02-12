package eu.alchip.model.db;

import lombok.*;

import java.util.Set;

@ToString
@Data
//@Entity
public class NormalUser extends AppUser {
    private String badgeNormale;

    public NormalUser(@NonNull String email, int age, String job, String name, String surname, String password, Set<Avatar> avatar, String badgeNormale) {
        super(email, age, job, name, surname, password, avatar);
        this.badgeNormale = badgeNormale;
    }
}
