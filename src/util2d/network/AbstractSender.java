package util2d.network;

import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Diego
 */
public abstract class AbstractSender {

    /*
     //sockets need here?
     private Socket client;
    
     public AbstractSender(Socket socket){
     this.client = socket;
     }
    
     */
    public void sendObject(Object objectValue) {
    }

    public void sendInt(int intValue) {
    }

    public void sendFloat(float floatValue) {
    }

    public void sendLong(long longValue) {
    }

    public void sendVector2f(Vector2f vectorValue) {
    }

    public void sendString(String stringValue) {
    }
    
    public void sendBoolean(boolean booleanValue) {
    }

}
