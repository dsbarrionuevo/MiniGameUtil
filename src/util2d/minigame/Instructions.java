package util2d.minigame;

import util2d.graphics.FigureShape;
import util2d.graphics.Drawable;
import test.Test;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author Diego
 */
public class Instructions extends Drawable {

    //it can include seccions...
    private String title, content;

    public Instructions(String title, String content) {
        this.title = title;
        this.content = content;
        defaultRendering();
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        super.render(gc, g);
        g.setColor(Color.black);
        g.drawString(title, Test.SCREEN_WIDTH / 2 - 100, 140);
        g.drawString(content, Test.SCREEN_WIDTH / 2 - 100, 200);
    }

    private void defaultRendering() {
        figure = new FigureShape();
        ((FigureShape) figure).addShape(new Rectangle(0, 0, 400, 350), Color.yellow);
        ((FigureShape) figure).addShape(new Rectangle(5, 5, 390, 340), Color.white);
        position.x = Test.SCREEN_WIDTH / 2;
        position.y = Test.SCREEN_HEIGHT / 2;
    }

}
