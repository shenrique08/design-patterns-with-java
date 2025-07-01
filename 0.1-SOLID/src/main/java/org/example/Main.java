package org.example;

import solid.Print;
import solid.Rectangle;
import solid.Square;


public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        Print.printShape(rectangle);
        Print.printArea(rectangle);

        Square square = new Square(2.0);
        Print.printShape(square);
        Print.printArea(square);
    }
}