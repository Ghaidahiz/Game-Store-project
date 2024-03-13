package gamestore_project;

import java.util.*;

public class GameStoreDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Admin Almaha = new Admin("Almaha", "123");
        Admin Eman = new Admin("Eman", "321");
        Admin Ghaida = new Admin("Ghaida", "213");
        GameStore GEA = new GameStore("GEA", Almaha, Eman, Ghaida);
        
        User Afnan = new User("Afnan", 500);
        User Sarah = new User("sarah",250.50);
        User Michael = new User("michael", 20);
        User Abdullah = new User("ABDULLAH", 300);

        GEA.addUser(Abdullah);
        GEA.addUser(Michael);
        GEA.addUser(Sarah);
        GEA.addUser(Afnan);

        Game Sekiro = new StoryRich("Sekiro", "cube game", 229);
        Game Detroit = new StoryRich("Detroit become human", "Quantic Dream", 185);
        Game Ori = new RPG("Ori and the blind forest","XBOX",85);
        Game Persona_5 = new RPG("Persona 5","SEGA",250);
        Game Minecraft = new Survival("Minecraft","Mojang",100);
        Game Dont_Starve = new Survival("Don't Starve","Klei",21.95);
        Game Unsolved_Case = new Detective("Unsolved case","eleven puzzels",13.95);
        Game Ace_attorney = new Detective("Ace attorney","CAPCOM",138);
        Game Silent_hill = new Horror("Silent Hill", "Konami",90.33);
        Game Lethal_company = new Horror("Lethal company", "zeekerss",22.49);


        GEA.addGame(Persona_5);
        GEA.addGame(Minecraft);
        GEA.addGame(Unsolved_Case);
        GEA.addGame(Silent_hill);
        GEA.addGame(Sekiro);
        GEA.addGame(Ori);
        GEA.addGame(Detroit);
        GEA.addGame(Dont_Starve);
        GEA.addGame(Lethal_company);
        GEA.addGame(Ace_attorney);




        


        System.out.println("GEA GAME STORE");
        int check = 0;

        do {
            System.out.println("\n DO YOU WANT TO LOG IN AS A(N) .. \n 1- USER \n 2- ADMIN \n 3- CLOSE THE APP");
            try {
                check = sc.nextInt();
                sc.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("\n PLEASE ENTER A DIGIT");
                sc.next();
                check = 0;
            }
            User u1;
            if (check == 1) {

                System.out.println("PLEASE ENTER YOUR NAME :");
                String name = sc.next();
                if (GEA.findUser(name) == null) {
                    System.out.println("\nWELCOME TO OUR STORE " + name + ", THIS IS YOUR FIRST TIME IN OUR APP :D");
                    double wallet;
                    do {
                        try {
                            System.out.println("PLEASE ENTER YOUR WALLET AMOUNT :");
                            wallet = sc.nextDouble();

                            if (wallet < 0) {
                                System.out.println("\n INVALID INPUT, PLEASE ENTER A POSITIVE AMOUNT ");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("PLEASE ENTER A NUMBER");
                            sc.next();
                            wallet = -1; // Set wallet to -1 to continue loop
                        }
                    } while (wallet < 0);

                    u1 = new User(name, wallet);
                    GEA.addUser(u1);
                } else if (GEA.findUser(name) != null) {
                    u1 = GEA.findUser(name);
                    System.out.println("WELCOME BACK !");
                }
                int choice;
                do {
                    do {

                        try {
                            System.out.println(" \nPLEASE SELECT NUMBER OF SERVICE THAT YOU WANT : ");
                            System.out.println(
                                    " ********************************* \n \n 1- BUY A GAME \n 2-SEND GIFT TO A FRIEND \n 3-UNINSTALL A GAME \n 4- FIND A GAME IN YOUR LIBRARY  \n 5-SHOW ALL GAMES IN LIBRARY \n 6-SHOW GAMES OF GEA STORE \n 7- DISPLAY YOUR PERSONAL INFORMATION \n 0- LOGOUT ");
                            choice = sc.nextInt();
                            sc.nextLine();

                            if (choice < 0 || choice > 7) {
                                System.out.println("INVALID INPUT , PLEASE ENTER A NUMBER BETWEEN 0 AND 6 ");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("PLEASE ENTER A DIGIT");
                            sc.next();
                            choice = -1; // Set choice to -1 to continue loop
                        }
                    } while (choice < 0 || choice > 7);

                    switch (choice) {
                    case 1:
                        System.out.println("ENTER THE NAME OF THE GAME YOU WANT TO PURCHASE ..");
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
                        GEA.findUser(name).findGame(Gname);
                        break;

                    case 5:
                        System.out.println("THESE ARE YOUR LIBRARY'S GAMES: \n ");
                        Game[] library = (GEA.findUser(name)).getGameLibrary();
                        for (int i = 0; i < (GEA.findUser(name)).getNumberOfGames(); i++)
                            System.out.println(library[i]);
                        break;

                    case 6:
                        GEA.displayGames();
                        break;

                        case 7:
                    
                        System.out.println( GEA.findUser(name));
                        break;

                    case 0:

                        break;
                    }
                } while (choice != 0);

            } else if (check == 2) {
                if(GEA.adminExists()){
               
                int choice = 0;
                do {
                    System.out.println(" PLEASE SELECT THE SERVICE THAT YOU WANT ");
                    do {

                        try {
                            System.out.println(
                                    " ********************************* \n \n 1- ADD A NEW GAME TO THE STORE  \n 2- REMOVE A GAME FROM THE STORE  \n 3- SEARCH FOR A GAME IN THE STORE \n 4- DISPLAY GAMES IN THE STORE \n 5- ADD A NEW USER \n 6- REMOVE A USER \n 7- DISPLAY ALL USERS  \n 8-SEARCH FOR CERTAIN USER \n 9- LOGOUT");
                            choice = sc.nextInt();
                            sc.nextLine();

                            if (choice < 1 || choice > 9) {
                                System.out.println("INVALID INPUT , PLEASE ENTER A NUMBER BETWEEN 1 AND 7 ");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("PLEASE ENTER A DIGIT");
                            sc.next();
                            choice = -1; // Set choice to -1 to continue loop
                        }
                    } while (choice < 1 || choice > 9);

                    switch (choice) {
                    case 1:
                        int GGenre = 0;
                        System.out.println("ENTER THE GAME'S NAME");
                        String Gname = sc.nextLine();
                        if(GEA.gameExists(Gname)==true){
                            System.out.println("\n the game already exists");
                            break;
                        }
                        System.out.println("ENTER THE GAME'S PUBLISHER");
                        String Gpub = sc.nextLine();
                        System.out.println("ENTER THE GAME'S PRICE");
                        double Gprice = sc.nextDouble();
                        sc.nextLine();

                        do {
                            try {
                                System.out.println("ENTER THE GAME'S GENRE");
                                System.out.println(
                                        " 1- Detective  \n 2- Horror  \n 3- RPG  \n 4- Story-rich  \n 5- Survival ");
                                GGenre = sc.nextInt();
                                sc.nextLine();

                                if (GGenre < 1 || GGenre > 5) {
                                    System.out.println("INVALID INPUT , PLEASE ENTER A NUMBER BETWEEN 0 AND 5 ");
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("PLEASE ENTER A DIGIT");
                                sc.next();
                                GGenre = -1; // Set GGenre to -1 to continue loop
                            }
                        } while (GGenre < 1 || GGenre > 5);

                        switch (GGenre) {
                        case 1:
                            Game game = new Detective(Gname, Gpub, Gprice);
                            if(GEA.addGame(game)==true){
                                System.out.println("the Game was added successfully :)");
                            }
                            break;
                        case 2:
                            game = new Horror(Gname, Gpub, Gprice);
                            if(GEA.addGame(game)==true){
                                System.out.println("the Game was added successfully :)");
                            }                            
                            break;
                        case 3:
                            game = new RPG(Gname, Gpub, Gprice);
                            if(GEA.addGame(game)==true){
                                System.out.println("the Game was added successfully :)");
                            }                            
                            break;
                        case 4:
                            game = new StoryRich(Gname, Gpub, Gprice);
                            if(GEA.addGame(game)==true){
                                System.out.println("the Game was added successfully :)");
                            }                            
                            break;
                        case 5:
                            game = new Survival(Gname, Gpub, Gprice);
                            if(GEA.addGame(game)==true){
                                System.out.println("the Game was added successfully :)");
                            }                            
                            break;                        }
                        break;
                    case 2:
                        System.out.println("ENTER THE GAME'S NAME");
                        Gname = sc.nextLine();
                        GEA.removeGame(Gname);

                        break;
                    case 3:
                        System.out.println("ENTER THE GAME'S NAME \n ");
                        Gname = sc.nextLine();
                        System.out.println(GEA.searchForGame(Gname));
                        break;
                    case 4:
                        GEA.displayGames();
                        break;
                    case 5:
                    System.out.println("Enter a username for the user you want to add");
                    String Uname = sc.nextLine();
                    if(GEA.userExists(Uname)){
                    break;}
                    System.out.println("Enter a wallet amount");
                    double Uwallet = sc.nextDouble();
                        sc.nextLine();
                    User u2 = new User(Uname, Uwallet);
                    if(GEA.addUser(u2)==true){
                        System.out.println("the User was added successfully :)");
                    }                            
                    break;
                    case 6:
                    System.out.println("Enter the username of the user you want to remove");
                    String Rname = sc.nextLine();
                    GEA.removeUser(Rname);
                    break;
                    case 7 :
                    GEA.displayAllUsers();
                    break;
                    case 8:{
                    	System.out.println("ENTER USERNAME OF THE USER YOU'R LOOKING FOR");
                    	String username=sc.nextLine();
                        if(GEA.userExists(username))
                    	System.out.println(GEA.findUser(username));
                        else 
                        System.out.println(username+"is not found in this store");
                    	break;}
                    case 9:
                        break;
                    }
                } while (choice != 9);
             }
            } else if (check != 3)

                System.out.println("invalid input, try again..");

        } while (check != 3);

    }
}
/////*DEBUG REMOVE GAME (null exception)(DONE) 
//& SEARCH H8T ADMIN (DONE?)
/// print statement after a successful purchase (DONE)
///print user info (DONE)
///tnsee8 tostring(DONE IG)
//*buy game check if exist (DOOONE!!)
//find game change exist to found (DONE )
//price formatting printf (DOONEE!!!)
