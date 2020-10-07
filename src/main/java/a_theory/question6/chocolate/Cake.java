package a_theory.question6.chocolate;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
public class Cake {

    public enum SizeType {BIG, SMALL}
    public enum SweetnessType {MEDIUM, SWEET}

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private SizeType size;
    @NonNull
    private SweetnessType sweetness;
    private String name;
    private List<String> ingredients;
    private List<String> toppings;
}
