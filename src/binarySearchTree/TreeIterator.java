package binarySearchTree;

/**
 * A basic binary search tree iterator that uses in-order traversal
 * 
 * @author Yaoquan Song
 * @author Ben Zevin
 * @version 2019.2.19
 */

public class TreeIterator {
    BinaryNode<Rectangle, String> result;


    // Default Constructor
    public TreeIterator() {
        result = null;
    }


    /**
     * Returns the last node in the in-order traversal of the iterator
     */
    public BinaryNode<Rectangle, String> inorderTrav(
        BinaryNode<Rectangle, String> p) {
        if (p.getLeft() != null) {
            inorderTrav(p.getLeft());
        }

        result = p;

        if (p.getRight() != null) {
            inorderTrav(p.getRight());
        }
        return result;
    }
}
