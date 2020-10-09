package a_theory.question6.art;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@RequiredArgsConstructor
public class Painting {

    @Id
    @GeneratedValue
    private Long id;
    private String author;
    private String name;
    private LocalDate drawnAt;
    private LocalDate boughtAt;
    private BigDecimal price;

}
