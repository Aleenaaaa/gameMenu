	import java.util.*;
	public class TheGame  {
		
		public static int rolldice() {
			Random rand = new Random();                       //This is where the computer will generate a random number.
			int n = rand.nextInt(6)+1;                        //The reason why I did 6 was that I only wanted the first six numbers furthermore I added +1 to get number 1,2,3,4,5,6 and not zero
			return n;                                          //This will return the random number generated
		}
		public static Snake[] getSnakes(){                       //This is a getter method where i can get the values of start and end of each snakes
		    Snake[] s = new Snake[5];                            // I have stored the values of the start and end of the snakes in a array.
	  	    s[0]= new Snake(67,48);                               // I have made 5 arrays which equals to 5 snakes objects
		    s[1]= new Snake(63,13);
		    s[2]= new Snake(32,24);
		    s[3]= new Snake(90,72);
		    s[4]= new Snake(93,47);
		    return s;                                          //This will return each array
		  }
		  public static Ladder[] getLadders(){                      //This is a getter method where i can get all the values of start and end of each ladders
		    Ladder[] l = new Ladder[5];                            // I have stored the values of the start and end of the ladder in a array.
		    l[0]= new Ladder(53,78);                               // I have made 5 arrays which equals to 5 ladder objects
		    l[1]= new Ladder(66,89);             
		    l[2]= new Ladder(39,51);
		    l[3]= new Ladder(25,54);
		    l[4]= new Ladder(12,44);
		    return l;                                               //This will return each array
		  }
		
		public static void run() {
			Scanner scan = new Scanner(System.in);
			Ladder[] ladders = getLadders();                      //This a variable to call upon the getter method for the ladder
			Snake[] snakes = getSnakes();                         //This a variable to call upon the getter method for the snake
			boolean winsgame = false;                              //Set win game to  false
			boolean extraturn = false;                              // Set extraturn to false
			
			System.out.println("Welcome to Snake and Ladders");       //Sends a welcome message
			System.out.println("Type the number of Players playing the game. (Minimum 2 and Maximum 4)"); //Ask you type the number of players playing the game. Minimum 2 and Maximum of 4 players.
			int number = Integer.parseInt(scan.nextLine());              //This method is used in parsing a string method into a integer object
			Gamer[] ga = new Gamer[number];                  //new array of each player
			System.out.println("Type all the name of the players");
			for(int i = 0; i<number; i++) {
				System.out.println("Type the name of player "+(i+1));         //This ask for the names of each player
				String name = scan.nextLine();
				ga[i] = new Gamer(name);
			}
			
			int i =0 ;
			int value=0;                     // value is the random number generated
			while(!winsgame) {
				System.out.println("["+ga[i].name+"] turn, type any key to roll the dice");    // the player will be asked to type any key to roll the dice
				char a = scan.nextLine().charAt(0);
				if(a=='r') 
				value = rolldice();           
				
				int currentposition = ga[i].playermoves(value);  //the player will move depending on the number generated
				if(currentposition ==100) {               //This if statement is when the player reaches 100, they will win the game.
					winsgame = true;
					ga[i].playerwins();
					break;                          //This statement breaks out of the while loop
				}
				for(Snake s: snakes) {
					if(ga[i].newposition==s.start) {        //if the player new position is the start position of the snake object it will active the method of playerlandsSnake
						if(value==6) {                        //if the player rolls a six, the player will get an extraturn
							extraturn= true;
						}
						currentposition = ga[i].playerlandsSnake(s);    //this will call the method of playerlandsSnake
					}
				}
				for(Ladder l: ladders) {
					if(ga[i].newposition == l.start) {             //if the player new position is the start position of the ladder object it will active the method of playerlandsLadder
						if(value ==6) {
							extraturn = true;
						}
						currentposition= ga[i].playerlandsLadder(l);
					}
				}
				if(!extraturn) {                          //This a mathematical equation where if the player didnt roll a six, its now the next player's turn
					i=(i+1)%number;
				}
				
			}
			
		}
	}

