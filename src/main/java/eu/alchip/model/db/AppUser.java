package eu.alchip.model.db;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Table(indexes = {@Index(name = "indice_pass", columnList = "password", unique = true)})
public class AppUser {

    @NonNull
    @Id
    private String email;
    private Integer age;
    private String job;
    private String name;
    private String surname;


    private String password;

    @OneToOne
    private Avatar avatar;

    public AppUser(@NonNull String email, int age, String job, String name, String surname, String password, Avatar avatar) {
        this.email = email;
        this.age = age;
        this.job = job;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.avatar = avatar;
    }
}
