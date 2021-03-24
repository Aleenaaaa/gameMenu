import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Hangman_B {
	private static File secret_word;
	private static Scanner textScanner;
	private static Scanner input;
	private static ArrayList<String> words;
	private static ArrayList<Integer> scores;
	private static char[] textArray;
	private static char[] myAnswers;
	private static String hidden_word;

	public static void run() {
		//this method will run line 137 to 150
		try {
			initialiseGame();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//if replay is true, the the user has decided to play again. if it is false, the user has decided to end the game and it will exit the while loop.
		boolean replay = true;
		while (replay == true)
		{
			
			//this method will run line 153 to 169
			generateSecretWord(); // initialises textArray and myanswers

			//this loop will finish when the game is done, either 0 guesses left or the word is found
			boolean end = false;
			int guesses = 6, warning = 0, MaxWarning = 3, N = 0;
			while(end == false) {
				System.out.println("..........");

				String letter = input.next();

				//checks for valid input. If the user inputs more than 1 character or inputs a number, an error will occur. The user will be given a warning if this happens
				if((letter.length() != 1) || Character.isDigit(letter.charAt(0))) {
					System.out.println("\n" + "Error Input - Try Again");
					warning ++;
					guesses ++;
					//If the user does 3 mistakes then they lose 1 guess.
					if (warning == MaxWarning) {
						guesses --;
						warning = warning -3;
						System.out.println("\n" + "Too many warnings, lose a guess");
					}
				}

				//check if the letter is in the word
				boolean correct = false;
				//this will check what the letters are in the Array
				for(int check = 0; check < textArray.length; check ++) {

					//this will record the answers in myAnswers
					if(letter.charAt(0) == textArray[check]) {
						myAnswers[check] = textArray[check];
						N ++;
						correct = true;
					}
				}

				//if the letter in incorrect, lose a guess
				if(!correct) {
					guesses--;

					System.out.println("Wrong Letter"+ "\n");
				}

				//this will print out the word you need to guess using "_"
				boolean complete = true;
				for(int i = 0; i < myAnswers.length; i++) {
					//the '?' signifies that the letter hasnt been guessed yet so "_" will be placed
					if(myAnswers[i] == '?') {
						System.out.print(" _");
						//complete will be false until the user has guessed all the letters or loses the game
						complete = false;
					}
					//this will print the correct letter on the correct position of "_"
					else {
						System.out.print(" " + myAnswers[i]);
					}
				}

				System.out.println("\n" + "\n" + "Guesses Left: " + guesses);
				System.out.println("Warnings: " + warning);
				UI(guesses);

				//this will check if you have won or lost yet

				if(complete == true) {
					System.out.println("\n" + "Well done, You Win!");
					end = true;
				}

				if(guesses <=0) {
					System.out.println("\n" + "You are out of guesses, You Lose");
					end = true;
				}
			}

			System.out.println("The word is "+ "*"+hidden_word+"*");
			System.out.println("\n" + "Your Score is " + N * guesses);
			System.out.print("Scoreboard: ");
			scores.add(N * guesses);
			Collections.sort(scores);
			
			for(int i = 0; i < scores.size(); i ++) {				
				System.out.print(" " + scores.get(i) + " ,");
			}			
			System.out.println("\n" + "\n" + "do you want to play again?");

			boolean NOTyesno = true;

			while (NOTyesno == true) {
				String playagain = input.next().toLowerCase();

				//this will turn any input by the user into lowercase
				String[] allowedAnsNo = new String[] {"no", "nope", "na" , "n"};
				String[] allowedAns = new String[] {"yes", "y", "yeah", "ok", "ye" , "k" , "perhaps"};
				if (Arrays.asList(allowedAns).contains(playagain)) { 
					replay = true;
					NOTyesno = false; 
				} else if (Arrays.asList(allowedAnsNo).contains(playagain)) {
					replay = false; 
					NOTyesno = false;  
				} else {
					System.out.println("\n" + "Please input yes or no. Do you want to play again?");
				}

			}
		}
		System.exit(0);
	}

	public static void initialiseGame() throws FileNotFoundException {

		System.out.println("Welcome to hangman!");

		//this finds the file you want and sets a variable to it
		secret_word = new File("C:\\Users\\Alawi\\eclipse-workspace\\Hangman\\src\\Secret Words.txt");

		//this reads the file
		textScanner = new Scanner(secret_word);
		//this allows the user to put in an input
		input = new Scanner(System.in);

		words = new ArrayList<>();
		scores = new ArrayList<>();
	}

	private static void generateSecretWord() {

		//the text scanner will go line by line in the file, taking the string and adding it to the words ArrayList. Once it reaches the final line it will end
		while(textScanner.hasNext()) {
			words.add(textScanner.nextLine());			
		}

		//this gets a random word from the file by getting a random line number. So number 0 is line 1 and it will take the first word from the list
		hidden_word = words.get((int)(Math.random() * words.size()));
		//this turns the secret word into a charArray. This will turn the string into single characters which is needed for a hangman game
		textArray = hidden_word.toCharArray();

		//this charArray records the answers
		myAnswers = new char[textArray.length];
		//this will initilise the answers with ? so there is no empty space.
		for(int i = 0; i <textArray.length; i++) {
			myAnswers[i] = '?';
		}
	}

	public static void UI(int guesses) {

		if(guesses == 6) {
			System.out.println("\n" + "|----------");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");

		}
		else if(guesses == 5) {
			System.out.println("\n" + "|----------");
			System.out.println("|    O");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");

		}
		else if(guesses == 4) {
			System.out.println("\n" + "|----------");
			System.out.println("|    O");
			System.out.println("|    |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");

		}
		else if(guesses == 3) {
			System.out.println("\n" + "|----------");
			System.out.println("|    O");
			System.out.println("|   -|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");

		}
		else if(guesses == 2) {
			System.out.println("\n" + "|----------");
			System.out.println("|    O");
			System.out.println("|   -|-");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");

		}
		else if(guesses == 1) {
			System.out.println("\n" + "|----------");
			System.out.println("|    O");
			System.out.println("|   -|-");
			System.out.println("|   / ");
			System.out.println("|");
			System.out.println("|");

		}
		else{
			System.out.println("\n" + "|----------");
			System.out.println("|    O");
			System.out.println("|   -|-");
			System.out.println("|   | |");
			System.out.println("|");
			System.out.println("|");

		}

	}
}
