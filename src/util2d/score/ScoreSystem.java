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
    //
    protected JDialog scoreChart;

    public ScoreSystem(MiniGame miniGame, ScorePlotter scorePlotter) {
        this.miniGame = miniGame;
        this.scores = new HashMap<>();
        this.resetScores();
        this.plotter = scorePlotter;
        if (this.plotter != null) {
            this.plotter.setScores(this.scores);
        }
    }

    public ScoreSystem(MiniGame miniGame) {
        this(miniGame, null);
    }

    public abstract boolean isFinished();

    public final void resetScores() {
        if (miniGame.getPlayers() != null) {
            this.scores = new HashMap<>();
            for (Player player : miniGame.getPlayers()) {
                this.scores.put(player.getId(), 0f);
                if (this.plotter != null) {
                    this.plotter.updateScore(player.getId(), 0f);
                }
            }
        }
    }

    public void renderScorePlotter(GameContainer container, Graphics g) {
        if (this.plotter != null) {
            this.plotter.render(container, g);
        }
    }

    public void incrementScore(String idPlayer, float score) {
        float lastScore = this.scores.get(idPlayer);
        float newScore = lastScore + score;
        this.scores.replace(idPlayer, newScore);
        if (this.plotter != null) {
            this.plotter.updateScore(idPlayer, newScore);
        }
    }

    public void decrementScore(String idPlayer, float score) {
        float lastScore = this.scores.get(idPlayer);
        float newScore = lastScore - score;
        this.scores.replace(idPlayer, newScore);
        if (this.plotter != null) {
            this.plotter.updateScore(idPlayer, newScore);
        }
    }

    public void setPlotter(ScorePlotter plotter) {
        this.plotter = plotter;
    }

    public HashMap<String, Float> getScores() {
        return scores;
    }

}
