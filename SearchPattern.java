/**
* @(#)SearchPattern.java
* This class creates a partial match table from a given pattern,
* which is used in searching a piece of text for the pattern.
* Contains an initialiser method
* Includes a method for creating partial match table
* Includes a method for comparing chars to pattern
* Includes a method for printing the partial match table
* Includes a method which returns the length of the patter
* @author Jack Hughes
* @version 2016/7/17
*/

import java.io.*;

public class SearchPattern{

	/*
	* Characters array contains chars in pattern.
	* PartialMatchTable contians indexes which must be gone
	* back to in the case of a character mismatch.
	* Pointer contains index of next char to be compared, if
	* it gets to the end of the array, pattern has been found.
	*/
	private char[] characters;
	private int[] partialMatchTable;
	private int pointer;

	/**
	* Initialiser method.
	* Takes in string and then initialises variables.
	* @param string
	*/
	public SearchPattern(String input){
		//create character array from input string
		this.characters = input.toCharArray();
		//create partial match table
		partialMatchTable = setPartialMatchTable(this.characters);
		//set pointer to initial value of 0
		pointer = 0;
	}

	/**
	* Creates partial match table from pattern
	* @param charArray
	* @return intArray
	*/
	private int[] setPartialMatchTable(char[] array){
		//create int array of same length as char array
		int[] pos = new int[array.length];
		if(pos.length == 0 || pos == null){
			return pos;
		}else{
			//set position of first character to 0.
			pos[0] = 0;

			/* For each position, produce a number which indicates
			*  how far we can move up the pattern in the event of
			*  a mismatch
			*/
			int index = 0;
			for(int i = 1; i < pos.length; i++){
				pos[i] = index;
				if(array[i] == array[index]){
					index++;
				}else{
					index = 0;
				}
			}

			//return partial match table
			return pos;
		}
	}

	/**
	*  Compares given character to current character pointed to by pointer variable.
	*  @param char
	*  @return boolean 
	*/
	public boolean compare(char in){
		/* If character matches, increment the pointer.
		*  Else set pointer to position indicated by partial match table.
		*/
		if(this.characters[this.pointer] == in){
			this.pointer++;
		}else{
			this.pointer = this.partialMatchTable[this.pointer];
		}

		/* If pointer has reached the end of the pattern, return true.
		*  Else, return false.
		*/
		if(this.pointer == this.characters.length){
			this.pointer = 0;
			return true;
		}else{
			return false;
		}
	}

	/**
	*  Prints the pattern and partial match table
	*/
	public void printTable(){
		//print pattern
		for(int i = 0; i < this.characters.length; i++){
			System.out.print(this.characters[i]+"\t");
		}
		System.out.println();
		//print partial match table
		for(int i = 0; i < this.partialMatchTable.length; i++){
			System.out.print(this.partialMatchTable[i]+"\t");
		}
	}

	/**
	* Pattern length getter method
	* @return int
	*/
	public int length(){
		return this.characters.length;
	}

}