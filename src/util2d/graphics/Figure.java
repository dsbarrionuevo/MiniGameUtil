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
public abstract class Figure {

    public static final short ALIGMENT_CENTER = 0;
    public static final short ALIGMENT_TOP_LEFT_CORNER = 1;

    protected static final Color DEFAULT_DEBUGDRAW_COLOR = Color.white;
    protected static final short DEFAULT_ALIGMENT_MODE = ALIGMENT_CENTER;

    protected float width, height;
    protected FigureShape debugDraw;//outline and centerpoint
    protected Color debugDrawColor;
    protected boolean showingDebugDraw;
    protected Vector2f parentPosition = new Vector2f();
    protected Vector2f center;
    protected Vector2f topLeftCorner;
    protected int aligmentMode;

    public void render(GameContainer gc, Graphics g) {
        if (debugDraw != null && isShowingDebugDraw()) {
            debugDraw.render(gc, g);
        } else {
            debugDrawColor = DEFAULT_DEBUGDRAW_COLOR;
            ArrayList<FigureShapeType> shapes = new ArrayList<>();
            shapes.add(new FigureShapeType(this.getOutlineRectangle(), debugDrawColor, FigureShapeType.GraphicsType.STROKE));
            shapes.add(new FigureShapeType(this.getCenterPointCircle(), debugDrawColor, FigureShapeType.GraphicsType.FILL));
            debugDraw = new FigureShape(shapes, debugDrawColor);
            debugDraw.setAligmentMode(aligmentMode);
            debugDraw.setShowingDebugDraw(false);
        }
    }

    protected void calculateDimensions() {
    }

    protected final Vector2f getAligmentOffset() {
        switch (aligmentMode) {
            case (ALIGMENT_CENTER):
                return new Vector2f(-center.x, -center.y);
            case (ALIGMENT_TOP_LEFT_CORNER):
            default:
                return new Vector2f(0, 0);
        }
    }

    public void updatePosition(Vector2f parentPosition) {
        this.parentPosition = parentPosition;
        if (debugDraw != null) {
            debugDraw.updatePosition(parentPosition);
        }
    }

    private Rectangle getOutlineRectangle() {
        return new Rectangle(topLeftCorner.x, topLeftCorner.y, width, height);
    }

    private Circle getCenterPointCircle() {
        return new Circle(center.x, center.y, 1);
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Vector2f getCenter() {
        return center;
    }

    public boolean isShowingDebugDraw() {
        return showingDebugDraw;
    }

    public void setShowingDebugDraw(boolean showingDebugDraw) {
        this.showingDebugDraw = showingDebugDraw;
    }

    public Color getDebugDrawColor() {
        return debugDrawColor;
    }

    public void setDebugDrawColor(Color debugDrawColor) {
        this.debugDrawColor = debugDrawColor;
    }

    public int getAligmentMode() {
        return aligmentMode;
    }

    public void setAligmentMode(int aligmentMode) {
        this.aligmentMode = aligmentMode;
        if (debugDraw != null) {
            this.debugDraw.setAligmentMode(aligmentMode);
        }
    }

}
