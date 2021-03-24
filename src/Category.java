import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class Category {


	public static void category() throws Exception {
		//this outputs the menu for picking a category for the word to be chosen in.
		System.out.println("\n\n\nyou can now select a category from below to play Hangman in\nPlease select an option using your keyboard");
		System.out.println("\n1.Random\n2.Countries\n3.Celebrities\n4.Food\n5.Animal"); // there is a total of 5 categories 
		Scanner category = new Scanner ( System.in ); // the user input will be gathered here 
		int catChoice = category.nextInt();
		
		switch (catChoice) // depending on the what the user chooses, they will be entered into one of these cases.
		{
		//in each of these cases, once the user has entered an option, they will be be presneted back with the option they have chose
		// they will need to confirm if its true and they want to carry on with that option 
		case 1:
		System.out.println("Category choice chosen: RANDOM");
		System.out.println("is this true?  (t/f)");
		
		Category.trueOrFalse();
		
		case 2:
		System.out.println("Category choice chosen: COUNTRIES");
		System.out.println("is this true?  (T/F)");
			
		Category.trueOrFalse();
			
		case 3:
		System.out.println("Category choice chosen: CELEBRITIES");
		System.out.println("is this true?  (T/F)");
		
		Category.trueOrFalse();
		
		case 4:
		System.out.println("Category choice chosen: FOOD");
		System.out.println("is this true?  (T/F)");
		
		Category.trueOrFalse();
			
		case 5:
		System.out.println("Category choice chosen: ANIMAL");
		System.out.println("is this true?  (T/F)");
		
		Category.trueOrFalse();
	
		 
				
			}
		
		}
		
	// this method is taking the user input for the category they want.
		public static int optionCat() { 
			Scanner correct1 = new Scanner (System.in);
			int optionCat = correct1.nextInt();
			return optionCat;
			
		}
		
		
		// this method is used if and only if the user selects true for the category they want to proceed with
		// once they have confirmed they are happy to proceed, they will be directed to the corresponding hangman game.
		public static void finalCat () throws Exception {
		
			//Category.optionCat();
			// int catOption = Category.optionCat();
		
				if (optioncategory() == 1 ) {
							 if(Difficulty.optionDifficulty() == 1) {
								
								 
							}
							 else if (Difficulty.optionDifficulty() == 2) {
								 
							}
						
							 else if (Difficulty.optionDifficulty() == 3) {
								
							}
							
				}
				 else if (optioncategory() == 2) {
						if (Difficulty.optionDifficulty() == 1) {
					
						}
						else if (Difficulty.optionDifficulty() == 2) {
						
						}
						else if (Difficulty.optionDifficulty() == 3) {
						
						}
						
				}
				else if (optioncategory() == 3) {
						if (Difficulty.optionDifficulty() == 1) {
						
						}
						else if (Difficulty.optionDifficulty() == 2) {
					
						}
						else if (Difficulty.optionDifficulty() == 3) {
						
						}
						
				}
				else if (optioncategory() == 4) {
						if (Difficulty.optionDifficulty() == 1) {
						
						}
						else if (Difficulty.optionDifficulty() == 2) {
						
						}
						else if (Difficulty.optionDifficulty() == 3) {
						
						}
				}
				else if (optioncategory() == 5) {
						if (Difficulty.optionDifficulty() == 1) {
						
						}
						else if (Difficulty.optionDifficulty() == 2) {
						
						}
						else if (Difficulty.optionDifficulty() == 3) {
						
						}
					
				}
				else {
					System.out.println("\nsorry please try again! we dont support that Category\n");
					Difficulty.difficultyLevel();
					
						
				
					
				} 
		}
		
		
		private static int optioncategory() {
			// TODO Auto-generated method stub
			return 0;
		}

		public static void trueOrFalse() throws Exception {
			Scanner trueOrFalse = new Scanner (System.in);
			String tf = trueOrFalse.nextLine();
			
			if (tf == "true" + "t" + "T") 
			{
			
			Category.finalCat();
			Category.finalCat();
			}

			else if (tf != "false" + "f" + "F" )
			{
				Category.category();
			}
			
			else 	
			{
				Category.category();
			}
		}


}