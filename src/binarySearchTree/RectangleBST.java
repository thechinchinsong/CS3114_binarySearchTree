package binarySearchTree;

/**
 * Implements an binary search tree specifically using the rectangle class
 * in order to fulfill requirements for project 1. Inherits from the original
 * BST class in order to utilize and build off of the basic BST methods. Uses
 * the TreeIterator class for some aspects of in-order traversal for specific
 * functionality needed.
 *
 * @param <Rectangle>
 *            The data stored in each node.
 * @param <Name>
 *            The name of each node that is also the key. The same as the name
 *            of each rectangle stored in the node.
 * @author Ben Zevin
 * @author Yaoquan Song
 * @version 2019.2.19
 */

import java.util.ArrayList;

public class RectangleBST extends BST<Rectangle, String> {
    private BinaryNode<Rectangle, String> root;


    /**
     * Constructs an empty tree.
     */
    public RectangleBST() {
        super();
    }


    /**
     * Returns the root node of the tree.
     * 
     * @return
     */
    public BinaryNode<Rectangle, String> getRoot() {
        return root;
    }


    public int getSize() {
        ArrayList<BinaryNode<Rectangle, String>> inorderList =
            new ArrayList<BinaryNode<Rectangle, String>>();
        TreeIterator test = new TreeIterator();
        test.inorderTrav(super.getRoot());
        inorderList = test.getList();
        return inorderList.size();
    }


    /**
     * Inserts a rectangle into the BST. Handles nodes alphabetically from
     * left to right and accepts identical insertions by sending them to
     * the right. Uses the inherited insert method from the BST class
     * 
     * 
     * @param name
     *            name/key of the node as well as the name of the rectangle
     * @param x
     *            x coordinate of the rectangle
     * @param y
     *            y coordinate of the rectangle
     * @param w
     *            width of the rectangle
     * @param h
     *            height of the rectangle
     */
    public void insert(String name, int x, int y, int w, int h) {
        if (w > 0 && h > 0 && y >= 0 && x >= 0 && (x + w <= 1024) && (y
            + h <= 1024)) {
            super.insert(new Rectangle(name, x, y, w, h), name);
            System.out.println("Rectangle accepted: (" + name + ", " + x + ", "
                + y + ", " + w + ", " + h + ")");
        }
        else {
            System.out.println("Rectangle rejected: (" + name + ", " + x + ", "
                + y + ", " + w + ", " + h + ")");
        }
    }


    /**
     * Removes nodes based on name. Uses the inherited BST class's
     * remove function. The try catch is in order to catch when the
     * wanted rectangle could not be found to be removed.
     */
    public void remove(String name) {
        try {
            super.remove(name);
        }
        catch (Exception e) {
            System.out.println("Rectangle rejected " + name);
        }
    }


    /**
     * Removes nodes based on the rectangle's information. The
     * TreeIterator is used to generate an in-order list ArrayList
     * of the BST and then a for loop is used to cycle through all
     * nodes, using the remove(name) function to remove all relevant
     * rectangles. Try-catch is used here for the same reason as in
     * the insert method.
     * 
     * @param x
     *            x coordinate that is wanted
     * @param y
     *            y coordinate that is wanted
     * @param w
     *            width that is wanted
     * @param h
     *            height that is wanted
     */
    public void remove(int x, int y, int w, int h) {
        ArrayList<BinaryNode<Rectangle, String>> inorderList =
            new ArrayList<BinaryNode<Rectangle, String>>();
        TreeIterator test = new TreeIterator();
        test.inorderTrav(super.getRoot());
        inorderList = test.getList();
        boolean found = false;
        for (int i = 0; i < inorderList.size(); i++) {
            if ((inorderList.get(i).getElement().getX() == x) && (inorderList
                .get(i).getElement().getY() == y) && (inorderList.get(i)
                    .getElement().getWidth() == w) && (inorderList.get(i)
                        .getElement().getHeight() == h)) {
                found = true;
                try {
                    super.remove(inorderList.get(i).getKey());
                }
                catch (Exception e) {
                    // System.out.println("Rectangle rejected (" + x + ", " + y
                    // + ", " + w + ", " + h + ")");
                }
            }
        }
        if (!found) {
            System.out.println("Rectangle rejected (" + x + ", " + y + ", " + w
                + ", " + h + ")");
        }
    }


