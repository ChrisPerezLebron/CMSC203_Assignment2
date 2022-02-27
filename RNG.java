/*
 * INCLDUING THIS SINCE I EDITED THIS CLASS! 
 * 
 * Class: CMSC203 CRN 34165
 * Instructor: Dr. Grinberg
 * Description: 
		RNG class has a field count that stores the number of guesses the user puts in. has a method for guess input validation
 * Due: 02/28/22
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Christopher Perez Lebron
*/

import java.util.Random;
import java.util.Scanner;


/**
 * This is the utility class to accompany RandomNumberGuesser
 * It contains static methods to generate a random number,
 * validate the guesses as being between the previous low and high guesses,
 * and maintain the number of guesses.
 * @author ralexander
 */
public class RNG 
{
	
	private static int count=0;
	
	static Scanner scan;
	
	public RNG() 
	{
		count++;
	}
	
	/**
	 * Sets the count to zero
	 */
	public static void resetCount() {
		count = 0;
	}
	
	/**
	 * generates a random integer between 1 and num
	 * @param num 
	 * @return the random number as an integer
	 */
	public static int rand(int num) 
	{
		Random rand = new Random();
		int randInt = rand.nextInt(num) + 1;
		return randInt;
	}
	
	/**
	 * Checks that nextGuess is strictly between lowGuess and highGuess. 
	 * If this is called and input is already valid it will return the original guess is returned.
	 * if this is called and input is invalid the user will retry until 
	 *  	valid input is read. Once read it will return this valid input as an int
	 * @param nextGuess
	 * @param lowGuess
	 * @param highGuess
	 * @return whatever the valid input is. 
	 */
	public static int inputValidation(int nextGuess, int lowGuess, int highGuess)
	{
		Scanner key = new Scanner(System.in);
		
		while (nextGuess >= highGuess || nextGuess <= lowGuess) 
		{
			System.out.print("\n   >>> Guess must be between " + lowGuess + " and " + highGuess +
						   ".  Try again: ");
			
			nextGuess = key.nextInt();
		}
		count++;
		return nextGuess;
	}

	/**
	 * @return an integer, the current value of count
	 */
	public static int getCount() 
	{
		return count;
	}
}