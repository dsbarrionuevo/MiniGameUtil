package util2d.score;

import util2d.minigame.MiniGame;

/**
 *
 * @author Diego
 */
public class ScoredGame extends ScoreSystem {

    private float targetScore;

    public ScoredGame(MiniGame miniGame, float targetScore) {
        super(miniGame);
        this.targetScore = targetScore;
    }

    @Override
    public boolean isFinished() {
        for (Float score : scores.values()) {
            if (score >= targetScore) {
                return true;
            }
        }
        return false;
    }

}
