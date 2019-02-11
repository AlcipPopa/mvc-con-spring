package eu.alchip.model.db;

import eu.alchip.model.db.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class AdminUser extends AppUser {
    private String badgeAdmin;
}
