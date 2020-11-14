package a_theory.question6.chocolate;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Cake {

    private Long id;
    @NonNull
    private String size;
    @NonNull
    private String sweetness;
    private List<String> ingredients;
    private List<String> toppings;
}
