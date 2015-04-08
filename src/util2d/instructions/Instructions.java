package util2d.instructions;

import controller.ApplicationController;
import controller.SimpleApplicationController;
import controller.AbstractSyncExecutor;
import controller.SimpleSynchronizer;
import javax.swing.JDialog;
import synchronizer.Synchronizer;
import util2d.minigame.MiniGame;

/**
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class Instructions {

    private MiniGame miniGame;
    private ApplicationController appController;
    private JDialog instructionsUI;
    private Synchronizer sync;

    public Instructions(MiniGame miniGame, JDialog instructionsUI) {
        this.miniGame = miniGame;
        this.appController = miniGame.getController();
        this.instructionsUI = instructionsUI;
    }

    public void showInstructions() {
        
        new Thread() {
            @Override
            public void run() {
                instructionsUI.setVisible(true);
            }
        }.start();
        
        sync = new SimpleSynchronizer((SimpleApplicationController) appController, new AbstractSyncExecutor() {
            @Override
            public void execute() {
                instructionsUI.setVisible(false);
                miniGame.start();
            }
        });
        sync.start();
    }

    public void sendToken() {
        sync.sendToken();
    }

}
