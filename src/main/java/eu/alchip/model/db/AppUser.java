package eu.alchip.model.db;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

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

    public AppUser(@NonNull String email, int age, String job, String name, String surname, String password, Set<Avatar> avatar) {
        this.email = email;
        this.age = age;
        this.job = job;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.avatar = avatar;
    }
}
