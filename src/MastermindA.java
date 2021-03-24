

import java.io.*;
import java.util.Random;
public class MastermindA {
	
		static BufferedReader stdin;
		static int [] computernumArray;
		static int [][] userguessArray;
		private static Random producers;
		private static int num0, num1, num2, num3;
		private static int rightPosition, wrongPosition;
		static boolean gotQuitCommand;
		
		public static void run()
		{
			computernumArray = new int[4]; //This will creates an array that will hold the computer's number
			
			stdin = new BufferedReader( new InputStreamReader( System.in ));
			setGenerator(new Random());

			gameInstructions(); // gives user instructions
			try {
				menu();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // see if user wants to quit or play

			// This loop is used to play a game everytime
			while (!gotQuitCommand) {
				System.out.println("\nThe computer has thought of a four colours. Make your first guess. \n");
				
				randomNumber(); 
			
				computernumArray[0] = num0;
				computernumArray[1] = num1;
				computernumArray[2] = num2;
				computernumArray[3] = num3;
							
				try {
					guessMenu();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
							
				try {
					menu();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // see if user wants to quit or continue playing
			}
			
			System.out.println("Type enter to end");
			try {
				System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}



		// random numbers
		public static void randomNumber()
		{
			Random generator = new Random();
			num0 = Math.abs(generator.nextInt()) % 10;
			num1 = Math.abs(generator.nextInt()) % 10;
			while (num1 == num0) 								// all numbers are different from each other
				num1 = Math.abs(generator.nextInt()) % 10;
			num2 = Math.abs(generator.nextInt()) % 10;
			while (num2 == num1 || num2 == num0)
				num2 = Math.abs(generator.nextInt()) % 10;
			num3 = Math.abs(generator.nextInt()) % 10;
			while (num3 == num2 || num3 == num1 || num3 == num0)
				num3 = Math.abs(generator.nextInt()) % 10;
		}

		
		public static void menu() throws IOException 
		{
			System.out.println ("Enter p to play the game, i to see the instructions, or q to quit the game.");
			char userInput = 'p';
			String lineOfInput = stdin.readLine();
			userInput = lineOfInput.charAt(0);
			if (userInput == 'q') {
				gotQuitCommand = true;
			} else {
				gotQuitCommand = false;
			}
			if (userInput == 'i') {
				gameInstructions();
				menu();
			}
		}
		// This prints out the instruction
			public static void gameInstructions()
			{
				System.out.println("Instructions for the Mastermind game:\n");
				System.out.println("For each round, you will need to guess a random number with a four different digits.\n" + 
								   "Each digit has its own colour, as 0= Pink 1= Red, 2= Blue, 3= Green, 4= Orange 5= Yellow.\n" + 
								   "The player need to to enter on digit of the number at a time. The digits\n" +
								   "must be between 0 and 5. Each digit needs to be different from the other digits\n" +
								   "the player have entered previously. If you enter the same digit you will be given "+
								   "a chance to enter a different digit again. After you finish and you entered your guess,\n" +
								   "you will be given the results. The result is shown to you as followed:\n" +
								   "IThe first 4 numbers are digits of your guess. The fifth number is how many\n" +
								   "digits are correct and in the right places, The sixth number is how many digits are\n" +
								   "correct but in the wrong places.\n");
			}
			
			// This prints out the array of all guesses and results, current and previous 
			public static void printOutArray(int [][] array, int count)
			{
				System.out.println("Results:");
				
				System.out.println();
				for (int row=0; row<(count+1); row++)
				{
					for (int col=0; col<(userguessArray[row].length-2); col++)
						System.out.print(userguessArray[row][col]+" ");
					System.out.print("\t");
					for (int col2=(userguessArray[row].length-2); col2<(userguessArray[row].length); col2++) {
						System.out.print(userguessArray[row][col2]+" ");
					}
					System.out.println();
				}
				System.out.println();
			}

		
		// Main body  
		public static void guessMenu() throws IOException
		{
			int guess0, guess1, guess2, guess3;
			int count = 0;
			int MAX = 12; //This is the gusses
			userguessArray = new int[MAX][6]; // this is the array that holds the user's guesses 
			while (rightPosition != 4) { 
				guess0 = 10;
				while (guess0 > 5) { //This makes sure that the gusses are between 0 to 5
					System.out.print("Enter your first digit: ");
					String guessString0 = stdin.readLine();
					guess0 = Integer.parseInt(guessString0);
				}
			
				guess1 = guess0; //This is used to make sure that the guesses are different
				while (guess1 == guess0 || guess1 > 5) {
					System.out.print("Enter your second digit: ");	
					String guessString1 = stdin.readLine();
					guess1 = Integer.parseInt(guessString1);
				}
			
				guess2 = guess1;
				while (guess2 == guess1 || guess2 == guess0 || guess2 > 5) {
					System.out.print("Enter your third digit: ");	
					String guessString2 = stdin.readLine();
					guess2 = Integer.parseInt(guessString2);
				}
			
				guess3 = guess2;
				while (guess3 == guess2 || guess3 == guess1 || guess3 == guess0 || guess3 > 5) {
					System.out.print("Enter your fourth digit: ");	
					String guessString3 = stdin.readLine();
					guess3 = Integer.parseInt(guessString3);
				}

				System.out.println();
			
				//user's guess is produced into an array
				userguessArray[count][0] = guess0;
				userguessArray[count][1] = guess1;
				userguessArray[count][2] = guess2;
				userguessArray[count][3] = guess3;

				rightPosition = 0; //ccorrect places:
				for (int i = 0; i < computernumArray.length; i++)
					if (userguessArray[count][i] == computernumArray[i])
						rightPosition++;
				
				wrongPosition = 0; // incorrect places:
				for (int i = 0; i < computernumArray.length; i++){
					if (userguessArray[count][i] == computernumArray[(i+1)%4])
						wrongPosition++;
					if (userguessArray[count][i] == computernumArray[(i+2)%4])
						wrongPosition++;
					if (userguessArray[count][i] == computernumArray[(i+3)%4])
						wrongPosition++;
				}
		
				
				userguessArray[count][4] = rightPosition;
				userguessArray[count][5] = wrongPosition;
				
				printOutArray(userguessArray, count);

				
				count++; //Number of gusses
			}
			System.out.println("Congratulations, You Win. \001");
			System.out.println("You guessed the number after " + count + " guesses.\n");
			rightPosition = 0;
			wrongPosition = 0;
			count = 0;
		}
		public static Random getGenerator() {
			return producers;
		}

		public static void setGenerator(Random generator) {
			MastermindA.producers = generator;
		}

		public static Random getProducers() {
			return producers;
		}

		public static void setProducers(Random producers) {
			MastermindA.producers = producers;
		}

		public static int getWrongPosition() {
			return wrongPosition;
		}

		public static void setWrongPosition(int wrongPosition) {
			MastermindA.wrongPosition = wrongPosition;
		}

	}

