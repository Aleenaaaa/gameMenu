import java.util.Scanner;

	public class WelcomeMenu {
		
			// welcome menu method
			public static void run() 
			{

			System.out.println("please enter your name");
			
			String userName = WelcomeMenu.getName(); // this calls a method to scan the users name and allocate it to the variable 'userName'
			
			System.out.println("Hello " + userName + ", welcome to hangman\nwould you like to continue and play?\n");
			System.out.println("please choose from an option below");
			System.out.println("0. continue to Hangman");
			System.out.println("1. exit");
			
			
			//this reads the user input from the welcome menu
			Scanner scanner = new Scanner(System.in); // this reads the user input from the welcome menu
			int choice = scanner.nextInt();
			
			//this piece of code execute actions based on what the use chooses.
			if (choice==1) { // if the user chooses '1' then the program will end. 
				System.exit(0);
			}
			else if (choice == 0) { // if the user chooses '0' then the user will be presented to the main menu.
				try {
					WelcomeMenu.mainMenu();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else  { // if the user inputs anything else, then the program will output this message below and direct the user back to the welcome menu to start again
				System.out.println("\nsorry this is not an option\nPlease try again\n\n\n");
				WelcomeMenu.run();
			}
			}
			
			
			// main menu method 
			public static void mainMenu () throws Exception {
			System.out.println("please enter an option below");
			System.out.println("1. instructions");
			System.out.println("2. play game");
			System.out.println("3. return to welcome menu");
				
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			
			switch (choice)
			{
			case 1: // case 1 is if the user choose 1. instructions. they will be presented with instructions to read through and get familiar with the game.
			
				System.out.println("welcome to the Hangman ");
				System.out.println("\n\n -	The screen will navigate you to choose a level of difficulty and a category. \r\n"
						+ "-	Based on this a word will be chosen, blanks will be presented to you in its place\r\n"
						+ "-	You will be presented with the number of guesses you are allowed and a list of letters you haven’t used.\r\n"
						+ "-	You can then input a letter to guess with\r\n"
						+ "-	If your guess is correct, the letter will be revealed on the screen \r\n"
						+ "-	If your guess is incorrect, you will lose one guess and the letter you have chosen will removed from the list of letter present on screen\r\n"
						+ "-	You win the game by guessing the word/s without running out of guesses\r\n"
						+ "-	If you have 3 or more guesses remaining you can guess the entire word/s in one go by using capital letters to enter your guess\r\n"
						+ "-	If your guess is wrong then you will loose 3 guesses\r\n"
						+ "-	If you enter an invalid guess you will receive a warning \r\n"
						+ "-	If you get 3 warnings you will end up loosing a guess\r\n"
						+ "\n\n");
				
				// this piece of code below outputs the statement below and asks the users whether they would like to return to the welcome menu or the main menu.
				System.out.println("if you would like to return to the Main Menu enter 0. \n If you would like to return to the welcome screen enter 1");
				Scanner scannerOption = new Scanner (System.in);
				int option = scannerOption.nextInt();
				// if the user chooses to go to the main menu they will be directed to that using this method below
						if ( option == 0) { 
							WelcomeMenu.mainMenu();
							}
				// if the user chooses to go to the welcome menu they will be directed to that using this method below
							else if ( option == 1 ) {
							WelcomeMenu.run();
							}	
				// if the user enters an input which is not expected they will receive this message and be redirected to the welcome menu.
							else {
								System.out.println("\n\nthat is an invalid input\nyou will not we directed to the welcome menu\n\n\n");
							WelcomeMenu.run();
							}
							break;
			
			// if the user chooses option 2 in the main menu, they will progress forward with the game by being directed to the difficulty class to choose their preffered level of difficulty 
			case 2: 
				Difficulty.difficultyLevel();
				break;
			
			// option 3 is taking the user back to the beginning by taking them back to the welcome menu
			case 3:
					WelcomeMenu.run();
					
				}
							
				
			}
			
			
			
			
			// this method is a scanner to receive the users name, which is used above in the welcome menu
			public static String getName() {
				Scanner scannername = new Scanner (System.in);
				String name = scannername.nextLine();
				return name;
			}
			
		}



