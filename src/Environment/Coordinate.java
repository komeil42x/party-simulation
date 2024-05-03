package Environment;

/********************************************
 * Author: Soodeh,...
 * Version: v.1
 * Date:   20240418
 * ------------------------------------------
 * Description:  
 * This class can represent the coordinates of each grid point.
 ********************************************/

/**
 * Represents a coordinate in a two-dimensional space.
 */
public class Coordinate {
    private int x;
    private int y;

    /**
     * Constructs a Coordinate object with the specified x and y values.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate of this Coordinate.
     *
     * @return the x-coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of this Coordinate.
     *
     * @return the y-coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the x-coordinate of this Coordinate.
     *
     * @param x the new x-coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y-coordinate of this Coordinate.
     *
     * @param y the new y-coordinate
     */
    public void setY(int y) {
        this.y = y;
    }
}
