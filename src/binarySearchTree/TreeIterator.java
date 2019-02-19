package binarySearchTree;

public class TreeIterator {
    BinaryNode<Rectangle, String> result;
    
    public TreeIterator() {
        result = null;
    }
    
    
    public BinaryNode<Rectangle, String> inorderTrav(BinaryNode<Rectangle, String> p) {
        if (p.getLeft() != null) {
            inorderTrav(p.getLeft());
        }
        
        result = p;
        
        if(p.getRight() != null) {
            inorderTrav(p.getRight());
        }
        return result;
        
        //Testing github
        //testing again
    } 
}
