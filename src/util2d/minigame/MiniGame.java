package util2d.minigame;

import util2d.score.ScoreSystem;
import util2d.network.NetworkController;
import java.util.ArrayList;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import util2d.player.GraphicPlayer;
import util2d.player.Player;

/**
 *
 * @author Diego
 */
public class MiniGame extends BasicGame {

    public static enum GameState {

        NOT_EVEN_STARTED,
        INSTRUCTIONS_SCREEN,
        RUNNING,
        //PAUSED,//only for running state
        SCORE_SCREEN
    }

    protected String name;
    protected ArrayList<GraphicPlayer> players; //this should be players with a graphics representation?
    protected Instructions instructions;
    protected ScoreSystem scoreSystem; //this one decides when the game is over (score reached, time limit, etc.)
    protected long currentTime;
    protected Options options;//screen size, full screnn, fps...
    protected GameState gameState;
    protected NetworkController networkController;

    protected AppGameContainer gameContainer;

    public MiniGame(String name, ArrayList<Player> players, Options options, Instructions intructions, ScoreSystem scoreSystem) throws SlickException {
        super(name);
        this.name = name;
        this.setGraphicPlayers(players);
        this.instructions = intructions;
        this.scoreSystem = scoreSystem;
        this.currentTime = 0;
        this.gameState = GameState.NOT_EVEN_STARTED;
        this.gameContainer = null;
    }

    //only for testing propuses...
    public MiniGame(String name) throws SlickException {
        this(name, new ArrayList<>(), null, null, null);
    }

    public void start() throws SlickException {
        this.gameContainer = new AppGameContainer(this, options.getScreenWidth(), options.getScreenHeight(), options.isFullScreen());
        this.gameContainer.setTargetFrameRate(options.getFps());
        this.gameState = GameState.INSTRUCTIONS_SCREEN;
        this.gameContainer.start();
    }

    public void finish() {
        this.gameState = GameState.SCORE_SCREEN;
    }

    public boolean isPaused() {
        return gameContainer.isPaused();
        //return gameState == GameState.PAUSED;
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        //it should be the enter mehtod when implementing BasicGameState
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        switch (gameState) {
            case NOT_EVEN_STARTED:
                break;
            case INSTRUCTIONS_SCREEN:
                break;
            case RUNNING:
                if (gameContainer.isPaused()) {
                    return;
                }
                //finish the game?
                if (this.scoreSystem.isFinished()) {
                    finish();
                }
                //time update
                this.currentTime += delta;
                break;
            case SCORE_SCREEN:
                break;
        }
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        switch (gameState) {
            case NOT_EVEN_STARTED:
                g.drawString("NOT_EVEN_STARTED", 0, 0);
                break;
            case INSTRUCTIONS_SCREEN:
                g.drawString("INSTRUCTIONS_SCREEN", 0, 0);
                this.instructions.render(container, g);
                //show instructions
                break;
            case RUNNING:
                scoreSystem.renderScorePlotter(container, g);
                g.drawString("RUNNING", 0, 0);
                break;
            case SCORE_SCREEN:
                g.drawString("SCORE_SCREEN", 0, 0);
                //show scores and winner of teh minigame
                break;
        }
    }

    protected void setGraphicPlayers(ArrayList<Player> players) {
        this.players = new ArrayList<>();
        for (Player player : players) {
            this.players.add(new GraphicPlayer(player));
        }
    }

    //INPUTS...
    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        super.mouseClicked(button, x, y, clickCount);
        switch (gameState) {
            case INSTRUCTIONS_SCREEN:
                if (button == Input.MOUSE_LEFT_BUTTON) {
                    //networkController.sendPlayerReady();
                    gameState = GameState.RUNNING;
                }
                break;
        }
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

    //Sets y gets
    public void setNetworkController(NetworkController networkController) {
        this.networkController = networkController;
    }

    public String getName() {
        return name;
    }

    public ArrayList<GraphicPlayer> getPlayers() {
        return players;
    }

    public Instructions getInstructions() {
        return instructions;
    }

    public ScoreSystem getScoreSystem() {
        return scoreSystem;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public Options getOptions() {
        return options;
    }

    public GameState getGameState() {
        return gameState;
    }

    public AppGameContainer getGameContainer() {
        return gameContainer;
    }

}
