package util2d.graphics;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Diego
 */
public class FigureImage extends Figure {

    private Image image;

    public FigureImage(String imageURL) {
        try {
            this.image = new Image(imageURL);
            this.calculateDimensions();
        } catch (SlickException ex) {
            Logger.getLogger(FigureImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FigureImage(Image image) {
        this.image = image;
        this.calculateDimensions();
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        Vector2f newPosition, aligmentOffset = getAligmentOffset();
        newPosition = new Vector2f(
                parentPosition.x + aligmentOffset.x,
                parentPosition.y + aligmentOffset.y);
        g.drawImage(image, newPosition.x, newPosition.y);
        super.render(gc, g);
    }

    @Override
    protected void calculateDimensions() {
        super.calculateDimensions();
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
        this.topLeftCorner = new Vector2f(0, 0);
        this.center = new Vector2f(width / 2, height / 2);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}
