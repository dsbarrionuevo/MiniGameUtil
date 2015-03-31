package util2d.score;

import java.util.HashMap;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import util2d.graphics.Drawable;

/**
 *
 * @author Diego
 */
public abstract class ScorePlotter extends Drawable {

    protected static Color[] DEFAULT_COLORS = new Color[]{Color.red, Color.green, Color.blue, Color.yellow};
    //
    protected HashMap<String, Float> scores;

    public ScorePlotter(HashMap<String, Float> scores, Vector2f position) {
        super(position);
        this.scores = scores;
        this.createPlotter();
    }

    public abstract void updateScores();

    protected void createPlotter() {
        this.updateScores();
    }

    protected void updateScore(String idPlayer, float score) {
        this.scores.replace(idPlayer, score);
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        super.render(gc, g);
    }
}
