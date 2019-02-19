package binarySearchTree;

public class RectangleTest extends student.TestCase{

	private Rectangle rec1;
	
	public void setUp() {
        rec1 = new Rectangle("rec1", 1, 2, 3, 4);

    }
	
	public void testGetName() { 
    	assertEquals(rec1.getName(), "rec1");
    	}
    
    public void testGetWidth() {
    	assertEquals(rec1.getWidth(), 1); 
    	}
    
    public void testGetHeight() { 
    	assertEquals(rec1.getHeight(), 2); 
    	}
    
    public void testGetX() {
    	assertEquals(rec1.getX(), 3); 
    	}
    
    public void testGetY() {
    	assertEquals(rec1.getY(), 4); 
    	}
    

}
