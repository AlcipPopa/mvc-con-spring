package eu.alchip.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class User {

    @NonNull
    @Id
    private String email;
    private int age;
    private String job;
    private String name;
    private String surname;
    private String password;


}
