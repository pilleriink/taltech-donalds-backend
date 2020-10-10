package ee.taltech.backend.model.advertisement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;  //link to img
    private String link;
    private String alt;

    public Advertisement(String imgSrc, String link, String alt) {
        this.image = imgSrc;
        this.link = link;
        this.alt = alt;
    }
}
