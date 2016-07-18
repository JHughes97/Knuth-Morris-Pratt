/**
* @(#)SearchingMain.java
* This class allows the user to search a file for a piece of text.
* It includes only a main method which takes in user
* input and creates and uses necessary objects to find
* given text in given file.
* @author Jack Hughes
* @version 1.0 2016/7/16
*/

import java.util.*;
import java.io.*;

public class SearchingMain{

	/**
	* Main method asks the user to enter a file and then
	* allows the user to search the file, switch to another
	* file, or exit the program.
	* @param args
	*/
	public static void main(String[] args) throws Exception{
		
		//ask user to enter file to be searched
		Scanner scan = new Scanner(System.in);
		String fileName = new String();
		while(true){
			System.out.println("\nFile to be searched:");
			fileName = scan.nextLine();
			if(fileName.length() == 0)
				System.out.println("Invalid input.");
			else
				break;
		}
		
		//initialise PatternMatcher object with given file 
		PatternMatcher matcher = new PatternMatcher(fileName);

		//loop until user decides to exit
		loop: while(true){
			//ask user what the wish to do
			System.out.println("\n1) Search for String");
			System.out.println("2) Change file");
			System.out.println("3) Exit Program");
			int x = scan.nextInt();

			/* If user enters 1, ask to enter a string and then
			 * search the file for all occurrences of the string
			 * via the PatternMatcher object.
			 * If user enters 2, ask user to enter a file and create
			 * a new PatternMatcher object.
			 * If user enters 3, break out of loop.
			 * Else, do nothing.
			*/
			if(x == 1){
				System.out.println("\nString to be searched for:");
				scan.nextLine();
				String pattern = scan.nextLine();
				if(pattern.length() == 0)
					System.out.println("Invalid input.");
				else
					matcher.find(pattern);
			}else if(x == 2){
				System.out.println("\nNew File:");
				scan.nextLine();
				String newFile = scan.nextLine();
				if(newFile.length() == 0)
					System.out.println("Invalid input.");
				else
					matcher = new PatternMatcher(newFile);
			}else if(x == 3){
				break loop;
			}
		}
	}

}