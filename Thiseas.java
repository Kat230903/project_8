/* 
 * //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------                                
 * AIKATERINH PALAIOLOGOY (p3210149)
 * IOANNA KARDARA (p3210065)
 * file name: Thiseas.java
 * //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 */

import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.lang.StringIndexOutOfBoundsException; 

class Thiseas {
	private static char[][] maze;
	private static int lines; //Grammes
	private static int columns; //Sthles
	private static int Xstart;
	private static int Ystart;

	static int realLines = 0; //to check if maze dimentions are correct

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	public static void ReadFile(String file){
		
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine(); //1h grammh --> diastaseis labyrhn8oy
			boolean flag = true;
			int i = 0;
			int Enumber = 0; //to count the entrances
			int RightInfo = 0; //to check if the maze's elements are correct (0,1 or E)

		   while (line != null){
				realLines++;
				String token = line.trim().substring(0).trim();
                StringTokenizer st = new StringTokenizer(line," ");

				if (flag) {
					String [] parts;
					parts = line.split(" ");

					try {
						Integer.parseInt(parts[0]);
						Integer.parseInt(parts[1]);
					} 

					catch (NumberFormatException e) { //an den mporoyn na ginoyn Integers tote exv error giati einai se la8os morfh
						System.out.println("\n\n\n\t[!]ERROR: Wrong, altered or missing information... (maze dimentions can not be used)\n\n\n");
						System.exit(0);						
					}

					if (parts.length!=2) { //an exei sbhstei mia apo tis grammes poy periexoyn xrhsimes plhrofories
						System.out.println("\n\n\n\t[!]ERROR: Wrong data... (something is wrong or might be missing from file)\n\n\n");
						System.exit(0);	
					}

					lines = Integer.parseInt(parts[0]);
					columns = Integer.parseInt(parts[1]);
					System.out.println();
					System.out.println(lines + " " + columns);
					
					line = reader.readLine(); //Paei sthn deyterh grammh --> syntetagmenes arxhs
					
					parts = line.split(" ");

					try {
						Integer.parseInt(parts[0]);
						Integer.parseInt(parts[1]);
					} 

					catch (NumberFormatException ex) { //an den mporoyn na ginoyn Integers tote exv error giati einai se la8os morfh
						System.out.println("\n\n\n\t[!]ERROR: Wrong, altered or missing information... (entrance coordinations can not be used)\n\n\n");
						System.exit(0);						
					}

					if (parts.length!=2) { //an exei sbhstei mia apo tis grammes poy periexoyn xrhsimes plhrofories
						System.out.println("\n\n\n\t[!]ERROR: Wrong data... (something is wrong or might be missing from file)\n\n\n");
						System.exit(0);	
					}

					Xstart = Integer.parseInt(parts[0]);
					Ystart = Integer.parseInt(parts[1]);
					
					flag = false;
					System.out.println(Xstart + " " + Ystart);

					line = reader.readLine(); //Allagh grammhs gia na paei ston labyrhn8o

					String [] realColumns; //ftiaxnei pinaka
					realColumns = line.split(" "); //apo8hkeyei ston pinaka ta stoixeia tis grammhs poy xvrizontai apo keno
					if (realColumns.length != columns) { //an to mege8os toy pinaka den einai idio me ton ari8mo sthlvn poy dinontai tote oi diastaseis einai la8os
							System.out.println("\n\n\n\t[!]ERROR: Wrong maze dimentions or wrong maze formation...\n\n\n");
							System.exit(0);	
						}

					maze = new char[lines][columns]; //To kanoume mia fora gia na min desmeyei mnhmh

				}
				
				int k = 0;
                for (int j=0; j<columns*2-1; j++) { //gia na pros8esv ta stoixeia toy maze toy arxeioy ston pinaka maze
                    char ch = line.charAt(j);
                    if (ch != ' ') {
                        maze[i][k] = ch;
                        k++;
                    }
					if (ch=='E') Enumber++; //gia na dv an yparxoyn polles h kamia eisodoi
					if (ch=='1' || ch=='0' || ch=='E') RightInfo++; //gia na dv an o maze exei la8os stoixeia
                }
                line = reader.readLine();
                i++;		
			    
            } //while
            reader.close(); 

			
			if (realLines != lines) { //an o eri8mos tvn pragmatikvn grammvn (ginetai ++ oso trexei to while) den einai isos me ayton poy grafei tote exv la8os diastaseis
				System.out.println("\n\n\n\t[!]ERROR: Wrong maze dimentions or wrong maze formation...\n\n\n");
				System.exit(0);	
			}
			
			for (int g=0; g<lines; g++) { //typvnei ton pinaka
                for (int h=0; h<columns; h++) {
                    System.out.print(maze[g][h] + " ");
                }
                System.out.print("\n");
			} 

			if (Enumber != 1) { //an o ari8mos eisodvn einai diaforos toy 1 tote yparxei error
				System.out.println("\n\n\n\t[!]ERROR: Entrance Number is wrong... (there should be only 1 Entrance)\n\n\n");
				System.exit(0);
			}

			if (RightInfo != lines*columns) { //an den exv ta katallhla stoixeia ston maze
				System.out.println("\n\n\n\t[!]ERROR: Wrong maze elements... (some of them aren't '0', '1' or 'E')\n\n\n");
				System.exit(0);
			}

			if (maze[Xstart][Ystart] != 'E') { //an to E (eisodos) einai se la8os 8esh apo ayth poy exv orisei sth deyterh grammh toy arxeioy
				System.out.println("\n\n\n\t[!]ERROR: Wrong placement of the entrance...\n\n\n");
				System.exit(0);
			}
        } //try block

