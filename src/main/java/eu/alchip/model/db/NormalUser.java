package eu.alchip.model.db;


import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.Entity;

@ToString
@Data
@Entity
public class NormalUser extends AppUser {
    private String authority;

    public NormalUser(){

    }

    public NormalUser(@NonNull String username, int age, String job, String name, String surname, String password, Avatar avatar, boolean active) {
        super(username, age, job, name, surname, password, avatar, active);
        this.authority = "ROLE_NORMAL";
    }
}
