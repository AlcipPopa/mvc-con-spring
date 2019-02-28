package eu.alchip.model.db;

import eu.alchip.model.db.AppUser;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@EqualsAndHashCode
public class AdminUser extends AppUser {
    private String badgeAdmin;


}
