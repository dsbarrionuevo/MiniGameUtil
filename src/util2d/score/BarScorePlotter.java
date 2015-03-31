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
    //
    private int orientation;
    private float topScore;
    private float barMaxLength;//in pixels

    public BarScorePlotter(int orientation, float topScore, HashMap<String, Float> scores, Vector2f position) {
        super(scores, position);
        this.orientation = orientation;
        this.topScore = topScore;
        this.barMaxLength = 100f;
    }

    public BarScorePlotter(float topScore, HashMap<String, Float> scores, Vector2f position) {
        this(PLOTTER_HORIZONTAL, topScore, scores, position);
    }

    @Override
    public void updateScores() {
        Figure scoreBars = new FigureShape();
        Rectangle rectangleShape, rectangleStroke;
        float topScoreNormalized = this.barMaxLength;
        float scoreNormalized;
        int i = 0;
        for (Entry<String, Float> entry : scores.entrySet()) {
            Float score = entry.getValue();
            scoreNormalized = ((score * topScoreNormalized) / topScore);
            if (this.orientation == PLOTTER_HORIZONTAL) {
                //horizontal
                rectangleStroke = new Rectangle(0, i * (10 + 5), topScoreNormalized, 10);
                rectangleShape = new Rectangle(0, i * (10 + 5), scoreNormalized, 10);
            } else {
                //vertical
                rectangleStroke = new Rectangle(i * (10 + 5), 0, 10, topScoreNormalized);
                rectangleShape = new Rectangle(i * (10 + 5), 0, 10, scoreNormalized);
            }
            Color color = ScorePlotter.DEFAULT_COLORS[i];
            FigureShapeType stroke = new FigureShapeType(rectangleStroke, Color.white, FigureShapeType.GraphicsType.STROKE, 1);
            FigureShapeType shape = new FigureShapeType(rectangleShape, color, FigureShapeType.GraphicsType.FILL);
            ((FigureShape) scoreBars).addShape(stroke);
            ((FigureShape) scoreBars).addShape(shape);
        }
        scoreBars.setAligmentMode(Figure.ALIGMENT_TOP_LEFT_CORNER);
        setFigure(scoreBars);
    }

}
