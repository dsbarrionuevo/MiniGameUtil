package util2d.network;

import common.Player;

/**
 *
 * @author Diego
 */
public class NetworkController extends AbstractSender {

    private static NetworkController instance;

    private boolean server;//true if I'm the server...
    private Player player;//the current player on this machine
    private SyncSystem syncSystem;

    private NetworkController() {
    }

    /*
     //real constructor:
     private NetworkController(Socket socker) {
     super(socket);
     }
     */
    public static NetworkController getInstance() {
        if (instance == null) {
            instance = new NetworkController();
        }
        return instance;
    }

    public void sendPlayerReady() {
        //int idPlayerReady = player.getId();
    }

    public boolean isServer() {
        return server;
    }

    public Player getPlayer() {
        return player;
    }

}
