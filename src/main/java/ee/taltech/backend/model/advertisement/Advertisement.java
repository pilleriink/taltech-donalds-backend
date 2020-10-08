package ee.taltech.backend.model.advertisement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.awt.*;

@Getter
@Setter
@NoArgsConstructor
public  class Advertisement {
    @Id
    @GeneratedValue
    private Long id;
    private Image img; // todo probably should change the type
    private String link;
    private String alt;
}
