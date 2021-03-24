public class Gamer {             //This is the class where I describe the player's attribute
	int newposition;
	String name;
	
	public Gamer(String n) {              //This is the constructor where its takes the name of the player as an arguement and initalise the player instance to the starting position
		newposition =0;
		name= n;
	}
	
	public int playermoves(int n ) {            //This a method where its takes an integer value of n as an arguement and return the final position of the player after moving.
		int currentposition = newposition;
		newposition = newposition +n;
		if(newposition>100) {
			System.out.println("Player ["+name+"] rolled a ["+n+"] and went beyond 100.");       //This if statement is used to prevent the player from exceeding 100.
			newposition=currentposition;
		}
		else {
			System.out.println("Player ["+name+"] has rolled the number ["+n+"] and moved from ["+currentposition+"] to ["+newposition+"]");  //This else statement is used when the player position is less than 100.
			                                                                                                                                  // The player will move from its current position to its new position.
		}
		return newposition;
		
	}
	public int playerlandsLadder(Ladder l) {                        //This method is called upon if ever the player lands on a ladder and return its final position
		int currentposition	 = newposition;
		newposition=l.end;                                           //This will make the player's new position at the end of the ladder object
		 
		if(newposition<100) {
			System.out.println("Player ["+name+"] reached a ladder and moved from ["+currentposition+"] to ["+newposition+"]");   //This makes it that the end of the ladder cannot surpass the 100 mark
		}
		return newposition;
		
	}
	public int playerlandsSnake(Snake s) {                                 //This method is called upon if ever the player lands on a snake and return its final position.
		int currentposition = newposition;
		newposition = s.end;                                               //This will make the player's new position at the end of the snake object
		if(newposition>0) {
			System.out.println("Player ["+name+"] reached a snake and moved from ["+currentposition+"] to ["+newposition+"]"); //This makes it that the end of the snake cannot go below zero
			
		}
		return newposition;
	}
	         
	public void playerwins() {                                              //This method is called upon if ever the player wins the game
		System.out.println("Player ["+name+"] HAS WON THE GAME!!!");
		System.out.println("Thank you for playing the game");
	}
 
}
