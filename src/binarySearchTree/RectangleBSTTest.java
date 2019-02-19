package binarySearchTree;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RectangleBSTTest extends student.TestCase{

	private RectangleBST tree;
	
	public void setUp() {
		tree = new RectangleBST();
		//final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); 
        //System.setOut(new PrintStream(outContent));
    }
	
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
		tree.insert("rec1", 2, 2, 2, 2);
		assertFalse(tree.isEmpty());
		
	}
	
	public void testRemoveName() {
	
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); 
        System.setOut(new PrintStream(outContent));
		assertTrue(tree.isEmpty());
		tree.remove("rec1");
		assertEquals("Rectangle rejected rec1\n", outContent.toString());
		assertTrue(tree.isEmpty());
		tree.insert("rec1", 1, 1, 1, 1);
		tree.insert("rec1", 2, 2, 2, 2);
		tree.remove("rec1");
		tree.remove("rec2");
		assertEquals("Rectangle rejected rec2\n", outContent.toString());
		tree.remove("rec1");
		assertTrue(tree.isEmpty());
		
		
	}
	
	public void testRemoveInt() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); 
        System.setOut(new PrintStream(outContent));
		assertTrue(tree.isEmpty());
		tree.insert("rec1", -1, 1, 1, 1);
		tree.remove("rec1");
		assertEquals("Rectangle rejected (-1, 1, 1, 1)\n", outContent.toString());
		assertTrue(tree.isEmpty());
		tree.insert("rec1", 1, 1, 1, 1);
		tree.insert("rec1", 2, 2, 2, 2);
		assertFalse(tree.isEmpty());
		tree.remove(1, 1, 1, 1);
		tree.remove(3, 4, 5, 6);
		assertEquals("Rectangle rejected (3, 4, 5, 6)\n", outContent.toString());
		tree.remove("rec1");
		assertTrue(tree.isEmpty());
		
	}
	
	public void testRegionSearch() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); 
        System.setOut(new PrintStream(outContent));
        tree.regionSearch(-5, -5, 20, 20);
        assertEquals("Rectangles intersecting region (-5, -5, 20, 20):", outContent.toString());
        tree.insert("rec1", 2, 2, 2, 2);
        assertFalse(tree.isEmpty());
        tree.regionSearch(0, 0, 10, 10);
        assertEquals("Rectangles intersecting region (0, 0, 10, 10):"
        		+ "(rec1, 2, 2, 2, 2)", outContent.toString());
	}
	
	public void testIntersections() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); 
        System.setOut(new PrintStream(outContent));
        tree.intersections();
        assertEquals("Intersection pairs:", outContent.toString());
        tree.insert("b", 2, 2, 2, 2);
        tree.insert("c", 1, 1, 1, 1);
        tree.insert("a", 3, 3, 3, 3);
        assertEquals("Intersection pairs:"
        		+ "(a, 3, 3, 3, 3) : (b, 2, 2, 2, 2)", outContent.toString());
		
	}
	
	public void testSearch() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); 
        System.setOut(new PrintStream(outContent));
        tree.search("a");
        assertEquals("Rectangle not found: a", outContent.toString());
        tree.insert("b", 2, 2, 2, 2);
        tree.insert("c", 1, 1, 1, 1);
        tree.insert("a", 3, 3, 3, 3);
        tree.search("c");
        assertEquals("Rectangle found: (c, 1, 1, 1, 1)", outContent.toString());
		
	}
	
	public void testDump() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); 
        System.setOut(new PrintStream(outContent));
        assertTrue(tree.isEmpty());
        tree.dump();
        assertEquals("BST dump:"
        		+ "Node has depth 0, Value (null)"
        		+ "BST size is: 0", outContent.toString());
        tree.insert("b", 2, 2, 2, 2);
        tree.insert("c", 1, 1, 1, 1);
        tree.insert("a", 3, 3, 3, 3);
        assertFalse(tree.isEmpty());
        assertEquals("BST dump:"
        		+ "Node has depth 1, Value (a, 3, 3, 3, 3)"
        		+ "Node has depth 0, Value (b, 2, 2, 2, 2)"
        		+ "Node has depth 1, Value (c, 1, 1, 1, 1)"
        		+ "BST size is: 0", outContent.toString());
        
	
	}
}
