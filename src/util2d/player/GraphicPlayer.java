package util2d.player;

import util2d.graphics.Movable;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Diego
 */
public class GraphicPlayer extends Movable {

    private Player player;

    public GraphicPlayer(Player player) {
        super();
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

}
