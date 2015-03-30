package util2d.score;

import java.util.HashMap;
import java.util.Map.Entry;
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

    public BarScorePlotter(int orientation, HashMap<String, Float> scores, Vector2f position) {
        super(scores, position);
        this.orientation = orientation;
    }

    public BarScorePlotter(HashMap<String, Float> scores, Vector2f position) {
        this(PLOTTER_HORIZONTAL, scores, position);
    }
    
    @Override
    public void updateScores() {
        Figure scoreBars = new FigureShape();
        Rectangle rectangleShape;
        int i = 0;
        for (Entry<String, Float> entry : scores.entrySet()) {
            Float score = entry.getValue();
            if (this.orientation == PLOTTER_HORIZONTAL) {
                //horizontal
                rectangleShape = new Rectangle(0, i * (10 + 5), score, 10);
            } else {
                //vertical
                rectangleShape = new Rectangle(i * (10 + 5), 0, 10, score);
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
