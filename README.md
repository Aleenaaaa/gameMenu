# gameMenu

import java.util.Scanner;

public class StartMenu {

	public static void main(String[] args) {

		System.out.println("Welcome to the games program made by Green Group 40!");
		System.out.println("please enter your name ");
		Scanner user = new Scanner(System.in);
		String name = user.next();
		
		
		System.out.println("\n\n\n Hello, " + name );
		
		System.out.println("These are the game options you can choose from /n please enter the correspeoding number below");
		System.out.println(" 1. Hangman A \n 2. Hangman B \n 3. Snakes and ladder A \n 4. Snakes and ladder B \n 5. Mastermind A \n 6. Mastermind B \n 7. Battleship A \n 8. Battleship B \n 9. start again");
		
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		
		
		switch (choice)
		{
		 
		case 1:
			// Difficulty.difficultyLevel();
			break;
			
		case 2:
			// hangman B 
			break;
		
		case 3:
			// snakes and ladder A
			break;
			
		case 4:
			// snakes and ladder B
			break;
			
		case 5: 
			// mastermind A 
			break;
			
		case 6:
			// mastermind B
			break;
		
		case 7:
			// battleship A 
			break;
			
		case 8: 
			// battleship B
			break;
		
		case 9: 
			StartMenu.main(args);
			break;
			

			
		
	}

	}
}
