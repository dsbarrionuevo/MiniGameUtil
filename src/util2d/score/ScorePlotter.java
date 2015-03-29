package util2d.score;

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

    public ScorePlotter(int countPlayers, Vector2f position) {
        super(position);
        this.createPlotter(countPlayers);
    }
    
    protected abstract void createPlotter(int countPlayers);

    @Override
    public void render(GameContainer gc, Graphics g) {
        super.render(gc, g);
    }
}
