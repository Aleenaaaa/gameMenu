
public class HangmanHard {


public static void hardWords() {
	int random = (int) ( Math.random()*11); // // random method to choose a number between 0-10, which will reterieve the corresponding element in the correct array
	
	// food + hard combination
	String [] foodHard;
	foodHard = new String [10];
			
	foodHard [0] = "quesadillas";
	foodHard [1] = "protein";
	foodHard [2] = "carbohydrates";
	foodHard [3] = "fajitas";
	foodHard [4] = "tacos";
	foodHard [5] = "scrambled eggs";
	foodHard [6] = "pancakes";
	foodHard [7] = "nutella crepes";
	foodHard [8] = "jacket potato";
	foodHard [9] = "enchiladas";
	
	String foodHardWord = foodHard[random]; // random word from foodHard category

// random + hard combination
	String [] randomHard;
	randomHard = new String [10];
	
	randomHard [0] = "kilogram";
	randomHard [1] = "observatory";
	randomHard [2] = "exponential";
	randomHard [3] = "philospher";
	randomHard [4] = "tournament";
	randomHard [5] = "snowball";
	randomHard [6] = "christmas";
	randomHard [7] = "diffusion";
	randomHard [8] = "qwerty";
	randomHard [9] = "evaporation";
	
	String randomHardWord = randomHard[random]; // random word from randomHard category
	
// animal + hard combination 
	String [] animalHard; 
	animalHard = new String [10];
	
	animalHard [0] = "squirrel";
	animalHard [1] = "elephant";
	animalHard [2] = "racoon";
	animalHard [3] = "kangaroo";
	animalHard [4] = "hedgehog";
	animalHard [5] = "koala";
	animalHard [6] = "french bulldog";
	animalHard [7] = "butterfly";
	animalHard [8] = "porcupine";
	animalHard [9] = "eagle";
	
	String animalHardWord = animalHard[random]; // random word from animalHard category

// celebrities + hard combination 	
	String [] celebritiesHard;
	celebritiesHard = new String [10];
	
	celebritiesHard [0] = "jimmy fallon";
	celebritiesHard [1] = "gigi hadid";
	celebritiesHard [2] = "taylor swift";
	celebritiesHard [3] = "zendeya";
	celebritiesHard [4] = "kate and william";
	celebritiesHard [5] = "kim kardashian west";
	celebritiesHard [6] = "priyanka chopra";
	celebritiesHard [7] = "will smith";
	celebritiesHard [8] = "ronaldo";
	celebritiesHard [9] = "zayn malik";
	
	String celebritiesHardWord = celebritiesHard[random]; // random word from celebritiesHard category

// countries + hard combination 
	String [] countriesHard;
	countriesHard = new String [10];
	
	countriesHard [0] = "central african republic";
	countriesHard [0] = "united kingdom";
	countriesHard [0] = "united arab emirates";
	countriesHard [0] = "united states america";
	countriesHard [0] = "venezuela";
	countriesHard [0] = "zimbabwe";
	countriesHard [0] = "phillipines";
	countriesHard [0] = "new zealand";
	countriesHard [0] = "micronesia";
	countriesHard [0] = "marshall islands"; 
	
	String countriesHardWord = countriesHard[random]; // random word from countriesHard category
}

}
