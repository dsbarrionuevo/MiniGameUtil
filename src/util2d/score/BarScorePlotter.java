package util2d.score;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import util2d.graphics.Figure;
import util2d.graphics.FigureShape;
import util2d.graphics.FigureShapeType;

/**
 *
 * @author Barrionuevo Diego
 */
public class BarScorePlotter extends ScorePlotter {

    public static final int PLOTTER_HORIZONTAL = 0;
    public static final int PLOTTER_VERTICAL = 1;

    private int orientation;

    public BarScorePlotter(int orientation, int countPlayers, Vector2f position) {
        super(countPlayers, position);
        this.orientation = orientation;
    }

    public BarScorePlotter(int countPlayers, Vector2f position) {
        this(PLOTTER_HORIZONTAL, countPlayers, position);
    }

    @Override
    protected void createPlotter(int countPlayers) {
        Figure scoreBars = new FigureShape();
        Rectangle rectangleShape;
        for (int i = 0; i < countPlayers; i++) {
            if (this.orientation == PLOTTER_HORIZONTAL) {
                //horizontal
                rectangleShape = new Rectangle(0, i * (10 + 5), 100, 10);
            } else {
                //vertical
                rectangleShape = new Rectangle(i * (10 + 5), 0, 10, 100);
            }
            Color color = ScorePlotter.DEFAULT_COLORS[i];
            FigureShapeType stroke = new FigureShapeType(rectangleShape, Color.white, FigureShapeType.GraphicsType.STROKE, 1);
            FigureShapeType shape = new FigureShapeType(rectangleShape, color, FigureShapeType.GraphicsType.FILL);
            ((FigureShape) scoreBars).addShape(shape);
            ((FigureShape) scoreBars).addShape(stroke);
        }
        scoreBars.setAligmentMode(Figure.ALIGMENT_TOP_LEFT_CORNER);
        setFigure(scoreBars);
    }

}
