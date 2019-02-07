package eu.alchip.model;

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
class Avatar {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String pixelDimensions;
    private int kbWeight;

    @ManyToOne
    //@JoinColumn(name = "appUser")
    private AppUser appUser;
}
