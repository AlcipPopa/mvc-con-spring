package eu.alchip.model.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class Avatar {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String pixelDimensions;
    private int kbWeight;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date creationDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lastUsedDate;
}
