
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


    // Constructor
    Rectangle(String name, int x, int y, int w, int h) {
        this.name = name;
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
    }


    // Getter methods for relevant informations
    public String getName() {
        return name;
    }


    public int getWidth() {
        return w;
    }


    public int getHeight() {
        return h;
    }


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    // Setter methods for all relevant information
    public void setName(String name) {
        this.name = name;
    }


    public void setWidth(int width) {
        this.w = width;
    }


    public void setHeight(int height) {
        this.h = height;
    }


    public void setX(int x) {
        this.x = x;
    }


    public void setT(int y) {
        this.y = y;
    }
}
