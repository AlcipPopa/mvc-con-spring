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
    private String username;
    private Integer age;
    private String job;
    private String name;
    private String surname;
    private boolean active;

    private String password;

    @OneToOne
    private Avatar avatar;

    public AppUser(){


    }

    public AppUser(@NonNull String username, int age, String job, String name, String surname, String password, Avatar avatar, boolean active) {
        this.username = username;
        this.age = age;
        this.job = job;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.avatar = avatar;
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
