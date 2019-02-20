
/**
 * Implements a Rectangle class that contains the data of
 * name, width, height, x-y coordinates, of a rectangle.
 * Contains only getter and setter functions.
 *
 * @author Ben Zevin
 * @author Yaoquan Song
 * @version 2019.2.19
 */

public class Rectangle {
    private String name;
    private int w;
    private int h;
    private int x;
    private int y;


    /**
     * Creates a rectangle with set element values
     * 
     * @param name
     *            name of rectangle
     * @param x
     *            x coordinate
     * @param y
     *            y coordinate
     * @param w
     *            width of rectangle
     * @param h
     *            height of rectangle
     */
    Rectangle(String name, int x, int y, int w, int h) {
        this.name = name;
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
    }


    /**
     * returns name
     * 
     * @return
     *         name of rectangle
     */
    public String getName() {
        return name;
    }


    /**
     * returns width
     * 
     * @return
     *         width of rectangle
     */
    public int getWidth() {
        return w;
    }


    /**
     * returns height
     * 
     * @return
     *         height of rectangle
     */
    public int getHeight() {
        return h;
    }


    /**
     * returns x coordinate
     * 
     * @return
     *         x coordinate
     */
    public int getX() {
        return x;
    }


    /**
     * returns y coordinate
     * 
     * @return
     *         y coordinate
     */
    public int getY() {
        return y;
    }


    /**
     * Compares the values in each rectangle to see if they
     * are equal.
     * 
     * @param rec
     *            rectangle to be compared to
     * @return
     *         boolean of whether the two are equal
     */
    public boolean valueEquals(Rectangle rec) {
        return rec.getX() == this.getX() && rec.getY() == this.getY() && rec
            .getWidth() == this.getWidth() && rec.getHeight() == this
                .getHeight();
    }
}
