package eu.alchip.model.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

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
    private Date creationDate;

    @ManyToOne
    private AppUser appUser;

    @OneToMany
    private List<Image> image;

}
