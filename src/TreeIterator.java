

import java.util.ArrayList;

/**
 * A basic binary search tree iterator that uses in-order traversal
 * to add nodes of tree into an ArrayList.
 * 
 * @author Yaoquan Song
 * @author Ben Zevin
 * @version 2019.2.19
 */

public class TreeIterator {
    ArrayList<BinaryNode<Rectangle, String>> nodeList;


    /**
     * Default Constructor
     */
    public TreeIterator() {
        nodeList = new ArrayList<BinaryNode<Rectangle, String>>();
    }


    /**
     * Adds nodes through in-order traversal to ArrayList.
     */
    public void inorderTrav(BinaryNode<Rectangle, String> node) {
        if (node != null) {
            if (node.getLeft() != null) {
                inorderTrav(node.getLeft());
            }

            nodeList.add(node);

            if (node.getRight() != null) {
                inorderTrav(node.getRight());
            }
        }
    }


    /**
     * Getter method for the ArrayList of nodes
     * 
     * @return
     *         In-order ArrayList of nodes in BST
     */
    public ArrayList<BinaryNode<Rectangle, String>> getList() {
        return nodeList;
    }
}
