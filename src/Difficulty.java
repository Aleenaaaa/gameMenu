import java.util.Scanner;

public class Difficulty {

	private static final int Integer = 0;

	public static void difficultyLevel() throws Exception // this allows the user to choose difficulty level they would like to play in 
	{
		// this outputs the menu to ask the user to choose the difficulty level
		System.out.println("\nYou can now choose a level of difficulty you would like to play in\nPlease enter the corresponding number related to the level of difficulty you'd like to play");
		System.out.println("\n1. easy\n2. medium\n3. hard");
		Scanner difficulty = new Scanner ( System.in );
		int level = difficulty.nextInt();
		
		// whatever the user chooses, one of the options will be outputted.
		switch (level)
		{
	
		case 1:
			System.out.println("\ndifficulty level chosen: EASY");
			System.out.println("press 1 to continue \nor press any other numberkey to return to the difficulty menu");
			Difficulty.finalOption();
		case 2:
			System.out.println("\ndifficulty level chosen: MEDIUM");
			System.out.println("press 1 to continue \nor press any other number key to return to the difficulty menu");
			Difficulty.finalOption();
		case 3:
			System.out.println("\ndifficulty level chosen: HARD");
			System.out.println("press 1 to continue, \nor press any other number key to return to the difficulty menu");
			Difficulty.finalOption();
		}
		}
		
		// this gets the user input to pass to finalOption. 
		public static int optionDifficulty() { // this gets the users options for difficulty
			Scanner correct = new Scanner (System.in);
			int optionDiff = correct.nextInt();
			return optionDiff;
		}
		
		// the finalOption is the redirecting the user to correct place
		public static void finalOption () throws Exception {
			int optionFinal = Difficulty.optionDifficulty();
			
			if (optionFinal == 1) {
			Category.category();
			}
			else if (optionFinal != 1) {
				Difficulty.difficultyLevel();
			}
			else { 
				Difficulty.difficultyLevel();
			}
	
}
}
