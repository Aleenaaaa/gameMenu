# gameMenu

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
			StartMenu run= new StartMenu();
			run.SnakeandLadderB();
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
			

			
		
	}//close switch
	
	}//close main
	
	public void SnakeandLadderB() 
	{
		Random random = new Random();
		Scanner input=new Scanner(System.in);
		//game
		int snake;
		int ladder;
		int player;
		int LH=0;
		int LT=0;
		int i;
		int j;
		int SH=0;
		int ST=0;
		int p;
		int q;
		int amo;
		int AMO;
		int z,x,c,v,s;
		int stickpositionA;
		int stickpositionB;
		int biscuitspositionA;
		int biscuitspositionB;
		int stickamout=0;
		int biscuitsamout=0;
		int V,B,N,M;
		int point;
		int IP=1,IIP=1,IIIP=1;
		int lh,sh,nsh;
		int flag=1;
		int sum=0;
		String PI = null,PII = null,PIII= null;
		String start;
		String dice;
		snake=random.nextInt(2)+5;
		ladder=random.nextInt(3)+3;		
		int[] ladderhead=new int[ladder];
		int[] laddertail=new int[ladder];
		int[] snakehead= new int [snake];
		int[] snaketail= new int[snake];
		for(i=0;i<ladderhead.length;i++)
		{
			ladderhead[i]=-1;
		}
		for(j=0;j<laddertail.length;j++)
		{
			laddertail[j]=-1;
		}
		while(LH<ladderhead.length)
		{
			int num=random.nextInt(87)+2;
			if(num==11)
			{
				num=num+1;
			}
			if(JUDGE(ladderhead,num))
			{
				ladderhead[LH]=num;
				LH++;			
				int NUM=random.nextInt(99)+num;
				if(JUDGE(laddertail,NUM))
				{
					laddertail[LT]=NUM;
					LT++;
				}
			}			
		}		
		for(p=0;p<snakehead.length;p++)
		{
			snakehead[p]=-1;
		}
		for(q=0;q<snaketail.length;q++)
		{
			snaketail[q]=-1;
		}
		while(SH<snakehead.length)
		{
			amo=random.nextInt(87)+12;
			boolean contains = contains(ladderhead, amo);
			if(contains)
			{
				amo=amo-1;
				boolean Contains = contains(laddertail,amo);
				if(Contains)
				{
					amo--;
				}
			}
			if(JUDGE(snakehead,amo))
			{
				snakehead[SH]=amo;
				SH++;
				AMO=random.nextInt(amo)+2;
				boolean include = contains(ladderhead,AMO);
				if(include)
				{
					AMO--;
				}
				if(JUDGE(snaketail,AMO))
				{
					snaketail[ST]=AMO;
					ST++;
				}
			}					
		}
		Integer[] arr= new Integer[ladderhead.length+laddertail.length+snakehead.length+snaketail.length];
		for(z=0;z<ladderhead.length;z++)
		{
			arr[z]=ladderhead[z];
		}
		for(x=0;x<laddertail.length;x++)
		{
			arr[ladderhead.length+z]=laddertail[x];
		}
		for(c=0;c<snakehead.length;c++)
		{
			arr[ladderhead.length+laddertail.length+c]=snakehead[c];
		}
		for(v=0;v<snaketail.length;v++)
		{
			arr[ladderhead.length+laddertail.length+snakehead.length+v]=snaketail[v];
		}
		Integer[] ALL=new Integer[100];
		for(s=0;s<100;s++)
		{
			ALL[s]=s+1;
		}
		Integer[] C=getC(ALL,arr);			
		V=B=N=M=0;
		while(V==B||V==M||V==N||B==M||B==N||M==N)
		{
			V=random.nextInt(C.length);
			B=random.nextInt(C.length);
			M=random.nextInt(C.length);
			N=random.nextInt(C.length);
		}
		stickpositionA=C[V];
		stickpositionB=C[B];
		biscuitspositionA=C[M];
		biscuitspositionB=C[N];
		System.out.println("                                        Snake & Ladder");
		System.out.println("Number of snakes: "+ snake+"                          Tips                      Number of biscuits: 2");
		System.out.println("Number of ladder: "+ ladder+"                  do not play with snakes!            Number of sticks: 2");
		System.out.println("                                Please enter the number of players.");
		System.out.print("                     Please note that this game supports up to 3 players.");
		player=input.nextInt();
		System.out.println("                                               "+player);
		while(player>3)
		{
			System.out.println("                               Please reduce the number of players.");
			System.out.print("                        This game really can not carry so many players.");
			player=input.nextInt();
			System.out.println("                                      Numbers of player: "+player);
		}
		if(player==1)
		{
			System.out.println("                        The game is about to start. Good luck to you.");
		}
		if(player==2)
		{
			System.out.println("Players, you can enter names to distinguish each other in this game.");
			System.out.println("Now, first player, please enter your name.");
			PI=input.next();
			System.out.println("Good. Your name is "+PI);
			System.out.println("Now, second player, please enter your name.");
			PII=input.next();
			System.out.println("Good. Your name is "+PII);
			System.out.println("The game is about to start. Good luck to you.");
		}
		if(player==3)
		{
			System.out.println("Players, you can enter names to distinguish each other in this game.");
			System.out.println("Now, first player, please enter your name.");
			PI=input.next();
			System.out.println("Good. Your name is "+PI);
			System.out.println("Now, second player, please enter your name.");
			PII=input.next();
			System.out.println("Good. Your name is "+PII);
			System.out.println("Now, third player, please enter your name.");
			PIII=input.next();
			System.out.println("Good. Your name is "+PIII);
			System.out.println("The game is about to start. Good luck to you.");
		}		
		System.out.println("In the field, there is already "+snake+" snakes in ambush");  
		if(player == 1) 
		{
			System.out.println("You're at the starting point now. Are you ready?");
			System.out.println("You can enter anything to start the game!");
			start=input.next();
			while(IP<100)
			{
				System.out.println("Now your positiong is "+IP);
				System.out.println("You can enter anything to roll dice!");
				dice=input.next();
				point=random.nextInt(5)+1;
				System.out.println("The point of dice is"+point);
				if(IP+point>100)
				{
					System.out.println("Sorry, you can not move because you are going to be out of field.");
				}
				else
				{
					System.out.println("You can move "+point+" step(s) forward.");
					IP=IP+point;					
					boolean meetladder = contains(ladderhead,IP);
					if(meetladder)
					{
						System.out.println("You found a ladder!");
						System.out.println("Go up the ladder.");
						for(lh=0;lh<ladderhead.length;lh++)
						{
							if(IP==ladderhead[lh])
							{
								break;
							}
						}
						IP=laddertail[lh];
						System.out.println("Now your position is"+IP);
					}
					if(IP==stickpositionA || IP==stickpositionB)
					{
						System.out.println("You are armed!");
						System.out.println("This abandoned stick may be used to ward off danger.");
						System.out.println(" But it seems that just can only be used once.");
						stickamout++;
						System.out.println("You have "+stickamout+"stick(s) now");
					}
					if(IP==biscuitspositionA ||IP==biscuitspositionB)
					{
						System.out.println("You find a forgotten biscuit.");
						System.out.println("But you are not hungry right now. Maybe it has other uses?");
						System.out.println("Wishing this biscuit had not expired.");
						biscuitsamout++;
						System.out.println("You have "+biscuitsamout+"biscuit(s) now");
					}
					boolean meetsnake = contains(snakehead,IP);
					if(meetsnake)
					{
						for(sh=0;sh<snakehead.length;sh++)
						{
							if(IP==snakehead[sh])
							{
								break;
							}
						}
						System.out.println("You feel creepy suddenly.");
						System.out.println("You find a snake staring at you.");
						System.out.println("Maybe it is hungry?");
						if(biscuitsamout>0)
						{
							System.out.println("You look in your pocket and all you can call food is biscuits.");
							System.out.println("You threw the biscuit to the snake. ");
							System.out.println("Even though you know that snakes do not like it.");
							biscuitsamout--;
							System.out.println("It is working! The snake began to bite the biscuit.");
							System.out.println("The snake's attention is off you!");
							System.out.println("Get out of here before the snake finds out it is been tricked!");
							System.out.println("You have "+biscuitsamout+"biscuit left");
						}
						if(stickamout>0)
						{
							System.out.println("You have nothing to distract a snake from.");
							System.out.println("The stick you picked up before should bring some sense of security.");
							System.out.println("You wave the stick hard, hoping to hit the snake.");
							if(snakehead[sh]<90)
							{
								System.out.println("The snake was hit. Well done, snake is scared now.");
								nsh=snakehead[sh]+10;
								boolean newsnake = contains(snakehead,nsh);
								if(newsnake)
								{
									System.out.println("However, instead of running away, the snake looks at you fiercely");
									IP--;
									System.out.println("Take a step back to avoid the snake's revenge.");
									System.out.println("Now your position is"+IP);
								}
								else
								{
									snakehead[sh]=nsh;
									System.out.println("The snake gives you a vicious look and runs away.");								
									System.out.println("Hopeing do not see that snake again.");
								}								
							}
							else
							{
								System.out.println("The snake was hit. Well done, snake is scared now.");
								System.out.println("However, instead of running away, the snake looks at you fiercely");
								IP--;
								System.out.println("Take a step back to avoid the snake's revenge.");
								System.out.println("Now your position is"+IP);
							}
							System.out.println("Anyway, the stick is broken.");
							System.out.println("Throw it away. It is useless.");
							stickamout--;
							System.out.println("Now, you have "+stickamout+"stick");
						}
						else
						{
							System.out.println("You do not have anything to help you.");
							System.out.println("Now you have to run.");
							System.out.println("Hoping the snake will not catch up.");
							System.out.println("Or pray it is not a poisonous snake?");
							IP=snaketail[sh];
							System.out.println("Fortunately, the snake did not come.");
							System.out.println("Your current position is "+IP);
						}
					}
				}				
				if(point==6)
				{
					System.out.println("Luckly！ You get 6 points before.");
					System.out.println("That means you will get a reward.");
					point=random.nextInt(5)+1;
					System.out.println("The reward is that you will take "+point+" extra step(s) forward.");
					if(IP+point>100)
					{
						System.out.println("Sorry, you can not move because you are going to be out of field.");
					}
					else
					{
						System.out.println("You can move"+point+"step(s) forward.");
						IP=IP+point;
						System.out.println("Your current position is "+IP);					
					}
					boolean meetladder = contains(ladderhead,IP);
					if(meetladder)
					{
						System.out.println("You found a ladder!");
						System.out.println("Go up the ladder.");
						for(lh=0;lh<ladderhead.length;lh++)
						{
							if(IP==ladderhead[lh])
							{
								break;
							}
						}
						IP=laddertail[lh];
						System.out.println("Now your position is"+laddertail);
					}
					if(IP==stickpositionA || IP==stickpositionB)
					{
						System.out.println("You are armed!");
						System.out.println("This abandoned stick may be used to ward off danger.");
						System.out.println(" But it seems that just can only be used once.");
						stickamout++;
						System.out.println("You have "+stickamout+" stick(s) now");
					}
					if(IP==biscuitspositionA || IP==biscuitspositionB)
					{
						System.out.println("You find a forgotten biscuit.");
						System.out.println("But you are not hungry right now. Maybe it has other uses?");
						System.out.println("Wishing this biscuit had not expired.");
						biscuitsamout++;
						System.out.println("You have "+biscuitsamout+" biscuit(s) now");
					}
					boolean meetsnake = contains(snakehead,IP);
					if(meetsnake)
					{
						for(sh=0;sh<snakehead.length;sh++)
						{
							if(IP==snakehead[sh])
							{
								break;
							}
						}
						System.out.println("You feel creepy suddenly.");
						System.out.println("You find a snake staring at you.");
						System.out.println("Maybe it is hungry?");
						if(biscuitsamout>0)
						{
							System.out.println("You look in your pocket and all you can call food is biscuits.");
							System.out.println("You threw the biscuit to the snake. ");
							System.out.println("Even though you know that snakes do not like it.");
							biscuitsamout--;
							System.out.println("It is working! The snake began to bite the biscuit.");
							System.out.println("The snake's attention is off you!");
							System.out.println("Get out of here before the snake finds out it is been tricked!");
							System.out.println("You have "+biscuitsamout+" biscuit left");
						}
						if(stickamout>0)
						{
							System.out.println("You have nothing to distract a snake from.");
							System.out.println("The stick you picked up before should bring some sense of security.");
							System.out.println("You wave the stick hard, hoping to hit the snake.");
							if(snakehead[sh]<90)
							{
								nsh=snakehead[sh]+10;
								boolean newsnake = contains(snakehead,nsh);
								if(newsnake)
								{
									System.out.println("However, instead of running away, the snake looks at you fiercely");
									IP--;
									System.out.println("Take a step back to avoid the snake's revenge.");
									System.out.println("Now your position is"+IP);
								}
								else
								{
									snakehead[sh]=nsh;
									System.out.println("The snake gives you a vicious look and runs away.");								
									System.out.println("Hopeing do not see that snake again.");
								}
							}
							else
							{
								System.out.println("The snake was hit. Well done, snake is scared now.");
								System.out.println("However, instead of running away, the snake looks at you fiercely");
								IP--;
								System.out.println("Take a step back to avoid the snake's revenge.");
								System.out.println("Now your position is"+IP);
							}
							System.out.println("Anyway, the stick is broken.");
							System.out.println("Throw it away. It is useless.");
							stickamout--;
							System.out.println("Now, you have "+stickamout+" stick");
						}
						else
						{
							System.out.println("You do not have anything to help you.");
							System.out.println("Now you have to run.");
							System.out.println("Hoping the snake will not catch up.");
							System.out.println("Or pray it is not a poisonous snake?");
							IP=snaketail[sh];
							System.out.println("Fortunately, the snake didn't come.");
							System.out.println("Your current position is "+IP);
						}
					}
				}
				for(int a=0;a<10;a++)
				{
					for(int b=1;b<=10;b++)
					{
						sum=10*a+b;						
						if(sum==IP)
						{
							System.out.print("1p  ");
						}
						else
						{
							System.out.print(String.format("%03d",sum)+" ");
						}
					}
					System.out.println("\n");
				}
			}
			System.out.println("You are at the finish line.");
			System.out.println("Congratulations,you win!");
			System.out.println("Thank you for playing this game!");
		}
		if(player == 2)
		{
			System.out.println(PI+" and "+PII+" you are at the starting point now. Are you ready?");
			System.out.println("You can enter anything to start the game!");
			start=input.next();
			while(IP<100 && IIP<100)
			{
				if(flag==1)
				{
					System.out.println(PI+", your positiong is "+IP);
					System.out.println("You can enter anything to roll dice!");
					dice=input.next();
					point=random.nextInt(5)+1;
					System.out.println("The point of dice is"+point);
					if(IP+point>100)
					{
						System.out.println("Sorry, you can not move because you are going to be out of field.");
					}
					else
					{
						System.out.println("You can move "+point+" step(s) forward.");
						IP=IP+point;					
						boolean meetladder = contains(ladderhead,IP);
						if(meetladder)
						{
							System.out.println("You found a ladder!");
							System.out.println("Go up the ladder.");
							for(lh=0;lh<ladderhead.length;lh++)
							{
								if(IP==ladderhead[lh])
								{
									break;
								}
							}
							IP=laddertail[lh];
							System.out.println(PI+", your current position is"+IP);
						}
						if(IP==stickpositionA || IP==stickpositionB)
						{
							System.out.println(PI+" is armed!");
							System.out.println("This abandoned stick may be used to ward off danger.");
							System.out.println(" But it seems that just can only be used once.");
							stickamout++;
							System.out.println(PI+" you have "+stickamout+"stick(s) now");
						}
						if(IP==biscuitspositionA ||IP==biscuitspositionB)
						{
							System.out.println(PI+" you find a forgotten biscuit.");
							System.out.println("But you are not hungry right now. Maybe it has other uses?");
							System.out.println("Wishing this biscuit had not expired.");
							biscuitsamout++;
							System.out.println(PI+" you have "+biscuitsamout+"biscuit(s) now");
						}
						boolean meetsnake = contains(snakehead,IP);
						if(meetsnake)
						{
							for(sh=0;sh<snakehead.length;sh++)
							{
								if(IP==snakehead[sh])
								{
									break;
								}
							}
							System.out.println(PI+", you feel creepy suddenly.");
							System.out.println("You find a snake staring at you.");
							System.out.println("Maybe it is hungry?");
							if(biscuitsamout>0)
							{
								System.out.println("You look in your pocket and all you can call food is biscuits.");
								System.out.println("You threw the biscuit to the snake. ");
								System.out.println("Even though you know that snakes do not like it.");
								biscuitsamout--;
								System.out.println("It is working! The snake began to bite the biscuit.");
								System.out.println("The snake's attention is off you, "+PI+" !");
								System.out.println("Get out of here before the snake finds out it is been tricked!");
								System.out.println("You have "+biscuitsamout+"biscuit left");
							}
							if(stickamout>0)
							{
								System.out.println(PI+", you have nothing to distract a snake from.");
								System.out.println("The stick you picked up before should bring some sense of security.");
								System.out.println("You wave the stick hard, hoping to hit the snake.");
								if(snakehead[sh]<90)
								{
									System.out.println("The snake was hit. Well done, snake is scared now.");
									nsh=snakehead[sh]+10;
									boolean newsnake = contains(snakehead,nsh);
									if(newsnake)
									{
										System.out.println("However, instead of running away, the snake looks at you fiercely");
										IP--;
										System.out.println("Take a step back to avoid the snake's revenge.");
										System.out.println(PI+", your current position is"+IP);
									}
									else
									{
										snakehead[sh]=nsh;
										System.out.println("The snake gives you a vicious look and runs away.");								
										System.out.println("Hopeing do not see that snake again.");
									}								
								}
								else
								{
									System.out.println("The snake was hit. Well done, snake is scared now.");
									System.out.println("However, instead of running away, the snake looks at you fiercely");
									IP--;
									System.out.println("Take a step back to avoid the snake's revenge.");
									System.out.println(PI+", your current position is"+IP);
								}
								System.out.println("Anyway, the stick is broken.");
								System.out.println("Throw it away. It is useless.");
								stickamout--;
								System.out.println("Now, you have "+stickamout+"stick");
							}
							else
							{
								System.out.println(PI+" you do not have anything to help you.");
								System.out.println("Now you have to run.");
								System.out.println("Hoping the snake will not catch up.");
								System.out.println("Or pray it is not a poisonous snake?");
								IP=snaketail[sh];
								System.out.println("Fortunately, the snake did not come.");
								System.out.println(PI+", your current position is "+IP);
							}
						}
					}
					
					if(point==6)
					{
						System.out.println("Luckly！ You get 6 points before.");
						System.out.println("That means you will get a reward.");
						point=random.nextInt(5)+1;
						System.out.println("The reward is that you will take "+point+" extra step(s) forward.");
						if(IP+point>100)
						{
							System.out.println("Sorry, you can not move because you are going to be out of field.");
						}
						else
						{
							System.out.println("You can move "+point+" step(s) forward.");
							IP=IP+point;
							System.out.println("Your current position is "+IP);					
						}
						boolean meetladder = contains(ladderhead,IP);
						if(meetladder)
						{
							System.out.println("You found a ladder!");
							System.out.println("Go up the ladder.");
							for(lh=0;lh<ladderhead.length;lh++)
							{
								if(IP==ladderhead[lh])
								{
									break;
								}
							}
							IP=laddertail[lh];
							System.out.println(PI+", your current position is"+IP);
						}
						if(IP==stickpositionA || IP==stickpositionB)
						{
							System.out.println(PI+" is armed!");
							System.out.println("This abandoned stick may be used to ward off danger.");
							System.out.println(" But it seems that just can only be used once.");
							stickamout++;
							System.out.println(PI+" you have "+stickamout+"stick(s) now");
						}
						if(IP==biscuitspositionA ||IP==biscuitspositionB)
						{
							System.out.println(PI+" you find a forgotten biscuit.");
							System.out.println("But you are not hungry right now. Maybe it has other uses?");
							System.out.println("Wishing this biscuit had not expired.");
							biscuitsamout++;
							System.out.println(PI+" you have "+biscuitsamout+"biscuit(s) now");
						}
						boolean meetsnake = contains(snakehead,IP);
						if(meetsnake)
						{
							for(sh=0;sh<snakehead.length;sh++)
							{
								if(IP==snakehead[sh])
								{
									break;
								}
							}
							System.out.println(PI+", you feel creepy suddenly.");
							System.out.println("You find a snake staring at you.");
							System.out.println("Maybe it is hungry?");
							if(biscuitsamout>0)
							{
								System.out.println("You look in your pocket and all you can call food is biscuits.");
								System.out.println("You threw the biscuit to the snake. ");
								System.out.println("Even though you know that snakes do not like it.");
								biscuitsamout--;
								System.out.println("It is working! The snake began to bite the biscuit.");
								System.out.println("The snake's attention is off you, "+PI+" !");
								System.out.println("Get out of here before the snake finds out it is been tricked!");
								System.out.println("You have "+biscuitsamout+"biscuit left");
							}
							if(stickamout>0)
							{
								System.out.println(PI+", you have nothing to distract a snake from.");
								System.out.println("The stick you picked up before should bring some sense of security.");
								System.out.println("You wave the stick hard, hoping to hit the snake.");
								if(snakehead[sh]<90)
								{
									System.out.println("The snake was hit. Well done, snake is scared now.");
									nsh=snakehead[sh]+10;
									boolean newsnake = contains(snakehead,nsh);
									if(newsnake)
									{
										System.out.println("However, instead of running away, the snake looks at you fiercely");
										IP--;
										System.out.println("Take a step back to avoid the snake's revenge.");
										System.out.println(PI+", your current position is"+IP);
									}
									else
									{
										snakehead[sh]=nsh;
										System.out.println("The snake gives you a vicious look and runs away.");								
										System.out.println("Hopeing do not see that snake again.");
									}								
								}
								else
								{
									System.out.println("The snake was hit. Well done, snake is scared now.");
									System.out.println("However, instead of running away, the snake looks at you fiercely");
									IP--;
									System.out.println("Take a step back to avoid the snake's revenge.");
									System.out.println(PI+", your current position is"+IP);
								}
								System.out.println("Anyway, the stick is broken.");
								System.out.println("Throw it away. It is useless.");
								stickamout--;
								System.out.println("Now, you have "+stickamout+"stick");
							}
							else
							{
								System.out.println(PI+" you do not have anything to help you.");
								System.out.println("Now you have to run.");
								System.out.println("Hoping the snake will not catch up.");
								System.out.println("Or pray it is not a poisonous snake?");
								IP=snaketail[sh];
								System.out.println("Fortunately, the snake did not come.");
								System.out.println(PI+", your current position is "+IP);
							}
						}
					
					}
					for(int a=0;a<10;a++)
					{
						for(int b=1;b<=10;b++)
						{
							sum=10*a+b;
							if(sum==IP&&sum==IIP)
							{
								System.out.print("ALL ");
							}
							else if(sum==IP)
							{
								System.out.print("1p  ");
							}
							else if(sum==IIP)
							{
								System.out.print("2p  ");
							}
							else
							{
								System.out.print(String.format("%03d",sum)+" ");
							}
						}
						System.out.println("\n");
					}
					if(IP==100)
					{
						System.out.println(PI+" you are at the finish line.");
						System.out.println("Congratulations,you win!");
					}
					else
					{
						flag=2;
					}
				}
				if(flag==2)
				{
					System.out.println(PII+", your positiong is "+IIP);
					System.out.println("You can enter anything to roll dice!");
					dice=input.next();
					point=random.nextInt(5)+1;
					System.out.println("The point of dice is"+point);
					if(IIP+point>100)
					{
						System.out.println("Sorry, you can not move because you are going to be out of field.");
					}
					else
					{
						System.out.println("You can move "+point+" step(s) forward.");
						IIP=IIP+point;					
						boolean meetladder = contains(ladderhead,IIP);
						if(meetladder)
						{
							System.out.println("You found a ladder!");
							System.out.println("Go up the ladder.");
							for(lh=0;lh<ladderhead.length;lh++)
							{
								if(IIP==ladderhead[lh])
								{
									break;
								}
							}
							IIP=laddertail[lh];
							System.out.println(PII+", your current position is"+IIP);
						}
						if(IIP==stickpositionA || IIP==stickpositionB)
						{
							System.out.println(PII+" is armed!");
							System.out.println("This abandoned stick may be used to ward off danger.");
							System.out.println(" But it seems that just can only be used once.");
							stickamout++;
							System.out.println(PII+" you have "+stickamout+"stick(s) now");
						}
						if(IIP==biscuitspositionA ||IIP==biscuitspositionB)
						{
							System.out.println(PII+" you find a forgotten biscuit.");
							System.out.println("But you are not hungry right now. Maybe it has other uses?");
							System.out.println("Wishing this biscuit had not expired.");
							biscuitsamout++;
							System.out.println(PII+" you have "+biscuitsamout+"biscuit(s) now");
						}
						boolean meetsnake = contains(snakehead,IIP);
						if(meetsnake)
						{
							for(sh=0;sh<snakehead.length;sh++)
							{
								if(IIP==snakehead[sh])
								{
									break;
								}
							}
							System.out.println(PII+", you feel creepy suddenly.");
							System.out.println("You find a snake staring at you.");
							System.out.println("Maybe it is hungry?");
							if(biscuitsamout>0)
							{
								System.out.println("You look in your pocket and all you can call food is biscuits.");
								System.out.println("You threw the biscuit to the snake. ");
								System.out.println("Even though you know that snakes do not like it.");
								biscuitsamout--;
								System.out.println("It is working! The snake began to bite the biscuit.");
								System.out.println("The snake's attention is off you, "+PII+" !");
								System.out.println("Get out of here before the snake finds out it is been tricked!");
								System.out.println("You have "+biscuitsamout+"biscuit left");
							}
							if(stickamout>0)
							{
								System.out.println(PII+", you have nothing to distract a snake from.");
								System.out.println("The stick you picked up before should bring some sense of security.");
								System.out.println("You wave the stick hard, hoping to hit the snake.");
								if(snakehead[sh]<90)
								{
									System.out.println("The snake was hit. Well done, snake is scared now.");
									nsh=snakehead[sh]+10;
									boolean newsnake = contains(snakehead,nsh);
									if(newsnake)
									{
										System.out.println("However, instead of running away, the snake looks at you fiercely");
										IIP--;
										System.out.println("Take a step back to avoid the snake's revenge.");
										System.out.println(PII+", your current position is"+IIP);
									}
									else
									{
										snakehead[sh]=nsh;
										System.out.println("The snake gives you a vicious look and runs away.");								
										System.out.println("Hopeing do not see that snake again.");
									}								
								}
								else
								{
									System.out.println("The snake was hit. Well done, snake is scared now.");
									System.out.println("However, instead of running away, the snake looks at you fiercely");
									IIP--;
									System.out.println("Take a step back to avoid the snake's revenge.");
									System.out.println(PII+", your current position is"+IIP);
								}
								System.out.println("Anyway, the stick is broken.");
								System.out.println("Throw it away. It is useless.");
								stickamout--;
								System.out.println("Now, you have "+stickamout+"stick");
							}
							else
							{
								System.out.println(PII+" you do not have anything to help you.");
								System.out.println("Now you have to run.");
								System.out.println("Hoping the snake will not catch up.");
								System.out.println("Or pray it is not a poisonous snake?");
								IIP=snaketail[sh];
								System.out.println("Fortunately, the snake did not come.");
								System.out.println(PII+", your current position is "+IIP);
							}
						}
					
					}
					
					if(point==6)
					{
						System.out.println("Luckly！ You get 6 points before.");
						System.out.println("That means you will get a reward.");
						point=random.nextInt(5)+1;
						System.out.println("The reward is that you will take "+point+" extra step(s) forward.");
						if(IIP+point>100)
						{
							System.out.println("Sorry, you can not move because you are going to be out of field.");
						}
						else
						{
							System.out.println("You can move "+point+" step(s) forward.");
							IIP=IIP+point;
							System.out.println("Your current position is "+IIP);					
						}
						boolean meetladder = contains(ladderhead,IIP);
						if(meetladder)
						{
							System.out.println("You found a ladder!");
							System.out.println("Go up the ladder.");
							for(lh=0;lh<ladderhead.length;lh++)
							{
								if(IIP==ladderhead[lh])
								{
									break;
								}
							}
							IIP=laddertail[lh];
							System.out.println(PII+", your current position is"+IIP);
						}
						if(IIP==stickpositionA || IIP==stickpositionB)
						{
							System.out.println(PII+" is armed!");
							System.out.println("This abandoned stick may be used to ward off danger.");
							System.out.println(" But it seems that just can only be used once.");
							stickamout++;
							System.out.println(PII+" you have "+stickamout+"stick(s) now");
						}
						if(IIP==biscuitspositionA ||IIP==biscuitspositionB)
						{
							System.out.println(PII+" you find a forgotten biscuit.");
							System.out.println("But you are not hungry right now. Maybe it has other uses?");
							System.out.println("Wishing this biscuit had not expired.");
							biscuitsamout++;
							System.out.println(PII+" you have "+biscuitsamout+"biscuit(s) now");
						}
						boolean meetsnake = contains(snakehead,IIP);
						if(meetsnake)
						{
							for(sh=0;sh<snakehead.length;sh++)
							{
								if(IIP==snakehead[sh])
								{
									break;
								}
							}
							System.out.println(PII+", you feel creepy suddenly.");
							System.out.println("You find a snake staring at you.");
							System.out.println("Maybe it is hungry?");
							if(biscuitsamout>0)
							{
								System.out.println("You look in your pocket and all you can call food is biscuits.");
								System.out.println("You threw the biscuit to the snake. ");
								System.out.println("Even though you know that snakes do not like it.");
								biscuitsamout--;
								System.out.println("It is working! The snake began to bite the biscuit.");
								System.out.println("The snake's attention is off you, "+PII+" !");
								System.out.println("Get out of here before the snake finds out it is been tricked!");
								System.out.println("You have "+biscuitsamout+"biscuit left");
							}
							if(stickamout>0)
							{
								System.out.println(PII+", you have nothing to distract a snake from.");
								System.out.println("The stick you picked up before should bring some sense of security.");
								System.out.println("You wave the stick hard, hoping to hit the snake.");
								if(snakehead[sh]<90)
								{
									System.out.println("The snake was hit. Well done, snake is scared now.");
									nsh=snakehead[sh]+10;
									boolean newsnake = contains(snakehead,nsh);
									if(newsnake)
									{
										System.out.println("However, instead of running away, the snake looks at you fiercely");
										IIP--;
										System.out.println("Take a step back to avoid the snake's revenge.");
										System.out.println(PII+", your current position is"+IIP);
									}
									else
									{
										snakehead[sh]=nsh;
										System.out.println("The snake gives you a vicious look and runs away.");								
										System.out.println("Hopeing do not see that snake again.");
									}								
								}
								else
								{
									System.out.println("The snake was hit. Well done, snake is scared now.");
									System.out.println("However, instead of running away, the snake looks at you fiercely");
									IIP--;
									System.out.println("Take a step back to avoid the snake's revenge.");
									System.out.println(PII+", your current position is"+IIP);
								}
								System.out.println("Anyway, the stick is broken.");
								System.out.println("Throw it away. It is useless.");
								stickamout--;
								System.out.println("Now, you have "+stickamout+"stick");
							}
							else
							{
								System.out.println(PII+" you do not have anything to help you.");
								System.out.println("Now you have to run.");
								System.out.println("Hoping the snake will not catch up.");
								System.out.println("Or pray it is not a poisonous snake?");
								IIP=snaketail[sh];
								System.out.println("Fortunately, the snake did not come.");
								System.out.println(PII+", your current position is "+IIP);
							}
						}
					
					}
					for(int a=0;a<10;a++)
					{
						for(int b=1;b<=10;b++)
						{
							sum=10*a+b;
							if(sum==IP&&sum==IIP)
							{
								System.out.print("ALL ");
							}
							else if(sum==IP)
							{
								System.out.print("1p  ");
							}
							else if(sum==IIP)
							{
								System.out.print("2p  ");
							}
							else
							{
								System.out.print(String.format("%03d",sum)+" ");
							}
						}
						System.out.println("\n");
					}
					if(IIP==100)
					{
						System.out.println(PII+" you are at the finish line.");
						System.out.println("Congratulations,you win!");
					}
					else
					{
						flag=1;
					}
				}				
			}
			System.out.println("Thank you for playing this game!");
		}
		if(player == 3) 
		{
			System.out.println(PI+" and "+PII+" you are at the starting point now. Are you ready?");
			System.out.println("You can enter anything to start the game!");
			start=input.next();
			while(IP<100 && IIP<100 && IIIP<100)
			{
				if(flag==1)
				{
					System.out.println(PI+", your positiong is "+IP);
					System.out.println("You can enter anything to roll dice!");
					dice=input.next();
					point=random.nextInt(5)+1;
					System.out.println("The point of dice is"+point);
					if(IP+point>100)
					{
						System.out.println("Sorry, you can not move because you are going to be out of field.");
					}
					else
					{
						System.out.println("You can move "+point+" step(s) forward.");
						IP=IP+point;					
						boolean meetladder = contains(ladderhead,IP);
						if(meetladder)
						{
							System.out.println("You found a ladder!");
							System.out.println("Go up the ladder.");
							for(lh=0;lh<ladderhead.length;lh++)
							{
								if(IP==ladderhead[lh])
								{
									break;
								}
							}
							IP=laddertail[lh];
							System.out.println(PI+", your current position is"+IP);
						}
						if(IP==stickpositionA || IP==stickpositionB)
						{
							System.out.println(PI+" is armed!");
							System.out.println("This abandoned stick may be used to ward off danger.");
							System.out.println(" But it seems that just can only be used once.");
							stickamout++;
							System.out.println(PI+" you have "+stickamout+"stick(s) now");
						}
						if(IP==biscuitspositionA ||IP==biscuitspositionB)
						{
							System.out.println(PI+" you find a forgotten biscuit.");
							System.out.println("But you are not hungry right now. Maybe it has other uses?");
							System.out.println("Wishing this biscuit had not expired.");
							biscuitsamout++;
							System.out.println(PI+" you have "+biscuitsamout+"biscuit(s) now");
						}
						boolean meetsnake = contains(snakehead,IP);
						if(meetsnake)
						{
							for(sh=0;sh<snakehead.length;sh++)
							{
								if(IP==snakehead[sh])
								{
									break;
								}
							}
							System.out.println(PI+", you feel creepy suddenly.");
							System.out.println("You find a snake staring at you.");
							System.out.println("Maybe it is hungry?");
							if(biscuitsamout>0)
							{
								System.out.println("You look in your pocket and all you can call food is biscuits.");
								System.out.println("You threw the biscuit to the snake. ");
								System.out.println("Even though you know that snakes do not like it.");
								biscuitsamout--;
								System.out.println("It is working! The snake began to bite the biscuit.");
								System.out.println("The snake's attention is off you, "+PI+" !");
								System.out.println("Get out of here before the snake finds out it is been tricked!");
								System.out.println("You have "+biscuitsamout+"biscuit left");
							}
							if(stickamout>0)
							{
								System.out.println(PI+", you have nothing to distract a snake from.");
								System.out.println("The stick you picked up before should bring some sense of security.");
								System.out.println("You wave the stick hard, hoping to hit the snake.");
								if(snakehead[sh]<90)
								{
									System.out.println("The snake was hit. Well done, snake is scared now.");
									nsh=snakehead[sh]+10;
									boolean newsnake = contains(snakehead,nsh);
									if(newsnake)
									{
										System.out.println("However, instead of running away, the snake looks at you fiercely");
										IP--;
										System.out.println("Take a step back to avoid the snake's revenge.");
										System.out.println(PI+", your current position is"+IP);
									}
									else
									{
										snakehead[sh]=nsh;
										System.out.println("The snake gives you a vicious look and runs away.");								
										System.out.println("Hopeing do not see that snake again.");
									}								
								}
								else
								{
									System.out.println("The snake was hit. Well done, snake is scared now.");
									System.out.println("However, instead of running away, the snake looks at you fiercely");
									IP--;
									System.out.println("Take a step back to avoid the snake's revenge.");
									System.out.println(PI+", your current position is"+IP);
								}
								System.out.println("Anyway, the stick is broken.");
								System.out.println("Throw it away. It is useless.");
								stickamout--;
								System.out.println("Now, you have "+stickamout+"stick");
							}
							else
							{
								System.out.println(PI+" you do not have anything to help you.");
								System.out.println("Now you have to run.");
								System.out.println("Hoping the snake will not catch up.");
								System.out.println("Or pray it is not a poisonous snake?");
								IP=snaketail[sh];
								System.out.println("Fortunately, the snake did not come.");
								System.out.println(PI+", your current position is "+IP);
							}
						}
					}					
					if(point==6)
					{
						System.out.println("Luckly！ You get 6 points before.");
						System.out.println("That means you will get a reward.");
						point=random.nextInt(5)+1;
						System.out.println("The reward is that you will take "+point+" extra step(s) forward.");
						if(IP+point>100)
						{
							System.out.println("Sorry, you can not move because you are going to be out of field.");
						}
						else
						{
							System.out.println("You can move"+point+"step(s) forward.");
							IP=IP+point;
							System.out.println("Your current position is "+IP);					
						}
						boolean meetladder = contains(ladderhead,IP);
						if(meetladder)
						{
							System.out.println("You found a ladder!");
							System.out.println("Go up the ladder.");
							for(lh=0;lh<ladderhead.length;lh++)
							{
								if(IP==ladderhead[lh])
								{
									break;
								}
							}
							IP=laddertail[lh];
							System.out.println(PI+", your current position is"+IP);
						}
						if(IP==stickpositionA || IP==stickpositionB)
						{
							System.out.println(PI+" is armed!");
							System.out.println("This abandoned stick may be used to ward off danger.");
							System.out.println(" But it seems that just can only be used once.");
							stickamout++;
							System.out.println(PI+" you have "+stickamout+"stick(s) now");
						}
						if(IP==biscuitspositionA ||IP==biscuitspositionB)
						{
							System.out.println(PI+" you find a forgotten biscuit.");
							System.out.println("But you are not hungry right now. Maybe it has other uses?");
							System.out.println("Wishing this biscuit had not expired.");
							biscuitsamout++;
							System.out.println(PI+" you have "+biscuitsamout+"biscuit(s) now");
						}
						boolean meetsnake = contains(snakehead,IP);
						if(meetsnake)
						{
							for(sh=0;sh<snakehead.length;sh++)
							{
								if(IP==snakehead[sh])
								{
									break;
								}
							}
							System.out.println(PI+", you feel creepy suddenly.");
							System.out.println("You find a snake staring at you.");
							System.out.println("Maybe it is hungry?");
							if(biscuitsamout>0)
							{
								System.out.println("You look in your pocket and all you can call food is biscuits.");
								System.out.println("You threw the biscuit to the snake. ");
								System.out.println("Even though you know that snakes do not like it.");
								biscuitsamout--;
								System.out.println("It is working! The snake began to bite the biscuit.");
								System.out.println("The snake's attention is off you, "+PI+" !");
								System.out.println("Get out of here before the snake finds out it is been tricked!");
								System.out.println("You have "+biscuitsamout+"biscuit left");
							}
							if(stickamout>0)
							{
								System.out.println(PI+", you have nothing to distract a snake from.");
								System.out.println("The stick you picked up before should bring some sense of security.");
								System.out.println("You wave the stick hard, hoping to hit the snake.");
								if(snakehead[sh]<90)
								{
									System.out.println("The snake was hit. Well done, snake is scared now.");
									nsh=snakehead[sh]+10;
									boolean newsnake = contains(snakehead,nsh);
									if(newsnake)
									{
										System.out.println("However, instead of running away, the snake looks at you fiercely");
										IP--;
										System.out.println("Take a step back to avoid the snake's revenge.");
										System.out.println(PI+", your current position is"+IP);
									}
									else
									{
										snakehead[sh]=nsh;
										System.out.println("The snake gives you a vicious look and runs away.");								
										System.out.println("Hopeing do not see that snake again.");
									}								
								}
								else
								{
									System.out.println("The snake was hit. Well done, snake is scared now.");
									System.out.println("However, instead of running away, the snake looks at you fiercely");
									IP--;
									System.out.println("Take a step back to avoid the snake's revenge.");
									System.out.println(PI+", your current position is"+IP);
								}
								System.out.println("Anyway, the stick is broken.");
								System.out.println("Throw it away. It is useless.");
								stickamout--;
								System.out.println("Now, you have "+stickamout+"stick");
							}
							else
							{
								System.out.println(PI+" you do not have anything to help you.");
								System.out.println("Now you have to run.");
								System.out.println("Hoping the snake will not catch up.");
								System.out.println("Or pray it is not a poisonous snake?");
								IP=snaketail[sh];
								System.out.println("Fortunately, the snake did not come.");
								System.out.println(PI+", your current position is "+IP);
							}
						}
					
					}
					for(int a=0;a<10;a++)
					{
						for(int b=1;b<=10;b++)
						{
							sum=10*a+b;
							if(sum==IP&&sum==IIP&&sum==IIIP)
							{
								System.out.print("ALL ");
							}
							else if(sum==IP&&sum==IIP&&sum!=IIIP)
							{
								System.out.print("1p2p");
							}
							else if(sum==IP&&sum!=IIP&&sum==IIIP)
							{
								System.out.print("1p3p");
							}
							else if(sum!=IP&&sum==IIP&&sum==IIIP)
							{
								System.out.print("2p3p");
							}
							else if(sum==IP)
							{
								System.out.print("1p  ");
							}
							else if(sum==IIP)
							{
								System.out.print("2p  ");
							}
							else if(sum==IIIP)
							{
								System.out.print("3p  ");
							}
							else
							{
								System.out.print(String.format("%03d",sum)+" ");
							}
						}
						System.out.println("\n");
					}
					if(IP==100)
					{
						System.out.println(PI+" you are at the finish line.");
						System.out.println("Congratulations,you win!");
					}
					else
					{
						flag=2;
					}
				}
				if(flag==2)
				{
					System.out.println(PII+", your positiong is "+IIP);
					System.out.println("You can enter anything to roll dice!");
					dice=input.next();
					point=random.nextInt(5)+1;
					System.out.println("The point of dice is"+point);
					if(IIP+point>100)
					{
						System.out.println("Sorry, you can not move because you are going to be out of field.");
					}
					else
					{
						System.out.println("You can move "+point+" step(s) forward.");
						IIP=IIP+point;					
						boolean meetladder = contains(ladderhead,IIP);
						if(meetladder)
						{
							System.out.println("You found a ladder!");
							System.out.println("Go up the ladder.");
							for(lh=0;lh<ladderhead.length;lh++)
							{
								if(IIP==ladderhead[lh])
								{
									break;
								}
							}
							IIP=laddertail[lh];
							System.out.println(PII+", your current position is"+IIP);
						}
						if(IIP==stickpositionA || IIP==stickpositionB)
						{
							System.out.println(PII+" is armed!");
							System.out.println("This abandoned stick may be used to ward off danger.");
							System.out.println(" But it seems that just can only be used once.");
							stickamout++;
							System.out.println(PII+" you have "+stickamout+"stick(s) now");
						}
						if(IIP==biscuitspositionA ||IIP==biscuitspositionB)
						{
							System.out.println(PII+" you find a forgotten biscuit.");
							System.out.println("But you are not hungry right now. Maybe it has other uses?");
							System.out.println("Wishing this biscuit had not expired.");
							biscuitsamout++;
							System.out.println(PII+" you have "+biscuitsamout+"biscuit(s) now");
						}
						boolean meetsnake = contains(snakehead,IIP);
						if(meetsnake)
						{
							for(sh=0;sh<snakehead.length;sh++)
							{
								if(IIP==snakehead[sh])
								{
									break;
								}
							}
							System.out.println(PII+", you feel creepy suddenly.");
							System.out.println("You find a snake staring at you.");
							System.out.println("Maybe it is hungry?");
							if(biscuitsamout>0)
							{
								System.out.println("You look in your pocket and all you can call food is biscuits.");
								System.out.println("You threw the biscuit to the snake. ");
								System.out.println("Even though you know that snakes do not like it.");
								biscuitsamout--;
								System.out.println("It is working! The snake began to bite the biscuit.");
								System.out.println("The snake's attention is off you, "+PII+" !");
								System.out.println("Get out of here before the snake finds out it is been tricked!");
								System.out.println("You have "+biscuitsamout+"biscuit left");
							}
							if(stickamout>0)
							{
								System.out.println(PII+", you have nothing to distract a snake from.");
								System.out.println("The stick you picked up before should bring some sense of security.");
								System.out.println("You wave the stick hard, hoping to hit the snake.");
								if(snakehead[sh]<90)
								{
									System.out.println("The snake was hit. Well done, snake is scared now.");
									nsh=snakehead[sh]+10;
									boolean newsnake = contains(snakehead,nsh);
									if(newsnake)
									{
										System.out.println("However, instead of running away, the snake looks at you fiercely");
										IIP--;
										System.out.println("Take a step back to avoid the snake's revenge.");
										System.out.println(PII+", your current position is"+IIP);
									}
									else
									{
										snakehead[sh]=nsh;
										System.out.println("The snake gives you a vicious look and runs away.");								
										System.out.println("Hopeing do not see that snake again.");
									}								
								}
								else
								{
									System.out.println("The snake was hit. Well done, snake is scared now.");
									System.out.println("However, instead of running away, the snake looks at you fiercely");
									IIP--;
									System.out.println("Take a step back to avoid the snake's revenge.");
									System.out.println(PII+", your current position is"+IIP);
								}
								System.out.println("Anyway, the stick is broken.");
								System.out.println("Throw it away. It is useless.");
								stickamout--;
								System.out.println("Now, you have "+stickamout+"stick");
							}
							else
							{
								System.out.println(PII+" you do not have anything to help you.");
								System.out.println("Now you have to run.");
								System.out.println("Hoping the snake will not catch up.");
								System.out.println("Or pray it is not a poisonous snake?");
								IIP=snaketail[sh];
								System.out.println("Fortunately, the snake did not come.");
								System.out.println(PII+", your current position is "+IIP);
							}
						}
					}
					
					if(point==6)
					{
						System.out.println("Luckly！ You get 6 points before.");
						System.out.println("That means you will get a reward.");
						point=random.nextInt(5)+1;
						System.out.println("The reward is that you will take "+point+" extra step(s) forward.");
						if(IIP+point>100)
						{
							System.out.println("Sorry, you can not move because you are going to be out of field.");
						}
						else
						{
							System.out.println("You can move "+point+" step(s) forward.");
							IIP=IIP+point;
							System.out.println("Your current position is "+IIP);					
						}
						boolean meetladder = contains(ladderhead,IIP);
						if(meetladder)
						{
							System.out.println("You found a ladder!");
							System.out.println("Go up the ladder.");
							for(lh=0;lh<ladderhead.length;lh++)
							{
								if(IIP==ladderhead[lh])
								{
									break;
								}
							}
							IIP=laddertail[lh];
							System.out.println(PII+", your current position is"+IIP);
						}
						if(IIP==stickpositionA || IIP==stickpositionB)
						{
							System.out.println(PII+" is armed!");
							System.out.println("This abandoned stick may be used to ward off danger.");
							System.out.println(" But it seems that just can only be used once.");
							stickamout++;
							System.out.println(PII+" you have "+stickamout+"stick(s) now");
						}
						if(IIP==biscuitspositionA ||IIP==biscuitspositionB)
						{
							System.out.println(PII+" you find a forgotten biscuit.");
							System.out.println("But you are not hungry right now. Maybe it has other uses?");
							System.out.println("Wishing this biscuit had not expired.");
							biscuitsamout++;
							System.out.println(PII+" you have "+biscuitsamout+"biscuit(s) now");
						}
						boolean meetsnake = contains(snakehead,IIP);
						if(meetsnake)
						{
							for(sh=0;sh<snakehead.length;sh++)
							{
								if(IIP==snakehead[sh])
								{
									break;
								}
							}
							System.out.println(PII+", you feel creepy suddenly.");
							System.out.println("You find a snake staring at you.");
							System.out.println("Maybe it is hungry?");
							if(biscuitsamout>0)
							{
								System.out.println("You look in your pocket and all you can call food is biscuits.");
								System.out.println("You threw the biscuit to the snake. ");
								System.out.println("Even though you know that snakes do not like it.");
								biscuitsamout--;
								System.out.println("It is working! The snake began to bite the biscuit.");
								System.out.println("The snake's attention is off you, "+PII+" !");
								System.out.println("Get out of here before the snake finds out it is been tricked!");
								System.out.println("You have "+biscuitsamout+"biscuit left");
							}
							if(stickamout>0)
							{
								System.out.println(PII+", you have nothing to distract a snake from.");
								System.out.println("The stick you picked up before should bring some sense of security.");
								System.out.println("You wave the stick hard, hoping to hit the snake.");
								if(snakehead[sh]<90)
								{
									System.out.println("The snake was hit. Well done, snake is scared now.");
									nsh=snakehead[sh]+10;
									boolean newsnake = contains(snakehead,nsh);
									if(newsnake)
									{
										System.out.println("However, instead of running away, the snake looks at you fiercely");
										IIP--;
										System.out.println("Take a step back to avoid the snake's revenge.");
										System.out.println(PII+", your current position is"+IIP);
									}
									else
									{
										snakehead[sh]=nsh;
										System.out.println("The snake gives you a vicious look and runs away.");								
										System.out.println("Hopeing do not see that snake again.");
									}								
								}
								else
								{
									System.out.println("The snake was hit. Well done, snake is scared now.");
									System.out.println("However, instead of running away, the snake looks at you fiercely");
									IIP--;
									System.out.println("Take a step back to avoid the snake's revenge.");
									System.out.println(PII+", your current position is"+IIP);
								}
								System.out.println("Anyway, the stick is broken.");
								System.out.println("Throw it away. It is useless.");
								stickamout--;
								System.out.println("Now, you have "+stickamout+"stick");
							}
							else
							{
								System.out.println(PII+" you do not have anything to help you.");
								System.out.println("Now you have to run.");
								System.out.println("Hoping the snake will not catch up.");
								System.out.println("Or pray it is not a poisonous snake?");
								IIP=snaketail[sh];
								System.out.println("Fortunately, the snake did not come.");
								System.out.println(PII+", your current position is "+IIP);
							}
						}					
					}
					for(int a=0;a<10;a++)
					{
						for(int b=1;b<=10;b++)
						{
							sum=10*a+b;
							if(sum==IP&&sum==IIP&&sum==IIIP)
							{
								System.out.print("ALL ");
							}
							else if(sum==IP&&sum==IIP&&sum!=IIIP)
							{
								System.out.print("1p2p");
							}
							else if(sum==IP&&sum!=IIP&&sum==IIIP)
							{
								System.out.print("1p3p");
							}
							else if(sum!=IP&&sum==IIP&&sum==IIIP)
							{
								System.out.print("2p3p");
							}
							else if(sum==IP)
							{
								System.out.print("1p  ");
							}
							else if(sum==IIP)
							{
								System.out.print("2p  ");
							}
							else if(sum==IIIP)
							{
								System.out.print("3p  ");
							}
							else
							{
								System.out.print(String.format("%03d",sum)+" ");
							}
						}
						System.out.println("\n");
					}
					if(IIP==100)
					{
						System.out.println(PII+" you are at the finish line.");
						System.out.println("Congratulations,you win!");
					}
					else
					{
						flag=3;
					}
				}
				if(flag==3)
				{
					System.out.println(PIII+", your positiong is "+IIIP);
					System.out.println("You can enter anything to roll dice!");
					dice=input.next();
					point=random.nextInt(5)+1;
					System.out.println("The point of dice is"+point);
					if(IIIP+point>100)
					{
						System.out.println("Sorry, you can not move because you are going to be out of field.");
					}
					else
					{
						System.out.println("You can move "+point+" step(s) forward.");
						IIIP=IIIP+point;					
						boolean meetladder = contains(ladderhead,IIIP);
						if(meetladder)
						{
							System.out.println("You found a ladder!");
							System.out.println("Go up the ladder.");
							for(lh=0;lh<ladderhead.length;lh++)
							{
								if(IIIP==ladderhead[lh])
								{
									break;
								}
							}
							IIIP=laddertail[lh];
							System.out.println(PIII+", your current position is"+IIIP);
						}
						if(IIIP==stickpositionA || IIIP==stickpositionB)
						{
							System.out.println(PIII+" is armed!");
							System.out.println("This abandoned stick may be used to ward off danger.");
							System.out.println(" But it seems that just can only be used once.");
							stickamout++;
							System.out.println(PIII+" you have "+stickamout+"stick(s) now");
						}
						if(IIIP==biscuitspositionA ||IIIP==biscuitspositionB)
						{
							System.out.println(PIII+" you find a forgotten biscuit.");
							System.out.println("But you are not hungry right now. Maybe it has other uses?");
							System.out.println("Wishing this biscuit had not expired.");
							biscuitsamout++;
							System.out.println(PIII+" you have "+biscuitsamout+"biscuit(s) now");
						}
						boolean meetsnake = contains(snakehead,IIIP);
						if(meetsnake)
						{
							for(sh=0;sh<snakehead.length;sh++)
							{
								if(IIIP==snakehead[sh])
								{
									break;
								}
							}
							System.out.println(PIII+", you feel creepy suddenly.");
							System.out.println("You find a snake staring at you.");
							System.out.println("Maybe it is hungry?");
							if(biscuitsamout>0)
							{
								System.out.println("You look in your pocket and all you can call food is biscuits.");
								System.out.println("You threw the biscuit to the snake. ");
								System.out.println("Even though you know that snakes do not like it.");
								biscuitsamout--;
								System.out.println("It is working! The snake began to bite the biscuit.");
								System.out.println("The snake's attention is off you, "+PIII+" !");
								System.out.println("Get out of here before the snake finds out it is been tricked!");
								System.out.println("You have "+biscuitsamout+"biscuit left");
							}
							if(stickamout>0)
							{
								System.out.println(PIII+", you have nothing to distract a snake from.");
								System.out.println("The stick you picked up before should bring some sense of security.");
								System.out.println("You wave the stick hard, hoping to hit the snake.");
								if(snakehead[sh]<90)
								{
									System.out.println("The snake was hit. Well done, snake is scared now.");
									nsh=snakehead[sh]+10;
									boolean newsnake = contains(snakehead,nsh);
									if(newsnake)
									{
										System.out.println("However, instead of running away, the snake looks at you fiercely");
										IIIP--;
										System.out.println("Take a step back to avoid the snake's revenge.");
										System.out.println(PIII+", your current position is"+IIIP);
									}
									else
									{
										snakehead[sh]=nsh;
										System.out.println("The snake gives you a vicious look and runs away.");								
										System.out.println("Hopeing do not see that snake again.");
									}								
								}
								else
								{
									System.out.println("The snake was hit. Well done, snake is scared now.");
									System.out.println("However, instead of running away, the snake looks at you fiercely");
									IIIP--;
									System.out.println("Take a step back to avoid the snake's revenge.");
									System.out.println(PIII+", your current position is"+IIIP);
								}
								System.out.println("Anyway, the stick is broken.");
								System.out.println("Throw it away. It is useless.");
								stickamout--;
								System.out.println("Now, you have "+stickamout+"stick");
							}
							else
							{
								System.out.println(PIII+" you do not have anything to help you.");
								System.out.println("Now you have to run.");
								System.out.println("Hoping the snake will not catch up.");
								System.out.println("Or pray it is not a poisonous snake?");
								IIIP=snaketail[sh];
								System.out.println("Fortunately, the snake did not come.");
								System.out.println(PIII+", your current position is "+IIIP);
							}
						}
					}				
					if(point==6)
					{
						System.out.println("Luckly！ You get 6 points before.");
						System.out.println("That means you will get a reward.");
						point=random.nextInt(5)+1;
						System.out.println("The reward is that you will take "+point+" extra step(s) forward.");
						if(IIIP+point>100)
						{
							System.out.println("Sorry, you can not move because you are going to be out of field.");
						}
						else
						{
							System.out.println("You can move "+point+" step(s) forward.");
							IIIP=IIIP+point;
							System.out.println("Your current position is "+IIIP);					
						}
						boolean meetladder = contains(ladderhead,IIIP);
						if(meetladder)
						{
							System.out.println("You found a ladder!");
							System.out.println("Go up the ladder.");
							for(lh=0;lh<ladderhead.length;lh++)
							{
								if(IIIP==ladderhead[lh])
								{
									break;
								}
							}
							IIIP=laddertail[lh];
							System.out.println(PIII+", your current position is"+IIIP);
						}
						if(IIIP==stickpositionA || IIIP==stickpositionB)
						{
							System.out.println(PIII+" is armed!");
							System.out.println("This abandoned stick may be used to ward off danger.");
							System.out.println(" But it seems that just can only be used once.");
							stickamout++;
							System.out.println(PIII+" you have "+stickamout+"stick(s) now");
						}
						if(IIIP==biscuitspositionA ||IIIP==biscuitspositionB)
						{
							System.out.println(PIII+" you find a forgotten biscuit.");
							System.out.println("But you are not hungry right now. Maybe it has other uses?");
							System.out.println("Wishing this biscuit had not expired.");
							biscuitsamout++;
							System.out.println(PIII+" you have "+biscuitsamout+"biscuit(s) now");
						}
						boolean meetsnake = contains(snakehead,IIIP);
						if(meetsnake)
						{
							for(sh=0;sh<snakehead.length;sh++)
							{
								if(IIIP==snakehead[sh])
								{
									break;
								}
							}
							System.out.println(PIII+", you feel creepy suddenly.");
							System.out.println("You find a snake staring at you.");
							System.out.println("Maybe it is hungry?");
							if(biscuitsamout>0)
							{
								System.out.println("You look in your pocket and all you can call food is biscuits.");
								System.out.println("You threw the biscuit to the snake. ");
								System.out.println("Even though you know that snakes do not like it.");
								biscuitsamout--;
								System.out.println("It is working! The snake began to bite the biscuit.");
								System.out.println("The snake's attention is off you, "+PIII+" !");
								System.out.println("Get out of here before the snake finds out it is been tricked!");
								System.out.println("You have "+biscuitsamout+"biscuit left");
							}
							if(stickamout>0)
							{
								System.out.println(PIII+", you have nothing to distract a snake from.");
								System.out.println("The stick you picked up before should bring some sense of security.");
								System.out.println("You wave the stick hard, hoping to hit the snake.");
								if(snakehead[sh]<90)
								{
									System.out.println("The snake was hit. Well done, snake is scared now.");
									nsh=snakehead[sh]+10;
									boolean newsnake = contains(snakehead,nsh);
									if(newsnake)
									{
										System.out.println("However, instead of running away, the snake looks at you fiercely");
										IIIP--;
										System.out.println("Take a step back to avoid the snake's revenge.");
										System.out.println(PIII+", your current position is"+IIIP);
									}
									else
									{
										snakehead[sh]=nsh;
										System.out.println("The snake gives you a vicious look and runs away.");								
										System.out.println("Hopeing do not see that snake again.");
									}								
								}
								else
								{
									System.out.println("The snake was hit. Well done, snake is scared now.");
									System.out.println("However, instead of running away, the snake looks at you fiercely");
									IIIP--;
									System.out.println("Take a step back to avoid the snake's revenge.");
									System.out.println(PIII+", your current position is"+IIIP);
								}
								System.out.println("Anyway, the stick is broken.");
								System.out.println("Throw it away. It is useless.");
								stickamout--;
								System.out.println("Now, you have "+stickamout+"stick");
							}
							else
							{
								System.out.println(PIII+" you do not have anything to help you.");
								System.out.println("Now you have to run.");
								System.out.println("Hoping the snake will not catch up.");
								System.out.println("Or pray it is not a poisonous snake?");
								IIIP=snaketail[sh];
								System.out.println("Fortunately, the snake did not come.");
								System.out.println(PIII+", your current position is "+IIIP);
							}
						}
					
					}
					for(int a=0;a<10;a++)
					{
						for(int b=1;b<=10;b++)
						{
							sum=10*a+b;
							if(sum==IP&&sum==IIP&&sum==IIIP)
							{
								System.out.print("ALL ");
							}
							else if(sum==IP&&sum==IIP&&sum!=IIP)
							{
								System.out.print("1p2p");
							}
							else if(sum==IP&&sum!=IIP&&sum==IIIP)
							{
								System.out.print("1p3p");
							}
							else if(sum!=IP&&sum==IIP&&sum==IIIP)
							{
								System.out.print("2p3p");
							}
							else if(sum==IP)
							{
								System.out.print("1p  ");
							}
							else if(sum==IIP)
							{
								System.out.print("2p  ");
							}
							else if(sum==IIIP)
							{
								System.out.print("3p  ");
							}
							else
							{
								System.out.print(String.format("%03d",sum)+" ");
							}
						}
						System.out.println("\n");
					}
					if(IIIP==100)
					{
						System.out.println(PIII+" you are at the finish line.");
						System.out.println("Congratulations,you win!");
					}
					else
					{
						flag=1;
					}
				}
			}
			System.out.println("Thank you for playing this game!");
		}
	}//close SnakeandLadderB
	
	public static boolean JUDGE(int[] ladderhead,int num)
	 {
		 for(int I=0;I<ladderhead.length;I++)
		 {
			 if(num==ladderhead[I])
			 {
				 return false;
			 }
		 }
		 return true;
	 }//subroutine of snake and ladder B
	
	 private static Integer[] getC(Integer[] ALL, Integer[] arr)
	 {
		 Set<Integer> set = new HashSet<Integer>(Arrays.asList(ALL.length > arr.length ? ALL : arr));
		 for (Integer SUM : ALL.length > arr.length ? arr : ALL)
	        {
	            if (set.contains(SUM))
	            {
	                set.remove(SUM);
	            } else
	            {
	                set.add(SUM);
	            }
	        }
	        Integer[] D = {};
	        return set.toArray(D);
	 }//subroutine of snake and ladder B	 
	 private static boolean contains(int[] arr, int val) 
	 {
		 for (int i=0; i<arr.length; i++) 
		 {
			 if (arr[i]==val) 
				 return true; 
		 }		 
		 return false; 
	 }//subroutine of snake and ladder B
	 //end game snake and ladder B

}//close StartMenu
