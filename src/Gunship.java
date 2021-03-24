

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import com.sun.java_cup.internal.runtime.Scanner;

public class Gunship {
	//Characteristics of GunShip
	private static int x1;
	private static int y1;
	private static String userMap[][] = new String [10][10];
	private static String map[][] = new String[10][10];
	private static boolean b = false;
	private static boolean c = false;
	private static boolean d = false;
	private static boolean e = false;
	private static boolean f = false;
	private static int firstBattleshipCounter = 0;
	private static int secondBattleshipCounter = 0;
	private static int thirdBattleshipCounter = 0;
	private static int fourthBattleshipCounter = 0;
	private static int fifthBattleshipCounter = 0;
	private static int points = 0;
	private static boolean allBattleshipsDestroyed;
	private static int radarCounter = 4;
	private static int shipsDetectedCounter = 0;
	private static boolean keepPlaying = true;
	private static boolean menuStarter;
	// using array list so i can adjust the values easily and also the size of it
	private static ArrayList<String> battleshipsDestroyed = new ArrayList<String>();
	private static ArrayList<String> battleshipsAlive = new ArrayList<String>();
	
	
	public static void run() {
		
		menu();
	}
	
	
	private static void menu() {
		
		while (keepPlaying) {
			// create an object called scan from scanner class
			Scanner scan = new Scanner(System.in);
			menuStarter = true;
			String input;
			
			System.out.println("Welcome to Battleship");
			System.out.println("Press 1 to start the game");
			System.out.println("Press 2 to read the rules");
			System.out.println("Press 3 exit");
			
			
			while (menuStarter) {
				input = scan.nextLine();
				if (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
					System.out.println("please input a number from 1 to 3");
				} else if (input.equals("1") || input.equals("2") || input.equals("3")) {
					menuStarter = false;
				}
				if (menuStarter == false) {
					if (input.equals("1")) {
						// if its 1 all these methods are called which generates the battleships and the grid
						setDefaultMap();
						defaultUserMap();
						firstBattleShip();
						secondBattleShip();
						thirdBattleShip();
						fourthBattleShip();
						fifthBattleShip();
						
						System.out.println(Arrays.toString(map[9]));
						System.out.println(Arrays.toString(map[8]));
						System.out.println(Arrays.toString(map[7]));
						System.out.println(Arrays.toString(map[6]));
						System.out.println(Arrays.toString(map[5]));
						System.out.println(Arrays.toString(map[4]));
						System.out.println(Arrays.toString(map[3]));
						System.out.println(Arrays.toString(map[2]));
						System.out.println(Arrays.toString(map[1]));
						System.out.println(Arrays.toString(map[0]));
						
						scanner();
						
					} else if (input.equals("2")) {
						System.out.println("There are 5 gunships:");
						System.out.println("Patrol Boat: 2 Squares Long");
						System.out.println("Destroyer: 3 Squares Long");
						System.out.println("Submarine: 3 Squares Long");
						System.out.println("Battleship: 4 Squares Long");
						System.out.println("Aircraft Carrier: 5 Squares Long");
						System.out.println("");
						System.out.println("The aim of this game is taking down all of the enemies gunships but with the least amount of misses");
						System.out.println("in a random 10x10 board");
						System.out.println("If you successfully hit an enemy ship you gain 1 point but if you miss you lose 1 point");
						System.out.println("You gain double the size of gunship length in points if you manage to sink it.");
						System.out.println("");
						System.out.println("You have 4 radars which you can drop at X,Y coordinate and it will detect any ship that is one square away from its position");
						System.out.println("Press anything to go back to menu");
						String back = scan.nextLine();
						menuStarter = true;
						System.out.println("Welcome to Battleship");
						System.out.println("Press 1 to start the game");
						System.out.println("Press 2 to read the rules");
						System.out.println("Press 3 exit");
						
					} else if (input.equals("3")) {
						System.out.println("Are you sure you want to exit?");
						System.out.println("Press 1 to exit");
						//System.out.println("Press anything else to go back to menu");
						String exit = scan.nextLine();
						if (exit.equals("1")) {
							keepPlaying = false;
							System. exit(0);
						} else {
							menuStarter = true;
							System.out.println("Welcome to Battleship");
							System.out.println("Press 1 to start the game");
							System.out.println("Press 2 to read the rules");
							System.out.println("Press 3 exit");
						}
					}
				}
				
			}
			
		}
		
	}
	
