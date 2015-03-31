package util2d.score;

import java.util.HashMap;
import java.util.Map.Entry;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Barrionuevo Diego
 */
public class TextScorePlotter extends ScorePlotter{

    public TextScorePlotter(HashMap<String, Float> scores, Vector2f position) {
        super(scores, position);
    }

    @Override
    public void updateScores() {
        //... not necesary
    }
    
    
    @Override
    public void render(GameContainer gc, Graphics g) {
        //super.render(gc, g);  
        int i=0;
        for (Entry<String, Float> entry : scores.entrySet()) {
            Float score = entry.getValue();
            Color color = DEFAULT_COLORS[i];
            g.setColor(color);
            //on top of screen
            g.drawString(score.toString(), 100 * (i+1), 10);
            i++;
        }
    }


}
