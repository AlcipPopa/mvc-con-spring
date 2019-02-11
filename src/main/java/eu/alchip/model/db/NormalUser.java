package eu.alchip.model.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class NormalUser extends AppUser {
    private String badgeNormale;

    public NormalUser(String badgeNormale) {
        super();
        this.badgeNormale = badgeNormale;
    }
}