	public static void setDefaultMap() {
		int i,j;
		for(i=0;i<10;++i) {
			for(j=0;j<10;++j){
//				this.map[i][j] = (Integer.toString(i) + Integer.toString(j));
				// will put 0 in each index inside the array
				map[i][j] = ("0");
			}
		}
	}
	
	public static void playerMap() {
		System.out.println(Arrays.toString(userMap[9]));
		System.out.println(Arrays.toString(userMap[8]));
		System.out.println(Arrays.toString(userMap[7]));
		System.out.println(Arrays.toString(userMap[6]));
		System.out.println(Arrays.toString(userMap[5]));
		System.out.println(Arrays.toString(userMap[4]));
		System.out.println(Arrays.toString(userMap[3]));
		System.out.println(Arrays.toString(userMap[2]));
		System.out.println(Arrays.toString(userMap[1]));
		System.out.println(Arrays.toString(userMap[0]));
	}

	
	public static int randNumbGenerator() {
		Random rand = new Random();
		int upperBound = 10;
		int rand_int = rand.nextInt(upperBound);
		return rand_int;
	}
	
	public static int randomDirection() {
		Random rand = new Random();
		int upperBound = 4;
		int randDirection = rand.nextInt(upperBound);
		return randDirection;
	}
	
	public static void firstBattleShip() {
		
		while (b == false) {
			x1 = randNumbGenerator();
			y1 = randNumbGenerator();
			int rd = randomDirection();
			
			// Up
			if (rd == 0 && y1 + 1 < 10) {
				if (map[y1][x1] == "0" && map[y1 + 1][x1] == "0") {
					map[y1][x1] = "1";
					map[y1 + 1][x1] = "1";
					b = true;
				}
				// Right
			} else if (rd == 1 && x1 + 1 < 10) {
				if (map[y1][x1] == "0" && map[y1][x1 + 1] == "0") {
					map[y1][x1] = "1";
					map[y1][x1 + 1] = "1";	
					b = true;
				}
				// Down
			} else if (rd == 2 && y1 - 1 > -1) {
				if (map[y1][x1] == "0" && map[y1 - 1][x1] == "0") {
					map[y1][x1] = "1";
					map[y1 - 1][x1] = "1";
					b = true;
				}
				//Left
			} else if (rd == 3 && x1 - 1 > -1) {
				if (map[y1][x1] == "0" && map[y1][x1 - 1] == "0") {
					map[y1][x1] = "1";
					map[y1][x1 - 1] = "1";
					b = true;
				}
			}
		}
	}
	
