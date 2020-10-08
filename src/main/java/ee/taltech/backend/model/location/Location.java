package ee.taltech.backend.model.location;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private Double lon;
    private Double lat;

}
