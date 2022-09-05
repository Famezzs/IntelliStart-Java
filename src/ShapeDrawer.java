public class ShapeDrawer {
    public static void printShapeName(Shape... shapes) {
        for (Shape shape: shapes) {
            shape.printShapeName();
        }
    }

    public static void drawShape(Shape... shapes) {
        for (Shape shape: shapes) {
            shape.drawShape();
        }
    }
}