	public static void secondBattleShip () {
		
		while (c == false) {
			x1 = randNumbGenerator();
			y1 = randNumbGenerator();
			int rd = randomDirection();
			
			
			if (rd == 0 && y1  + 2 < 10) {
				if (map[y1][x1] == "0" && map [y1 + 1][x1] == "0" && map[y1 + 2][x1] == "0") {
					map[y1][x1] = "2";
					map[y1 + 1][x1] = "2";
					map[y1 + 2][x1] = "2";
					c = true;
				}
			} else if (rd == 1 && x1 + 2 < 10) {
				if (map[y1][x1] == "0" && map [y1][x1 + 1] == "0" && map[y1][x1 + 2] == "0") {
					map[y1][x1] = "2";
					map[y1][x1 + 1] = "2";
					map[y1][x1 + 2] = "2";
					c = true;	
				}
			} else if (rd == 2 && y1 - 2 > -1) {
				if (map[y1][x1] == "0" && map [y1 - 1][x1] == "0" && map[y1 - 2][x1] == "0") {
					map[y1][x1] = "2";
					map[y1 - 1][x1] = "2";
					map[y1 - 2][x1] = "2";
					c = true;
				}
			} else if (rd == 3 && x1 - 2 > -1) {
				if (map[y1][x1] == "0" && map [y1][x1 - 1] == "0" && map[y1][x1 - 2] == "0") {
					map[y1][x1] = "2";
					map[y1][x1 - 1] = "2";
					map[y1][x1 - 2] = "2";
					c = true;
				}
			}
		}
	}
	public static void thirdBattleShip() {
		
		while (d == false) {
			x1 = randNumbGenerator();
			y1 = randNumbGenerator();
			int rd = randomDirection();
			
			
			if (rd == 0 && y1  + 2 < 10) {
				if (map[y1][x1] == "0" && map [y1 + 1][x1] == "0" && map[y1 + 2][x1] == "0") {
					map[y1][x1] = "3";
					map[y1 + 1][x1] = "3";
					map[y1 + 2][x1] = "3";
					d = true;
				}
			} else if (rd == 1 && x1 + 2 < 10) {
				if (map[y1][x1] == "0" && map [y1][x1 + 1] == "0" && map[y1][x1 + 2] == "0") {
					map[y1][x1] = "3";
					map[y1][x1 + 1] = "3";
					map[y1][x1 + 2] = "3";
					d = true;
				}
			} else if (rd == 2 && y1 - 2 > -1) {
				if (map[y1][x1] == "0" && map [y1 - 1][x1] == "0" && map[y1 - 2][x1] == "0") {
					map[y1][x1] = "3";
					map[y1 - 1][x1] = "3";
					map[y1 - 2][x1] = "3";
					d = true;
				}
			} else if (rd == 3 && x1 - 2 > -1) {
				if (map[y1][x1] == "0" && map [y1][x1 - 1] == "0" && map[y1][x1 - 2] == "0") {
					map[y1][x1] = "3";
					map[y1][x1 - 1] = "3";
					map[y1][x1 - 2] = "3";
					d = true;
				}

			}
		}
	}
	
	public static void fourthBattleShip() {
		while (e == false) {
			x1 = randNumbGenerator();
			y1 = randNumbGenerator();
			int rd = randomDirection();
			
			if (rd == 0 && y1  + 3 < 10) {
				if (map[y1][x1] == "0" && map[y1 + 1][x1] == "0" && map[y1 + 2][x1] == "0" && map[y1 + 3][x1] == "0") {
				map[y1][x1] = "4";
				map[y1 + 1][x1] = "4";
				map[y1 + 2][x1] = "4";
				map[y1 + 3][x1] = "4";
				e = true;
			}
		}else if (rd == 1 && x1 + 3 < 10) {
			if (map[y1][x1] == "0" && map[y1][x1 + 1] == "0" && map[y1][x1 + 2] == "0" && map[y1][x1 + 3] == "0") {
				map[y1][x1] = "4";
				map[y1][x1 + 1] = "4";
				map[y1][x1 + 2] = "4";
				map[y1][x1 + 3] = "4";	
				e = true;
			}
		}else if (rd == 2 && y1 - 3 > -1) {
			if (map[y1][x1] == "0" && map[y1 - 1][x1] == "0" && map[y1 - 2][x1] == "0" && map[y1 - 3][x1] == "0") {
				map[y1][x1] = "4";
				map[y1 - 1][x1] = "4";
				map[y1 - 2][x1] = "4";
				map[y1 - 3][x1] = "4";
				e = true;
			}
		} else if (rd == 3 && x1 - 3 > -1) {
			if (map[y1][x1] == "0" && map[y1][x1 - 1] == "0" && map[y1][x1 - 2] == "0" && map[y1][x1 - 3] == "0") {
				map[y1][x1] = "4";
				map[y1][x1 - 1] = "4";
				map[y1][x1 - 2] = "4";
				map[y1][x1 - 3] = "4";	
				e = true;
			}
		}
	}				
}
	
