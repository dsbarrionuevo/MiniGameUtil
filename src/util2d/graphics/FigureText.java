package util2d.graphics;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Barrionuevo Diego
 */
public class FigureText extends Figure {

    private static final Color DEFAULT_COLOR = Color.white;

    private Color textColor;
    private String text;

    public FigureText(String text, Color textColor) {
        this.text = text;
        this.textColor = textColor;
        this.calculateDimensions();
    }

    public FigureText(String text) {
        this(text, DEFAULT_COLOR);
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        Vector2f newPosition, aligmentOffset = getAligmentOffset();
        newPosition = new Vector2f(
                parentPosition.x + aligmentOffset.x,
                parentPosition.y + aligmentOffset.y);
        g.drawString(text, newPosition.x, newPosition.y);
        super.render(gc, g);
    }

    @Override
    protected void calculateDimensions() {
        super.calculateDimensions();
        this.width = 1;
        this.height = 1;
        this.topLeftCorner = new Vector2f(0, 0);
        this.center = new Vector2f(width / 2, height / 2);
    }

}
