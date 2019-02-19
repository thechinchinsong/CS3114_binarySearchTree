package binarySearchTree;

import java.io.File; 
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Scanner;

public class Reader {

	
	public static void main(String[] args)
	        throws FileNotFoundException {

	        if (args.length == 1) {
	        	File file = new File(args[0]); 
	            Scanner scan = new Scanner(file); 
	        		  
	        	while (scan.hasNextLine())
	        	{
	        		 String line = scan.nextLine();
	        		 String[] parts = line.split("\\s+");
	        		 if (parts[0].contentEquals("insert") && parts.length == 6) {
	        			
	        			 int x,y,w,h;
	        			 try {
	        				 x = Integer.parseInt(parts[2]);
		        			 y = Integer.parseInt(parts[3]);
		        			 w = Integer.parseInt(parts[4]);
		        			 h = Integer.parseInt(parts[5]);
	        				}
	        				catch (NumberFormatException e)
	        				{
	        				   System.out.print("Invalid Command Format");
	        				}
	        			 //insert(parts[1], x,y,w,h);
	        			 
	        		 }
	        		 else if (parts[0].contentEquals("remove")&& parts.length == 2) {
	        			 //remove(parts[1]);
	        			 
	        		 }
	        		 else if (parts[0].contentEquals("remove") && parts.length == 5) {
	        			 
	        			 int x,y,w,h;
	        			 try {
	        				 x = Integer.parseInt(parts[2]);
		        			 y = Integer.parseInt(parts[3]);
		        			 w = Integer.parseInt(parts[4]);
		        			 h = Integer.parseInt(parts[5]);
	        				}
	        				catch (NumberFormatException e)
	        				{
	        				   System.out.print("Invalid Command Format");
	        				}
	        			 //remove(x,y,w,h);
	        			 
	        		 }
	        		 else if (parts[0].contentEquals("search") && parts.length == 2) {
	        			 //search(parts[1]);
	        			 
	        		 }
	        		 else if (parts[0].contentEquals("dump") && parts.length == 1) {
	        			 //dump();
	        			 
	        		 }
	        		 else if (parts[0].contentEquals("regionsearch") && parts.length == 5) {
	        			 
	        			 int x,y,w,h;
	        			 try {
	        				 x = Integer.parseInt(parts[2]);
		        			 y = Integer.parseInt(parts[3]);
		        			 w = Integer.parseInt(parts[4]);
		        			 h = Integer.parseInt(parts[5]);
	        				}
	        				catch (NumberFormatException e)
	        				{
	        				   System.out.print("Invalid Command Format");
	        				}
	        			 //regionsearch(x,y,w,h);
	        			 
	        		 }
	        		 else if (parts[0].contentEquals("intersections") && parts.length == 1) {
	        			 //intersections();
	        			 
	        		 }
	        		  
	        	}
	        	scan.close();
	        }
	    }
}