	public static void fifthBattleShip() {
		while (f == false) {
			x1 = randNumbGenerator();
			y1 = randNumbGenerator();
			int rd = randomDirection();
			
			if (rd == 0 && y1 + 4 < 10) {
				if (map[y1][x1] == "0" && map[y1 + 1][x1] == "0" && map[y1 + 2][x1] == "0" && map[y1 + 3][x1] == "0" && map[y1 + 4][x1] == "0") {
					map[y1][x1] = "5";
					map[y1 + 1][x1] = "5";
					map[y1 + 2][x1] = "5";
					map[y1 + 3][x1] = "5";
					map[y1 + 4][x1] = "5";
					f = true;
				}
			}else if (rd == 1 && x1 + 4 < 10) {
				if (map[y1][x1] == "0" && map[y1][x1 + 1] == "0" && map[y1 ][x1 + 2] == "0" && map[y1][x1 + 3] == "0" && map[y1][x1 + 4] == "0") {
					map[y1][x1] = "5";
					map[y1][x1 + 1] = "5";
					map[y1][x1 + 2] = "5";
					map[y1][x1 + 3] = "5";
					map[y1][x1 + 4] = "5";
					f = true;
				}
			}else if (rd == 2 && y1 - 4 > -1) {
				if (map[y1][x1] == "0" && map[y1 - 1][x1] == "0" && map[y1 - 2][x1] == "0" && map[y1 - 3][x1] == "0" && map[y1 - 4][x1] == "0") {
					map[y1][x1] = "5";
					map[y1 - 1][x1] = "5";
					map[y1 - 2][x1] = "5";
					map[y1 - 3][x1] = "5";
					map[y1 - 4][x1] = "5";
					f = true;
				}
			}else if (rd == 3 && x1 - 4 > -1) {
				if (map[y1][x1] == "0" && map[y1][x1 - 1] == "0" && map[y1 ][x1 - 2] == "0" && map[y1][x1 - 3] == "0" && map[y1][x1 - 4] == "0") {
					map[y1][x1] = "5";
					map[y1][x1 - 1] = "5";
					map[y1][x1 - 2] = "5";
					map[y1][x1 - 3] = "5";
					map[y1][x1 - 4] = "5";
					f = true;
				}
			}
		}
	}
	
