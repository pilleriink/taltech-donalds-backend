package b_theory.question11;

public class Nr3isL {

    //todo this is a contribution based question so make sure to keep commits separate
    //todo A What does L stand for in SOLID? Explain the principle.
    /*
    L stands for Liskov substitution principle.
    It means every subclass should be able to substitute their parent class.
     */
    //todo B Give an example. Write actual or pseudo code.
    public static class Rectangle {
    }
    public static class ColoredRectangle extends Rectangle {
        String color;
    }
    /*
    This is an example of LSP because the ColoredRectangle could perfectly substituted
    its parent (the Rectangle class). An example of a LSP violation might be:
    */
    public static class Square extends Rectangle {

    }
    /*
    This violates LSP because in some cases Square couldn't substitute Rectangle
     such as when we want to give a Rectangle instance different width and height.
    */

}
