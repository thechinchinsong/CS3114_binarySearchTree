package binarySearchTree;

public class BinaryNode<U,T> {
    private T key;
    private U element;
    
    private BinaryNode<U,T> left;
    private BinaryNode<U,T> right;

    //Default Constructor
    BinaryNode(U element, T key) {
        this.element = element;
        this.key = key;
        left = null;
        right = null;
    }
    
    public T getKey() { return key; }

    public void setKey(T value) { key = value; }
    
    public U getElement() { return element; }

    public void setElement(U value) { element = value; }

    public BinaryNode<U,T> getLeft() { return left; }

    public void setLeft(BinaryNode<U,T> value) { left = value; }

    public BinaryNode<U,T> getRight(){ return right; }

    public void setRight(BinaryNode<U,T> value) { right = value; }
}
