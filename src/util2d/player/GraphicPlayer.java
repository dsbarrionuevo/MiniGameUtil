package util2d.player;

import util2d.graphics.Movable;
import common.Player;

/**
 *
 * @author Diego
 */
public abstract class GraphicPlayer extends Movable {

    private final Player player;

    public GraphicPlayer(Player player) {
        super();
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

}
