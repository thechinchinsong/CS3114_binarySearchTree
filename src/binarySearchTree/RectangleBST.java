package binarySearchTree;

public class RectangleBST extends BST<Rectangle, String> {
    private BinaryNode<Rectangle,String> root;
    
    public BinaryNode<Rectangle, String> getRoot() {
        return root;
    }
    
    public RectangleBST() { root = null; }
    
    public void insert(String name, int x, int y, int w, int h) {
        if (w > 0 && h > 0 && y >= 0 && x >= 0) {
            super.insert(new Rectangle(name, x, y, w, h), name);
            System.out.println("Rectangle accepted (" + name + ", " + x + ", " + y + ", " + w + ", " + h + ")");
        }
        else {
            System.out.println("Rectangle rejected (" + name + ", " + x + ", " + y + ", " + w + ", " + h + ")");
        }
    }
    
    public void remove(String name) {
        try {
            super.remove(name);
        }
        catch (Exception e){
            System.out.println("Rectangle rejected " + name);
        }
    }
    
    public void remove(int x, int y, int w, int h) {
        BinaryNode<Rectangle,String> result;
        TreeIterator test = new TreeIterator();
        result = test.inorderTrav(root);
        int count = 0;
        while (count < 1) {
            if (result.getElement().getX() == x &&
                result.getElement().getY() == y &&
                result.getElement().getWidth() == w &&
                result.getElement().getHeight() == h) {
                try {
                    super.remove(result.getKey());
                }
                catch (Exception e) {
                    System.out.println("Rectangle rejected (" + x + ", " + y + ", " + w + ", " + h + ")");
                }
                count = 1;
            }
        }
    }
    
    public void regionSearch(int x, int y, int w, int h) {
        
    }
    
    public void intersections() {
        
    }
    
    public void search(String name) {
        //must return all rectangles with the same name
        super.find(name);
    }
    
    public void dump() {
        BinaryNode<Rectangle,String> result;
        TreeIterator test = new TreeIterator();
        result = test.inorderTrav(root);
        while (result != null) {
                
        }
    }
}
