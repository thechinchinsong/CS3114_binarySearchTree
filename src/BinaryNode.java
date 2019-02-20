
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
 * @author Ben Zevin (benz44)
 * @version 2019.2.19
 */

public class BinaryNode<U, T> {
    private T key;
    private U element;

    private BinaryNode<U, T> left;
    private BinaryNode<U, T> right;


    /**
     * Constructor
     * 
     * @param element
     *            the element to be stored
     * @param key
     *            the key used to access node
     */
    BinaryNode(U element, T key) {
        this.element = element;
        this.key = key;
        left = null;
        right = null;
    }


    /**
     * Getter for key
     * 
     * @return
     *         returns key
     */
    public T getKey() {
        return key;
    }


    /**
     * Getter for element
     * 
     * @return
     *         returns the element
     */
    public U getElement() {
        return element;
    }


    /**
     * Returns the left node
     * 
     * @return
     *         left node
     */
    public BinaryNode<U, T> getLeft() {
        return left;
    }


    /**
     * Returns the right node
     * 
     * @return
     *         right node
     */
    public BinaryNode<U, T> getRight() {
        return right;
    }


    /**
     * Sets the key
     * 
     * @param value
     *            value of key
     */
    public void setKey(T value) {
        key = value;
    }


    /**
     * Sets the element
     * 
     * @param value
     *            value of element
     */
    public void setElement(U value) {
        element = value;
    }


    /**
     * sets the left node
     * 
     * @param value
     *            what left node should be
     */
    public void setLeft(BinaryNode<U, T> value) {
        left = value;
    }


    /**
     * Sets the right node.
     * 
     * @param value
     *            what the right node should be
     */
    public void setRight(BinaryNode<U, T> value) {
        right = value;
    }
}
