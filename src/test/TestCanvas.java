package test;

import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.CanvasGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Diego
 */
public class TestCanvas extends BasicGame {
    
    public static void main(String[] argv) {
        try {
            CanvasGameContainer container = new CanvasGameContainer(new TestCanvas());

            JFrame frame = new JFrame("Test");
            frame.setLayout(new GridLayout(1, 2));
            frame.setSize(800, 600);
            frame.add(container);

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    frame.dispose();
                    System.exit(0);
                }
            });
            frame.setVisible(true);
            container.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TestCanvas() {
        super("Test Canvas");
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        
    }

    @Override
    public void render(GameContainer container, org.newdawn.slick.Graphics g) throws SlickException {
        
    }
}
