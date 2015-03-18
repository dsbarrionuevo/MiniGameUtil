package util2d.graphics;

import util2d.graphics.Drawable;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Diego
 */
public abstract class Movable extends Drawable {

    protected Vector2f direction;
    protected float speed;
    private float angle;//in radians
    private float magnitude;

    public Movable(float speed, Vector2f direction) {
        super();
        this.speed = speed;
        this.direction = direction;
        this.angle = 0f;
        this.magnitude = 0f;
        this.updateMovementParameters();
    }

    public Movable(float speed) {
        this(speed, new Vector2f(0, 0));
    }

    public Movable() {
        this(10);
    }

    public void update(GameContainer gc, int delta) {
        Vector2f newPosition = new Vector2f();
        newPosition.x = (float) (Math.cos(angle) * speed * magnitude);
        newPosition.y = (float) (Math.sin(angle) * speed * magnitude);
        super.position.x += newPosition.x * (delta / 100f);
        super.position.y += newPosition.y * (delta / 100f);
    }

    public Vector2f getDirection() {
        return direction;
    }

    public float getDirectionX() {
        return direction.x;
    }

    public float getDirectionY() {
        return direction.y;
    }

    public void setDirection(float x, float y) {
        this.direction.x = x;
        this.direction.y = y;
        this.updateMovementParameters();
    }

    //receives the angle in degrees
    public void setDirection(float angle) {
        this.angle = (float) (angle * Math.PI / 180);
        this.direction.x = (float) Math.cos(angle);
        this.direction.y = (float) Math.sin(angle);
        System.out.println("this.direction.y: "+this.direction.y);
        this.magnitude = (float) Math.sqrt(direction.x * direction.x + direction.y * direction.y);
    }

    public void setDirection(Vector2f direction) {
        this.setDirection(direction.x, direction.y);
    }

    public void setDirectionX(float x) {
        this.setDirection(x, direction.y);
    }

    public void setDirectionY(float y) {
        this.setDirection(direction.x, y);
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    private void updateMovementParameters() {
        angle = (float) Math.atan2(direction.y, direction.x);
        magnitude = (float) Math.sqrt(direction.x * direction.x + direction.y * direction.y);
        magnitude = (magnitude > 0) ? 1f : 0f;
    }

    public float getAngle() {
        return angle;
    }

    public float getAngleInRadians() {
        return getAngle();
    }

    public float getAngleInDegrees() {
        return ((float) (getAngle() * 180 / Math.PI));
    }

}
