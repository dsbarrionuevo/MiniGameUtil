package util2d.graphics;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Diego
 */
public abstract class Drawable {

    public static final Vector2f DEFAULT_POSITION = new Vector2f(0, 0);

    protected Vector2f position;
    protected boolean visible;
    protected Figure figure;

    public Drawable(Figure figure, Vector2f position, boolean visible) {
        this.figure = figure;
        this.position = position;
        this.visible = visible;
    }

    public Drawable(Figure figure, Vector2f position) {
        this(figure, position, true);
    }

    public Drawable(Vector2f position) {
        this(new FigureShape(), position, true);
    }

    public Drawable() {
        this(DEFAULT_POSITION);
    }

    public void render(GameContainer gc, Graphics g) {
        if (isVisible()) {
            figure.updatePosition(position);
            figure.render(gc, g);
        }
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public Vector2f getPosition() {
        return position;
    }

    public float getPositionX() {
        return position.x;
    }

    public float getPositionY() {
        return position.y;
    }

    public void setPosition(Vector2f position) {
        this.position = position;
    }

    public void setPosition(float x, float y) {
        this.position.x = x;
        this.position.y = y;
    }

    public void setPositionX(float x) {
        this.position.x = x;
    }

    public void setPositionY(float y) {
        this.position.y = y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
