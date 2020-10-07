package a_theory.question6.chocolate;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class Chocolate {

    // Each person has to do only 1. So 2 person team has to do 2 different ones, 3 person - 3, 4 person - 4.
    // Make sure to commit under your user otherwise points won't count.
    // I didn't number these so you can pick your favorite

    // It compiles and runs. You need to use proper annotations, methods, etc, however to ease the process you can use empty methods (examples below).
    // Follow the story to have only the necessary methods in it

    // Welcome-welcome!
    // My name is Lukas and I am very happy to meet you.
    // Thank you for coming to Vienna, Austria.
    // Vienna is the best place for coffee. And my cafe, Chocolate, is the best cafe for cakes.
    // You should try my Sachertorte, oh-ah, es isst so gut.
    // No-no, stop thinking we have no time for cake, now we must make an IT system.
    // I tell and you make.

    // I need a system to review my cakes. I have many cakes. I need a system.
    private HashMap<Cake, Double> cakes = new HashMap<>();

    // Every cake must have following properties. Size: big/small. Sweetness: medium/sweet. These are mandatory as there must be ordnung.
    public Cake createNewCake(Cake.SweetnessType sweetnessType, Cake.SizeType sizeType){ return new Cake(sizeType, sweetnessType); }

    // In addition I want to search by ingredients and toppings, these are not necessary.
    public void searchByIngredients(List<String> ingredients) {}
    public void searchByToppings(List<String> toppings) {}

    // I strive for perfection.
    // Every day I bake a new cake. I must add it to the cakes. Sell it to my loyal customers.
    public void addNewCake(Cake cake, Double price) {cakes.put(cake, price);}

    // I also make my cakes better. I am an artist and I improve my recipes.
    // I take existing Sachertorte and I make it better and next week I make it better and next week...
    // Can you do this? I need this system tomorrow!
    public void cakeAddNewIngredients(Cake cake, List<String> ingredients) {}
    public void cakeAddNewToppings(Cake cake, List<String> toppings) {}
    public void cakeRemoveIngredients(Cake cake, List<String> ingredients) {}
    public void cakeRemoveToppings(Cake cake, List<String> toppings) {}


}
