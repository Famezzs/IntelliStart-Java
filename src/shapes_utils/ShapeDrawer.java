package shapes_utils;

import shapes.Shape;

public class ShapeDrawer {

    public static void drawShape(Shape... shapes) {
        for (Shape shape: shapes) {
            System.out.println(shape.drawShape());
        }
    }
}
