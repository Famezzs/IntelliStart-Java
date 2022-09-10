import shapes.Circle;
import shapes.Square;
import shapes.Star;
import shapes_utils.ShapeDrawer;
import shapes_utils.ShapePrinter;

public class Main {
    public static void main(String[] args) {
        ShapePrinter.printShapes(new Circle(), new Square(), new Star());
        ShapeDrawer.drawShape(new Circle(), new Square(), new Star());
    }
}
