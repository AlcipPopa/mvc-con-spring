package eu.alchip.model.db;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class AppUser {

    @NonNull
    @Id
    private String email;
    private int age;
    private String job;
    private String name;
    private String surname;
    private String password;

    @OneToMany
    private Set<Avatar> avatar;
}
