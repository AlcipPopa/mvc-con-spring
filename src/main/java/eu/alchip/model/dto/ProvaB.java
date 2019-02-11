package eu.alchip.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class ProvaB {
    @Id
    private int id;
    private String attributo1;
    private String attributo2;

    //@ManyToMany
    //private Set<ProvaA> elencoA;
    //@OneToOne
    //private ProvaA provaA;
}
