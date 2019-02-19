

import java.io.FileNotFoundException;

/**
 * Driver that is used to create the parser and the tree, then using
 * the reader method in the parser to output information based on the
 * input and tree.
 *
 * @author Ben Zevin
 * @author Yaoquan Song
 * @version 2019.2.19
 */
public class Rectangle1 {

    /**
     * Default constructor
     */
    public Rectangle1() {

    }


    /**
     * Main function for parsing and output.
     * 
     * @param args
     *            input for the parser
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Reader parser;
        RectangleBST tree = new RectangleBST();
        if (args.length == 1) {
            parser = new Reader(args[0]);
            parser.reader(tree);
        }
    }

}
