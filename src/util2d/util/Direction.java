package util2d.util;

/**
 *
 * @author Diego
 */
public class Direction {

    public static final float DIRECTION_NORTH = 270;
    public static final float DIRECTION_SOUTH = 90;
    public static final float DIRECTION_WEST = 180;
    public static final float DIRECTION_EAST = 0;
    public static final float DIRECTION_NORTH_WEST = 225;
    public static final float DIRECTION_NORTH_EAST = 315;
    public static final float DIRECTION_SOUTH_WEST = 135;
    public static final float DIRECTION_SOUTH_EAST = 45;

    //angle in degrees
    public static float getOpposite(float angle) {
        return (float)((angle + 180) * (Math.PI / 180));
    }

}
