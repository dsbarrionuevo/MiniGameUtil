package test;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import util2d.graphics.Figure;
import util2d.graphics.FigureImage;
import util2d.graphics.Movable;
import util2d.util.Direction;

/**
 *
 * @author Diego
 */
public class TestUsingFigures extends BasicGame {

    private Player player;

    public TestUsingFigures() throws SlickException {
        super("Using figures...");
        AppGameContainer container = new AppGameContainer(this);
        container.setDisplayMode(800, 600, false);
        container.setShowFPS(false);
        container.start();
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        player = new Player();
        Figure playerFigure = new FigureImage("res/mario.png");
        playerFigure.setShowingDebugDraw(true);
        playerFigure.setAligmentMode(Figure.ALIGMENT_CENTER);
        player.setFigure(playerFigure);
        player.setPosition(new Vector2f(400f,300f));
        player.setSpeed(5f);
        //player.setDirection(Direction.DIRECTION_EAST);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        player.update(container, delta);
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        player.render(container, g);
    }

    class Player extends Movable {


    }

    public static void main(String[] args) {
        try {
            new TestUsingFigures();
        } catch (SlickException ex) {
            Logger.getLogger(TestUsingFigures.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
