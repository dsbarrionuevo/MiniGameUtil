package util2d.graphics;

import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Diego
 */
public class FigureShape extends Figure {

    public static final Shape DEFAULT_SHAPE = new Circle(0, 0, 5);

    private ArrayList<FigureShapeType> shapes;
    private Color lastColorAdded;

    private void commonContructor(ArrayList<FigureShapeType> shapes) {
        this.shapes = shapes;
        this.aligmentMode = DEFAULT_ALIGMENT_MODE;
        this.calculateDimensions();
    }

    public FigureShape(ArrayList<FigureShapeType> shapes) {
        this.commonContructor(shapes);
    }

    public FigureShape(ArrayList<FigureShapeType> shapes, Color color) {
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).setColor(color);
        }
        this.commonContructor(shapes);
    }

    public FigureShape(Shape shape, Color color) {
        ArrayList<FigureShapeType> shapes = new ArrayList<>();
        shapes.add(new FigureShapeType(shape, color));
        this.commonContructor(shapes);
    }

    public FigureShape(Shape shape) {
        ArrayList<FigureShapeType> shapes = new ArrayList<>();
        shapes.add(new FigureShapeType(shape));
        this.commonContructor(shapes);
    }

    public FigureShape() {
        this.commonContructor(new ArrayList<>());
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        float currentLineWidth = g.getLineWidth();
        for (int i = 0; i < shapes.size(); i++) {
            FigureShapeType figureShapeType = shapes.get(i);
            g.setColor(figureShapeType.getColor());
            if (figureShapeType.getLineWidth() != g.getLineWidth()) {
                currentLineWidth = g.getLineWidth();
                g.setLineWidth(figureShapeType.getLineWidth());
            }
            Shape shape = figureShapeType.getShape();
            Vector2f newPosition, aligmentOffset = getAligmentOffset();
            newPosition = new Vector2f(
                    parentPosition.x + figureShapeType.getRelativePosition().x + aligmentOffset.x,
                    parentPosition.y + figureShapeType.getRelativePosition().y + aligmentOffset.y);
            shape.setLocation(newPosition);
            if (figureShapeType.getGraphicsType() == FigureShapeType.GraphicsType.FILL) {
                g.fill(figureShapeType.getShape());
            } else if (figureShapeType.getGraphicsType() == FigureShapeType.GraphicsType.STROKE) {
                g.draw(figureShapeType.getShape());
            }
            g.setLineWidth(currentLineWidth);
        }
        //al ultimo dibujo el contorno
        super.render(gc, g);
    }

//    public void centerShape() {
//        for (int i = 0; i < shapes.size(); i++) {
//            FigureShapeType figureShapeType = shapes.get(i);
//            Vector2f newPosition = new Vector2f();
//            newPosition.x = figureShapeType.getRelativePosition().x - center.x;
//            newPosition.y = figureShapeType.getRelativePosition().y - center.y;
//            figureShapeType.setRelativePosition(newPosition);
//        }
//    }
    @Override
    protected void calculateDimensions() {
        super.calculateDimensions();
        float minX = 0, minY = 0, maxWidth = 0, maxHeight = 0;
        for (FigureShapeType figureShapeType : shapes) {
            Shape shape = figureShapeType.getShape();
            if (shape.getWidth() + Math.abs(shape.getX()) > maxWidth) {
                maxWidth = shape.getWidth() + Math.abs(shape.getX());
            }
            if (shape.getHeight() + Math.abs(shape.getY()) > maxHeight) {
                maxHeight = shape.getHeight() + Math.abs(shape.getY());
            }
            if (shape.getX() < minX) {
                minX = shape.getX();
            }
            if (shape.getY() < minY) {
                minY = shape.getY();
            }
        }
        this.width = maxWidth;
        this.height = maxHeight;
        this.topLeftCorner = new Vector2f(minX, minY);
        this.center = new Vector2f(width / 2, height / 2);
    }

    public void addShape(FigureShapeType figureShapeType) {
        this.shapes.add(figureShapeType);
        this.calculateDimensions();
    }

    public void addShape(Shape shape, Color color) {
        this.shapes.add(new FigureShapeType(shape, color));
        this.lastColorAdded = color;
        this.calculateDimensions();
    }

    public void addShape(Shape shape) {
        if (lastColorAdded == null) {
            lastColorAdded = FigureShapeType.DEFAULT_COLOR;
        }
        this.addShape(shape, lastColorAdded);
    }

    public ArrayList<FigureShapeType> getShapes() {
        return shapes;
    }

    public void setShapes(ArrayList<FigureShapeType> shapes) {
        this.shapes = shapes;
    }

}