    /**
     * Finds all rectangles intersecting a rectangle with the given
     * parameters. Uses the intersectHelper method.
     * 
     * @param x
     *            x coordinate that is wanted
     * @param y
     *            y coordinate that is wanted
     * @param w
     *            width that is wanted
     * @param h
     *            height that is wanted
     */
    public void regionSearch(int x, int y, int w, int h) {
        System.out.println("Rectangles intersecting region (" + x + ", " + y
            + ", " + w + ", " + h + "):");

        ArrayList<BinaryNode<Rectangle, String>> inorderList =
            new ArrayList<BinaryNode<Rectangle, String>>();
        TreeIterator orderiterator = new TreeIterator();
        orderiterator.inorderTrav(super.getRoot());
        inorderList = orderiterator.getList();

        if (h > 0 || w > 0) {
            Rectangle test = new Rectangle("test", x, y, w, h);
            for (int i = 0; i < inorderList.size(); i++) {
                if (intersectHelper(test, inorderList.get(i).getElement())) {
                    Rectangle temp = inorderList.get(i).getElement();
                    System.out.println("(" + temp.getName() + ", " + temp.getX()
                        + ", " + temp.getY() + ", " + temp.getWidth() + ", "
                        + temp.getHeight() + ")");
                }
            }
        }
    }


    /**
     * Finds all intersecting rectangles by going through an in-order
     * ArrayList of all node in BST using the intersectHelper method
     * to determine if they actually intersect
     */
    public void intersections() {
        ArrayList<BinaryNode<Rectangle, String>> inorderList =
            new ArrayList<BinaryNode<Rectangle, String>>();
        TreeIterator test = new TreeIterator();
        test.inorderTrav(super.getRoot());
        inorderList = test.getList();
        for (int i = 0; i < inorderList.size(); i++) {
            for (int j = i+1; j < inorderList.size(); j++) {
                Rectangle reci = inorderList.get(i).getElement();
                Rectangle recj = inorderList.get(j).getElement();
                if (intersectHelper(reci, recj) {
                    System.out.println("(" + temp.getName() + ", " + temp.getX()
                        + ", " + temp.getY() + ", " + temp.getWidth() + ", "
                        + temp.getHeight() + ")");
                }
            }
        }
    }


    /**
     * Compares the top left and bottom right points of two rectangles to
     * determine if they are intersecting
     * 
     * @param node1
     *            first rectangle to compare
     * @param node2
     *            second rectangle to compare
     * @return
     *         true if the 2 rectangles intersect, false if they don't
     */
    @SuppressWarnings("unused")
    private boolean intersectHelper(Rectangle rec1, Rectangle rec2) {

        // If one rectangle is on left side of other
        if (rec1.getX() >= rec2.getX() + rec2.getWidth() || rec2.getX() >= rec1
            .getX() + rec1.getWidth()) {
            return false;
        }

        // If one rectangle is below other
        if (rec1.getY() >= rec2.getY() + rec2.getHeight() || rec2.getY() >= rec1
            .getY() + rec1.getHeight()) {
            return false;
        }

        return true;
    }


    /**
     * Uses a similar process to removing based on given information. Instead of
     * removal after going through the in-order ArrayList, it simply prints out
     * the relevant information if the name matches. Otherwise it will simply
     * print that the rectangle was not found.
     * 
     * @param name
     *            finds all rectangles with this name
     */
    public void search(String name) {
        boolean found = false;
        ArrayList<BinaryNode<Rectangle, String>> inorderList =
            new ArrayList<BinaryNode<Rectangle, String>>();
        TreeIterator test = new TreeIterator();
        test.inorderTrav(super.getRoot());
        inorderList = test.getList();
        for (int i = 0; i < inorderList.size(); i++) {
            if (inorderList.get(i).getKey().equals(name)) {
                System.out.println("Rectangle found: (" + name + ", "
                    + inorderList.get(i).getElement().getX() + ", "
                    + inorderList.get(i).getElement().getY() + ", "
                    + inorderList.get(i).getElement().getWidth() + ", "
                    + inorderList.get(i).getElement().getHeight() + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Rectangle not found: " + name);
        }
    }


    /**
     * The dump function that is called to print out an in-order
     * list of nodes in the BST with depth information and overall
     * size of the BST. Uses the private dump helper method for
     * recursive in-order traversal of the binary tree.
     */
    public void dump() {
        System.out.println("BST dump:");
        if (super.getRoot() == null) {
            System.out.println("Node has depth 0, Value (null)");
            System.out.println("BST size is: 0");
        }
        else {
            dump(super.getRoot(), 0);
            System.out.println("BST size is: " + this.getSize());
        }
    }


    /**
     * Function that recursively prints out information on each node
     * while going through the in-order traversal of the BST.
     * 
     * @param node
     *            the node at which to start in-order traversal
     * @param depth
     *            starting depth
     * @param size
     *            starting size of the BST
     */
    private void dump(BinaryNode<Rectangle, String> node, int depth) {
        if (node == null) {
            return;
        }

        if (node.getLeft() != null) {
            dump(node.getLeft(), depth + 1);
        }

        System.out.println("Node has depth " + depth + ", Value (" + node
            .getElement().getName() + ", " + node.getElement().getX() + ", "
            + node.getElement().getY() + ", " + node.getElement().getWidth()
            + ", " + node.getElement().getHeight() + ")");

        if (node.getRight() != null) {
            dump(node.getRight(), depth + 1);
        }

    }
}