		catch (FileNotFoundException e) {
			System.out.println("\n\n\n\t[!]ERROR: The file was not found...\n\n\n");
			System.exit(0);
		}	 

		catch (IOException e) {
			System.out.println("\n\n\n\t[!]ERROR: an error occured while reading line...\n\n\n");
			System.exit(0);
		} 

		catch (StringIndexOutOfBoundsException e) {//////////////////////////////////////
			System.out.println("\n\n\n\t[!]ERROR: Wrong maze dimentions or wrong maze formation...\n\n\n");
			System.exit(0);	
		}

		catch (ArrayIndexOutOfBoundsException e) {//////////////////////////////////////
			System.out.println("\n\n\n\t[!]ERROR: Wrong maze dimentions or wrong maze formation...\n\n\n");
			System.exit(0);	
		}

    }//readFile function
	

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private static void setVisited(int i, int j) { //gia na shmeivnv poy exv paei
		maze[i][j] = 'X';
	}


//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	private static void isReachable(int a, int b) {
		Xstart = a;
		Ystart = b;
		StringStackImpl<Point> stack = new StringStackImpl<Point>(); //8a bazv sth stoiba stoixeia typoy point
		stack.push(new Point(Xstart, Ystart)); //bazv sth stoiba thn prvth kinhsh (afethria)
		int count;
		boolean found = false; //to check if an exit was found
		boolean noExit = false; //to check if there isn't any exit from the maze
		boolean first = true; // to check if it's my first time trying to move into the maze
		
		while (!found && !noExit) { //oso den exv brei ejodo alla yparxei periptvsh na brv kapote (allivs termatizei to programma)
			count = 0; //elegxv posa mhdenika exv gyrv apo th 8esh poy eimai gia na dv posa dia8esima monopatia exv
			if (Ystart+1<=columns-1 && maze[Xstart][Ystart+1]=='0' && !found) { //an den exv brei lysh & paramenv entos orivn an pav mia 8esh dejia (gia sthles) & to stoixeio poy brisketai se ayth th grammh kai thn epomenh sthlh einai 0
				if (Ystart+1==columns-1 || Xstart==lines-1 || Xstart==0) { //an h epomenh sthlh einai h teleytaia | an briskomai sthn prvth h' sthn teleytaia grammh 
					found = true; //brhka ejodo
					Ystart++; //proxvrav mia 8esh dejia 
				}
				
				else {
					count++;
					Ystart++; //pav dejia
					stack.push(new Point(Xstart, Ystart));
					setVisited(Xstart,Ystart);
				}
			} //look right for available path

			if (Ystart-1>=0 && maze[Xstart][Ystart-1]=='0' && !found) { //an den exv brei lysh & paramenv entos orivn an pav mia 8esh aristera (gia sthles) & to stoixeio poy brisketai se ayth th grammh kai thn prohgoymenh sthlh einai 0
				if (Ystart-1==0 || Xstart==lines-1 || Xstart==0) { //an h prohgoymenh sthlh einai h prvth | an briskomai sthn prvth h' sthn teleytaia grammh 
					found = true; //brhka ejodo
					Ystart--; //proxvrav mia 8esh aristera 
				}
				
				else {
					count++;
					Ystart--; //pav aristera
					stack.push(new Point(Xstart, Ystart));
					setVisited(Xstart, Ystart);
				}
			} //look left for available path


			if (Xstart+1<=lines-1 && maze[Xstart+1][Ystart]=='0' && !found) { //an den exv brei lysh & paramenv entos orivn an pav mia 8esh katv (gia grammes) & to stoixeio poy brisketai se ayth th sthlh kai thn epomenh grammh einai 0
				if (Xstart+1==lines-1 || Ystart==columns-1 || Ystart==0) { //an h epomenh grammh einai h teleytaia | an briskomai sthn prvth h' sthn teleytaia sthlh
					found = true; //brhka ejodo
					Xstart++; //proxvrav mia 8esh katv
				}
				
				else {
					count++;
					Xstart++; //pav katv
					stack.push(new Point(Xstart, Ystart));
					setVisited(Xstart, Ystart);
				}
			} //look down for available path


			if (Xstart-1>=0 && maze[Xstart-1][Ystart]=='0' && !found) { //an den exv brei lysh & paramenv entos orivn an pav mia 8esh panv (gia grammes) & to stoixeio poy brisketai se ayth th sthlh kai thn prohgoymenh grammh einai 0
				if (Xstart-1==0 || Ystart==columns-1 || Ystart==0) { //an h prohgoymenh grammh einai h prvth | an briskomai sthn prvth h' sthn teleytaia sthlh
					found = true; //brhka ejodo
					Xstart--; //proxvrav mia 8esh panv
				}
				
				else {
					count++;
					Xstart--; //pav panv
					stack.push(new Point(Xstart, Ystart));
					setVisited(Xstart, Ystart);
				}
			} //look up for available path


			if (first) { //an thn prvth fora poy mphka sto while den eixa kanena mhdeniko gyrv moy tote eimai se adiejodo
				if (count==0) noExit = true;
				first = false;
			}

			if (!first && !found) { //oso den exv brei ejodo kai exv hdh mpei sto parapanv while mia fora
				if (count==0) { //an den yparxoyn mhdenika gyrv moy (dhladh yparxoyn mono '1' kai 'X') kanv to backtracking
					//backtracking
					Xstart = stack.peek().getX(); //h syntetagmenh 'X' ths 8eshs moy einai ayth toy stoixeioy poy brisketai panv panv sthstoiba --> dhladh ths teleytaias kinhshs poy ekana
					Ystart = stack.peek().getY(); //h syntetagmenh 'Y' ths 8eshs moy einai ayth toy stoixeioy poy brisketai panv panv sthstoiba --> dhladh ths teleytaias kinhshs poy ekana
					stack.pop(); //afairv mia kinhsh apo th stoiba gia na pav pisv
					if (stack.isEmpty()) noExit = true; //an den exei meinei allh kinhsh gia na pav pisv se aythn kai den exv brei ejodo, tote moy exoyn teleivsei ta monopatia kai den yparxei ejodos	
				}
			}
			
		} //while (!found && !noExit) 
		
		if (found) System.out.println("\n\nA solution was found at: " + "(" + Xstart + "," + Ystart + ")\n\n");

		else {System.out.println("\n\nNo solution was found...\n\n");}
	}
	


//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//	|  MAIN  |
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		char [] x = args[0].toCharArray(); //pairnv to onoma toy arxeioy apo to path
		int pos = -1;
		int i = x.length-1; //jekinav apo to telos gia na diatrexv to path
		boolean flag = false;

		while (!flag && i>=0) {
			if (Character.compare(x[i],'\\')==0) { //kratav th 8esh poy brhka to prvto backslash apo to telos pros thn arxh *
				pos = i;
				flag = true;
			}
			i--;
		}

		String word = "";
		for (int j=pos+1; j<x.length; j++) { // * pav apo th 8esh poy brhka pio panv kai apo8hkeyv sth metablhth word to onoma toy arxeioy xarakthra xarakthra gia na to dvsv vs orisma sthn ReadFile **
			String other = String.valueOf(x[j]);
			word = word + other;
		} 
		
		ReadFile(word); // ** 
		isReachable(Xstart, Ystart);
	} //main

} //Thiseas