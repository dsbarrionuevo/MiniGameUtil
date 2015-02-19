package test;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.SlickException;
import util2d.minigame.Instructions;
import util2d.minigame.MiniGame;
import util2d.network.NetworkController;
import util2d.minigame.Options;
import util2d.player.Player;
import util2d.score.TimedGame;

/**
 *
 * @author Diego
 */
public class Test {

    public static final int SCREEN_WIDTH = 800, SCREEN_HEIGHT = 600;

    private static MiniGame miniGame;

    public static void main(String[] args) {
        try {
            ArrayList<Player> players = new ArrayList<>();
            for (int i = 1; i <= 4; i++) {
                players.add(new Player("Player " + i, i));
            }
            Options options = new Options(SCREEN_WIDTH, SCREEN_HEIGHT);
            miniGame = new MiniGameTest(players, options, NetworkController.getInstance());
            miniGame.start();
        } catch (SlickException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static class MiniGameTest extends MiniGame {

        public MiniGameTest(ArrayList<Player> players, Options options, NetworkController networkController) throws SlickException {
            super("MiniGame 1");
            this.setGraphicPlayers(players);
            this.options = options;
            this.networkController = networkController;
            this.instructions = new Instructions("MiniGame 1 Instructions", "You have to...");
            this.scoreSystem = new TimedGame(this, 2000);
        }

    }

}
