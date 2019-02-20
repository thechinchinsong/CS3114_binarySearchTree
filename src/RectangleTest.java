/**
 * Test the functionality of the Rectangle class,
 * from CS3114 project 1.
 * 
 * @author Ben Zevin (benz44),
 * 
 * @version 2-19-19
 */
public class RectangleTest extends student.TestCase {

    private Rectangle rec1;


    /**
     * run before every test case
     */
    public void setUp() {
        rec1 = new Rectangle("rec1", 1, 2, 3, 4);

    }


    /**
     * Tests that the getName() method returns the name of the rectangle.
     */
    public void testGetName() {
        assertEquals(rec1.getName(), "rec1");
    }


    /**
     * Tests that the getWidth() method returns the width of the rectangle.
     */
    public void testGetWidth() {
        assertEquals(rec1.getWidth(), 3);
    }


    /**
     * Tests that the getHeight() method returns the height of the rectangle.
     */
    public void testGetHeight() {
        assertEquals(rec1.getHeight(), 4);
    }


    /**
     * Tests that the getX() method returns the X coordinate of the rectangle.
     */
    public void testGetX() {
        assertEquals(rec1.getX(), 1);
    }


    /**
     * Tests that the getY() method returns the Y coordinate of the rectangle.
     */
    public void testGetY() {
        assertEquals(rec1.getY(), 2);
    }


    /**
     * Test if valueEquals() method returns correct boolean
     */
    public void testValueEquals() {
        Rectangle rec2 = new Rectangle("rec2", 1, 2, 3, 4);
        assertTrue(rec1.valueEquals(rec2));
    }

}
