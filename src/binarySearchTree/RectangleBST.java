package binarySearchTree;

import java.util.ArrayList;

public class RectangleBST extends BST<Rectangle, String> {
    private BinaryNode<Rectangle, String> root;


    public BinaryNode<Rectangle, String> getRoot() {
        return root;
    }


    public RectangleBST() {
        root = null;
    }


    public void insert(String name, int x, int y, int w, int h) {
        if (w > 0 && h > 0 && y >= 0 && x >= 0) {
            super.insert(new Rectangle(name, x, y, w, h), name);
            System.out.println("Rectangle accepted (" + name + ", " + x + ", "
                + y + ", " + w + ", " + h + ")");
        }
        else {
            System.out.println("Rectangle rejected (" + name + ", " + x + ", "
                + y + ", " + w + ", " + h + ")");
        }
    }


    public void remove(String name) {
        try {
            super.remove(name);
        }
        catch (Exception e) {
            System.out.println("Rectangle rejected " + name);
        }
    }


    public void remove(int x, int y, int w, int h) {
        ArrayList<BinaryNode<Rectangle, String>> inorderList =
            new ArrayList<BinaryNode<Rectangle, String>>();
        TreeIterator test = new TreeIterator();
        test.inorderTrav(root);
        inorderList = test.getList();
        for (int i = 0; i < inorderList.size(); i++) {
            if (inorderList.get(i).getElement().getX() == x && inorderList.get(
                i).getElement().getY() == y && inorderList.get(i).getElement()
                    .getWidth() == w && inorderList.get(i).getElement()
                        .getHeight() == h) {

                try {
                    super.remove(inorderList.get(i).getKey());
                }
                catch (Exception e) {
                    System.out.println("Rectangle rejected (" + x + ", " + y
                        + ", " + w + ", " + h + ")");
                }
            }
        }
    }


    public void regionSearch(int x, int y, int w, int h) {

    }


    public void intersections() {

    }


    public void search(String name) {
        // must return all rectangles with the same name
        super.find(name);
    }


    public void dump() {
        System.out.println("BST dump:");
        dump(root, 0);
    }


    private void dump(BinaryNode<Rectangle, String> node, int depth) {
        if (node.getLeft() != null) {
            depth++;
            dump(node.getLeft(), depth);
        }

        System.out.println("Node has depth " + depth + ", Value (" + node
            .getElement().getWidth() + ", " + node.getElement().getX() + ", "
            + node.getElement().getY() + ", " + node.getElement().getWidth()
            + ", " + node.getElement().getHeight());

        if (node.getRight() != null) {
            depth++;
            dump(node.getRight(), depth);
        }
    }
}
