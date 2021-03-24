
public class HangmanEasy {

	
	

	
	
public static void easyWords() {
	
int random = (int) (Math.random()* 11); // random method to choose a number between 0-10, which will reterieve the corresponding element in the correct array

// food + easy combination
String [] foodEasy;
foodEasy = new String [10];

foodEasy[0] = "breads";
foodEasy[1] = "rice";
foodEasy[2] = "pasta";
foodEasy[3] = "fruit";
foodEasy[4] = "chicken";
foodEasy[5] = "nuts";
foodEasy[6] = "breakfast";
foodEasy[7] = "fish and chips";
foodEasy[8] = "sausages"; 
foodEasy[9] = "beans";

String foodEasyWord = foodEasy[random]; // random word from foodEasy category

// random + easy combination 
String [] randomEasy;
randomEasy = new String [10];

randomEasy[0] = "message"; 
randomEasy[1] = "house";
randomEasy[2] = "dogs";
randomEasy[3] = "hello world";
randomEasy[4] = "swing";
randomEasy[5] = "ghost";
randomEasy[6] = "ice cream cone";
randomEasy[7] = "toothbrush";
randomEasy[8] = "camera";
randomEasy[9] = "friend";

String randomEasyWord = randomEasy[random]; // random word from randomEasy category

// animal + easy combination

String [] animalEasy;
animalEasy = new String [10];

animalEasy [0] = "cat";
animalEasy [1] = "dog";
animalEasy [2] = "pig";
animalEasy [3] = "shark";
animalEasy [4] = "duck";
animalEasy [5] = "fish";
animalEasy [6] = "fox";
animalEasy [7] = "snake";
animalEasy [8] = "lizard";
animalEasy [9] = "horse";

String animalEasyWord = animalEasy[random]; // random word from animalEasy category

// celebrities + easy combination  

String [] celebritiesEasy;
celebritiesEasy = new String [10];

celebritiesEasy [0] = "adele";
celebritiesEasy [1] = "cardi b";
celebritiesEasy [2] = "kendall";
celebritiesEasy [3] = "Kim";
celebritiesEasy [4] = "miley";
celebritiesEasy [5] = "demi";
celebritiesEasy [6] = "selena";
celebritiesEasy [7] = "drake";
celebritiesEasy [8] = "nick";
celebritiesEasy [9] = "bella";

String celebritiesEasyWord = celebritiesEasy[random]; // random word from celebritiesEasy category

// countries + easy combination 		
String [] countriesEasy;
countriesEasy = new String[10];

countriesEasy[0] = "uk";
countriesEasy[1] = "usa";
countriesEasy[2] = "uae";
countriesEasy[3] = "peru";
countriesEasy[4] = "morocco";
countriesEasy[5] = "kenya";
countriesEasy[6] = "japan";
countriesEasy[7] = "italy";
countriesEasy[8] = "india";
countriesEasy[9] = "greece"; 

String countriesEasyWord = countriesEasy[random]; // random word from countriesEasy category


}
}
