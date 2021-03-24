import java.util.Scanner;



public class HangmanMedium {
		


	public static void hangmanFood() throws Exception {
		System.out.println("starting game");
		int maxIncorrectGuesses = 10;
		int remainingguesses = maxIncorrectGuesses;
		Scanner scanner = new Scanner(System.in);
		
	
		while (remainingguesses > 0) {
			System.out.println("remaining guesses: " + remainingguesses);
		}
		
		for (int i = 0; i < remainingguesses; i++) {
			System.out.println("0");
		}
		
		String input = scanner.nextLine();
		System.out.println();
		System.out.println("input:" + input);
		
		char guess = input.charAt(0);
		
	}

	

public static void foodMediumWords() {
	int random = (int) (Math.random() * 11); // random method to choose a number between 0-10, which will reterieve the corresponding element in the correct array
	
	//food + medium combination
	String [] foodMedium;
	foodMedium = new String[10]; 
	
	foodMedium[0] = "burgers";
	foodMedium[1] = "kebabs"; 
	foodMedium[2] = "salads";
	foodMedium[3] = "lettuce"; 
	foodMedium[4] = "bolognese";
	foodMedium[5] = "spagetti";
	foodMedium[6] = "hotdogs"; 
	foodMedium[7] = "mcdonalds";
	foodMedium[8] = "nuggets";
	foodMedium[9] = "lasanga";

	String foodMediumWord = foodMedium[random];// random word from foodMedium category
}

public static void randomMediumWords() {
	int random = (int) (Math.random() * 11); // random method to choose a number between 0-10, which will reterieve the corresponding element in the correct array
	
// random + medium combination
	String [] randomMedium;
	randomMedium = new String [10];
	
	randomMedium [0] = "face mask";
	randomMedium [0] = "thunderstorm";
	randomMedium [0] = "exhale";
	randomMedium [0] = "restaurant";
	randomMedium [0] = "pizza hut";
	randomMedium [0] = "formula";
	randomMedium [0] = "graduation";
	randomMedium [0] = "afternoon";
	randomMedium [0] = "football";
	randomMedium [0] = "supermarket"; 
	
	String randomMediumWord = randomMedium[random];// random word from randomMedium category
}


public static void animalMediumWords() {
	int random = (int) (Math.random() * 11); // random method to choose a number between 0-10, which will reterieve the corresponding element in the correct array
	
// animal + medium combination	
	String [] animalMedium;
	animalMedium = new String [10];
	

	animalMedium [0] = "parrot";
	animalMedium [1] = "lion";
	animalMedium [2] = "giraffe";
	animalMedium [3] = "chipmunk";
	animalMedium [4] = "mouse";
	animalMedium [5] = "rabbit";
	animalMedium [6] = "zebra";
	animalMedium [7] = "penguin";
	animalMedium [8] = "panda";
	animalMedium [9] = "cheetah";
	
	String animalMediumWord = animalMedium[random];// random word from animalMedium category
}

public static void celebritiesMediumWords() {
	int random = (int) (Math.random() * 11); // random method to choose a number between 0-10, which will reterieve the corresponding element in the correct array
	
// celebrities + medium combination 	
	String [] celebritiesMedium;
	celebritiesMedium = new String [10];
	
	celebritiesMedium [0] = "lil wayne";
	celebritiesMedium [1] = "nicki minaj";
	celebritiesMedium [2] = "amy schumer";
	celebritiesMedium [3] = "will smith";
	celebritiesMedium [4] = "jay z";
	celebritiesMedium [5] = "usher";
	celebritiesMedium [6] = "britney";
	celebritiesMedium [7] = "lorde";
	celebritiesMedium [8] = "jessie j";
	celebritiesMedium [9] = "meghan and harry";
	
	String celebritiesMediumWord = celebritiesMedium[random]; // random word from celebritiesMedium category
}

public static void countriesMediumWords() {
	int random = (int) (Math.random() * 11); // random method to choose a number between 0-10, which will reterieve the corresponding element in the correct array
	
// countries + medium combination	
	String [] countriesMedium; 
	countriesMedium = new String [10];
	
	countriesMedium [0] = "germany";
	countriesMedium [1] = "finland";
	countriesMedium [2] = "jordan";
	countriesMedium [3] = "mongolia";
	countriesMedium [4] = "nepal";
	countriesMedium [5] = "portugal";
	countriesMedium [6] = "uganda";
	countriesMedium [7] = "ukraine";
	countriesMedium [8] = "zambia";
	countriesMedium [9] = "haiti";
	
	String countriesMediumWord =  countriesMedium[random]; // random word from counriesMedium category
}
}