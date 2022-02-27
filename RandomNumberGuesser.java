/*
 * Class: CMSC203 CRN 34165
 * Instructor: Dr. Grinberg
 * Description: 
		RandomNumberGuesser class:
			Program allows user to play a guessing game between 0 and whatever number they choose.
 *  		For each guess the interval gets smaller and user is told if guess was high or low. 
 * 			Once user has won they have the option to play again with whatever range they would like. 
 * Due: 02/28/22
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Christopher Perez Lebron
*/

import java.util.Scanner;


/*
 * Program allows user to play a guessing game between 0 and whatever number they choose.
 *  For each guess the interval gets smaller and user is told if guess was high or low. 
 * Once user has won they have the option to play again with whatever range they would like. 
 */
public class RandomNumberGuesser
{
	public static void main(String[] args)
	{
		int randNum,  //holds random number
			guessRange, //holds the value specified by the user as the guess range
			lowGuess, //holds minimum guess
			highGuess,//holds max guess
			nextGuess,//holds current guess
			guessCompare, //holds 1 if nextGuess is greater than randNum or -1 if nextGuess is less than randNum and 0 if they are equal
			runNumber = 1;//holds the current number of runs
		final int MINIMUM_GUESS_RANGE = 4; 
		String repeat; 
		
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Lets do things a bit differently....");
		
		do
		{
			System.out.print("What is the maximum value you would like to use for this game (minimum is 4): ");
			guessRange = keyboard.nextInt();
			
			//guessRange input validation
			guessRange = validateGuessRange(guessRange, MINIMUM_GUESS_RANGE);
			
			
			randNum = RNG.rand((guessRange-1)); //random number can be between 1 and (guessRange - 1)
			highGuess = guessRange; //guesses must be less than guessRange 
			lowGuess = 0; //0 
			RNG.resetCount();
			
			//print header using runNumber
			System.out.println("\n\n=============== run " + runNumber + " (between 0 and "
								+ guessRange + ") ===============\n\n");
			
			System.out.print("Enter your first guess between " + lowGuess + " and " + highGuess + ": ");
			nextGuess = keyboard.nextInt();
			
			
			//validate next guess
			nextGuess = RNG.inputValidation(nextGuess, lowGuess, highGuess);
			
			System.out.println("Number of guesses is " + RNG.getCount());
			
			//decide if guess is high low or equal to random numner
			guessCompare = guessCompareToRand(nextGuess, randNum);
		
			//adjust guessing range
			if (guessCompare == 1)
				highGuess = nextGuess;
			else if (guessCompare == -1)
				lowGuess = nextGuess;
			
			while(nextGuess != randNum)
			{
				System.out.print("Enter your next guess between " + lowGuess + 
									" and " + highGuess + ": "); 
				
				nextGuess = keyboard.nextInt();
				
		
				//validate next guess
				nextGuess = RNG.inputValidation(nextGuess, lowGuess, highGuess);
				
				System.out.println("Number of guesses is " + RNG.getCount());
				
				//decide if guess is high low or equal to random numner
				guessCompare = guessCompareToRand(nextGuess, randNum);
				
				//adjust guessing range
				if (guessCompare == 1) 
					highGuess = nextGuess;
				else if (guessCompare == -1)
					lowGuess = nextGuess;
			}
			
			System.out.println("\n\n\n CONGRATS: You won!!!!\n\n\n");
			
			
			//Assign a new scanner Obj to keyboard (\
			//this seemed like the best option.
			// while loop using hasNext method would just get stuck as it will always have a next value to read
			//a for loop would require counting every time a int is entered creating unnecessary lines of code through out the program
			//this option is the only technique i could get to work with the tools I know. (besides turning the repeat yes value into a integer so \n characters don't bother it)
			keyboard = new Scanner(System.in);
			
			System.out.print("would you like to play again?");
			repeat = keyboard.nextLine();
			
			runNumber++;
			
			
			
			/*
			System.out.println("next guess value is " + nextGuess);
			System.out.println("RNG guess count equals " + RNG.getCount());
			System.out.println("Random number equals " + randNum);
			System.out.println("lowGuess equals " + lowGuess);
			System.out.println("highGuess equals " + highGuess);
			/*
			use this for testing
			*/
		} while (repeat.equalsIgnoreCase("yes"));	
		
		keyboard.close();
		
		System.out.print("\n\n\n\n PROGRAMMER: Christopher Perez Lebron");
	}
	
	
	/**
	 * Compares guess and random. 
	 * @param guess
	 * @param random
	 * @return 1 if guess is greater, -1 if guess is less, 0 if they are equal
	 */
	public static int guessCompareToRand(int guess, int random)
	{
		if(guess > random)
		{
			System.out.println("your guess is too high!\n");
			return 1;
		}
		else if (guess < random)
		{
			System.out.println("your guess is too low!\n");
			return -1;
		}
		//only other condition is equals so it gets 0
		return 0;
	}
	/**
	 * 	validates guessRange to be greater than or equal minimum range
	 *  @param rangeInput stores the user input for comparison
	 *  @param MIN_RANGE stores the minimum range 
	 *  @return valid guessRange 
	 */
	public static int validateGuessRange(int rangeInput, final int MIN_RANGE)
	{
		Scanner key = new Scanner(System.in);
		while (rangeInput < MIN_RANGE)
		{
			System.out.println("\n   >>> ERROR: maximum value must be 4 or greater");
			System.out.print("Try again: ");
			rangeInput = key.nextInt();
		}
		return rangeInput;
	}
}