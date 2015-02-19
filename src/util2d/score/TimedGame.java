package util2d.score;

import java.util.ArrayList;
import util2d.minigame.MiniGame;

/**
 *
 * @author Diego
 */
public class TimedGame extends ScoreSystem {

    private long finishTime;

    public TimedGame(MiniGame miniGame, long finishTime) {
        super(miniGame);
        this.finishTime = finishTime;
    }

    @Override
    public boolean isFinished() {
        return (miniGame.getCurrentTime() >= this.finishTime);
    }

}
