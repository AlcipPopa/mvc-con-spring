package eu.alchip.model.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class Post {

    @Id
    private int id;
    private String title;
    private String body;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date creationDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @ManyToOne
    private AppUser appUser;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Image> image;
}
