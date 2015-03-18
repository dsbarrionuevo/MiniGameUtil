package util2d.score;

import static javafx.scene.input.KeyCode.F;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import util2d.graphics.Drawable;
import util2d.graphics.Figure;
import util2d.graphics.FigureShape;
import util2d.graphics.FigureShapeType;

/**
 *
 * @author Diego
 */
public class ScorePlotter extends Drawable {

    private static Color[] DEFAULT_COLORS = new Color[]{Color.red, Color.green, Color.blue, Color.yellow};

    public ScorePlotter(int countBars, Vector2f position) {
        super(position);
        Figure scoreBars = new FigureShape();
        Rectangle rectangleShape;
        for (int i = 0; i < countBars; i++) {
            //horizontal
            rectangleShape = new Rectangle(0, i * (10 + 5), 100, 10);
            //vertical
            //rectangleShape = new Rectangle(i * (10 + 5), 0, 10, 100);
            Color color = DEFAULT_COLORS[i];
            FigureShapeType stroke = new FigureShapeType(rectangleShape, Color.white, FigureShapeType.GraphicsType.STROKE, 1);
            FigureShapeType shape = new FigureShapeType(rectangleShape, color, FigureShapeType.GraphicsType.FILL);
            //((FigureShape)scoreBars).addShape(rectangle, DEFAULT_COLORS[i]);
            ((FigureShape)scoreBars).addShape(shape);
            ((FigureShape)scoreBars).addShape(stroke);
        }
        scoreBars.setAligmentMode(Figure.ALIGMENT_TOP_LEFT_CORNER);
        setFigure(scoreBars);
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        super.render(gc, g);
    }
}
