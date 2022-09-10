package shapes_utils;

import shapes.Shape;

public class ShapePrinter {

    public static void printShapes(Shape... shapes) {
        for (Shape shape: shapes) {
            System.out.println(shape.getShapeName());
        }
    }
}
