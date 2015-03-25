package util2d.score;

import util2d.minigame.MiniGame;
import common.Player;

/**
 *
 * @author Diego
 */
public class ScoredGame extends ScoreSystem {

    private float targetScore;
    private Player winner;

    public ScoredGame(MiniGame miniGame, float targetScore) {
        super(miniGame);
        this.targetScore = targetScore;
    }

    @Override
    public boolean isFinished() {
        for (Float score : scores.values()) {
            if (score >= targetScore) {
                //set the winner
                return true;
            }
        }
        return false;
    }

}
