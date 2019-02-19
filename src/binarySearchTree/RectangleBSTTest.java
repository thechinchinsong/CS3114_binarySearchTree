package binarySearchTree;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Tests the functionality of the RectangleBST class,
 * from CS3114 project 1.
 * 
 * @author Ben Zevin (benz44),
 * 
 * @version 2-19-19
 */
public class RectangleBSTTest extends student.TestCase {

    private RectangleBST tree;


    /**
     * run before every test case
     */
    public void setUp() {
        tree = new RectangleBST();

    }


    /**
     * This method tests the Insert method of the RectangleBST class.
     */
    public void testInsert() {
        assertTrue(tree.isEmpty());
        tree.insert("rec1", -1, 1, 1, 1);
        assertTrue(tree.isEmpty());
        tree.insert("rec1", 1, -1, 1, 1);
        assertTrue(tree.isEmpty());
        tree.insert("rec1", 1, 1, -1, 1);
        assertTrue(tree.isEmpty());
        tree.insert("rec1", 1, 1, 1, -1);
        assertTrue(tree.isEmpty());
        tree.insert("rec1", 1, 1, 1, 1);
        assertFalse(tree.isEmpty());
        tree.insert("rec2", 2, 2, 2, 2);
        assertFalse(tree.isEmpty());
        System.out.println(tree.findMax());
        tree.dump();
    }


    /**
     * This method tests the Remove(name) method of the RectangleBST class.
     */
    public void testRemoveName() {

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        assertTrue(tree.isEmpty());
        tree.remove("rec1");
        assertEquals("Rectangle rejected rec1\n", outContent.toString());
        assertTrue(tree.isEmpty());
        tree.insert("rec1", 1, 1, 1, 1);
        //assertEquals(1, tree.getRoot());
        tree.insert("rec1", 2, 2, 2, 2);
        assertEquals(2, tree.getSize());
        assertFalse(tree.isEmpty());
        tree.remove("rec1");
        assertEquals(1, tree.getSize());
        assertFalse(tree.isEmpty());
        tree.remove("rec2");
        assertFalse(tree.isEmpty());
        tree.remove("rec1");
        assertEquals(0, tree.getSize());
        assertEquals("Rectangle rejected rec1\n"
            + "Rectangle accepted: (rec1, 1, 1, 1, 1)\n"
            + "Rectangle accepted: (rec1, 2, 2, 2, 2)\n"
            + "Rectangle rejected rec2\n", outContent.toString());
        assertTrue(tree.isEmpty());

    }


    /**
     * This method tests the Remove(x, y, w, h) method of the RectangleBST
     * class.
     */
    public void testRemoveInt() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        assertTrue(tree.isEmpty());
        tree.remove("rec1");
        assertEquals("Rectangle rejected (-1, 1, 1, 1)\n", outContent
            .toString());
        assertTrue(tree.isEmpty());
        tree.insert("rec1", 1, 1, 1, 1);
        tree.insert("rec1", 2, 2, 2, 2);
        assertFalse(tree.isEmpty());
        tree.remove(1, 1, 1, 1);
        tree.remove(3, 4, 5, 6);
        assertEquals("Rectangle rejected (-1, 1, 1, 1)\n"
            + "Rectangle accepted: (rec1, 1, 1, 1, 1)\n"
            + "Rectangle accepted: (rec1, 2, 2, 2, 2)\n"
            + "Rectangle rejected (3, 4, 5, 6)\n", outContent.toString());
        tree.remove("rec1");
        assertTrue(tree.isEmpty());

    }


    /**
     * This method tests the regionSearch method of the RectangleBST class.
     */
    public void testRegionSearch() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        tree.regionSearch(-5, -5, 20, 20);
        assertEquals("Rectangles intersecting region (-5, -5, 20, 20):\n",
            outContent.toString());
        tree.insert("rec1", 2, 2, 2, 2);
        assertFalse(tree.isEmpty());
        tree.regionSearch(0, 0, 10, 10);
        assertEquals("Rectangles intersecting region (-5, -5, 20, 20):\n"
            + "Rectangle accepted: (rec1, 2, 2, 2, 2)\n"
            + "Rectangles intersecting region (0, 0, 10, 10):\n"
            + "(rec1, 2, 2, 2, 2)\n", outContent.toString());
    }


    /**
     * This method tests the intersections method of the RectangleBST class.
     */
    public void testIntersections() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        tree.intersections();
        assertEquals("Intersection pairs:", outContent.toString());
        tree.insert("b", 2, 2, 2, 2);
        tree.insert("c", 1, 1, 1, 1);
        tree.insert("a", 3, 3, 3, 3);
        System.setOut(new PrintStream(outContent));
        // tree.intersection();
        assertEquals("Intersection pairs:"
            + "(a, 3, 3, 3, 3) : (b, 2, 2, 2, 2)", outContent.toString());

    }


    /**
     * This method tests the search method of the RectangleBST class.
     */
    public void testSearch() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        tree.search("a");
        assertEquals("Rectangle not found: a", outContent.toString());
        tree.insert("b", 2, 2, 2, 2);
        tree.insert("c", 1, 1, 1, 1);
        tree.insert("a", 3, 3, 3, 3);
        System.setOut(new PrintStream(outContent));
        tree.search("c");
        assertEquals("Rectangle found: (c, 1, 1, 1, 1)", outContent.toString());

    }


    /**
     * This method tests the dump method of the RectangleBST class.
     */
    public void testDump() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        assertTrue(tree.isEmpty());
        tree.dump();
        assertEquals("BST dump:\n" + "Node has depth 0, Value (null)\n"
            + "BST size is: 0\n", outContent.toString());
        tree.insert("b", 2, 2, 2, 2);
        tree.insert("c", 1, 1, 1, 1);
        tree.insert("a", 3, 3, 3, 3);
        final ByteArrayOutputStream outContent1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent1));
        assertFalse(tree.isEmpty());
        tree.dump();
        assertEquals("BST dump: \n"
            + "Node has depth 1, Value (a, 3, 3, 3, 3)\n"
            + "Node has depth 0, Value (b, 2, 2, 2, 2)\n"
            + "Node has depth 1, Value (c, 1, 1, 1, 1)\n" + "BST size is: 3\n",
            outContent1.toString());
    }
}
