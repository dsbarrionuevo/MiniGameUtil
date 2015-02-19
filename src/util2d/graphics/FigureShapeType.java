package util2d.graphics;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Diego
 */
public class FigureShapeType {

    public static final Color DEFAULT_COLOR = Color.white;
    public static final float DEFAULT_LINE_WIDTH = 1f;
    public static final GraphicsType DEFAULT_GRAPHICS_TYPE = GraphicsType.FILL;

    public static enum GraphicsType {

        FILL,
        STROKE
    };

    private Shape shape;
    private Color color;
    private GraphicsType graphicsType;
    private Vector2f relativePosition;
    private float lineWidth;

    public FigureShapeType(Shape shape, Color color, GraphicsType graphicsType, float lineWidth) {
        this.shape = shape;
        this.color = color;
        this.graphicsType = graphicsType;
        this.lineWidth = lineWidth;
        this.relativePosition = new Vector2f(shape.getX(), shape.getY());
    }

    public FigureShapeType(Shape shape, Color color, GraphicsType graphicsType) {
        this(shape, color, graphicsType, DEFAULT_LINE_WIDTH);
    }

    public FigureShapeType(Shape shape, Color color) {
        this(shape, color, DEFAULT_GRAPHICS_TYPE, DEFAULT_LINE_WIDTH);
    }

    public FigureShapeType(Shape shape) {
        this(shape, DEFAULT_COLOR, DEFAULT_GRAPHICS_TYPE, DEFAULT_LINE_WIDTH);
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public GraphicsType getGraphicsType() {
        return graphicsType;
    }

    public void setGraphicsType(GraphicsType graphicsType) {
        this.graphicsType = graphicsType;
    }

    public float getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    public Vector2f getRelativePosition() {
        return relativePosition;
    }

    public void setRelativePosition(Vector2f relativePosition) {
        this.relativePosition = relativePosition;
    }

}
