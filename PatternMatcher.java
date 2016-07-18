/**
* @(#)PatternMatcher.java
* This class is used for searching a file for a given pattern.
* It includes an initialiser method which takes in a file name.
* It includes a method which takes in a string and the scans the file.
* @author Jack Hughes
* @version 1.0 2016/7/17
*/

import java.io.*;

public class PatternMatcher{

	//each slot of array holds one line of file
	private String[] contents;

	/**
	* Initialiser method.
	* Takes in file name, then reads in file and fills array
	* with it's contents
	* @param string
	*/
	public PatternMatcher(String fileName) throws Exception{
		FileIO io = new FileIO();
		this.contents = io.load(fileName);
	}

	/**
	* Searches file for given string
	* @param string
	*/
	public void find(String input){
		//Initialises SearchPattern object with given string
		SearchPattern pattern = new SearchPattern(input);

		//go through lines of file
		for(int i = 0; i < this.contents.length; i++){
			//scan through current line
			for(int j = 0; j < this.contents[i].length(); j++){
				/*
				* compare current char to pattern.
				* if method returns true, pattern has been found...
				* in which case print out location of pattern.
				*/
				if(pattern.compare(this.contents[i].charAt(j))){
					System.out.println("Pattern '"+input+"' found at:\tLine "+(i+1)+", Characters "+(j+2-pattern.length())+" - "+(j+1));
				}
			}
		}
	}

}