package shapes;

public abstract class Shape {

    protected String shapeName;

    protected final static String drawingComment = "Drawing ";

    public String getShapeName() {
        return shapeName;
    }

    public String drawShape() {
        return drawingComment + shapeName;
    }
}
