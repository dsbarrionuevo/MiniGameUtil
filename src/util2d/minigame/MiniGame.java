package util2d.minigame;

import common.ActionCommunication;
import controller.ApplicationController;
import util2d.score.ScoreSystem;
import java.util.ArrayList;
import javax.swing.JDialog;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import common.Player;
import javax.swing.JFrame;

/**
 *
 * @author Diego
 */
public abstract class MiniGame extends BasicGameState {

    public static enum GameState {

        NOT_EVEN_STARTED,
        INSTRUCTIONS_SCREEN,
        RUNNING,
        //PAUSED,//only for running state
        SCORE_SCREEN
    }

    protected int id;
    protected String name;
    protected GameState gameState;
    protected ApplicationController controller;
    protected ArrayList<Player> players;
    protected JDialog instructions;
    protected GameContainer gameContainer;
    protected ScoreSystem scoreSystem; //this one decides when the game is over (score reached, time limit, etc.)
    protected long currentTime;
    protected ActionCommunication actionCommunication;
    protected JFrame gameWindow;

    public MiniGame(ApplicationController controller) throws SlickException {
        super();
        this.controller = controller;
        this.players = controller.getPlayers();
        this.name = getName();
        this.instructions = getInstructions();
        this.scoreSystem = getScoreSystem();
        this.currentTime = 0;
        this.gameState = GameState.NOT_EVEN_STARTED;
        this.actionCommunication = controller.getCommunication();
        this.gameWindow = controller.getGameWindow();
    }

    public void finish() {
        this.gameState = GameState.SCORE_SCREEN;
    }

    public void start() {
        this.gameState = GameState.RUNNING;
    }

    public boolean isPaused() {
        return gameContainer.isPaused();
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        this.gameContainer = container;
        this.gameState = GameState.INSTRUCTIONS_SCREEN;
    }

    @Override
    public abstract void init(GameContainer container, StateBasedGame game) throws SlickException;

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        switch (gameState) {
            case NOT_EVEN_STARTED:
                break;
            case INSTRUCTIONS_SCREEN:
                updateInstructions(container, game, delta);
                break;
            case RUNNING:
                if (gameContainer.isPaused()) {
                    return;
                }
                //finish the game?
                if (this.scoreSystem.isFinished()) {
                    finish();
                } else {
                    updateRunning(container, game, delta);
                }
                //time update
                this.currentTime += delta;
                break;
            case SCORE_SCREEN:
                updateScore(container, game, delta);
                break;
        }
    }

    public void updateInstructions(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    }

    public abstract void updateRunning(GameContainer container, StateBasedGame game, int delta) throws SlickException;

    public void updateScore(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        switch (gameState) {
            case NOT_EVEN_STARTED:
                break;
            case INSTRUCTIONS_SCREEN:
                renderInstructions(container, game, g);
                break;
            case RUNNING:
                renderRunning(container, game, g);
                break;
            case SCORE_SCREEN:
                renderScore(container, game, g);
                break;
        }
    }

    public void renderInstructions(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
    }

    public abstract void renderRunning(GameContainer container, StateBasedGame game, Graphics g) throws SlickException;

    public void renderScore(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
    }

    @Override
    public void keyPressed(int key, char c) {
        //pause action only available when the game is running...
        if (gameState == GameState.RUNNING) {
            switch (key) {
                case Input.KEY_ESCAPE:
                    gameContainer.setPaused(!gameContainer.isPaused());
                    break;
            }
        }
    }

    public abstract String getName();

    @Override
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public GameState getGameState() {
        return gameState;
    }

    public ApplicationController getController() {
        return controller;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public abstract JDialog getInstructions();

    public GameContainer getGameContainer() {
        return gameContainer;
    }

    public abstract ScoreSystem getScoreSystem();

    public long getCurrentTime() {
        return currentTime;
    }

    public ActionCommunication getActionCommunication() {
        return actionCommunication;
    }
}
