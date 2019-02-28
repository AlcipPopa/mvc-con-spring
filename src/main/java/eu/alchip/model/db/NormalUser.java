package eu.alchip.model.db;

import lombok.*;

import javax.persistence.Entity;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@EqualsAndHashCode
public class NormalUser extends AppUser {
    private String badgeNormale;

}
