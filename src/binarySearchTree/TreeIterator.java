package binarySearchTree;

import java.util.ArrayList;

/**
 * A basic binary search tree iterator that uses in-order traversal
 * 
 * @author Yaoquan Song
 * @author Ben Zevin
 * @version 2019.2.19
 */

public class TreeIterator {
    BinaryNode<Rectangle, String> result;
    ArrayList<BinaryNode<Rectangle, String>> nodeList =
        new ArrayList<BinaryNode<Rectangle, String>>();


    // Default Constructor
    public TreeIterator() {
        result = null;
    }


    /**
     * Returns the last node in the in-order traversal of the iterator
     */
    public void inorderTrav(BinaryNode<Rectangle, String> node) {
        if (node.getLeft() != null) {
            inorderTrav(node.getLeft());
        }

        nodeList.add(node);

        if (node.getRight() != null) {
            inorderTrav(node.getRight());
        }
    }


    // getter method for the ArrayList of nodes
    public ArrayList<BinaryNode<Rectangle, String>> getList() {
        return nodeList;
    }
}
