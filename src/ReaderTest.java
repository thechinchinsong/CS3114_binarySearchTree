import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Test the functionality of the reader
 * 
 * @author Ben Zevin (benz44)
 * @version 2-19-19
 */

public class ReaderTest extends student.TestCase {

    /**
     * run Read for the scanner
     */
    public void testRead1() throws FileNotFoundException {
        Reader scan = new Reader("testgg_nore.txt");
        RectangleBST tree = new RectangleBST();
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        scan.reader(tree);
        assertEquals("Rectangle rejected: (r_r, -1, -20, 3, 4)\n"
            + "Rectangle rejected: (rec, 7, -8, 1, 3)\n"
            + "Rectangle rejected: (virtual_rec0, 1, 1, 0, 0)\n"
            + "Rectangle rejected: (virtual_REC0, 0, 0, 11, 0)\n"
            + "Rectangle rejected: (inExistRec_0, 1, 1, -1, -2)\n"
            + "Rectangles intersecting region (11, 11, 0, 0):\n"
            + "Intersection pairs:\n" + "BST dump:\n"
            + "Node has depth 0, Value (null)\n" + "BST size is: 0\n"
            + "Rectangle not found: r_r\n" + "Rectangle rejected r_r\n"
            + "Rectangle rejected (1, 1, 0, 0)\n"
            + "Rectangles intersecting region (-5, -5, 20, 20):\n", outContent
                .toString());

    }
}
