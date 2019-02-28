package eu.alchip.model.db;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.Objects;

@ToString
@Data
@Entity
@EqualsAndHashCode
public class NormalUser extends AppUser {
    private String badgeNormale;

    public NormalUser(@NonNull String email, int age, String job, String name, String surname, String password, Avatar avatar, String badgeNormale) {
        super(email, age, job, name, surname, password, avatar);
        this.badgeNormale = badgeNormale;
    }
}
