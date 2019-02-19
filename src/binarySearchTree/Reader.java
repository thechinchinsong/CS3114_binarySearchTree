package binarySearchTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Scanner;

public class Reader {
    Scanner scan;


    public Reader(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        scan = new Scanner(file);
    }


    public void reader(RectangleBST tree) {
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parts = line.split("\\s+");
            if (parts[0].contentEquals("insert") && parts.length == 6) {

                int x = 0, y = 0, w = 0, h = 0;
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

                int x = 0, y = 0, w = 0, h = 0;
                try {
                    x = Integer.parseInt(parts[2]);
                    y = Integer.parseInt(parts[3]);
                    w = Integer.parseInt(parts[4]);
                    h = Integer.parseInt(parts[5]);
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

                int x = 0, y = 0, w = 0, h = 0;
                try {
                    x = Integer.parseInt(parts[2]);
                    y = Integer.parseInt(parts[3]);
                    w = Integer.parseInt(parts[4]);
                    h = Integer.parseInt(parts[5]);
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
