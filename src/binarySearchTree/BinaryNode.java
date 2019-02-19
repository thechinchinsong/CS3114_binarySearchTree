package binarySearchTree;

/**
 * A basic node stored in a binary search tree. Built to work with
 * basically any kind of information.
 *
 * @param <T>
 *            The key that is used to identify the node.
 * @param <U>
 *            The type of data element contained in the node.
 * 
 * @author Yaoquan Song
 * @author Ben Zevin
 * @version 2019.2.19
 */

public class BinaryNode<U, T> {
    private T key;
    private U element;

    private BinaryNode<U, T> left;
    private BinaryNode<U, T> right;


    // Constructor
    BinaryNode(U element, T key) {
        this.element = element;
        this.key = key;
        left = null;
        right = null;
    }


    // Getter methods for all relevant information in this node
    public T getKey() {
        return key;
    }


    public U getElement() {
        return element;
    }


    public BinaryNode<U, T> getLeft() {
        return left;
    }


    public BinaryNode<U, T> getRight() {
        return right;
    }


    // Setter methods for the key, element, and both left and right nodes
    public void setKey(T value) {
        key = value;
    }


    public void setElement(U value) {
        element = value;
    }


    public void setLeft(BinaryNode<U, T> value) {
        left = value;
    }


    public void setRight(BinaryNode<U, T> value) {
        right = value;
    }
}
