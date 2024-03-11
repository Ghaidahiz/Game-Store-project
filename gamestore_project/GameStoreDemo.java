package gamestore_project;

import java.util.*;

public class GameStoreDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Admin Almaha = new Admin("Almaha", "123");
        Admin Eman = new Admin("Eman", "321");
        Admin Ghaida = new Admin("Ghaida", "213");

        GameStore GEA = new GameStore("GEA", Almaha, Eman, Ghaida);

        System.out.println("GEA GAME STORE");
        int check;

        do {
            System.out.println("ARE YOU A .. \n 1- USER? \n 2-ADMIN?");
            check = sc.nextInt();
            User u1;
            if (check == 1) {

                System.out.println("PLEASE ENTER YOUR NAME :");
                String name = sc.next();
                if (GEA.findUser(name) == null) {
                    System.out.println("WELCOME TO OUR STORE , PLEASE FILL THE NEXT INFORMATION");
                    System.out.println("PLEASE ENTER YOUR WALLET AMOUNT :");
                    double wallet = sc.nextDouble();

                     u1 = new User(name , wallet);
                     GEA.addUser(u1);
                } else if (GEA.findUser(name) != null) {
                     u1 = GEA.findUser(name);
                    System.out.println("WELCOME BACK !");
                }

                System.out.println(" PLEASE SELECT NUMBER OF SERVICE THAT YOU WANT : ");
                System.out.println(
                        "1- BUY A GAME ? \n 2-SEND GIFT TO A FRIEND ? \n 3-UNINSTALL GAME ? \n 4- FIND GAME ? \n 5-SHOW ALL GAMES IN LIBRARY ? \n 6-SHOW GAMES OF GEA STORE ? \n 0-EXIT ?");
                int choice = sc.nextInt();

                while (choice < 0 && choice > 6) {
                    System.out.println("WRONG INPUT , PLEASE TRY AGAIN ?");
                    System.out.println(
                        "1- BUY A GAME ? \n 2-SEND GIFT TO A FRIEND ? \n 3-UNINSTALL GAME ? \n 4- FIND GAME ? \n 5-SHOW ALL GAMES IN LIBRARY ? \n 6-SHOW GAMES OF GEA STORE ? \n 0-EXIT ?");
                    choice = sc.nextInt();
                }

                switch (choice) {
                case 1:
                    System.out.println("ENTER THE NAME OF THE GAME ..");
                    String Gname = sc.nextLine();
                 (GEA.findUser(name)).buyGame(GEA.searchForGame(Gname));
                    break;

                case 2:
                    System.out.println(" ENTER THE NAME OF YOUR FRIEND ACCOUNT AND THE NAME OF THE WANTED GAME");
                    String Fname = sc.nextLine();
                    Gname = sc.nextLine();
                    (GEA.findUser(name)).sendGift(GEA.findUser(Fname), GEA.searchForGame(Gname));

                    break;

                case 3:
                    System.out.println("ENTER THE NAME OF THE GAME YOU WANT TO UNINSTALL..");
                    Gname = sc.nextLine();
                    (GEA.findUser(name)).uninstallGame(Gname);
                    break;

                case 4:
                    System.out.println("ENTER THE NAME OF THE GAME YOU WANT TO FIND IN YOUR LIBRARY ..");
                    Gname = sc.nextLine();
                    System.out.println((GEA.findUser(name)).findGame(Gname));
                    break;

                case 5:
                	System.out.println("these are all games you have in your library");
                   Game [] library= (GEA.findUser(name)).getGameLibrary();
                   for (int i=0; i<(GEA.findUser(name)).getNofg(); i++)
               	   	System.out.println(library[i]);
                    break;
                    
                    
                case 6:
                	System.out.println("CHOOSE WHAT DO YOU WANT TO DISPLAY?");
                	System.out.println("1-ALL GAMES. \n 2-RPG GAMES. \n 3-DETECTIVE GAMES. \n 4-HORROR GAMES. \n 5-STORY RICH GAMES. \n 6-SURVIVAL GAMES. ");
                    int selection = sc.nextInt(); 
                	switch(selection) {
                	case 1:
                		Game[] allGame= GEA.getGameList();
                		System.out.println("this is all games in GEA STORE:\n--------------");
                	    for (int i=0; i<GEA.getNoUsers(); i++)
                	   	System.out.println(allGame[i]);
                	     break;
                	        
                    case 2:	
                    	System.out.println("this is all games of type RPG in GEA STORE:\n--------------");
                    	Game[] RPGGame= GEA.getRPG();
                	    for (int i=0; i<RPGGame.length; i++)
                	   	System.out.println(RPGGame[i]);
                	     break;
                	     
                    case 3:
                    	System.out.println("these are all games of type Detective in GEA STORE:\n--------------");
                    	Game[] DetectiveGame= GEA.getDetective();
                	    for (int i=0; i<DetectiveGame.length; i++)
                	    System.out.println(DetectiveGame[i]);
                	     break;
                	     
                    case 4: 
                    	System.out.println("this is all games of type Horror in GEA STORE:\n--------------");
                    	Game[] HorrorGame= GEA.getHorror();
                	    for (int i=0; i<HorrorGame.length; i++)
                	    System.out.println(HorrorGame[i]);
                	     break;
                	     
                    case 5: 
                    	System.out.println("this is all games of type Story Rich in GEA STORE:\n--------------");
                    	Game[] SRGame= GEA.getStoryRich();
                	    for (int i=0; i<SRGame.length; i++)
                	    System.out.println(SRGame[i]);
                	     break;
                    	
                    case 6:
                    	System.out.println("this is all games of type Survival in GEA STORE:\n--------------");
                    	Game[] SurvivalGame= GEA.getSurvival();
                	    for (int i=0; i<SurvivalGame.length; i++)
                	    System.out.println(SurvivalGame[i]);
                	     break; }
                	break; 	
                	    
                	 	
                	
                case 0:
                    System.exit(0);
                    break;
                }




            } else if (check == 2) {




            } else


                System.out.println("invalid input , try again..");

        } while (check != 1 && check != 2);
    }}




