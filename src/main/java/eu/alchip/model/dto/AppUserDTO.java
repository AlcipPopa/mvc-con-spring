package eu.alchip.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class AppUserDTO {
    private String email;
    private int age;
    private String job;
    private String name;
    private String surname;
    private String password;
    
//    private Set<Avatar> avatar;
    
}
