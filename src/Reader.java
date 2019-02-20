
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Scanners through a string input, parsing each line for function calls
 * and parameters to pass to the created RectangleBST.
 * 
 * @author Yaoquan Song (thechin)
 * @author Ben Zevin (benz44)
 * 
 * @version 2019.2.19
 *
 */
public class Reader {
    private Scanner scan;


    /**
     * Constructor that creates the file and scanner that are used.
     * 
     * @param fileName
     *            name of the file that is to be parsed
     */
    public Reader(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        scan = new Scanner(file);
    }


    /**
     * Reader is the method where parsing is actually done.
     * 
     * @param tree
     *            the BST class in which to call methods on and stores
     *            information
     */
    public void reader(RectangleBST tree) {
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parts = line.trim().split("\\s+");
            if (parts[0].contentEquals("insert") && parts.length == 6) {

                int x = 0;
                int y = 0;
                int w = 0;
                int h = 0;
                try {
                    x = Integer.parseInt(parts[2]);
                    y = Integer.parseInt(parts[3]);
                    w = Integer.parseInt(parts[4]);
                    h = Integer.parseInt(parts[5]);
                }
                catch (NumberFormatException e) {
                    System.out.print("Invalid Command Format");
                }
                tree.insert(parts[1], x, y, w, h);

            }
            else if (parts[0].contentEquals("remove") && parts.length == 2) {
                tree.remove(parts[1]);

            }
            else if (parts[0].contentEquals("remove") && parts.length == 5) {

                int x = 0;
                int y = 0;
                int w = 0;
                int h = 0;
                try {
                    x = Integer.parseInt(parts[1]);
                    y = Integer.parseInt(parts[2]);
                    w = Integer.parseInt(parts[3]);
                    h = Integer.parseInt(parts[4]);
                }
                catch (NumberFormatException e) {
                    System.out.print("Invalid Command Format");
                }
                tree.remove(x, y, w, h);

            }
            else if (parts[0].contentEquals("search") && parts.length == 2) {
                tree.search(parts[1]);

            }
            else if (parts[0].contentEquals("dump") && parts.length == 1) {
                tree.dump();

            }
            else if (parts[0].contentEquals("regionsearch")
                && parts.length == 5) {

                int x = 0;
                int y = 0;
                int w = 0;
                int h = 0;
                try {
                    x = Integer.parseInt(parts[1]);
                    y = Integer.parseInt(parts[2]);
                    w = Integer.parseInt(parts[3]);
                    h = Integer.parseInt(parts[4]);
                }
                catch (NumberFormatException e) {
                    System.out.print("Invalid Command Format");
                }
                tree.regionSearch(x, y, w, h);

            }
            else if (parts[0].contentEquals("intersections")
                && parts.length == 1) {
                tree.intersections();

            }

        }
        scan.close();

    }
}
