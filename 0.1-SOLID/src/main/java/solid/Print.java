package solid;

public class Print {

    public static void printShape(Shape shape) {
        System.out.println("Shape: " + shape.getClass().getSimpleName());
    }

    public static void printArea(Shape shape) {
        System.out.printf("Area: %.3f\n", shape.area());
    }
}
