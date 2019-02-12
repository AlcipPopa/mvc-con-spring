package eu.alchip.model.db;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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
    //@ManyToOne
    private Set<Avatar> avatar;
    //private Avatar avatar;

}
