package util2d.score;

import java.util.HashMap;
import util2d.player.GraphicPlayer;
import util2d.minigame.MiniGame;

/**
 *
 * @author Diego
 */
public abstract class ScoreSystem {

    protected HashMap<Integer, Float> scores;
    protected MiniGame miniGame;//ref to the miniGame

    public ScoreSystem(MiniGame miniGame) {
        this.miniGame = miniGame;
        this.resetScores();
    }

    public final void resetScores() {
        if (miniGame.getPlayers() != null) {
            this.scores = new HashMap<>();
            for (GraphicPlayer graphicPlayer : miniGame.getPlayers()) {
                this.scores.put(graphicPlayer.getPlayer().getId(), 0f);
            }
        }
    }

    public void incrementScore(int idPlayer, float score) {
        float lastScore = this.scores.get(idPlayer);
        this.scores.replace(idPlayer, lastScore + score);
    }

    public void decrementScore(int idPlayer, float score) {
        float lastScore = this.scores.get(idPlayer);
        this.scores.replace(idPlayer, lastScore - score);
    }

    public abstract boolean isFinished();

}