	public static void defaultUserMap() {
		int i,j;
		for(i=0;i<10;++i) {
			for(j=0;j<10;++j){
//				this.map[i][j] = (Integer.toString(i) + Integer.toString(j));
				userMap[i][j] = ("0");
			}
		}
	}
	
	
	public static void scanner() {
		
		battleshipsAlive.add("Patrol Boat");
		battleshipsAlive.add("Submarine");
		battleshipsAlive.add("Destroyer");
		battleshipsAlive.add("Battleship");
		battleshipsAlive.add("Aircraft Carrier");
		
		while (allBattleshipsDestroyed == false) {
			Scanner scan = new Scanner(System.in);
			int xCoordinate;
			int yCoordiante;
			
			if (radarCounter > 0) {
				System.out.println("Would you like to use one of your " + radarCounter + " remaining radars");
				System.out.print("Type 'Y' if you would like to use it or type 'N' if you dont want to");
				String radar = scan.nextLine();
				System.out.println(radar);
				
				if (radar.equals("Y")) {
					radarCounter--;
					System.out.println("Where would you like to drop the radar");
					System.out.println("Enter x coordinate for radar drop in the range of 1 to 8");
					xCoordinate = scan.nextInt();
					System.out.println("Enter y coordiante for radar drop in the range of 1 to 8");
					yCoordiante = scan.nextInt();
					
					if (xCoordinate > 0 && xCoordinate < 9 && yCoordiante > 0 && yCoordiante < 9) {
						if (map[yCoordiante][xCoordinate] == "1") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante + 1][xCoordinate] == "1") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante + 1][xCoordinate + 1] == "1") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante + 1][xCoordinate - 1] == "1") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante][xCoordinate - 1] == "1") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante][xCoordinate + 1] == "1") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante - 1][xCoordinate - 1] == "1") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante - 1][xCoordinate] == "1") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante - 1][xCoordinate + 1] == "1") {
							shipsDetectedCounter++;
						}
						
						if (map[yCoordiante][xCoordinate] == "2") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante + 1][xCoordinate] == "2") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante + 1][xCoordinate + 1] == "2") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante + 1][xCoordinate - 1] == "2") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante][xCoordinate - 1] == "2") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante][xCoordinate + 1] == "2") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante - 1][xCoordinate - 1] == "2") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante - 1][xCoordinate] == "2") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante - 1][xCoordinate + 1] == "2") {
							shipsDetectedCounter++;
						}
						
						if (map[yCoordiante][xCoordinate] == "3") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante + 1][xCoordinate] == "3") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante + 1][xCoordinate + 1] == "3") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante + 1][xCoordinate - 1] == "3") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante][xCoordinate - 1] == "3") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante][xCoordinate + 1] == "3") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante - 1][xCoordinate - 1] == "3") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante - 1][xCoordinate] == "3") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante - 1][xCoordinate + 1] == "3") {
							shipsDetectedCounter++;
						}
						
						if (map[yCoordiante][xCoordinate] == "4") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante + 1][xCoordinate] == "4") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante + 1][xCoordinate + 1] == "4") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante + 1][xCoordinate - 1] == "4") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante][xCoordinate - 1] == "4") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante][xCoordinate + 1] == "4") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante - 1][xCoordinate - 1] == "4") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante - 1][xCoordinate] == "4") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante - 1][xCoordinate + 1] == "4") {
							shipsDetectedCounter++;
						}
						
						if (map[yCoordiante][xCoordinate] == "5") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante + 1][xCoordinate] == "5") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante + 1][xCoordinate + 1] == "5") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante + 1][xCoordinate - 1] == "5") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante][xCoordinate - 1] == "5") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante][xCoordinate + 1] == "5") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante - 1][xCoordinate - 1] == "5") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante - 1][xCoordinate] == "5") {
							shipsDetectedCounter++;
						} else if (map[yCoordiante - 1][xCoordinate + 1] == "5") {
							shipsDetectedCounter++;
						}
						
						if (shipsDetectedCounter == 5) {
							System.out.println("you have detected 5 ships");
						} else if (shipsDetectedCounter == 4) {
							System.out.println("you have detected 4 ships");
						} else if (shipsDetectedCounter == 3) {
							System.out.println("you have detected 3 ships");
						} else if (shipsDetectedCounter == 2) {
							System.out.println("you have detected 2 ships");
						} else if (shipsDetectedCounter == 1) {
							System.out.println("you have detected 1 ships");
						} else if (shipsDetectedCounter == 0) {
							System.out.println("you have detected 0 ships");
						}
					} else {
						System.out.println("you did not enter a valid coordinate! you can try again next time");
					}
					
			}
			
				
				
			}
			
			System.out.println("Where do you want to shoot");
			System.out.println("Enter x coordinate you want to shoot");
			xCoordinate = scan.nextInt();
			System.out.println("Enter y coordiante you want to shoot");
			yCoordiante = scan.nextInt();
			
			
			if (map[yCoordiante][xCoordinate] == "0") {
				map[yCoordiante][xCoordinate] = "M";
				userMap[yCoordiante][xCoordinate] = "M";
				System.out.println("You missed!");
				points--;
			} else if (map[yCoordiante][xCoordinate] == "1") {
				map[yCoordiante][xCoordinate] = "H";
				userMap[yCoordiante][xCoordinate] = "H";
				System.out.println("My ship was hit");
				firstBattleshipCounter++;
				if (firstBattleshipCounter == 2) {
					System.out.println("you have sunk Patrol boat");
					points = points + 2 * 2;
					battleshipsDestroyed.add("Patrol boat");
					battleshipsAlive.remove(0);
				} else {
					points++;
				}
			} else if (map[yCoordiante][xCoordinate] == "2") {
				map[yCoordiante][xCoordinate] = "H";
				userMap[yCoordiante][xCoordinate] = "H";
				System.out.println("My ship was hit");
				secondBattleshipCounter++;
				if (secondBattleshipCounter ==3) {
					System.out.println("you have sunk Submarine");
					points = points + 2 * 3;
					battleshipsDestroyed.add("Submarine");
					battleshipsAlive.remove(1);
				} else {
					points++;
				}
			} else if (map[yCoordiante][xCoordinate] == "3") {
				map[yCoordiante][xCoordinate] = "H";
				userMap[yCoordiante][xCoordinate] = "H";
				System.out.println("My ship was hit");
				thirdBattleshipCounter++;
				if (thirdBattleshipCounter == 3) {
					System.out.println("you have sunk Destroyer");
					points = points + 2 * 3;
					battleshipsDestroyed.add("Destroyer");
					battleshipsAlive.remove(2);
				} else {
					points++;
				}
			} else if (map[yCoordiante][xCoordinate] == "4") {
				map[yCoordiante][xCoordinate] = "H";
				userMap[yCoordiante][xCoordinate] = "H";
				System.out.println("My ship was hit");
				fourthBattleshipCounter++;
				if (fourthBattleshipCounter == 4) {
					System.out.println("you have sunk Battleship");
					points = points + 2 * 4;
					battleshipsDestroyed.add("Battleship");
					battleshipsAlive.remove(3);
				} else {
					points++;
				}
			} else if (map[yCoordiante][xCoordinate] == "5") {
				map[yCoordiante][xCoordinate] = "H";
				userMap[yCoordiante][xCoordinate] = "H";
				System.out.println("My ship was hit");
				fifthBattleshipCounter++;
				if (fifthBattleshipCounter == 5) {
					System.out.println("you have sunk Aircraft Carrier");
					points = points + 2 * 5;
					battleshipsDestroyed.add("Aircraft Carrier");
					battleshipsAlive.remove(4);
				} else {
					points ++;
				}
			} else if (map[yCoordiante][xCoordinate] == "M" ||map[yCoordiante][xCoordinate] == "H") {
				System.out.println("You have already hit this place");
			}
			
			System.out.print(xCoordinate + " , ");
			System.out.println(yCoordiante);
			
			System.out.println();
			
			playerMap();
			
			System.out.println("Battleships un-sunk: " + Arrays.toString(battleshipsAlive.toArray()));
			System.out.println("Battleships sunk: " + Arrays.toString(battleshipsDestroyed.toArray()));
			
			System.out.println("your points: " + points);
			
			if (firstBattleshipCounter == 2 && secondBattleshipCounter == 3 && thirdBattleshipCounter == 3 && fourthBattleshipCounter == 4 && fifthBattleshipCounter == 5) {
				allBattleshipsDestroyed = true;
				battleshipsDestroyed.clear();
				System.out.println("Congratulations you have destroyed all the ships and won the game!");
				System.out.println("Your final score is: " + points);
			}
			
		}
		
		firstBattleshipCounter = 0;
		secondBattleshipCounter = 0;
		thirdBattleshipCounter = 0;
		fourthBattleshipCounter = 0;
		fifthBattleshipCounter = 0;
		radarCounter = 4;
		battleshipsAlive.clear();
		battleshipsDestroyed.clear();
		b = false;
		c = false;
		d = false;
		e = false;
		f = false;
		menuStarter = true;
		points = 0;
		allBattleshipsDestroyed = false;
		System.out.println("Would you like to play again?");
		System.out.println("Press 1 to start the game");
		System.out.println("Press 2 to read the rules");
		System.out.println("Press 3 exit");
		

	}
	
}
