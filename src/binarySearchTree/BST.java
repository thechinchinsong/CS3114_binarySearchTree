package binarySearchTree;

/**
 * Implements an binary search tree. Note that all "matching" is
 * based on the compareTo() method. Most of this class was taken
 * from the basic CS 2114 binary search tree and and this is the
 * base from which the RectangleBST is built off of. Permission was
 * given to use this class in this project.
 *
 * @param <T>
 *            The key of each node.
 * @param <U>
 *            The data stored in each node.
 * @author Ben Zevin
 * @author Yaoquan Song
 * @version 2019.2.19
 */

public class BST<U, T extends Comparable<? super T>> {

    private BinaryNode<U, T> root;


    /**
     * Constructs an empty tree.
     */
    public BST() {
        root = null;
    }


    // ~ Public methods ........................................................
    public BinaryNode<U, T> getRoot() {
        return root;
    }
    
    /**
     * Insert into the tree.
     *
     * @param x
     *            the item to insert.
     * @throws DuplicateItemException
     *             if x is already present.
     */
    public void insert(U x, T k) {
        root = insertHelper(x, k, root);
    }


    /**
     * Remove the specified value from the tree.
     *
     * @param x
     *            the item to remove.
     * @throws ItemNotFoundException
     *             if x is not found.
     */
    public void remove(T k) {
        root = remove(k, root);
    }


    /**
     * Find the smallest item in the tree.
     *
     * @return The smallest item, or null if the tree is empty.
     */
    public T findMin() {
        return elementAt(findMin(root));
    }


    /**
     * Find the largest item in the tree.
     *
     * @return The largest item in the tree, or null if the tree is empty.
     */
    public T findMax() {
        return elementAt(findMax(root));
    }


    /**
     * Find an item in the tree.
     *
     * @param x
     *            the item to search for.
     * @return the matching item or null if not found.
     */
    public T find(T x) {
        return elementAt(find(x, root));
    }


    /**
     * Make the tree logically empty.
     */
    public void makeEmpty() {
        root = null;
    }


    /**
     * Test if the tree is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }


    // ~ Private methods
    // ........................................................
    /**
     * Internal method to get element value stored in a tree node, with safe
     * handling of null nodes.
     *
     * @param node
     *            the node.
     * @return the element field or null if node is null.
     */
    private T elementAt(BinaryNode<U, T> node) {
        return (node == null) ? null : node.getKey();
    }


    /**
     * Internal method to insert a value into a subtree.
     *
     * @param x
     *            the item to insert.
     * @param node
     *            the node that roots the subtree.
     * @return the new root of the subtree.
     * @throws DuplicateItemException
     *             if x is already present.
     */
    public BinaryNode<U, T> insertHelper(U x, T k, BinaryNode<U, T> node) {
        if (node == null) {
            return new BinaryNode<U, T>(x, k);
        }
        else if (k.compareTo(node.getKey()) < 0) {
            node.setLeft(insertHelper(x, k, node.getLeft()));
        }
        else {
            node.setRight(insertHelper(x, k, node.getRight()));
        }
        return node;
    }


    /**
     * Internal method to remove a specified item from a subtree.
     *
     * @param x
     *            the item to remove.
     * @param node
     *            the node that roots the subtree.
     * @return the new root of the subtree.
     * @throws ItemNotFoundException
     *             if x is not found.
     */
    private BinaryNode<U, T> remove(T x, BinaryNode<U, T> node) {
        // This local variable will contain the new root of the subtree,
        // if the root needs to change.
        BinaryNode<U, T> result = node;

        // If there's no more subtree to examine
        if (node == null) {
            throw new IllegalArgumentException("No more subtree to examine");
        }

        // if value should be to the left of the root
        if (x.compareTo(node.getKey()) < 0) {
            node.setLeft(remove(x, node.getLeft()));
        }
        // if value should be to the right of the root
        else if (x.compareTo(node.getKey()) > 0) {
            node.setRight(remove(x, node.getRight()));
        }
        // If value is on the current node
        else {
            // If there are two children
            if (node.getLeft() != null && node.getRight() != null) {
                node.setElement(findMin(node.getRight()).getElement());
                node.setKey(findMin(node.getRight()).getKey());
                node.setRight(remove(node.getKey(), node.getRight()));
            }
            // If there is only one child on the left
            else if (node.getLeft() != null) {
                result = node.getLeft();
            }
            // If there is only one child on the right
            else {
                result = node.getRight();
            }
        }
        return result;
    }


    /**
     * Internal method to find the smallest item in a subtree.
     *
     * @param node
     *            the node that roots the tree.
     * @return node containing the smallest item.
     */
    private BinaryNode<U, T> findMin(BinaryNode<U, T> node) {
        if (node == null) {
            return node;
        }
        else if (node.getLeft() == null) {
            return node;
        }
        else {
            return findMin(node.getLeft());
        }
    }


    /**
     * Internal method to find the largest item in a subtree.
     *
     * @param node
     *            the node that roots the tree.
     * @return node containing the largest item.
     */
    private BinaryNode<U, T> findMax(BinaryNode<U, T> node) {
        if (node == null) {
            return node;
        }
        else if (node.getRight() == null) {
            return node;
        }
        else {
            return findMax(node.getRight());
        }
    }


    /**
     * Internal method to find an item in a subtree.
     *
     * @param x
     *            is item to search for.
     * @param node
     *            the node that roots the tree.
     * @return node containing the matched item.
     */
    private BinaryNode<U, T> find(T x, BinaryNode<U, T> node) {
        if (node == null) {
            return null; // Not found
        }
        else if (x.compareTo(node.getKey()) < 0) {
            // Search in the left subtree
            return find(x, node.getLeft());
        }
        else if (x.compareTo(node.getKey()) > 0) {
            // Search in the right subtree
            return find(x, node.getRight());
        }
        else {
            return node; // Match
        }
    }
}
