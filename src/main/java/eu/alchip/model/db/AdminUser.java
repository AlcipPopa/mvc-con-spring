package eu.alchip.model.db;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import javax.persistence.Entity;

@ToString
@Data
@Entity
@EqualsAndHashCode
public class AdminUser extends AppUser {
    private String badgeAdmin;


    public AdminUser(@NonNull String email, int age, String job, String name, String surname, String password, Avatar avatar, String badgeAdmin) {
        super(email, age, job, name, surname, password, avatar);
        this.badgeAdmin = badgeAdmin;
    }
}
