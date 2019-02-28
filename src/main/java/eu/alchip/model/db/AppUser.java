package eu.alchip.model.db;

import lombok.*;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

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


    public AppUser() {
    }

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
