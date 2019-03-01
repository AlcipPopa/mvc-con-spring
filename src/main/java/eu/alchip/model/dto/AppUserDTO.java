package eu.alchip.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import eu.alchip.model.db.Avatar;
import eu.alchip.session.AppUserI;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Component
public class AppUserDTO implements AppUserI {
    @JsonProperty("username")
    private String username;
    @JsonProperty("age")
    private int age;
    @JsonProperty("job")
    private String job;
    @JsonProperty("user_name")
    private String name;
    @JsonProperty("user_surname")
    private String surname;
    @JsonProperty("active")
    private boolean active;

    @JsonIgnore
    private String password;
    
    private Set<Avatar> avatar;

    public AppUserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    public Set<Avatar> getAvatar() {
        return avatar;
    }

    public void setAvatar(Set<Avatar> avatar) {
        this.avatar = avatar;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
