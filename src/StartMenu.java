import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class StartMenu {

	public static void main(String[] args) {

		System.out.println("Welcome to the games program made by Green Group 40!");
		System.out.println("please enter your name ");
		Scanner user = new Scanner(System.in);
		String name = user.next();
		
		
		System.out.println("\n\n\n Hello, " + name );
		
		System.out.println("These are the game options you can choose from /n please enter the correspeoding number below");
		System.out.println(" 1. Hangman A \n 2. Hangman B \n 3. Snakes and ladder A \n 4. Snakes and ladder B \n 5. Mastermind  \n 6. Battleship   \n 7. start again");
		
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		
		
		switch (choice)
		{
		 
		case 1:
			WelcomeMenu.run();
			break;
			
		case 2:
			Hangman_B.run(); 
			break;
		
		case 3:
			TheGame.run();
			break;
			
		case 4:
			// snakes and ladder B
			SnakesAndLadderB game= new SnakesAndLadderB();
			game.run();
			break;
			
		case 5: 
			MastermindA.run();
			break;
		
		case 6:
			Gunship.run();
			break;
			
	
		case 7: 
			StartMenu.main(args);
			break;
			

			
		
	}//close switch
	
	}//close main
	
}//close StartMenu
