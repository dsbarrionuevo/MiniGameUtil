package util2d.score;

import java.util.HashMap;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import common.Player;
import util2d.minigame.MiniGame;
import javax.swing.JDialog;

/**
 *
 * @author Diego
 */
public abstract class ScoreSystem {

    protected HashMap<String, Float> scores;
    protected MiniGame miniGame;//ref to the miniGame
    protected ScorePlotter plotter;
    protected JDialog scoreChart;

    public ScoreSystem(MiniGame miniGame) {
        this.miniGame = miniGame;
        this.resetScores();
        this.plotter = new BarScorePlotter(scores, new Vector2f(10, 10));
    }

    public final void resetScores() {
        if (miniGame.getPlayers() != null) {
            this.scores = new HashMap<>();
            for (Player player : miniGame.getPlayers()) {
                this.scores.put(player.getId(), 0f);
                this.plotter.updateScore(player.getId(), 0f);
            }
        }
    }

    public void renderScorePlotter(GameContainer container, Graphics g) {
        this.plotter.render(container, g);
    }

    public void incrementScore(String idPlayer, float score) {
        float lastScore = this.scores.get(idPlayer);
        this.scores.replace(idPlayer, lastScore + score);
        this.plotter.updateScore(idPlayer, score);
    }

    public void decrementScore(String idPlayer, float score) {
        float lastScore = this.scores.get(idPlayer);
        this.scores.replace(idPlayer, lastScore - score);
        this.plotter.updateScore(idPlayer, score);
    }

    public abstract boolean isFinished();

}
