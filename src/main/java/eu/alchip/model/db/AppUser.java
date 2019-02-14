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

    public AppUser(){

    }

    public AppUser(@NonNull String email, int age, String job, String name, String surname, String password, Avatar avatar) {
        this.email = email;
        this.age = age;
        this.job = job;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
