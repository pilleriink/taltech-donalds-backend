package a_theory.question4;

import ee.taltech.backend.model.product.Product;

import javax.persistence.*;

public class DependencyInjection {

    //todo
    // One of the reasons we use Spring is that it gives us good support for
    // Dependency Injection (DI) and Inversion of Control (IoC)

    //todo p1
    // In your words (do not use wiki definitions)
    // What is Dependency Injection?
    // Answer:
    // It is providing the objects that an object needs (its dependencies) instead of it having to construct them itself

    //todo p2
    // Bring example from your code of Dependency Injection.
    // Paste your code here, but comment it out

    //@Entity
    //public class Comment {

    //    @Id
    //    @GeneratedValue(strategy = GenerationType.IDENTITY)    private Long id;
    //    private String comment;
    //    @ManyToOne
    //    private Product product;
    //
    //    public Comment(Long id, String comment, Product product) {
    //        this.id = id;
    //        this.comment = comment;
    //        this.product = product;
    //    }
    //}

    //todo p3
    // Name 2 benefits of Dependency Injection
    // 1 Makes testing easier
    // 2 Can change dependencies without having to change the class that uses it

    //todo p4
    // Name 1 disadvantage of Dependency Injection
    // 1 Increased number of classes
}
