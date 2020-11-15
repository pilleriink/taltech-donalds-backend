package b_theory.question11;

public class Nr2isO {

    //todo this is a contribution based question so make sure to keep commits separate
    //todo A What does O stand for in SOLID? Explain the principle.
    // O stands for Open-Closed Principle (OCP) and it states that software entities (classes, modules, methods, etc.)
    // should be open for extension, but closed for modification.

    //todo B Give an example. Write actual or pseudo code.

    public interface Shape{
        public double calculateArea();
    }

    public class Rectangle implements Shape{
        double length;
        double width;
        public double calculateArea(){
            return length * width;
        }
    }

    public class Circle implements Shape{
        double radius;
        public double calculateArea(){
            return Math.PI*radius*radius;
        }
    }

    public class AreaCalculator {
        public double calculateShapeArea(Shape shape) {
            return shape.calculateArea();
        }
    }
    //todo If we want to add more shapes, we don't have to modify the existing code and can just add methods that calculate
    // the new areas by adding new classes, eg Triangle that implements the shape interface
}

